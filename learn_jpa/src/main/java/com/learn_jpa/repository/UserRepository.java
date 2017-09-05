package com.learn_jpa.repository;

import com.learn_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Serializable> {

    /**
     * 根据id获取对应的User实体类
     *
     * @param id
     * @return
     */
    public User findByUid(Serializable id);

    /**
     * 父类中的增加方法
     *
     * @param user
     * @return 增加的类对象
     */
    public User save(User user);

    public List<User> findByAgeBetween(Integer begin, Integer end);

    @Query("select u from User u order by u.age desc ")
    public List<User> myAll();
}
