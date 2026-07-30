import java.util.*;
public class exercise2 {
    public static void main(String[] args) {
        int[] weights = {200, 200, 1, 2, 3, 4, 5, 200};
        ArrayList<Integer> weights1 = new ArrayList<>(List.of(200, 200, 1, 2, 3, 4, 5, 200));
        System.out.println(weights(300, weights));
        System.out.println(stretchGoal1(300, weights1));
        System.out.println(stretchGoal2(300, weights));
        System.out.println(stretchGoal3(300, weights));
    }
    public static String weights(int limit, int[] weights) {
        int curr_weight = 0;
        for (int i = 0; i < weights.length; i++) {
            curr_weight += weights[i];
            if (curr_weight >= limit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + curr_weight + " lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + curr_weight;
    }
    public static String stretchGoal1(int limit, ArrayList<Integer> weights) {
        Collections.sort(weights);
        int count = 0;
        for (int weight : weights) {
            limit -= weight;
            if (limit <= 0) {
                return count + "passengers can load without overload.";
            }
            count += 1;
        }
        return count + "passengers can load without overload.";
    }
    public static String stretchGoal2(int limit, int[] weights) {
        int curr_weight = 0;
        int heaviest = 0;
        int lightest = 0;
        for (int i = 0; i < weights.length; i++) {
            heaviest = Math.max(heaviest, weights[i]);
            lightest = Math.min(lightest, weights[i]);
            curr_weight += weights[i];
            if (curr_weight >= limit) {
                return "Passenger " + (i + 1) + " caused an overload. Total weight at that point: " + curr_weight + " lbs. Heaviest weight was " + heaviest + "lbs. Lightest weight was " + lightest + "lbs.";
            }
        }
        return "All passengers boarded safely. Total weight: " + curr_weight + ". Heaviest weight was " + heaviest + "lbs. Lightest weight was " + lightest + "lbs.";
    }
    public static String stretchGoal3(int limit, int[] weights) {
        StringBuilder ret = new StringBuilder();
        int curr_weight = 0;
        StringBuilder currPassengers = new StringBuilder();
        int trip_count = 1;
        for (int i = 0; i < weights.length; i++) {
            curr_weight += weights[i];
            if (curr_weight >= limit) {
                if (currPassengers.isEmpty()) {
                    return "Task is not possible, there is a passenger who exceeds the limit.";
                }
                currPassengers.deleteCharAt(currPassengers.length() - 1);
                currPassengers.deleteCharAt(currPassengers.length() - 1);
                ret.append("Passenger(s) ").append(currPassengers).append(" succcessfully loaded on trip number ").append(trip_count).append(". ");
                curr_weight = weights[i];
                currPassengers = new StringBuilder();
                trip_count += 1;
            }
            currPassengers.append(i).append(", ");
        }
        return "Total trips: " + trip_count + ". " + ret + ".";
    }
}
