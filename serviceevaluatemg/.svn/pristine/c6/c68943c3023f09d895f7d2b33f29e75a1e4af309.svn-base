
window.onload=function(){
	
	
	var oBtn=document.getElementById('btn');
	var oDiv=document.getElementById('div');
	var aLi = oDiv.getElementsByTagName('li');
	var oTu=document.getElementById('tu1');
	
	oBtn.onfocus=function(){
		oDiv.style.display='block';
	}
	
	var n=0;
	for(var i=0;i<aLi.length;i++){
		aLi[i].onclick=function(){
			var n=this.innerHTML;
			oBtn.value+=n;
		}
		
	}
	
	oTu.onclick=function(){
		oBtn.value='';
		oDiv.style.display='none';
	}
}

