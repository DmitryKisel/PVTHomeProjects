package by.itacademy.Lesson12.Test;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.rmi.server.ExportException;

public class TestPhoneNumber extends Assert{

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void before(){

    }

    @After
    public void after(){

    }

    @Test
    public void testPhoneNumber1(){
        boolean result = Main.checkPhoneNumber("+375(29)6852952");
        assertTrue(result);
    }

    @Test
    public void testPhoneNumber2(){
        boolean result = Main.checkPhoneNumber("+375(33)685-29-52");
        assertTrue(result);
    }

    @Test
    public void testPhoneNumber3(){
        boolean result = Main.checkPhoneNumber("+375(55)6852952");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumber4(){
        boolean result = Main.checkPhoneNumber("380(29)685-29-52");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumber5(){
        boolean result = Main.checkPhoneNumber("375(44)68529552");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumber6(){
        expectedException.expect(NullPointerException.class);
        Main.checkPhoneNumber(null);

    }
}