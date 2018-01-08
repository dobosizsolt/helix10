package com.company;

import java.io.*;
import java.util.ArrayList;

public class SacramentoUtil {
    private ArrayList<Crime> crimes;

    public SacramentoUtil() {
        this.crimes = new ArrayList<>();
    }


    public void readSacramentoCSV() throws IOException{

        try (BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\Helix8\\Desktop\\DZs")))) {


            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                if (i > 0) {
                    String[] csvRow = line.split(",");
                    Crime crime = new Crime();
                    crime.setcDateTime(csvRow[0]);
                    crime.setAddress(csvRow[1]);
                    crime.setDistrict(Integer.parseInt(csvRow[2]));
                    crime.setBeat(csvRow[3]);
                    crime.setGrid(Integer.parseInt(csvRow[4]));
                    crime.setCrimeDescr(csvRow[5]);
                    crime.setUcrNcicCode(Integer.parseInt(csvRow[6]));
                    crime.setLatitude(Float.parseFloat(csvRow[7]));
                    crime.setLongtitude(Float.parseFloat(csvRow[8]));

                    crimes.add(crime);

                }
                ++i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


