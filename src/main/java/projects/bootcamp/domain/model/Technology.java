package projects.bootcamp.domain.model;

public class Technology {
    private int id_technology;
    private String name;
    private String description;

    public Technology(int id_technology, String name, String description) {
        this.id_technology = id_technology;
        this.name = name;
        this.description = description;
    }

    public int getId_technology() {
        return id_technology;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId_technology(int id_tecnology) {
        this.id_technology = id_tecnology;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
