public enum SavedData
{
    INSTANCE;

    public Measurement LastMeasurement;
    public Period SavedPeriod;

    public void SetPeriod()
    {
        SavedPeriod = new Period(5);
        //todo
    }

    public void SetLastMeasurement()
    {
        LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement());
    }
}
