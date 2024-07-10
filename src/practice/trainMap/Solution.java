package practice.trainMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 */

/*
 *      Visual representation of the Train map used
 *                               1        1
 *      King's Cross St Pancras --- Angel ---- Old Street
 *      |                   \                            |
 *      |                    \                            |
 *      |                     \                            |
 *      Russell Square         Farringdon --- Barbican --- Moorgate
 *      |                                                  /
 *      |                                                 /
 *      |                                                /
 *      Holborn --- Chancery Lane --- St Paul's --- Bank
 *
 *   king Angel
 * King's Cross St Pancras  Old Street
 *                          Farringdon
 * map
 * king  null
 * angel king
 * Old Street angel
 *
 * oldstrre -> angel ->kin
 *
 *
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        Station kingCross = new Station("Kingcross");
        Station angel = new Station("Angel");
        Station oldStreet = new Station("Old Street");
        Station russel = new Station("Russell Square");
        Station holborn = new Station("Holborn");
        Station farringnton = new Station("Farringnton");
        Station moorGate = new Station("moorGate");
        Station barbican = new Station("barbican");
        Station chancery = new Station("chancery");
        Station stpaul = new Station("stpaul");
        Station bank = new Station("bank");

        //King's Cross St Pancras
        List<Station> stations = List.of(angel, russel, farringnton);
        kingCross.setNeighbours(stations);

        //Angel
        stations = List.of(oldStreet, kingCross);
        angel.setNeighbours(stations);

        //Old Street
        stations = List.of(angel, moorGate);
        oldStreet.setNeighbours(stations);

        //russel Square
        stations = List.of(holborn, kingCross);
        russel.setNeighbours(stations);

        //farrington
        stations = List.of(kingCross, barbican);
        farringnton.setNeighbours(stations);

        //barbican
        stations = List.of(moorGate, farringnton);
        barbican.setNeighbours(stations);

        //moorgate
        stations = List.of(barbican, oldStreet, bank);
        moorGate.setNeighbours(stations);

        //holborn
        stations = List.of(russel, chancery);
        holborn.setNeighbours(stations);


        //chancery
        stations = List.of(holborn, stpaul);
        chancery.setNeighbours(stations);

        //stpaul
        stations = List.of(chancery, bank);
        stpaul.setNeighbours(stations);

        //bank
        stations = List.of(stpaul, moorGate);
        bank.setNeighbours(stations);

        System.out.println(shortestPath(kingCross, stpaul));

    }

    public static String shortestPath(Station fromStation, Station toStation) {
        Queue<Station> stationQ = new LinkedList<>();
        HashMap<String, Visited> visitedHashMap = new HashMap<>();
        stationQ.add(fromStation);

        visitedHashMap.put(fromStation.name, new Visited());

        //bfs
        while (!stationQ.isEmpty()) {
            Station station = stationQ.poll();
            List<Station> neighbours = station.neighbours;
            for (Station neighbour : neighbours) {
                if (neighbour.equals(toStation)) {
                    visitedHashMap.put(neighbour.name, new Visited(station));
                    stationQ.clear();
                    break;
                }
                if (!visitedHashMap.containsKey(neighbour.name)) {
                    visitedHashMap.put(neighbour.name, new Visited(station));
                    stationQ.add(neighbour);
                }
            }
        }

        List<Station> results = new ArrayList<>();
        while (toStation != null) {
            results.add(0, toStation);
            toStation = visitedHashMap.get(toStation.name).parentStation;
        }

        //
        //System.out.println(results);

        return results.stream()
                .map(it -> it.name)
                .collect(Collectors.joining("->"));
    }
}
