package Algorithm.Chapter1;

public class NSum {
    private int a[];

    public NSum(int a[]) {
        this.a = a;
    }

    private boolean containsDuplicates() {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                System.out.println(i);
                System.out.println(i + 1);
                return true;
            }
        }
        return false;
    }

    private void printAll(int ... a) {
        for (var temp : a) {
            System.out.print(" " + temp);
        }
    }

    //Array.Sort() first
    public int ThreeSum() {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        printAll(a[i],a[j],a[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //Order Of Growth: ~NlogN
    public int ThreeSumFast() {
        var bs = new BinarySearch();
        int count = 0;

        if (containsDuplicates()) throw new IllegalArgumentException();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int k = bs.rank(a,-(a[i] + a[j]),0,a.length - 1);
                if (k > j) {
                    printAll(a[i],a[j],a[k]);
                    count++;
                }
            }
        }
        return count;
    }


    public int TwoSumFast() {
        var bs = new BinarySearch();
        int count = 0;

        if (containsDuplicates()) throw new IllegalArgumentException();
        for (int i = 0; i < a.length; i++) {
            int k = bs.rank(a,-a[i],0,a.length - 1);
            if (k > i) {
                printAll(a[i],a[k]);
                count++;
            }
        }
        return count;
    }
}
