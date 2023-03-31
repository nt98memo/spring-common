package com.example.common.search.range;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class TimestampRange extends BaseRange<Timestamp> {

	private Timestamp from;
	private Timestamp to;

}
