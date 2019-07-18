package com.jrg.demo2.entity;

import lombok.Data;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/7 13:41
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/7 13:41
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
@Data
public class UserEntity {
    private String userName;
    private String userId;


    public UserEntity(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
