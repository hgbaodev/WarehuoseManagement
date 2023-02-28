package MAIN;

import DAO.TaikhoanDAO;
import MODEL.Taikhoan;

/**
 *
 * @author robot
 */
public class test {
    public static void main(String[] args) {
        Taikhoan user = new Taikhoan("bao@gamil.com", "Hoang Gia Bao", "123", 1, "khohang1", "nhomquyen2");
        TaikhoanDAO.getInstance().insert(user);
    }
}
