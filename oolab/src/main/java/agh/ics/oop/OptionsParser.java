package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] input){ // zwracamy typ MoveDirection
        int validCnt = 0;
        for (String arg : input){
            if (arg.equals("f") || arg.equals("b") || arg.equals("r") || arg.equals("l")){
                validCnt++;
            }
        }
        MoveDirection[] moves = new MoveDirection[validCnt];
        int cnt = 0;
        for (String arg : input) {
            switch (arg) {
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
