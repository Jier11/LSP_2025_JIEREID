package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages adding, retrieving, updating, and printing tasks.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds new task. If name already exists, DuplicateTaskException.
     */
    public void addTask(String name, int priority, String status)
            throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(name);
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves task by name, or TaskNotFoundException.
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) throw new TaskNotFoundException(name);
        return t;
    }

    /**
     * Updates status of existing task, or TaskNotFoundException.
     */
    public void updateStatus(String name, String newStatus)
            throws TaskNotFoundException {
        Task t = getTaskByName(name);
        t.setStatus(newStatus);
    }

    /**
     * Prints tasks by status: 
     * TODO, IN_PROGRESS, DONE.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            for (Task t : tasks.values()) {
                if (t.getStatus().equals(status)) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}
