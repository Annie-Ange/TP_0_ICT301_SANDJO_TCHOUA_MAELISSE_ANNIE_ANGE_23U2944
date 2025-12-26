package DIP.Apres_refactoring;

class MongoDBDatabase implements Database {

    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}