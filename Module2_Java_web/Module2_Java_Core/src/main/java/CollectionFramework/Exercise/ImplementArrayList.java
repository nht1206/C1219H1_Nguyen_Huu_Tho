package CollectionFramework.Exercise;

public class ImplementArrayList<E> {
    private int size = 0;
    private static final int Default_Capacity = 10;
    private Object elements[];

    public ImplementArrayList() {
        elements = new Object[Default_Capacity];
    }

    public ImplementArrayList(int size) {
        this.size = size;
    }

    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("the index is invalid.");
        } else {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = e;
            size++;
        }
    }

    public E remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("the index is invalid.");
        } else {
            E temp = (E) elements[index];
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return temp;
        }
    }

    public int size() {
        return size;
    }

    public ImplementArrayList<E> clone() {
        ImplementArrayList<E> array = new ImplementArrayList<E>();
        for (int i = 0; i < size; i++) {
            array.add(i, (E) elements[i]);
        }
        return array;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o) {
        if (size > elements.length) {
            return false;
        } else {
            elements[size++] = o;
            return true;
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public static void main(String[] args) {
        ImplementArrayList<String> arr = new ImplementArrayList<String>();
        arr.add(0,"a");
        arr.add(1,"d");
        arr.add(2,"e");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }

        arr.add("s");
        arr.add("e");

        System.out.println("\n");
        ImplementArrayList<String> newArray = arr.clone();
        for (int i = 0; i < newArray.size(); i++) {
            System.out.print(newArray.get(i) + " ");
        }
    }
}
