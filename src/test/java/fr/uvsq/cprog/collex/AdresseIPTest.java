package   fr.uvsq.cprog.collex;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdresseIPTest {

    @Test
    public void testAdresseValide() {
        AdresseIp ip = new AdresseIp("192.168.0.1");
        assertEquals("192.168.0.1", ip.getIp());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdresseInvalideFormat() {
        new AdresseIp("abc.def.ghi.jkl");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdresseInvalideValeur() {
        new AdresseIp("999.10.10.10");
    }

    @Test
    public void testEgalite() {
        AdresseIp ip1 = new AdresseIp("10.0.0.1");
        AdresseIp ip2 = new AdresseIp("10.0.0.1");
        assertEquals(ip1, ip2);
    }

    @Test
    public void testToString() {
        AdresseIp ip = new AdresseIp("127.0.0.1");
        assertEquals("127.0.0.1", ip.toString());
    }
}
