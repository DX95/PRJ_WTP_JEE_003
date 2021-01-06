package domain;

import java.io.Serializable;

public class trippicture implements Serializable {

    private int id;
    private String name;

    @Override
    public String toString() {
        return "trippicture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
