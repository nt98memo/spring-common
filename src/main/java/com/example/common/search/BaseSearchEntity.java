package com.example.common.search;

import java.util.ArrayList;
import java.util.List;

import com.example.common.form.BaseForm;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class BaseSearchEntity extends BaseForm {

	public static final int DEFAULT_OFFSET = 0;
	public static final int DEFAULT_LIMIT = 50;

	@Getter @Setter
	private List<OrderBy> orderBy = new ArrayList<OrderBy>();

	@Getter @Setter
	private Integer limit;

	@Getter @Setter
	private Integer offset;
	
}
