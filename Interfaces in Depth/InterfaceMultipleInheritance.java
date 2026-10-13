interface LandAnimal {
    public boolean canBreathe();
}

interface WaterAnimal {
    public boolean canBreathe();
}

class Crocodile implements LandAnimal, WaterAnimal {

    @Override
    public boolean canBreathe() {
        return true;
    }
}

public class InterfaceMultipleInheritance {
    public static void main(String[] args) {

        Crocodile c1 = new Crocodile();

        System.out.println(
            c1.canBreathe()
                ? "Can Breathe"
                : "Can Not Breathe"
        );
    }
}