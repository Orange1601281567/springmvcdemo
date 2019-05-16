package business.dao.impl;

import business.dao.IUserDao;
import business.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class IUserDaoImpl implements IUserDao {
    @Autowired
    private QueryRunner runner;

    @Override
    public List<User> findAllUser() {
        try {
            return runner.query( "select * from testusers ",new BeanListHandler<User>( User.class ) );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }

    }

    @Override
    public User findUserById(Integer UserId) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer UserId) {

    }


}
