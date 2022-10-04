package pract.hackerrank;

/**
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static int getMedian(List<Integer> arr)
    {
        if(arr.size() % 2 == 0)
        {
            int mid = arr.size()/2;
            return (arr.get(mid) + arr.get(mid+1)) / 2;
        }
        else
        {
            return arr.get(arr.size()/2);
        }
    }

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d)
    {
        //step 1: Make anna array that holds d elements
        ArrayList<Integer> days = new ArrayList<>();
        for(int i = 0; i<d; i++)
        {
            days.add(expenditure.get(i));
        }

        //step 2 calculate median
        // step 2.1 Sort
        Collections.sort(days);

        //step 2.2 get the median value
        int median = getMedian(days);
        int numNotifs = 0;

        //step 3: Iterate through the array
        for(int i = d; i<expenditure.size()-1; i++)
        {
            if(2 * median >= expenditure.get(i))
            {
                numNotifs++;
            }

            days.remove((Integer)expenditure.get(i-d));
            days.add(expenditure.get(i+1));
        }



        return numNotifs;
    }
}

public class FraudulentNotifs
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
