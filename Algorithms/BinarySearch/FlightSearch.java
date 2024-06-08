package BinarySearch;

import java.util.Arrays;

public class FlightSearch {

  // Flight class to store flight details
  static class Flight {
    String destination;
    String flightNumber;
    int departureTime; // in minutes from midnight
    
    Flight(String destination, String flightNumber, int departureTime) {
      this.destination = destination;
      this.flightNumber = flightNumber;
      this.departureTime = departureTime;
    }
  }

  // Method to search for a flight by departure time in a 2D array of flights
  public static Flight searchFlightByTime(Flight[][] schedule, String destination, int targetTime) {
    // Find the row corresponding to the destination
    int row = findDestinationRow(schedule, destination);
    if (row == -1) {
      return null; // Destination not found
    }
    
    // Perform binary search within the row for the closest departure time
    return binarySearch(schedule, targetTime, row);
  }

  // Helper method to find the row corresponding to the destination
  private static int findDestinationRow(Flight[][] schedule, String destination) {
    for (int i = 0; i < schedule.length; i++) {
      if (schedule[i].length > 0 && schedule[i][0].destination.equals(destination)) {
        return i;
      }
    }
    return -1;
  }

  // Binary search helper method to find the closest flight by departure time
  private static Flight binarySearch(Flight[][] schedule, int targetTime, int row) {
    int cstart = 0;
    int cend = schedule[row].length - 1;

    while (cstart <= cend) {
      int cmid = cstart + (cend - cstart) / 2;
      if (schedule[row][cmid].departureTime > targetTime) {
        cend = cmid - 1;
      } else if (schedule[row][cmid].departureTime < targetTime) {
        cstart = cmid + 1;
      } else {
        return schedule[row][cmid];
      }
    }
    
    // Return the closest flight if an exact match is not found
    if (cstart >= schedule[row].length) {
      return schedule[row][schedule[row].length - 1];
    }
    if (cend < 0) {
      return schedule[row][0];
    }
    return schedule[row][cstart];
  }

  public static void main(String[] args) {
    Flight[][] schedule = {
      {
        new Flight("New York", "NY001", 600), // 10:00 AM
        new Flight("New York", "NY002", 900), // 3:00 PM
        new Flight("New York", "NY003", 1200) // 8:00 PM
      },
      {
        new Flight("Los Angeles", "LA001", 720), // 12:00 PM
        new Flight("Los Angeles", "LA002", 1020), // 5:00 PM
        new Flight("Los Angeles", "LA003", 1320) // 10:00 PM
      },
      {
        new Flight("Chicago", "CH001", 540), // 9:00 AM
        new Flight("Chicago", "CH002", 840), // 2:00 PM
        new Flight("Chicago", "CH003", 1140) // 7:00 PM
      }
    };
    
    String destination = "Los Angeles";
    int targetTime = 1000; // 4:40 PM
    
    Flight result = searchFlightByTime(schedule, destination, targetTime);
    if (result != null) {
      System.out.println("Found: Flight " + result.flightNumber + " to " + result.destination +
                         " departing at " + result.departureTime / 60 + ":" + String.format("%02d", result.departureTime % 60));
    } else {
      System.out.println("Flight not found");
    }
  }
}
