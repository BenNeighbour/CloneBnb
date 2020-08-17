package com.benneighbour.CloneBnb.listingservice.model;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ben Neighbour
 * @created 17/08/2020
 * @project CloneBnb
 */
public final class ListingSpecificationBuilder {

    private final List<ListingSearchCriteria> params;

    public ListingSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public final ListingSpecificationBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final ListingSpecificationBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) {
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new ListingSearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<Listing> build() {
        if (params.size() == 0)
            return null;

        Specification<Listing> result = new ListingSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i).isOrPredicate()
                    ? Specification.where(result).or(new ListingSpecification(params.get(i)))
                    : Specification.where(result).and(new ListingSpecification(params.get(i)));
        }

        return result;
    }

    public final ListingSpecificationBuilder with(ListingSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final ListingSpecificationBuilder with(ListingSearchCriteria criteria) {
        params.add(criteria);
        return this;
    }

}