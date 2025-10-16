package fr.uvsq.cprog.collex;

import java.io.IOException;

public class CommandeAjout implements Commande {
    private final AdresseIp ip;
    private final NomMachine nom;

    public CommandeAjout(AdresseIp ip, NomMachine nom) {
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public String execute(Dns dns) throws IOException {
        dns.addItem(ip, nom);
        return "Ajout réussi : " + nom.getNom() + " -> " + ip.getIp();
    }
}
