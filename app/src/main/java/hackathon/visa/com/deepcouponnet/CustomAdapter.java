package hackathon.visa.com.deepcouponnet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hackathon.visa.com.deepcouponnet.model.DealsNearby;

public class CustomAdapter extends ArrayAdapter<DealsNearby> implements View.OnClickListener{

    private ArrayList<DealsNearby> dealsNearbyList;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtVendor;
        TextView txtDeal;
        TextView txtDistance;
    }

    public CustomAdapter(ArrayList<DealsNearby> data, Context context) {
        super(context, R.layout.single_deal, data);
        this.dealsNearbyList = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DealsNearby dealsNearby = (DealsNearby) object;

//        switch (v.getId())
//        {
//            case R.id.item_info:
//                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DealsNearby dealsNearby = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.single_deal, parent, false);
            viewHolder.txtVendor = (TextView) convertView.findViewById(R.id.vendor);
            viewHolder.txtDeal = (TextView) convertView.findViewById(R.id.deal);
            viewHolder.txtDistance = (TextView) convertView.findViewById(R.id.dealDistance);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtVendor.setText(dealsNearby.getVendor());
        viewHolder.txtDeal.setText(dealsNearby.getDeal());
//        viewHolder.txtDistance.setText(dealsNearby.getDist());
        // Return the completed view to render on screen
        return convertView;
    }
}
