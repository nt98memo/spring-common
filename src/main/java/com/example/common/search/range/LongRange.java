package com.example.common.search.range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class LongRange extends BaseRange<Long> {

    @Min(value=-9223372036854775808L)
    @Max(value=9223372036854775807L)
	private Long from;

    @Min(value=-9223372036854775808L)
    @Max(value=9223372036854775807L)
	private Long to;

}
