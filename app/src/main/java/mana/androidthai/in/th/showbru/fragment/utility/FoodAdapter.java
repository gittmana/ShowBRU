package mana.androidthai.in.th.showbru.fragment.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import mana.androidthai.in.th.showbru.R;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private  String[]imageString,foodStrings,priceStrings,dateilStrings;

    public FoodAdapter(Context context,
                       String[] imageString,
                       String[] foodStrings,
                       String[] priceStrings,
                       String[] dateilStrings) {
        this.context = context;
        this.imageString = imageString;
        this.foodStrings = foodStrings;
        this.priceStrings = priceStrings;
        this.dateilStrings = dateilStrings;

    }

    @Override
    public int getCount() {
        return foodStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_food,parent,false);

        TextView foodTextView = view.findViewById(R.id.txtFood);
        TextView priceTextView = view.findViewById(R.id.txtPrice);
        TextView detailTextView = view.findViewById(R.id.txtDetail);
        ImageView imageView = view.findViewById(R.id.imvFood);

        foodTextView.setText(foodStrings[position]);
        priceTextView.setText(priceStrings[position]);
        detailTextView.setText(dateilStrings[position]);

        Picasso.get().load(imageString[position]).into(imageView);

        return null;
    }
}
