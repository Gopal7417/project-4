package Happy;

public class BusModel {
	private String bustype;
	private String bustypeId;
	private int busid;
	private String regno;
	private String Station;
	private int tripid;
	
	public BusModel()
	{
		
	}
	public BusModel(String bustype, String bustypeId, int busid, String regno, String station, int tripid) {
		super();
		this.bustype = bustype;
		this.bustypeId = bustypeId;
		this.busid = busid;
		this.regno = regno;
		Station = station;
		this.tripid = tripid;
	}
	public String getBustype() {
		return bustype;
	}
	public void setBustype(String bustype) {
		this.bustype = bustype;
	}
	public String getBustypeId() {
		return bustypeId;
	}
	public void setBustypeId(String string) {
		this.bustypeId = string;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getStation() {
		return Station;
	}
	public void setStation(String station) {
		Station = station;
	}
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}


	
}
