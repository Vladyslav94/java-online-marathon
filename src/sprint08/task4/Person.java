package sprint08.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    String name;
    int discount;

    public Person(String name, int discount){
        this.name = name;
        this.discount = discount;
    }

    DecisionMethod goShopping = (name, discount) -> name.equals("product1") && discount > 10;


}

interface DecisionMethod{
    boolean decide(String name, int discount);
}

class Shop{
    public List<DecisionMethod> clients = new ArrayList<>();


    public int sale(String product, int percent){
        int count = 0;
        for (DecisionMethod decisionMethod : clients) {
            if(decisionMethod.decide(product, percent))
                count++;
        }
        return count;
    }
}
