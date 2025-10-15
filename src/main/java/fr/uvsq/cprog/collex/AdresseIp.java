package fr.uvsq.cprog.collex;

public class AdresseIp {
    private final String ip;

    public AdresseIp(String ip) {
        if (ip == null || !ip.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        }

        for (String part : ip.split("\\.")) {
            int n = Integer.parseInt(part);
            if (n < 0 || n > 255) {
                throw new IllegalArgumentException("Octet invalide : " + part);
            }
        }
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AdresseIp))
            return false;
        AdresseIp other = (AdresseIp) o;
        return ip.equals(other.ip);
    }

    @Override
    public int hashCode() {
        return ip.hashCode();
    }

    @Override
    public String toString() {
        return ip;
    }

    public String getIp() {
        return ip;
    }
}
