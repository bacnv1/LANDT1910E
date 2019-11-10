public class HanhDong {
    int thu;

    void nhap(int giaTriThu) {
        thu = giaTriThu;
    }

    void inHanhDong() {
        if (thu == 2) {
            System.out.println("Di choi");
        }else if (thu == 3){
            System.out.println("Di hoc");
        }else if (thu == 4){
            System.out.println("Di boi");
        }else if (thu == 5){
            System.out.println("Da bong");
        }else if (thu == 6){
            System.out.println("Xem phim");
        }else if (thu == 7){
            System.out.println("Choi game");
        }else if (thu == 9){
            System.out.println("Ve que");
        }
    }

    void inHanhDongSwitch() {
        switch (thu) {
            case 2:
                System.out.println("Di choi");
                break;
            case 3:
                System.out.println("Di hoc");
                break;
            case 4:
                System.out.println("Di boi");
                break;
            case 5:
                System.out.println("Da bong");
                break;
            case 6:
                System.out.println("Xem phim");
                break;
            case 7:
                System.out.println("Choi game");
                break;
            case 8:
                System.out.println("Ve que");
                break;
        }
    }
}
