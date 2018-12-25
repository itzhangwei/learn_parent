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
 * @copyright: 2018 北京君致速达科技有限公司
 */
public class JasyptTest {
    public static void main(String[] args) {
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        //加密所需要的盐
        basicTextEncryptor.setPassword("I'm very handsome");
        String zhangwei = basicTextEncryptor.encrypt("zhangwei");
        System.out.println(zhangwei);
    }
}
