package com.callor.word;

import com.callor.word.service.GameService;
import com.callor.word.service.impl.GameServiceImplV1;

public class WordQuiz {

	public static void main(String[] args) {
		
		GameService gameService = new GameServiceImplV1();
		gameService.selectMenu();
		
		
	}
}
