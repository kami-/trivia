package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.IPrinter;

public class SystemOutPrinter implements IPrinter {
    @Override
    public void print(Object message) {
        System.out.println(message);
    }
}
