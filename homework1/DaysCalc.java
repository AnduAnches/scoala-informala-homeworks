import java.util.Scanner;

public class DaysCalc{
    public static void main (String [] args){
        int monthNo = 0; //The month number declared by user
        int year = 0; //Year declared by user

        Scanner userInput = new Scanner(System.in);

        //Next step - user will imput a month number. As long as it's invalid (less than 1 or greater than 12), an error message will appear and the user will be asked to input another one
        do {
            System.out.println("Please enter a valid month number (1 - 12): ");
            monthNo = userInput.nextInt();
            if ((monthNo < 1) || (monthNo > 12))
                System.out.println("Month number is invalid");

        } while ((monthNo < 1) || (monthNo > 12));

        //Next step - user will imput a year. As long as it's invalid (less than 0), an error message will appear and the user will be asked to input another one
        do {
            System.out.println("Please enter year (positive number): ");
            year = userInput.nextInt();
            if (year<0)
                System.out.println ("Invalid year");

        } while (year < 0);

        int noOfDays = 0; //Number of days in a month to be calculated

        switch (monthNo) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                noOfDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                noOfDays = 30;
                break;
            case 2: //Calculation for February, depending if it's a leap year or not
                if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
                    noOfDays = 29;
                else
                    noOfDays = 28;
                break;
        }

        System.out.println("Month " + monthNo + " of year " + year + " has " + noOfDays + " days.");
    }

}

