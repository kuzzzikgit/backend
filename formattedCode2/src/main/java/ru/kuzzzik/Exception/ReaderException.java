package ru.kuzzzik.Exception;

import java.io.IOException;

public class ReaderException extends Exception {
    private IOException e;
    public ReaderException(String some_writing_error, IOException e) {
        this.e = e;
    }
}

