package beans;

public class Track {
	public String trackId;
	public String position;
	public String arrival;
	public String departure;

	public Track() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param trackId
	 * @param position
	 * @param arrival
	 * @param departure
	 */
	public Track(String trackId, String position, String arrival,
			String departure) {
		super();
		this.trackId = trackId;
		this.position = position;
		this.arrival = arrival;
		this.departure = departure;
	}


	/**
	 * @param position
	 * @param arrival
	 * @param departure
	 */
	public Track(String position, String arrival, String departure) {
		super();
		this.position = position;
		this.arrival = arrival;
		this.departure = departure;
	}


	public String getTrackId() {
		return trackId;
	}


	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getArrival() {
		return arrival;
	}


	public void setArrival(String arrival) {
		this.arrival = arrival;
	}


	public String getDeparture() {
		return departure;
	}


	public void setDeparture(String departure) {
		this.departure = departure;
	}

	
	
}
