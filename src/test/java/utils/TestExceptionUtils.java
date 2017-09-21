package utils;

import org.junit.Test;

import java.util.List;

/**
 * Created by zhangkai on 2017/9/18.
 */
public class TestExceptionUtils {
    @Test
    public void testGetExceptionStack()
    {
        System.out.println("test start");
        ExceptionUtils exceptionUtils = ExceptionUtils.getInstance();

        try {
            List<Integer> list = null;
            list.add(1);
        }catch (Exception e)
        {

            System.out.println(exceptionUtils.getExceptionStackTrace(e));
        }


    }

}
