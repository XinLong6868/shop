package com.fh.shop.backend.dept.mapper;

import com.fh.shop.backend.dept.po.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDeptMapper extends JpaRepository<Dept,Integer>,JpaSpecificationExecutor<Dept> {

//删除部门
    @Modifying
    @Query("delete from Dept where id in(:ids)")
    void deleteByIdList(@Param("ids") List<Integer> ids);
}
