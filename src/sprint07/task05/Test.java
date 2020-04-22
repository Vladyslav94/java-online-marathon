package sprint07.task05;

public class Test {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook(4);
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("Steven", "Taylor", "Address #1");
        addressBook.create("Susan", "Brown", "Address # 4");
        addressBook.update("Steven", "Taylor", "Address #3");
        addressBook.delete("John", "Brown");
        for (Object record : addressBook) {
            System.out.println(record);
        }
    }
}
