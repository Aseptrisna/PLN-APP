package com.omkabel1995.pln.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.omkabel1995.pln.Controller.Asset;
import com.omkabel1995.pln.Features.Menu_DataAsset;
import com.omkabel1995.pln.Features.Menu_EditAsset;
import com.omkabel1995.pln.Features.Menu_StatusAsset;
import com.omkabel1995.pln.Features.Pemilik.Dashboard_Pemilik;
import com.omkabel1995.pln.Model.Model_Pln;
import com.omkabel1995.pln.R;
import com.omkabel1995.pln.Response.Model_DetailAsset;
import com.omkabel1995.pln.View.ViewAsset;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter_Asset extends RecyclerView.Adapter<Adapter_Asset.MyViewHolder> implements ViewAsset {
    Context context;
    List<Model_DetailAsset> Menu;
    Asset asset;
    ProgressDialog progressDialog;
    String ID,NAMA;



    public Adapter_Asset(Context context, List<Model_DetailAsset> Data_Menu) {
        this.context = context;
        this.Menu = Data_Menu;
        progressDialog=new ProgressDialog(context);
        asset=new Asset(this);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_asset, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            holder.DeskrispiAsset.setText(Menu.get(position).getDeskripsi());
            holder.NomorAsset.setText(Menu.get(position).getNomorAsset());
            holder.KodeAsset.setText(Menu.get(position).getKodeAsset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.editasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Menu_EditAsset.class);
                intent.putExtra("ID", Menu.get(position).getId());
                intent.putExtra("NOMOR_ASSET", Menu.get(position).getNomorAsset());
                intent.putExtra("KODE_ASSET", Menu.get(position).getKodeAsset());
                intent.putExtra("DESKRIPSI", Menu.get(position).getDeskripsi());
                intent.putExtra("ID_ASSET", Menu.get(position).getIdAsset());
                intent.putExtra("STATUS", Menu.get(position).getStatus());
                intent.putExtra("KETERANGAN", Menu.get(position).getKeterangan());
//                intent.putExtra("TANGGAL", Menu.get(position).getKeterangan());
                context.startActivity(intent);
            }
        });
        holder.hapusasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=Menu.get(position).getId();
                ID=Menu.get(position).getId();
//                NAMA=Menu.get(position).ge
                DeleteAsset(id);
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, Menu_StatusAsset.class);
////                intent.putExtra("ID", Menu.get(position).getId());
//                intent.putExtra("NAMA", Menu.get(position).getNama());
////                intent.putExtra("PENGIRIM", Menu.get(position).getPengirim());
////                intent.putExtra("PENERIMA", Menu.get(position).getPenerima());
////                intent.putExtra("NAMA_PENGIRIM", Menu.get(position).getNamaPengirim());
//                context.startActivity(intent);
            }
        });

    }

    private void DeleteAsset(String id) {
        Warning(id);

    }

    private void Warning(String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Mohon Konfirmasi");
        builder.setMessage("Apakah Anda Yakin akan Menghapus data ini?");
        builder.setCancelable(true);
        builder.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Hapus(id);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(context,"Terima Kasih",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void Hapus(String id) {
        progressDialog.setMessage("Hapus Asset.....");
        progressDialog.setCancelable(true);
        progressDialog.show();
        asset.hapusAsset(id);
    }

    @Override
    public int getItemCount() {
        return Menu.size();
    }

    @Override
    public void Berhasil_getdata(List<Model_DetailAsset> data) {

    }

    @Override
    public void Gagal_getdata(String Message) {
        progressDialog.dismiss();
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void Berhasil(String Message) {
        progressDialog.dismiss();
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, Dashboard_Pemilik.class);
        intent.putExtra("ID",ID);
        context.startActivity(intent);

    }

    @Override
    public void No_Internet(String Message) {
        progressDialog.dismiss();
        Toast.makeText(context, Message, Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.NomorAsset)
        TextView NomorAsset;
        @BindView(R.id.KodeAsset)
        TextView KodeAsset;
        @BindView(R.id.DeskrispiAsset)
        TextView DeskrispiAsset;
        @BindView(R.id.editasset)
        Button editasset;
        @BindView(R.id.hapusasset)
        Button hapusasset;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}


