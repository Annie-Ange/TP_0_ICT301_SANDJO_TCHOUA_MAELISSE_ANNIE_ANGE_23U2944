# LSP – Liskov Substitution Principle

Nom : Sandjo Tchoua Maelisse Annie Ange
UE : ICT301  

## Définition
Le principe de substitution de Liskov stipule qu'une classe fille doit pouvoir remplacer sa classe mère sans modifier le comportement attendu du programme.

## Problème

                               CODE DE LA CLASSE SQUARE

package LSP.Avant_refactoring;

class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
 
                              CODE DE LA CLASSE RECTANGLE

package LSP.Avant_refactoring;

class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

Dans l'exemple initial, la classe Square hérite de Rectangle, mais modifie son comportement, ce qui provoque des résultats incorrects.

## Solution

La solution consiste à supprimer l'héritage incorrect et à utiliser une interface Shape implémentée séparément par Rectangle et Square.


                                     CODE DE LA CLASSE SHAPE
package LSP.Apres_refactoring;

interface Shape {
    int getArea();
}

                                     CODE DE LA CLASSE RECTANGLE

package LSP.Apres_refactoring;

class Rectangle implements Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

                                     CODE DE LA CLASSE SQUARE

package LSP.Apres_refactoring;

class Square implements Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
