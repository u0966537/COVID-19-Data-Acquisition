package data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseJsonObject {

    public static HashMap<String, ArrayList<DataObject>> parseJson() throws IOException, InterruptedException {
        JSONArray countries = ReadJsonObject.readJsonFromUrl("https://api.covid19api.com/countries");

        // Add countries into the map:
        HashMap<String, ArrayList<DataObject>> countriesMap = new  HashMap<>();
        for(int i = 0; i < countries.length(); i++){
            countriesMap.put(countries.getJSONObject(i).getString("ISO2"), new ArrayList<>());
        }

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        String url ="https://api.covid19api.com/country/";
        String startDate = "?from=2020-01-22T00:00:00Z&to=";
        String endDate = now.toString();
        StringBuilder wholeUrl = new StringBuilder("");

        int count = 0;
        int total = 0;
        for(String country : countriesMap.keySet()){

            wholeUrl.setLength(0);
            wholeUrl.append(url);
            wholeUrl.append(country);
            wholeUrl.append(startDate);
            wholeUrl.append(endDate);

            JSONArray datas = ReadJsonObject.readJsonFromUrl(wholeUrl.toString());
            if(datas != null) {
                for (int i = 0; i < datas.length(); i++) {
                    JSONObject temp = datas.getJSONObject(i);
                    DataObject dataObject = new DataObject(temp.getString("Country"),
                            temp.getString("CountryCode"),
                            temp.getString("Province"),
                            temp.getString("City"),
                            temp.getDouble("Lat"),
                            temp.getDouble("Lon"),
                            temp.getInt("Confirmed"),
                            temp.getInt("Deaths"),
                            temp.getInt("Recovered"),
                            temp.getInt("Active"),
                            temp.get("Date").toString());
                    countriesMap.get(country).add(dataObject);
                }
                count++;
                total = total + datas.length();
                if (count % 8 == 0) {
                    Thread.sleep(4000);
                }
            }
        }
        return countriesMap;
    }
}
