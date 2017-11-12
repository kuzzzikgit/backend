package ru.kuzzzik.writer;

import java.util.*;

public class FileWriter implements IWriter{
    private ArrayList listArray;
    private int indexF;
    private String writerCode;

    public FileWriter(String writerCode, ArrayList listArray) {
        this.listArray = listArray;
        this.writerCode = writerCode;
    }


    @Override
    public boolean hasNextW() {
        return indexF < listArray.size();
    }

    @Override
    public char readW() {
        char fw = (char) listArray.get(indexF);
        indexF++;
        return fw;
    }
}
