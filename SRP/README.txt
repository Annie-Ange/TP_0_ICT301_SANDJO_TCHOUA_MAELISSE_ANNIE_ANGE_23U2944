# SRP – Single Responsibility Principle

Nom : Sandjo Tchoua Maelisse Annie Ange
UE : ICT301  

## Définition
Le principe de responsabilité unique stipule qu'une classe ne doit avoir qu'une seule responsabilité.

## Problème
La classe Book gérait à la fois les données, l'affichage, la sauvegarde et la logique métier se qui n'est pas normal pour se principe.

                                 CODE DE LA CLASSE BOOK

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

## Solution
Chaque responsabilité a été séparée dans une classe dédiée : BookSRP, BookPrinter, BookSaver et BookBusinessLogic et ainsi rèsoudre le problème.

                                 CODE DE LA CLASSE BOOKSRP

package SRP.Apres_refactoring; 
 

// Gère les données du livre 
 

public class BookSRP { 
 

private final String title;
 

private final String author;
 

private final String content;
 

public BookSRP(String title, String author, String content) {

this.title = title; 
 

this.author = author; 
 

this.content = content; 
 

} 
 




public String getTitle() { return title; } 

public String getAuthor() { return author; } 
 

public String getContent() { return content; } 
 

}
                                 CODE DE LA CLASSE BOOKPRINTER

package SRP.Apres_refactoring; 

 

class BookPrinter {  


public void printToScreen(BookSRP book) { 
 

  System.out.println("===Print to Screen=== ");  
 

  System.out.println("Titre: " + book.getTitle());  
 

  System.out.println("Auteur: " + book.getAuthor());  
 

  System.out.println("Contenu: " + book.getContent());  
 

} 
 


public void printToHTML(BookSRP book) { 
 

System.out.println("\n===Print to HTML=== ");  
 

System.out.println("<h1>" + book.getTitle() + "</h1>"); 
 

System.out.println("<h2>Par " + book.getAuthor() + "</h2>");  
 

System.out.println("<p>" + book.getContent() + "</p>"); 
 

}  
 

} 
                                 CODE DE LA CLASSE BOOKSAVER

package SRP.Apres_refactoring; 

 

class BookSaver {  
 

  public void saveToDatabase(BookSRP book) {  
 

      System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de données..."); }  
 

public void saveToFile(BookSRP book, String filename) { 
 

System.out.println("\nSauvegarde de '" + book.getTitle() + "' dans " + filename); } 
 

} 
                                 CODE DE LA CLASSE BOOKBUSINESSLOGIC

package SRP.Apres_refactoring; 


class BookBusinessLogic { 

public void emprunter(BookSRP book, String lecteur) { 
 

System.out.println("\nEmprunt du livre '" + book.getTitle() + "' par " + lecteur); } 
 

public void autreService(BookSRP book) {  
 

  System.out.println("\nAutre logique métier sur le livre '" + book.getTitle());}  
 

}