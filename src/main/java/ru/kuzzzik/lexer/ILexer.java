package ru.kuzzzik.lexer;

import ru.kuzzzik.io.reader.ReaderException;

import java.io.IOException;

public interface ILexer {
    boolean hasMoreTokens() throws IOException;
    IToken readToken() throws ReaderException;
}
