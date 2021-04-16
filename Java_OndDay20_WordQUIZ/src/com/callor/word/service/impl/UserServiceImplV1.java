package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.callor.word.model.UserVO;
import com.callor.word.service.UserService;

public class UserServiceImplV1 implements UserService {

	protected Scanner scan;
	protected final int 점수 = 0;
	protected final int 맞힌횟수 = 1;
	protected final int 틀린횟수 = 2;

	public UserServiceImplV1() {

		scan = new Scanner(System.in);
	}

	@Override
	public void saveUserInfo(UserVO vo) { // GameService 에서 넘어온 UserVO 형 정보 저장하기
		// TODO 유저정보 파일로 저장하기
		
		String fileName = null;
		
		while (true) {
			System.out.println("저장할 파일이름을 입력해주세요(QUIT:종료)");
			System.out.print(">> ");
			fileName = scan.nextLine();
			if (fileName.equals("QUIT")) {
				return;
			}
			if (fileName.equals("")) {
				System.out.println("파일이름은 반드시 입력해야합니다");
				continue;
			}
			break;
		} // end while()
		
		String fileName1 = "src/com/callor/word/" + fileName + ".txt";
		FileWriter fileWriter = null;
		PrintWriter out = null;

		try {
			fileWriter = new FileWriter(fileName1);
			out = new PrintWriter(fileWriter);
			
			UserVO userVO = vo;
			out.print(userVO.getScore() + ":");
			out.print(userVO.getWinCount() + ":");
			out.print(userVO.getLoseCount() + "\n");

			out.flush();
			out.close();
			System.out.println("저장 완료");
		} catch (IOException e) {
			System.out.println("파일을 생성할 수 없음");
		}
	} // end saveUserInfo()

	@Override
	public UserVO loadUserInfo() { //
		// TODO 유저정보 파일에서 불러오기
		
		FileReader fileReader = null;
		BufferedReader buffer = null;

		while(true) {
			System.out.println("불러올 파일이름을 입력하세요(QUIT:입력종료)");
			System.out.print(">> ");
			String fileName = scan.nextLine();
			if (fileName.equals("QUIT")) {
				return null;
			}
			String strFileName = "src/com/callor/word/" + fileName + ".txt";
							
			try {
				fileReader = new FileReader(strFileName);
				buffer = new BufferedReader(fileReader);

				String reader = buffer.readLine();
				String[] nums = reader.split(":");
				UserVO userVO = new UserVO();
				userVO.setScore(Integer.valueOf(nums[점수]));
				userVO.setWinCount(Integer.valueOf(nums[맞힌횟수]));
				userVO.setLoseCount(Integer.valueOf(nums[틀린횟수]));
				
				buffer.close();
				System.out.println("불러오기 완료");
				return userVO;  // UserVO형 userVO 객체정보를 호출한 GameService로 넘겨주기
				
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다");
				continue;
			} catch (IOException e) {
				System.out.println("파일을 읽는 도중 오류");
				continue;
			}
		} // end while()
	}
}
