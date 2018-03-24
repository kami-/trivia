package com.adaptionsoft.games.uglytrivia;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class QuestionDeck {
    private final Map<Category, LinkedList<String>> questions = new HashMap<>();

    public QuestionDeck() {
        Stream.of(Category.values()).forEach(type -> {
            List<String> list = IntStream.range(0, 50).mapToObj(index -> type + " Question " + index).collect(toList());
            questions.put(type, new LinkedList<>(list));
        });
    }

    public String getQuestion(Category category) {
        return questions.get(category).removeFirst();
    }
}

