package web.servlet;

public class test {
    public static void main(String[] args) {
        String str="14854124569";
        String zz="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean matches = str.matches(zz);
        if (matches){
            System.out.println("邮箱");
        }else {
            System.out.println("手机号！");
        }
    }
}
