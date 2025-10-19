package fr.uvsq.cprog.collex;

public class DnsApp {

    private final Dns dns;
    private final DnsTUI tui;

    public DnsApp(String filename) {
        this.dns = new Dns(filename);
        this.tui = new DnsTUI();
    }
    public void run() {
        while (true) {
            Commande cmd = tui.nextCommande();
            if (cmd != null) {
                try {
                    String result = cmd.execute(dns);
                    tui.affiche(result);
                } catch (Exception e) {
                    tui.affiche( e.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        DnsApp app = new DnsApp("dns.txt");
        app.run();
    }
}
