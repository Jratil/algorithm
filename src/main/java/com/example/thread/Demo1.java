package com.example.thread;

import jdk.internal.util.EnvUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author wen
 * @create 2019-07-27 22:23
 * {@link ThreadLocal}
 */
public class Demo1 {
    public static void main(String[] args) {

        String a = "aa";
        try {
            Files.write(Paths.get("/"), a.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
