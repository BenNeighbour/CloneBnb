package com.benneighbour.CloneBnb.commonlibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ben Neighbour
 * @created 02/09/2020
 * @project CloneBnb
 */
@Setter
@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MessageDTO {

    private String command;

    private String source;

    private String destination;

    private Status status;

    public MessageDTO() {}


    @Override
    public String toString() {
        return "MessageDTO{" +
                "command='" + command + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", status=" + status +
                '}';
    }
}
