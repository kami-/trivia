package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.uglytrivia.IPrinter;

public class SystemOutPrinterMock implements IPrinter {
    private StringBuilder builder = new StringBuilder();

    @Override
    public void print(Object message) {
        builder.append(message.toString()).append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
