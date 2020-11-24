
/**
 * 1）数组的插入、删除、按照下标随机访问操作
 * 2）int数组，不支持其它类型
 */
public class Array {
    protected int[] data;
    protected int length;

    public Array(int capacity) {
        data = new int[capacity];
        length = 0;
    }

    private boolean checkIfFull() {
        return data.length == length;
    }

    private boolean checkOutOfRange(int index) {
        return index >= length;
    }

    public int find(int index) {
        if (checkOutOfRange(index)) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index < 0) {
            return false;
        }

        if (checkIfFull()) {
            return false;
        }

        for (int i = length - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = value;
        length++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0) {
            return false;
        }

        if (checkOutOfRange(index)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
        length--;
 
        return true;
    }

    public void printAll() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 1);
        array.insert(0, 0);
        array.insert(2, 2);
        array.insert(3, 4);
        array.insert(3, 3);
        array.insert(3, 4);
        array.insert(4, 4);
        // array.delete(3);
        // array.delete(0);
        // System.out.println(array.find(0));
        array.printAll();
    }
}
