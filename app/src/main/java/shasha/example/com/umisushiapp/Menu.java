package shasha.example.com.umisushiapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Menu extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        items = res.getStringArray(R.array.main_menu_items);
        descriptions = res.getStringArray(R.array.main_menu_descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, descriptions);
        myListView.setAdapter(itemAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showSubMenu = new Intent(getApplicationContext(), SubMenus.class);
                showSubMenu.putExtra("shasha.example.com.ITEM_INDEX", i);
                startActivity(showSubMenu);
            }
        });

    }
}
