package com.sparta.ja;

public class PerformanceTimer {

    private static double startTime;

    private static double endTime;

    private static double totalTime;


    public static double getTotalTime() {
        return totalTime;
    }

    public static void setStartTime(double startTime) {
        PerformanceTimer.startTime = startTime;
    }

    public static void setEndTime(double endTime) {
        PerformanceTimer.endTime = endTime;
    }

    public static void setTotalTime() {
        totalTime = endTime - startTime;
        printPerformanceTime();
    }

    private static void printPerformanceTime() {
        System.out.println(totalTime + " seconds.");
    }
}
