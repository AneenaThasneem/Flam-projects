import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    DoublyLinkedListNode head=new DoublyLinkedListNode(-1,-1);
    DoublyLinkedListNode tail=new DoublyLinkedListNode(-1,-1);
   Map<Integer,DoublyLinkedListNode> map=new HashMap<>();
   int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

   public int get(int key){
        if(!map.containsKey(key)){
          return -1;
        }
        DoublyLinkedListNode node=map.get(key);
        deleteNode(node);
        insert(node);
        return node.value;
   }
   public void put(int key,int value){
       if (map.containsKey(key)) {
           DoublyLinkedListNode node=map.get(key);
           deleteNode(node);

       }
       if (map.size() == capacity) {
           if(capacity==0){
               System.out.println("the given operation is beyond the current capacity");
               return;
           }
           deleteNode(tail.prev);
       }
       DoublyLinkedListNode newNode=new DoublyLinkedListNode(key, value);

       insert(newNode);
   }

    public void insert(DoublyLinkedListNode node){
        map.put(node.key,node);
      DoublyLinkedListNode nextNode=head.next;
      head.next=node;
      node.next=nextNode;
      nextNode.prev=node;
      node.prev=head;


  }
public void deleteNode(DoublyLinkedListNode node)  {

        map.remove(node.key);
DoublyLinkedListNode nodeBefore=node.prev;
DoublyLinkedListNode nodeAfter=node.next;
nodeBefore.next=nodeAfter;
nodeAfter.prev=nodeBefore;

}

}
class DoublyLinkedListNode{
    int key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key,int value) {
        this.key=key;
        this.value = value;
        this.prev=null;
        this.next=null;
    }


}