package com.benneighbour.CloneBnb.commonlibrary;

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
public class Message implements Serializable {

    private static final long serialVersionUID = -1146780520012585159L;

    private UUID id;

    private String content;

    private int command;

    private String route;

    private boolean isAsync;

    private boolean isFinished;

    public Message(String content, int command, String route) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.command = command;
        this.route = route;
    }

    public void setRollbackCommand(int command) {
        this.command = command + Command.MARGIN;
    }

}