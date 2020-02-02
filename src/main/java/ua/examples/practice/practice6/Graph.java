package ua.examples.practice.practice6;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private final int NUMBER_OF_LIMB;
    public static Set<Limb> limbs;

    public Graph(int numberOfLimb) {

        NUMBER_OF_LIMB = numberOfLimb;
        limbs = new HashSet<>();
    }

    public void addLimb(int vertex1, int vertex2){

        if(limbs.size() < NUMBER_OF_LIMB && vertex1 != vertex2){
            limbs.add(new Limb(vertex1, vertex2));
        }
    }

    public void removeLimb(int vertex1, int vertex2){
        limbs.remove(new Limb(vertex1, vertex2));
    }

    private class Limb {
        private int vertex1;
        private  int vertex2;

        public Limb(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }

        public int getStartPoint() {
            return vertex1;
        }

        public void setStartPoint(int vertex1) {
            this.vertex1 = vertex1;
        }

        public int getEndPoint() {
            return vertex2;
        }

        public void setEndPoint(int vertex2) {
            this.vertex2 = vertex2;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Limb limb = (Limb) o;

            if (vertex1 == limb.vertex1 && vertex2 == limb.vertex2){
                return true;
            }
            else if (vertex1 == limb.vertex2 && vertex2 == limb.vertex1){
                return true;
            }
            else return false;
        }

        @Override
        public int hashCode() {
            return vertex1 + vertex2;
        }

        @Override
        public String toString() {
            return "Limb{" +
                    "vertex1=" + vertex1 +
                    ", vertex2=" + vertex2 +
                    '}';
        }
    }
}
