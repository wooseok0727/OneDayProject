package com.callor.word.model;

public class WordVO {

	private String english;
	private String korea;
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorea() {
		return korea;
	}
	public void setKorea(String korea) {
		this.korea = korea;
	}
	@Override
	public String toString() {
		return "[μμ΄ = " + english + ", νκΈ = " + korea + "]";
	}
}
