package business.service;

import business.entity.Order;

import java.util.List;

/**
 * 预约信息业务层接口
 * */
public interface IOrderService {
    /**
     * 查询所有预约信息
     * @return
     */
    List<Order> findAllOrder();

    /**
     * 根据预约号查询预约信息
     * @param yuid
     * @return
     */
    Order findOrderByYuId(String yuid);

    /**
     * 根据用户账号UserId查询预约信息
     * @param userid
     * @return
     */
    Order findOrderByUserId(String userid);

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
