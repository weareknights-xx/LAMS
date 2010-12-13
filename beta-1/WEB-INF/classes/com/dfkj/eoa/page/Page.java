
package com.dfkj.eoa.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.Serializable;  

/** 
  * ������ʾ�������ҳ��
  */  
public class Page implements Serializable {  

  /**
   * �հ�ҳ��
   */
  public static final Page EMPTY_PAGE =  
         new Page(Collections.EMPTY_LIST, 0, false);  
  /**
   * ������б�
   */
  List objects;  
  /**
   * ��ʼ��¼�ţ���0��ʼ
   */
  public int start;  
  /**
   * ������¼��
   */
  public int end;  
  /**
   * ��ʾ��ҳ�濪ʼ��¼�ţ���1��ʼ
   */
  public int viewStart;  
  /**
   * ��ʾ��ҳ�������¼��
   */
  public int viewEnd;  
  /**
   * �Ƿ�����һҳ�Ŀ���
   */
  public boolean hasPrevious;  
  /**
   * ��һҳ��ҳ��
   */
  public int previousPageNumber;  
  /**
   * �Ƿ�����һҳ�Ŀ���
   */
  public boolean hasNext;  
  /**
   * ��һҳ��ҳ��
   */
  public int nextPageNumber;  
  /**
   * һ���ж����м�¼
   */
  public int total;    
  /**
   * һ���ж���ҳ
   */
  public int totalPage;    
  /**
   * ��ǰ�ǵڼ�ҳ
   */
  public int currentPageNumber;    
  /**
   * ÿҳ�ж�����
   */
  public int pageSize;

  /**
   * ������,����ҳ��
   * @param: l �����
   * @param: s ��ʼ��¼�ţ���0��ʼ
   * @param: hasNext �Ƿ�����һҳ�Ŀ���
   */
  public Page(List l, int s, boolean hasNext) {  
    objects = new ArrayList(l);  
    this.currentPageNumber = s/PageConfig.PAGE_SIZE + 1;
      this.pageSize = PageConfig.PAGE_SIZE;
      this.total = 0;
      if( total== 0) 
        this.currentPageNumber = 0;
      else
        autoCalculate();
  }  

  /**
   * ������,����ҳ��
   * @param: l �����
   * @param: s ��ʼ��¼�ţ���0��ʼ
   * @param: hasNext �Ƿ�����һҳ�Ŀ���
   * @param: total һ���ж����м�¼
   */
  public Page(List l, int s, boolean hasNext, int total) {  
    objects = new ArrayList(l);  
    this.currentPageNumber = s/PageConfig.PAGE_SIZE + 1;
      this.pageSize = PageConfig.PAGE_SIZE;
      this.total = total;
      if( total== 0) 
        this.currentPageNumber = 0;
      else
        autoCalculate();
  }  

  /**
   * ������,����ҳ��
   * @param: l �����
   * @param: s ��ʼ��¼�ţ���0��ʼ
   * @param: size ÿҳ�ж�����
   * @param: hasNext �Ƿ�����һҳ�Ŀ���
   * @param: total һ���ж����м�¼
   */
  public Page(List l, int s, int size, boolean hasNext, int total) {  
    objects = new ArrayList(l);  
    this.currentPageNumber = s/size + 1;
      this.pageSize = size;
      this.total = total;
      if( total== 0) 
        this.currentPageNumber = 0;
      else
        autoCalculate();
  }  

  /**
   * ������,����ҳ��
   * @param: l �����
   * @param: num ��ǰ�ǵڼ�ҳ
   * @param: size ÿҳ�ж�����
   * @param: total һ���ж����м�¼
   */
  public Page(List l, int num, int size, int total) {
    this.objects = new ArrayList(l);
    this.currentPageNumber = num;
      this.pageSize = size;
      this.total = total;
      if( total== 0) 
        this.currentPageNumber = 0;
      else
        autoCalculate();
  }

  /**
   * ������,����һ��ҳ��,����ҳ
   * @param: l �����
   */
  public Page(List l) {
    this.objects = new ArrayList(l);
    this.currentPageNumber = 1;
      this.pageSize = l.size();
      this.total = l.size();
      if( total== 0) 
        this.currentPageNumber = 0;
      else
        autoCalculate();
  }

  /**
   * �Զ����㣬���ݵ�ǰҳ��ҳ��С��������������������Ե�ֵ
   */
  private void autoCalculate(){
    start = (currentPageNumber - 1) * pageSize;
    end = start + pageSize - 1;
    if ( end > total ) {
        end = total;
    }
    viewStart = start + 1;
    viewEnd = end + 1;
    totalPage = (total+pageSize-1)/pageSize;
    if ( currentPageNumber == 1) {
        hasPrevious = false;
        previousPageNumber = 1;
    }else{
        hasPrevious = true;
        previousPageNumber = currentPageNumber - 1;
    }
    if ( currentPageNumber == totalPage){ 
        hasNext = false;
        nextPageNumber = totalPage;
    }else{
        hasNext = true;
        nextPageNumber = currentPageNumber + 1;
    }
  }
  /**
   * ��ý����
   * @return: List �����
   */
  public List getList() {  
    return objects;   
  }  
  /**
   * �����ʾ��ҳ��Ŀ�ʼ��¼�ţ���1��ʼ
   * @return: int ��ʾ��ҳ��Ŀ�ʼ��¼��
   */
  public int getViewStart(){ 
    return viewStart; 
  } 
  /**
   * �����ʾ��ҳ��Ľ�����¼��
   * @return: int ��ʾ��ҳ��Ľ�����¼��
   */
  public int getViewEnd(){ 
    return viewEnd; 
  } 
  /**
   * �Ƿ�����һҳ
   * @return: boolean �Ƿ�����һҳ�Ŀ���
   */
  public boolean hasNextPage() {  
    return hasNext;  
  }  
  /**
   * �Ƿ�����һҳ
   * @return: boolean �Ƿ�����һҳ�Ŀ���
   */
  public boolean hasPreviousPage() {  
    return start > 0;  
  }  
  /**
   * �����һҳ��ҳ��
   * @return: int ��һҳ��ҳ��
   */
  public int getPreviousPageNumber(){ 
    return previousPageNumber; 
  } 
  /**
   * �����һҳ��ҳ��
   * @return: int ��һҳ��ҳ��
   */
  public int getNextPageNumber(){ 
    return nextPageNumber; 
  } 
  /**
   * ��ý�����м�¼������
   * @return: int һ���ж����м�¼
   */
  public int getTotal(){ 
    return total; 
  } 
  /**
   * �����ҳ��
   * @return: int һ���ж���ҳ
   */
  public int getTotalPage(){ 
    return totalPage; 
  } 
  /**
   * ��õ�ǰҳ��
   * @return: int ��ǰҳ��
   */
  public int getCurrentPageNumber(){ 
    return currentPageNumber; 
  } 
  /**
   * ���ÿҳ�����м�¼
   * @return: int ҳ��С
   */
  public int getPageSize(){ 
    return pageSize; 
  } 
  /**
   * �����һҳ�ڽ�����п�ʼ�ļ�¼�ţ���0��ʼ
   * @return: int ��һҳ�ڽ�����п�ʼ�ļ�¼��
   */
  public int getStartOfNextPage() {   
    return start + objects.size();   
    }  
  /**
   * �����һҳ�ڽ�����п�ʼ�ļ�¼�ţ���0��ʼ
   * @return: int ��һҳ�ڽ�����п�ʼ�ļ�¼��
   */
  public int getStartOfPreviousPage() {  
    return Math.max(start-objects.size(), 0);  
  }  
  /**
   * ��õ�ǰҳ�����ļ�¼����
   * @return: int ��ǰҳ�����ļ�¼����
   */
  public int getSize() {  
   return objects.size();   
  }
  /**
   * �жϵ�ǰҳ���Ƿ��ǿհ�ҳ��,�����ǰҳ���ǿհ�ҳ��,
   * ����true,����,����false
   * @return: boolean ��ǰҳ���Ƿ��ǿհ�ҳ��
   */
  public boolean isEmpty() {  
   return objects.isEmpty();   
  }

}
