package com.dream.mentor;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

/**
 * Created by Administrator on 2017/5/19.
 */
public class TestCommandLine {
    public static void main(String[]args){
        String line = "python  C:\\python_test\\list_dir_file_name.py";
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            int exitValue = executor.execute(cmdLine);
            System.out.print("exitValue_"+exitValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
