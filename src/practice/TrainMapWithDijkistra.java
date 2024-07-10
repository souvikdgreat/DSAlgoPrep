package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */

/*
 *      Visual representation of the Train map used
 *
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 */

public class TrainMapWithDijkistra {
    static class StationMap {
        Map<String, List<Station>> map;

        public StationMap() {
            map = new HashMap<>();
        }

        public void connectStation(String source, String dest) {
            Station sourceStation = new Station(source);
            Station destStation = new Station(dest);
            sourceStation.weight = 1;
            destStation.weight = 1;
            if (!map.containsKey(source)) {
                List<Station> neighbouringStations = new ArrayList<>();
                neighbouringStations.add(destStation);
                map.put(source, neighbouringStations);
            } else {
                map.get(source).add(destStation);
            }


            if (!map.containsKey(dest)) {
                List<Station> neighbouringStations = new ArrayList<>();
                neighbouringStations.add(sourceStation);
                map.put(dest, neighbouringStations);
            } else {
                map.get(dest).add(destStation);
            }
        }
    }

    static class Station {
        String name;
        Integer weight;

        public Station(String name){
            this.name = name;
            this.weight = 1;
        }
    }

    public static void main(String[] args) {
        StationMap stationMap = new StationMap();
        stationMap.connectStation("King's Cross St Pancras","Angel");
        stationMap.connectStation("King's Cross St Pancras","Russell Square");
        stationMap.connectStation("King's Cross St Pancras","Farringdon");
        stationMap.connectStation("Russell Square","Holborn");
        stationMap.connectStation("Angel","Old Street");
        stationMap.connectStation("Holborn","Chancery Lane");
        stationMap.connectStation("Chancery Lane","St Paul's");
        stationMap.connectStation("St Paul's","Bank");
        stationMap.connectStation("Bank","Moorgate");
        stationMap.connectStation("Moorgate","Barbican");
        stationMap.connectStation("Barbican","Farringdon");
        System.out.println(stationMap);

    }
}
