package ru.kuzzzik.io.reader;

public interface IReader {
    boolean hasChars() throws ReaderException;
    char readChar() throws ReaderException;
}
