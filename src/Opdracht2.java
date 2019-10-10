import java.util.ArrayList;

/**
 * Author: Kim
 * Bepaal hoe vaak binnen een periode de binnen- en buitentemperatuur elkaar inhalen. Hiermee
 * bedoelen we dat op een moment de buitentemperatuur boven de binnentemperatuur komt of
 * omgekeerd binnentemperatuur boven de buitentemperatuur komt.
 */
/*
public class Opdracht2 {

    public static double tempChange(ArrayList<Measurement> inside, ArrayList<Double> outside){
        int count = 0;
        double insideTemp = inside.get(0).getInsideTemp();
        double outsideTemp = inside.get(0).getOutsideTemp();

        boolean colderOutside = true;

        if (outsideTemp < insideTemp){
            colderOutside = true;
        } else {
            colderOutside = false;
        }

        for(int i = 0; i < inside.size(); i++){
            insideTemp = inside.get(i).getInsideTemp();
            outsideTemp = inside.get(i).getOutsideTemp();

            if (colderOutside == true && insideTemp > outsideTemp) {
                count++;
                colderOutside = false;
                System.out.println(inside.get(i).getDateStamp());
            } else if (colderOutside == false && outsideTemp > insideTemp){
                count++;
                colderOutside = true;
                System.out.println(inside.get(i).getDateStamp());

            }
        }

        return count;
    }

}*/
