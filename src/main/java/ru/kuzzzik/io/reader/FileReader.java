package ru.kuzzzik.io.reader;

import ru.kuzzzik.io.closeable.ICloseable;
import ru.kuzzzik.io.closeable.CloseException;
import ru.kuzzzik.lexer.IToken;

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
        return (indexF != -1);
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            indexF = fReaderCode.read();
            return (char) indexF;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
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

