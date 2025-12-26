package SRP.Apres_refactoring; 

 

class BookSaver {  
 

  public void saveToDatabase(BookSRP book) {  
 

      System.out.println("\nSauvegarde de '" + book.getTitle() + "' en base de données..."); }  
 

public void saveToFile(BookSRP book, String filename) { 
 

System.out.println("\nSauvegarde de '" + book.getTitle() + "' dans " + filename); } 
 

} 