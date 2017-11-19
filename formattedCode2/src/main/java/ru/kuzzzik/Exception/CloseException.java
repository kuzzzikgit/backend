package ru.kuzzzik.Exception;

import java.io.IOException;

public class CloseException extends Exception {
    private IOException e;
    public CloseException(IOException e) {
        this.e = e;
    }
}
