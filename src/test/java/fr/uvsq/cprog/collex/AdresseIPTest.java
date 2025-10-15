package fr.uvsq.cprog.dns;

import org.junit.Test;

public class AdresseIPTest {
  @Test(expected = IllegalArgumentException.class)
  public void rejectsBadIp() { new AdresseIP("999.1.2.3"); }

  @Test
  public void acceptsValidIp() { new AdresseIP("193.51.31.90"); }
}
