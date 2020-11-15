package algo.chapter_05_array;

public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }
    // 获取当前元素个数
    public int count() {
        return size;
    }
    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 修改index位置的元素
    public void set(int index, T e) {
        checkOutOfRange(index);
        data[index] = e;
    }
    // 获取index位置的元素
    public T get(int index) {
        checkOutOfRange(index);
        return data[index];
    }
    // contains
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    // find，获取对应下标
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    // add
    public void add(int index, T e) {
        checkOutOfRangeForAdd(index);
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    // 头插
    public void addFirst(T e) {
        add(0, e);
    }
    // 尾插
    public void addLast(T e) {
        add(size, e);
    }
    // remove指定位置的元素，并返回
    public T remove(int index) {
        checkOutOfRange(index);
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        // 缩容(1/4时缩容)
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    // 删除first
    public T removeFirst() {
        return remove(0);
    }
    // 删除last
    public T removeLast() {
        return remove(size - 1);
    }
    // remove指定element
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }
    // 重写toString
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
    // 扩容方法resize
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    private void checkOutOfRange(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("out of range for set/get/remove");
        }
    }
    private void checkOutOfRangeForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("out of range for add");
        }
    }

    public static void main(String[] args) {
        GenericArray<Integer> intArray = new GenericArray<>(5);
        intArray.add(0, 1);
        intArray.add(0, 0);
        intArray.add(2, 2);
        intArray.add(3, 4);
        intArray.add(3, 3);
        intArray.set(4, 3);
        intArray.add(5, 5);
        System.out.println(intArray);
        
        intArray.remove(2);
        intArray.removeFirst();
        intArray.removeLast();
        System.out.println(intArray);

        intArray.removeLast();
        System.out.println(intArray);
    }
}
