package projects.bootcamp.domain.model;

public class Capacity {
    private int id_capacity;
    private String name;
    private String description;
    private String row_3;

    public Capacity(int id_capacity, String name, String description, String row_3) {
        this.id_capacity = id_capacity;
        this.name = name;
        this.description = description;
        this.row_3 = row_3;
    }

    public int getId_capacity() {
        return id_capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRow_3() {
        return row_3;
    }

    public void setId_capacity(int id_capacity) {
        this.id_capacity = id_capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRow_3(String row_3) {
        this.row_3 = row_3;
    }
}
