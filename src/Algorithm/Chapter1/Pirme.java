package Algorithm.Chapter1;

public class Pirme {
    public boolean isPrime(int num) {
        //任何小于2的数都不是素数
        if (num < 2) return false;
        //声明计数器 从2开始判断
        int i = 2;
        /*
            将num和i取模,,i会持续递增,直到跳出循环.
            有两种情况可以跳出循环:
                    1) num > i,表明在i递增过程中,num还能被其他的数整除,不是素数
                    2) num == i,表明num只能被自己整除
        */
        while (num % i++ != 0);
        //返回i是否一直递增到 num == i时,跳出循坏,又因自增运算符i++副作用,故-1
        return num == i - 1;
    }
}
