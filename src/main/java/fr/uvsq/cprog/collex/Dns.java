package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Dns {
    private final Map<String, DnsItem> byName = new HashMap<>();
    private final Map<String, DnsItem> byIp = new HashMap<>();
    private final Path dataPath;

    public Dns(String filename) {
        this.dataPath = Path.of(filename);
        try {
            load();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement du fichier DNS : " + e.getMessage(), e);
        }
    }

    /** Charge les enregistrements depuis le fichier texte */
    private void load() throws IOException {
        if (!Files.exists(dataPath)) return;
        List<String> lines = Files.readAllLines(dataPath, StandardCharsets.UTF_8);
        for (String line : lines) {
            if (line.isBlank() || line.startsWith("#")) continue;
            String[] parts = line.trim().split("\\s+");
            if (parts.length != 2) continue;
            NomMachine nm = new NomMachine(parts[0]);
            AdresseIp ip = new AdresseIp(parts[1]);
            DnsItem item = new DnsItem(nm, ip);
            byName.put(nm.getNom(), item);
            byIp.put(ip.getIp(), item);
        }
    }

    /** Sauvegarde tous les enregistrements dans le fichier texte */
    private void save() throws IOException {
        List<String> lines = byName.values().stream()
                .sorted(Comparator.comparing(i -> i.getNom().getNom()))
                .map(i -> i.getNom().getNom() + " " + i.getIp().getIp())
                .collect(Collectors.toList());
        Files.write(dataPath, lines, StandardCharsets.UTF_8);
    }

    /** Récupère un item à partir du nom */
    public DnsItem getItem(NomMachine nm) {
        return byName.get(nm.getNom());
    }

    /** Récupère un item à partir de l’adresse IP */
    public DnsItem getItem(AdresseIp ip) {
        return byIp.get(ip.getIp());
    }

    /** Liste toutes les machines d’un domaine */
    public List<DnsItem> getItems(String domain, boolean sortByIp) {
        Comparator<DnsItem> cmp = sortByIp
                ? Comparator.comparing(i -> i.getIp().getIp())
                : Comparator.comparing(i -> i.getNom().getHost());
        return byName.values().stream()
                .filter(i -> i.getNom().getDomain().equals(domain))
                .sorted(cmp)
                .collect(Collectors.toList());
    }

    /** Ajoute un nouvel enregistrement */
    public void addItem(AdresseIp ip, NomMachine nm) throws IOException {
        if (byName.containsKey(nm.getNom()))
            throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");
        if (byIp.containsKey(ip.getIp()))
            throw new IllegalArgumentException("ERREUR : L’adresse IP existe déjà !");
        DnsItem item = new DnsItem(nm, ip);
        byName.put(nm.getNom(), item);
        byIp.put(ip.getIp(), item);
        save();
    }
}
