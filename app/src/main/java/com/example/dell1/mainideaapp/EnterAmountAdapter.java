package com.example.dell1.mainideaapp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterAmountAdapter extends RecyclerView.Adapter<EnterAmountAdapter.ViewHolder>{


    Context context;
    private MyGroups clickedGrp;
    public static ArrayList<EditModel> editModelArrayList;

    public EnterAmountAdapter(Context context, MyGroups clickedGrp,ArrayList<EditModel> editModelArrayList) {
        this.editModelArrayList=editModelArrayList;
        this.context=context;
        this.clickedGrp=clickedGrp;
    }

    @NonNull
    @Override
    public EnterAmountAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_row_enter_amt_for_split,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnterAmountAdapter.ViewHolder holder, int position) {

        GroupMembers currentGrpMember=clickedGrp.getGroupMembersArrayList().get(position);
        String initial=currentGrpMember.getName().substring(0,1);
        holder.textView1.setText(initial);
        holder.textView2.setText(currentGrpMember.getName());
        holder.editText.setText(editModelArrayList.get(position).getEditTextValue());
    }

    @Override
    public int getItemCount() {
        return editModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        EditText editText;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.tv_itemrowenteramtforsplitIcon);
            textView2=itemView.findViewById(R.id.tv_itemrowenteramtforsplitName);
            editText=itemView.findViewById(R.id.etAddAmounttoSplit);
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(!editText.getText().toString().equals(""))
                    editModelArrayList.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
                    else{
                        editModelArrayList.get(getAdapterPosition()).setEditTextValue("0.0");
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

//    public ArrayList<Double> getDoubleArrayList() {
//        return doubleArrayList;
//    }
}
