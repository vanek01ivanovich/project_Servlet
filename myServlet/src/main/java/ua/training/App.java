package ua.training;



import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.UserDao;

public class App {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        UserDao dao = factory.createUserDao();
    }
}
