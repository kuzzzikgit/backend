package ru.kuzzzik.formatter;

import ru.kuzzzik.io.reader.IReader;
import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.lexer.ILexer;
import ru.kuzzzik.lexer.IToken;

public interface IFormatter extends IToken, ILexer {
    void format(IReader inFile, IWriter outFile) throws FormatterException;
}
