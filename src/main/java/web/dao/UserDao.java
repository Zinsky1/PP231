package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   User getUser(int id);

   void deleteUser(int id);

   //update user
   void updateUser(User user);


}
