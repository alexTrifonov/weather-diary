package ru.weather.diary.enums;

public enum WindDirection {
    NORTH (338, 22),
    NORTH_EAST(23, 67),
    EAST(68, 112),
    SOUTH_EAST(113,157),
    SOUTH(158, 202),
    SOUTH_WEST(203,247),
    WEST(248, 292),
    NORTH_WEST(293, 337);
    private final int startDegree;
    private final int endDegree;
    WindDirection(int startDegree, int endDegree) {
        this.startDegree = startDegree;
        this.endDegree = endDegree;
    }
    public int getStartDegree() {
        return startDegree;
    }
    public int getEndDegree() {
        return endDegree;
    }
}
