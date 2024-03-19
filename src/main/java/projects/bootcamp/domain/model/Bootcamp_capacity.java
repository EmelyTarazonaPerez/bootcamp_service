package projects.bootcamp.domain.model;

public class Bootcamp_capacity {
    private int id_bootcamp_capacity;
    private int bootcamp_id_bootcamp;
    private int capacity_id_capacity;

    public Bootcamp_capacity(int id_bootcamp_capacity, int bootcamp_id_bootcamp, int capacity_id_capacity) {
        this.id_bootcamp_capacity = id_bootcamp_capacity;
        this.bootcamp_id_bootcamp = bootcamp_id_bootcamp;
        this.capacity_id_capacity = capacity_id_capacity;
    }

    public int getId_bootcamp_capacity() {
        return id_bootcamp_capacity;
    }

    public int getBootcamp_id_bootcamp() {
        return bootcamp_id_bootcamp;
    }

    public int getCapacity_id_capacity() {
        return capacity_id_capacity;
    }

    public void setId_bootcamp_capacity(int id_bootcamp_capacity) {
        this.id_bootcamp_capacity = id_bootcamp_capacity;
    }

    public void setBootcamp_id_bootcamp(int bootcamp_id_bootcamp) {
        this.bootcamp_id_bootcamp = bootcamp_id_bootcamp;
    }

    public void setCapacity_id_capacity(int capacity_id_capacity) {
        this.capacity_id_capacity = capacity_id_capacity;
    }
}
