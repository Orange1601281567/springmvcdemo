package business.dao.impl;

import business.dao.IAccountDao;
import business.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class IAccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query( "select * from account ",new BeanListHandler<Account>( Account.class ) );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query( "select *from account where id= ?", new BeanHandler<Account>( Account.class ),accountId );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update( "insert into account (name,money) values(?,?)",account.getName(),account.getMoney() );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update( "update account name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId() );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update( "delete account where id=?",accountId );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }
}
