public class stringBuilderr {
    public static void main(String[] args) {
        String a = "djasdfejfjgnslka";
        StringBuilder s = new StringBuilder("");
        StringBuilder s1 = new StringBuilder("");

        // for (int i = 0; i <4; i++) {
            String s2 = a.substring(0,4);
            String s3 = a.substring(4, a.length());
            // s1.append();
            System.out.println(s2);
            System.out.println(s3);
            String s4 = a.substring(a.length()-4,a.length());
            String s5 = a.substring(0, a.length()-4);
            // s1.append();
            System.out.println(s4);
            System.out.println(s5);
        // }
    }
}
