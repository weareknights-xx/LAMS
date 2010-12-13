
//是否为中文
function bol_chinese(str)
{
	var pattern = /[^\u4E00-\u9FA5]/;
	if(pattern.test(str)) return false;
	else return true;
}
//返回unicode编码
function ParamUnicode(param)
{
	for(i=0;i<param.length;i++)
	{
		if(bol_chinese(param.substring(i,i+1))) param=param.substring(0,i)+escape(param.substring(i,i+1))+param.substring(i+1,param.length);
	}
	return param;
}
//返回字符串的长度
function str2Length(src)
{
	var nLength = 0;
	if (src == '')
	{
		return nLength;
	}
	else
	{
		for (nI = 0; nI < src.length; nI++)
		{
			if ( ! bol_chinese(src.substring(nI,nI+1)))
			{
				nLength +=1 ;
			}
			else
			{
				nLength += 2;
			}
		}
	}

	return nLength;
}



//验证录入的时间是否合法
//
function checkDate(objName,objLength)
{
  if ( objLength < 1)
  {
    //没有需要验证的数据
    return true;
  }
  else if (objLength == 1)
  {
    //调用基础验证函数
    if (formatDate(objName) == true)
    {
      return true;
    }
    else
    {
      objName.select();
      objName.focus();
      return false;
    }
  }
  else
  {
    for(amount_i = 0; amount_i < objName.length; amount_i++)
    {
      if (formatDate(objName[amount_i]) == false)
      {
        objName[amount_i].select();
        objName[amount_i].focus();
        return false;
      }
    }
    return true;
  }
}
//
//日期比较大小
//
function compareDate(dBegin,dEnd)
{
  if (!isNull(dBegin) && !isNull(dEnd))
  {
    if (formatDate(dBegin) == false) return false;
    if (formatDate(dEnd) == false) return false;
    if (dBegin.value > dEnd.value)
    {
      alert('起始日期大于终止日期.');
      dEnd.select();
      dEnd.focus();
      return -1;
    }
    else if (dBegin.value < dEnd.value)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
  else
  {
    return false;
  }
}

//
//是否为零
//

function checkZero(objName,objLength)
{

  if (checkPublic(objName,objLength,2) == true)
  {
    return true;
  }
  else
  {
    alert('请输入大于 0 的整数.');
    return false;
  }

  //return true;
}


function trimThis(objThis,chkObj){
    try{
        objThis.value=objThis.value.replace(/(^\s*)|(\s*$)/g,"");
    }
    catch(e){
    }
}
function trimThis(objThis){
    if (objThis.value != '')
    {
	    try{
	        objThis.value=objThis.value.replace(/(^\s*)|(\s*$)/g,"");
	    }
	    catch(e){
    }
}
}
//
//为了避免每一次重复判断控件是一个还是一组。
//
function checkPublic(objName,objLength,functionID)
{
  var temResult = true;
  if ( objLength < 1)
  {
    //没有需要验证的数据
    return true;
  }
  else if (objLength == 1)
  {
    //调用基础验证函数
    switch (functionID)
    {
      case 1:
           temResult = isNull(objName);
        break;
      case 2:
           temResult = greaterZero(objName);
        break;
    }
    if (temResult == true)
    {
      return true;
    }
    else
    {
      objName.select();
      objName.focus();
      return false;
    }
  }
  else
  {
    for(amount_i = 0; amount_i < objName.length; amount_i++)
    {
      switch (functionID)
      {
        case 1:
            temResult = isNull(objName[amount_i]);
          break;
        case 2:
           temResult = greaterZero(objName[amount_i]);
         break;
      }

      if (temResult == false)
      {
        objName[amount_i].select();
        objName[amount_i].focus();
        return false;
      }
    }
    return true;
  }
}
//消除一个表单中所有元素首尾空格
function trimAll(frmObj){
    for (var i=1;i<frmObj.elements.length-1;i++)    {
        frmObj.elements[i].value
          =frmObj.elements[i].value.replace(/(^\s*)|(\s*$)/g,"");
    }
}
//判断是否为空
function isNull(objName)
{
  objName.value = objName.value.replace(/(^\s*)|(\s*$)/g,"");
  if (objName.value == '')
  {
    return true;
  }
  else
  {
    return false;
  }
}

//只能输入正整数
function isNumber(objThis){
	trimThis(objThis,objThis);
	if (objThis.value.length!=0){
        var strCheck=/^\d+$/;
        if (!strCheck.exec(objThis.value)){
            alert('数字格式不正确.');
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
//判断数字是否为0
//
function greaterZero(objName)
{
  trimThis(objName);
  if (isNumeric(objName.value) && parseFloat(objName.value) > 0)
  {
    return true;
  }
  else
  {
    return false;
  }
}
//货币类型验证
//作用是将输入变成Number(10,2)格式 数据长度不包括小数点位置
//是否是数字
function isNumeric(strNumber)
{
	return (strNumber.search(/^(-|\+)?\d+(\.\d+)?$/) != -1);
}
//是否是正整数
function isInteger(strInteger) {
	return (strInteger.search(/^(-|\+)?\d+$/) != -1);
}
//判断输入的货币类型是否合法(无符号类型)
function checkUnsignedDecimalInput(obj,dataLength,fractionLength)
{
	obj.value = obj.value.replace(/-/g,"");
	return checkDecimalInput(obj,dataLength,fractionLength);
}

function checkIntInput(obj,min,max)		//作用是将输入变成整数，默认范围是非负。onblur event
	{
	obj.value=obj.value.replace(/ /g,"");		//去空格
	if(obj.value=="") return false;
	var r;
	var s = obj.value ;
	var theMin=-1;
	var theMax=10000000000;
	if (min!=null) theMin=min;
	if (max!=null) theMax=max;
	if (s.length==0) return false;
	r = parseInt(s);;								//取数
	if (r==null||isNaN(r))
	{
		obj.value="";
		alert("！！！！请注意：\n您刚才输入的整数不正确，我们已进行了清除。");
		obj.focus();
		return false;
	}
	if ((r>=theMax)||(r<=theMin))
	{
		obj.value="";
		alert("！！！！请注意：\n您刚才输入的整数超出允许范围，我们已进行了清除。");
		obj.focus();
		return false;
	}
	if ( r!=s)
	{
		obj.value=r;
		alert("！！！！请注意：\n您刚才输入的整数不正确，我们已进行了修改。");
		obj.select();
		obj.focus();
		return false;
	}
	obj.value=r;
	}


/********************************************************************/

var blnIsCorrect=true; //检查值有效性标志量，初始值为真（有效）
var strError='';       //当发生错误时显示的错误提示信息
var objItem;           //当发生错误时，将焦点定位到哪一个表单元素

document.oncontextmenu=lkj;
function lkj(){
if (event.srcElement.nodeName=="A" || event.srcElement.parentElement.nodeName=="A")
    event.returnValue=false;
}

//返回检查标志量，如果标志量为否，则显示错误警告，并将光标定位在出错的文本框内
function checkAll(){
    if (!blnIsCorrect){
        alert(strError);
        try{
            objItem.focus();
        }
        catch(e){
        }
        blnIsCorrect=true; //返回否之前重置标志量为真
        return false;
    }
    else
        return true;
}


function formatDate(txtObj){
    isDate(txtObj);
    return checkAll();
}


function getByteLengh(str)
{
var len;
var i;
len = 0;
for (i=0;i<str.length;i++)
{
if (str.charCodeAt(i)>255) len+=2; else len++;
}
return len;
}

