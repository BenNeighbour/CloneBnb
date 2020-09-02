package com.benneighbour.CloneBnb.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Ben Neighbour
 * @created 31/08/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse implements Serializable {

    private static final long serialVersionUID = -972572774116003964L;

    private STATUS STATUS;

    private String MESSAGE;

    public enum STATUS {
        SUCCESS,
        ERROR
    }

}
