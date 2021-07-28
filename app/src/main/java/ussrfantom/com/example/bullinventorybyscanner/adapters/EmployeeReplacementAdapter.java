package ussrfantom.com.example.bullinventorybyscanner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;


public class EmployeeReplacementAdapter extends RecyclerView.Adapter<EmployeeReplacementAdapter.EmployeeReplacementViewHolder>{

    private OnButtonClick onButtonClick;

    public interface OnButtonClick{
        void OnButtonClickShop(int position);
    }

    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    private List<Shop> shops;

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public EmployeeReplacementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.replacement_shop_item, parent, false);
        return new EmployeeReplacementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeeReplacementAdapter.EmployeeReplacementViewHolder holder, int position) {
        Shop shop = shops.get(position);

        holder.textView_name1.setText(shop.getName());
        holder.textView_name_pcd1.setText(shop.getNamePcd());
        holder.textView_pcd_serial_number1.setText(shop.getPcdSerialNumber());
        holder.textView_pcd_ke1.setText(shop.getPcdKe());
        holder.textView_name_server1.setText(shop.getNameServer());
        holder.textView_server_serial_number1.setText(shop.getServerSerialNumber());
        holder.textView_server_ke1.setText(shop.getServerKe());
        holder.textView_router_master1.setText(shop.getRouterMaster());
        holder.textView_router_master_serial_number1.setText(shop.getRouterMasterSerialNumber());
        holder.textView_router_master_ke1.setText(shop.getRouterMasterKe());
        holder.textView_router_reserve1.setText(shop.getRouterReserve());
        holder.textView_router_reserve_serial_number1.setText(shop.getRouterReserveSerialNumber());
        holder.textView_router_reserve_ke1.setText(shop.getRouterReserveKe());
        holder.textView_ups_pcd1.setText(shop.getUpsPcd());
        holder.textView_ups_pcd_serial_number1.setText(shop.getUpsPcdSerialNumber());
        holder.textView_ups_pcd_ke1.setText(shop.getUpsPcdKe());
        holder.textView_ups_server1.setText(shop.getUpsServer());
        holder.textView_ups_server_serial_number1.setText(shop.getUpsServerSerialNumber());
        holder.textView_ups_server_ke1.setText(shop.getUpsServerKe());
        holder.textView_monitor_pcd1.setText(shop.getMonitorPcd());
        holder.textView_monitor_pcd_serial_number1.setText(shop.getMonitorPcdSerialNumber());
        holder.textView_monitor_pcd_ke1.setText(shop.getMonitorPcdKe());
        holder.textView_print_pcd1.setText(shop.getPrintPcd());
        holder.textView_print_pcd_serial_number1.setText(shop.getPrintPcdSerialNumber());
        holder.textView_print_pcd_ke1.setText(shop.getPrintPcdKe());
        holder.textView_tsd11.setText(shop.getTsd1());
        holder.textView_tsd1_serial_number1.setText(shop.getTsd1SerialNumber());
        holder.textView_tsd1_pcd_ke1.setText(shop.getTsd1PcdKe());
        holder.textView_tsd21.setText(shop.getTsd2());
        holder.textView_tsd2_serial_number1.setText(shop.getTsd2SerialNumber());
        holder.textView_tsd2_pcd_ke1.setText(shop.getTsd2PcdKe());
        holder.textView_tsd31.setText(shop.getTsd3());
        holder.textView_tsd3_serial_number1.setText(shop.getTsd3SerialNumber());
        holder.textView_tsd3_pcd_ke1.setText(shop.getTsd3PcdKe());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    class EmployeeReplacementViewHolder extends RecyclerView.ViewHolder{

        TextView textView_name1;
        TextView textView_name_pcd1;
        TextView textView_pcd_serial_number1;
        TextView textView_pcd_ke1;
        TextView textView_name_server1;
        TextView textView_server_serial_number1;
        TextView textView_server_ke1;
        TextView textView_router_master1;
        TextView textView_router_master_serial_number1;
        TextView textView_router_master_ke1;
        TextView textView_router_reserve1;
        TextView textView_router_reserve_serial_number1;
        TextView textView_router_reserve_ke1;
        TextView textView_ups_pcd1;
        TextView textView_ups_pcd_serial_number1;
        TextView textView_ups_pcd_ke1;
        TextView textView_ups_server1;
        TextView textView_ups_server_serial_number1;
        TextView textView_ups_server_ke1;
        TextView textView_monitor_pcd1;
        TextView textView_monitor_pcd_serial_number1;
        TextView textView_monitor_pcd_ke1;
        TextView textView_print_pcd1;
        TextView textView_print_pcd_serial_number1;
        TextView textView_print_pcd_ke1;
        TextView textView_tsd11;
        TextView textView_tsd1_serial_number1;
        TextView textView_tsd1_pcd_ke1;
        TextView textView_tsd21;
        TextView textView_tsd2_serial_number1;
        TextView textView_tsd2_pcd_ke1;
        TextView textView_tsd31;
        TextView textView_tsd3_serial_number1;
        TextView textView_tsd3_pcd_ke1;
        Button button2;
        Button button3;




        public EmployeeReplacementViewHolder(@NonNull  View itemView) {
            super(itemView);
            textView_name1 = itemView.findViewById(R.id.textView_name1);
            textView_name_pcd1 = itemView.findViewById(R.id.textViewName_pcd1);
            textView_pcd_serial_number1 = itemView.findViewById(R.id.textView_pcd_serial_number1);
            textView_pcd_ke1 = itemView.findViewById(R.id.textView_pcd_ke1);
            textView_name_server1 = itemView.findViewById(R.id.textView_name_server1);
            textView_server_serial_number1 = itemView.findViewById(R.id.textView_server_serial_number1);
            textView_server_ke1 = itemView.findViewById(R.id.textView_server_ke1);
            textView_router_master1 = itemView.findViewById(R.id.textView_router_master1);
            textView_router_master_serial_number1 = itemView.findViewById(R.id.textView_router_master_serial_number1);
            textView_router_master_ke1 = itemView.findViewById(R.id.textView_router_master_ke1);
            textView_router_reserve1 = itemView.findViewById(R.id.textView_router_reserve1);
            textView_router_reserve_serial_number1 = itemView.findViewById(R.id.textView_router_reserve_serial_number1);
            textView_router_reserve_ke1 = itemView.findViewById(R.id.textView_router_reserve_ke1);
            textView_ups_pcd1 = itemView.findViewById(R.id.textView_ups_pcd1);
            textView_ups_pcd_serial_number1 = itemView.findViewById(R.id.textView_ups_pcd_serial_number1);
            textView_ups_pcd_ke1 = itemView.findViewById(R.id.textView_ups_pcd_ke1);
            textView_ups_server1 = itemView.findViewById(R.id.textView_ups_server1);
            textView_ups_server_serial_number1 = itemView.findViewById(R.id.textView_ups_server_serial_number1);
            textView_ups_server_ke1 = itemView.findViewById(R.id.textView_ups_server_ke1);
            textView_monitor_pcd1 = itemView.findViewById(R.id.textView_monitor_pcd1);
            textView_monitor_pcd_serial_number1 = itemView.findViewById(R.id.textView_monitor_pcd_serial_number1);
            textView_monitor_pcd_ke1 = itemView.findViewById(R.id.textView_monitor_pcd_ke1);
            textView_print_pcd1 = itemView.findViewById(R.id.textView_print_pcd1);
            textView_print_pcd_serial_number1 = itemView.findViewById(R.id.textView_print_pcd_serial_number1);
            textView_print_pcd_ke1 = itemView.findViewById(R.id.textView_print_pcd_ke1);
            textView_tsd11 = itemView.findViewById(R.id.textView_tsd11);
            textView_tsd1_serial_number1 = itemView.findViewById(R.id.textView_tsd1_serial_number1);
            textView_tsd1_pcd_ke1 = itemView.findViewById(R.id.textView_tsd1_pcd_ke1);
            textView_tsd21 = itemView.findViewById(R.id.textView_tsd21);
            textView_tsd2_serial_number1 = itemView.findViewById(R.id.textView_tsd2_serial_number1);
            textView_tsd2_pcd_ke1 = itemView.findViewById(R.id.textView_tsd2_pcd_ke1);
            textView_tsd31 = itemView.findViewById(R.id.textView_tsd31);
            textView_tsd3_serial_number1 = itemView.findViewById(R.id.textView_tsd3_serial_number1);
            textView_tsd3_pcd_ke1 = itemView.findViewById(R.id.textView_tsd3_pcd_ke1);
            button2 = itemView.findViewById(R.id.button2);
            button3 = itemView.findViewById(R.id.button31);

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onButtonClick.OnButtonClickShop(1);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onButtonClick.OnButtonClickShop(1);
                }
            });



        }
    }

}
