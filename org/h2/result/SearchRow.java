/*    */ package org.h2.result;
/*    */ 
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface SearchRow
/*    */ {
/* 19 */   public static final SearchRow[] EMPTY_ARRAY = new SearchRow[0];
/*    */   
/*    */   int getColumnCount();
/*    */   
/*    */   Value getValue(int paramInt);
/*    */   
/*    */   void setValue(int paramInt, Value paramValue);
/*    */   
/*    */   void setKeyAndVersion(SearchRow paramSearchRow);
/*    */   
/*    */   int getVersion();
/*    */   
/*    */   void setKey(long paramLong);
/*    */   
/*    */   long getKey();
/*    */   
/*    */   int getMemory();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\SearchRow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */