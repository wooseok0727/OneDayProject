package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	
	public ScoreServiceV1() {
	
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}
	
	public Integer menuScore() {
		
		System.out.println("=".repeat(50));
		System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
		System.out.println("=".repeat(50));
		System.out.println("1. 학생별 성적 입력");
		System.out.println("2. 학생 성적 리스트 출력");
		System.out.println("QUIT. 업무종료");
		System.out.println("=".repeat(50));
		System.out.print("업무선택 >> ");
		
		String select = scan.nextLine();
		
		return 0;
		}
	
	public Integer inputScore() {
				
		return 0;
	}
	
	public Integer intpuScore1() {
		
		return 0;
	}
	
	public void printListScore() {
		
	}
	
}
