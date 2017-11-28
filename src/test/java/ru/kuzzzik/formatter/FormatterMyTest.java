package ru.kuzzzik.formatter;

import org.junit.Before;
import org.junit.Test;
import ru.kuzzzik.io.reader.FileReader;
import ru.kuzzzik.io.reader.IReader;
import ru.kuzzzik.io.reader.ReaderException;
import ru.kuzzzik.io.reader.StringReader;
import ru.kuzzzik.io.writer.IWriter;
import ru.kuzzzik.io.writer.StringWriter;
import ru.kuzzzik.io.writer.WriterException;

import static junit.framework.TestCase.assertEquals;

public class FormatterMyTest {
    private FormatterMy formatter;

    @Before
    public void setUp() {
        formatter = new FormatterMy();
    }

    @Test
    public void testFormatS1() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("a{b}c");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("a {\nb\n}\nc", out.toString());
    }

    @Test
    public void testFormatS2() throws WriterException, ReaderException, FormatterException {
        IReader in = new StringReader("a( b) c");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("a (b) c", out.toString());
    }
    @Test
    public void testFormatF1() throws WriterException, ReaderException, FormatterException {
        IReader in = new FileReader("/home/kuzzzik/my_git/repo/backend/src/test/inputtest.java");
        IWriter out = new StringWriter();
        formatter.format(in, out);
        assertEquals("a {\nbc (d) ef\n}\n}\n", out.toString());
    }
}