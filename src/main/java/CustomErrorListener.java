

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        System.err.println("Error en línea " + line + ":" + charPositionInLine + " - " + msg);
    }
}
