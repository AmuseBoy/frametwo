package com.amuse.frametwo.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName TestUtil
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/2 15:46
 * @Version 1.0
 */
public class TestUtil {

    public static void main(String[] args) {
        //System.out.println(UUID.randomUUID().toString());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }
}
