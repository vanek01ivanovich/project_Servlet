package ua.training;

import ua.training.model.dao.entity.User;

import java.util.Optional;

public class test {
  public static void main(String[] args) {
      Optional<User> user;
      User user1 = new User();
      user1.setFirstName("dcss");
      user1.setUserName("csdcsdc");
      user = Optional.of(user1);
      user.ifPresent(val -> System.out.println(user.get().getFirstName()));
  }
}
