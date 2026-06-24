package com.example.InsurTech.util;
import com.example.InsurTech.util.entityFilter.Filter;
import com.example.InsurTech.util.entityFilter.SortOrder;
import org.springframework.data.domain.*;

public class FilterUtil {

    public static Pageable toPageable(Filter filter) {

        int page = (filter.getPage() == null || filter.getPage() < 1)
                ? 0
                : filter.getPage() - 1;

        int limit = (filter.getLimit() == null) ? 10 : filter.getLimit();

        Sort sort = Sort.unsorted();

        if (filter.getSortBy() != null && !filter.getSortBy().isEmpty()) {

            Sort.Direction direction =
                    (filter.getSortOrder() == SortOrder.DESC)
                            ? Sort.Direction.DESC
                            : Sort.Direction.ASC;

            sort = Sort.by(direction, filter.getSortBy());
        }

        return PageRequest.of(page, limit, sort);
    }
}