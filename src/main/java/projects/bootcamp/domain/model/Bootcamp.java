package projects.bootcamp.domain.model;

import java.util.List;

public class Bootcamp {
    private int idBootcamp;
    private String name;
    private String description;
    private List<Capacity> capacityList;

    public Bootcamp() {
    }

    public Bootcamp(int idBootcamp, String name, String description, List<Capacity> capacityList) {
        this.idBootcamp = idBootcamp;
        this.name = name;
        this.description = description;
        this.capacityList = capacityList;
    }

    public List<Capacity> getCapacityList() {
        return capacityList;
    }

    public void setCapacityList(List<Capacity> capacityList) {
        this.capacityList = capacityList;
    }

    public int getIdBootcamp() {
        return idBootcamp;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIdBootcamp(int idBootcamp) {
        this.idBootcamp = idBootcamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
