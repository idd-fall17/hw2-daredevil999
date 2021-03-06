package com.example.androidthings.myproject;

import java.util.HashMap;

/**
 * Created by KiANMiNG on 8/9/2017.
 */

public class MorseCodeDecoder {

    private HashMap<String,Character> morseCodeMap;

    public MorseCodeDecoder() {
        morseCodeMap = new HashMap<String,Character>();
        setup();
    }

    private void setup() {
        morseCodeMap.put(".-",'a');
        morseCodeMap.put("-...",'b');
        morseCodeMap.put("-.-.",'c');
        morseCodeMap.put("-..",'d');
        morseCodeMap.put(".",'e');
        morseCodeMap.put("..-.",'f');
        morseCodeMap.put("--.",'g');
        morseCodeMap.put("....",'h');
        morseCodeMap.put("..",'i');
        morseCodeMap.put(".---",'j');
        morseCodeMap.put("-.-",'k');
        morseCodeMap.put(".-..",'l');
        morseCodeMap.put("--",'m');
        morseCodeMap.put("-.",'n');
        morseCodeMap.put("---",'o');
        morseCodeMap.put(".--.",'p');
        morseCodeMap.put("--.-",'q');
        morseCodeMap.put(".-.",'r');
        morseCodeMap.put("...",'s');
        morseCodeMap.put("-",'t');
        morseCodeMap.put("..-",'u');
        morseCodeMap.put("...-",'v');
        morseCodeMap.put(".--",'w');
        morseCodeMap.put("-..-",'x');
        morseCodeMap.put("-.--",'y');
        morseCodeMap.put("--..",'z');

        morseCodeMap.put(".----",'1');
        morseCodeMap.put("..---",'2');
        morseCodeMap.put("...--",'3');
        morseCodeMap.put("....-",'4');
        morseCodeMap.put(".....",'5');
        morseCodeMap.put("-....",'6');
        morseCodeMap.put("--...",'7');
        morseCodeMap.put("---..",'8');
        morseCodeMap.put("----.",'9');
        morseCodeMap.put("-----",'0');
        morseCodeMap.put("----",' ');
    }

    /**
     * Reads in a string of dots and dashes
     * @throws IllegalValueException when input string cannot be matched
     */
    public char decodeInput(String inputStr) throws IllegalValueException {
        char outputChar;
        inputStr = inputStr.trim();
        if (!morseCodeMap.containsKey(inputStr)) {
            throw new IllegalValueException("Input values are not valid");
        } else {
            outputChar = morseCodeMap.get(inputStr).charValue();
        }
        return outputChar;
    }
}
