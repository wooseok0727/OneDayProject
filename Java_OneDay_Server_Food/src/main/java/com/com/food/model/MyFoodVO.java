package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class MyFoodVO {

	private Long mf_seq = 0L; 	//	number
	private String mf_date; 	//	char(10 byte)
	private String mf_pcode; 	//	char(7 byte)
	private Integer mf_intake = 0; 	//	number
}
