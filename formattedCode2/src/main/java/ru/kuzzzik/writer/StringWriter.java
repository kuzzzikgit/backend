package ru.kuzzzik.writer;

import java.util.ArrayList;

public class StringWriter implements IWriter {
    private ArrayList<Character> listArray;
    private int indexW;



    public StringWriter(ArrayList<Character> listArray) {
        this.listArray = listArray;
    }


    @Override
    public boolean hasNextW() {
        return indexW < listArray.size();
    }

    @Override
    public char readW() {
        char sw = listArray.get(indexW);
        indexW++;
        return sw;
    }
}
