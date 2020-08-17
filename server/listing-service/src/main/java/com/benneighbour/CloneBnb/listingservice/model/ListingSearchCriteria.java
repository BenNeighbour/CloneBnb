package com.benneighbour.CloneBnb.listingservice.model;

/**
 * @author Ben Neighbour
 * @created 17/08/2020
 * @project CloneBnb
 */
public class ListingSearchCriteria {

  private String key;

  private SearchOperation operation;

  private Object value;

  private boolean orPredicate;

  public ListingSearchCriteria() {}

  public ListingSearchCriteria(final String key, final SearchOperation operation, final Object value) {
    super();

    this.key = key;
    this.operation = operation;
    this.value = value;
  }

  public ListingSearchCriteria(final String orPredicate, final String key, final SearchOperation operation, final Object value) {
    super();
    this.orPredicate = orPredicate != null && orPredicate.equals(SearchOperation.OR_PREDICATE_FLAG);
    this.key = key;
    this.operation = operation;
    this.value = value;
  }

  public ListingSearchCriteria(
      String key, String operation, String prefix, String value, String suffix) {
    SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
    if (op != null) {
      if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
        final boolean startWithAsterisk =
            prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
        final boolean endWithAsterisk =
            suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

        if (startWithAsterisk && endWithAsterisk) {
          op = SearchOperation.CONTAINS;
        } else if (startWithAsterisk) {
          op = SearchOperation.ENDS_WITH;
        } else if (endWithAsterisk) {
          op = SearchOperation.STARTS_WITH;
        }
      }
    }
    this.key = key;
    this.operation = op;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public boolean isOrPredicate() {
    return orPredicate;
  }

  public void setOrPredicate(boolean orPredicate) {
    this.orPredicate = orPredicate;
  }

  public SearchOperation getOperation() {
    return operation;
  }

  public void setOperation(SearchOperation operation) {
    this.operation = operation;
  }
}
