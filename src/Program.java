
//Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
//Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
//Сериализуйте этот объект в файл.
//Десериализуйте объект обратно в программу из файла.
//Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.


import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student1 = new Student("Petro", 25, 4.5);
        Student student2 = new Student("Sergo", 32, 3.9);
        Student student3 = new Student("Alex", 19, 2.8);



        try (FileOutputStream fileOutputStream = new FileOutputStream("studentBin.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student1);
            System.out.println("Обьект студент1 Сериализован");

            objectOutputStream.writeObject(student2);
            System.out.println("Обьект студент2 Сериализован");

            objectOutputStream.writeObject(student3);
            System.out.println("Обьект студент3 Сериализован");

        }

        try (FileInputStream fileInputStream = new FileInputStream("studentBin.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            student1 = (Student) objectInputStream.readObject();
            System.out.println("Обьект студент1 Десериализован");

            student2 = (Student) objectInputStream.readObject();
            System.out.println("Обьект студент2 Десериализован");

            student3 = (Student) objectInputStream.readObject();
            System.out.println("Обьект студент3 Десериализован");

        }

        System.out.println("Обьект студент1 Десериализован");
        System.out.println("Имя : " + student1.getName());
        System.out.println("Возраст : " + student1.getAge());
        System.out.println("Средний бал : " + student1.getGPA());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Обьект студент2 Десериализован");
        System.out.println("Имя : " + student2.getName());
        System.out.println("Возраст : " + student2.getAge());
        System.out.println("Средний бал : " + student2.getGPA());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("Обьект студент3 Десериализован");
        System.out.println("Имя : " + student3.getName());
        System.out.println("Возраст : " + student3.getAge());
        System.out.println("Средний бал : " + student3.getGPA());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");


        System.out.println("\n Примечание : " +
                " Данные о среднем балле не были сохранены в файл, и не были востановленны, " +
                " потому что значение переменной transient double GPA т.к она, " +
                " является transien св-ом и не вхожит в состав обвчного определения класса " +
                " transien св-во не сохраняется в баззе данных HiberNate т.к они считаются временными " +
                " и не ялвются частью составления обьекта, они используются для оптимизации производительности " +
                " и улучшения работы приложения");


    }
}