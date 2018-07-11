package hackathon.visa.com.deepcouponnet;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        Intent myDealsIntent = new Intent(this, MyDeals.class);
        myDealsIntent.putExtra("PAN" , pan);
        startActivity(myDealsIntent);
    }
}
