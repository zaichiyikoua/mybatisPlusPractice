package com.zaichiyikou.starter.sys.service.impl;

import com.zaichiyikou.starter.sys.pojo.User;
import com.zaichiyikou.starter.sys.mapper.UserMapper;
import com.zaichiyikou.starter.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zaichiyikoua
 * @since 2020-04-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
