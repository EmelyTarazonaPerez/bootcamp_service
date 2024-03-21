package projects.bootcamp.domain.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology that)) return false;
        return getIdTechnology() == that.getIdTechnology() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTechnology(), getName(), getDescription());
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
