import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
public class TourGuide {
    //Initializing TourGuide Attributes
    String tourGuide,customerName,customerCountry,tourDestination,hireDate;
    int noOfDays;
    double dailyRate,downPayment;
    boolean availableStatus;
    //TourGuide Constructor
    TourGuide(){
    }
    TourGuide(String tourGuide,double dailyRate){
        this.tourGuide=tourGuide;
        this.dailyRate=dailyRate;
        this.customerName="";
        this.customerCountry="";
        this.tourDestination="";
        this.hireDate="";
        this.noOfDays=0;
        this.downPayment=0.0;
        this.availableStatus=true;
    }
    //Methods for Returning
    String getTourGuide(){
        return this.tourGuide;
    }
    String getCustomerName(){
        return this.customerName;
    }
    String getCustomerCountry(){
        return this.customerCountry;
    }
    String getTourDestination(){
        return this.tourDestination;
    }
    String getHireDate(){
        return  this.hireDate;
    }
    int getNoOfDays(){
        return this.noOfDays;
    }
    double getDailyRate(){
        return this.dailyRate;
    }
    double getDownPayment(){
        return this.downPayment;
    }
    boolean getAvailableStatus(){
        return this.availableStatus;
    }
    //This Method is to Set new Values for Daily Rate and Tour Duration
    void setDailyRate(double newRate){
        this.dailyRate=newRate;
    }
    void setNoOfDays(int newDays){
        this.noOfDays=newDays;
    }

    //This Method to book a Tour Guide
    void bookGuide(String customerName,String customerCountry,String hireDate,String tourDestination,int noOfDays,double downPayment){
        if(this.getAvailableStatus()){
            this.customerName=customerName;
            this.customerCountry=customerCountry;
            this.hireDate=hireDate;
            this.tourDestination=tourDestination;
            this.noOfDays=noOfDays;
            this.downPayment=downPayment;
            this.availableStatus=false;
            System.out.println("Thank you for booking the guide .. !! ");
            System.out.println("Enjoy your tour .. !! ");
        }else{
            System.out.println("The guide is booked .. ");
            System.out.println("Sorry !! this Tour Guide is not available for "+this.getNoOfDays()+" days");
        }
    }
    //This Method is for Making Tour Guide Available
    void setAvailableStatus(){
        if(this.getAvailableStatus()){
            System.out.println(this.getTourGuide()+" Guide is Free ..");
        }else{
            this.customerName="";
            this.customerCountry="";
            this.noOfDays=0;
            this.tourDestination="";
            this.hireDate="";
            this.downPayment=0.0;
            this.availableStatus=true;
            System.out.println(this.getTourGuide()+" Guide is free now ");
        }
    }
    //Final Method to display description of Tour Guide Name, Daily Rate
    final void display(){
        System.out.println("Tour Guide Name : "+this.tourGuide);
        System.out.println("Daily Rate : "+this.dailyRate);
    }
    //This method is to display Menu
    static void menu(){
        System.out.println("Choose your Choice \n" +
                "1. Add Tour Guide \n 2. Remove Tour Guide \n 3. Book Tour Guide \n 4. Make Tour Guide Available \n " +
                "5. Display Available Guides \n 6. Display All Guides \n 7.Display Customer \n '-1' To Exit");
    }
    //Driver Main Method
    public static void main(String[] args) {
        int ch,pos;boolean run=true;
        Scanner sc=new Scanner(System.in);
        TourCompany tc1=new TourCompany();
        while(run){
            menu();
            System.out.println("Enter you Choice .. ");
            ch=sc.nextInt();
            switch (ch){
                case 1:
                    tc1.addOTourGuide();
                    break;
                case 2:
                    if(tc1.getTourGuideSize()){
                        tc1.displayTourGuides();
                        System.out.println("Enter position to remove ");
                        pos=sc.nextInt();
                        tc1.removeTourGuide(pos);
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case 3:
                    if(tc1.getTourGuideSize()){
                        tc1.bookTourGuide();
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case 4:
                    if(tc1.getTourGuideSize()){
                        tc1.makeTourGuideAvailable();
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case 5:
                    if(tc1.getTourGuideSize()){
                        tc1.displayAvailableGuides();
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case 6:
                    if(tc1.getTourGuideSize()){
                        tc1.displayTourGuides();
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case 7:
                    if(tc1.getTourGuideSize()){
                        tc1.displayCustomer();
                    }else{
                        System.out.println("Sorry Array is Empty !! ");
                    }
                    break;
                case -1:
                    run=false;
                    break;
                default:
                    System.out.println("Please Select Correct Choice ");
            }
        }
    }
}
//TourCompany Class Extending TourGuide Class
class TourCompany extends TourGuide {
    //Attribute of Array of Tourguide Objects  for TourCompany
    ArrayList<TourGuide> TourGuides = new ArrayList<TourGuide>();

    //This method add Tour Guide
    void addOTourGuide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of Tour Guide and Daily Rate ");
        String name = sc.next();
        double rate = sc.nextDouble();
        TourGuide t1 = new TourGuide(name, rate);
        TourGuides.add(t1);
        System.out.println("TourGuide Successfully Added .. !! ");
    }

    //This Method Removes Tour Guide
    void removeTourGuide(int pos) {
        try {
            TourGuides.remove(pos);
            System.out.println("Successfully Removed .. !! ");
        } catch (Exception e) {
            System.out.println("Please Use Correct Index .. !! ");
        }
    }

    //This method books Tour Guide
    void bookTourGuide() {
        Scanner sc = new Scanner(System.in);
        this.displayTourGuides();
        System.out.println("Choose Tour Guide with numbers: ");
        int choice = sc.nextInt();
        try {
            TourGuide t1 = TourGuides.get(choice);
            String customerName, customerCountry, hireDate, tourDestination;
            int noOfDays;
            double downPayment;
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            System.out.println("Enter Customer's Name , Country  and Tour Destination ");
            customerName = sc.next();
            customerCountry = sc.next();
            tourDestination = sc.next();
            System.out.println("Enter tour Durations and Down Payment ");
            noOfDays = sc.nextInt();
            downPayment = sc.nextDouble();
            t1.bookGuide(customerName, customerCountry, date, tourDestination, noOfDays, downPayment);
            System.out.println("ThankYou for Hiring "+t1.getTourGuide()+" on "+date);
        } catch (Exception e) {
            System.out.println("Please Choose Correct Options .. !! ");
        }
    }

    //This Method is for making TourGuide Available is TourGuide is Not Available
    void makeTourGuideAvailable() {
        Scanner sc = new Scanner(System.in);
        this.displayTourGuides();
        System.out.println("Choose Tour Guide to Make Available .. !! ");
        int choice = sc.nextInt();
        try {
            TourGuide t1 = TourGuides.get(choice);
            t1.setAvailableStatus();
        } catch (Exception e) {
            System.out.println("Please choose Correct Option .. !! ");
        }
    }

    //This method displays the Available Tour Guides
    void displayAvailableGuides() {
            for (int i = 0; i < TourGuides.size(); i++) {
                if (TourGuides.get(i).getAvailableStatus()) {
                System.out.println(i + ". " + TourGuides.get(i).getTourGuide());
            }
        }
    }

    //This method displays all the Tour Guides
    void displayTourGuides() {
            for (int i = 0; i < TourGuides.size(); i++) {
                System.out.println(i + ". " + TourGuides.get(i).getTourGuide());
            }
    }
    //This method returns the size of Array -- Additional method
    boolean getTourGuideSize(){
        if(TourGuides.size()>0){
            return true;
        }else{
            return false;
        }
    }

    //This method is for Displaying Customer'Name , Country and Tour Guide name is Ascending Order
    void displayCustomer() {
        System.out.println("Customer Name \t Customer Country \t TourGuide Name ");
        ArrayList<String> customers = new ArrayList<String>();
        int j, i;
        for (i = 0; i < TourGuides.size(); i++) {
            if (!TourGuides.get(i).getAvailableStatus()) {
                customers.add(TourGuides.get(i).getCustomerName());
            }
        }
        Collections.sort(customers);
        for (i = 0; i < customers.size(); i++) {
            for (j = 0; j < TourGuides.size(); j++) {
                if (!TourGuides.get(j).getAvailableStatus()) {
                        if(customers.get(i).equals(TourGuides.get(j).getCustomerName())){
                            System.out.println(TourGuides.get(j).getCustomerName()+"\t \t \t  "+TourGuides.get(j).getCustomerCountry()+"\t\t\t  "
                            +TourGuides.get(j).getTourGuide());
                        }
                }
            }
        }
    }
}