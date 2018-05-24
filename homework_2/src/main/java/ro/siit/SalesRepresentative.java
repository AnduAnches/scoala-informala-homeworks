package ro.siit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is used to collect the information about the Sales Representatives and then sort them by revenue in a descending order.
 *
 * @author Alexandru Anches
 * @version 1.0
 * @since 2018-05-20
 */
public class SalesRepresentative {

    /**
     * This method is used to build the team of Sales Reps and display the names of the team members;
     * The user is prompted to insert the Sales Reps one by one, along with the number of sales and the quota/sale;
     *
     * @param userInput Calls the Scanner object from
     * @param noOfEmployees Reps in a team
     * @param repsName The names of the Sales Reps as inserted by the user
     * @param repsSales The number of sales a rep makes
     * @param quota The quota/sale of each Sales Rep
     * @param totalRevenue The total amount that a Sales Rep makes
     *
     * @return the Reps names;
     *
     */
    public String getReps(Scanner userInput, int noOfEmployees, String[] repsName, int[] repsSales, double[] quota, double[] totalRevenue) {
        for (int i = 0; i < noOfEmployees; i++) {
            System.out.println("Please insert employee " + (i + 1));
            System.out.println("Name:");
            repsName[i] = userInput.next();
            System.out.println("Number of sales: ");
            repsSales[i] = userInput.nextInt();
            System.out.println("Quota: ");
            quota[i] = userInput.nextDouble();
            totalRevenue[i] = repsSales[i] * quota[i];
        }

        return(Arrays.toString(repsName));
    }



    /**
     * This is the algorithm that sorts the Sales Reps by revenue generated, in descending order;
     *
     * @param noOfEmployees Reps in a team;
     * @param repsName The names of the Sales Reps as inserted by the user;
     * @param totalRevenue The total amount that a Sales Rep makes;
     *
     * @return The Sales Representatives, sorted by revenue;
     */
    public String sortRepsByRevenue(int noOfEmployees, String[] repsName, double[] totalRevenue) {
        for (int i = 1; i < noOfEmployees; i++) {
            double temp = 0;
            String tempName;
            if (totalRevenue[i - 1] < totalRevenue[i]) {
                temp = totalRevenue[i-1];
                totalRevenue[i-1] = totalRevenue[i];
                totalRevenue [i] = temp;
                tempName = repsName [i - 1];
                repsName[i - 1] = repsName[i];
                repsName[i] = tempName;
            }

        }
        return (Arrays.toString(repsName));
    }
}
