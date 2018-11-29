package Algorithm.Sort;

public class Bubble extends Template {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if (less(a[i],a[j])) {
                    exchange(a,i,j);
                }
            }
        }
    }
}
