package ua.examples.practice.practice6;

public class Part3 {
	
	public static void main(String[] args) {

		int numberOfPlace = 10;
		Object[] cars = new Object[numberOfPlace];
		for (int i = 0; i < numberOfPlace; i++){
			cars[i] = new Object();
		}
		Parking parking = new Parking(numberOfPlace);
		for(int i = 0; i < numberOfPlace; i++){
			if((i%2) == 0){
				System.out.println(parking.arrive(cars[i], i));
			}
		}
		parking.currentState();
		for (int i = 0; i < numberOfPlace/2; i++){
			System.out.println(parking.depart(cars[i]));
		}
		parking.currentState();
	}
}
