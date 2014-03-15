package com.android.ceehacktrust.app;

/**
 * Created by Primosz on 15.03.14.
 */
public class Politic {

    /**
     * Politics name
     */
    @com.google.gson.annotations.SerializedName("name")
    private String name;

    /**
     * Politics Surname
     */
    @com.google.gson.annotations.SerializedName("surname")
    private boolean surname;

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;



    /**
     * Politic constructor
     */
    public Politic() {

    }

    /**
     * Initializes a new ToDoItem
     *
     * @param name The name of politic
     * @param surname The surname of politic
     */
    public Politic(String name, String surname) {
        this.setId(surname);
    }

    @Override
    public String toString() {
        return name + " "  + surname;
    }


    /**
     * Returns the politic id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the politic id
     *
     * @param id id to set
     */
    public final void setId(String id) {
        mId = id;
    }


    @Override
    public boolean equals(Object o) {
        return o instanceof Politic && ((Politic) o).mId == mId;
    }

}
