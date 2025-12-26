package SRP.Avant_refactoring;

public class Book {

    private final String title;
    private final String author;
    private final String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // Responsabilité 1 : Données
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    // Responsabilité 2 : Affichage
    public void printToScreen() {
        System.out.println("Titre: " + title);
        System.out.println("Auteur: " + author);
        System.out.println("Contenu: " + content);
    }

    // Responsabilité 3 : Persistance
    public void saveToDatabase() {
        System.out.println("Sauvegarde du livre '" + title + "' en base de données...");
    }

    // Responsabilité 4 : Logique métier
    public void emprunter(String lecteur) {
        System.out.println("Emprunt du livre '" + title + "' par " + lecteur);
    }
}