package org.howard.edu.lspfinal.question2;

/**
 *  when requested task is not found.
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String taskName) {
        super("Task '" + taskName + "' not found.");
    }
}
