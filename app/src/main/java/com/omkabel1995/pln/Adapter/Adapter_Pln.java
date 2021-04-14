package com.omkabel1995.pln.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omkabel1995.pln.Features.Menu_StatusAsset;
import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Server.InitRetrofit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_Pln extends RecyclerView.Adapter<Adapter_Pln.MyViewHolder> {
    Context context;
    List<Model_Pln> Menu;

    public Adapter_Pln(Context context, List<Model_Pln> Data_Menu) {
        this.context = context;
        this.Menu = Data_Menu;
    }

    @NonNull
    @Override
    public Adapter_Pln.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_pln, parent, false);
        Adapter_Pln.MyViewHolder holder = new Adapter_Pln.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_Pln.MyViewHolder holder, int position) {
        final String urlgambar = InitRetrofit.BASE_URL+"Gambar/"+Menu.get(position).getImage();
        Picasso.with(context).load(urlgambar).into(holder.gambar);
        holder.namapln.setText(Menu.get(position).getNama());
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Menu_StatusAsset.class);
                intent.putExtra("ID", Menu.get(position).getId());
                intent.putExtra("NAMA", Menu.get(position).getNama());
//                intent.putExtra("PENGIRIM", Menu.get(position).getPengirim());
//                intent.putExtra("PENERIMA", Menu.get(position).getPenerima());
//                intent.putExtra("NAMA_PENGIRIM", Menu.get(position).getNamaPengirim());
                context.startActivity(intent);
            }
        });
        holder.namapln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Menu_StatusAsset.class);
                intent.putExtra("ID", Menu.get(position).getId());
                intent.putExtra("NAMA", Menu.get(position).getNama());
//                intent.putExtra("PENGIRIM", Menu.get(position).getPengirim());
//                intent.putExtra("PENERIMA", Menu.get(position).getPenerima());
//                intent.putExtra("NAMA_PENGIRIM", Menu.get(position).getNamaPengirim());
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Menu_StatusAsset.class);
                intent.putExtra("ID", Menu.get(position).getId());
                intent.putExtra("NAMA", Menu.get(position).getNama());
//                intent.putExtra("PENGIRIM", Menu.get(position).getPengirim());
//                intent.putExtra("PENERIMA", Menu.get(position).getPenerima());
//                intent.putExtra("NAMA_PENGIRIM", Menu.get(position).getNamaPengirim());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return Menu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView namapln;
        ImageView gambar;
        Button detail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namapln = (TextView) itemView.findViewById(R.id.namapln);
           gambar=(ImageView)itemView.findViewById(R.id.gambarpln);
           detail=(Button)itemView.findViewById(R.id.detail);
        }
    }
}


