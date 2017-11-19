package ru.kuzzzik.io.StringIo;

import ru.kuzzzik.Exception.WriterException;
import ru.kuzzzik.io.IWriter;

import java.io.IOException;
import java.util.ArrayList;

public class StringWriter implements IWriter {
    private ArrayList listArray;

    public StringWriter(ArrayList<Character> listArray) throws WriterException {
        this.listArray = listArray;
    }

    @Override
    public void writeChar() throws WriterException {
        try {
        for (Object aListArray : listArray) {
            System.out.print(aListArray);
        }
        } catch (Exception e) {
            throw new WriterException("Error write in console", (IOException) e);
        }
//        for(int indexF = 0; indexF < listArray.size(); indexF++)
//        {
//            StringWriter.write((char) listArray.get(indexF));
//            fWriterCode.flush();
//        }
    }
}
