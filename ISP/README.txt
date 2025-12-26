# ISP – Interface Segregation Principle

Nom : Sandjo Tchoua Annie Ange 
UE : ICT301  

## Définition
Le principe de ségrégation des interfaces stipule qu'une classe ne doit pas être forcée d’implémenter des méthodes qu’elle n’utilise pas.

## Problème
Dans l'exemple initial, l'interface Worker impose la méthode eat() à RobotWorker, alors qu’un robot ne mange pas.

                   CODE DE LA CLASSE ROBOTWORKER

package ISP.Avant_refactoring;

class RobotWorker implements Worker {

    @Override
    public void work() {
        System.out.println("Les Robots travaillent sans fatigue");
    }

    @Override
    public void eat() {
        System.out.println("l'on ne doit pas faire manger un robot");
        throw new UnsupportedOperationException("Les Robots ne mangent pas");
    }
}

## Solution
La solution consiste à diviser l’interface Worker en plusieurs interfaces plus spécifiques : Workable et Eatable.

                   CODE DE LA CLASSE WORKABLE

package ISP.Apres_refactoring;

interface Workable {
    void work();
}

                   CODE DE LA CLASSE EATABLE

package ISP.Apres_refactoring;

interface Eatable extends Workable {
    void eat();
}
