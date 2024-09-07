package BTVN_b3;
public class MyLinkedList {

    private Node head;

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            newNode = head;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // add vị trí bất kì b2
    public void add(int data, int index){
        Node newNode = new Node(data);
       if(index == 0){
        addFirst(data);
       }else if(index < 0){
        System.out.println("Error varibale index");
       }
        Node temp = head;
        for(int i = 0; i < index - 1  ; i++) // index - 1 
        {
            temp = temp.next;
        }
        Node temptemp = temp.next;
        temp.next = newNode;
        newNode.next = temptemp;
        
    }
    //BTVN b2 
    //1.public int length()

    public int length(){
        int count = 1;
        if(head == null){
            return 0;
        }else
        {
            
            Node temp = head;
            while (temp.next!=null) {
                count ++;
                temp = temp.next;
            }
        }
        return count;
    }
    //2.display
    
    public void display()
    {
        Node temp = head;
        if(temp.next == null)
            System.out.println("My LinkedList :" +temp);
        while (temp.next != null) {
            System.out.print(temp.getData()+"->");
            temp = temp.next;
            if(temp.next == null)
                System.out.print(temp.getData());
        }
        System.out.println();
    }


    //3.deleteFirst
    public void deleteFirst(){
        head = head.next;
    }



    //BUỔI 3 
    //1.Xóa LastIndex
    public void deleteLast(){
        if (head == null) {
            return;
        }
        if(head.next == null){
            deleteFirst();
        }
        Node temp = head;
        Node Previous = null; //chạy sau temp lưu lại giá trị team vừa đi qua

        while(temp.next != null){
            Previous = temp;
            temp = temp.next; //hết vòng while này temp sẽ là node cuối cùng 
        }
        Previous.next= null;
    }

    //2.Xóa node vị trí bất kì
    public void delete(int index){
        if(index <0)
            System.out.println("Error value variable index");
        if(index == 0)
            deleteFirst();
        if(index == length() - 1)
            deleteLast();
        Node preNodeDelete = head;
        for(int i = 0; i < index ;i++){
            preNodeDelete = preNodeDelete.next; // hết vòng này Pre đứng trước inxdex cần xóa
        }
        preNodeDelete.next = preNodeDelete.next.next; // 1->2->3   (lấy 1 nối vô 3)
    }

    //3.boolean searchh
    public boolean search(int data){
        Node temp = head;
        if(head ==null){
            return false;
        }
        while(temp!= null){
            if(temp.getData() == data)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //4.sort tại 1 vị trí
    public Node searchAtPosition(int index){
        if(index < 0 || index >= length()){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }



    
    //BTVN buổi 3 
    //Viết hàm sort tăng dần 
    public void sort() {
        if (head == null) {
            return;
        }
        int n ;
        int flag ;
        do {
            Node temp = head;
            flag = 0;
            while (temp.next != null) {
                if (temp.getData() > temp.next.getData()) {
                    n =temp.getData();
                    temp.setData(temp.next.getData());
                    temp.next.setData(n);
                    flag= 1; 
                }
                temp = temp.next;
            }
        } while (flag == 1); 
    }

    // viết hàm delete theo while
    public void deleteWhile(int index){
        int count = 0;
        if(index <0)
            System.out.println("Error value variable index");
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == length() - 1){
            deleteLast();
            return;
        }
        Node preNodeDelete = head;
        while(count < index -1 ){
            preNodeDelete = preNodeDelete.next;
            count++;
        }
        preNodeDelete.next = preNodeDelete.next.next;
    }
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(8);
        linkedList.addFirst(6);
        linkedList.addFirst(20);
        linkedList.addLast(73);
        linkedList.addLast(36);
        linkedList.addLast(3);
        linkedList.addLast(12);
        System.out.print("Star :");
        linkedList.display();  
        System.out.println("After adding new Node");
        linkedList.add(100, 4);
        linkedList.display();      
        System.out.println("Length of LinkedList :"+linkedList.length());
        System.out.println("After deleting First Node");
        linkedList.deleteFirst();
        linkedList.display();
        System.out.println("After delete Last Index ");
        linkedList.deleteLast();
        linkedList.display();
        System.out.println("Result Searching data " +linkedList.search(30));

        System.out.println("Result searchAtPosition "+linkedList.searchAtPosition(3).getData());

        //6->8->10->100->36 
        System.out.println("Output BTVN buổi 3 :");
        System.out.print("Sort tăng dần :");
        linkedList.sort();
        linkedList.display();
        linkedList.deleteWhile(3);
        linkedList.display();
        
    }
}
