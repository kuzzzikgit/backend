package ru.kuzzzik.io.reader;

import ru.kuzzzik.io.closeable.ICloseable;
import ru.kuzzzik.io.closeable.CloseException;

import java.io.*;

public class FileReader implements IReader, ICloseable {
    private InputStreamReader fReaderCode;
    private int indexF = 0;


    public FileReader(String inputFilePath) throws ReaderException {
        try {
              fReaderCode = new InputStreamReader(new FileInputStream(new File(inputFilePath)) , "UTF-8");
        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found", e);
        } catch (UnsupportedEncodingException e) {
            throw new ReaderException("Unsupported encoding", e);
        }
    }

    @Override
    public boolean hasChars() throws ReaderException {
        try {
            indexF = fReaderCode.read();
            return (indexF != -1);
        } catch (IOException e) {
            throw new ReaderException("Attempting to read outside of the input stream", e);
        }
    }

    @Override
    public char readChar() throws ReaderException {
         return (char) indexF;
    }

    @Override
    public void close() throws CloseException {
        try {
            fReaderCode.close();
        } catch (IOException e) {
            throw new CloseException("Closing stream error", e);
        }
    }
}

