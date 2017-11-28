package ru.kuzzzik.io.writer;

import ru.kuzzzik.io.closeable.ICloseable;
import ru.kuzzzik.io.closeable.CloseException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWriter implements IWriter, ICloseable {

    private OutputStreamWriter fWriterCode;


    public FileWriter(String outputFilePath) throws WriterException {
        try {
            fWriterCode = new OutputStreamWriter(new FileOutputStream(new File(outputFilePath)) , "UTF-8");
        } catch (Exception e) {
            throw new WriterException("Opening file error", e);
        }
    }

    @Override
    public void writeChar(char c) throws WriterException {
        try {
            fWriterCode.write(c);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
//            fWriterCode.flush();
//    }
//            for(int indexF = 0; indexF < listArray.size(); indexF++)
//        {
//            fWriterCode.write((char) listArray.get(indexF));
//            fWriterCode.flush();
//        }
    }

    @Override
    public void close() throws CloseException {
        try {
            fWriterCode.close();
        } catch (IOException e) {
            throw new CloseException("Closing error", e);
        }
    }
}
