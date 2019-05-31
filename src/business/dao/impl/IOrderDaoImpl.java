package business.dao.impl;

import business.dao.IOrderDao;
import business.entity.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IOrderDaoImpl implements IOrderDao {
    @Autowired
// private QueryRunner runner;
    @Override
    public List<Order> findAllOrder() {
        try {
            return null;
       //     return runner.query( "select * from yu ",new BeanListHandler<Order>( Order.class ) );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public Order findOrderByYuId(String yuid) {
        try {
            return null;
        //    return runner.query( "select *from yu where yuid= ?", new BeanHandler<Order>( Order.class ),yuid );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public Order findOrderByUserId(String userid) {
        try {
            return null;
            //   return runner.query( "select * from yu where userid= ?", new BeanHandler<Order>( Order.class ),userid );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }
    }

    @Override
    public void  saveOrder(Order order) {
        try {
           // runner.update( "insert into yu (yuid,userid,people,tableid,yutime,sumprice,casename,ordertime) values(?,?,?,?,?,?,?,?)",
             //       order.getYuid(),order.getUserid(),order.getPeople(),
              //      order.getTableid(),order.getYutime(),order.getSumprice(),order.getCasename(),order.getOrdertime() );
        }catch (Exception e){
            throw  new RuntimeException( e );
        }

}

    @Override
    public void updateOrder(Order order) {

    }
}
