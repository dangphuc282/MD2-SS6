import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class QuanLyNguoiDung {

    static String hoTen = "";
    static String email = "";
    static String sdt = "";
    static String matKhau = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            System.out.println("\n************ QUẢN LÝ NGƯỜI DÙNG ************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    hoTen = scanner.nextLine();

                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    sdt = scanner.nextLine();

                    System.out.print("Nhập mật khẩu: ");
                    matKhau = scanner.nextLine();
                    break;

                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("Chưa nhập họ tên.");
                        break;
                    }
                    hoTen = chuanHoaTen(hoTen);
                    System.out.println("Họ tên sau khi chuẩn hóa: " + hoTen);
                    break;

                case 3:
                    if (email.isEmpty()) {
                        System.out.println("Chưa nhập email.");
                        break;
                    }
                    if (kiemTraEmail(email)) {
                        System.out.println("Email hợp lệ.");
                    } else {
                        System.out.println("Email không hợp lệ.");
                    }
                    break;

                case 4:
                    if (sdt.isEmpty()) {
                        System.out.println("Chưa nhập số điện thoại.");
                        break;
                    }
                    if (kiemTraSDT(sdt)) {
                        System.out.println("Số điện thoại hợp lệ.");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ.");
                    }
                    break;

                case 5:
                    if (matKhau.isEmpty()) {
                        System.out.println("Chưa nhập mật khẩu.");
                        break;
                    }
                    if (kiemTraMatKhau(matKhau)) {
                        System.out.println("Mật khẩu hợp lệ.");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ.");
                    }
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Vui lòng chọn từ 1 đến 6.");
            }
        } while (luaChon != 6);
    }

    public static String chuanHoaTen(String ten) {
        ten = ten.trim().toLowerCase();
        String[] tu = ten.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String t : tu) {
            sb.append(Character.toUpperCase(t.charAt(0)))
                    .append(t.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }
    public static boolean kiemTraEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    public static boolean kiemTraSDT(String sdt) {
        String regex = "^(0[3|5|7|8|9])[0-9]{8}$";
        return sdt.matches(regex);
    }
    public static boolean kiemTraMatKhau(String pass) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return pass.matches(regex);
    }
}
