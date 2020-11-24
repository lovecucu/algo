public class ArrayAlgo {
    public GenericArray<Integer> merge(GenericArray<Integer> num1, GenericArray<Integer> num2) {
        for (int i = 0; i < num2.count(); i++) {
            for (int j = 0; j < num1.count(); j++) {
                if (num2.get(i) >= num1.get(j)) {
                    num1.add(j, num2.get(i));
                    break;
                }
            }
        }
        return num1;
    }

    public static void main(String[] args) {
        ArrayAlgo arrayAlgo = new ArrayAlgo();
        GenericArray<Integer> num1 = new GenericArray<Integer>(3);
        num1.add(0, 0);
        num1.add(1, 3);
        num1.add(2, 5);
        GenericArray<Integer> num2 = new GenericArray<Integer>(3);
        num1.add(0, 1);
        num1.add(2, 2);
        num1.add(3, 4);
        num1 = arrayAlgo.merge(num1, num2);
        System.out.println(num1);
    }
}
