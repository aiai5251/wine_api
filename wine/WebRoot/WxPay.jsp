<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String data = (String)request.getParameter("data");
data = URLDecoder.decode(data, "UTF-8");
String url = (String)request.getParameter("url");
url= data = URLDecoder.decode(url, "UTF-8");
%> 
<html>
	<head>
	</head>
	<body>
		<script type="text/javascript">
			function onBridgeReady() {
				WeixinJSBridge.invoke(
					'getBrandWCPayRequest', {<%= data %>},
					function(res) {
						if(res.err_msg == "get_brand_wcpay_request:ok") {
							location.href = <%= url %>;
						} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
					}
				);
			}
			if(typeof WeixinJSBridge == "undefined") {
				if(document.addEventListener) {
					document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
				} else if(document.attachEvent) {
					document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
					document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
				}
			} else {
				onBridgeReady();
			}

			$(function() {
				onBridgeReady();
			})
		</script>
	</body>

</html>