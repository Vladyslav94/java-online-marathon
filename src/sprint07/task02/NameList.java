package sprint07.task02;

import java.util.ArrayList;
import java.util.Iterator;

public class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patrick", "Sara"};

    public Iterator getIterator(){
        return new Iterator();
    }

    public class Iterator{
        private int counter = 0;

        private Iterator(){}

        public  boolean hasNext(){
            return counter < names.length;
        }

        public String next(){
           if(this.hasNext())
               return names[counter++];
           return null;
        }

    }
}
