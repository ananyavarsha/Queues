import java.util.EmptyStackException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        ListNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void enqueue(int value) {
        ListNode temp = new ListNode(value);
        if (rear == null) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        length--;
        return value;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(12);
        q.display();
        q.dequeue();
        q.display();
    }
}
