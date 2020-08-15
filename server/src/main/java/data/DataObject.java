package data;

public class DataObject {

    public String Country;
    public String CountryCode;
    public String Province;
    public String City;
    public double Lat;
    public double Lon;
    public int Confirmed;
    public int Deaths;
    public int Recovered;
    public int Active;
    public String Date;

    public DataObject(String Country, String CountryCode, String Province,
                      String City, double Lat, double Lon, int Confirmed,
                      int Deaths, int Recovered, int Active, String Date){
        this.Country = Country;
        this.CountryCode = CountryCode;
        this.Province = Province;
        this.City = City;
        this.Lat = Lat;
        this.Lon = Lon;
        this.Confirmed = Confirmed;
        this.Deaths = Deaths;
        this.Recovered = Recovered;
        this.Active = Active;
        this.Date = Date;
    }
}
