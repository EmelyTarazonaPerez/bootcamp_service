package projects.bootcamp.domain.model;

import java.time.LocalDate;

public class Version {
    private int idVersion;
    private LocalDate startDate;
    private LocalDate endDate;
    private int cupMaxParticipant;
    private Bootcamp bootcamp;
    private String name;

    public Version(int idVersion, LocalDate startDate, LocalDate endDate, int cupMaxParticipant, Bootcamp bootcamp, String name) {
        this.idVersion = idVersion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cupMaxParticipant = cupMaxParticipant;
        this.bootcamp = bootcamp;
        this.name = name;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCupMaxParticipant() {
        return cupMaxParticipant;
    }

    public void setCupMaxParticipant(int cupMaxParticipant) {
        this.cupMaxParticipant = cupMaxParticipant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }
}
