package ru.kuzzzik.lexer;

public interface ILexer extends IToken {
    boolean hasMoreTokens();
    String readToken();
}
