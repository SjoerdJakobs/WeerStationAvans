import java.time.LocalDate;

public enum SavedData
{
    INSTANCE;

    // VARIABLES
    public Measurement LastMeasurement;
    public Period SavedPeriod = new Period(LocalDate.of(2010, 1, 1), LocalDate.of(2010, 1, 31));
    public int graphStep = SetGraphStep();
    public double graphSpeed = 0.06; // 3 different speeds: slow (0.15), medium (0.06) or fast (0.02)

    /**
     * Re-calculate all results of the new period
     * @param startOfPeriod Begin date of the period
     * @param endOfPeriod End date of the period
     */
    public void SetPeriod(LocalDate startOfPeriod, LocalDate endOfPeriod) {
        SavedPeriod = new Period(startOfPeriod, endOfPeriod);
        SetGraphStep();
    }

    /**
     * Set latest measurement
     */
    public void SetLastMeasurement() {
        LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement());
    }

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
     * Set the graph's step by (user) input
     * @param graphStep the number of measurements that goes in one dot on the DotMatrixDisplay
     */
    public void SetGraphStep(int graphStep) {
        this.graphStep = graphStep;
    }

    /**
     * Set the graph's speed by (user) input
     * @param graphSpeed Time in seconds each time the graph shows one step (dot) of the graph
     */
    private void SetGraphSpeed(double graphSpeed) {
        this.graphSpeed = graphSpeed;
    }

}
