package Algorithm.Sort;

public class Shell extends Template {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        while (h < n / 3 ) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j],a[j - h]); j -= h) {
                    exchange(a,j,j - h);
                }
            }
            h = h / 3;
        }

    }
}
