package projects.bootcamp.adapters.driven.jpa.mysql;

import projects.bootcamp.domain.model.Bootcamp;
import projects.bootcamp.domain.model.Capacity;

import java.util.List;

public class OrderByTech {

    public static List<Bootcamp>  getOrderByCantCapacity (List<Bootcamp> bootcamps, boolean direction) {
        bootcamps.sort((objeto1, objeto2) -> {
            if (direction) {
                return Integer.compare(objeto1.getCapacityList().size(), objeto2.getCapacityList().size());
            } else {
                return Integer.compare(objeto2.getCapacityList().size(), objeto1.getCapacityList().size());
            }
        });
        return bootcamps;
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
