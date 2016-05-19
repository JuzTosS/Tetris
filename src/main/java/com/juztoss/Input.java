package com.juztoss;

import java.io.InputStreamReader;

/**
 * Created by 1 on 12.05.2016.
 */
public class Input implements Runnable {
    private InputStreamReader mInputReader = new InputStreamReader(System.in);
    private IInputReceiver mReceiver;

    public Input(IInputReceiver receiver) {
        mReceiver = receiver;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (mInputReader.ready())
                    mReceiver.receive(mInputReader.read());
            } catch (Exception e) {
                //Ignore error
            }
        }
    }

    public interface IInputReceiver {
        void receive(int character);
    }
}
