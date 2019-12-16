package com.it.crudlistviewsanpham;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class sanphamAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<sanpham> sanphamList;

    /********* Create a holder Class to contain inflated xml file elements *********/


    public sanphamAdapter(Context context, int layout, List<sanpham> sanphamList) {
        this.context = context;
        this.layout = layout;
        this.sanphamList = sanphamList;
    }

    @Override
    public int getCount() {
        if(sanphamList.size()<=0)
            return 1;
        return sanphamList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView txtMasp = (TextView) convertView.findViewById(R.id.TextViewMasp);
        TextView txtTensp= (TextView) convertView.findViewById(R.id.TextViewTensp);
        TextView txtSoluong = (TextView) convertView.findViewById(R.id.TextViewSoluong);

        //gan gia tri
        sanpham sanpham = sanphamList.get(position);

        txtMasp.setText(sanpham.getMasp());
        txtTensp.setText(sanpham.getTensp());
        txtSoluong.setText(String.valueOf(sanpham.getSoluong()));


        return convertView;
    }
}
