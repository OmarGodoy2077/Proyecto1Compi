import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class MainLexer {
    private static JFrame ventanaTokens = null;
    private static JFrame ventanaArbol = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            crearVentanaPrincipal();
        });
    }

    private static void crearVentanaPrincipal() {
        JFrame frame = new JFrame("MiniLang Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenido a MiniLang Analyzer", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton botonAnalizarArchivo = new JButton("Analizar Archivo");
        botonAnalizarArchivo.addActionListener(e -> analizarArchivo());
        JButton botonAnalizarExpresion = new JButton("Analizar Expresión");
        botonAnalizarExpresion.addActionListener(e -> analizarExpresion());
        JButton botonSalir = new JButton("Salir");
        botonSalir.addActionListener(e -> System.exit(0));

        panel.add(botonAnalizarArchivo);
        panel.add(botonAnalizarExpresion);
        panel.add(botonSalir);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void analizarExpresion() {
        try {
            String expresion = JOptionPane.showInputDialog(null, "Ingrese la expresión a analizar:");
            if (expresion == null || expresion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ingresó ninguna expresión.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CharStream input = CharStreams.fromString(expresion);
            MiniLangLexer lexer = new MiniLangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniLangParser parser = new MiniLangParser(tokens);

            MyErrorListener errorListener = new MyErrorListener();
            parser.addErrorListener(errorListener);


            ParseTree tree = parser.program();


            cerrarVentanas();


            mostrarTokens(tokens);


            if (errorListener.hayErrores()) {
                String errores = errorListener.getErrores();
                JOptionPane.showMessageDialog(null, errores, "Errores de Sintaxis", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Análisis completado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }


            mostrarArbol(tree, parser);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error durante el análisis: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void analizarArchivo() {
        try {
            String ruta = seleccionarArchivo();

            if (ruta == null || !Files.exists(Paths.get(ruta))) {
                JOptionPane.showMessageDialog(null, "El archivo no existe o no se seleccionó correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            CharStream input = CharStreams.fromFileName(ruta);
            MiniLangLexer lexer = new MiniLangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniLangParser parser = new MiniLangParser(tokens);


            MyErrorListener errorListener = new MyErrorListener();
            parser.addErrorListener(errorListener);


            ParseTree tree = parser.program();

            cerrarVentanas();


            mostrarTokens(tokens);


            if (errorListener.hayErrores()) {
                String errores = errorListener.getErrores();
                JOptionPane.showMessageDialog(null, errores, "Errores de Sintaxis", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Análisis completado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }


            mostrarArbol(tree, parser);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error durante el análisis: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cerrarVentanas() {
        if (ventanaTokens != null && ventanaTokens.isVisible()) {
            ventanaTokens.dispose();  // Cerrar ventana de tokens
        }
        if (ventanaArbol != null && ventanaArbol.isVisible()) {
            ventanaArbol.dispose();  // Cerrar ventana del árbol
        }
    }


    private static String seleccionarArchivo() {
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo a analizar");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos fuente", "txt", "java"));

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            return archivoSeleccionado.getAbsolutePath();
        }
        return null;
    }


    private static void mostrarTokens(CommonTokenStream tokens) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tokens Reconocidos");
            JTextArea textArea = new JTextArea(20, 50);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            tokens.fill();
            StringBuilder tokenInfo = new StringBuilder();
            for (Token token : tokens.getTokens()) {
                String tipo = MiniLangLexer.VOCABULARY.getSymbolicName(token.getType());
                tokenInfo.append(String.format("[%s] '%s' en línea %d\n", tipo, token.getText(), token.getLine()));
            }
            textArea.setText(tokenInfo.toString());

            frame.add(scrollPane);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }


    private static void mostrarArbol(ParseTree tree, MiniLangParser parser) {
        SwingUtilities.invokeLater(() -> {
            Trees.inspect(tree, parser);
        });
    }


    static class MyErrorListener extends BaseErrorListener {
        private final List<String> errores = new ArrayList<>();


        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errores.add(String.format("Error en línea %d:%d: %s", line, charPositionInLine, msg));
        }

        public boolean hayErrores() {
            return !errores.isEmpty();
        }

        public String getErrores() {
            return String.join("\n", errores);
        }
    }

}

