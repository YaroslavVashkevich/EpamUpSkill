package calc.expression;

import java.util.ArrayList;
import java.util.List;


public class LexemeAnalyzer {
    public static int resolve(String expression) {
        List<Lexeme> lexemes = lexemeAnalyze(expression);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        return expr(lexemeBuffer);
    }

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET, OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER, EOF
    }

    public static class Lexeme {
        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }

        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character value) {
            this.type = type;
            this.value = value.toString();
        }
    }

    public static class LexemeBuffer {
        private int pos;
        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    private static List<Lexeme> lexemeAnalyze(String expText) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            if (c == '(') {
                lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                pos++;
            } else if (c == ')') {
                lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                pos++;
            } else if (c == '+') {
                lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                pos++;
            } else if (c == '-' && pos != 0) {
                lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                pos++;
            } else if (c == '*') {
                lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                pos++;
            } else if (c == '/') {
                lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                pos++;
            } else {
                if ((c <= '9' && c >= '0') || (c == '-')) {
                    StringBuilder stringBuilder = new StringBuilder();
                    do {
                        stringBuilder.append(c);
                        pos++;
                        if (pos >= expText.length()) {
                            break;
                        }
                        c = expText.charAt(pos);
                    } while (c <= '9' && c >= '0');
                    lexemes.add(new Lexeme(LexemeType.NUMBER, stringBuilder.toString()));
                } else {
                    if (c != ' ') {
                        throw new RuntimeException("Unexpected char: " + c);
                    }
                    pos++;
                }
            }


        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    private static int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusMinus(lexemes);
        }
    }

    private static int plusMinus(LexemeBuffer lexemes) {
        int value = multDiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multDiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multDiv(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    private static int multDiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    private static int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Integer.parseInt(lexeme.value);

            case LEFT_BRACKET:
                int value = expr(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value + " at position: " + lexemes.getPos());
        }
    }
}


