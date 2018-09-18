package Algorithm.Sort;

public class Test {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{23,11,55,22,31,64,1,7};

        var sortInstance = new Insertion();
        sortInstance.sort(a);

        Templete.printAll(a);
        System.out.println(Templete.isSorted(a));;
    }
}
