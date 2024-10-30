/*    */ package org.h2.result;
/*    */ 
/*    */ import org.h2.store.Data;
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Row
/*    */   extends SearchRow
/*    */ {
/*    */   public static final int MEMORY_CALCULATE = -1;
/* 17 */   public static final Row[] EMPTY_ARRAY = new Row[0];
/*    */   
/*    */   Row getCopy();
/*    */   
/*    */   void setVersion(int paramInt);
/*    */   
/*    */   int getByteCount(Data paramData);
/*    */   
/*    */   boolean isEmpty();
/*    */   
/*    */   void setDeleted(boolean paramBoolean);
/*    */   
/*    */   void setSessionId(int paramInt);
/*    */   
/*    */   int getSessionId();
/*    */   
/*    */   void commit();
/*    */   
/*    */   boolean isDeleted();
/*    */   
/*    */   Value[] getValueList();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\Row.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */