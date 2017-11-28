package ru.kuzzzik.io.writer;

public class StringWriter implements IWriter {

    private StringBuilder stringW;

    public StringWriter() {

        stringW = new StringBuilder();
    }

    public final String toString() {

        return stringW.toString();
    }

    @Override
    public void writeChar(char c) throws WriterException {
        try {
            stringW.append(c);
        } catch (Exception e) {
            throw new WriterException("Error write string", e);
        }
    }
}