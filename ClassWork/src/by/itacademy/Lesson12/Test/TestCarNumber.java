package by.itacademy.Lesson12.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCarNumber extends Assert{

    @Before
    public void before(){

    }

    @After
    public void after(){

    }

   @Test
    public void testCarNumber1(){
        boolean result = Main.checkCarNumber("2050 MP-7");
        assertTrue(result);
    }

    @Test
    public void testCarNumber2(){
        boolean result = Main.checkCarNumber("2050 AC-1");
        assertTrue(result);
    }

    @Test
    public void testCarNumber3(){
        boolean result = Main.checkCarNumber("2050 AC-9");
        assertFalse(result);
    }

    @Test
    public void testCarNumber4(){
        boolean result = Main.checkCarNumber("20505 AC-1");
        assertFalse(result);
    }

    @Test
    public void testCarNumber5(){
        boolean result = Main.checkCarNumber("2050 A3-1");
        assertFalse(result);
    }
}
