package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class NomMachineTest {

    @Test
    public void testNomValide() {
        NomMachine nm = new NomMachine("www.uvsq.fr");
        assertEquals("www", nm.getHost());
        assertEquals("uvsq.fr", nm.getDomain());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomSansPoint() {
        new NomMachine("localhost");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomVide() {
        new NomMachine(".fr");
    }

    @Test
    public void testEgalite() {
        NomMachine a = new NomMachine("www.uvsq.fr");
        NomMachine b = new NomMachine("www.uvsq.fr");
        assertEquals(a, b);
    }

    @Test
    public void testToString() {
        NomMachine nm = new NomMachine("poste.uvsq.fr");
        assertEquals("poste.uvsq.fr", nm.toString());
    }
}
