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
public class MyFoodDTO {

	private String mf_date; 				// 날짜			CHAR(10)
	private String f_name; 					// 식품명		NVARCHAR2(125)
	private Integer mf_intake = 0; 			// 섭취량		NUMBER
	private Integer mf_spc = 0; 			// 총내용량		NUMBER
	private Integer mf_calories = 0; 		// 에너지(kcal)	NUMBER
	private Integer mf_protein = 0; 		// 단백질(g)	NUMBER
	private Integer mf_fat = 0; 			// 지방(g)		NUMBER
	private Integer mf_carbohydrate = 0; 	// 탄수화물(g)	NUMBER
	private Integer mf_sugars = 0; 			// 총당류(g)	NUMBER
}
