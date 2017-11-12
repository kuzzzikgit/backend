package ru.kuzzzik.reader;

public class StringReader implements IReader {
    private String readString;
    private int index = 0;

    public StringReader(String readString){
        this.readString = readString;
    }

    @Override
    public boolean hasNext() {
        return index < readString.length();
    }

    @Override
    public char reading() {
        char sr = readString.charAt(index);
        index++;
        return sr;
    }
}
