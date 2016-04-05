package com.kirill.model;

import java.util.Date;

/**
 * Created by Kirill on 05.04.2016.
 */
public class Record {

    private long id;
    private boolean isIncoming;
    private Date date;
    private float amount;
    private String description;

    public Record(long id, boolean isIncoming, Date date, float amount, String description) {
        this.id = id;
        this.isIncoming = isIncoming;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;

        Record record = (Record) o;

        return id == record.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
