package com.master.template.service.util;

import org.apache.commons.lang.RandomStringUtils;


public final class RandomUtil {

    private static final int DEF_COUNT = 20;
    private static final int DEF_USER_NAME= 5;
    private static final int DEF_USER_PASSWORD= 6;
    private static final int DEF_REGISTER= 10;
    private static final int DEF_REGISTER_ONLINE=10;
    private RandomUtil() {
    }
    public static long generateRegisterOnline() {

        return Long.parseLong(RandomStringUtils.randomNumeric(DEF_REGISTER_ONLINE));
    }

    public static String generateUserName() {
        return RandomStringUtils.randomNumeric(DEF_USER_NAME);
    }

    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_USER_PASSWORD);
    }

    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    public static String generateResetKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    public static String generateNoRegister() {
        return RandomStringUtils.randomAlphanumeric(DEF_REGISTER);
    }
}
