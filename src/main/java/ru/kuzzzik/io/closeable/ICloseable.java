package ru.kuzzzik.io.closeable;

public interface ICloseable extends AutoCloseable {
    void close() throws CloseException;
}
