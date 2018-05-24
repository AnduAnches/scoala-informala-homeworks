/**
 * This application will sort out the Sales Representatives in a team, according to the revenue they get.
 *<br>
 * @author Alexandru Anches
 * @version 1.0
 * @since 2018-05-20
 */

package ro.siit;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        /**
         * The main method will introduce the user to the application, call out the Scanner object
         * in order to get the information from the keyboard.
         * Displays the results from the SalesRepresentatives methods:
         * a list with the Sales Representatives' names
         * a list wit the SAles Reps ordered by revenue;
         */
        System.out.printf("%n%nThis application will sort out your Sales Representatives, according to the revenue generated. %n");

        Scanner userInput = new Scanner(System.in);
        System.out.printf("%nHow big your Sales Representatives team is? (number of employees)%n");
        /**
         * The user must declare how big is the Sales Representatives team;
         */
        int noOfEmployees = userInput.nextInt();
        String[] repsName = new String[noOfEmployees];
        int[] repsSales = new int[noOfEmployees];
        double[] quota = new double[noOfEmployees];
        double[] totalRevenue = new double[noOfEmployees];

        SalesRepresentative reps = new SalesRepresentative();
        System.out.println("The Sales Representatives in your team are: " + reps.getReps(userInput, noOfEmployees, repsName, repsSales, quota, totalRevenue));

        SalesRepresentative sortedReps = new SalesRepresentative();
        System.out.println("The Sales Representatives, sorted by revenue: " +  sortedReps.sortRepsByRevenue(noOfEmployees, repsName, totalRevenue));
    }
}

