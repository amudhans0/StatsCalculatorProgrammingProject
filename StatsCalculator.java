import java.util.Arrays;
/**
 * @file StatsCalculator.java
 * @Date 3/17/23
 * @Author Sneha Amudhan
 *
 * @Description Identifies and sorts wanted array then finds minimum, maximum, median, mean first quartile, and third quartile
 *
 */
public class StatsCalculator {
    /**
     * @description creates double array of values
     */
    private double[] numbers;
    /**
     * @description creates double array of sorted values
     */
    private double[] sortedNum;

    /**
     * @description creates array size of 20 full of zeros
     */
    public StatsCalculator() {
        double numbers[] = new double[20];

    }

    /**
     * @description sets instance variable to the parameter
     */
    public StatsCalculator(double[] num) {
        numbers = num;
    }

    /**
     * @description Sorts the given data
     */
    public void sortData() {
        sortedNum = new double[numbers.length];

        //copy the user data into a new array
        for (int i = 0; i < numbers.length; i++) {
            sortedNum[i] = numbers[i];
        }

        //sort the array
        Arrays.sort(sortedNum);
    }

    /**
     * @description finds the maximum value in array
     * @returns maximum value of the array
     */
    public double calculateMax() {
        if ((sortedNum.length == 0))
            return Integer.MAX_VALUE;

        double max = sortedNum[0];
        for (int i = 0; i < sortedNum.length - 1; i++) {
            if (sortedNum[i] < sortedNum[i + 1]) {
                max = sortedNum[i + 1];
            } else {
                i++;
            }
        }
        return max;
    }

    /**
     * @return minimum value of the array
     * @description finds the minimum value in array
     */
    public double calculateMin() {
        if ((sortedNum.length == 0)) {
            return Integer.MIN_VALUE;
        }
        double min = sortedNum[0];
        for (int i = 0; i < sortedNum.length - 1; i++) {
            if (sortedNum[i] > sortedNum[i + 1]) {
                min = sortedNum[i];
            } else {
                i++;
            }
        }
        return min;
    }

    /**
     * @return first quartile
     * @description finds the first quartile of the sorted array
     */
    public double calculateFirstQuartile() {
        double fQuartile;
        int divFour = sortedNum.length / 4;
        if (sortedNum.length % 4 == 0) {
            fQuartile = (sortedNum[divFour - 1] + sortedNum[divFour]) / 2;
        } else if (sortedNum.length % 2 == 0) {
            fQuartile = (sortedNum[divFour]);
        } else {
            fQuartile = (sortedNum[divFour]);
        }
        return fQuartile;
    }

    /**
     * @return third quartile
     * @description finds the third quartile of the sorted array
     */
    public double calculateThirdQuartile() {
        double tQuartile;
        int divFour = sortedNum.length / 4;
        int divTwo = sortedNum.length / 2;

        if (sortedNum.length % 4 == 0) {
            tQuartile = (sortedNum[(divFour) + (divTwo) - 1] + sortedNum[(divFour) + (divTwo)]) / 2;
        } else if (sortedNum.length % 2 == 0) {
            tQuartile = sortedNum[(divFour) + (divTwo)];
        } else {
            tQuartile = sortedNum[(divFour) + (divTwo) + 1];
        }

        return tQuartile;
    }

    /**
     * @return median
     * @description finds the median of the sorted array
     */
    public double calculateMedian() {
        double median = 0;

        if (sortedNum.length % 2 == 0) {

            int mid = sortedNum.length / 2;

            median = ((sortedNum[mid] + sortedNum[mid - 1]) / 2.0);
        } else {
            median = sortedNum[sortedNum.length / 2];
        }
        return median;
    }

    /**
     * @return sum
     * @description calculates the sum of the array
     */
    public double calculateSum() {
        double sum = 0.0;
        for (int i = 0; i < sortedNum.length; i++) {
            sum += sortedNum[i];
        }
        return sum;
    }

    /**
     * @return mean
     * @description calculates the mean of the array
     */
    public double calculateMean() {
        int sum = 0;
        double ave = 0;
        for (double num : sortedNum) {
            sum += num;
        }
        ave = (double) sum / numbers.length;
        return ave;
    }

    /**
     * @description prints the call and return of the array with comma in between
     */
    public void print() {
        System.out.print("Your data is: ");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    /**
     * @description prints the call and return of the sorted array with comma in between
     */
        public void printSorted() {

            //sort the array
            System.out.print("Your sorted data is: ");
            Arrays.sort(sortedNum);
           for(double num: sortedNum){
               System.out.print( num + " ");
           }
           System.out.println(" ");


            }


    /**
     * @description prints out five number summary which include Minimum, First Quartile, Median, Third Quartile, and Maximum
     */
        public void printFiveNumberSummary(){
            System.out.println("The five number summary is: ");
            System.out.println("Minimum: " + calculateMin());
            System.out.println("First Quartile: " + calculateFirstQuartile());
            System.out.println("Median: " + calculateMedian());
            System.out.println("Third Quartile: " + calculateThirdQuartile());
            System.out.println("Max: " + calculateMax());
        }
    }