package com.mooc.mall.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.mooc.mall.dao.BookDao;
import com.mooc.mall.pojo.Book;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Book> findSearch(Map whereMap, int page, int size) {
		Specification<Book> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return bookDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Book> findSearch(Map whereMap) {
		Specification<Book> specification = createSpecification(whereMap);
		return bookDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Book findById(String id) {
		int i=1/0;
		return bookDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param book
	 */
	public void add(Book book) {

		bookDao.save(book);
	}

	/**
	 * 修改
	 * @param book
	 */
	public void update(Book book) {
		bookDao.save(book);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		bookDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Book> createSpecification(Map searchMap) {

		return new Specification<Book>() {

			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 
                if (searchMap.get("writer")!=null && !"".equals(searchMap.get("writer"))) {
                	predicateList.add(cb.like(root.get("writer").as(String.class), "%"+(String)searchMap.get("writer")+"%"));
                }
                // 
                if (searchMap.get("introduction")!=null && !"".equals(searchMap.get("introduction"))) {
                	predicateList.add(cb.like(root.get("introduction").as(String.class), "%"+(String)searchMap.get("introduction")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
