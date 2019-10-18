import java.time.LocalDate;

public enum SavedData
{
    INSTANCE;

    public Measurement LastMeasurement;
    public Period SavedPeriod = new Period(LocalDate.of(2010, 1, 1), LocalDate.of(2010, 12, 31));
    public int graphStep = SetGraphStep();


    private int SetGraphStep() {
        int nMeasurements = SavedPeriod.getDataStorage().getPeriodMeasurements().size();
        int nDisplayShifts = 5;
        int graphStep = nMeasurements / (nDisplayShifts * 128); // DotMatrixDisplay has a width of 128 dots
        if (graphStep <= 100) return graphStep;
        else return 100;
    }

    public void SetPeriod(LocalDate startOfPeriod, LocalDate endOfPeriod) {
        SavedPeriod = new Period(startOfPeriod, endOfPeriod);
    }

    public void setStepWidth(int graphStep) {
        this.graphStep = graphStep;
    }


    public void SetLastMeasurement() {
        LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement());
    }
}
