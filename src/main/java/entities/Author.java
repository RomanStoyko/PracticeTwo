package entities;

import entities.abstracts.BookList;


public class Author extends BookList {

    private String firstName;
    private String secondName;

    public Author() {
    }

    public Author(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    @Override
    public String toString() {
        return secondName + " " + firstName.charAt(0) + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Author author = (Author) obj;
        if (!this.firstName.equals(author.firstName)) {
            return false;
        }
        return this.secondName.equals(author.secondName);
    }

    @Override
    public int hashCode() {
        int result = 18;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }
}
