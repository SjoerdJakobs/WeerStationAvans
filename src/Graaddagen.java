import java.time.LocalDateTime;
import java.util.ArrayList;

public class Graaddagen {

    public LocalDateTime begin;
    public LocalDateTime end;


    public Graaddagen(LocalDateTime begin, LocalDateTime end){

        this.begin = begin;
        this.end = end;
    }


    public int calculateGraaddagen(){
        int graaddagen = 0;
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsBetween(begin,end);
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();
        int degreeDifference;

        for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
        }

        int prevDate = measurements.get(0).getDateStamp().getDayOfYear();

        int OriginalDate = prevDate;
        ArrayList<Double> dayTemps = new ArrayList<>();
        for (int counter = 0; counter<measurements.size(); counter++){
            if (measurements.get(counter).getDateStamp().getDayOfYear() == prevDate) {
                dayTemps.add(temperature.get(counter));
            }
            else if (measurements.get(counter).getDateStamp().getDayOfYear() != prevDate) {

               int RoundedAveragePlusOne = (int)MSD.mean(dayTemps)+1;
               double CorrectAverage = MSD.mean(dayTemps);
               double offrounderDecider = (double)RoundedAveragePlusOne - CorrectAverage;
               if (offrounderDecider < 0.5){
                   degreeDifference = 18 - RoundedAveragePlusOne;
               }
               else {
                   degreeDifference = 18 - (int)MSD.mean(dayTemps);
               }

                 if (degreeDifference > 0){
                     graaddagen = graaddagen + degreeDifference;
                 }
                 dayTemps.clear();
                 prevDate = measurements.get(counter).getDateStamp().getDayOfYear();

            }


                }
        if (prevDate == OriginalDate && graaddagen == 0){
            degreeDifference = 18 - (int)MSD.mean(dayTemps);
            graaddagen = graaddagen + degreeDifference;
        }
        return graaddagen;
            }
    }

