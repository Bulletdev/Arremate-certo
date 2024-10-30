/*    */ package org.h2.result;
/*    */ 
/*    */ import org.h2.util.StatementBuilder;
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
/*    */ public class SimpleRow
/*    */   implements SearchRow
/*    */ {
/*    */   private long key;
/*    */   private int version;
/*    */   private final Value[] data;
/*    */   private int memory;
/*    */   
/*    */   public SimpleRow(Value[] paramArrayOfValue) {
/* 23 */     this.data = paramArrayOfValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getColumnCount() {
/* 28 */     return this.data.length;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getKey() {
/* 33 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setKey(long paramLong) {
/* 38 */     this.key = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setKeyAndVersion(SearchRow paramSearchRow) {
/* 43 */     this.key = paramSearchRow.getKey();
/* 44 */     this.version = paramSearchRow.getVersion();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getVersion() {
/* 49 */     return this.version;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(int paramInt, Value paramValue) {
/* 54 */     this.data[paramInt] = paramValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(int paramInt) {
/* 59 */     return this.data[paramInt];
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     StatementBuilder statementBuilder = new StatementBuilder("( /* key:");
/* 65 */     statementBuilder.append(getKey());
/* 66 */     if (this.version != 0) {
/* 67 */       statementBuilder.append(" v:" + this.version);
/*    */     }
/* 69 */     statementBuilder.append(" */ ");
/* 70 */     for (Value value : this.data) {
/* 71 */       statementBuilder.appendExceptFirst(", ");
/* 72 */       statementBuilder.append((value == null) ? "null" : value.getTraceSQL());
/*    */     } 
/* 74 */     return statementBuilder.append(')').toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMemory() {
/* 79 */     if (this.memory == 0) {
/* 80 */       int i = this.data.length;
/* 81 */       this.memory = 24 + i * 8;
/* 82 */       for (byte b = 0; b < i; b++) {
/* 83 */         Value value = this.data[b];
/* 84 */         if (value != null) {
/* 85 */           this.memory += value.getMemory();
/*    */         }
/*    */       } 
/*    */     } 
/* 89 */     return this.memory;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\SimpleRow.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */