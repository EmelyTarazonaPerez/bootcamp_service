package projects.bootcamp.domain.model;

public class Bootcamp {
    private int id_bootcamp;
    private String name;
    private String descrption;

    public Bootcamp(int id_bootcamp, String name, String descrption) {
        this.id_bootcamp = id_bootcamp;
        this.name = name;
        this.descrption = descrption;
    }

    public int getId_bootcamp() {
        return id_bootcamp;
    }

    public String getName() {
        return name;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setId_bootcamp(int id_bootcamp) {
        this.id_bootcamp = id_bootcamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
