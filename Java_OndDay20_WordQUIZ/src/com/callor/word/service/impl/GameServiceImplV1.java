package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.UserVO;
import com.callor.word.model.WordVO;
import com.callor.word.service.GameService;
import com.callor.word.service.UserService;
import com.wooseok.standard.MenuService;
import com.wooseok.standard.impl.MenuServiceImplV1;

public class GameServiceImplV1 implements GameService {
	
	protected MenuService menuService;
	protected UserService userService;
	protected String engWord;
	protected String korWord;
	protected List<WordVO> wordList;
	protected Scanner scan;
	protected Random rnd;
	protected int score;
	protected int winCount;
	protected int loseCount;
	protected int nCount;
	protected final int 영어 = 0;
	protected final int 한글 = 1;
	
	public GameServiceImplV1() {
		
		userService = new UserServiceImplV1();
		engWord = new String();
		korWord = new String();
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();
		score = 10;
		winCount = 0;
		loseCount = 0;
		nCount = 3;
		
		this.loadWord();
	}
	
	@Override
	public void selectMenu() {
		// TODO 시작메뉴
		List<String> menuList = new ArrayList<String>();
		menuList.add("게임 시작하기");
		menuList.add("점수 저장하기");
		menuList.add("점수 불러오기");
		menuService = new MenuServiceImplV1("영어 단어 퀴즈", menuList);
		while(true) {
			Integer menu = menuService.selectMenu();
			if(menu == null) {
				System.out.println("종료되었습니다");
				return;
			}
			if(menu == 1) {
				this.viewWord();
			} else if(menu == 2) {
				this.saveScore();
			} else if(menu == 3) {
				this.loadScore();
			}
		}
	}

	@Override
	public void viewWord() {
		// TODO 게임 진행 화면
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("제시된 영 단어를 바르게 배열하시오(QUIT:게임 종료)");
			System.out.println("※ 플레이어 점수 : " + score);
			System.out.println();
			String[] engWord = this.splitRandomWord();
			System.out.println(Arrays.toString(engWord));
			Integer select = this.selectHintPass();
			if(select == null) {
				return;
			}
			System.out.println("-".repeat(50));
			System.out.println("* 현재 점수 : " + this.score);
			System.out.println("* 맞힌 횟수 : " + this.winCount);
			System.out.println("* 틀린 횟수 : " + this.loseCount);
		}
	}
	protected Integer selectHintPass() {
		// TODO 건너뛰기 및 힌트
		while(true) {
			System.out.println("=".repeat(50));
			System.out.println("[1. 건너뛰기] [2. 힌트보기] (점수 : -1 차감)");
			System.out.print(">> ");
			String strInput = scan.nextLine();
			if(strInput.equals("QUIT")) {
				return null;
			} else if(strInput.equals("1")) {
				this.score--;
				return 0;
			} else if(strInput.equals("2")) {
				if(this.score <= 0) {
					System.out.println("* 현재점수 : " + this.score);
					System.out.println("* 0점 이하는 힌트를 주지 않습니다");
					continue;
				}
				this.score--;
				System.out.println("-".repeat(50));
				System.out.println("* 현재점수 : " + this.score);
				System.out.println("* 힌트 : " + this.korWord);
				System.out.println("* 남은 기회 :" + nCount);
				
				continue;
				
			} else if(strInput.equalsIgnoreCase(this.engWord)) {
				this.score++;
				this.winCount++;
				System.out.println("-".repeat(50));
				System.out.println("* 정답입니다!");
				System.out.println("* 현재점수 : " + this.score);
				System.out.println("* 한글 뜻" + this.korWord);
				return 0;
				
			} else {
				this.score--;
				this.loseCount++;
				this.nCount--;
				if(nCount == 0) {
					System.out.println("-".repeat(50));
					System.out.println("* 기회 소진!!");
					this.nCount = 3;
					return 0;
				}
				System.out.println("-".repeat(50));
				System.out.println("* 틀렸습니다 남은기회 :" + this.nCount);
				System.out.println("* 현재점수 : " + this.score);
			}
		} // end while()
	}
	
	protected WordVO getWord() {
		// TODO 단어 1개 무작위로 뽑기
		
		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);
		WordVO vo = wordList.get(num);
		return vo;
	}
	
	protected String[] splitRandomWord() {
		// TODO 영단어 알파벳 순서 섞기
		
		WordVO word = this.getWord();
		this.engWord = word.getEnglish();
		this.korWord = word.getKorea();
		String[] rndEng = this.engWord.split("");
		
		for(int i = 0; i < 50; i++) {
			
			int index1 = rnd.nextInt(rndEng.length);
			int index2 = rnd.nextInt(rndEng.length);
			
			String temp = rndEng[index1];
			rndEng[index1] = rndEng[index2];
			rndEng[index2] = temp;
		}
		return rndEng;
	}
	
	@Override
	public void loadWord() {
		// TODO 단어파일 읽어오기
		
		String fileName = "src/com/callor/word/word.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);
			
			String reader = new String();
			while((reader = buffer.readLine()) != null) {
				
				String[] words = reader.split(":");
				WordVO wordVO = new WordVO();
				wordVO.setEnglish(words[영어]);
				wordVO.setKorea(words[한글]);
				wordList.add(wordVO);
			}
			buffer.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 오류 발생");
		}
	}

	@Override
	public void saveScore() {
		// TODO 유저 점수 저장하기
		
		UserVO userVO = new UserVO();
		userVO.setScore(this.score);
		userVO.setWinCount(this.winCount);
		userVO.setLoseCount(this.loseCount);
		
		userService.saveUserInfo(userVO);
	}

	@Override
	public void loadScore() {
		// TODO 유저 점수 불러오기
		
		UserVO userVO = userService.loadUserInfo();
		if(userVO == null) return;
		this.score = userVO.getScore();
		this.winCount = userVO.getWinCount();
		this.loseCount = userVO.getLoseCount();
	}
}
