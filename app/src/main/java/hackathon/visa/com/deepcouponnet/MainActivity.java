package hackathon.visa.com.deepcouponnet;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.root_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    public void getCoupons(View view) {

        String pan = ((EditText) findViewById(R.id.txtPan)).getText().toString();
        createCardIdForPAN(pan);
    }

    private String createCardIdForPAN(String pan) {

        final String url = "https://sandbox.api.visa.com/dcas/cardservices/v1/cards";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String greeting = restTemplate.getForObject(url, String.class);
        Toast.makeText(MainActivity.this, "Sending response", Toast.LENGTH_SHORT).show();
        return greeting;
    }
}
