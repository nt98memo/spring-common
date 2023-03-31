package com.example.common.search;

import com.example.common.enumeration.OrderDirection;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class OrderBy {

	@Getter @Setter
	private String column;

	@Getter @Setter
	private OrderDirection order;
	
}
