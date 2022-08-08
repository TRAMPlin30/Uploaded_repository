package utils;

public class SelectTransportByValue {

    public static int selectTransport(String transportName) {

        int mainValue = 404;

        switch (transportName) {
            case "Bicycle (OSRM)":
                mainValue = 0;
                break;

            case "Bicycle (GraphHopper)":
                mainValue = 1;
                break;

            case "Car (GraphHopper)":
                mainValue = 2;
                break;

            case "Car (OSRM)":
                mainValue = 3;
                break;

            case "Foot (GraphHopper)":
                mainValue = 4;
                break;

            case "Foot (OSRM)":
                mainValue = 5;
                break;
        }
        return mainValue;
    }
}
