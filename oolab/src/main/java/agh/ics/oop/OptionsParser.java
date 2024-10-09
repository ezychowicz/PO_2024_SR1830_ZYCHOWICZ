package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input){
        int validCnt = 0;  //zlicza litery w inpucie, które znajdują się w zbiorze: {f,b,r,l}
        for (String arg : input){
            if (arg.equals("f") || arg.equals("b") || arg.equals("r") || arg.equals("l")){
                validCnt++;
            }
        }

        MoveDirection[] moves = new MoveDirection[validCnt];
        int cnt = 0;
        for (String letter : input) {
            switch (letter) {
                case "f" -> {
                    moves[cnt] = MoveDirection.FORWARD;
                    cnt++;
                }
                case "b" -> {
                    moves[cnt] = MoveDirection.BACKWARD;
                    cnt++;
                }
                case "r" -> {
                    moves[cnt] = MoveDirection.RIGHT;
                    cnt++;
                }
                case "l" -> {
                    moves[cnt] = MoveDirection.LEFT;
                    cnt++;
                }
            }
        }
        return moves;
    }
}
