package sprint10;

public class Array<T> {
    private T[] array;

    public Array(T[] arary){
        this.array = arary;
    }

    public T get(int index) {
        return array[index];
    }

    public int length(){
        return array.length;
    }
}
