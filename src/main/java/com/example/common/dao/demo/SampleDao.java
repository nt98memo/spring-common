package com.example.common.dao.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.common.dao.BaseDao;
import com.example.common.dto.demo.SampleForListDto;
import com.example.common.entity.demo.Sample;
import com.example.common.enumeration.Flg;
import com.example.common.enumeration.OrderDirection;
import com.example.common.search.OrderBy;
import com.example.common.search.demo.SampleSearch;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class SampleDao extends BaseDao {

	public SampleDao() {
		super();
	}

	public SampleDao(EntityManager entityManager) {
		super(entityManager);
	}

	public List<SampleForListDto> getSampleList() {

		List<SampleForListDto> list = this.entityManager
				.createQuery(
						"select new com.example.common.dto.demo.SampleForListDto(tbl1.id, tbl1.intCol, tbl1.longCol, tbl1.decimalCol, tbl1.textCol, tbl1.textareaCol, tbl1.radioCol, tbl1.selectCol, tbl1.dateCol, tbl1.timeCol, tbl1.datetimeCol) from Sample tbl1 where tbl1.id = :id1 or tbl1.id = :id2",
						SampleForListDto.class)
				.setParameter("id1", 1L)
				.setParameter("id2", 2L)
				.getResultList();

		return list;

	}

	public Page<Sample> searchSample(SampleSearch searchEntity) {
		
		int offset = searchEntity.getOffset() == null ? SampleSearch.DEFAULT_OFFSET : searchEntity.getOffset();
		int limit = searchEntity.getLimit() == null ? SampleSearch.DEFAULT_LIMIT : searchEntity.getLimit();
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
		Root<Sample> rootCount = queryCount.from(Sample.class);
		queryCount.select(builder.count(rootCount));
		
		CriteriaQuery<Sample> query = builder.createQuery(Sample.class);
		Root<Sample> root = query.from(Sample.class);
		query.select(root);

		List<Predicate> whereCountList = new ArrayList<Predicate>();
		List<Predicate> whereList = new ArrayList<Predicate>();
		
		if (searchEntity.getIntCol().getFrom() != null) {
			whereCountList.add(builder.ge(rootCount.get("intCol"), searchEntity.getIntCol().getFrom()));
			whereList.add(builder.ge(root.get("intCol"), searchEntity.getIntCol().getFrom()));
		}
		if (searchEntity.getIntCol().getTo() != null) {
			whereCountList.add(builder.le(rootCount.get("intCol"), searchEntity.getIntCol().getTo()));
			whereList.add(builder.le(root.get("intCol"), searchEntity.getIntCol().getTo()));
		}
		if (searchEntity.getLongCol().getFrom() != null) {
			whereCountList.add(builder.ge(rootCount.get("longCol"), searchEntity.getLongCol().getFrom()));
			whereList.add(builder.ge(root.get("longCol"), searchEntity.getLongCol().getFrom()));
		}
		if (searchEntity.getLongCol().getTo() != null) {
			whereCountList.add(builder.le(rootCount.get("longCol"), searchEntity.getLongCol().getTo()));
			whereList.add(builder.le(root.get("longCol"), searchEntity.getLongCol().getTo()));
		}
		if (searchEntity.getDecimalCol().getFrom() != null) {
			whereCountList.add(builder.ge(rootCount.get("decimalCol"), searchEntity.getDecimalCol().getFrom()));
			whereList.add(builder.ge(root.get("decimalCol"), searchEntity.getDecimalCol().getFrom()));
		}
		if (searchEntity.getDecimalCol().getTo() != null) {
			whereCountList.add(builder.le(rootCount.get("decimalCol"), searchEntity.getDecimalCol().getTo()));
			whereList.add(builder.le(root.get("decimalCol"), searchEntity.getDecimalCol().getTo()));
		}
		if (searchEntity.getTextCol() != null) {
			whereCountList.add(builder.equal(rootCount.get("textCol"), searchEntity.getTextCol()));
			whereList.add(builder.equal(root.get("textCol"), searchEntity.getTextCol()));
		}
		if (searchEntity.getTextareaCol() != null) {
			whereCountList.add(builder.equal(rootCount.get("textareaCol"), searchEntity.getTextareaCol()));
			whereList.add(builder.equal(root.get("textareaCol"), searchEntity.getTextareaCol()));
		}
		if (searchEntity.getDateCol().getFrom() != null) {
			whereCountList.add(builder.greaterThanOrEqualTo(rootCount.get("dateCol"), searchEntity.getDateCol().getFrom()));
			whereList.add(builder.greaterThanOrEqualTo(root.get("dateCol"), searchEntity.getDateCol().getFrom()));
		}
		if (searchEntity.getDateCol().getTo() != null) {
			whereCountList.add(builder.lessThanOrEqualTo(rootCount.get("dateCol"), searchEntity.getDateCol().getTo()));
			whereList.add(builder.lessThanOrEqualTo(root.get("dateCol"), searchEntity.getDateCol().getTo()));
		}
		if (searchEntity.getTimeCol().getFrom() != null) {
			whereCountList.add(builder.greaterThanOrEqualTo(rootCount.get("timeCol"), searchEntity.getTimeCol().getFrom()));
			whereList.add(builder.greaterThanOrEqualTo(root.get("timeCol"), searchEntity.getTimeCol().getFrom()));
		}
		if (searchEntity.getTimeCol().getTo() != null) {
			whereCountList.add(builder.lessThanOrEqualTo(rootCount.get("timeCol"), searchEntity.getTimeCol().getTo()));
			whereList.add(builder.lessThanOrEqualTo(root.get("timeCol"), searchEntity.getTimeCol().getTo()));
		}
		if (searchEntity.getDatetimeCol().getFrom() != null) {
			whereCountList.add(builder.greaterThanOrEqualTo(rootCount.get("datetimeCol"), searchEntity.getDatetimeCol().getFrom()));
			whereList.add(builder.greaterThanOrEqualTo(root.get("datetimeCol"), searchEntity.getDatetimeCol().getFrom()));
		}
		if (searchEntity.getDatetimeCol().getTo() != null) {
			whereCountList.add(builder.lessThanOrEqualTo(rootCount.get("datetimeCol"), searchEntity.getDatetimeCol().getTo()));
			whereList.add(builder.lessThanOrEqualTo(root.get("datetimeCol"), searchEntity.getDatetimeCol().getTo()));
		}
		if (searchEntity.getRadioCol() != null) {
			List<Flg> valueList = new ArrayList<Flg>();
			for (Flg flg : searchEntity.getRadioCol()) {
				if (flg != null) {
					valueList.add(flg);
				}
			}
			if (valueList.size() > 0) {
				whereCountList.add(rootCount.get("radioCol").in((Object[])(valueList.toArray(new Flg[valueList.size()]))));
				whereList.add(root.get("radioCol").in((Object[])(valueList.toArray(new Flg[valueList.size()]))));
			}
		}
		if (searchEntity.getSelectCol() != null) {
			List<Flg> valueList = new ArrayList<Flg>();
			for (Flg flg : searchEntity.getSelectCol()) {
				if (flg != null) {
					valueList.add(flg);
				}
			}
			if (valueList.size() > 0) {
				whereCountList.add(rootCount.get("selectCol").in((Object[])(valueList.toArray(new Flg[valueList.size()]))));
				whereList.add(root.get("selectCol").in((Object[])(valueList.toArray(new Flg[valueList.size()]))));
			}
		}
		
		Predicate whereCount = builder.and((Predicate[])(whereCountList.toArray(new Predicate[whereCountList.size()])));
		Predicate where = builder.and((Predicate[])(whereList.toArray(new Predicate[whereList.size()])));
		queryCount.where(whereCount);
		query.where(where);
		
		List<Order> orderList = new ArrayList<Order>();
		List<OrderBy> orderByList = searchEntity.getOrderBy();
		for (OrderBy orderBy : orderByList) {
			if (orderBy.getColumn() != null) {
				if (orderBy.getOrder() == OrderDirection.DESC) {
					orderList.add(builder.desc(root.get(orderBy.getColumn())));
				} else {
					orderList.add(builder.asc(root.get(orderBy.getColumn())));
				}
			}
		}
		query.orderBy((Order[])(orderList.toArray(new Order[orderList.size()])));

		long rowNum = entityManager
				       .createQuery(queryCount)
				       .getSingleResult()
				       .longValue();
		
		List<Sample> list = entityManager
				            .createQuery(query)
				            .setFirstResult(offset)
				            .setMaxResults(limit)
				            .getResultList();

    	Pageable pageable = PageRequest.of(offset, limit);
		Page<Sample> page = new PageImpl<Sample>(list, pageable, rowNum);
		return page;

	}

}
