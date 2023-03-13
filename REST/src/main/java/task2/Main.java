package task2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

        JSONArray jsonArray = new JSONArray(response.toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            System.out.println("*******************");
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String ccy = jsonObject.getString("ccy");
            String buy = jsonObject.getString("buy");
            String sale = jsonObject.getString("sale");
            System.out.println("ccy: " + ccy);
            System.out.println("buy: " + buy);
            System.out.println("sale: " + sale);
        }
    }
}
