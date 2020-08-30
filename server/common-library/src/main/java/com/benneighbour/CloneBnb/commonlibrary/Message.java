package com.benneighbour.CloneBnb.commonlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = -1146780520012585159L;

    private UUID id = UUID.randomUUID();

    private String content;

    private int command;

    private String route;

    private boolean isAsync;

    private boolean isFinished;

    public void setRollbackCommand(int command) {
        this.command = command + Command.MARGIN;
    }

}