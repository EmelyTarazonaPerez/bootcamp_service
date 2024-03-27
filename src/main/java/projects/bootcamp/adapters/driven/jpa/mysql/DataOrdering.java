package projects.bootcamp.adapters.driven.jpa.mysql;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class DataOrdering {
    public  static Pageable getOrdering (int page, int size, boolean order) {
        Sort.Order orderPageable = order ? Sort.Order.desc("name") : Sort.Order.asc("name");
        Sort sort = Sort.by(orderPageable);
        return PageRequest.of(page, size, sort);
    }

}
