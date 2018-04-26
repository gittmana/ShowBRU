package mana.androidthai.in.th.showbru.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import mana.androidthai.in.th.showbru.R;
import mana.androidthai.in.th.showbru.fragment.utility.FoodAdapter;
import mana.androidthai.in.th.showbru.fragment.utility.GetAllData;
import mana.androidthai.in.th.showbru.fragment.utility.MyConstant;

public class ServiceFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Listview
        createListview();


    }//Main Method

    private void createListview() {
        ListView listView = getView().findViewById(R.id.listViewFood);
        MyConstant myConstant = new MyConstant();

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetAllFood());

            String jsonString = getAllData.get();

            JSONArray jsonArray = new JSONArray(jsonString);

            String[] foodString = new String[jsonArray.length()];
            String[] priceString = new String[jsonArray.length()];
            String[] detailString = new String[jsonArray.length()];
            String[] imageString = new String[jsonArray.length()];

            for (int i = 0; i<jsonArray.length(); i+=1){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                foodString[i] = jsonObject.getString("NameFood");
                priceString[i] = jsonObject.getString("Price");
                detailString[i] = jsonObject.getString("Detail");
                imageString[i] = jsonObject.getString("ImagePath");

            }

            FoodAdapter foodAdapter = new FoodAdapter(getActivity(),
                    imageString, foodString,priceString,detailString);
            listView.setAdapter(foodAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service,container, false);
        return view;

    }
}
