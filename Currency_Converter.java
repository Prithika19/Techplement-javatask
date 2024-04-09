package Currencuconverter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Currency_Converter {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FavoriteCurrency favoriteCurrency = new FavoriteCurrency();

        
        //Getting user input
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add favorite currency");
            System.out.println("2. View favorite currencies");
            System.out.println("3. Update favorite currencies");
            System.out.println("4. Show real-time exchange rate");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            //with the suer input we are gib=ving the choice to menudriven code and it will  call the desired method
            
            switch (choice) {
                case 1:
                    System.out.print("Enter currency code (e.g., USD): ");
                    String currencyCode = scanner.nextLine().toUpperCase();
                    favoriteCurrency.addCurrency(currencyCode);
                    break;
                case 2:
                    favoriteCurrency.viewCurrencies();
                    break;
                case 3:
                    favoriteCurrency.updateCurrencies();
                    break;
                case 4:
                    CurrencyAPI.showExchangeRate(favoriteCurrency.getCurrencies());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
	
	
	

