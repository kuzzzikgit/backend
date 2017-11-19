package ru.kuzzzik.io;

public interface IReader {
    boolean hasChars() throws Exception;
    char readChar() throws Exception;
}
