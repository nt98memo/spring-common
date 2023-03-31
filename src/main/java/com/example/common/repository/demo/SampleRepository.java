package com.example.common.repository.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.common.dto.demo.SampleForListDto;
import com.example.common.entity.demo.Sample;

import jakarta.persistence.LockModeType;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>  {
	@Query(value = "select new com.example.common.dto.demo.SampleForListDto(tbl1.id, tbl1.intCol, tbl1.longCol, tbl1.decimalCol, tbl1.textCol, tbl1.textareaCol, tbl1.radioCol, tbl1.selectCol, tbl1.dateCol, tbl1.timeCol, tbl1.datetimeCol) from Sample tbl1")
	List<SampleForListDto> getList();

	@Query(value = "select new com.example.common.dto.demo.SampleForListDto(tbl1.id, tbl1.intCol, tbl1.longCol, tbl1.decimalCol, tbl1.textCol, tbl1.textareaCol, tbl1.radioCol, tbl1.selectCol, tbl1.dateCol, tbl1.timeCol, tbl1.datetimeCol) from Sample tbl1 WHERE tbl1.id = :id")
	SampleForListDto getDto(@Param("id") Long id);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query(value = "select tbl1 from Sample tbl1 WHERE tbl1.id = :id")
    Sample findByIdForUpdate(@Param("id") Long id);
}
