package DIP.Apres_refactoring;

class MySQLDatabase implements Database {

    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}