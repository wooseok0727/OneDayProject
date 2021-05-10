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
public class FoodDTO {

	private String f_code; 				// 식품코드		CHAR(7)
	private String f_name; 				// 식품명		NVARCHAR2(125)
	private String f_date; 				// 출시연도		CHAR(4)
	private String c_name; 				// 제조사명		NVARCHAR2(125)
	private String t_name; 				// 분류명		NVARCHAR2(30)
	private Integer f_aps = 0; 			// 1회제공량	NUMBER
	private Integer f_spc = 0; 			// 총내용량(g)	NUMBER
	private Integer f_calories = 0; 	// 에너지(kcal)	NUMBER
	private Integer f_protein = 0; 		// 단백질(g)	NUMBER
	private Integer f_fat = 0; 			// 지방(g)		NUMBER
	private Integer f_carbohydrate = 0; // 탄수화물(g)	NUMBER
	private Integer f_sugars = 0; 		// 총당류(g)	NUMBER
}
