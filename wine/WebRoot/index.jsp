<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>北京赤木科技有限公司</title>
  </head>
  <body>
  首页接口：
  <br/>
  <a href="http://localhost:9090/wine/product">http://localhost:9090/wine/product</a>
  <br/>
  商品详情
  <br/>
  <a href="http://localhost:9090/wine/product_detail?id=10">http://localhost:9090/wine/product_detail?id=10</a>
  <br/>
  优惠券通过uid、pid
  <br/>
  <a href="http://localhost:9090/wine/coupon?uid=1">http://localhost:9090/wine/coupon?uid=1</a>
  <br/>
  <a href="http://localhost:9090/wine/coupon?pid=1">http://localhost:9090/wine/coupon?pid=10</a>
  <br/>
  促销详情
  <br/>
  <a href="http://localhost:9090/wine/promotion?id=10">http://localhost:9090/wine/promotion?id=10</a>
  <br/>
  评价详情
  <br/>
  <a href="http://localhost:9090/wine/comment?pid=10">http://localhost:9090/wine/comment?pid=10</a>
  <br/>
  购物车
  <br/>
  <a href="http://localhost:9090/wine/cart_add?pid=10&uid=1&count=2">http://localhost:9090/wine/cart_add?pid=10&uid=1&count=2</a>
  <br/>
  <a href="http://localhost:9090/wine/cart?uid=1">http://localhost:9090/wine/cart?uid=1</a>
  <br/>
  收货地址
  <br/>
  <a href="http://localhost:9090/wine/address_add?name=是妖娆&tel=13524556007&address=北京市北方明珠&uid=1">http://localhost:9090/wine/address_add?name=是妖娆&tel=13524556007&address=北京市北方明珠&uid=1</a>
  <br/>
  <a href="http://localhost:9090/wine/address_modify?name=是妖娆&tel=13524556007&address=北京市北方明珠&id=1">http://localhost:9090/wine/address_modify?name=是妖娆&tel=13524556007&address=北京市北方明珠&id=1</a>
  <br/>
  <a href="http://localhost:9090/wine/address_default?id=125">http://localhost:9090/wine/address_default?id=125</a>
  <br/>
  <a href="http://localhost:9090/wine/address_selected?id=125">http://localhost:9090/wine/address_selected?id=125</a>
  <br/>
  订单
  <br/>
  创建订单Post请求
  <p>http://localhost:9090/wine/order_add, 参数uid，pids，counts，amounts</p>
  <br/>
  <a href="http://localhost:9090/wine/order?id=1012">http://localhost:9090/wine/order?id=1012</a>
  <br/>
  <p>get请求： http://localhost:9090/wine/order_modify，参数id, address_id, coupon_id, status, memo, pay</p>
  </body>
</html>
