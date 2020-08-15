package data;

import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseToCSVFile {

    public static boolean writerToCSV() {
        try (PrintWriter writer = new PrintWriter(new File("data.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Country,");
            sb.append("CountryCode,");
            sb.append("Province,");
            sb.append("City,");
            sb.append("Lat,");
            sb.append("Lon,");
            sb.append("Confirmed,");
            sb.append("Deaths,");
            sb.append("Recovered,");
            sb.append("Active,");
            sb.append("Date");
            sb.append("\n");

            // bug around here.
            HashMap<String, ArrayList<DataObject>> data = ParseJsonObject.parseJson();
            int count = 0;
            for (String country : data.keySet()) {
                for(DataObject element : data.get(country)){
                    if(element.Date.equals("2020-03-01T00:00:00Z")){
                        sb.append(element.Country);
                        sb.append(element.CountryCode);
                        sb.append(element.Province);
                        sb.append(element.City);
                        sb.append(element.Lat);
                        sb.append(element.Lon);
                        sb.append(element.Confirmed);
                        sb.append(element.Deaths);
                        sb.append(element.Recovered);
                        sb.append(element.Active);
                        sb.append(element.Date);
                        sb.append("\n");
                        count++;
                        break;
                    }
                }
                if(count == 5){
                    return true;
                }
            }
            writer.append(sb.toString());

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
