import java.time.LocalDateTime;
import java.util.ArrayList;

public class Graaddagen {

//    public LocalDateTime begin;
//    public LocalDateTime end;
    public int days;
    public Graaddagen(int days){
//        this.begin = begin;
//        this.end = end;
        this.days = days;
    }

    public int calculateGraaddagen(){
        int graaddagen = 0;
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastDays(days);
//        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(2019, 9,29,00,00), LocalDateTime.of(2019, 10,05,00,00));
//                                                                                                        System.out.println("rawDatas.size = "+rawDatas.size());
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();
        int gradenVerschil;

        for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
        }
//                                                                                                        System.out.println("measurements.size = "+measurements.size());
//                                                                                                        System.out.println("temperature.size = "+temperature.size());

        int prevDate = measurements.get(0).getDateStamp().getDayOfYear();
//                                                                                                        System.out.println("prevDate = "+prevDate);
//                                                                                                        System.out.println("");
//                                                                                                        System.out.println("=========");
//                                                                                                        System.out.println("");
        int OriginalDate = prevDate;
        ArrayList<Double> dagTemps = new ArrayList<>();
        for (int counter = 0; counter<measurements.size(); counter++){
            if (measurements.get(counter).getDateStamp().getDayOfYear() == prevDate) {
                dagTemps.add(temperature.get(counter));
//                                                                                                            System.out.println(measurements.get(teller).getDateStamp().getHour()+":"+measurements.get(teller).getDateStamp().getMinute());
            }
            else if (measurements.get(counter).getDateStamp().getDayOfYear() != prevDate) {
//                                                                                                         System.out.println("dagTemps.size() = "+dagTemps.size());
                 gradenVerschil = 18 - (int)MSD.mean(dagTemps);
//                                                                                                         System.out.println("gradenVerschil = "+gradenVerschil);
//                                                                                                         System.out.println("average = "+MSD.mean(dagTemps));
                 if (gradenVerschil > 0){
                     graaddagen = graaddagen + gradenVerschil;
                 }
                 dagTemps.clear();
                 prevDate = measurements.get(counter).getDateStamp().getDayOfYear();
//                                                                                                        System.out.println("prevDate = "+prevDate);
//                                                                                                        System.out.println("");
            }


                }
        if (prevDate == OriginalDate && graaddagen == 0){
            gradenVerschil = 18 - (int)MSD.mean(dagTemps);
            graaddagen = graaddagen + gradenVerschil;
        }
        return graaddagen;
            }






    }

