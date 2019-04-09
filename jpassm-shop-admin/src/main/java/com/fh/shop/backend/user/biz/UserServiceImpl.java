package com.fh.shop.backend.user.biz;

import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.user.mapper.IUserMapper;
import com.fh.shop.backend.user.po.User;
import com.fh.shop.backend.user.vo.UserVO;
import com.fh.shop.backend.user.web.from.UserRequest;
import com.fh.shop.backend.util.COSUtil;
import com.fh.shop.backend.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements IUserService{

   @Autowired
    private IUserMapper userMapper;
    /**
     * 查看用户信息
     * @param user
     * @return
     */
    @Override
    public DataTableResult findUserList(UserRequest user) {
        PageRequest pageRequest = new PageRequest(user.getStart() / user.getLength(), user.getLength(), Sort.Direction.DESC, "id");
        //动态where条件拼接
        Specification<User> specification =buildWhere(user);
        //动态where条件拼接
        Page<User> userPage = userMapper.findAll(specification, pageRequest);
        //获取商品信息
        List<User> userList = userPage.getContent();
        //包装用户VO
        List<UserVO> userVoList = wrapperUserVO(userList);
        //获取总条数
        long totalCount = userPage.getTotalElements();
        //重组数据
        DataTableResult dataTableResult = DataTableResult.dataTableResultData(userVoList, user.getDraw(), totalCount, totalCount);
        return dataTableResult;
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        String t=UUID.randomUUID().toString();
        user.setSalt(t);
        user.setLoginStatus(0);
        user.setPassword(MD5Util.getStringMD5(user.getPassword()+t));
        userMapper.save(user);
    }

    /**
     *  修改回显
     * @return
     */
    @Override
    public UserVO findUser(Integer id) {
        User user = userMapper.getOne(id);
        UserVO userVo = getUserVo(user);
        return userVo;
    }

    /**
     * 修改
     * @param user
     */
    @Override
    public void updateUser(User user) {
        //判断是否有新图片上传
        if(StringUtils.isNotEmpty(user.getUserImage())){
            //删除服务器上的主图片
            COSUtil.deleteFile(user.getOldUserImage());
        }else{
            //product.getProductImagePath()不为空则证明主图不需要修改 所以就把回显的路径赋值给上传的路径
            user.setUserImage(user.getOldUserImage());
        }
        userMapper.updateUser(user);
    }

    /**
     * 解锁
     * @param id
     */
    @Override
    public void updateUserLoginStatus(Integer id) {
        userMapper.updateUserLoginStatus(id);
    }

    /**
     * 批量删除用户
     * @param ids
     */
    @Override
    public void deleteBatchUser(String ids) {
        String[] idArr = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for(int i=0;i<idArr.length;i++){
            idList.add(Integer.valueOf(idArr[i]));
        }
        userMapper.deleteBatchUser(idList);
    }

    //动态where条件拼接
    private Specification<User> buildWhere(final UserRequest user){
        return new Specification<User>() {
            //生成sql语句并动态拼接where条件
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //两表联查
                root.join("dept",JoinType.LEFT);
                List<Predicate> PredicateList = new ArrayList<Predicate>();
                if(StringUtils.isNotEmpty(user.getUserName())){
                    PredicateList.add(cb.like(root.get("userName").as(String.class),'%'+user.getUserName()+'%'));
                }
                if( user.getMinBirthday()!=null){
                    PredicateList.add(cb.greaterThanOrEqualTo(root.get("birthday").as(Date.class),user.getMinBirthday()));
                }
                if( user.getMaxBirthday()!=null){
                    PredicateList.add(cb.lessThanOrEqualTo(root.get("birthday").as(Date.class),user.getMaxBirthday()));
                }
                if(user.getMinSalary()!=null && user.getMinSalary()>=0){
                    PredicateList.add(cb.greaterThanOrEqualTo(root.get("salary").as(Double.class),user.getMinSalary()));
                }
                if(user.getMaxSalary()!=null && user.getMaxSalary()>=0){
                    PredicateList.add(cb.lessThanOrEqualTo(root.get("salary").as(Double.class),user.getMaxSalary()));
                }
                Predicate[] predicateArr = PredicateList.toArray(new Predicate[PredicateList.size()]);
                return query.where(predicateArr).getRestriction();
            }
        };

    }

    //包装用户VO
    private List<UserVO> wrapperUserVO(List<User> userList) {
        List<UserVO> userVoList=new ArrayList<>();
        for (User userInfo : userList) {
            UserVO userVo = getUserVo(userInfo);
            userVoList.add(userVo);

        }
        return userVoList;
    }
    //VO转po
    private UserVO getUserVo(User userInfo) {
        UserVO userVo=new UserVO();
        userVo.setId(userInfo.getId());//用户图像
        userVo.setUserName(userInfo.getUserName());
        userVo.setBirthday(userInfo.getBirthday());
        userVo.setUserImage(userInfo.getUserImage());
        userVo.setDeptName(userInfo.getDept().getDeptName());
        userVo.setDeptId(userInfo.getDept().getId());
        userVo.setLoginStatus(userInfo.getLoginStatus());
        userVo.setPassword(userInfo.getPassword());
        userVo.setSalary(userInfo.getSalary());
        userVo.setSex(userInfo.getSex());
        userVo.setUserRealName(userInfo.getUserRealName());
        userVo.setLoginStatus(userInfo.getLoginStatus());
        return userVo;
    }




}
