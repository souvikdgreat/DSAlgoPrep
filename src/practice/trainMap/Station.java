package practice.trainMap;

import java.util.List;

public class Station {
    String name;
    List<Station> neighbours;

    public Station(String name){
        this.name = name;
    }

    public void setNeighbours(List<Station> stations){
        this.neighbours = stations;
    }
}
