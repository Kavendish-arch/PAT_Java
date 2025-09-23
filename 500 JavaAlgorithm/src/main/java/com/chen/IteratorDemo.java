
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator<String> listIter = list.iterator();

        while (listIter.hasNext()) {
            Object elem = listIter.next();

            // System.out.println("elem: " + elem);
            if ("b".equals(elem)) {
                listIter.remove();
                // listIter.set("B");
            }

        }
        listIter = list.iterator();
        while (listIter.hasNext()) {
            Object elem = listIter.next();

            System.out.println("elem: " + elem);

        }

    }

    public static void ListIteratorMain(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ListIterator<String> listIter = list.listIterator();

        while (listIter.hasNext()) {
            Object elem = listIter.next();

            System.out.println("elem: " + elem);
            if ("b".equals(elem)) {
                listIter.set("B");
            }

        }
        while (listIter.hasPrevious()) {
            Object elem = listIter.previous();

            System.out.println(elem);

        }
    }

}
