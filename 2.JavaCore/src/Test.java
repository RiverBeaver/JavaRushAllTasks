import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list2.add("a");
        list2.add("c");
        for (String str : list1){
            System.out.println(list2.remove(str));
        }

    }
}
