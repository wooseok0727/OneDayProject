package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	private Scanner scan;
	private List<ScoreVO> scoreList;

	public ScoreServiceV1() {

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}

	public void menuScore() {
		// TODO 메뉴화면
		while (true) {
			System.out.println("=".repeat(72));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(72));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(72));
			System.out.print("업무선택 >> ");

			String select = scan.nextLine();
			if (select.equals("1")) {
				this.inputName();
			} else if (select.equals("2")) {
				this.printListScore();
			} else if (select.equals("QUIT")) {
				return;
			} else {
				System.out.println("1~2, 또는 QUIT 만 선택할 수 있습니다.");
				System.out.println();
				continue;
			}
		} // end while()
	} // end menu Score()

	private void inputName() {
		// TODO 학생 이름 입력받기
		System.out.println("=".repeat(72));
		System.out.println("학생 이름을 입력하세요(입력을 중단하려면 QUIT)");
		System.out.println("=".repeat(72));
		System.out.print("이름 >> ");
		String strName = scan.nextLine();
		if (strName.equals("QUIT")) {
			return;
		}
		this.inputScore(strName);
	} // end inputNate()

	private void inputScore(String name) {
		// TODO inputScore() 에서 입력된 학생 점수를 sVO객체에 추가하기
		String[] subject = { "국어", "영어", "수학", "과학", "국사" };
		Integer[] scores = new Integer[subject.length];

		System.out.println("=".repeat(72));
		System.out.println(name + " 의 성적을 입력하세요 (성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)");
		System.out.println("=".repeat(72));

		for (int i = 0; i < subject.length; i++) {   // 과목수만큼 점수를 입력받아오기
			scores[i] = this.inputSubjectScore(subject[i]);
			if (scores[i] == null) {
				return;
			}
		}
		ScoreVO sVO = new ScoreVO();
		sVO.setName(name);
		sVO.setKor(scores[0]);
		sVO.setEng(scores[1]);
		sVO.setMath(scores[2]);
		sVO.setSci(scores[3]);
		sVO.setHis(scores[4]);

		scoreList.add(sVO);

		this.printScore(sVO);
	} // end inputScore()

	private Integer inputSubjectScore(String sub) {
		// TODO 과목 점수 입력받기
		Integer score = 0;
		while (true) {
			System.out.print(sub + " >> ");
			String strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return null;
			}
			try {
				score = Integer.valueOf(strScore);
			} catch (Exception e) {
				System.out.println("0 ~ 100까지 숫자만 입력하세요");
				continue;
			}
			if (score < 0 || score > 100) {
				System.out.println("0 ~ 100까지 숫자만 입력하세요");
				continue;
			}
			break;
		}
		return score;
	} // end inputScore2()

	private void printScore(ScoreVO sVO) {
		// TODO 1명의 성적 추가 화면 출력하기
		System.out.println("=".repeat(72));
		System.out.println(sVO.getName() + " 학생의 성적이 추가 되었습니다");
		System.out.println("=".repeat(72));
		System.out.println("국어 >> " + sVO.getKor());
		System.out.println("영어 >> " + sVO.getEng());
		System.out.println("수학 >> " + sVO.getMath());
		System.out.println("과학 >> " + sVO.getSci());
		System.out.println("국사 >> " + sVO.getHis());
	} // end printScore()

	private void printListScore() {
		// TODO 성적리스트 출력하기
		System.out.println("=".repeat(72));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t 평균");
		System.out.println("-".repeat(72));
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			System.out.printf("%03d    ", i + 1);
			System.out.print(vo.getName() + " \t ");
			System.out.print(vo.getKor() + "\t ");
			System.out.print(vo.getEng() + "\t ");
			System.out.print(vo.getMath() + "\t ");
			System.out.print(vo.getSci() + "\t ");
			System.out.print(vo.getHis() + "\t ");
			System.out.print(vo.getTotal() + "\t ");
			System.out.printf("%3.2f\n", vo.getAvg());
		}
		this.printListTotalScore();
	} // end allPrintScore()

	private void printListTotalScore() {
		// TODO 전체 리스트의 총점 평균 출력하기
		int[] allTotal = new int[6];
		float allTotalAvg = 0.0f;
		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO scoreVO = scoreList.get(i);
			allTotal[0] += scoreVO.getKor();
			allTotal[1] += scoreVO.getEng();
			allTotal[2] += scoreVO.getMath();
			allTotal[3] += scoreVO.getSci();
			allTotal[4] += scoreVO.getHis();
			allTotal[5] += scoreVO.getTotal();
			allTotalAvg += scoreVO.getAvg();
		}
		System.out.println("=".repeat(72));
		System.out.print("총점\t         ");
		for(int i = 0; i < allTotal.length; i++) {
			System.out.print(allTotal[i] + "\t ");
		}
		System.out.printf("%3.2f\n", allTotalAvg / scoreList.size());
		System.out.println("=".repeat(72));
	}

}
