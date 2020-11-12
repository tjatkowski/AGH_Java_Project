package agh.cs.lab2.utility;


import static java.util.Arrays.copyOfRange;

public class OptionsParser {
    public static MoveDirection[] parse(String[] strings) {
        MoveDirection[] directions = new MoveDirection[strings.length];
        int index = 0;
        for(String str : strings) {
            switch (str) {
                case "f": case "forward":{
                    directions[index++] = MoveDirection.FORWARD;
                    break;
                }
                case "r": case "right": {
                    directions[index++] = MoveDirection.RIGHT;
                    break;
                }
                case "b": case "backward":{
                    directions[index++] = MoveDirection.BACKWARD;
                    break;
                }
                case "l": case "left":{
                    directions[index++] = MoveDirection.LEFT;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Wrong direction has been given: " + str);
                }
            }
        }
        return copyOfRange(directions, 0, index);   // po co copyOfRange, skoro będziemy mieli tyle kierunków ile zaplanowaliśmy?
    }
}
