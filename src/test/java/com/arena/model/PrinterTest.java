package com.arena.model;

import com.arena.model.common.Printer;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrinterTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void test_output_should_equals_content_which_i_build(){
        String buildStr = "It's the content which i want to print";
        Printer printer = new Printer();

        printer.printToConsol(buildStr);

        assertThat(outContent.toString(),is("It's the content which i want to print\n"));
    }
}
