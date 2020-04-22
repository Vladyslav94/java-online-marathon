package sprint07;

public class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza(){}

    public static PizzaBuilder base(){
        return new PizzaBuilder();
    }
    public static class PizzaBuilder{
        private Pizza pizza;

        private PizzaBuilder(){}

        public PizzaBuilder addCheese(String cheese){
            return this;
        }

        public PizzaBuilder addMeat(String meat){
            return this;
        }

        public PizzaBuilder addSeafood(String seafood){
            return this;
        }

        public PizzaBuilder addVegetable(String vegetable){
            return this;
        }

        public PizzaBuilder addMushroom(String mushroom){
            return this;
        }

        public Pizza build(){
            return new Pizza();
        }
    }
}


class Oven {
    public static Pizza cook() {
    return Pizza.base().build();

    }
}