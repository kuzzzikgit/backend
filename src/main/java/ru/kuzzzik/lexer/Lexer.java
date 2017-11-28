package ru.kuzzzik.lexer;

import ru.kuzzzik.io.reader.IReader;

public class Lexer implements ILexer{
    public Lexer(IReader inFile) {
    }

    @Override
    public boolean hasMoreTokens() {
        return false;
    }

    @Override
    public String readToken() {
        return null;
    }
    
    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLexeme() {
        return null;
    }
//    public IToken readToken() {
//        while (readChar.hasMoreChars()) {
//            char c = readChar.readChar();
//            // append character to current lexeme
//            // OR
//            return newToken();
//        }
//        return newToken();
//    }
    
}