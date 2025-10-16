package fr.uvsq.cprog.collex;

import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.*;

public class DnsTest {

    @Test
    public void testAddAndGet() throws IOException {
        Path temp = Files.createTempFile("dns", ".txt");
        Dns dns = new Dns(temp.toString());

        AdresseIp ip = new AdresseIp("192.168.1.1");
        NomMachine nm = new NomMachine("test.local");
        dns.addItem(ip, nm);

        assertEquals("test.local", dns.getItem(ip).getNom().getNom());
    }
}
