import java.util.ArrayList;
import java.util.Arrays;

public class Modus {
    public int[] array;


//    public Modus(int[] arrayList){
//        this.array = arrayList;
//
//    }


//    public ArrayList<Integer> modus(){
//
//        int i = 0;
//        ArrayList<Integer> AlleModus = new ArrayList<>();
//        int modus = 0;
//        int maxFromAll = 0;
//        for (int aa : array){
//            int max = 0;
//            modus = array[i];
//            int e = 0;
//            while (e < array.length){
//                if (modus == array[e]){
//                    max++;
//                }
//                e++;
//            }
//            if (max >= maxFromAll){
//                if (max == maxFromAll){
//                    if (AlleModus.contains(array[i])){
//
//                    }
//                    else {
//                        AlleModus.add(array[i]);
//                    }
//                }
//                else if (max > maxFromAll){
//                    maxFromAll = max;
//                    AlleModus.clear();
//                    AlleModus.add(array[i]);
//                }
//            }
//            i++;
//
//        }
//        return AlleModus;
//
//    }




//    ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastDays(5);
//    ArrayList<Measurement> thisAfternoon = new ArrayList<>();
//    int i = 0;
//    int e = 0;
//          for(Object data : rawData){
//        thisAfternoon.add(new Measurement(rawData.get(i)) );
//    }
//
//    ArrayList<Double> thisMorning = new ArrayList<Double>();
//          for (Object aa : thisMorning){
//        thisMorning.add(thisAfternoon.get(e).getOutsideTemp());
//        e++;
//    }
//          System.out.println(thisMorning);

//        System.out.println(thisAfternoon.getOutsideTemp());
//
//        String strDouble = String.format("%.2f", thisAfternoon.getOutsideTemp());
//        HelperFunctions.WriteOnMatrixScreen("OutsideTemp " + strDouble + "    bovenste value is ooktemperatuur");
//        HelperFunctions.WriteValueOnSegments(1,thisAfternoon.getOutsideTemp(), 3);




    /**
     * get the mean of temperatures from the last hour
     */
//        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastHour();
//        ArrayList<Measurement>  measurements = new ArrayList<Measurement>();
//
//        Double mean = 0.0;
//        for (int i = 0; i < rawDatas.size(); i++)
//        {
//            measurements.add(new Measurement(rawDatas.get(i)));
//            mean += measurements.get(i).getOutsideTemp();
//        }
//        mean /= measurements.size();
//
//        System.out.println(mean);





//        System.out.println(thisAfternoon.getOutsideTemp());
//        DatabaseConnection.getMeasurementsLastMonths(3);
//        int[] values = {8, 3, 7, 9, 1, 2, 4,3,4};
//        Modus modus = new Modus(values);
//        System.out.println(modus.modus());
//
//        Period period = new Period(5);
//        System.out.println(period.getMeasurements());
}



