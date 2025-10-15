package fr.uvsq.cprog.collex;

public class NomMachine {
    private final String nom;
    private final String host;
    private final String domain;

    public NomMachine(String nom) {
        if(nom == null || nom.isEmpty() || !nom.contains(".")) {
            throw new IllegalArgumentException("Le nom de la machine "+ nom +" est invalide");
        }
        this.nom = nom.trim();
        int index= nom.indexOf(".");
        this.host= nom.substring(0, index);
        this.domain= nom.substring(index+1);

        if(host.isEmpty() || domain.isEmpty()) {
            throw new IllegalArgumentException("Le nom de la machine "+ nom +" est invalide");
        }
    }
    public String getNom() {
        return nom;
    }
    public String getHost() {
        return host;}
        
    public String getDomain() {
        return domain;}

     @Override
    public String toString() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomMachine)) return false;
        NomMachine other = (NomMachine) o;
        return nom.equals(other.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
