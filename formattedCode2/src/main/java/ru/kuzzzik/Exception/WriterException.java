package ru.kuzzzik.Exception;

import java.io.IOException;

public class WriterException extends Exception {
    private IOException e;
    public WriterException(String some_reading_error, IOException e) {
        this.e = e;
    }
}

