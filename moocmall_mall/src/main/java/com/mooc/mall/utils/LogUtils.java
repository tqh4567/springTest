package com.mooc.mall.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
@Component
public class LogUtils {
    private static boolean fileLog = true;
    @Value("${myLog.url}")
    private  String logFileName;// 指定程序执行结果保存的文件路径

    public  OutputStream getOutputStream() throws IOException {
        if (fileLog) {
            File file = new File(logFileName);
            if (!file.exists())
                file.createNewFile();
            return new FileOutputStream(file, true);
        } else {
            return System.out;
        }
    }

    public  void log(String info) throws IOException {
        OutputStream out = getOutputStream();
        out.write(info.getBytes("utf-8"));
    }
}
