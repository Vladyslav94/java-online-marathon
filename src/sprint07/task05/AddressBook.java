package sprint07.task05;


import sprint06.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class AddressBook implements Iterable {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public NameAddressPair[] getAddressBook() {
        return addressBook;
    }

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if ((firstName == null) || (lastName == null)) return false;
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                return false;
            }
        }
        int length = addressBook.length;
        if (size() == addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[addressBook.length * 2];
            for (int i = 0; i < length; i++) {
                newAddressBook[i] = addressBook[i];
            }
            addressBook = newAddressBook;
            addressBook[size()] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
            counter++;
            return true;

        }
        addressBook[size()] = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        counter++;
        return true;
    }

    public String read(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.firstName.equals(firstName) && addressBook[i].person.lastName.equals(lastName)) {
                return addressBook[i].address;
            }
        }

        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        if ((firstName == null) || (lastName == null)) return false;
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (Objects.equals(person, addressBook[i].person)) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        int numberOfPersonToDelete = 0;
        if ((firstName == null) || (lastName == null)) return false;
        NameAddressPair.Person person = new NameAddressPair.Person(firstName, lastName);

        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(person)) {
                numberOfPersonToDelete = i;
                for (int c = numberOfPersonToDelete; c < counter - 1; c++) {
                    addressBook[c] = addressBook[c + 1];
                }
                counter--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        Comparator<NameAddressPair> comparatorByAscendingOrder = new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                if (o1.person.firstName == null || o2.person.firstName == null)
                    return 0;
                if (!(o1.person.firstName.equals(o2.person.firstName)))
                    return o1.person.firstName.compareTo(o2.person.firstName);
                return o1.person.lastName.compareTo(o2.person.lastName);
            }
        };

        Comparator<NameAddressPair> comparatorByDescendingOrder = new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                if (o1.person.firstName == null || o2.person.firstName == null)
                    return 0;
                if (!(o1.person.firstName.equals(o2.person.firstName)))
                    return o2.person.firstName.compareTo(o1.person.firstName);
                return o2.person.lastName.compareTo(o1.person.lastName);
            }
        };


        switch (order) {
            case ASC:
                Arrays.sort(addressBook, 0, counter, comparatorByAscendingOrder);
                break;
            case DESC:
                Arrays.sort(addressBook, 0, counter, comparatorByDescendingOrder);
                break;
        }
    }

    @Override
    public Iterator<AddressBookIterator> iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < AddressBook.this.counter;
        }

        @Override
        public String next() {
            return addressBook[this.counter++].toString();
        }
    }

    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return firstName.equals(person.firstName) &&
                        lastName.equals(person.lastName);
            }

            @Override
            public String toString() {
                return "First name: " + firstName + ", " + "Last name: " + lastName;
            }
        }

        @Override
        public String toString() {
            return person + ", " + "Address: " + address;
        }
    }

}
