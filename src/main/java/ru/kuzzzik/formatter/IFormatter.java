package ru.kuzzzik.formatter;

import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.lexer.ILexer;

public interface IFormatter {
    void format(ILexer inFile, IWriter outFile) throws FormatterException;
}
