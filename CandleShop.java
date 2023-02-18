/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package candleshop;
import java.util.Scanner;

/**
 *
 * @author Brandon Sakal
 * ITSC1212-101, Long
 * @version 1
 * @since 10/22/22
 * Project 3
 * A candle shop that sells 3 different candles. This program allows the shopkeeper
 * to enter data about the 3 candles. It calculates the price, price with discount,
 * total burn time, and cost-per-minute of burning the candles. It then displays
 * that information. It also displays the number of each candle bought with a
 * histogram. 
 */
public class CandleShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new scanner
        Scanner input = new Scanner(System.in);
        //variables to store candle name, type, and burn time
        String name;
        int type, burnTime;
        //variables to store the amount of each candle purchased
        int candle1Amount = 0, candle2Amount = 0, candle3Amount = 0;
        //variables to store the price of each type of candle purchased
        double candle1Cost = 0, candle2Cost = 0, candle3Cost = 0;
        //variables to store the cost of the candles and the total price 
        double cost, totalPrice;
        
        //making candle objects
        Candle candle1 = null;
        Candle candle2 = null;
        Candle candle3 = null;
        
        //getting candle name, type, price, and burn duration for each of the 3 candles
        for (int i = 1; i <= 3; i++)
        {
            System.out.println("Please enter the name for candle number " + i + ": ");
            name = input.nextLine();
            System.out.println("Please enter the type for candle number " + i + ": ");
            type = input.nextInt();
                if (type < 1)
                    {
                    System.out.println("Error. Please enter a number greater than 0.");
                    System.exit(-1);   
                    }
                else 
            System.out.println("Please enter the price for candle number " + i + ": ");
            cost = input.nextDouble();
                if (cost < 1)
                    {
                    System.out.println("Error. Please enter a number greater than 0.");
                    System.exit(-1);   
                    }
                else 
            System.out.println("Please enter the burn duration in minutes for candle number " + i + ": ");
            burnTime = input.nextInt();
                if (burnTime < 1)
                    {
                    System.out.println("Error. Please enter a number greater than 0.");
                    System.exit(-1);   
                    }
                else 
                {        
                }
            input.nextLine();
            
            switch (i)
            {
                case 1:
                   candle1 = new Candle(name, type, cost, burnTime);
                   break;
                   
                case 2:
                   candle2 = new Candle(name, type, cost, burnTime);
                   break;
                
                case 3:
                   candle3 = new Candle(name, type, cost, burnTime);
                   break;
            }
        }
        

        //getting the amount of each candle to purchase and calculating the 
        //total cost of that candle type
        for (int i = 1; i <= 3; i++)
        {
            System.out.println("How many candles of type " + i + " do you want to buy?");
            
            switch (i) 
            {
                case 1:
                    candle1Amount = input.nextInt();
                    candle1Cost = candle1Amount * candle1.getCost();
                    break;
                
                case 2:
                    candle2Amount = input.nextInt();
                    candle2Cost = candle2Amount * candle2.getCost();
                    break;
                    
                case 3:
                    candle3Amount = input.nextInt();
                    candle3Cost = candle3Amount * candle3.getCost();
                    break;
            }
         
        }

        //calculating the total candle cost
        double totalCost = candle1Cost + candle2Cost + candle3Cost;
        
        //calculating the discount based on the total candle cost
        double discountedCost = 0;
        
        if (totalCost > 20 && totalCost <= 35)
        {
            discountedCost = totalCost * 0.95; 
        }
        else if (totalCost > 35 && totalCost <= 55)
        {
            discountedCost = totalCost * 0.93;
        }
        else if (totalCost > 55 && totalCost <= 100)
        {
            discountedCost = totalCost * 0.9;
        }
        else if (totalCost > 100)
        {
            discountedCost = totalCost * 0.8;
        }
        else
        { 
        }
        
        //calculating the total consecutive burn time
        int totalBurnTime = (candle1.getTime() * candle1Amount) + (candle2.getTime() * candle2Amount) + (candle3.getTime() * candle3Amount);
        //calculating the burn cost per minute
        double costPerMin = discountedCost / totalBurnTime;
        
        //displaying the type, name, and amount of each of the 3 candles purchased 
        System.out.println("Number of type " + candle1.getType() + " " + candle1.getName() + " candles bought: " + candle1Amount);
        System.out.println("Number of type " + candle2.getType() + " " + candle2.getName() + " candles bought: " + candle2Amount);
        System.out.println("Number of type " + candle3.getType() + " " + candle3.getName() + " candles bought: " + candle3Amount);
        System.out.println("");
        //displaying the total cost before and after the discount
        System.out.println("Total price before discount: " + totalCost);
        System.out.println("Total price after discount: " + discountedCost);
        System.out.println("");
        //displaying the total burn time and burn cost per minute
        System.out.println("Total burn time: " + totalBurnTime + " minutes.");
        System.out.println("Burn time cost-per-minute: " + costPerMin);
        //calculating the total number of candles purchased and using that to calculate the reward points
        int totalCandleAmount = candle1Amount + candle2Amount + candle3Amount;
        int rewardPoints = totalCandleAmount / 10;
        //displaying the reward points
        System.out.println("");
        System.out.println("Your rewards points: " + rewardPoints);
        System.out.println("");
        
        //creating a histogram bar with a different symbol for each candle
        String histogramBar1 = "", histogramBar2 = "", histogramBar3 = "";
        for (int i = 1; i <= candle1Amount; i++)
        {
            histogramBar1 += "*";
        }
        for (int i = 1; i <= candle2Amount; i++)
        {
            histogramBar2 += "@";
        }
        for (int i = 1; i <= candle3Amount; i++)
        {
            histogramBar3 += "&";
        }
        
        //displaying the histogram
        System.out.println("Histogram of number purchased: ");
        System.out.println(candle1.getName() + " candles: " + histogramBar1);
        System.out.println(candle2.getName() + " candles: " + histogramBar2);
        System.out.println(candle3.getName() + " candles: " + histogramBar3);
    }
    
}
