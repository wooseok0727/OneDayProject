package com.callor.word.model;

public class UserVO {

	private String name;
	private Integer score = 0;
	private Integer winCount = 0;
	private Integer loseCount = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getWinCount() {
		return winCount;
	}
	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}
	public Integer getLoseCount() {
		return loseCount;
	}
	public void setLoseCount(Integer loseCount) {
		this.loseCount = loseCount;
	}
	@Override
	public String toString() {
		return "UserVO [name=" + name + ", score=" + score + ", winCount=" + winCount + ", loseCount=" + loseCount
				+ "]";
	}
	
	
}
