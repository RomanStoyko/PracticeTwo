package entities;

import entities.abstracts.BookList;


public class Publisher extends BookList {
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Publisher publisher = (Publisher) obj;
        return this.name.equals(publisher.name);

    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 31 * result + name.hashCode();
        return result;
    }
}
