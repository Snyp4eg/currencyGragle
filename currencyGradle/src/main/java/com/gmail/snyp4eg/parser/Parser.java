package com.gmail.snyp4eg.parser;

import java.util.List;

public interface Parser<T> {
    List<T> parse(String jsonString);
}
