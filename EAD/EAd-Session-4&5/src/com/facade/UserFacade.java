package com.facade;

import java.sql.Connection;
import java.util.List;

import com.dao.JdbcConnection;
import com.dao.UserDao;
import com.model.User;

public class UserFacade {

    private static UserFacade userFacade = new UserFacade();

    UserDao userDao = new UserDao();
    
    public static UserFacade getInstance() {
        return userFacade;
    }

    public List<User> getAllProdcts() {
        return userDao.getAll();
    }

    public Status create(User user) {
        List<User> products = userDao.getAll();
        for (User tempUser: products) {
            if (tempUser.getCode().equals(user.getCode())) {
                return Status.DUPLICATE;
            }
        }
        userDao.create(product);
        return Status.CREATED;
    }

    public Status update(User user) {
    	userDao.update(product);
        return Status.UPDATED;
    }

    public Status delete(Product product) {
        List<Product> products = productDao.getAll();
        for (Product tempProduct: products) {
            if (tempProduct.getId() == product.getId()) {
            	userDao.delete(product);
                return Status.DELETED;
            }
        }
        return Status.NOT_FOUND;
    }
}