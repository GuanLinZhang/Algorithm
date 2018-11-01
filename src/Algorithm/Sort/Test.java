package Algorithm.Sort;

public class Test {
    public static void main(String[] args) {
/*        Integer[] a = new Integer[]{23,11,55,22,31,64,1,7};

        var sortInstance = new Shell();
        sortInstance.sort(a);

        Template.printAll(a);
        System.out.println(Template.isSorted(a));*/
        var fuck = new Quick();
        Integer[] a = {23, 11, 55, 22, 31, 64, 1, 7};
        fuck.sort(a);
        Template.printAll(a);
    }
}
