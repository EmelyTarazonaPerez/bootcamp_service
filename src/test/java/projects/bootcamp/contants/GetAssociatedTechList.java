package projects.bootcamp.contants;

import projects.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import projects.bootcamp.domain.model.Technology;

import java.util.ArrayList;
import java.util.List;

public  class GetAssociatedTechList {
    public static List<TechnologyEntity> getTechnologyEntityList() {
        TechnologyEntity technology1 = new TechnologyEntity(1, "Java1", "Any description", null);
        TechnologyEntity technology2 = new TechnologyEntity(2, "Java2", "Any description", null);
        TechnologyEntity technology3 = new TechnologyEntity(3, "Java3", "Any description", null);

        List<TechnologyEntity> technologyEntitylist = new ArrayList<>();
        technologyEntitylist.add(technology1);
        technologyEntitylist.add(technology2);
        technologyEntitylist.add(technology3);
        return technologyEntitylist;
    }

    public static List<Technology> getTechnologyList() {
        Technology technology1 = new Technology(1, "Java1", "Any description");
        Technology technology2 = new Technology(2, "Java2", "Any description");
        Technology technology3 = new Technology(3, "Java3", "Any description");

        List<Technology> technologyList = new ArrayList<>();
        technologyList.add(technology1);
        technologyList.add(technology2);
        technologyList.add(technology3);
        return technologyList;
    }

}
