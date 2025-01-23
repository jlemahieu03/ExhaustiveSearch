// jdh CS 3240A / CS 5240A Spring 2025

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String argv[]) {
    testOne();
    testTwo();
  }

  //------------------------------------------------------

  public static void testOne() {
    CityMap map = new CityMap();
    City A = new City("A");
    City B = new City("B");
    City C = new City("C");
    City D = new City("D");
    City E = new City("E");

    map.addCity(A);
    map.addCity(B);
    map.addCity(C);
    map.addCity(D);
    map.addCity(E);

    map.setDistance(A, B, 30);
    map.setDistance(A, C, 31);
    map.setDistance(A, D, 67);
    map.setDistance(A, E, 41);
    map.setDistance(B, C, 21);
    map.setDistance(B, D, 35);
    map.setDistance(B, E, 23);
    map.setDistance(C, D, 54);
    map.setDistance(C, E, 47);
    map.setDistance(D, E, 37);

    City[] route = map.computeTSP();

    for (int i=0; i<route.length; ++i)
      System.out.println(route[i]);
  } // testOne()

  //-----------------------------------------------------

  public static void testTwo() {
    CityMap map = new CityMap();
    City chicago = new City("Chicago");
    City desmoines = new City("Des Moines");
    City detroit = new City("Detroit");
    City indianapolis = new City("Indianapolis");
    City memphis = new City("Memphis");
    City milwaukee = new City("Milwaukee");
    City minneapolis = new City("Minneapolis");
    City nashville = new City("Nashville");
    City pittsburg = new City("Pittsburg");
    City stlouis = new City("St. Louis");

    map.addCity(chicago);
    map.addCity(desmoines);
    map.addCity(detroit);
    map.addCity(indianapolis);
    map.addCity(memphis);
    map.addCity(milwaukee);
    map.addCity(minneapolis);
    map.addCity(nashville);
    map.addCity(pittsburg);
    map.addCity(stlouis);

    map.setDistance(chicago, desmoines, 332);
    map.setDistance(chicago, detroit, 280);
    map.setDistance(chicago, indianapolis, 181);
    map.setDistance(chicago, memphis, 531);
    map.setDistance(chicago, milwaukee, 90);
    map.setDistance(chicago, minneapolis, 408);
    map.setDistance(chicago, nashville, 469);
    map.setDistance(chicago, pittsburg, 459);
    map.setDistance(chicago, stlouis, 296);

    // finish filling in the distances

    City[] route = map.computeTSP();

    for (int i=0; i<route.length; ++i)
      System.out.println(route[i]);
  } // testTwo()

} // Main()
