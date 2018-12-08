package Algorithm.Search;

public class TestST {
    public static void main(String[] args) {
        var st = new BST<String,Integer>();

        st.put("hello", 0);
        st.put("world", 1);
        st.put("fuck", 2);
        st.put("fuc00", 2);
        st.put("fuc10", 2);
        st.put("fuc20", 2);
        System.out.println(st.height());
    }
}
