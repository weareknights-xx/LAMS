
//�Ƿ�Ϊ����
function bol_chinese(str)
{
	var pattern = /[^\u4E00-\u9FA5]/;
	if(pattern.test(str)) return false;
	else return true;
}
//����unicode����
function ParamUnicode(param)
{
	for(i=0;i<param.length;i++)
	{
		if(bol_chinese(param.substring(i,i+1))) param=param.substring(0,i)+escape(param.substring(i,i+1))+param.substring(i+1,param.length);
	}
	return param;
}
//�����ַ����ĳ���
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



//��֤¼���ʱ���Ƿ�Ϸ�
//
function checkDate(objName,objLength)
{
  if ( objLength < 1)
  {
    //û����Ҫ��֤������
    return true;
  }
  else if (objLength == 1)
  {
    //���û�����֤����
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
//���ڱȽϴ�С
//
function compareDate(dBegin,dEnd)
{
  if (!isNull(dBegin) && !isNull(dEnd))
  {
    if (formatDate(dBegin) == false) return false;
    if (formatDate(dEnd) == false) return false;
    if (dBegin.value > dEnd.value)
    {
      alert('��ʼ���ڴ�����ֹ����.');
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
//�Ƿ�Ϊ��
//

function checkZero(objName,objLength)
{

  if (checkPublic(objName,objLength,2) == true)
  {
    return true;
  }
  else
  {
    alert('��������� 0 ������.');
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
//Ϊ�˱���ÿһ���ظ��жϿؼ���һ������һ�顣
//
function checkPublic(objName,objLength,functionID)
{
  var temResult = true;
  if ( objLength < 1)
  {
    //û����Ҫ��֤������
    return true;
  }
  else if (objLength == 1)
  {
    //���û�����֤����
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
//����һ����������Ԫ����β�ո�
function trimAll(frmObj){
    for (var i=1;i<frmObj.elements.length-1;i++)    {
        frmObj.elements[i].value
          =frmObj.elements[i].value.replace(/(^\s*)|(\s*$)/g,"");
    }
}
//�ж��Ƿ�Ϊ��
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

//ֻ������������
function isNumber(objThis){
	trimThis(objThis,objThis);
	if (objThis.value.length!=0){
        var strCheck=/^\d+$/;
        if (!strCheck.exec(objThis.value)){
            alert('���ָ�ʽ����ȷ.');
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
//�ж������Ƿ�Ϊ0
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
//����������֤
//�����ǽ�������Number(10,2)��ʽ ���ݳ��Ȳ�����С����λ��
//�Ƿ�������
function isNumeric(strNumber)
{
	return (strNumber.search(/^(-|\+)?\d+(\.\d+)?$/) != -1);
}
//�Ƿ���������
function isInteger(strInteger) {
	return (strInteger.search(/^(-|\+)?\d+$/) != -1);
}
//�ж�����Ļ��������Ƿ�Ϸ�(�޷�������)
function checkUnsignedDecimalInput(obj,dataLength,fractionLength)
{
	obj.value = obj.value.replace(/-/g,"");
	return checkDecimalInput(obj,dataLength,fractionLength);
}

function checkIntInput(obj,min,max)		//�����ǽ�������������Ĭ�Ϸ�Χ�ǷǸ���onblur event
	{
	obj.value=obj.value.replace(/ /g,"");		//ȥ�ո�
	if(obj.value=="") return false;
	var r;
	var s = obj.value ;
	var theMin=-1;
	var theMax=10000000000;
	if (min!=null) theMin=min;
	if (max!=null) theMax=max;
	if (s.length==0) return false;
	r = parseInt(s);;								//ȡ��
	if (r==null||isNaN(r))
	{
		obj.value="";
		alert("����������ע�⣺\n���ղ��������������ȷ�������ѽ����������");
		obj.focus();
		return false;
	}
	if ((r>=theMax)||(r<=theMin))
	{
		obj.value="";
		alert("����������ע�⣺\n���ղ������������������Χ�������ѽ����������");
		obj.focus();
		return false;
	}
	if ( r!=s)
	{
		obj.value=r;
		alert("����������ע�⣺\n���ղ��������������ȷ�������ѽ������޸ġ�");
		obj.select();
		obj.focus();
		return false;
	}
	obj.value=r;
	}


/********************************************************************/

var blnIsCorrect=true; //���ֵ��Ч�Ա�־������ʼֵΪ�棨��Ч��
var strError='';       //����������ʱ��ʾ�Ĵ�����ʾ��Ϣ
var objItem;           //����������ʱ�������㶨λ����һ����Ԫ��

document.oncontextmenu=lkj;
function lkj(){
if (event.srcElement.nodeName=="A" || event.srcElement.parentElement.nodeName=="A")
    event.returnValue=false;
}

//���ؼ���־���������־��Ϊ������ʾ���󾯸棬������궨λ�ڳ�����ı�����
function checkAll(){
    if (!blnIsCorrect){
        alert(strError);
        try{
            objItem.focus();
        }
        catch(e){
        }
        blnIsCorrect=true; //���ط�֮ǰ���ñ�־��Ϊ��
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

