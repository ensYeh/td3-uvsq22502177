package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    private final Scanner scanner = new Scanner(System.in);

    
    public Commande nextCommande() {
        System.out.print("> ");
        String line = scanner.nextLine().trim();

        if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
            return new CommandeQuitter();
        }

        try {
            if (line.startsWith("add")) {
                String[] parts = line.split("\\s+");
                if (parts.length != 3) {
                    System.out.println("Format : add <ip> <nom>");
                    return null;
                }
                AdresseIp ip = new AdresseIp(parts[1]);
                NomMachine nm = new NomMachine(parts[2]);
                return new CommandeAjout(ip, nm);
            }
            if (line.startsWith("ls")) {
                String[] parts = line.split("\\s+");
                boolean sortByIp = line.contains("-a");
                String domain = parts[parts.length - 1];
                return new CommandeListe(domain, sortByIp);
            }

            if (line.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$")) {
                AdresseIp ip = new AdresseIp(line);
                return new CommandeRechercheNom(ip);
            }

            if (line.contains(".")) {
                NomMachine nm = new NomMachine(line);
                return new CommandeRechercheIP(nm);
            }

            System.out.println("Commande non reconnue : " + line);
            return null;

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }

    public void affiche(String texte) {
        System.out.println(texte);
    }
}
