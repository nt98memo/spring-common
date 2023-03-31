package com.example.common.search.range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ShortRange extends BaseRange<Short> {

    @Min(value=-32768)
    @Max(value=32767)
	private Short from;

    @Min(value=-32768)
    @Max(value=32767)
	private Short to;

}
