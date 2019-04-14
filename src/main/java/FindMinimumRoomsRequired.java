import java.util.*;

/**
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 *
 */

/*Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number
  of rooms required.
  For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.*/

public class FindMinimumRoomsRequired {

    private static int findMinimumRooms(List<List<Integer>> schedule) {
        schedule.sort((o1, o2) -> o1.get(0) - o2.get(1));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>(schedule.size(), Comparator.comparingInt(o -> o));

        endTimes.add(schedule.get(0).get(1));

        for (int i=1; i<schedule.size(); i++) {
            if (schedule.get(i).get(0) >= endTimes.peek()) {
                endTimes.poll();
            }

            endTimes.add(schedule.get(i).get(1));
        }

        return endTimes.size();
    }
}