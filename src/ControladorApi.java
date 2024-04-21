import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Map;
public class ControladorApi {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private String apiKey;

    public ControladorApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public Map<String, Double> getConversionRates(String baseCurrency) throws Exception {
        // Realizar la solicitud a la API
        String urlStr = BASE_URL + apiKey + "/latest/" + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Leer la respuesta
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Analizar la respuesta JSON
        Gson gson = new Gson();
        Map<String, Object> responseJson = gson.fromJson(response.toString(), Map.class);

        // Obtener las tasas de cambio
        return (Map<String, Double>) responseJson.get("conversion_rates");
    }
}
