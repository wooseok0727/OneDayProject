package com.com.food.persistence;

public class DBInfo {

	public static class FOOD {
		
	    public static final String f_code = "식품코드";
	    public static final String f_name = "식품명";
	    public static final String f_date = "출시연도";
	    public static final String c_name = "제조사명";
	    public static final String t_name = "분류명";
	    public static final String f_aps = "1회제공량";
	    public static final String f_spc = "총내용량(g)";
	    public static final String f_calories = "에너지(kcal)";
	    public static final String f_protein = "단백질(g)";
	    public static final String f_fat = "지방(g)";
	    public static final String f_carbohydrate = "탄수화물(g)";
	    public static final String f_sugars = "총당류(g)";
	}
	
	public static class MYFOOD {
		
		public static final String mf_seq = "SEQ";
		public static final String mf_date = "날짜";
		public static final String f_name = "식품명";
		public static final String mf_intake = "섭취량";
		public static final String mf_spc = "총내용량";
		public static final String mf_calories = "에너지(kcal)";
		public static final String mf_protein = "단백질(g)";
		public static final String mf_fat = "지방(g)";
		public static final String mf_carbohydrate = "탄수화물(g)";
		public static final String mf_sugars = "총당류(g)";
	}
}
