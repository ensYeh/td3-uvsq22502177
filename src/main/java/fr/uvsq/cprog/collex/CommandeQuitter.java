package fr.uvsq.cprog.collex;

public class CommandeQuitter implements Commande {
    @Override
    public String execute(Dns dns) {
        System.out.println("Fermeture du programme...");
        System.exit(0);
        return "";
    }
}
