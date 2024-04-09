package Currencuconverter;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

public class CurrencyAPI {
//	private static final String API_KEY = "https://exchangerate.host"; 
//
//    public static void showExchangeRate(List<String> currencies) {
//        for (String currency : currencies) {
//            try {
//                String url = "https://v6.exchangeratesapi.io/latest" + currency + "?apiKey=" + API_KEY;
//                String json = IOUtils.toString(new URL(url).openStream(), "UTF-8");
//                Object JsonParser;
//				ConditionObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
//                double exchangeRate = jsonObject.getAsJsonObject("rates").get("USD").getAsDouble();
//                System.out.println("1 " + currency + " = " + exchangeRate + " USD");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}


	private static final String API_KEY = "https://exchangerate.host";
    private static final String BASE_URL = "https://v6.exchangeratesapi.io/latest";

    public static void showExchangeRate(List<String> list) {
        try {
            // Constructing the URL to fetch exchange rates for all currencies
            String url = BASE_URL + "?apiKey=" + API_KEY;

            // Making the API call and fetching JSON response
            String json = IOUtils.toString(new URL(url).openStream(), "UTF-8");

            // Parsing the JSON response
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("rates");

            // Iterating over all currencies and printing their exchange rates
            Set<String> currencies = rates.keySet();
            for (String currency : currencies) {
                double exchangeRate = rates.get(currency).getAsDouble();
                System.out.println("1 " + currency + " = " + exchangeRate + " " + currency);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        showExchangeRate();
    }
}