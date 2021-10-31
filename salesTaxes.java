import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class salesTaxes{
    

    public static void printReceipt(String file){
        Scanner sc;
        try{
            sc = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e){
            System.out.println(file + "not found");
            return;
        }
        
        double taxes = 0;
        double total = 0;
        double itemPrice;
        double itemTax;
        int quantity;
        String[] exemptProducts = {"chocolate", "chocolates", "book", "pills", "medicine"};
        DecimalFormat df = new DecimalFormat("#0.00");

        //Iterate through each line in input shopping basket
        while(sc.hasNext()){
            String[] tokens = sc.nextLine().split(" ");
            quantity = Integer.parseInt(tokens[0]);
            itemPrice = Double.parseDouble(tokens[tokens.length-1]);
            itemPrice *= quantity;  //Multiply price by number of items for total
            boolean taxExempt = false;
            itemTax = 0;

            //Add price of items in line to the total
            total += itemPrice;
            
            //Calculate amount of tax
            if(tokens[1].equals("imported")){   //tax for imported items is 5% with no exemption
                itemTax += 0.05*itemPrice;
            } 

            for(String product : exemptProducts){
                if(Arrays.asList(tokens).contains(product)){
                    taxExempt = true;
                    break;
                }
            }

            if(!taxExempt){
                itemTax += 0.1*itemPrice;
            }

            //Round itemTax to nearest .05
            itemTax = Math.ceil(itemTax*20)/20;

            taxes += itemTax;

            System.out.print(quantity);
            
            for(int i=1; i<tokens.length-2; i++){
                System.out.print(" "+tokens[i]);
            }
            System.out.print(": " + df.format((double)Math.round((itemPrice+itemTax)*100)/100));
            System.out.println();
        }

        System.out.println("Sales Taxes: " + df.format(taxes));
        System.out.println("Total: "+ df.format(total + taxes));
    }

    public static void main(String[] args){
        for(String file : args){
            printReceipt(file);
            System.out.println();
        }
    }

}