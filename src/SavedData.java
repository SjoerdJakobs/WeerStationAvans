import java.time.LocalDate;

public enum SavedData
{
    INSTANCE;

    // VARIABLES
    private Measurement LastMeasurement;
    private Period SavedPeriod = new Period(LocalDate.of(2010, 7, 1), LocalDate.of(2010, 7, 31));

    private int graphStep = SetGraphStep();
    private double graphSpeed = 0.02; // 3 different speeds: slow (0.15), medium (0.06) or fast (0.02)

    /**
     * Re-calculate all results of the new period
     * @param startOfPeriod Begin date of the period
     * @param endOfPeriod End date of the period
     */
    public void SetPeriod(LocalDate startOfPeriod, LocalDate endOfPeriod) {
        SavedPeriod = new Period(startOfPeriod, endOfPeriod);
        SetGraphStep(); }
    public Period GetPeriod() { return SavedPeriod; }

    /**
     * Set and get latest measurement
     */
    public void SetLastMeasurement() {LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement()); }
    public Measurement GetLastMeasurement() { return LastMeasurement; }


    /**
     * Set the graph's step based on the number of measurements
     * @return graphStep with a max tep of 200
     */
    public int SetGraphStep() {
        int nMeasurements = SavedPeriod.getDataStorage().getPeriodMeasurements().size();
        int nDisplayShifts = 5;
        int graphStep = nMeasurements / (nDisplayShifts * 128); // DotMatrixDisplay has a width of 128 dots
        if (graphStep <= 100) return graphStep;
        else return 200;
    }

    /**
     * Set and get the graph's step
     * @param graphStep the number of measurements that goes in one dot on the DotMatrixDisplay
     */
    public void SetGraphStep(int graphStep) { this.graphStep = graphStep; }
    public int GetGraphStep() { return graphStep; }

    /**
     * Set and get the graph's speed
     * @param graphSpeed Time in seconds each time the graph shows one step (dot) of the graph
     */
    public void SetGraphSpeed(double graphSpeed) { this.graphSpeed = graphSpeed; }
    public double GetGraphSpeed() { return graphSpeed; }

}
