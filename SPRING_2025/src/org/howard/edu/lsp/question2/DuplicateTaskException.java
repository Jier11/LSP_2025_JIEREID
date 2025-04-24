package org.howard.edu.lspfinal.question2;

/**
 *  when adding task whose name already exists.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String taskName) {
        super("Task '" + taskName + "' already exists.");
    }
}
