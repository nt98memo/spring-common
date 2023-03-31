package com.example.common.search.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.common.enumeration.Flg;
import com.example.common.search.BaseSearchEntity;
import com.example.common.search.OrderBy;
import com.example.common.search.range.BigDecimalRange;
import com.example.common.search.range.DateRange;
import com.example.common.search.range.IntegerRange;
import com.example.common.search.range.LongRange;
import com.example.common.search.range.TimeRange;
import com.example.common.search.range.TimestampRange;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class SampleSearch extends BaseSearchEntity  {

	@Valid
    private IntegerRange intCol = new IntegerRange();

	@Valid
    private LongRange longCol = new LongRange();

	@Valid
    private BigDecimalRange decimalCol = new BigDecimalRange();

    private String textCol;

    private String passwordCol;

    private String textareaCol;

    private List<Flg> radioCol = new ArrayList<Flg>(Arrays.asList(null, null));

    private List<Flg> selectCol = new ArrayList<Flg>(Arrays.asList(null, null));

	@Valid
    private DateRange dateCol = new DateRange();

	@Valid
    private TimeRange timeCol = new TimeRange();

	@Valid
    private TimestampRange datetimeCol = new TimestampRange();

    @PostConstruct
    private void postConstruct() {
    	this.setOrderBy(new ArrayList<OrderBy>(Arrays.asList(null, null)));
    }
}