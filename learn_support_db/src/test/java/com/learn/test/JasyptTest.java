package com.learn.test;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author 张伟
 * @version V1.0.0
 * @projectName learn_parent
 * @title JasyptTest
 * @package com.learn.test
 * @description 加密测试类
 * @date 2018/12/25 13:26
 */
public class JasyptTest {
    public static void main(String[] args) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        //加密所需要的盐
        basicTextEncryptor.setPassword("I'm very handsome");
        //String zhangwei = basicTextEncryptor.encrypt("zhangwei");
        String zhangwei = basicTextEncryptor.encrypt("Iamveryhandsome");
        System.out.println(zhangwei);
    }
}
