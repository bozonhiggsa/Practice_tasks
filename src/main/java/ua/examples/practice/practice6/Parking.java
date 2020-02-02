package ua.examples.practice.practice6;

import java.util.Arrays;

public class Parking {

    private final int NUMBER_OF_PLACE;
    private static Object[] park;

    public Parking(int numberOfPlace) {
        NUMBER_OF_PLACE = numberOfPlace;
        park = new Object[NUMBER_OF_PLACE];
    }

    public boolean arrive(Object object, int place){

        if(object == null){
            return false;
        }

        for(int i = 0; i < NUMBER_OF_PLACE; i++){
            if(park[i] != null && object.equals(park[i])){
                return false;
            }
        }
        for(int i = place; i < NUMBER_OF_PLACE; i++){
            if(park[i] == null){
                park[i] = object;
                return true;
            }
        }
        return false;
    }

    public boolean depart(Object object){

        if(object == null){
            return false;
        }
        for (int i = 0; i < NUMBER_OF_PLACE; i++) {
            if(park[i] != null && park[i].equals(object)){
                park[i] = null;
                return true;
            }
        }
        return false;
    }

    public void currentState(){
        System.out.println(Arrays.toString(park));
    }
}
