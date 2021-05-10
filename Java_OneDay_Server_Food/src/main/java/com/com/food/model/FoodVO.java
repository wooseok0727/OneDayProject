package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class FoodVO {

	private String f_code;				//	char(7 byte)
	private String f_name;				//	nvarchar2(125 char)
	private String f_date;				//	char(4 byte)
	private String f_ccode;				//	char(6 byte)
	private String f_tcode;				//	char(4 byte)
	private Integer f_aps = 0;			//	number
	private Integer f_spc = 0;			//	number
	private Integer f_calories = 0;		//	number
	private Integer f_protein = 0;		//	number
	private Integer f_fat = 0;			//	number
	private Integer f_carbohydrate = 0;	//	number
	private Integer f_sugars = 0;		//	number
}
