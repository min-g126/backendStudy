package com.greedy.level02.normal;

import java.util.Random;

public class RandomMaker {
    Random random = new Random();
    public int randomNumber(int min, int max){
        //최소값부터 최대값까지 범위의 난수 반환함
        int randomNum= random.nextInt(max - min +1)+min;
        return randomNum;
    }

    public String randomUpperAlphabet(int length){
        //인자의 길이 만큼의 랜덤한 대문자 알파벳으로 이루어진 문자열을 반환함
        String randomStr = "";
        for (int i = 0; i < length; i++) {
            // ASCII 코드에서 대문자 알파벳은 65('A')부터 90('Z')까지
            char randomChar = (char) (random.nextInt(26) + 65);
            randomStr += randomChar;
        }
        return randomStr;
    }

    public String  rockPaperScissors(){
        //가위, 바위, 보 중 한가지를 반환함
        int randomNum = random.nextInt(3);

        switch (randomNum) {
            case 0:
                return "가위";
            case 1:
                return "바위";
            case 2:
                return "보";
            default:
                return "";
        }
    }

    public String  tossCoin(){
        //동전의 앞면, 뒷면 중 한 가지를 반환함
        int randomNum = random.nextInt(2);

        switch (randomNum){
            case 0 :
                return "앞면";
            case 1 :
                return "뒷면";
            default:
                return " ";
        }
    }



}
