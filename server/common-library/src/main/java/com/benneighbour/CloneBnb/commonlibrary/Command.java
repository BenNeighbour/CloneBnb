package com.benneighbour.CloneBnb.commonlibrary;

/**
 * @author Ben Neighbour
 * @created 30/08/2020
 * @project CloneBnb
 */
public final class Command {
    public static final int MARGIN = 1000;

    // STEP 1
    public static final int VERIFY_LISTING_FOR_BOOK = MARGIN;

    // STEP 2
    public static final int BOOK_STAY = MARGIN + 1;

    // STEP 3
    public static final int UPDATE_LISTING_FOR_BOOK = MARGIN + 2;

    // Rollback margins
    public static final int VERIFY_LISTING_FOR_BOOK_ROLLBACK = VERIFY_LISTING_FOR_BOOK + MARGIN;
    public static final int BOOK_STAY_ROLLBACK = BOOK_STAY + MARGIN;
    public static final int UPDATE_LISTING_FOR_BOOK_ROLLBACK = UPDATE_LISTING_FOR_BOOK + MARGIN;
}