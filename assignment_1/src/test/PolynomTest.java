package test;

import mvc.models.Polynom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomTest {

    @Test
    void xSquaredDerivatedShouldEqual2x()
    {
        //because it works
        var a = new Polynom();
        a.add(2,1);///x^2
        Polynom result = a.derivate();
        assertEquals(2, result.getMap().get(1));///2 * x
    }

    @Test
    void Three_X_SquaredIntegratedShouldEqual_X_Cubed()
    {
        var a = new Polynom();
        a.add(2,3);///x^2
        Polynom result = a.integrate();
        assertEquals(1, result.getMap().get(3));///1 * x^3
    }

    @Test
    void sevenMinusFiveShouldEqualTwo()
    {
        var a = new Polynom();
        Polynom b = new Polynom();
        a.add(1,7);
        b.add(1,5);
        Polynom result = a.subtract(b);
        assertEquals(2, result.getMap().get(1));
    }

    @Test
    void twoPlusFiveShouldEqualSeven()
    {
        var a = new Polynom();
        Polynom b = new Polynom();
        a.add(1,2);
        b.add(1,5);
        Polynom result = a.addition(b);
        assertEquals(7, result.getMap().get(1));
        //assertTrue();
        //assertFalse();
        //assertNull();   assertNotNull();

        ///RUN TEST WITH COVERAGE -> LINES OF CODE
    }

    @Test
    void twoMultipledWithFourShouldEqualEight()
    {
        var a = new Polynom();
        Polynom b = new Polynom();
        a.add(1,2);
        b.add(1,4);
        Polynom result = a.multiply(b);

        assertEquals(8, result.getMap().get(2 * 1));
    }



    @Test
    void twoPlusSevenShouldEqualNine()
    {
        var a = new Polynom();
        Polynom b = new Polynom();
        a.add(1,2);
        b.add(1,7);
        Polynom result = a.addition(b);
        ///syntax
        assertThrows(IllegalArgumentException.class,
                () -> {
                    b.add(Integer.parseInt("Mancare"), 5);
                });
        ///test passes if it throws that exception
        assertThrows(NumberFormatException.class,
                () -> {///lambda to check if throw that exception
                    b.add(Integer.parseInt("Mancare"), 5);
                });
    }
}