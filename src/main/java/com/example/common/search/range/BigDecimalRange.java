package com.example.common.search.range;

import java.math.BigDecimal;

import org.springframework.core.annotation.MergedAnnotations.Search;

import jakarta.validation.constraints.Digits;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class BigDecimalRange extends BaseRange<BigDecimal> {

    @Digits(integer=3, fraction=2, groups={Search.class})
	private BigDecimal from;

    @Digits(integer=3, fraction=2, groups={Search.class})
	private BigDecimal to;

}
