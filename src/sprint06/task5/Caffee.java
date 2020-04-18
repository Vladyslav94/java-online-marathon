package sprint06.task5;

import java.util.*;

public class Caffee implements DrinkReceipt, DrinkPreparation, Rating{
    private String name;
    private int rating;
    private Map<String,Integer> ingredients;

    public Caffee(String name, int rating){
        this.name = name;
        this.rating = rating;
        this.ingredients = new HashMap<>();
        ingredients.put("Water", 100);
        ingredients.put("Arabica", 20);
    }


    @Override
    public Map<String, Integer> makeDrink() {
        return ingredients;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        this.ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Caffee{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getRating();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Caffee))
            return false;
        Caffee caffee = (Caffee) obj;
        return this.name.equals(caffee.getName()) && this.rating == caffee.getRating();
    }

    public static void main(String[] args) {
        Espresso espresso = new Espresso("Espresso", 8);
        Cappuccino cappuccino = new Cappuccino("Cappuccino", 10);
        Espresso espresso1 = new Espresso("Espresso", 10);
        Cappuccino cappuccino1 = new Cappuccino("Cappuccino", 6);
        Caffee caffee = new Caffee("Caffe", 6);
        Caffee caffee1 = new Caffee("Caffe", 6);


        List<Caffee> caffees = new ArrayList<>();
        caffees.add(espresso);
        caffees.add(cappuccino);
        caffees.add(espresso1);
        caffees.add(cappuccino1);
        caffees.add(caffee);
        caffees.add(caffee1);

       MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.averageRating(caffees));
    }
}

class Espresso extends Caffee{

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink().put("Water", 50);
        return super.makeDrink();
    }



    @Override
    public String toString() {
        return "Espresso{" +
                "name='" + getName() + '\'' +
                ", rating=" + getRating() +
                '}';
    }
}

class Cappuccino extends Caffee{

    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        super.makeDrink().put("Milk", 50);
        return super.makeDrink();
    }
    @Override
    public String toString() {
        return "Cappuccino{" +
                "name='" + getName() + '\'' +
                ", rating=" + getRating() +
                '}';
    }

}

class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Set<Caffee> caffees11 = new HashSet<>(coffees);
        List<Caffee> unique = new ArrayList<>(caffees11);
        Map<String, Integer> totalRateMap = new HashMap<>();
        double countForCaffe = 0;
        double countForCapuccino = 0;
        double countForEspresso = 0;
        for (Caffee c: unique) {
            if(c instanceof Cappuccino)
                countForCapuccino++;
            else if(c instanceof Espresso)
                countForEspresso++;
            else
                countForCaffe++;
        }

        for (Caffee caf:unique) {
            if(!totalRateMap.containsKey(caf.getName()))
                totalRateMap.put(caf.getName(),caf.getRating());
            else totalRateMap.put(caf.getName(), totalRateMap.get(caf.getName()) + caf.getRating());
        }

        Map<String, Double> averageRateMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry: totalRateMap.entrySet()){
            if(entry.getKey().equals("Cappuccino")){
                averageRateMap.put("Cappuccino", entry.getValue()/countForCapuccino);
            } else if(entry.getKey().equals("Espresso")){
                averageRateMap.put("Espresso", entry.getValue()/countForEspresso);
            } else
                averageRateMap.put("Caffe", entry.getValue()/countForCaffe);
        }

        return averageRateMap;
    }
}