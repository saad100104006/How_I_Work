package hiw.saad.com.howiwork.Adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aphidmobile.utils.AphidLog;
import com.aphidmobile.utils.IO;
import com.aphidmobile.utils.UI;

import java.util.ArrayList;
import java.util.List;

import hiw.saad.com.howiwork.Models.Flip;
import hiw.saad.com.howiwork.R;

public class FlipAdapter extends BaseAdapter {

  private LayoutInflater inflater;

  private int repeatCount = 0;

  private List<Flip.Data> flipData;

  public FlipAdapter(Context context) {
    inflater = LayoutInflater.from(context);
    flipData = new ArrayList<Flip.Data>(Flip.IMG_DESCRIPTIONS);
  }

  @Override
  public int getCount() {
    return flipData.size();
  }

  public int getRepeatCount() {
    return repeatCount;
  }

  public void setRepeatCount(int repeatCount) {
    this.repeatCount = repeatCount;
  }

  @Override
  public Object getItem(int position) {
    return position;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View layout = convertView;
    if (convertView == null) {
      layout = inflater.inflate(R.layout.activity_flip, null);
      System.out.println("created new view from adapter:  " + position);
    }

    final Flip.Data data = flipData
            .get(position);




    UI
        .<TextView>findViewById(layout, R.id.title)
        .setText(AphidLog.format(data.title));

      //"%d. %s", position, 

    UI
        .<ImageView>findViewById(layout, R.id.photo)
            .setImageBitmap(IO.readBitmap(inflater.getContext().getAssets(), data.imageFilename));

    UI
        .<TextView>findViewById(layout, R.id.description)
            .setText(Html.fromHtml(data.description));



    UI
            .<TextView>findViewById(layout, R.id.category)
            .setText(Html.fromHtml(data.category));

    UI
            .<TextView>findViewById(layout, R.id.date)
            .setText(Html.fromHtml(data.date));

 /*   UI
        .<Button>findViewById(layout, R.id.wikipedia)
        .setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(data.link)
            );
            inflater.getContext().startActivity(intent);
          }
        });*/

    return layout;
  }

  public void removeData(int index) {
    if (flipData.size() > 1) {
      flipData.remove(index);
    }
  }
}
