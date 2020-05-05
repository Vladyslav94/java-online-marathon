package sprint11;

public class Plant {
    private String name;
    private Color color;
    private Type type;

    public static void main(String[] args) throws TypeException, ColorException {
        Plant plant = tryCreatePlant("Ra", "Blue", "MyPlant");
        System.out.println(plant);
    }

    public Plant(String type, String color, String name) throws ColorException, TypeException {

        this.name = name;

        try{
            this.color = Color.valueOf(color);
        } catch (IllegalArgumentException e){
            throw new ColorException("ColorException found");
        }

        try{
            this.type = Type.valueOf(type);
        } catch (IllegalArgumentException e){
            throw new TypeException("TypeException found");
        }
    }

    public static Plant tryCreatePlant(String type, String color, String name) throws TypeException, ColorException {
        Plant plant;
        try {
            plant = new Plant(type, color, name);
            return plant;
        } catch (ColorException e) {
            try {
                plant = new Plant(type, "Red", name);
                return plant;
            } catch (ColorException | TypeException ignored) {
            }
        } catch (TypeException e) {
            try {
                plant = new Plant("Ordinary", color, name);
                return plant;
            } catch (ColorException | TypeException ignored) {
            }
        }
        return new Plant("Ordinary", "Red", name);
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color + ", name: " + name + "}";
    }
}


enum Type{
    Rare,
    Ordinary
}

enum Color{
    White,
    Red,
    Blue
}

class ColorException extends Exception{

    public ColorException(String name){
        super(name);
    }
}

class TypeException  extends Exception{
    public TypeException(String name){
        super(name);
    }

}

