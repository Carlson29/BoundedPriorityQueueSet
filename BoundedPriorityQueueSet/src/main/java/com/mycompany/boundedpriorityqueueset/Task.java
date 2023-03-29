/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.boundedpriorityqueueset;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Task {
    private String owner;
    private String description;
    private LocalDate deadline;

    public Task(String owner, String description, LocalDate deadline) {
        if(deadline.compareTo(LocalDate.now())<=0){
            throw new DateTimeException("The date is before current date or it's current date");
        }
        this.owner = owner;
        this.description = description;
        this.deadline = deadline;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if(deadline.compareTo(LocalDate.now())<=0){
            throw new DateTimeException("The date is before current date or it's current date");
        }
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.owner);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + ", deadline=" + deadline + '}';
    }
    
    
   
}
