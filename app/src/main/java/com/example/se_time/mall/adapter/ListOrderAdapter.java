package com.example.se_time.mall.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.se_time.mall.R;
import com.example.se_time.mall.listener.OnItemClickListener;
import com.example.se_time.mall.pojo.CartItem;
import com.example.se_time.mall.pojo.Order;
import com.example.se_time.mall.pojo.OrderItem;
import com.example.se_time.mall.ui.OrderListActivity;

import java.util.ArrayList;
import java.util.List;

public class ListOrderAdapter extends RecyclerView.Adapter<ListOrderAdapter.ListOrderViewHolder> implements View.OnClickListener
                ,View.OnLongClickListener{
    private static Context context;
    private List<Order> mData;

    private OnItemClickListener onItemClickListener;

    public ListOrderAdapter(Context context, List<Order> mData) {
        this.context = context;
        this.mData = mData;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public ListOrderAdapter.ListOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.activity_order_list_item,null,true);
        return new ListOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListOrderAdapter.ListOrderViewHolder holder, int position) {

        Order orderItem=mData.get(position);
//        holder.created.setText("创建时间"+orderItem.getCreated());
        holder.amount.setText("￥"+orderItem.getAmount());
        holder.deliveryName.setText("收货人："+orderItem.getDeliveryName());
        holder.orderNo.setText("订单编号"+orderItem.getOrderNo());

        //status 1 未付款  2 已付款 3 已发货 4 交易成功 5交易关闭 6已取消
      //  holder.opt_btn.setText("删除");
        switch (orderItem.getStatus())
        {
            case 1:
                holder.status.setText("未付款");
              //  holder.opt_btn.setText("付款");
                break;
            case 2:
                holder.status.setText("已付款");
                break;
            case 3:
                holder.status.setText("已发货");
              //  holder.opt_btn.setText("确认收货");
                break;
            case 4:
                holder.status.setText("交易成功");
                break;
            case 5:
                holder.status.setText("交易关闭");
                break;
            case 6:
                holder.status.setText("已取消");
                break;
        }
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(this);
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener!=null)
        {
            onItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(onItemClickListener!=null)
        {
            onItemClickListener.onItemLongClick(v,(int)v.getTag());
        }
        return false;
    }

    public static class ListOrderViewHolder extends RecyclerView.ViewHolder{

        private TextView orderNo;
        private View itemView;
        private TextView deliveryName;
       // public TextView created;
      //  public TextView opt_btn;
        public TextView status;
        private  TextView amount;
        public ListOrderViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            orderNo=(TextView)itemView.findViewById(R.id.orderNo);
            deliveryName=(TextView)itemView.findViewById(R.id.deliveryName);
           // created=(TextView) itemView.findViewById(R.id.created);
            status=(TextView)itemView.findViewById(R.id.status);
            amount=(TextView)itemView.findViewById(R.id.total);
        }
    }
}
