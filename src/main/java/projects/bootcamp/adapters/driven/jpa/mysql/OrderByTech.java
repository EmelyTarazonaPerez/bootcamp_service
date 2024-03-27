package projects.bootcamp.adapters.driven.jpa.mysql;

import projects.bootcamp.domain.model.Bootcamp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrderByTech {

    public static List<Bootcamp>  getOrderByCantTech (List<Bootcamp> bootcamps, boolean direction) {
        Collections.sort(bootcamps, new Comparator<Bootcamp>() {
            @Override
            public int compare(Bootcamp objeto1, Bootcamp objeto2) {
                if (direction){
                    return Integer.compare(objeto1.getCapacityList().size(), objeto2.getCapacityList().size());
                }
                else {
                    return Integer.compare(objeto2.getCapacityList().size(), objeto1.getCapacityList().size());
                }
            }
        });
        return bootcamps;
    }
}
