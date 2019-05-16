package business.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import business.entity.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String yuid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String yuid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> findAllByUserid(@Param("userid")String userid);




}