import java.util.ArrayList;

/*
public class Opdracht2 {

   /**
     * Author: Kim
     * This function gets the outside and inside temperature and checks if they cross each other in a given period of time.
     * @param inside consists of the inside temperatures measured in the given time period.
     * @param outside consists of the outside temperatures measured in the given time period.
     * Count: keeps track of the amount of times the inside temperature crosses the outside temperature.
     * colderOutside: checks if the outside and inside temperature cross each other, and sets it to either false or true for the rest
     *                of the time until the two temperatures cross each other again.
     */
    /*public static double tempChange(ArrayList<Measurement> inside, ArrayList<Measurement> outside) {
            int count = 0;
            double insideTemp = inside.get(0).getInsideTemp();
            double outsideTemp = outside.get(0).getOutsideTemp();

            boolean colderOutside = true;

            if (outsideTemp < insideTemp) {
            colderOutside = true;
            } else {
                colderOutside = false;
            }

            for (int i = 0; i < inside.size(); i++) {
                insideTemp = inside.get(i).getInsideTemp();
                outsideTemp = outside.get(i).getOutsideTemp();

                if (!Double.isNaN(insideTemp) && !Double.isNaN(outsideTemp)){
                if (colderOutside == true && insideTemp > outsideTemp) {
                count++;
                colderOutside = false;
                System.out.println(inside.get(i).getDateStamp());
                } else if (colderOutside == false && outsideTemp > insideTemp) {
                    count++;
                    colderOutside = true;
                    System.out.println(inside.get(i).getDateStamp());

                }
            }
        }
        return count;
    }
}*/
