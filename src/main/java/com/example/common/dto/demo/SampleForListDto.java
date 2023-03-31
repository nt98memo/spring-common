package com.example.common.dto.demo;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.example.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class SampleForListDto extends BaseEntity  {

	@Id
	@Column(name = "id")
    private Long id;

	@Column(name = "int_col")
    private Integer intCol;

	@Column(name = "long_col")
    private Long longCol;

	@Column(name = "decimal_col")
    private BigDecimal decimalCol;

	@Column(name = "text_col")
    private String textCol;

	@Column(name = "textarea_col")
    private String textareaCol;

	@Column(name = "radio_col")
    private String radioCol;

	@Column(name = "select_col")
    private String selectCol;

	@Column(name = "date_col")
    private Date dateCol;

	@Column(name = "time_col")
    private Time timeCol;

	@Column(name = "datetime_col")
    private Timestamp datetimeCol;

}