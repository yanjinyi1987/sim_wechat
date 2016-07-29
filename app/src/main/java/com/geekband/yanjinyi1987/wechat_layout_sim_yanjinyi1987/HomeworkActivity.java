package com.geekband.yanjinyi1987.wechat_layout_sim_yanjinyi1987;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeworkActivity extends AppCompatActivity {
    private String[] data = {"去评分","功能介绍","系统通知","帮助与反馈","检查新版本"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        Wechat_ArrayAdapter adapter = new Wechat_ArrayAdapter(HomeworkActivity.this,
                R.layout.wechat_item,data);

        ListView listview = (ListView) findViewById(R.id.wechat_list);
        listview.setAdapter(adapter);
        /*
        TextView textView = (TextView)findViewById(R.id.wechat_copyright_id);
        Log.i("YJY1987",Float.toString(textView.getPaint().getTextSize()));
        Log.i("YJY1987",Float.toString(textView.getPaddingBottom()));
        */
    }
}

class Wechat_ArrayAdapter extends ArrayAdapter<String> {
    private int resourceId;
    public Wechat_ArrayAdapter(Context context, int resource, String[] objects) {
        super(context,resource,objects);
        resourceId=resource;
    }
    /*
    Get a View that displays the data at the specified position in the data set.
    You can either create a View manually or inflate it from an XML layout file.
    When the View is inflated, the parent View (GridView, ListView...) will
    apply default layout parameters unless you use inflate(int, android.view.ViewGroup, boolean)
     to specify a root view and to prevent attachment to the root.
     */
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        String currentstr=getItem(position);
        View view;
        TextView wechat_textview;
        if(convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            wechat_textview = (TextView) view.findViewById(R.id.wechat_item_text);
            view.setTag(wechat_textview);
        }
        else {
            view=convertView;
            wechat_textview = (TextView) view.getTag();
        }
        //Log.i("YJY1987","Start");
        if (wechat_textview!=null) {
            wechat_textview.setTextColor(getContext().getResources().getColor(R.color.wechat_textcolor3));
            wechat_textview.setText(currentstr);
            //Log.i("YJY1987","Pass");
        }
        //Log.i("YJY1987","Stop");
        return view;
    }
}
