//��''ת��Ϊ'0'
function blankToZero(obj)
{
if(obj=='')
 return '0';
else
return obj;
}
//�ж�һ������Ƿ�Ϊ��
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
//�������Ƿ�ѡ����һ��
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
//�������Ƿ���һ��Ϊ��
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
//�������Ƿ���һ�������  
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
//ֻ������������
function isNumber(objThis){
	trimThis(objThis,objThis);
	if (objThis.value.length!=0){
        var strCheck=/^\d+$/;
        if (!strCheck.exec(objThis.value)){
		    alert("��������ȷ�����֣�");
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
//�Ƿ�������
function isNumeric(oObject)
{
  strNumber=oObject.value; 	  
  if (strNumber.search(/^(-|\+)?\d+(\.\d+)?$/) != -1){
    return true;	
}else{
  alert("��������ȷ������");
  oObject.select();  
  oObject.focus();
  return false;
}	  
}