package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils {
    public static String calFileMd5(String path) {
        try(FileInputStream fileInputStream = new FileInputStream(path)) {
            return calFileMd5(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String calFileMd5(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            return calFileMd5(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String calFileMd5(FileInputStream fileInputStream) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }

            byte[] byteArray = md5.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : byteArray) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
