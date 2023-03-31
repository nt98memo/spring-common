package com.example.common.search.range;

import org.springframework.core.annotation.MergedAnnotations.Search;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class IntegerRange extends BaseRange<Integer> {

    @Min(value=-2147483648)
    @Max(value=2147483647)
	private Integer from;

    @Min(value=-2147483648)
    @Max(value=2147483647)
	@NotNull(groups = Search.class)
	private Integer to;

}
