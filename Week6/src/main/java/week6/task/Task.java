/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package week6.task;


import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author aoife
 */
public class Task implements Comparable<Task> {

private String owner;
private String description;
private LocalDate deadline;
/**
 * Creates a new Task with an owner, description and deadline 
 * @param owner the owner of the task
 * @param description the description of the task
 * @param deadline the deadline for the task
 * @throws IllegalArgumentException if the deadline is before the current date
 */
    public Task(String owner, String description, LocalDate deadline) {
        if(deadline.compareTo(LocalDate.now())<0){
            throw new IllegalArgumentException("Deadline cant be before the current time!");
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
        if(deadline.compareTo(LocalDate.now())<0){
            throw new IllegalArgumentException("Deadline cant be before the current time!");
        }
        this.deadline = deadline;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.owner); 
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.deadline);
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
        return Objects.equals(this.deadline, other.deadline);
    }

    @Override
    public String toString() {
        return "Task{" + "owner=" + owner + ", description=" + description + ", deadline=" + deadline + '}';
    }

   @Override
    public int compareTo(Task otherTask) {
        // Compare by deadline first
        int deadlineComparison = this.deadline.compareTo(otherTask.getDeadline());
        if (deadlineComparison != 0) {
            return deadlineComparison;
        }

        // If deadline is the same, compare by owner
        int ownerComparison = this.owner.compareTo(otherTask.getOwner());
        if (ownerComparison != 0) {
            return ownerComparison;
        }

        // If owner is the same, compare by description
        return this.description.compareTo(otherTask.getDescription());
    }


}

