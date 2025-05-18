package estrutura_dados;

public class Fila {
    private Node head;
    private Node tail;

    private static class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

    }

    private int size = 0;

    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }


    public String[] toArray() {
        if (head == null) {
            return null;
        }

        Node current = head;

        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }

        return array;
    }
}