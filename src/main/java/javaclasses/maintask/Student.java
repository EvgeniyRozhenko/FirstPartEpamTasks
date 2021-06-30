/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные
на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
Создать массив объектов. Вывести:
a) список студентов заданного факультета;
b) списки студентов для каждого факультета и курса;
c) список студентов, родившихся после заданного года;
d) список учебной группы.
 */
package javaclasses.maintask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javaclasses.maintask.Student.Faculty.*;
import static javaclasses.maintask.Student.Course.*;
import static javaclasses.maintask.Student.Group.*;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int birthdayYear;
    private String address;
    private String phone;
    private String faculty;
    private String course;
    private char group;

    public Student() {
    }

    public Student(int id, String name, String patronymic, String surname, int birthdayYear, String faculty, String course, char group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdayYear = birthdayYear;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthdayYear + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }

    public static int createStudentIdRandomly() {
        Random random = new Random();
        int minValue = 100000;
        int maxValue = 999999;
        int differanceBetweenValues = maxValue - minValue;
        return random.nextInt(differanceBetweenValues + 1) + minValue;
    }

    public static List<Student> getFilteredListOfStudents(ArrayList<Student> initialListWithStudents, Faculty faculty) {
        Stream<Student> streamFromStudentsList = initialListWithStudents.stream()
                .filter(student -> student.faculty.equals(String.valueOf(faculty)));
        return streamFromStudentsList.collect(Collectors.toList());
    }

    public static List<Student> getFilteredListOfStudents(ArrayList<Student> initialListWithStudents,
                                                                            Faculty faculty, Course course) {
        Stream<Student> streamFromStudentsList = initialListWithStudents.stream()
                .filter(student -> student.faculty.equals(String.valueOf(faculty)))
                .filter(student -> student.course.equals(String.valueOf(course)));
        return streamFromStudentsList.collect(Collectors.toList());
    }

    public static List<Student> getFilteredListOfStudents(ArrayList<Student> initialListWithStudents, int yearOfBirthday) {
        Stream<Student> streamFromStudentsList = initialListWithStudents.stream()
                .filter(student -> student.birthdayYear >= yearOfBirthday);
        return streamFromStudentsList.collect(Collectors.toList());
    }

    public static List<Student> getFilteredListOfStudents(ArrayList<Student> initialListWithStudents, Group group) {
        Stream<Student> streamFromStudentsList = initialListWithStudents.stream()
                .filter(student -> student.group == group.groupLetterAsChar);
        return streamFromStudentsList.collect(Collectors.toList());
    }

    public static void printListOfStudents(List<Student> initialListWithStudents) {
        initialListWithStudents.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Student> studentsArrayList = new ArrayList<>() {
            {
                add(new Student(Student.createStudentIdRandomly(), "Юрий", "Михайлович", "Рогозин", 2001, String.valueOf(LAW), String.valueOf(III), A.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Николай", "Юрьевич", "Швецов", 2002, String.valueOf(ECONOMIC), String.valueOf(II), E.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Юлия", "Владимировна", "Тетеря", 2000, String.valueOf(MEDIC), String.valueOf(I), B.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Вальдемар", "Соломонович", "Шилдт", 2002, String.valueOf(LAW), String.valueOf(IV), C.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Адам", "Борисович", "Шейнин", 2003, String.valueOf(MUSIC), String.valueOf(I), C.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Евгений", "Анатольевич", "Роженко", 1999, String.valueOf(MUSIC), String.valueOf(III), E.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Генадий", "Васильевич", "Марамошкин", 1998, String.valueOf(MATHEMATICS), String.valueOf(V), D.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Инокентий", "Фёдорович", "Зюзя", 2004, String.valueOf(LAW), String.valueOf(I), A.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Клавдия", "Арнольдовна", "Бабочкина", 1999, String.valueOf(BIOLOGY), String.valueOf(IV), B.groupLetterAsChar));
                add(new Student(Student.createStudentIdRandomly(), "Елизоветта", "Виссарионовна", "Шматько", 1997, String.valueOf(MEDIC), String.valueOf(V), D.groupLetterAsChar));
            }
        };

        printListOfStudents(getFilteredListOfStudents(studentsArrayList, MUSIC));
        System.out.println();
        printListOfStudents(getFilteredListOfStudents(studentsArrayList, ECONOMIC, II));
        System.out.println();
        printListOfStudents(getFilteredListOfStudents(studentsArrayList, 2001));
        System.out.println();
        printListOfStudents(getFilteredListOfStudents(studentsArrayList, A));
    }

    enum AddressCities {
        MINSK, GRODNO, BREST, GOMEL, VITEBSK
    }

    enum Faculty {
        ECONOMIC, LAW, MEDIC, MUSIC, ART, MATHEMATICS, BIOLOGY
    }

    enum Course {
        I, II, III, IV, V
    }

    enum Group {
        A('A'), B('B'), C('C'), D('D'), E('E');

        private final char groupLetterAsChar;

        Group(char groupLetterAsChar){
            this.groupLetterAsChar = groupLetterAsChar;
        }
    }
}
