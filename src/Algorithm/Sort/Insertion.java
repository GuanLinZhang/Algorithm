package Algorithm.Sort;

public class Insertion extends Example {
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (less(a[j],a[j - 1]))
                    exchange(a,j,j - 1);
            }
        }
    }
}
