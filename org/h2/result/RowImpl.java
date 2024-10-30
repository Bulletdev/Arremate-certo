/*     */ package org.h2.result;
/*     */ 
/*     */ import org.h2.store.Data;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RowImpl
/*     */   implements Row
/*     */ {
/*     */   private long key;
/*     */   private final Value[] data;
/*     */   private int memory;
/*     */   private int version;
/*     */   private boolean deleted;
/*     */   private int sessionId;
/*     */   
/*     */   public RowImpl(Value[] paramArrayOfValue, int paramInt) {
/*  26 */     this.data = paramArrayOfValue;
/*  27 */     this.memory = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Row getCopy() {
/*  38 */     Value[] arrayOfValue = new Value[this.data.length];
/*  39 */     System.arraycopy(this.data, 0, arrayOfValue, 0, this.data.length);
/*  40 */     RowImpl rowImpl = new RowImpl(arrayOfValue, this.memory);
/*  41 */     rowImpl.key = this.key;
/*  42 */     this.version++;
/*  43 */     rowImpl.sessionId = this.sessionId;
/*  44 */     return rowImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKeyAndVersion(SearchRow paramSearchRow) {
/*  49 */     setKey(paramSearchRow.getKey());
/*  50 */     setVersion(paramSearchRow.getVersion());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVersion() {
/*  55 */     return this.version;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVersion(int paramInt) {
/*  60 */     this.version = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKey() {
/*  65 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(long paramLong) {
/*  70 */     this.key = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(int paramInt) {
/*  75 */     return (paramInt == -1) ? (Value)ValueLong.get(this.key) : this.data[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getByteCount(Data paramData) {
/*  86 */     int i = 0;
/*  87 */     for (Value value : this.data) {
/*  88 */       i += paramData.getValueLen(value);
/*     */     }
/*  90 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValue(int paramInt, Value paramValue) {
/*  95 */     if (paramInt == -1) {
/*  96 */       this.key = paramValue.getLong();
/*     */     } else {
/*  98 */       this.data[paramInt] = paramValue;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 104 */     return (this.data == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 109 */     return this.data.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 114 */     if (this.memory != -1) {
/* 115 */       return this.memory;
/*     */     }
/* 117 */     int i = 40;
/* 118 */     if (this.data != null) {
/* 119 */       int j = this.data.length;
/* 120 */       i += 24 + j * 8;
/* 121 */       for (byte b = 0; b < j; b++) {
/* 122 */         Value value = this.data[b];
/* 123 */         if (value != null) {
/* 124 */           i += value.getMemory();
/*     */         }
/*     */       } 
/*     */     } 
/* 128 */     this.memory = i;
/* 129 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 134 */     StatementBuilder statementBuilder = new StatementBuilder("( /* key:");
/* 135 */     statementBuilder.append(getKey());
/* 136 */     if (this.version != 0) {
/* 137 */       statementBuilder.append(" v:" + this.version);
/*     */     }
/* 139 */     if (isDeleted()) {
/* 140 */       statementBuilder.append(" deleted");
/*     */     }
/* 142 */     statementBuilder.append(" */ ");
/* 143 */     if (this.data != null) {
/* 144 */       for (Value value : this.data) {
/* 145 */         statementBuilder.appendExceptFirst(", ");
/* 146 */         statementBuilder.append((value == null) ? "null" : value.getTraceSQL());
/*     */       } 
/*     */     }
/* 149 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeleted(boolean paramBoolean) {
/* 154 */     this.deleted = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSessionId(int paramInt) {
/* 159 */     this.sessionId = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSessionId() {
/* 164 */     return this.sessionId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() {
/* 172 */     this.sessionId = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeleted() {
/* 177 */     return this.deleted;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value[] getValueList() {
/* 182 */     return this.data;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\RowImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */