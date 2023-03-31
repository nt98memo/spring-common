package com.example.common.search.range;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class DateRange extends BaseRange<Date> {

	private Date from;
	private Date to;

}
