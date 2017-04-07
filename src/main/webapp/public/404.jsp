<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head></head>
<body>
<div>
你请求的页面不存在.<span id="sec">5</span>秒后转首页
</div>
<script> 
  var v = 5;
  setInterval(function(){
		if(v==0){
			document.location.href="/";
		}
		v--;
		document.getElementById("sec").innerHTML=v;
  },1000);
</script>
</body>
</html>