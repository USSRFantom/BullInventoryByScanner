package ussrfantom.com.example.bullinventorybyscanner.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.pojo.Shop;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {


    private List<Shop> shops;  //!!!!!!!!!!!


    public List<Shop> getShops() {   //!!!!!!!!!!
        return shops;
    }

    public void setShops(List<Shop> shops) { //!!!!!!!!!!
        this.shops = shops;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  EmployeeViewHolder employeeViewHolder, int position) {
    Shop shop = shops.get(position);
        employeeViewHolder.textView_name.setText(shop.getName());
        employeeViewHolder.textView_name_pcd.setText(shop.getNamePcd());
        employeeViewHolder.textView_pcd_serial_number.setText(shop.getPcdSerialNumber());
        employeeViewHolder.textView_pcd_ke.setText(shop.getPcdKe());
        employeeViewHolder.textView_name_server.setText(shop.getNameServer());
        employeeViewHolder.textView_server_serial_number.setText(shop.getServerSerialNumber());
        employeeViewHolder.textView_server_ke.setText(shop.getServerKe());
        employeeViewHolder.textView_router_master.setText(shop.getRouterMaster());
        employeeViewHolder.textView_router_master_serial_number.setText(shop.getRouterMasterSerialNumber());
        employeeViewHolder.textView_router_master_ke.setText(shop.getRouterMasterKe());
        employeeViewHolder.textView_router_reserve.setText(shop.getRouterReserve());
        employeeViewHolder.textView_router_reserve_serial_number.setText(shop.getRouterReserveSerialNumber());
        employeeViewHolder.textView_router_reserve_ke.setText(shop.getRouterReserveKe());
        employeeViewHolder.textView_ups_pcd.setText(shop.getUpsPcd());
        employeeViewHolder.textView_ups_pcd_serial_number.setText(shop.getUpsPcdSerialNumber());
        employeeViewHolder.textView_ups_pcd_ke.setText(shop.getUpsPcdKe());
        employeeViewHolder.textView_ups_server.setText(shop.getUpsServer());
        employeeViewHolder.textView_ups_server_serial_number.setText(shop.getUpsServerSerialNumber());
        employeeViewHolder.textView_ups_server_ke.setText(shop.getUpsServerKe());
        employeeViewHolder.textView_monitor_pcd.setText(shop.getMonitorPcd());
        employeeViewHolder.textView_monitor_pcd_serial_number.setText(shop.getMonitorPcdSerialNumber());
        employeeViewHolder.textView_monitor_pcd_ke.setText(shop.getMonitorPcdKe());
        employeeViewHolder.textView_print_pcd.setText(shop.getPrintPcd());
        employeeViewHolder.textView_print_pcd_serial_number.setText(shop.getPrintPcdSerialNumber());
        employeeViewHolder.textView_print_pcd_ke.setText(shop.getPrintPcdKe());
        employeeViewHolder.textView_tsd1.setText(shop.getTsd1());
        employeeViewHolder.textView_tsd1_serial_number.setText(shop.getTsd1SerialNumber());
        employeeViewHolder.textView_tsd1_pcd_ke.setText(shop.getTsd1PcdKe());
        employeeViewHolder.textView_tsd2.setText(shop.getTsd2());
        employeeViewHolder.textView_tsd2_serial_number.setText(shop.getTsd2SerialNumber());
        employeeViewHolder.textView_tsd2_pcd_ke.setText(shop.getTsd2PcdKe());
        employeeViewHolder.textView_tsd3.setText(shop.getTsd3());
        employeeViewHolder.textView_tsd3_serial_number.setText(shop.getTsd3SerialNumber());
        employeeViewHolder.textView_tsd3_pcd_ke.setText(shop.getTsd3PcdKe());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView textView_name;
        TextView textView_name_pcd;
        TextView textView_pcd_serial_number;
        TextView textView_pcd_ke;
        TextView textView_name_server;
        TextView textView_server_serial_number;
        TextView textView_server_ke;
        TextView textView_router_master;
        TextView textView_router_master_serial_number;
        TextView textView_router_master_ke;
        TextView textView_router_reserve;
        TextView textView_router_reserve_serial_number;
        TextView textView_router_reserve_ke;
        TextView textView_ups_pcd;
        TextView textView_ups_pcd_serial_number;
        TextView textView_ups_pcd_ke;
        TextView textView_ups_server;
        TextView textView_ups_server_serial_number;
        TextView textView_ups_server_ke;
        TextView textView_monitor_pcd;
        TextView textView_monitor_pcd_serial_number;
        TextView textView_monitor_pcd_ke;
        TextView textView_print_pcd;
        TextView textView_print_pcd_serial_number;
        TextView textView_print_pcd_ke;
        TextView textView_tsd1;
        TextView textView_tsd1_serial_number;
        TextView textView_tsd1_pcd_ke;
        TextView textView_tsd2;
        TextView textView_tsd2_serial_number;
        TextView textView_tsd2_pcd_ke;
        TextView textView_tsd3;
        TextView textView_tsd3_serial_number;
        TextView textView_tsd3_pcd_ke;


        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_name = itemView.findViewById(R.id.textView_name);
            textView_name_pcd = itemView.findViewById(R.id.textViewName_pcd);
            textView_pcd_serial_number = itemView.findViewById(R.id.textView_pcd_serial_number);
            textView_pcd_ke = itemView.findViewById(R.id.textView_pcd_ke);
            textView_name_server = itemView.findViewById(R.id.textView_name_server);
            textView_server_serial_number = itemView.findViewById(R.id.textView_server_serial_number);
            textView_server_ke = itemView.findViewById(R.id.textView_server_ke);
            textView_router_master = itemView.findViewById(R.id.textView_router_master);
            textView_router_master_serial_number = itemView.findViewById(R.id.textView_router_master_serial_number);
            textView_router_master_ke = itemView.findViewById(R.id.textView_router_master_ke);
            textView_router_reserve = itemView.findViewById(R.id.textView_router_reserve);
            textView_router_reserve_serial_number = itemView.findViewById(R.id.textView_router_reserve_serial_number);
            textView_router_reserve_ke = itemView.findViewById(R.id.textView_router_reserve_ke);
            textView_ups_pcd = itemView.findViewById(R.id.textView_ups_pcd);
            textView_ups_pcd_serial_number = itemView.findViewById(R.id.textView_ups_pcd_serial_number);
            textView_ups_pcd_ke = itemView.findViewById(R.id.textView_ups_pcd_ke);
            textView_ups_server = itemView.findViewById(R.id.textView_ups_server);
            textView_ups_server_serial_number = itemView.findViewById(R.id.textView_ups_server_serial_number);
            textView_ups_server_ke = itemView.findViewById(R.id.textView_ups_server_ke);
            textView_monitor_pcd = itemView.findViewById(R.id.textView_monitor_pcd);
            textView_monitor_pcd_serial_number = itemView.findViewById(R.id.textView_monitor_pcd_serial_number);
            textView_monitor_pcd_ke = itemView.findViewById(R.id.textView_monitor_pcd_ke);
            textView_print_pcd = itemView.findViewById(R.id.textView_print_pcd);
            textView_print_pcd_serial_number = itemView.findViewById(R.id.textView_print_pcd_serial_number);
            textView_print_pcd_ke = itemView.findViewById(R.id.textView_print_pcd_ke);
            textView_tsd1 = itemView.findViewById(R.id.textView_tsd1);
            textView_tsd1_serial_number = itemView.findViewById(R.id.textView_tsd1_serial_number);
            textView_tsd1_pcd_ke = itemView.findViewById(R.id.textView_tsd1_pcd_ke);
            textView_tsd2 = itemView.findViewById(R.id.textView_tsd2);
            textView_tsd2_serial_number = itemView.findViewById(R.id.textView_tsd2_serial_number);
            textView_tsd2_pcd_ke = itemView.findViewById(R.id.textView_tsd2_pcd_ke);
            textView_tsd3 = itemView.findViewById(R.id.textView_tsd3);
            textView_tsd3_serial_number = itemView.findViewById(R.id.textView_tsd3_serial_number);
            textView_tsd3_pcd_ke = itemView.findViewById(R.id.textView_tsd3_pcd_ke);

        }
    }
}
