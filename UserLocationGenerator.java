package ajou.aiot.samples;

import java.util.ArrayList;
import java.util.Random;

public class UserLocationGenerator {

	private ArrayList<Rect> areaList;
	final double MIN_X=126D;
	final double MIN_Y=34D;
	final double MAX_X=130D;
	final double MAX_Y=39D;
	double nowX=-1;
	double nowY=-1;
	private Random rand;
	int areaCode;

	class Rect {
		double x1,x2,y1,y2;
		Rect() {}
		public void setRange(double x1, double x2, double y1, double y2) {
			this.x1=x1;
			this.x2=x2;
			this.y1=y1;
			this.y2=y2;
		}

		public boolean contains(double x, double y) {
			if (x>=x1 && x<x2 && y>=y1 && y<y2) {
				return true;
			}
			return false;
		}
		public double getMinLongitude(){
			return this.x1;
		}
		public double getMaxLongitude(){
			return this.x2;
		}
		public double getMinLatitude(){
			return this.y1;
		}
		public double getMaxLatitude(){
			return this.y2;
		}
	}
	public void initLoc() {
		areaList=new ArrayList<Rect>();
		long seed = System.currentTimeMillis();
		this.rand = new Random(seed);

		for (int i=0;i<9;i++) {
			areaList.add(new Rect());
		}
		// x: 126~130, y: 34~39
		//area1 -> 경도(126~127.3333), 위도 37.3333~39
		areaList.get(0).setRange(126, 127.3333, 37.3333, 39);
		//area2 -> 경도(127.3333~ 128.6666), 위도 37.3333~39
		areaList.get(1).setRange(127.3333, 128.6666, 37.3333, 39);
		//area3 -> 경도(128.6666~ 130), 위도 37.3333~39
		areaList.get(2).setRange(128.6666, 130, 37.3333, 39);
		//area4 -> 경도(126~127.3333), 위도 35.6777~37.3333
		areaList.get(3).setRange(126, 127.3333, 35.6777, 37.3333);
		//area5 -> 경도(127.3333~ 128.6666), 위도 35.6777~37.3333
		areaList.get(4).setRange(127.3333, 128.6666, 35.6777, 37.3333);
		//area6 -> 경도(128.6666~ 130), 위도 35.6777~37.3333
		areaList.get(5).setRange(128.6666, 130, 35.6777, 37.3333);
		//area7 -> 경도(126~127.3333), 위도 34~ 35.6777
		areaList.get(6).setRange(126, 127.3333, 34, 35.6777);
		//area8 -> 경도(127.3333~ 128.6666), 위도 34~ 35.6777
		areaList.get(7).setRange(127.3333, 128.6666, 34, 35.6777);
		//area9 -> 경도(128.6666~ 130), 위도 34~ 35.6777
		areaList.get(8).setRange(128.6666, 130, 34, 35.6777);
		this.nowX=rand.nextDouble()*0.99 * (this.MAX_X-this.MIN_X) + this.MIN_X;
		this.nowY=rand.nextDouble()*0.99 * (this.MAX_Y-this.MIN_Y) + this.MIN_Y;
		this.areaCode=getArea(nowX,nowY);

	}
	private int getArea(double x, double y) {
		for (int i=0;i<9;i++) {
			if (areaList.get(i).contains(x, y))
				return i;
		}
		System.err.println("Can find areaCode for " + x + ", "+ y);
		System.exit(-1);
		return -1;
	}

	public double getRandMyAreaY() {

		Rect myArea = areaList.get(this.areaCode);
		return rand.nextDouble(myArea.getMinLatitude(), myArea.getMaxLatitude());
	}

	public double getRandMyAreaX() {
		Rect myArea = areaList.get(this.areaCode);
		return rand.nextDouble(myArea.getMinLongitude(), myArea.getMaxLongitude());
	}

	public double getCurrentLatitude() {
		return this.nowY;
	}

	public double getCurrentLongitute() {
		return this.nowX;
	}

	public int getCurrentArea() {
		return this.areaCode;
	}

}
