package com.example.dell1.mainideaapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SettleDebtsAdapter extends RecyclerView.Adapter<SettleDebtsAdapter.ViewHolder> {

    private  MyGroups clickedGrp;
    private Context baseContext;
    private Double totalsum;



    public SettleDebtsAdapter(Context finalResult, SaveBill saveBill) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(baseContext).inflate(R.layout.item_row_rvsettledebts,parent,false) ;
     return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettleDebtsAdapter.ViewHolder holder, int position) {

        GroupMembers currentGrpMember=clickedGrp.getGroupMembersArrayList().get(position);
//        Double balance=currentGrpMember.getPaidAmount()-currentGrpMember.getAmountMemberOwestoOthers();
//        if(balance>0){
//            currentGrpMember.setAmountOthersOwetoMember(balance);
//        }
//        else if(balance<0){
//            currentGrpMember.setAmountMemberOwestoOthers(balance);
//        }
//        else{
//            currentGrpMember.setAmountMemberOwestoOthers(0.0);
//        }
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewOwerIcon,textViewOwerName,textViewPayerIcon,textViewPayerName,textViewAmtOwerToPayer;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewOwerIcon=itemView.findViewById(R.id.tv_rvsettleOwericon);
            textViewOwerName=itemView.findViewById(R.id.tv_rvsettleOwerName);
            textViewPayerIcon=itemView.findViewById(R.id.tv_rvsettlePayericon);
            textViewPayerName=itemView.findViewById(R.id.tv_rvsettlePayerName);
            textViewAmtOwerToPayer=itemView.findViewById(R.id.tv_rvsettleamountowertoPayer);
        }
    }
}
