package fr.uvsq.cprog.collex;

import java.util.Objects;

public class DnsItem implements Comparable<DnsItem>{
    private NomMachine nomMachine;
    private AdresseIp adresseIp;
    public DnsItem(NomMachine nomMachine, AdresseIp adresseIp) {
        this.nomMachine = Objects.requireNonNull(nomMachine, "NomMachine ne doit pas être null");
        this.adresseIp = Objects.requireNonNull(adresseIp, "AdresseIp ne doit pas être null");
    }
     public NomMachine getNom() {
        return nomMachine;
    }

    public AdresseIp getIp() {
        return adresseIp;
    }

    @Override
    public String toString() {
        return adresseIp + " " + nomMachine;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem other = (DnsItem) o;
        return nomMachine.equals(other.nomMachine) && adresseIp.equals(other.adresseIp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomMachine, adresseIp);
    }

    @Override
    public int compareTo(DnsItem other) {
        return this.nomMachine.getNom().compareTo(other.nomMachine.getNom());
    }
}
