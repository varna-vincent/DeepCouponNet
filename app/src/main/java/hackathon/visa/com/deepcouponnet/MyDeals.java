package hackathon.visa.com.deepcouponnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import hackathon.visa.com.deepcouponnet.model.DealsNearby;
import hackathon.visa.com.deepcouponnet.model.FrequentDestination;
import hackathon.visa.com.deepcouponnet.model.FrequentDestinations;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyDeals extends AppCompatActivity {

    OkHttpClient client;
    FrequentDestinations frequentDestinations;
    ArrayList<DealsNearby> deals;
    ListView listView;
    private static CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_deals);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        String pan = getIntent().getStringExtra("PAN");
        fetchMyDealsByPan(pan);

        deals = new ArrayList<>();

        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(customAdapter);
    }

    private void fetchMyDealsByPan(String pan) {
        final String url = "https://stormy-caverns-64711.herokuapp.com/?pan=4883836336860016&address=6715+W+Colfax+Ave%2C+Lakewood%2C+CO+80214";

        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("TAG", "\nDeepCoupleNet API to fetch the coupons failed\n" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonResponse = response.body().string();
                Log.i("TAG", jsonResponse);

                frequentDestinations = new ObjectMapper().readValue(jsonResponse, FrequentDestinations.class);
                Log.i("TAG", frequentDestinations.toString());

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        for(FrequentDestination frequentDestination : frequentDestinations.getFrequentDestinations()) {
                            if(frequentDestination.getDealsNearby() != null) {
                                for (DealsNearby dealsNearby : frequentDestination.getDealsNearby()) {
                                    deals.add(dealsNearby);
                                }
                            }
                        }

                        customAdapter= new CustomAdapter(deals, getApplicationContext());

                        listView.setAdapter(customAdapter);

                        customAdapter.notifyDataSetChanged();

                    }
                });

            }
        });
    }

}
