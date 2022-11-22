package utils;

import java.net.URL;

public class PathUtils {
    static final String JAVA_INNER_SEPARATOR = "!/";
    static final String JAVA_SEPARATOR = "/";
    public static String getRootPath() {
        URL rootURL = Thread.currentThread().getContextClassLoader().getResource("");
        if (null == rootURL) {
            return null;
        }
        String rootPath = rootURL.getPath();
        int innerSeparatorIndex = rootPath.indexOf(JAVA_INNER_SEPARATOR);
        if (-1 == innerSeparatorIndex) {
            return rootPath;
        }

        String jarPath = rootPath.substring(0, innerSeparatorIndex);
        int lastFileSeparatorIndex = jarPath.lastIndexOf(JAVA_SEPARATOR);
        if (-1 == lastFileSeparatorIndex) {
            return null;
        }
        return jarPath.substring(0, lastFileSeparatorIndex);
    }
}
