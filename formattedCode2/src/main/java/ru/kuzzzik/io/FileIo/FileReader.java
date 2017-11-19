package ru.kuzzzik.io.FileIo;

import ru.kuzzzik.Closeable.ICloseable;
import ru.kuzzzik.Exception.CloseException;
import ru.kuzzzik.io.IReader;
import ru.kuzzzik.Exception.ReaderException;
import java.io.*;

public class FileReader implements IReader, ICloseable {
    private InputStreamReader fReaderCode;
    private int indexF = 0;


    public FileReader(String inputFilePath) throws ReaderException {
        try {
              fReaderCode = new InputStreamReader(new FileInputStream(new File(inputFilePath)) , "UTF-8");
        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found", e);
        } catch (Exception e) {
            throw new ReaderException("Some reading file error", (IOException) e);
        }
    }

    @Override
    public boolean hasChars() throws ReaderException {
        try {
            indexF = fReaderCode.read();
        } catch (IOException e) {
            throw new ReaderException("Some reading file error", e);
        }
        return (indexF != -1);
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
            throw new CloseException(e);
        }
    }
}

