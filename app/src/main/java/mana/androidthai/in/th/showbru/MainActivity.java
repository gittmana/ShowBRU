package mana.androidthai.in.th.showbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mana.androidthai.in.th.showbru.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //     Add Flagment
        if (savedInstanceState==null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment,new MainFragment())
                    .commit();

        }

    }   //Main Method
}   // Main Class
