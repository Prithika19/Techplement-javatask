package Currencuconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FavoriteCurrency {
	private List<String> currencies;

	
	//method to add to favorite currency
    public FavoriteCurrency() {
        this.currencies = new ArrayList<>();
    }

    //method to add currency
    public void addCurrency(String currency) {
        currencies.add(currency);
        System.out.println(currency + " added to favorites.");
    }

    //method to view
    public void viewCurrencies() {
        if (currencies.isEmpty()) {
            System.out.println("No favorite currencies added yet.");
        } else {
            System.out.println("Favorite currencies:");
            for (String currency : currencies) {
                System.out.println(currency);
            }
        }
    }
    
    
    
    //if we want to do any upadataion we have this method

    public void updateCurrencies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current favorite currencies:");
        viewCurrencies();
        System.out.print("Enter currency to remove: ");
        String currencyToRemove = scanner.nextLine().toUpperCase();
        if (currencies.contains(currencyToRemove)) {
            currencies.remove(currencyToRemove);
            System.out.println(currencyToRemove + " removed from favorites.");
        } else {
            System.out.println(currencyToRemove + " is not in favorites.");
        }
    }

    //to get the currencies
    public List<String> getCurrencies() {
        return currencies;
    }
}

