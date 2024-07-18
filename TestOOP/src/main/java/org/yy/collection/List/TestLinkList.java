package org.yy.collection.List;

public class TestLinkList {
    Node first;
    Node last;
    int count;

    public TestLinkList() {
    }

    // 添加元素
    public void add(Object obj) {
        Node node = new Node();
        if (first == null) {
            // 添加的元素是第一个节点，将添加的元素封装为node对象
            node.setPre(null);
            node.setCur(obj);
            node.setNext(null);
            // 链中第一个节点、最后一个节点指向node
            this.first = node;
        } else {
            node.setPre(this.last);
            node.setCur(obj);
            node.setNext(null);
            this.last.setNext(node);
        }
        this.last = node;
        count++;
    }

    public int getCount(){
        return count;
    }

    public Object get(int index){
        // 链表的头节点
        Node n=first;
        for (int i = 0; i < index; i++) {
            n=n.getNext();
        }
        return n.getCur();
    }

    public static void main(String[] args) {
        TestLinkList list = new TestLinkList();
        list.add(111);
        list.add("hhhh");
        list.add("ttt");
        System.out.println(list.getCount());
        System.out.println(list.get(2));
    }
}

class Node {
    private Node pre;
    private Object cur;
    private Node next;

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Object getCur() {
        return cur;
    }

    public void setCur(Object cur) {
        this.cur = cur;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "pre=" + pre +
                ", cur=" + cur +
                ", next=" + next +
                '}';
    }
}
