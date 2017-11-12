package ru.kuzzzik.reader;

public class FileReader implements IReader {
    private String readFile;
    private int indexF = 0;

    public FileReader(String readFile) {
        this.readFile = readFile;
    }

    @Override
    public boolean hasNext() {
        return indexF < readFile.length();
    }

    @Override
    public char reading() {
        char sr = (char) indexF;
        indexF++;
        return sr;
    }

}
