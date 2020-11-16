package com.example.yoyotest.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.yoyotest.Clases.Deportistas;
import com.example.yoyotest.Clases.tiempos;
import com.example.yoyotest.R;

import java.util.List;

public class TiemposAdapter extends RecyclerView.Adapter<TiemposAdapter.TiemposViewHolder>  {
    private List<tiempos> mItems;
    Activity contexto;
    public TiemposAdapter(Activity context,List<tiempos> item)
    {
        this.contexto=context;
        mItems = item;
    }
    @Override
    public int getItemCount(){
        return mItems.size();
    }
    @Override
    public TiemposAdapter.TiemposViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_tiempos,parent,false);
        TiemposAdapter.TiemposViewHolder viewHolder = new TiemposAdapter.TiemposViewHolder(v);
        return viewHolder;
    }
    @Override
    public void
    onBindViewHolder(TiemposAdapter.TiemposViewHolder holder, int position){
        final tiempos m = mItems.get(position);
        holder.txTiempo.setText("Velocidad: "+m.getTiempo().toString()+" m");
        holder.txVelocidad.setText("Tramo: "+m.getVelocidad().toString()+" m/s");
    }
    public class TiemposViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txTiempo;
        public TextView txVelocidad;

        public TiemposViewHolder(View itemView)
        {
            super(itemView);

            txTiempo = itemView.findViewById(R.id.txTiempo);
            txVelocidad = itemView.findViewById(R.id.txVelocidad);
        }
    }
}
