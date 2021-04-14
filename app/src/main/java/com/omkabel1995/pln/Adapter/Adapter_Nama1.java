        package com.omkabel1995.pln.Adapter;

        import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.omkabel1995.pln.Features.Menu_LaporanAsset;
        import com.omkabel1995.pln.Features.Menu_MonitoringAset;
        import com.omkabel1995.pln.Model.Model_Pln;
        import com.omkabel1995.pln.R;

        import java.util.List;

        public class Adapter_Nama1 extends RecyclerView.Adapter<Adapter_Nama1.MyViewHolder> {
                Context context;
                List<Model_Pln> Menu;

        public Adapter_Nama1 (Context context, List<Model_Pln> Data_Menu) {
                this.context = context;
                this.Menu = Data_Menu;
                }

        @NonNull
        @Override
        public Adapter_Nama1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(context).inflate(R.layout.list_nama, parent, false);
                Adapter_Nama1 .MyViewHolder holder = new Adapter_Nama1 .MyViewHolder(view);
                return holder;
                }

        @Override
        public void onBindViewHolder(@NonNull Adapter_Nama1 .MyViewHolder holder, int position) {
        //        final String urlgambar = InitRetrofit.BASE_URL+"Gambar/"+Menu.get(position).getImage();
        //        Picasso.with(context).load(urlgambar).into(holder.gambar);
                holder.namapln.setText(Menu.get(position).getNama());
        //        holder.detail.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent intent = new Intent(context, Menu_StatusAsset.class);
        ////                intent.putExtra("ID", Menu.get(position).getId());
        //                intent.putExtra("NAMA", Menu.get(position).getNama());
        ////                intent.putExtra("PENGIRIM", Menu.get(position).getPengirim());
        ////                intent.putExtra("PENERIMA", Menu.get(position).getPenerima());
        ////                intent.putExtra("NAMA_PENGIRIM", Menu.get(position).getNamaPengirim());
        //                context.startActivity(intent);
        //            }
        //        });
                holder.namapln.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                Intent intent = new Intent(context, Menu_LaporanAsset.class);
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
                Intent intent = new Intent(context, Menu_MonitoringAset.class);
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
        //        ImageView gambar;
        //        Button detail;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                namapln = (TextView) itemView.findViewById(R.id.nama);
        //            gambar=(ImageView)itemView.findViewById(R.id.gambarpln);
        //            detail=(Button)itemView.findViewById(R.id.detail);
            }
        }
        }