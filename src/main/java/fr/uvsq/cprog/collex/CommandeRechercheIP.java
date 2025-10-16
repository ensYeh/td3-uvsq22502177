package fr.uvsq.cprog.collex;

public class CommandeRechercheIP implements Commande {
    private final NomMachine nom;

    public CommandeRechercheIP(NomMachine nom) {
        this.nom = nom;
    }

    @Override
    public String execute(Dns dns) {
        DnsItem item = dns.getItem(nom);
        return (item != null)
                ? item.getIp().getIp()
                : "Aucune correspondance trouvée pour " + nom.getNom();
    }
}
