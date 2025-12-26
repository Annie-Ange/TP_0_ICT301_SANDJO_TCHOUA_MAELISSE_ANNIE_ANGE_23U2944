package ISP.Apres_refactoring;

class HumanWorker implements Eatable {

    @Override
    public void work() {
        System.out.println("Les humains travaillent");
    }

    @Override
    public void eat() {
        System.out.println("Les humains mangent");
    }
}