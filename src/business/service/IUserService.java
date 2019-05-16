package business.service;

import business.entity.User;

import java.util.List;

/**
 * 用户业务层接口
 * */
public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

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
    void saveUser(User user);

    /**
     * 更新
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除
     * @param userId
     */
    void deleteUser(Integer userId);

}
