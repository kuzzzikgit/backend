package ru.kuzzzik.formatter;

import org.junit.Before;
import org.junit.Test;
import ru.kuzzzik.io.reader.IReader;
import ru.kuzzzik.io.reader.StringReader;
import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.io.writer.StringWriter;
import ru.kuzzzik.lexer.ILexer;
import ru.kuzzzik.lexer.Lexer;

import static junit.framework.TestCase.assertEquals;

public class FormatterMyTest {
    private FormatterMy formatter;


    @Before
    public void setUp() {
        formatter = new FormatterMy();
    }

    @Test
    public void testFormatS1() throws Exception {
        IReader in = new StringReader("a{b");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals("a {\nb", out.toString());
    }

    @Test
    public void testFormatS2() throws Exception {
        IReader in = new StringReader("a}b");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals("a\n}\nb", out.toString());
    }

    @Test
    public void testFormatS3() throws Exception {
        IReader in = new StringReader("a {b");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals("a {\nb", out.toString());
    }

    @Test
    public void testFormatS4() throws Exception {
        IReader in = new StringReader("a{\nb");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        formatter.format(lexer, out);
        assertEquals("a {\nb", out.toString());
    }
}