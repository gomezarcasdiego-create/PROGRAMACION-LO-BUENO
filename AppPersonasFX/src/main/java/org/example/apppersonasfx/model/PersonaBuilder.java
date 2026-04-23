package org.example.apppersonasfx.model;

public class PersonaBuilder {

    private String dni;
    private String name;
    private String surname;
    private String email;
    private int age;
    private String phone;

    public PersonaBuilder(String dni, String name, String surname,
                          String email, int age, String phone) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getage() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public PersonaBuilder dni(String dni) {
        this.dni = dni;
        return this;
    }

    public PersonaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonaBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PersonaBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonaBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Persona build() {
        return new Persona(dni, name, surname, age, email, phone);
    }

    public PersonaBuilder() {}
}
