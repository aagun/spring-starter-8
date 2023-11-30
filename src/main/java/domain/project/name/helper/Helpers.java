package domain.project.name.helper;

import domain.project.name.dto.RequestPageableDefault;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Helpers {

    public static Sort.Direction setOrder(String order) {
        String orderBy = Objects.toString(order, "").toUpperCase();
        return List.of(Sort.Direction.ASC.toString(), Sort.Direction.DESC.toString())
                .contains(orderBy) ? Sort.Direction.valueOf(orderBy) : Sort.Direction.ASC;
    }

    public static String setSort(String sort, String defaultField, Map<String, String> mappedFileds) {
        String key = Objects.toString(sort, "").toLowerCase();
        return mappedFileds.getOrDefault(key, defaultField);
    }

    public static Pageable setPageable(RequestPageableDefault page, Map<String, String> mappedFields) {
        Sort sort = Sort.by(setOrder(page.getOrder()), setSort(page.getSort(), page.getDefaultSort(), mappedFields));
        return PageRequest.of(page.getOffset(), page.getLimit(), sort);
    }
}
