package com.jrg.demo2;

import com.jrg.demo2.entity.UserEntity;
import com.jrg.demo2.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/7 13:59
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/7 13:59
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
public class testDemo implements Runnable {
    private List<UserEntity> listUser;

    public testDemo(List<UserEntity> listUser) {
        this.listUser = listUser;
    }

    public static void main(String[] args) {
        //初始化
        List<UserEntity> userEntities =  intiUser();
        int userCont = 2;
        List<List<UserEntity>> users = ListUtils.splitList(userEntities,userCont);
        for (List<UserEntity> user: users) {
            testDemo testDemo = new testDemo(user);
            for (UserEntity u:user) {
                System.out.println(u.toString());
            }
            System.out.println();
            //Thread thread = new Thread(testDemo);
            //thread.start();
        }
    }
    //初始化数据
    static private List<UserEntity> intiUser(){
        List<UserEntity> list = new ArrayList<>();
        for(int i=0;i<=11;i++){
            list.add(new UserEntity("aa"+i,"bb"+i));
        }
        return list;
    }

    @Override
    public void run() {

    }
}
