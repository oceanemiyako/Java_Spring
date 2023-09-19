package com.example.exo1.models;

public class Person {
        private String name;

        private String lastname;
        private String email;

        public Person(String name, String lastname, String email) {
            this.name = name;
            this.email = email;
            this.lastname = lastname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

