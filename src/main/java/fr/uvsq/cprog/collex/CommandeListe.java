package fr.uvsq.cprog.collex;

import java.util.List;

public class CommandeListe implements Commande {
    private final String domain;
    private final boolean sortByIp;

    public CommandeListe(String domain, boolean sortByIp) {
        this.domain = domain;
        this.sortByIp = sortByIp;
    }

    @Override
    public String execute(Dns dns) {
        List<DnsItem> items = dns.getItems(domain, sortByIp);
        if (items.isEmpty()) {
            return "Aucune machine trouvée pour le domaine " + domain;
        }

        StringBuilder sb = new StringBuilder();
        for (DnsItem item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
