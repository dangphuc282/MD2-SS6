import java.util.Scanner;
import java.util.Arrays;

public class QuanLyDiemSV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] diemSV = new float[100];
        int soLuong = 0;

        while (true) {
            System.out.println("\n************* QUẢN LÝ ĐIỂM SV *************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng (1-8): ");
            int chon = scanner.nextInt();

            switch (chon) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    soLuong = scanner.nextInt();
                    for (int i = 0; i < soLuong; i++) {
                        System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        diemSV[i] = scanner.nextFloat();
                    }
                    break;

                case 2:
                    System.out.println("Danh sách điểm sinh viên:");
                    for (int i = 0; i < soLuong; i++) {
                        System.out.print(diemSV[i] + "\t");
                    }
                    System.out.println();
                    break;

                case 3:
                    float tong = 0;
                    for (int i = 0; i < soLuong; i++) {
                        tong += diemSV[i];
                    }
                    float trungBinh = tong / soLuong;
                    System.out.printf("Điểm trung bình: %.2f\n", trungBinh);
                    break;

                case 4:
                    float max = diemSV[0], min = diemSV[0];
                    for (int i = 1; i < soLuong; i++) {
                        if (diemSV[i] > max) max = diemSV[i];
                        if (diemSV[i] < min) min = diemSV[i];
                    }
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (int i = 0; i < soLuong; i++) {
                        if (diemSV[i] >= 5) dat++;
                        else truot++;
                    }
                    System.out.println("Số sinh viên đạt (>=5): " + dat);
                    System.out.println("Số sinh viên trượt (<5): " + truot);
                    break;

                case 6:
                    Arrays.sort(diemSV, 0, soLuong);
                    System.out.println("Danh sách sau khi sắp xếp tăng dần:");
                    for (int i = 0; i < soLuong; i++) {
                        System.out.print(diemSV[i] + "\t");
                    }
                    System.out.println();
                    break;

                case 7:
                    int gioi = 0, xuatSac = 0;
                    for (int i = 0; i < soLuong; i++) {
                        if (diemSV[i] >= 8) gioi++;
                        if (diemSV[i] >= 9) xuatSac++;
                    }
                    System.out.println("Số sinh viên giỏi (>=8): " + gioi);
                    System.out.println("Số sinh viên xuất sắc (>=9): " + xuatSac);
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }
}
