package com.example.common.search.range;

import java.sql.Time;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class TimeRange extends BaseRange<Time> {

	private Time from;
	private Time to;

}
