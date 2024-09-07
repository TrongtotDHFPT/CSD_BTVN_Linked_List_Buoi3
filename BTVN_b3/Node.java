package BTVN_b3;

public class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
    public Node()
    {

    }
    public Node(int data, Node next)
    {
        this.data= data;
        this.next = null; //trỏ tới vị trí kế tiếp : mặc định là null
    }
    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
    public void setData(int data)
    {
        this.data =data;
    }
}
