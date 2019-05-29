package com.mooc.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.mooc.mall.pojo.Book;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface BookDao extends JpaRepository<Book,String>,JpaSpecificationExecutor<Book>{
	
}
