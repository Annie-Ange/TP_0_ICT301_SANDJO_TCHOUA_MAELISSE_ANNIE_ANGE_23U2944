# DIP – Dependency Inversion Principle

Nom : Sandjo Tchoua Maelisse Annie Ange
UE : ICT301  

## Définition
Le principe d’inversion des dépendances stipule que les modules de haut niveau ne doivent pas dépendre des modules de bas niveau, mais d’abstractions.

## Problème
Dans l'exemple initial, la classe OrderProcessor dépend directement de MySQLDatabase, ce qui rend le code rigide.

                                       CODE DE LA CLASSE ORDERPROCESSOR

package DIP.Avant_refactoring;

public class OrderProcessor {

    private MySQLDatabase database;

    public OrderProcessor() {
        this.database = new MySQLDatabase();
    }

    public void processOrder(String order) {
        database.save(order);
    }
}

                                       CODE DE LA CLASSE MYSQLDATABASE

package DIP.Avant_refactoring;

class MySQLDatabase {

    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

## Solution
La solution consiste à introduire une interface Database et à injecter l’implémentation via le constructeur.

                                       CODE DE LA CLASSE DATABASE

package DIP.Apres_refactoring;

interface Database {
    void save(String data);
}

                                       CODE DE LA CLASSE MONGODBDATABASE

package DIP.Apres_refactoring;

class MongoDBDatabase implements Database {

    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}
