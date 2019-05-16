package business.service.impl;

import business.dao.IOrderDao;
import business.entity.Order;
import business.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 预约信息业务层实现类
 * */
@Service("orderService")
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> findAllOrder() {
        return orderDao.findAllOrder();
    }

    @Override
    public Order findOrderByYuId(String yuid) {
        return orderDao.findOrderByYuId(yuid);
    }

    @Override
    public Order findOrderByUserId(String userid) {
        return orderDao.findOrderByUserId(userid);
    }

    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);

    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
}
