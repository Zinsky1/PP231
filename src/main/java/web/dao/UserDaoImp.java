package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      //TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      //return query.getResultList();
      TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User", User.class);
      return query.getResultList();
//      String sql = "select name, last_name, email from users";
//      Query query = entityManager.createQuery(sql);
//      return (List<User>) query.getResultList();

   }

   @Override
   public User getUser(int id) {
//      TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("from User where User.id=:id", User.class);
//
//      return (User) query.getResultList();

//      User user = (User) entityManager.createQuery("from User where User.id=:id", User.class)
//              .setParameter("id", id);
//      return user;
      return entityManager.find(User.class, id);
   }

   @Override
   public void deleteUser(int id) {
      //entityManager.createQuery("delete from User where User.id=:id",User.class);

//      entityManager.createQuery("delete from User where User.id=:id", User.class)
//              .setParameter("id", id)
//              .executeUpdate();
      User user = entityManager.find(User.class, id);
      entityManager.remove(user);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

}
