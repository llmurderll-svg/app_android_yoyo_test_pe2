package com.example.yoyotest.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.yoyotest.Clases.Deportistas;
import com.example.yoyotest.R;

import java.util.List;

public class DeportistasAdapter extends RecyclerView.Adapter<DeportistasAdapter.DeportistasViewHolder> {
    private List<Deportistas> mItems;
    Activity contexto;
    public DeportistasAdapter(Activity context,List<Deportistas> item)
    {
        this.contexto=context;
        mItems = item;
    }
    @Override
    public int getItemCount(){
        return mItems.size();
    }
    @Override
    public DeportistasViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_deportista,parent,false);
        DeportistasViewHolder viewHolder = new DeportistasViewHolder(v);
        return viewHolder;
    }
    @Override
    public void
    onBindViewHolder(DeportistasViewHolder holder, int position){
        final Deportistas m = mItems.get(position);
        holder.txv_nombre.setText("Nombre: "+m.getNombre().toString());
        holder.txv_codigo.setText("Codigo: "+m.getCodigo().toString());
        holder.txv_deporte.setText("Deporte: "+m.getDeporte().toString());
    }
    public class DeportistasViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txv_nombre;
        public TextView txv_codigo;
        public TextView txv_deporte;

        public DeportistasViewHolder(View itemView)
        {
            super(itemView);
            //Obtenemos las referencias de los componentes:
            txv_nombre = itemView.findViewById(R.id.txv_Nombre);
            txv_codigo = itemView.findViewById(R.id.txv_Codigo);
            txv_deporte = itemView.findViewById(R.id.txv_Deporte);
        }
    }
}
