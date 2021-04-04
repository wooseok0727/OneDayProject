package com.callor.score.model;

public class ScoreVO {

	private String name;
	private Integer kor;
	private Integer eng;
	private Integer math;
	private Integer sci;
	private Integer his;
	private Integer total;
	private Float avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getKor() {
		return kor;
	}
	public void setKor(Integer kor) {
		this.kor = kor;
	}
	public Integer getEng() {
		return eng;
	}
	public void setEng(Integer eng) {
		this.eng = eng;
	}
	public Integer getMath() {
		return math;
	}
	public void setMath(Integer math) {
		this.math = math;
	}
	public Integer getSci() {
		return sci;
	}
	public void setSci(Integer sci) {
		this.sci = sci;
	}
	public Integer getHis() {
		return his;
	}
	public void setHis(Integer his) {
		this.his = his;
	}
	public Integer getTotal() {
		this.total = this.kor + this.eng + this.math + this.sci + this.his;
		return total;
	}
	public Float getAvg() {
		avg = (float)total / 5;
		return avg;
	}
	
}
