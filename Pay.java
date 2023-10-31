package ajou.aiot.samples;

public class Pay {

	int userId;
	String cost;
	String rideId;
	int driverId;
	int createdAt;
	String taxiNum;

	public void updatePay(int userId, String rideId, String cost, int driverId, int createdAt, String taxiNum){
		this.userId = userId;
		this.rideId = rideId;
		this.driverId = driverId;
		this.cost = cost;
		this.createdAt = createdAt;
		this.taxiNum = taxiNum;
	}

	@Override
	public String toString(){
		return "userId : " + userId+ ", rideId : "+rideId+ ", driverId : "+driverId+", createdAt : "+createdAt+
				"taxiNum : "+taxiNum+", cost : "+cost;
	}


}
