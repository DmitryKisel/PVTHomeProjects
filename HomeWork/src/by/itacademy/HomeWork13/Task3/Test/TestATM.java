package by.itacademy.HomeWork13.Task3.Test;

import by.itacademy.HomeWork6.Task1.ATMAlfa;
import org.junit.Assert;
import org.junit.Test;

public class TestATM extends Assert{
    ATMAlfa atm =  new ATMAlfa(100, 100, 100);



    @Test
    public void testCheckSum1() {
        boolean result = atm.chekSum(110,atm);
        assertTrue(result);
    }

    @Test
    public void testCheckSum2() {
        boolean result = atm.chekSum(1101, atm);
        assertFalse(result);
    }

    @Test
    public void testCheckSum3() {
        boolean result = atm.chekSum(30, atm);
        assertFalse(result);
    }

    @Test
    public void testCheckSum4() {
        boolean result = atm.chekSum(10, atm);
        assertFalse(result);
    }

    @Test
    public void testCheckSum5() {
        boolean result = atm.chekSum(1590, atm);
        assertTrue(result);
    }


}
