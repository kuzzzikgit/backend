package ru.kuzzzik.io.FileIo;

import ru.kuzzzik.Closeable.ICloseable;
import ru.kuzzzik.Exception.CloseException;
import ru.kuzzzik.Exception.WriterException;
import ru.kuzzzik.io.IWriter;

import java.io.*;
import java.util.ArrayList;

public class FileWriter implements IWriter, ICloseable {

    private OutputStreamWriter fWriterCode;
    private ArrayList listArray;


    public FileWriter(String outputFilePath) throws WriterException {
        try {
            fWriterCode = new OutputStreamWriter(new FileOutputStream(new File(outputFilePath)) , "UTF-8");
        } catch (Exception e) {
            throw new WriterException("Some input file error", (IOException) e);
        }
    }

    public FileWriter(IWriter[] out, ArrayList<Character> listArray) throws WriterException {
        try {
//            this.fWriterCode =  out;
            this.listArray = listArray;
        } catch (Exception e) {
            throw new WriterException("Error write", (IOException) e);
        }
    }


    @Override
    public void writeChar() throws WriterException, IOException {

        for (Object aListArray : listArray) {

            fWriterCode.write((char) aListArray);
            fWriterCode.flush();
        }
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
            throw new CloseException(e);
        }
    }
}
