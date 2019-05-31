package business.dao;

import business.entity.User;

import java.util.List;

/**
 * 用户持久层
 * created by 徐君涛
 * */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     * */
    List<User>findAllUser();

    /**
     * 查询一个
     * @param UserId
     * @return
     */
    User findUserById(Integer UserId);

    /**
     * 保存
     * @param user
     */
    User loginUser(User user);

    /**
     * 更新
     * @param user
     */
    int updateUser(User user);

    /**
     * 删除
     * @param UserId
     */
    int deleteUser(Integer UserId);
    /**
     * 转账
     */
    int change(String user1,String user2, float money);
}
