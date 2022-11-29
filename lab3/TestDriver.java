import java.util.Iterator;

public class TestDriver {
    public static void main(String[] args) {
        SimpleArrayList<Integer> arraylist = new SimpleArrayList<Integer>(10);
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();        

        for (int i = 0; i < 20; i++) {
            arraylist.add(i);
            linkedList.add(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(arraylist.isContain(i));
            System.out.print(linkedList.isContain(i));
        }
        System.out.println();

        System.out.println("Arraylist size: " + arraylist.size());
        System.out.println("Linkedlist size: " + linkedList.size());

        System.out.print("Arraylist: ");
        Iterator<Integer> it = arraylist.iterator();
        for (Integer integer : arraylist) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.print("Linkedlist: ");
        for (Integer integer : arraylist) {
            System.out.print(integer + " ");
        }

        System.out.println();
        System.out.print("Arraylist: ");
        for (int i = 0; i < arraylist.size(); i++) {
            System.out.print(arraylist.get(i) + " ");
        }
        System.out.println();
        System.out.print("Linkedlist: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
    }
}
