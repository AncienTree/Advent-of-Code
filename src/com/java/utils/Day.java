package com.java.utils;

import java.io.File;

public interface Day {
    public default void run() {
        puzzle1();
        puzzle2();
    }
    public void puzzle1();
    public void puzzle2();
}
