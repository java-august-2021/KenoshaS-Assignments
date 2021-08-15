public class Bat extends Mammal {

    public Bat(int energyLevel) {
        super(300);
    }


    public void fly(){
        System.out.println("Flyyyyyy");
        energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("so- well, never mind");
        energyLevel += 25;

    }

    public void attackTown(){
        System.out.println("Fiiirrrreeeee!!!");
        energyLevel -= 100;

    }

}