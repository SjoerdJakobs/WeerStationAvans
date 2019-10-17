import java.time.LocalDate;

public enum SavedData
{
    INSTANCE;

    public Measurement LastMeasurement;
    public Period SavedPeriod;

    public void SetPeriod(LocalDate startOfPeriod, LocalDate endOfPeriod)
    {
        SavedPeriod = new Period(startOfPeriod, endOfPeriod);
    }

    public void setStepWidth(int stepWidth){
        int newStepWidth = stepWidth; 
    }


    public void SetLastMeasurement()
    {
        LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement());
    }
}
