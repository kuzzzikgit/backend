package ru.kuzzzik.lexer;

import ru.kuzzzik.io.reader.IReader;
import ru.kuzzzik.io.reader.ReaderException;

import java.io.IOException;

public class Lexer implements ILexer {
//
//    static String C_OPEN_BRACKETS_BEF = "^[ ][{]";
//    static String C_BRACKETS_AFT = "[{|}]^\n";
//    static String C_CLOSE_BRACKETS_BEF = "^\n[}]";
//
//    public static enum Type {
//        SEMICOLON(";"), CPACE("    "), NEWLINE("\n");
//
//        public final String pattern;
//
//        private Type(String pattern) {
//            this.pattern = pattern;
//        }
//    }
//    public static class Token {
//        public final Type tok;
//        public final String cha;
//        public Token(Type tok, String cha) {
//            this.tok = tok;
//            this.cha = cha;
//        }
//        public String toString() {
//            if(tok == Type.) {
//                return ;
//            }
//            return tok.toString();
//        }
//    }

    private IReader reader;

    public Lexer(IReader reader) {
        this.reader = reader;
    }

    @Override
    public boolean hasMoreTokens() throws IOException {
        try {
            return reader.hasChars();
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public IToken readToken() throws ReaderException {
        String nameLex = null;
        char c = 0;
        while (reader.hasChars()) {
            c = reader.readChar();
            switch (c) {
                case '{': nameLex = "openCurlBracket"; break;
                case '}': nameLex = "closeCurlBracket"; break;
                case ' ': nameLex = "space"; break;
                case '\n': nameLex = "newLine"; break;
                case ';': nameLex = "semicilone"; break;
                default: nameLex = "noFormat";
            }
            if (!nameLex.equals(null)) {
                break;
            }
        }
        return new Token(nameLex, Character.toString(c));
    }
}