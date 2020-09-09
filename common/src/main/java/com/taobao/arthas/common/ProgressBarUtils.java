package com.taobao.arthas.common;

/**
 * @author: kaixinbaba
 * @date: 2020/9/9 10:03 下午
 * @description:
 */
public class ProgressBarUtils {

    private static final int PROGRESS_SIZE = 50;
    private static final int BITE = 2;
    private static final char FINISHED = '█';
    private static final char UNFINISHED = '─';

    private static String getNChar(int num, char ch){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < num; i++){
            builder.append(ch);
        }
        return builder.toString();
    }

    public static void printProgressBar(String format, double currentSize, double totalSize) {
        int index = Double.valueOf(currentSize / totalSize * 100).intValue();

        String finish = getNChar(index / BITE, FINISHED);
        String unFinish = getNChar(PROGRESS_SIZE - index / BITE, UNFINISHED);

        String progressBar = String.format("%3d%%├%s%s┤", index, finish, unFinish);
        String target = String.format("\r" + format, progressBar);
        System.out.print(target);
    }
}
