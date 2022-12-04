package de.tu_dortmund.vki.modules.dap1.utils.uebung07;

public class RingBufferElement {
    private Student content;
    private RingBufferElement next;
    private int id;

    public RingBufferElement(int id) {
        this.id = id;
    }

    public RingBufferElement setNext(RingBufferElement next) {
        return this.next = next;
    }

    public RingBufferElement getNext() {
        return this.next;
    }

    public void setContent(Student s) {
        this.content = s;
    }

    public Student getContent() {
        return this.content;
    }

    public void remove() {
        this.content = null;
    }

    public boolean isEmpty() {
        return this.content == null;
    }

    public int getId() {
        return this.id;
    }

    public boolean equals(RingBufferElement other) {
        return other.getId() == this.id;
    }
}
