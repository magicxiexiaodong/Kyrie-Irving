package com.xxd.test;

import com.xxd.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: XiaoDong.Xie
 * @DateTime: 2019/10/31 9:58
 * @Description: 测试mybatis源码
 */
public class testMain {
    public static void main(String[] args) throws IOException {
        Dept dept = new Dept();
        dept.setDname("人工智能部门");
        dept.setLoc("杭州");
        InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("insertDept",dept);
        session.commit();
        session.close();
    }
}
