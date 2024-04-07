package projects.bootcamp.adapters.driven.jpa.mysql.utils;

import lombok.AllArgsConstructor;
import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public class OrderByTech {
    private OrderByTech() {
        throw new IllegalStateException("Utility class");
    }
    public static List<Bootcamp>  getOrderByCantCapacity (List<Bootcamp> bootcamp, boolean direction) {
        bootcamp.sort((objeto1, objeto2) -> {
            if (direction) {
                return Integer.compare(objeto1.getCapacityList().size(), objeto2.getCapacityList().size());
            } else {
                return Integer.compare(objeto2.getCapacityList().size(), objeto1.getCapacityList().size());
            }
        });
        return bootcamp;
    }

    public static List<Capacity>  getOrderByCantTech (List<Capacity> capacities, boolean direction) {
        capacities.sort((objeto1, objeto2) -> {
            if (direction) {
                return Integer.compare(objeto1.getTechnologyList().size(), objeto2.getTechnologyList().size());
            } else {
                return Integer.compare(objeto2.getTechnologyList().size(), objeto1.getTechnologyList().size());
            }
        });
        return capacities;
    }
}
