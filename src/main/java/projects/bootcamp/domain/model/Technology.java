package projects.bootcamp.domain.model;

public class Technology {
    private int idTechnology;
    private String name;
    private String description;

    public Technology(int idTechnology, String name, String description) {
        this.idTechnology = idTechnology;
        this.name = name;
        this.description = description;
    }

    public int getIdTechnology() {
        return idTechnology;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIdTechnology(int idTechnology) {
        this.idTechnology = idTechnology;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
