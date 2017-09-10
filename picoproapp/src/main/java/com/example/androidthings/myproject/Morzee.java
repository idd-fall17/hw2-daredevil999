package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * HW2 Text Entry Device - Morzee
 * Kianming Phua
 */

public class Morzee extends SimplePicoPro {

    public MorseCodeDecoder decoder;
    public String curStr;

    public Morzee() {
        decoder = new MorseCodeDecoder();
        curStr = "";
    }

    @Override
    public void setup() {

        //dot button
        pinMode(GPIO_128, Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        //dash button
        pinMode(GPIO_39, Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        //backspace button
        pinMode(GPIO_37, Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);

        //enter button
        pinMode(GPIO_35, Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);
    }

    @Override
    public void loop() {
    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);

        //dot
        if(pin==GPIO_128 && value==HIGH) {
            curStr = curStr + ".";
            printCharacterToMorseScreen('·');
        }

        //dash
        else if(pin==GPIO_39 && value==HIGH) {
            curStr = curStr + "-";
            printCharacterToMorseScreen('—');
        }

        //backspace
        else if(pin==GPIO_37 && value==HIGH) {
            backspaceCharacterOnTextScreen();
        }

        // enter
        else if(pin==GPIO_35 && value==HIGH) {
            try {
                char curChar;
                curChar = decoder.decodeInput(curStr);
                clearStringOnMorseScreen();
                printCharacterToTextScreen(curChar);
            } catch (IllegalValueException e) {
                curStr = "";
                clearStringOnMorseScreen();
            }
            curStr = "";
        }
    }
}
