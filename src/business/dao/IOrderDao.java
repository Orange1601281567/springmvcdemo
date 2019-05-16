package business.dao;

import business.entity.Order;

import java.util.List;

/**
 * 预约信息持久层
 * */
public interface IOrderDao {
    /**
     * 查询所有预约信息
     * @return
     */
    List<Order> findAllOrder();

    /**
     * 根据预约号查询预约信息
     * @param YuId
     * @return
     */
    Order findOrderByYuId(String YuId);

    /**
     * 根据用户账号UserId查询预约信息
     * @param UserId
     * @return
     */
    Order findOrderByUserId(String UserId);

    /**
     * 保存
     * @param order
     */
    void saveOrder(Order order);

    /**
     * 更新
     * @param order
     */
    void updateOrder(Order order);

}
