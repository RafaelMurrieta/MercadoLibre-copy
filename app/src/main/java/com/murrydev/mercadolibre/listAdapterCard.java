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

public class listAdapterCard extends RecyclerView.Adapter<listAdapterCard.ViewHolder> {
    private List<liselement> mData;
    private LayoutInflater minflater;
    private Context context;

    public listAdapterCard(List<liselement> itemList, Context context){
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public listAdapterCard.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = minflater.inflate(R.layout.list_elements, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listAdapterCard.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<liselement> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView textoTopmd, titlemd, pricemd;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImage);
            textoTopmd = itemView.findViewById(R.id.texttop);
            titlemd = itemView.findViewById(R.id.titlep);
            pricemd = itemView.findViewById(R.id.pricep);
        }

        void bindData(final liselement item){
            int resource= context.getResources().getIdentifier(item.getImg(), "drawable", context.getPackageName());
            iconImage.setImageResource(resource);
            textoTopmd.setText(item.getTextoTop());
            titlemd.setText(item.getTitle());
            pricemd.setText(item.price);
        }
    }
}

