package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BerekenaarTest {
    private Berekenaar berekenaar;

    @Before
    public void setUp() {
        berekenaar = new Berekenaar();
    }

    @Test
    public void testMaxLeenBedragWithoutStudieSchuld() {
        berekenaar.setEigenInkomen(2100);
        berekenaar.setPartnerInkomen(1500);
        berekenaar.setStudieSchuld(false);
        berekenaar.setTermijn(1);
        berekenaar.setRente(0.02);

        berekenaar.setMaxLeenBedrag();

        assertEquals(183600, berekenaar.getMaxLeenBedrag(), 0.01);
    }

    @Test
    public void testMaxLeenBedragWithStudieSchuld() {
        berekenaar.setEigenInkomen(4000);
        berekenaar.setPartnerInkomen(2000);
        berekenaar.setStudieSchuld(true);
        berekenaar.setTermijn(5);
        berekenaar.setRente(0.03);

        berekenaar.setMaxLeenBedrag();

        assertEquals(229500, berekenaar.getMaxLeenBedrag(), 0.01);
    }

    @Test
    public void testLeenBedragMetRente() {
        berekenaar.setMaxLeenBedrag();
        berekenaar.setRente(0.04);

        berekenaar.setLeenBedragMetRente(100000.0);

        assertEquals(260000.0, berekenaar.getLeenBedragMetRente(), 0.01);
    }

    @Test
    public void testTotaalInkomen() {
        berekenaar.setEigenInkomen(40000.0);
        berekenaar.setPartnerInkomen(20000.0);

        berekenaar.setTotaalInkomen();

        assertEquals(60000.0, berekenaar.getTotaalInkomen(), 0.01);
    }

    @Test
    public void testMonthlyPayment() {
//        berekenaar.setEigenInkomen(100);
//        berekenaar.setPartnerInkomen(100);
        berekenaar.getLeenBedragMetRente(1000);
        berekenaar.setStudieSchuld(true);
        berekenaar.setTermijn(10);
        berekenaar.setRente(0.035);

        berekenaar.setAflossingPerMaand();

        assertEquals(1000, berekenaar.getAflossingPerMaand(), 0.01);
    }
}
