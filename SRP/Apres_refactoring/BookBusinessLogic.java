package SRP.Apres_refactoring; 


class BookBusinessLogic { 

public void emprunter(BookSRP book, String lecteur) { 
 

System.out.println("\nEmprunt du livre '" + book.getTitle() + "' par " + lecteur); } 
 

public void autreService(BookSRP book) {  
 

  System.out.println("\nAutre logique métier sur le livre '" + book.getTitle());}  
 

}