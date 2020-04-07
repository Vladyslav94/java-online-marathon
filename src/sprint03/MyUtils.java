package sprint03;

import java.util.*;

public class MyUtils {
    public static void main(String[] args) {

    }
//    Create a arrSort() method of the MyUtils class to sort a two-dimensional integer array by
//    descending the elements of the first column.  In the case of equality of elements in the first
//    column, the elements of the second column must be sorted in ascending order.
//    For example, for a given array
// 1 2 3
// 1 4
// 3 2
// 3 3 5
//    you should get
// 3 2
// 3 3 5
// 1 2 3
// 1 4

    public int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if (o1.length == 0) {
                    return 1;
                }
                if (o2.length == 0) {
                    return -1;
                }

                int min = Math.min(o1.length, o2.length);
                for (int i = 0; i < min; i++) {
                    if (o1[i] != o2[i]) {
                        return o2[i] - o1[i];
                    }
                    return o1[i] - o2[i];
                }
                return 1;
            }
        });
        return arr;
    }


    //Create the strSort() method of the MyUtils class to sort a list of stirngs
    // first by length and alphabetically within the same length. The original list must be unchanged.
    //For example, for a given list [zz, abc, aa, aaa] you should get [aa, zz, aaa, abc].
    public List<String> strSort(List<String> originList) {
        List<String> list = new ArrayList<>(originList);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = o1.length();
                int b = o2.length();
                if (a != b) {
                    return Integer.compare(o1.length(), o2.length());
                }

                return o1.compareTo(o2);
            }
        });

        return list;
    }


    //    Create a createNotebook() method of the MyUtils class to create a new map with name as key and phone list as value.
//    The method receives a map  with phone as key and name as value.
//    For example, for a given map {0967654321=Petro, 0677654321=Petro, 0501234567=Ivan, 0970011223=Stepan, 0631234567=Ivan}
//    you should get {Ivan=[0501234567, 0631234567], Petro=[0967654321, 0677654321], Stepan=[0970011223]}.
    public static Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> noteBook = new TreeMap<>();

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            noteBook.put(entry.getValue(), new ArrayList<>());
        }

        for (Map.Entry<String, String> entry : phones.entrySet()) {
            String currentName = entry.getValue();
            if (noteBook.containsKey(currentName)) {
                noteBook.get(currentName).add(entry.getKey());
            }

        }

        return noteBook;
    }

    //Create a listMapCompare() method of the MyUtils class to compare the contents
    // of a list of strings and the values of a map.
    //For example, for a given list [aa, bb, aa, cc] and map {1=cc, 2=bb, 3=cc, 4=aa, 5=cc} you should get true.

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        List<String> mapValues = new ArrayList<>(map.values());

        for (String l : list) {
            if (!mapValues.contains(l))
                return false;
        }

        for (String mapValue : mapValues) {
            if (!list.contains(mapValue))
                return false;
        }

        return true;
    }

    //Create the commonStudents() method of the MyUtils class to return a HashSet of common elements of two student lists.
    //For example, for a given list1 [Students [id=1, name=Ivan], Students [id=2, name=Petro], Students [id=3, name=Stepan]]
    // and list2 [Students [id=1, name=Ivan], Students [id=3, name=Stepan], Students
    // [id=4, name=Andriy]] you should get [Students [id=3, name=Stepan], Students [id=1, name=Ivan]].

    public static class Student {
        private int id;
        private String name;


        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Student))
                return false;
            Student student = (Student) obj;

            return id == student.id && ((name == student.name) || (name != null && name.equals(student.name)));
        }

        @Override
        public int hashCode() {
            int result = 0;
            result = result + (name == null ? 0 : name.hashCode());
            result = result * 31 + id;
            return result;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        Set<Student> commonStudent = new HashSet<>();
        Set<Student> l1 = new HashSet<>(list1);
        Set<Student> l2 = new HashSet<>(list2);
        for (Student s1 : l1) {
            for (Student s2 : l2) {
                if (s1.equals(s2)) {
                    commonStudent.add(s1);
                }
            }
        }
        return commonStudent;
    }

}
