public class Gorilla extends Mammal{
    public Gorilla(int energyLevel) {
		super(energyLevel);
    }

    public void throwSometing(){
        System.out.println("Throwing bananas");
        energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("Eating as many bananas as I can");
        energyLevel -= 10;

    }

    public void climb(){
        System.out.println("Climbing the tree");
        energyLevel -= 10;

    }
}

