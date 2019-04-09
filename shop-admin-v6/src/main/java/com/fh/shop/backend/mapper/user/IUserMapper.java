
package com.fh.shop.backend.mapper.user;

import java.util.List;

import com.fh.shop.backend.po.department.Department;
import com.fh.shop.backend.po.user.User;
import org.apache.ibatis.annotations.Param;


public interface IUserMapper {


	public List<User> queryUserList(User user);


	public User fingUser(User user);


	public void addUser(User user);

    List<User> judgeUserName(User user);

    void updateUser(User users);

	void updateUserStatus(User users);

	long totalCount(User user);

    void unlockUser(User user);

    User selectUser(User user);

    void updateUserInfo(User user);

    void updateUserDept(@Param("nodesId") Integer nodesId, @Param("userIds") List<Integer> userIds);

    List<User> excelOutUser(Department departmentInfo);

    void deleteUser(List<Integer> deptList);
}
