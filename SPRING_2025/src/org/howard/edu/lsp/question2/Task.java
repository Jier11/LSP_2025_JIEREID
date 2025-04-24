package org.howard.edu.lspfinal.question2;

/**
 * Represents task with name, priority, and status.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
    public String getName() { return name; }
    public int getPriority() { return priority; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Task{name='%s', priority=%d, status='%s'}",
                             name, priority, status);
    }
}
