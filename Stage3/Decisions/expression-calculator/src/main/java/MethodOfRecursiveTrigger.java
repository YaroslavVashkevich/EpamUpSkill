import java.util.ArrayList;
import java.util.List;

public class MethodOfRecursiveTrigger {


    enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MULTIPLY, OP_DIVISOR,
        NUMBER,
        EOF
    }

    public static class Lexeme {
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

        @Override
        public String toString() {
            return "Lexeme =" + type + ", value=" + value + '\'';
        }
    }

    public static class LexemeBuffer {
        private int position;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(position++);
        }

        public void back() {
            position--;
        }

        public int getPosition() {
            return position;
        }
    }

    public static List<Lexeme> lexemesAnalyze(String expression) {
        List<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expression.length()) {
            char c = expression.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    break;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    break;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    break;

                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    break;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MULTIPLY, c));
                    pos++;
                    break;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIVISOR, c));
                    pos++;
                    break;
                default:
                    if (Character.isDigit(c)) {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expression.length()) {
                                break;
                            }
                            c = expression.charAt(pos);
                        } while (Character.isDigit(c));
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new IllegalArgumentException();
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }


    public static int expression(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusAndMinus(lexemes);
        }
    }

    public static int plusAndMinus(LexemeBuffer lexemes) {
        int value = multiplyAndDivision(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multiplyAndDivision(lexemes);
                    break;
                case OP_MINUS:
                    value -= multiplyAndDivision(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    public static int multiplyAndDivision(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MULTIPLY:
                    value *= factor(lexemes);
                    break;
                case OP_DIVISOR:
                    value /= factor(lexemes);
                    break;
                default:
                    lexemes.back();
                    return value;
            }
        }
    }

    public static int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                int value = expression(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new IllegalArgumentException("Unexpected token " + lexeme.value + " at " + lexemes.getPosition());
                }
                return value;
            default:
                throw new IllegalArgumentException("Unexpected token " + lexeme.value + " at " + lexemes.getPosition());
        }
    }

}
