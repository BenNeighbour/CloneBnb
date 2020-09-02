package com.benneighbour.CloneBnb.commonlibrary;

/**
 * @author Ben Neighbour
 * @created 02/09/2020
 * @project CloneBnb
 */
public enum Status {
    ROLLBACK("ROLLBACK"),
    PENDING("PENDING"),
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    String value;

    Status(String value) {
        this.value = value;
    }
}
