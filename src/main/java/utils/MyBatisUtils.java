package utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatis工具类
 * Created by zhangkai on 2017/9/28.
 */
public class MyBatisUtils {

    private MyBatisUtils()
    {}

    private static class MyBatisUtilsHandle{
        private static MyBatisUtils INSTANCE = new MyBatisUtils();
    }

    public static MyBatisUtils getInstance()
    {
        return MyBatisUtilsHandle.INSTANCE;
    }

    /**
     * 根据配置文件获取SqlSessionFactory
     * @param confPath
     * @return
     */
    public SqlSessionFactory getSqlSessionFactroy(String confPath)
    {
        InputStream inputStream = MyBatisUtils.class.getClassLoader().getResourceAsStream(confPath);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        return factory;
    }

    public SqlSession getSqlSession(String confPath)
    {
        return getSqlSessionFactroy(confPath).openSession();
    }

    public SqlSession getSqlSession(String confPath, boolean isAutoCommit){
        return getSqlSessionFactroy(confPath).openSession(isAutoCommit);
    }


}
