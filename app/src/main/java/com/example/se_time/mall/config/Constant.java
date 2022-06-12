package com.example.se_time.mall.config;

public class Constant {

    //常量类

    public static class API{
        //基地址
        public static final String BASE_URL="http://192.168.43.132/mall/";
        public static final String BASE_URL2="http://192.168.43.132/mall";
//        public static final String BASE_URL="http://10.0.2.2:8080/mall/";
//        public static final String BASE_URL2="http://10.0.2.2:8080/mall";
        //产品类型参数
        public static final String CATEGOTYRY_PARAM_URL=BASE_URL+"param/findallparams.do";
        //热销商品
        public static final String HOT_PRODUCT_URL=BASE_URL+"product/findhotproducts.do";
        public static final String CATEGORY_PRODUCT_URL=BASE_URL+"product/findproducts.do";

        public static final String CART_LIST_URL=BASE_URL+"cart/findallcarts.do";
        public static final String CART_DELETE_URL=BASE_URL+"cart/delcarts.do";

        public static final String CART_UPDATE_URL=BASE_URL+"cart/updatecarts.do";
        public static final String USER_INFO_URL=BASE_URL+"user/getuserinfo.do";

        public static final String USER_LOGIN_URL=BASE_URL+"user/do_login.do";
        public static final String USER_LOGOUT_URL=BASE_URL+"user/do_logout.do";
        public static final String USER_ADDR_LIST_URL=BASE_URL+"addr/findaddrs.do";
        public static final String USER_ADDR_DELETE_URL=BASE_URL+"addr/deladdr.do";
        public static final String USER_ADDR_ADD_URL=BASE_URL+"addr/saveaddr.do";
        public static final String USER_ADDR_DEFAULT_URL=BASE_URL+"addr/setdefault.do";
        public static final String USER_REGISTER_URL=BASE_URL+"user/do_register.do";

        public static final String PRODUCT_DETAIL_URL=BASE_URL+"product/getdetail.do";
        public static final String CART_ADD_URL=BASE_URL+"cart/savecart.do";
        public static final String ORDER_CREATE_URL=BASE_URL+"order/createorder.do";
        public static final String ORDER_LIST_URL=BASE_URL+"order/getlist.do";
        public static final String ORDER_DETAIL_URL=BASE_URL+"order/getdetail.do";
        public static final String ORDER_CANCEL_URL=BASE_URL+"order/cancelorder.do";

    }

    public static class ACTION{

        public static final String LOAD_CART_ACTION="com.example.se_time.mall.LOAD_CART_ACTION";
    }
}
