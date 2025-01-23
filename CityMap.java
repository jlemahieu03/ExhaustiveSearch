// jdh CS 3240A / CS 5240A Spring 2025

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class CityMap {
  List<City> cities;
  Map<City, Map<City, Integer>> distances;

  public CityMap() {
    cities = new ArrayList<City>();
    distances = new HashMap<City, Map<City, Integer>>();
  }

  public boolean addCity(City city) {
    int idx = cities.indexOf(city);
    if (idx != -1) {
      System.out.println("city " + city + " already present");
      return false;
    } else {
      cities.add(city);
      return true;
    }
  }

  public int getDistance(City cityOne, City cityTwo) {
    if (cities.indexOf(cityOne) == -1) {
      System.out.println("city " + cityOne + " is not on map");
      return -1;
    }

    if (cities.indexOf(cityTwo) == -1) {
      System.out.println("city " + cityTwo + " is not on map");
      return -1;
    }

    if ( ! distances.containsKey(cityOne) ) {
      System.out.println("first key " + cityOne + " not in distance table");
      return -1;
    }

    Map<City, Integer> submap = distances.get(cityOne);
    if ( ! submap.containsKey(cityTwo) ) {
      System.out.println("no entry for " + cityOne + " - " + cityTwo + " in distance table");
      return Integer.MAX_VALUE / 100;
    }

    int entry = submap.get(cityTwo);
    return entry;
  } // getDistance()

  //---------------------------------------------------------

  public boolean setDistance(City cityOne, City cityTwo, int distance) {
    boolean r1 = this.setDistanceOneWay(cityOne, cityTwo, distance);
    boolean r2 = this.setDistanceOneWay(cityTwo, cityOne, distance);
    return r1 || r2;
  }

  //---------------------------------------------------------

  public boolean setDistanceOneWay(City cityOne, City cityTwo, int distance) {
    if (cities.indexOf(cityOne) == -1) {
      System.out.println("city " + cityOne + " is not on map");
      return false;
    }

    if (cities.indexOf(cityTwo) == -1) {
      System.out.println("city " + cityTwo + " is not on map");
      return false;
    }

    if ( ! distances.containsKey(cityOne) ) {
      Map<City, Integer> submap = new HashMap<City, Integer>();
      submap.put(cityTwo, distance);
      distances.put(cityOne, submap);
    } else {
      Map<City, Integer> submap = distances.get(cityOne);
      if ( ! submap.containsKey(cityTwo) ) {
        submap.put(cityTwo, distance);
      }
    }

    return true;
  } // setDistance()

  //----------------------------------------------------------------

  public static List<Integer[]> permHelper(Integer[] vals) {
    List<Integer[]> rtnval = new ArrayList<Integer[]>();
    int n = vals.length;

    if (n == 0)
      return rtnval;

    if (n == 1) {
      Integer[] A = new Integer[1];
      A[0] = vals[0];
      rtnval.add(A);
      return rtnval;
    }

    if (n == 2) {
      Integer[] A1 = new Integer[2];
      A1[0] = vals[0];
      A1[1] = vals[1];
      rtnval.add(A1);
      Integer[] A2 = new Integer[2];
      A2[0] = vals[1];
      A2[1] = vals[0];
      rtnval.add(A2);
      return rtnval;
    }

    Integer[] subarray = Arrays.copyOfRange(vals, 1, n);
    List<Integer[]> recResult = permHelper(subarray);
    for (Integer[] A: recResult) {
      Integer[] newA = new Integer[n];
      System.arraycopy(A, 0, newA, 0, A.length);
      newA[n-1] = vals[0];
      rtnval.add(newA);
    }

    int firstval = vals[0];

    for (int i=0; i<n-1; ++i) {
      int save = subarray[i];
      subarray[i] = firstval;
      recResult = permHelper(subarray);
      for (Integer[] A: recResult) {
        Integer[] newA = new Integer[n];
        System.arraycopy(A, 0, newA, 0, A.length);
        newA[n-1] = save;
        rtnval.add(newA);
      }
      subarray[i] = save;
    }

    return rtnval;
  } 

  //----------------------------------------------------------------

  public static List<Integer[]> genPermutations(int n) {
    List<Integer[]> rtnval = new ArrayList<Integer[]>();

    if (n == 0)
      return rtnval;

    Integer[] A = new Integer[n];
    for (int i=0; i<n; ++i)
      A[i] = i;
    return permHelper(A);
  }

  //----------------------------------------------------------------

  City[] computeTSP() {
    // write this function!
  } // computeTSP()

} // class CityMap
