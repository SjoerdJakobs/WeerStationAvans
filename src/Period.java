import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;

/**
 * A class to contain a period of time
 *
 * @author Johan Talboom
 * Revised by team A3
 * @version 2.2
 */
public class Period {
    private LocalDate beginPeriod;
    private LocalDate endPeriod;
    private PeriodData dataStorage = new PeriodData();

    /**
     * default constructor, sets the period to today1
     */
    public Period() {
        beginPeriod = LocalDate.now();
        endPeriod = LocalDate.now();
        Init();
    }

    /**
     * Constructor which sets the period to two set start and end dates.
     * @param beginPeriod Given start of the period.
     * @param endPeriod Given end of the period.
     */
    public Period(LocalDate beginPeriod, LocalDate endPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
        Init();
    }

    /**
     * Constructor which sets the period from a start period to today.
     * @param beginPeriod Given start of the period.
     */
    public Period(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = LocalDate.now();
        Init();
    }

    /**
     * Constructor which sets the period to a given amount of days ago .
     * @param days Given amount of days in the period.
     */
    public Period(int days) {
        this.beginPeriod = LocalDate.now().minus(java.time.Period.ofDays(days));
        this.endPeriod = LocalDate.now();
        Init();
    }

    /**
     * Initializes the process of automatically grabbing, converting, calculating and setting all data in the period.
     */
    private void Init() {
        dataStorage.setPeriodMeasurements(getMeasurements());
        dataStorage.setData();
    }

    /**
     * Simple setter for start of period
     */
    public void setStart(int year, int month, int day) {
        beginPeriod = LocalDate.of(year, month, day);
    }

    /**
     * simple setter for end of period
     */
    public void setEnd(int year, int month, int day) {
        endPeriod = LocalDate.of(year, month, day);
    }

    /**
     * alternative setter for start of period
     *
     * @param beginPeriod Start of the period.
     */
    public void setStart(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    /**
     * alternative setter for end of period
     *      *
     * @param endPeriod End of the period.
     */
    public void setEnd(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    /**
     * calculates the number of days in the period
     */
    public long numberOfDays() {
        return ChronoUnit.DAYS.between(beginPeriod, endPeriod);
    }


    /**
     * gets all raw measurements of this period from the database
     * @return a list of raw measurements
     */
    private ArrayList<RawMeasurement> getRawMeasurements() {
        return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
    }

    /**
     * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
     * @return a filtered list of measurements
     */
    private ArrayList<Measurement> getMeasurements() {
        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
        for (RawMeasurement rawMeasurement : rawMeasurements) {
            Measurement measurement = new Measurement(rawMeasurement);
            measurements.add(measurement);
        }
        return measurements;
    }

    /**
     * Returns the DataStorage
     * @return The DataStorage of the Period.
     */
    public PeriodData getDataStorage() {
        return dataStorage;
    }
}
