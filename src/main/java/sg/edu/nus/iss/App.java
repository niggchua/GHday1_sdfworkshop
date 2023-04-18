package sg.edu.nus.iss;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Welcome to your shopping cart!" );

        List<String> shoppingCart = new ArrayList<String>(); // container to store string objects



        Console con = System.console();  //open console for input from keyboard
        String input = "";

        while(!input.equals("quit")){
            input = con.readLine("Type 'help' to show list of commands\n");


                if(input.equals("help")){
                    System.out.println("'list' to show a list of items in the shopping cart");
                    System.out.println("'add <item name>', to add item to shopping cart");
                    System.out.println("'delete <item number>' to remove item from shopping cart");
                    System.out.println("'quit' to terminate the program");
                }


                if(input.startsWith("add")){
                    input = input.replace(',', ' '); //replace comma with a space

                    Scanner scan = new Scanner(input.substring(4));
                    
                    String content = "";
                    while(scan.hasNext()) {
                        content = scan.next();

                        if(shoppingCart.contains(content)){
                            System.out.println(content + "already in cart.");
                        } else {

                        shoppingCart.add(content);
                        }
                    }
                }


                if(input.equals("list")) {
                    int i = 0;
                    for(String item: shoppingCart) {
        
                        i++;
                        System.out.println(i + ". " + item); //lists out 1. apple
                    }
                }


                if (input.equals("list")) {

                    for (String item: shoppingCart) {
                        System.out.println("Item: " + item); //lists out item: apple
                    }
                }

                if (input.startsWith("delete")) {
                    Scanner scan = new Scanner(input.substring(6));

                    String content = "";
                    while(scan.hasNext()){
                        content = scan.next();

                        int listIndex = Integer.parseInt(content);

                        if (listIndex < shoppingCart.size()) {
                            shoppingCart.remove(listIndex);
                        } else {
                            System.err.println("Incorrect item index");
                        }


                    }
                }

        }


        System.out.println("Bye! Bye! I don't want to see you again...");

       // String name = con.readLine("What would you like to add to your shopping cart today?") //prompt for input



        






    }
}
