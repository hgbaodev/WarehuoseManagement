package MAIN;

import DAO.UserDAO;
import MODEL.User;

/**
 *
 * @author robot
 */
public class test {
    public static void main(String[] args) {
        User user = new User("bao@gamil.com", "Hoang Gia Bao", "123", 1, "khohang1", "nhomquyen2");
        UserDAO.getInstance().insert(user);
    }
}
