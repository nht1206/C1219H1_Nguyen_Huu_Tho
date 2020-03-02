package CollectionFramework.Practice;

import java.util.Arrays;

public class ImplementList<E> {
    private int size = 0;
    private static final int Default_Capacity = 10;
    private Object elements[];

    public ImplementList() {
        elements = new Object[Default_Capacity];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e){
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E get (int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public static void main(String[] args) {
        ImplementList<Integer> listInteger = new ImplementList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

    }
}
