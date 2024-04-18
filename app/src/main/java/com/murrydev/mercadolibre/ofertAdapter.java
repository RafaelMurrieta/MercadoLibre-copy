package com.murrydev.mercadolibre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ofertAdapter extends RecyclerView.Adapter<ofertAdapter.ViewHolder> {
    private List<ofertElement> mData;
    private LayoutInflater minflater;
    private Context context;

    public ofertAdapter(List<ofertElement> itemList, Context context){
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public  int getItemCount(){return  mData.size();}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.icons_element, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public  void setItems(List<ofertElement> items){mData = items;}

    public  class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView title;

        ViewHolder(View ItemView){
            super(ItemView);
            iconImage = ItemView.findViewById(R.id.iconImageOf);
            title = ItemView.findViewById(R.id.txtofert);
        }
        void bindData(final ofertElement item){
            int resource =context.getResources().getIdentifier(item.getImgn(), "drawable",context.getPackageName());
            iconImage.setImageResource(resource);
            title.setText(item.getTitle());
        }
    }
}
