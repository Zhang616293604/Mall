package com.example.se_time.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.se_time.mall.R;
import com.example.se_time.mall.adapter.ConfirmOrderProductAdapter;
import com.example.se_time.mall.config.Constant;
import com.example.se_time.mall.pojo.CartItem;
import com.example.se_time.mall.pojo.Order;
import com.example.se_time.mall.pojo.OrderItem;
import com.example.se_time.mall.pojo.PageBean;
import com.example.se_time.mall.pojo.ResponseCode;
import com.example.se_time.mall.pojo.SverResponse;
import com.example.se_time.mall.utils.JSONUtils;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public  class OrderDetailActivity extends AppCompatActivity {

    private TextView orderNo;
    private TextView created;
    private TextView type;
    private TextView status;
    private TextView deliveryName;
    private TextView total;
    private TextView buy_btn;
    private RecyclerView recyclerView;

    private ConfirmOrderProductAdapter adapter;

    private SverResponse<Order> result;
    private Order order;
    private List<CartItem> cartItems;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_deatail);
        initView();

        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
        if(!TextUtils.isEmpty(id))
        {
            loadData(id);
        }


    }

    private void initView() {

        orderNo=(TextView)findViewById(R.id.orderNo);
        recyclerView=(RecyclerView)findViewById(R.id.order_detail_rv);
        created=(TextView)findViewById(R.id.created);
        type=(TextView)findViewById(R.id.type);
        status=(TextView)findViewById(R.id.status);
        deliveryName=(TextView)findViewById(R.id.deliveryName);
        total=(TextView)findViewById(R.id.total);
        buy_btn=(TextView)findViewById(R.id.buy_btn);

        cartItems=new ArrayList<>();
        adapter=new ConfirmOrderProductAdapter(this,cartItems);
        adapter.setShowAll(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //??????

            }
        });
    }

    private void loadData( String orderNo)
    {
        OkHttpUtils.get()
                .url(Constant.API.ORDER_DETAIL_URL)
                .addParams("orderNo",orderNo)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                        System.out.println("orderDetail:"+response);
                        Type type=new TypeToken<SverResponse<Order>>(){}.getType();
                        result=JSONUtils.fromJson(response,type);
                        if(result.getStatus()==ResponseCode.SUCCESS.getCode())
                        {
                            cartItems.clear();
                            cartItems.addAll(orderItemsToCartItems(result.getData().getOrderItems()));
                            adapter.notifyDataSetChanged();
                            order=result.getData();
                            updateHeader();
                        }
                        else {
                            Toast.makeText(OrderDetailActivity.this,result.getMsg(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void updateHeader() {
        deliveryName.setText("?????????:"+order.getDeliveryName());
        orderNo.setText("????????????:"+order.getOrderNo());
        created.setText("????????????:"+order.getCreated());

       type.setText("????????????:"+order.getType());
        total.setText("?????????"+order.getAmount());

        //status.setText("????????????:"+order.getStatus());

        switch (order.getStatus())
        {
            case 1:
                status.setText("????????????:?????????");
                break;
            case 2:
                status.setText("????????????:?????????");
                break;
            case 3:
                status.setText("????????????:?????????");
                break;
            case 4:
               status.setText("????????????:????????????");
                break;
            case 5:
                status.setText("????????????:????????????");
                break;
            case 6:
                status.setText("????????????:?????????");
                break;
        }

    }

    private List<CartItem> orderItemsToCartItems(List<OrderItem> datas) {

        List<CartItem> cartItems =new ArrayList<>();
        //????????????????????????
        for(int i=0;i<datas.size();i++)
        {

            OrderItem orderItem=datas.get(i);
            CartItem cartItem=new CartItem();
            cartItem.setName(orderItem.getGoodsName());
            cartItem.setIconUrl(orderItem.getIconUrl());
            cartItem.setPrice(orderItem.getCurPrice());
            cartItem.setQuantity(orderItem.getQuantity());
            cartItem.setTotalPrice(orderItem.getTotalPrice());

            //   System.out.println("dataItem:"+cartItem.getName()+cartItem.getIconUrl()+cartItem.getPrice()+cartItem.getQuantity()+cartItem.getTotalPrice());

            cartItems.add(cartItem);
        }
        return cartItems;
    }
}
