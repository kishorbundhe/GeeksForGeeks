package PublicFunctions;

public class CalculateTimeForProgram {
    public long start_time;
    public long end_time;

    public long startTime() {
        this.start_time = System.nanoTime();
        return start_time;
    }

    public long endTime() {
        this.end_time = System.nanoTime();
        return end_time;
    }

    public long timeInMilli() {
        return ((start_time - end_time) / 1000);
    }
}
