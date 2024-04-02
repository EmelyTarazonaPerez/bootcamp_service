package projects.bootcamp.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Version {
    private int idVersion;
    private LocalDate startDate;
    private LocalDate endDate;
    private int cupMaxParticipant;
    private List<Bootcamp> bootcampList;

    public Version(int idVersion, LocalDate startDate, LocalDate endDate, int cupMaxParticipant, List<Bootcamp> bootcampList) {
        this.idVersion = idVersion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cupMaxParticipant = cupMaxParticipant;
        this.bootcampList = bootcampList;
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

    public List<Bootcamp> getBootcampList() {
        return bootcampList;
    }

    public void setBootcampList(List<Bootcamp> bootcampList) {
        this.bootcampList = bootcampList;
    }
}
