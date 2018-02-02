package br.com.guimaraescosta.drinknow.br.com.guimaraescosta.drinknow.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by genner.almeida on 21/01/18.
 */

public abstract class GenericAdapter<T> extends ArrayAdapter {

    LayoutInflater layoutInflater;
    Context context;
    private List<T> tList;

    public GenericAdapter(Context context, int resource, List<T> tList) {
        super(context, resource, tList);
        this.context = context;
        this.tList = tList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (tList == null)
            return 0;
        return tList.size();
    }

    @Override
    public Object getItem(int position) {
        return tList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    public abstract View getMyView(int position, View convertView, ViewGroup parent, T t);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getMyView(position, convertView, parent,tList.get(position));
    }
}
