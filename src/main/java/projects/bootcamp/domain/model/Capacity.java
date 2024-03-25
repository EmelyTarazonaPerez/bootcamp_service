package projects.bootcamp.domain.model;

import java.util.List;
import java.util.Set;

public class Capacity {
    private int idCapacity;
    private String name;
    private String description;
    private List<Technology> technologyList;

    public Capacity() {
    }

    public Capacity(int idCapacity, String name, String description, List<Technology> technologyList) {
        this.idCapacity = idCapacity;
        this.name = name;
        this.description = description;
        this.technologyList = technologyList;
    }
    public int getIdCapacity() {
        return idCapacity;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setIdCapacity(int idCapacity) {
        this.idCapacity = idCapacity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Technology> getTechnologyList() { return technologyList; }
    public void setTechnologyList(List<Technology> technologyList) { this.technologyList = technologyList; }
}
