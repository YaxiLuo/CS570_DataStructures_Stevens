package IDLList;

public class IDLListTest extends IDLList {
	public static void main(String[] args) {
        IDLList<Integer> d = new IDLList<>();
        for (int i = 0; i < 10; i++) {
            d.add(i);
        }
        System.out.println(d);

        System.out.println();

        d.add(6, 6);
        System.out.println("Element equals to 4 " + d.get(6));
        d.add(7, 49);
        System.out.println("Element equals to 49 " + d.get(7));
        d.add(0, 99);
        System.out.println("Element equals to 99 " + d.get(0));

        System.out.println();

        System.out.println(d);
        System.out.println("remove element 49: " + d.remove(49));
        System.out.println(d);
        System.out.println("remove  element 999: " + d.remove(999));
        System.out.println(d);

        System.out.println();


        int newId = d.size() - 1;
        d.add(newId, 98);
        System.out.println("Element equals 98: " + d.get(newId));
        System.out.println(d);

        System.out.println();

        System.out.println(d.size());
        d.append(100);
        System.out.println("Element equals 100:  " + d.get(d.size() - 1));
        System.out.println(d);
        System.out.println(d.size());

        System.out.println();

        System.out.println("Element equals to: " + d.get(6) + " -> " + d.removeAt(6));

        System.out.println();

        int del = d.size();
        for (int i = del - 1; i >= 0; i--) {
            System.out.println(" Element removed at index: " + d.removeAt(i));
            // System.out.println(d)
        }

        for (int i = 100; i < 111; i++) {
            d.append(i);
        }
        System.out.println(d);

    }


}
