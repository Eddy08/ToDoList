package com.Harsh.DataModel;

import java.time.LocalDate;

public class ToDoItem {
    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public ToDoItem ( String shortDescription, String details, LocalDate deadline ) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public void setShortDescription ( String shortDescription ) {
        this.shortDescription = shortDescription;
    }

    public void setDetails ( String details ) {
        this.details = details;
    }

    public void setDeadline ( LocalDate deadline ) {
        this.deadline = deadline;
    }

    public String getShortDescription () {
        return shortDescription;
    }

    public String getDetails () {
        return details;
    }

    public LocalDate getDeadline () {
        return deadline;
    }

    @Override
    public String toString () {
        return shortDescription;
    }
}
