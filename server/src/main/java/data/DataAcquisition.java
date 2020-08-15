package data;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DataAcquisition {

    public static void main(String[] args) throws IOException, InterruptedException {

        if(ParseToCSVFile.writerToCSV()){
            System.out.println("yess!!");
        }



    }

}