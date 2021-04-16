package com.callor.word.service;

import com.callor.word.model.WordVO;

public interface GameService {

	public void selectMenu();
	public void viewWord();
	public WordVO getWord();
	public String[] splitRandomWord();
	public void loadWord();
	public void saveScore();
	public void loadScore();
}
