package ru.kuzzzik.io.reader;

public class StringReader implements IReader {
    private String readString;
    private int index = -1;

    public StringReader(String readString) throws ReaderException {
      try {
          this.readString = readString;
      }catch (Exception e) {
          throw new ReaderException("Error reading string", e);
      }
    }

    @Override
    public boolean hasChars() throws ReaderException {
        boolean charsS;
        try {
            charsS = index < readString.length() -1;
        } catch (Exception e) {
            throw new ReaderException("Some reading string error", e);
        }
        return charsS;
    }

    @Override
    public char readChar() throws ReaderException {
        try {
            index++;
            return readString.charAt(index);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ReaderException("Attempting to read outside of the string", e);
        }
    }
}
