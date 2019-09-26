package DyUtil.GDMapUtil;

public class LngLat {
	private double longitude;//经度
    private double lantitude;//维度
 
    public LngLat() {
    }
 
    public LngLat(double longitude, double lantitude) {
        this.longitude = longitude;
        this.lantitude = lantitude;
    }
    public LngLat(String str){
    	String[] arr = str.split(",");
    	this.longitude = Double.parseDouble(arr[0]);
    	this.lantitude = Double.parseDouble(arr[1]);
    }
 
    public double getLongitude() {
        return longitude;
    }
 
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
 
    public double getLantitude() {
        return lantitude;
    }
 
    public void setLantitude(double lantitude) {
        this.lantitude = lantitude;
    }
 
    @Override
    public String toString() {
        return "LngLat{" +
                "longitude=" + longitude +
                ", lantitude=" + lantitude +
                '}';
    }

}
