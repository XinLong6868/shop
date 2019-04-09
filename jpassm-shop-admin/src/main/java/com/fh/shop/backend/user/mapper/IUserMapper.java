package com.fh.shop.backend.user.mapper;

import com.fh.shop.backend.user.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserMapper extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

    /**
     * 分页条件查询
     * @param specification
     * @param pageRequest
     * @return
     */
    //避免控制台打印n+1 sql语句
    @EntityGraph(value = "user.Graph",type = EntityGraph.EntityGraphType.FETCH)
    Page<User> findAll(Specification<User> specification, Pageable pageRequest);

    //解锁
    @Modifying
    @Query("update User set loginStatus=0,errorLoginCount=0 where id=?1")
    void updateUserLoginStatus(Integer id);

    /**
     * 修改
     * @param user
     */
    @Modifying
    @Query("update User set userName=:#{#user.userName},userImage=:#{#user.userImage}," +
            "userRealName=:#{#user.userRealName},birthday=:#{#user.birthday},sex=:#{#user.sex}," +
            "salary=:#{#user.salary},deptId=:#{#user.dept.id} where id=:#{#user.id}")
    void updateUser(@Param("user") User user);

    /**
     * 批量删除用户
     * @param idList
     */
    @Modifying
    @Query("delete from User where id in (:idList)")
    void deleteBatchUser(@Param("idList") List<Integer> idList);
}
