//将''转化为'0'
function blankToZero(obj)
{
if(obj=='')
 return '0';
else
return obj;
}
//判断一组对象是否都为空
function allIsNull(obj)
{
allIsNullResult=true;
for (i=0;i<obj.length;i++){
  if (obj[i].value!=''){   	    
    allIsNullResult=false; 
  }
}
return allIsNullResult;
}
//多项中是否选择了一项
  function isSelected(oObject){	
	selectResult=false;
      for (i = 0; i < oObject.length; i++){
		 if (oObject[i].checked==true){  
		    selectResult=true;
			return selectResult;
		 }		 
      }	
	return selectResult;  
  }
//多项中是否有一项为空
function itemIsNull(oObject){ 	
  nullResult=false;
  for (i = 0; i < oObject.length; i++){
    if (oObject[i].value==""){ 
      oObject[i].select(); 
      nullResult=true;
	  return nullResult;
    }		 
  }	
  return nullResult;  
}     
//多项中是否有一项不是数字  
function itemIsNotNumber(oObject){ 	
  notNumbeResult=false;  
  for (i = 0; i < oObject.length; i++){
    if (oObject[i].value!=""&&!isNumeric(oObject[i])){ 
      //oObject[i].select(); 
      notNumbeResult=true;
	  return notNumbeResult;
    }		 
  }	
  return notNumbeResult;  
}   
//只能输入正整数
function isNumber(objThis){
	trimThis(objThis,objThis);
	if (objThis.value.length!=0){
        var strCheck=/^\d+$/;
        if (!strCheck.exec(objThis.value)){
		    alert("请输入正确的数字！");
            objThis.select();			
            return false;
        }
				else
				{
					return true;
				}
    }
}  
//
function trimThis(objThis,chkObj){
    try{
        objThis.value=objThis.value.replace(/(^\s*)|(\s*$)/g,"");
    }
    catch(e){
    }
}
//是否是数字
function isNumeric(oObject)
{
  strNumber=oObject.value; 	  
  if (strNumber.search(/^(-|\+)?\d+(\.\d+)?$/) != -1){
    return true;	
}else{
  alert("请输入正确的数字");
  oObject.select();  
  oObject.focus();
  return false;
}	  
}