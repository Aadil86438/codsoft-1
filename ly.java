
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY"; // Replace with your ExchangeRate-API key
        String baseCurrency = "USD";
        String targetCurrency = "EUR";

        try {
            double exchangeRate = getExchangeRate(apiKey, baseCurrency, targetCurrency);
            System.out.println("Exchange rate from " + baseCurrency + " to " + targetCurrency + ": " + exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String apiKey, String baseCurrency, String targetCurrency) throws Exception {
        String apiUrl = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + apiKey;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            // Parse the JSON response and extract the exchange rate for the target currency
            // Here, you may use a JSON library like Jackson or Gson for better handling
            // For simplicity, we'll use substring-based extraction in this example
            int targetCurrencyIndex = responseBody.indexOf("\"" + targetCurrency + "\":");
            int endIndex = responseBody.indexOf(",", targetCurrencyIndex);
            String rateSubstring = responseBody.substring(targetCurrencyIndex, endIndex);

            // Extract the exchange rate value
            String[] parts = rateSubstring.split(":");
            return Double.parseDouble(parts[1].trim());
        } else {
            throw new RuntimeException("Failed to fetch exchange rates. Status code: " + response.statusCode());
        }
    }
}

class getcurrency
{
    String basecur;
    String convcur;
    public void getcur()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base currency:");
        basecur =sc.nextLine();
        System.out.println("");
        System.out.println("Enter the CURRENCY converted to:");
        convcur = sc.nextLine();
    }
}




public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		getcurrency gc = new getcurrency();
		gc.getcur();
	}
}
