package MidtermSprint;

public class TaskList {
    public TaskNode head;
    public TaskNode tail;
    public int size;

    // Create tasklist with single linked list
    public TaskNode createList(String description) {
        TaskNode taskNode = new TaskNode();
        taskNode.task = new Task(description);
        taskNode.next = null;
        head = taskNode;
        tail = taskNode;
        size = 1;
        return head;
    }

    // Add a task to list
    public void addTask(String description) {
        TaskNode newNode = new TaskNode();
         newNode.task = new Task(description);

        // If list is empty
        if(head == null) {
            createList(description);
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // Mark task as completed
    public void markAsCompleted(String description) {
        TaskNode tempNode = head;
        while(tempNode != null) {
            if(tempNode.task.getDescription().equals(description)) {
                tempNode.task.markAsComplete();
                return;
            } else {
                tempNode = tempNode.next;
            }
        }
    }

    // Print all tasks
    public void printAllTasks() {
        TaskNode tempNode = head;
        while(tempNode != null) {
            System.out.println(tempNode.task.getDescription() + " -> " + tempNode.task.isCompleted());
            tempNode = tempNode.next;
        }
    }
};
