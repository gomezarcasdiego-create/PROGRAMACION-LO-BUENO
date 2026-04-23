package org.example.apppersonasfx.model;

public class Persona {

    private String dni;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String phone;

    public Persona(String dni, String name, String surname, String email,
                   int age, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public Persona(PersonaBuilder builder) {

        this.dni = builder.getDni();
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.email = builder.getEmail();
        this.age = builder.getage();
        this.phone = builder.getPhone();
    }

    public Persona() {}

    public Persona(String dni, String name, String surname, int age,
                   String email, String phone) {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static PersonaBuilder builder(){
        return new PersonaBuilder();
    }
}
