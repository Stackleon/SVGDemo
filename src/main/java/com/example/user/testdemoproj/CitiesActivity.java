package com.example.user.testdemoproj;



import android.app.Activity;
import android.os.Bundle;

import com.example.user.testdemoproj.R;
import com.example.user.testdemoproj.wheel.widget.ArrayWheelAdapter;
import com.example.user.testdemoproj.wheel.widget.OnWheelChangedListener;
import com.example.user.testdemoproj.wheel.widget.WheelView;

public class CitiesActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cities_layout);
                
        WheelView country = (WheelView) findViewById(R.id.country);
        String countries[] = new String[] {"USA", "Canada", "Ukraine", "France"};
        country.setVisibleItems(3);
        country.setAdapter(new ArrayWheelAdapter<String>(countries));

        final String cities[][] = new String[][] {
        		new String[] {"New York", "Washington", "Chicago", "Atlanta", "Orlando"},
        		new String[] {"Ottawa", "Vancouver", "Toronto", "Windsor", "Montreal"},
        		new String[] {"Kiev", "Dnipro", "Lviv", "Kharkiv"},
        		new String[] {"Paris", "Bordeaux"},
        		};
        
        final WheelView city = (WheelView) findViewById(R.id.city);
        city.setVisibleItems(5);

        country.addChangingListener(new OnWheelChangedListener() {
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				city.setAdapter(new ArrayWheelAdapter<String>(cities[newValue]));
				city.setCurrentItem(cities[newValue].length / 2);
			}
		});
        
        country.setCurrentItem(2);
    }
}
