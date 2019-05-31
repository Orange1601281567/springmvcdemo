package business.dao.impl;

import business.dao.IUserDao;
import business.entity.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("iuserDao")
public class IUserDaoImpl implements IUserDao {
    // 声明JdbcTemplate属性及其setter方法
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> findAllUser() {
        try {
            return null;
      //      return runner.query( "select * from testusers",new BeanListHandler<User>( User.class ) );

        }catch (Exception e){
            throw  new RuntimeException( e );
        }
        /*finally {
            DbUtils.close();
        }*/

    }

    @Override
    public User findUserById(Integer UserId) {
        return null;
    }

    @Override
    public User loginUser(User user) {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return  this.jdbcTemplate.queryForObject("select * from `testusers`where userid=? and name = ?",rowMapper,user.getUserid(),user.getName());
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Integer UserId) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT, readOnly = false)
    public int change(String user1, String user2, float money) {
        //创建数据库访问对象
       int a= this.jdbcTemplate.update("update `case` set case_price=case_price-? "
                + "where case_name = ?",money, user1);
        // 收款时，收款用户的余额=现有余额+所汇金额
        // 模拟系统运行时的突发性问题
        //int i=1/0;
          // 汇款时，汇款用户的余额=现有余额-所汇金额
        this.jdbcTemplate.update("update `case` set case_price=case_price+? "
                + "where case_name = ?",money, user2);
        return a;

    }


}
