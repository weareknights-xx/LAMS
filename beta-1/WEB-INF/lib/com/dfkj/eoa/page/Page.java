
package com.dfkj.eoa.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.Serializable;  

/** 
  * 描述显示结果集的页面
  */  
public class Page implements Serializable {  

  /**
   * 空白页面
   */
  public static final Page EMPTY_PAGE =  
         new Page(Collections.EMPTY_LIST, 0, false);  
  /**
   * 结果集列表
   */
  List objects;  
  /**
   * 开始记录号，从0开始
   */
  public int start;  
  /**
   * 结束记录号
   */
  public int end;  
  /**
   * 显示在页面开始记录号，从1开始
   */
  public int viewStart;  
  /**
   * 显示在页面结束记录号
   */
  public int viewEnd;  
  /**
   * 是否有上一页的开关
   */
  public boolean hasPrevious;  
  /**
   * 上一页的页码
   */
  public int previousPageNumber;  
  /**
   * 是否有下一页的开关
   */
  public boolean hasNext;  
  /**
   * 下一页的页码
   */
  public int nextPageNumber;  
  /**
   * 一共有多少行记录
   */
  public int total;    
  /**
   * 一共有多少页
   */
  public int totalPage;    
  /**
   * 当前是第几页
   */
  public int currentPageNumber;    
  /**
   * 每页有多少行
   */
  public int pageSize;

  /**
   * 构造器,创建页面
   * @param: l 结果集
   * @param: s 开始记录号，从0开始
   * @param: hasNext 是否有下一页的开关
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
   * 构造器,创建页面
   * @param: l 结果集
   * @param: s 开始记录号，从0开始
   * @param: hasNext 是否有下一页的开关
   * @param: total 一共有多少行记录
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
   * 构造器,创建页面
   * @param: l 结果集
   * @param: s 开始记录号，从0开始
   * @param: size 每页有多少行
   * @param: hasNext 是否有下一页的开关
   * @param: total 一共有多少行记录
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
   * 构造器,创建页面
   * @param: l 结果集
   * @param: num 当前是第几页
   * @param: size 每页有多少行
   * @param: total 一共有多少行记录
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
   * 构造器,创建一个页面,不分页
   * @param: l 结果集
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
   * 自动计算，根据当前页、页大小、总行数计算出其它属性的值
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
   * 获得结果集
   * @return: List 结果集
   */
  public List getList() {  
    return objects;   
  }  
  /**
   * 获得显示在页面的开始记录号，从1开始
   * @return: int 显示在页面的开始记录号
   */
  public int getViewStart(){ 
    return viewStart; 
  } 
  /**
   * 获得显示在页面的结束记录号
   * @return: int 显示在页面的结束记录号
   */
  public int getViewEnd(){ 
    return viewEnd; 
  } 
  /**
   * 是否有下一页
   * @return: boolean 是否有下一页的开关
   */
  public boolean hasNextPage() {  
    return hasNext;  
  }  
  /**
   * 是否有上一页
   * @return: boolean 是否有上一页的开关
   */
  public boolean hasPreviousPage() {  
    return start > 0;  
  }  
  /**
   * 获得上一页的页码
   * @return: int 上一页的页码
   */
  public int getPreviousPageNumber(){ 
    return previousPageNumber; 
  } 
  /**
   * 获得下一页的页码
   * @return: int 下一页的页码
   */
  public int getNextPageNumber(){ 
    return nextPageNumber; 
  } 
  /**
   * 获得结果集中记录总行数
   * @return: int 一共有多少行记录
   */
  public int getTotal(){ 
    return total; 
  } 
  /**
   * 获得总页数
   * @return: int 一共有多少页
   */
  public int getTotalPage(){ 
    return totalPage; 
  } 
  /**
   * 获得当前页码
   * @return: int 当前页码
   */
  public int getCurrentPageNumber(){ 
    return currentPageNumber; 
  } 
  /**
   * 获得每页多少行记录
   * @return: int 页大小
   */
  public int getPageSize(){ 
    return pageSize; 
  } 
  /**
   * 获得下一页在结果集中开始的记录号，从0开始
   * @return: int 下一页在结果集中开始的记录号
   */
  public int getStartOfNextPage() {   
    return start + objects.size();   
    }  
  /**
   * 获得上一页在结果集中开始的记录号，从0开始
   * @return: int 下一页在结果集中开始的记录号
   */
  public int getStartOfPreviousPage() {  
    return Math.max(start-objects.size(), 0);  
  }  
  /**
   * 获得当前页包括的记录行数
   * @return: int 当前页包括的记录行数
   */
  public int getSize() {  
   return objects.size();   
  }
  /**
   * 判断当前页面是否是空白页面,如果当前页面是空白页面,
   * 返回true,否则,返回false
   * @return: boolean 当前页面是否是空白页面
   */
  public boolean isEmpty() {  
   return objects.isEmpty();   
  }

}
