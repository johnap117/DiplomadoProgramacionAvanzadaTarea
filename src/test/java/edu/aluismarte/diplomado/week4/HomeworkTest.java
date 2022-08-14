package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.Operation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.StringWriter;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Escribir los test del código
 *
 * @author aluis on 5/1/2022.
 */
public class HomeworkTest {

    private final Homework homework = new Homework();

    private static final File file = new File("sumTest.txt");

    @AfterAll
    static void afterAllTest() {
        assertTrue(file.delete());
    }

    /**@Test
    void operationNullTest() {
        assertThrows(Homework.operationNullException.class, () ->
                homework.calculateAndSave(null, null, null, null));
    }**/

    @Test
    void fileNullTest() {
        assertThrows(NullPointerException.class, () ->
                homework.calculateAndSave(null, null, null, (File) null));
    }

    @Test
    void writeInFileTest() throws Exception {
        homework.calculateAndSave(Operation.SUM, 2.0, 2.0, file);
        assertTrue(file.exists());
        byte[] bytes = Files.readAllBytes(file.toPath());
        String data = new String(bytes);
        assertEquals("Result is: 4.0", data);
    }

    @Test
    void sumOperationTest() throws Exception {
        StringWriter stringWriter = new StringWriter();
        homework.calculateAndSave(Operation.SUM, 2.0, 2.0, file);
        assertEquals("Result is: 4.0", stringWriter.toString());
    }

    @Test
    void multiOperationTest() throws Exception {
        StringWriter stringWriter = new StringWriter();
        homework.calculateAndSave(Operation.MULT, 4.0, 4.0, file);
        assertEquals("Result is: 16.0", stringWriter.toString());
    }

    @Test
    void divOperationTest() throws Exception {
        StringWriter stringWriter = new StringWriter();
        homework.calculateAndSave(Operation.DIV, 4.0, 4.0, file);
        assertEquals("Result is: 1.0", stringWriter.toString());
    }
}
