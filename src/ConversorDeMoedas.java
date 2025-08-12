import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoedas {

    private final String apiKey;

    public ConversorDeMoedas(String apiKey) {
        this.apiKey = apiKey;
    }

    public double obterTaxa(String base, String destino) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/e997f3f0b0be08a12a7f8ccc/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String body = response.body();

            JsonObject json = JsonParser.parseString(body).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (!rates.has(destino)) {
                throw new IOException("Moeda de destino não encontrada: " + destino);
            }

            return rates.get(destino).getAsDouble();
        } else {
            throw new IOException("Falha na chamada. Descrição da falha:\n" + response.body());
        }
    }

    public double converter(double valor, String base, String destino) throws IOException, InterruptedException {
        double taxa = obterTaxa(base, destino);
        return valor * taxa;
    }
}
