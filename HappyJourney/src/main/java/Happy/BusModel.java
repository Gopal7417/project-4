package Happy;

import java.util.List;

public class BusModel {
	private String bustype;
	private String bustypeId;
	private int busid;
	private String regno;
	private String station;
	private int tripid;
	private List<BusModel> BList;
	private List<BusModel> SList;
	
	public List<BusModel> getSList() {
		return SList;
	}
	public void setSList(List<BusModel> sList) {
		SList = sList;
	}
	public List<BusModel> getBList() {
		return BList;
	}
	public void setBList(List<BusModel> bList) {
		BList = bList;
	}
	public BusModel()
	{
		
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
	public void setBustypeId(String bustypeId) {
		this.bustypeId = bustypeId;
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
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	

	
}
