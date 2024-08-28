package bank;
import java.util.Scanner;

public class Account {
    // cls var
    int bal;
    int prevTrans;
    String custName;
    String custID;

    // Class Constru
    public Account(String custName, String custID) {
        this.custName = custName;
        this.custID = custID;
    }

    // Fun for depo money
    void depposit(int amount){
      if (amount != 0) {
        bal=bal+amount;
        prevTrans=amount;
      }  
    }
    //Fun for withdr
    void withdraw(int amount)
    {
     if (amount !=0) {
         bal=bal-amount;
         prevTrans=amount;
     }
   }
   // fun for show prev trns
  public void getPrevTrans(){
    if (prevTrans>0) {
        System.out.println("Deposit :"+prevTrans);
    }else if (prevTrans<0) {
        System.out.println("withdraw :"+ Math.abs(prevTrans));
    }else  {
        System.out.println("no trans occured");
    }
   }

   //Fun cals interest of curr fund in year
   void CalculateInterest( int year){
    double intRate=0.4;
    double newBal=(bal+intRate*year)+bal;
    System.out.println(" the curr interest rate is: "+(100*intRate));
    System.out.println("after"+year+"yr , your bal wiil be "+ newBal);
   }
   void showMenu(){
    char option ='\0';
    Scanner sc=new Scanner(System.in);
    System.out.println("welcome  "+custName+"!");
    System.out.println("yur id is  { "+custID+"}");
    System.out.println();
    System.out.println("what would u like you do");
    System.out.println();
    System.out.println("A : check bal");
    System.out.println("B: meke depo");
    System.out.println("C: make withdraw");
    System.out.println("d: view prev trans");
    System.out.println("E : cal interest");
    System.out.println("F :  existss");

    do{
        System.out.println();
        System.out.println("Enter an option");
        char option1=sc.next().charAt(0);
        option=Character.toUpperCase(option1);
        System.out.println();

        switch (option) {
            // allow user to check bal
            case 'A':
            System.out.println("************************");
            System.out.println("BAL is = Rs"+bal);
            System.out.println("****************************");
            System.out.println();
                break;
                //dpo money in acc
            case 'B':
            System.out.println("Enter amount to depo: ");
            int amount= sc.nextInt();
            depposit(amount);
            System.out.println();
            break;
            // withdreo money from acc
            case 'C':
            System.out.println("enter amt to withdraw");
            int amount2= sc.nextInt();
            withdraw(amount2);
            System.out.println(amount2);
            break;
            //view most recent trans
            case 'D':
            System.out.println("***************************");
            getPrevTrans();
            System.out.println("***************************");
            System.out.println();
            break;
            //E cal interest
            case 'E':
            System.out.println(" Enter how many year of accuerd intrest :");
            int year=sc.nextInt();
            CalculateInterest(year);
            break;
            //case f exits from acc
            case 'f':
            System.out.println("**********************************");
            break;

            default:
            System.out.println("ERRORRS: INval option");
                break;
        }
    }while(option != 'F');
    System.out.println("thank for banking !!!");
    sc.close();



   }


 
}
