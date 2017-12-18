package shasha.example.com.umisushiapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("shasha.example.com.ITEM_INDEX", -1);
        String identifier = in.getStringExtra("shasha.example.com.ITEM_IDENTIFIER");



        if (index > -1) {
            int pic = getIdentifier(identifier, index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getIdentifier(String identifier, int index) {
        switch (identifier) {
            case "appetizer": return getImgAppetizer(index);
            case "soup": return getImgSoup(index);
            case "roll": return getImgRoll(index);
            case "sashimi": return getImgSashimi(index);
            default: return -1;
        }
    }

    private int getImgAppetizer(int index) {
        switch (index) {
            case 0: return R.drawable.appetizer;
            case 1: return R.drawable.appetizer;
            case 2: return R.drawable.appetizer;
            case 3: return R.drawable.appetizer;
            default: return -1;
        }
    }
    private int getImgSoup(int index) {
        switch (index) {
            case 0: return R.drawable.soup;
            case 1: return R.drawable.soup;
            case 2: return R.drawable.soup;
            case 3: return R.drawable.soup;
            default: return -1;
        }
    }
    private int getImgRoll(int index) {
        switch (index) {
            case 0: return R.drawable.roll;
            case 1: return R.drawable.roll;
            case 2: return R.drawable.roll;
            case 3: return R.drawable.roll;
            default: return -1;
        }
    }
    private int getImgSashimi(int index) {
        switch (index) {
            case 0: return R.drawable.sashimi;
            case 1: return R.drawable.sashimi;
            case 2: return R.drawable.sashimi;
            case 3: return R.drawable.sashimi;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }
}
