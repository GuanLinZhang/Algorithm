package Algorithm.Chapter1;

public class Test {
    public static void main(String[] args) {
        var stack = new ResizingArrayStack<String>();

        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));
        }

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        for (var i : stack) {
            System.out.println(i);
        }

        stack.push("fuck");
        System.out.println(stack.size());
    }
}
