public enum SavedData
{
    INSTANCE;

    public Measurement LastMeasurement;
    public Period SavedPeriod;

    public void SetPeriod()
    {
        //todo
    }

    public void SetLastMeasurement()
    {
        LastMeasurement = new Measurement(DatabaseConnection.getMostRecentMeasurement());
    }
}
