package fr.uvsq.cprog.collex;

public class CommandeRechercheNom implements Commande {
    private final AdresseIp ip;

    public CommandeRechercheNom(AdresseIp ip) {
        this.ip = ip;
    }

    @Override
    public String execute(Dns dns) {
        DnsItem item = dns.getItem(ip);
        return (item != null)
                ? item.getNom().getNom()
                : "Aucune correspondance trouvée pour " + ip.getIp();
    }
}
