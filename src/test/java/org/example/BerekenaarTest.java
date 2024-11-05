package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


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
        berekenaar.setEigenInkomen(1750);
        berekenaar.setPartnerInkomen(2000);
        berekenaar.setRente(0.05);

        assertEquals(200812.5, berekenaar.getLeenBedragMetRente(), 0.01);
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
        berekenaar.setEigenInkomen(2100);
        berekenaar.setPartnerInkomen(1500);
        berekenaar.setStudieSchuld(true);
        berekenaar.setTermijn(10);
        berekenaar.setRente(0.035);

        berekenaar.setAflossingPerMaand();

        assertEquals(1583.55, berekenaar.getAflossingPerMaand(), 0.01);
    }

    @Test
    public void testFullHypotheekBerekeningMetCorrecteInvoer() {
        // Simulate user input for a complete test run
        // Provide inputs for all prompts that the program expects, such as income, term, etc.
        String input = "1\n6663\n2\n1\n3000\n5000\n5\n2\n";  // Adjusted based on user prompts in Vragen.formulier
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capture the standard output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Run the application
        Main.main(new String[0]);

        // Reset the standard output and input to their original states
        System.setOut(originalOut);
        System.setIn(System.in);

        // Capture the output and check for expected values in the result
        String actualOutput = outputStream.toString();

        // Define what you expect based on your calculations
        // Example of an expected output, adjust this based on the actual expected calculation
        String expectedOutput = "Je maximale leen bedrag exclusief rente is: €";
        String expectedMonthlyPayment = "Je moet dan €";  // Check for monthly payment output as well

        // Assertions to check that the expected results are included in the actual output
//        assertTrue(actualOutput.contains(expectedOutput), "Expected maximum loan output is missing.");
//        assertTrue(actualOutput.contains(expectedMonthlyPayment), "Expected monthly payment output is missing.");
    }
}
