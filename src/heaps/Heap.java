package heaps;

import java.util.Vector;

public class Heap {

    private final Vector<Integer> array;
    private int heapSize;

    public Heap(int[] array) {
        this.array = new Vector<Integer>(array.length);
        heapSize = array.length;
        for (int i = 0; i < array.length; i++)
            this.array.add(array[i]);
    }

    public Heap(int size) {
        this.array = new Vector<Integer>(size);
        heapSize = size;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public boolean isHeap() {
        for (int i = 2; i <= array.size(); i++) {
            if (array.get(parent(i) - 1) < array.get(i - 1))
                return false;
        }

        return true;
    }

    public void heapify(int i) {
        int largest;
        int l = left(i);
        int r = right(i);
        if (l <= heapSize && array.get(l - 1) > array.get(i - 1))
            largest = l;
        else
            largest = i;
        if (r <= heapSize && array.get(r - 1) > array.get(largest - 1))
            largest = r;
        if (largest != i) {
            exchange(i, largest);
            heapify(largest);
        }
    }

    public void exchange(int i, int largest) {
        int temp = array.get(i - 1);
        array.set(i - 1, array.get(largest - 1));
        array.set(largest - 1, temp);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        int max = 1;
        int count = 0;
        int rows = (int) Math.ceil(Math.log(array.size()) / Math.log(2.0));
        int row = 1;
        for (int i = 1; i <= array.size(); i++) {
            int y = rows - row;
            int z = (int) Math.pow(2.0, y) - 1;
            int x = count == 0 ? 5 * z - 1 : 10 * z;
            for (int j = 0; j < x; j++)
                result.append(' ');

            result.append('[');
            if (i < 10)
                result.append(' ');
            result.append(i);
            result.append(" : ");
            if (array.get(i - 1) < 10)
                result.append(' ');
            result.append(array.get(i - 1)).append(']');

            count++;
            if (count == max) {
                result.append("\n");
                count = 0;
                max *= 2;
                row++;
            } else if (row == rows && count % 2 == 0)
                result.append(' ');
        }
        result.append("\n");
        return result.toString();
    }

    public void buildHeap() {
        for (int i = array.size() / 2; i >= 1; i--)
            heapify(i);
    }

    public void heapsort() {
        buildHeap();
        for (int i = array.size(); i >= 2; i--) {
            exchange(1, i);
            heapSize--;
            heapify(1);
        }
    }

    public int[] getArray() {
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++)
            result[i] = array.get(i);
        return result;
    }

    public int extractMax() {
        if (heapSize < 1)
            throw new IllegalArgumentException("Heap underflow");

        int max = array.get(0);
        array.set(0, array.get(heapSize - 1));
        heapSize--;
        heapify(1);
        return max;
    }

    public void heapInsert(int key) {
        heapSize++;
        array.add(-1);
        int i = heapSize;
        while (i > 1 && array.get(parent(i) - 1) < key) {
            array.set(i - 1, array.get(parent(i) - 1));
            i = parent(i);
        }
        array.set(i - 1, key);
    }
}

