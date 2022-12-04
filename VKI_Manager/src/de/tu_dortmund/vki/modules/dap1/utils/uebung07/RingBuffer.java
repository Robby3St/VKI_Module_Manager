package de.tu_dortmund.vki.modules.dap1.utils.uebung07;

public class RingBuffer {
    private RingBufferElement last;
    private int size;

    public RingBuffer(int n) {
        RingBufferElement first = new RingBufferElement(0);
        this.last = first;
        this.size++;
        for(int i = 1; i < n; i++) {
            RingBufferElement current = this.last.setNext(new RingBufferElement(i));
            this.size++;
        }
        this.last.setNext(first);
    }

    public Student pop() {
        Student s = this.last.getContent();
        this.last.remove();
        return s;
    }

    public Student peek() {
        return this.last.getContent();
    }

    public void push(Student s) {
        RingBufferElement current = this.last;
        if(current.isEmpty()) {
            current.setContent(s);
            return;
        }

        do {
            current = current.getNext();
        } while(!current.isEmpty() && !current.equals(last));
        throw new RuntimeException();
    }

    public int countElements() {
        RingBufferElement current = this.last.getNext();
        int count = 0;
        for(int i = 0; i < this.size; i++) {
            if(!current.isEmpty())
                count++;
            current = current.getNext();
        }

        return count;
    }
}
