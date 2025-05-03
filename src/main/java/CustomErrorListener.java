

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.List;

class MyErrorListener extends BaseErrorListener {
    private final List<String> errores = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine, String msg, RecognitionException e) {
        String mensajeDetallado = String.format("Error en línea %d, posición %d: %s",
                line, charPositionInLine, mensajePersonalizado(msg));
        errores.add(mensajeDetallado);
    }

    private String mensajePersonalizado(String msg) {
        if (msg.contains("mismatched input")) return "Símbolo inesperado o fuera de lugar.";
        if (msg.contains("no viable alternative")) return "Sintaxis incorrecta o incompleta.";
        if (msg.contains("extraneous input")) return "Hay un símbolo demás que no se esperaba.";
        return msg;
    }

    public boolean hayErrores() {
        return !errores.isEmpty();
    }

    public String getErrores() {
        return String.join("\n", errores);
    }
}
