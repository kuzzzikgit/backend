package ru.kuzzzik.reader;

public interface IReader {
    boolean hasNext() throws Exception;
    char reading() throws Exception;
}
