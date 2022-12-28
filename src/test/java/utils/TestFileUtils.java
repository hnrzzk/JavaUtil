package utils;

import org.junit.Test;

public class TestFileUtils {
    @Test
    public void testCalMd5() {
        String rootPath = PathUtils.getRootPath();
        System.out.println("rootPath:" + rootPath);
        String md5 = FileUtils.calFileMd5(rootPath+"/start.sh");
        System.out.println(md5);
        assert md5 != null && md5.equals("42120743891e5a20ba4a941a0b0757c2");
    }
}
