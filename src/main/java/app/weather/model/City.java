package app.weather.model;

public enum City {

	DELHI("Delhi, the National Capital Territory of Delhi, India", "28.610001", "77.230003"),

	MUMBAI("Mumbai, Maharashtra, India", "19.076090", "72.877426"),

	LUCKNOW("Lucknow, Uttar Pradesh, India", "26.850000", "80.949997"),

	RAIPUR("Raipur, Chhattisgarh, India", "21.250000", "81.629997");

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getFullInfo() {
		return fullInfo;
	}

	public void setFullInfo(String fullInfo) {
		this.fullInfo = fullInfo;
	}

	private String latitude;
	private String longitude;
	private String fullInfo;

	City(String fullInfo, String latitude, String longitude) {
		this.fullInfo = fullInfo;
		this.latitude = latitude;
		this.longitude = longitude;
	}

}
