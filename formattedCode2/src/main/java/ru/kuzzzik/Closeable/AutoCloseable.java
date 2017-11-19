package ru.kuzzzik.Closeable;

import ru.kuzzzik.Exception.CloseException;

public interface AutoCloseable {
    void close() throws Exception, CloseException;
}
