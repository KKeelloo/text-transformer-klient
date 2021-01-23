package pl.put.poznan.transformerKlient.back;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

public class KlientBackend {
    public static String request(String text, ArrayList<String> transformacje){
        try{
            HttpGetWithEntity e = new HttpGetWithEntity();
            e.setURI(new URI("http://localhost:8080/"));
            DefaultHttpClient httpClient = new DefaultHttpClient();
            ObjectMapper mapper = new ObjectMapper();
            DataContener dataContener = new DataContener();
            dataContener.setText(text);
            dataContener.setTransforms(transformacje);
            String string = mapper.writeValueAsString(dataContener);
            StringEntity entity = new StringEntity(string,"UTF-8");
            e.setEntity(entity);
            e.setHeader("Content-type", "application/json");
            HttpResponse httpResponse = httpClient.execute(e);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            DataContener data = mapper.readValue(convertStreamToString(httpResponse.getEntity().getContent()), DataContener.class);
            return data.getReturn_val();
        }catch (Exception exception){
        }
        return null;
    }

    public static class DataContener{
        /**
         * Pole zawierające tekst do zmiany
         */
        private String text;
        /**
         * Pole zawierające transformacje do wykonania
         */
        private ArrayList<String> transforms;
        /**
         * Pole zawierające wartość otrzymaną w wyniku transformacji
         */
        private String return_val;
        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public ArrayList<String> getTransforms() {
            return transforms;
        }

        public void setTransforms(ArrayList<String> transforms) {
            this.transforms = transforms;
        }

        public void setReturn_val(String return_val) {
            this.return_val = return_val;
        }

        public String getReturn_val() {
            return return_val;
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}