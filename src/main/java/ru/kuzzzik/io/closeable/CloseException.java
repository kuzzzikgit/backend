package ru.kuzzzik.io.closeable;

public class CloseException extends Exception {
    public CloseException(Exception e) {
        super(e);
    }
    public CloseException(String message, Exception e) {
        super(message, e);
    }
}
