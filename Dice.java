package aerorpess.app;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
	
	private ArrayList<Pair<Integer, Integer>> ratio;
	private ArrayList<Pair<String, Integer>> grindAndTime;
	private int[] temperature;
	private boolean upright;
	private ArrayList<Pair<Integer,Integer>> bloom;
	private String[] stir;
	private Random rand;
	
	private void constructRatio() {
		Pair<Integer, Integer> ratio1 = new Pair<>(12, 200);
		Pair<Integer, Integer> ratio2 = new Pair<>(15, 200);
		Pair<Integer, Integer> ratio3 = new Pair<>(15, 250);
		Pair<Integer, Integer> ratio4 = new Pair<>(18, 250);
		Pair<Integer, Integer> ratio5 = new Pair<>(23, 200);
		ratio = new ArrayList<Pair<Integer, Integer>>();
		ratio.add(ratio1);
		ratio.add(ratio2);
		ratio.add(ratio3);
		ratio.add(ratio4);
		ratio.add(ratio5);
		
	}
	private void constructGrindAndTime() {
		
		Pair<String, Integer> gt1 = new Pair<>("Fine", 60);
		Pair<String, Integer> gt2 = new Pair<>("Medium", 90);
		Pair<String, Integer> gt3 = new Pair<>("Medium", 120);
		Pair<String, Integer> gt4 = new Pair<>("Coarse", 120);
		Pair<String, Integer> gt5 = new Pair<>("Coarse", 240);
		
		grindAndTime = new ArrayList<Pair<String, Integer>>();
		grindAndTime.add(gt1);
		grindAndTime.add(gt2);
		grindAndTime.add(gt3);
		grindAndTime.add(gt4);
		grindAndTime.add(gt5);
		
	}
	private void constructBloom() {
		Pair<Integer, Integer> bloom1 = new Pair<>(30, 20);
		Pair<Integer, Integer> bloom2 = new Pair<>(30, 30);
		Pair<Integer, Integer> bloom3 = new Pair<>(30, 40);
		Pair<Integer, Integer> bloom4 = new Pair<>(60, 20);
		Pair<Integer, Integer> bloom5 = new Pair<>(60, 30);
		Pair<Integer, Integer> bloom6 = new Pair<>(0, 0);
		bloom = new ArrayList<Pair<Integer, Integer>>();
		bloom.add(bloom1);
		bloom.add(bloom2);
		bloom.add(bloom3);
		bloom.add(bloom4);
		bloom.add(bloom5);
		bloom.add(bloom6);
	}
	
	public Dice() {
		rand = new Random();
		this.constructRatio();
		this.constructGrindAndTime();
		this.constructBloom();
		temperature = new int[] {176, 185, 187, 194, 203};
		upright = true;
		stir = new String[] {
				"Stir once in one direction.",
				"Stir once clockwise and once counterclockwise.",
				"Stir 2 times clockwise and 2 times counterclockwise.",
				"Stir 2 times in one direction.",
				"Don't stir."
		};
		
	}
	
	public String rollRatio() {
		int index = rand.nextInt(5);
		Pair<Integer, Integer> rat = ratio.get(index);
		String ret = rat.getFirst().toString() + 
				" GRAMS OF COFFEE to \n" +
				rat.getSecond().toString() +
				" GRAMS OF WATER.";
		
		return ret;
	}
	public String rollGrindAndTime() {
		int index = rand.nextInt(5);
		Pair<String, Integer> gt = grindAndTime.get(index);
		String ret = "Grind to " +
				gt.getFirst().toUpperCase() +
				" GRIND and \nWait for " +
				gt.getSecond().toString() +
				" SECONDS when brewing.";
		
		return ret;
	}
	public String rollTemp() {
		int index = rand.nextInt(5);
		return "Warm water to " + ((Integer)temperature[index]).toString() + " DEGREES.";
	}
	public String rollMethod() {
		upright = rand.nextInt(2) == 1 ? true : false;
		String ret = "";
		if (upright) {
			ret += "Set Aeropress upright while brewing. \n";
		}
		else {
			ret += "Set Aeropress filter-side down on drinking device while brewing. \n";
		}
		int index = rand.nextInt(5);
		Pair<Integer, Integer> bl = bloom.get(index);
		ret += ("Add " + bl.getFirst().toString() +
				" GRAMS OF WATER and wait \n" +
				bl.getSecond().toString() + " SECONDS for coffee to bloom.");
		return ret;
	}
	public String rollStir() {
		int index = rand.nextInt(5);
		return stir[index];
	}
	
	
	
	
	

}
