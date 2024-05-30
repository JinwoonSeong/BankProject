package kr.ac.kopo.account.dao;

import java.util.Random;

public class RandomAccountNumberGenerator {

    public static String generateRandomAccountNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        // 13자리의 랜덤 숫자 생성
        for (int i = 0; i < 13; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
