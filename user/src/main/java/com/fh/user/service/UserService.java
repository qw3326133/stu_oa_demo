package com.fh.user.service;

import com.fh.user.model.User;
import com.fh.user.vo.UserVo;

import java.util.Map;

public interface UserService {

    void zc(User user);

    Map chaByName(String name);

    Map dl(User user);

    void upUser(User user);

    void delUser(String name);

    Map chaUser(UserVo uv);
}
