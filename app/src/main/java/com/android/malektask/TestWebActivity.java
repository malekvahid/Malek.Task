package com.android.malektask;




import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.util.Log;

        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.util.logging.LoggingMXBean;

public class TestWebActivity extends AppCompatActivity {

    private static final String TAG = "TestHttpClientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web);
//        final String address = "https://www.omdbapi.com/?s=gladiator&apikey=70ad462a";
        final String address = "http://api.aladhan.com/v1/timingsByCity?city=Dubai&country=United%20Arab%20Emirates&method=8";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL obj = new URL(address);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", "Mozilla/5.0");
                    int responseCode = con.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {

                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                con.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        System.out.println(response.toString());
                        JSONObject object = new JSONObject(response.toString());
                        String data = object.getString("Search");
                        JSONObject object1 = new JSONObject(data);
                        String data1 = object1.getString("2");
                        JSONObject object2 = new JSONObject(data1);
                        String asr = object2.getString("Title");
                        Log.d(TAG, "run: " + asr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
