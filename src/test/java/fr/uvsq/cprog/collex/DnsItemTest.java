package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class DnsItemTest {

    @Test
    public void testCreationItem() {
        NomMachine nm = new NomMachine("www.uvsq.fr");
        AdresseIp ip = new AdresseIp("193.51.31.90");
        DnsItem item = new DnsItem(nm, ip);

        assertEquals("www.uvsq.fr", item.getNom().getNom());
        assertEquals("193.51.31.90", item.getIp().getIp());
    }

    @Test
    public void testToString() {
        NomMachine nm = new NomMachine("www.uvsq.fr");
        AdresseIp ip = new AdresseIp("193.51.31.90");
        DnsItem item = new DnsItem(nm, ip);

        assertTrue(item.toString().contains("193.51.31.90"));
        assertTrue(item.toString().contains("www.uvsq.fr"));
    }

    @Test
    public void testEgalite() {
        DnsItem a = new DnsItem(new NomMachine("poste.uvsq.fr"), new AdresseIp("193.51.31.154"));
        DnsItem b = new DnsItem(new NomMachine("poste.uvsq.fr"), new AdresseIp("193.51.31.154"));
        assertEquals(a, b);
    }
}
