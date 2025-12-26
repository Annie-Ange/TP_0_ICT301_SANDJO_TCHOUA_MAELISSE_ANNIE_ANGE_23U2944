# OCP – Open Closed Principle

Nom : SANDJO TCHOUA MAELISSE  
UE : ICT301  

## Définition
Le principe OCP stipule qu’une classe doit être ouverte à l’extension mais fermée à la modification.

## Problème du code initial

                         CODE DE La classe AreaCalculator

package OCP.Avant_refactoring;

public class AreaCalculator {

    public double calculateArea(Object shape) {

        if (shape instanceof Rectangle) {

            Rectangle rectangle = (Rectangle) shape;
            return rectangle.getWidth() * rectangle.getHeight();

        } else if (shape instanceof Circle) {

            Circle circle = (Circle) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        }

        throw new IllegalArgumentException("Unknown shape");
    }
}

La classe AreaCalculator utilise des conditions if/else pour calculer l’aire selon le type de forme.
En ajoutant une nouvelle forme qui oblige à modifier cette classe, ce qui viole le principe OCP.

## Refactoring appliqué
Une interface Shape a été introduite.
Chaque forme implémente sa propre méthode calculateArea().
La classe AreaCalculator2 dépend désormais de l’interface et non des classes concrètes.


                                     CODE DE La classe Shape
package OCP.Apres_refactoring;;

public interface Shape {
    double calculateArea();
}

                                    CODE DE La classe AreaCalculator2

package OCP.Apres_refactoring;

public class AreaCalculator2 {

    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
                                        
## Conclusion
Le code est maintenant extensible sans modification, ce qui respecte le principe Open Closed.