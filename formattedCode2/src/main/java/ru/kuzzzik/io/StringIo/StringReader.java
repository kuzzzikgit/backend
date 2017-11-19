package ru.kuzzzik.io.StringIo;

import ru.kuzzzik.Exception.ReaderException;
import ru.kuzzzik.io.IReader;

import java.io.IOException;

public class StringReader implements IReader {
    private String readString;
    private int index = 0;

    public StringReader(String readString) throws ReaderException {
  try {
      this.readString = readString;
  }catch (Exception e) {
      throw new ReaderException("Error reading string", (IOException) e);
  }
    }

    @Override
    public boolean hasChars() throws ReaderException {
        boolean charsS;
        try {
            charsS = index < readString.length();
        } catch (Exception e) {
            throw new ReaderException("Some reading string error", (IOException) e);
        }
        return charsS;
    }

    @Override
    public char readChar() throws ReaderException {
        char sr = readString.charAt(index);
        index++;
        return sr;
    }

}
