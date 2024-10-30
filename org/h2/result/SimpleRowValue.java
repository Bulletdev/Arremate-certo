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
/*    */ public class SimpleRowValue
/*    */   implements SearchRow
/*    */ {
/*    */   private long key;
/*    */   private int version;
/*    */   private int index;
/*    */   private final int virtualColumnCount;
/*    */   private Value data;
/*    */   
/*    */   public SimpleRowValue(int paramInt) {
/* 23 */     this.virtualColumnCount = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setKeyAndVersion(SearchRow paramSearchRow) {
/* 28 */     this.key = paramSearchRow.getKey();
/* 29 */     this.version = paramSearchRow.getVersion();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getVersion() {
/* 34 */     return this.version;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getColumnCount() {
/* 39 */     return this.virtualColumnCount;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getKey() {
/* 44 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setKey(long paramLong) {
/* 49 */     this.key = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(int paramInt) {
/* 54 */     return (paramInt == this.index) ? this.data : null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(int paramInt, Value paramValue) {
/* 59 */     this.index = paramInt;
/* 60 */     this.data = paramValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 65 */     return "( /* " + this.key + " */ " + ((this.data == null) ? "null" : this.data.getTraceSQL()) + " )";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMemory() {
/* 71 */     return 24 + ((this.data == null) ? 0 : this.data.getMemory());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\SimpleRowValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */