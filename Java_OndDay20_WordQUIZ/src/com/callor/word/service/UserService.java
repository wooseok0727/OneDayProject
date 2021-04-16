package com.callor.word.service;

import com.callor.word.model.UserVO;

public interface UserService {

	public void saveUserInfo(UserVO vo);
	public UserVO loadUserInfo();
}
