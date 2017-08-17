package com.learn.queue.demo1;

import java.io.*;

/**
 * 使用io,编写一个工具类,主要是对对象转换为字节数组,将字节数组转换为对象的功能.
 */
public class ObjectUtils {

    /**
     * 对象转换为字节数组
     *
     * @param object 要转换的对象
     * @return 字节数组
     * @throws IOException
     */
    public static byte[] objectToByteArr(Object object) throws IOException {
        //获取字节数组输出流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        //将对象转换为字节数组,写入内存
        oos.writeObject(object);
        //获取字节数组
        byte[] bytes = bos.toByteArray();
        //关闭资源
        bos.close();
        oos.close();
        return bytes;
    }

    /**
     * 字节数组转换为对象
     *
     * @param bytes
     * @return
     */
    public static Object bytesToObject(byte[] bytes) throws Exception {
        //创建字节输入流
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        //创建对象输入流
        ObjectInputStream oin = new ObjectInputStream(bin);
        return oin.readObject();

    }

}
