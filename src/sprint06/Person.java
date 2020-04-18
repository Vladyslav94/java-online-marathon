package sprint06;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Student))
            return false;
        Student student = (Student) obj;
        return this.getName().equals(student.getName()) && this.studyPlace.equals(student.studyPlace) && this.studyYears == student.studyYears;
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Worker))
            return false;
        Worker worker = (Worker) obj;

        return worker.getName().equals(this.getName()) && worker.getExperienceYears() == this.getExperienceYears() &&
                worker.workPosition.equals(this.workPosition);
    }
}

class MyUtils {

    public List<Person> maxDuration(List<Person> people) {
        List<Person> personListCopy = new ArrayList<>(people);

        List<Student> students = new ArrayList<>();
        List<Student> studentsSorted = new ArrayList<>();
        List<Worker> workers = new ArrayList<>();
        List<Worker> workersSorted = new ArrayList<>();

        for (Person p : personListCopy) {
            if (p instanceof Worker && !workers.contains(p))
                workers.add((Worker) p);
            else if(p instanceof Student && !students.contains(p))
                students.add((Student) p);
        }

        List<Person> personList = new ArrayList<>();

        Comparator<Student> comparatorStudent = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getStudyYears() - o1.getStudyYears();
            }
        };
        students.sort(comparatorStudent);
        for (Student s : students) {
            if (students.get(0).getStudyYears() == s.getStudyYears())
                studentsSorted.add(s);
        }

        Comparator<Worker> comparatorWorker = new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                return o2.getExperienceYears() - o1.getExperienceYears();
            }
        };

        workers.sort(comparatorWorker);

        for (Worker w : workers) {
            if (workers.get(0).getExperienceYears() == w.getExperienceYears())
                workersSorted.add(w);
        }

        personList.addAll(workersSorted);
        personList.addAll(studentsSorted);


        return personList;
    }


}




