package shasha.example.com.umisushiapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by LucMurakami on 2017-12-17.
 */

public class SubMenus extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent in = getIntent();
        int index = in.getIntExtra("shasha.example.com.ITEM_INDEX", -1);

        if (index > -1) {
            int item = getItem(index);
            int description = getDescription(index);

            Resources res = getResources();
            myListView = (ListView) findViewById(R.id.myListView);
            items = res.getStringArray(item);
            descriptions = res.getStringArray(description);

            ItemAdapter itemAdapter = new ItemAdapter(this, items, descriptions);
            myListView.setAdapter(itemAdapter);

            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                    showDetailActivity.putExtra("shasha.example.com.ITEM_INDEX", i);
                    startActivity(showDetailActivity);
                }
            }
            );
        }
    }

    private int getItem(int index) {
        switch (index) {
            case 0:
//                return R.layout.appetizer_items;
            case 1:
//                return R.layout.soup_items;
            case 2:
//                return R.layout.roll_items;
            case 3:
                return R.array.sashimi_items;
            default:
                return -1;
        }
    }
    private int getDescription(int index) {
        switch (index) {
            case 0:
//                return R.layout.appetizer_descriptions;
            case 1:
//                return R.layout.soup_descriptions;
            case 2:
//                return R.layout.roll_descriptions;
            case 3:
                return R.array.sashimi_descriptions;
            default:
                return -1;
        }
    }
}