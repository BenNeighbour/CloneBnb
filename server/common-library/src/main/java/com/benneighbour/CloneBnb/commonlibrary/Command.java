package com.benneighbour.CloneBnb.commonlibrary;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
public final class Command {
    public static final int MARGIN = 1000;

    public static final int BOOK_TICKET = MARGIN;
    public static final int RESERVE_SEAT = MARGIN + 1;
    public static final int MAKE_PAYMENT = MARGIN + 2;

    public static final int BOOK_TICKET_ROLLBACK = BOOK_TICKET + MARGIN;
    public static final int RESERVE_SEAT_ROLLBACK = RESERVE_SEAT + MARGIN;
    public static final int MAKE_PAYMENT_ROLLBACK = MAKE_PAYMENT + MARGIN;
}