<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-3.3.1.js"  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="  crossorigin="anonymous"></script>
</head>
<body>
<input type="button" value="ajax 문자역" id="ajaxString"/>
<input type="button" value="ajax Object" id="ajaxObject"/>
<input type="button" value="ajax List" id="ajaxList"/>
<input type="button" value="ajax map" id="ajaxMap"/>
	<div id="str"></div>
	<div id="obj"></div>
	<div id="list"></div>
	<div id="map"></div>

	<div>
		<form method="post" id="frm">
			번호: <input type="text" name="no"/><br/>
			이름: <input type="text" name="name"/><br/>
			<input type="button" value="submit" id="btn"/>
		</form>
		<div id="result2"></div>
	</div>

</body>
<script>
const ajaxString = document.querySelector("#ajaxString");
const ajaxObject = document.querySelector("#ajaxObject");
const ajaxList = document.querySelector("#ajaxList");
const ajaxMap = document.querySelector("#ajaxMap");


const frm = document.querySelector("#frm");

const btn = document.querySelector("#btn");

const result2 = document.querySelector("#result2");
const str = document.querySelector("#str");
const obj = document.querySelector("#obj");
const list = document.querySelector("#list");
const map = document.querySelector("#map");

//const ajaxString = document.querySelector("#ajaxString");

	function event(){
		ajaxString.addEventListener("click",function(){
			let uri ="/webAjax/ajaxString";
			let param = "no=123&name=이순신";
			$.ajax({
				type : "GET",
				url : uri,
				data : param,
				contentType : 'application/json;charset=UTF-8',
				success : function(result){
					str.innerHTML=result;
				},
				error : function(error){
					str.innerHTML=error.responseText;
				}
			});
		});
		
		ajaxObject.addEventListener("click",function(){
			let uri ="/webAjax/ajaxObject";
			let param = "no=1111&name=홍길동";
			$.ajax({
				type:"GET",
				url : uri,
				data : param,
				contentType : 'application/json;charset=UTF-8',
				success : function(result){
					const str = "no=" + result.no +", name="+result.name;
					obj.innerHTML= str;
				},
				error : function(error){
					obj.innerHTML=error.responseText;
				}
			});
			
			
		});
		
		ajaxList.addEventListener("click",function(){
			let uri ="/webAjax/ajaxList";
			let param = "no=2222&name=경복궁";
			$.ajax({
				type:"GET",
				url : uri,
				data : param,
				contentType : 'application/json;charset=UTF-8',
				success : function(result){
					//foreach
					let result3 = $(result);
					list.innerHTML = result3;
					let txt ="<ul>";
					
					result3.each(function(idx,data){
						txt += "<li>no :"+data.no+" name : "+data.name+"</li>"
					});
					txt+= "</ul>"
					list.innerHTML = txt;
				},
				error : function(error){
					list.innerHTML=error.responseText;
				}
			});
		});
		//map
		ajaxMap.addEventListener("click",function(){
			let uri ="/webAjax/ajaxMap";
			let param = "no=3333&name=창덕궁";
			$.ajax({
				type:"GET",
				url : uri,
				data : param,
				contentType : 'application/json;charset=UTF-8',
				success : function(result){
					let txt = "<ul>";
					txt += "<li>"+result.A.no +","+ result.A.name+ "</li>"
					txt += "<li>"+result.B.no +","+ result.B.name+ "</li>"
					txt += "<li>"+result.C.no +","+ result.C.name+ "</li>"
					txt += "<li>"+result.D.no +","+ result.D.name+ "</li></ul>"
					map.innerHTML = txt;
				},
				error : function(error){
					map.innerHTML=error.responseText;
				}
			});
		})
		
		
		btn.addEventListener("click",function(){
			//event.preventDefault();
			let uri ="/webAjax/ajaxForm";
			let param = $("#frm").serialize();
			console.log(param);
			$.ajax({
				type:"POST",
				url : uri,
				data : param,
				contentType : 'application/json;charset=UTF-8',
				success : function(result){
					result2.innerHTML = result
				},
				error : function(error){
					result2.innerHTML = error.responseText;
				}
			});
		});
		
	}
	event();
	
	
	
	
	
</script>


</html>