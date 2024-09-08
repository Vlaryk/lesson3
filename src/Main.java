import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Ivan",22,4.5);
        try(FileOutputStream fileOutputStream = new FileOutputStream("student.bin");) {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(student);
            }
        }
        try(FileInputStream fileInputStream = new FileInputStream("student.bin");) {
            ObjectInputStream objectInput = new ObjectInputStream(fileInputStream);
            Student person = ((Student) objectInput.readObject());
            System.out.printf("Имя: %s, возраст: %s, средний балл: %s средний балл не был сохранен, потому что поле GPA модифицированно transient", person.getName(),person.getAge(),person.getGPA());

        }
    }
}