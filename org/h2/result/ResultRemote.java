/*     */ package org.h2.result;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.SessionRemote;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Transfer;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResultRemote
/*     */   implements ResultInterface
/*     */ {
/*     */   private int fetchSize;
/*     */   private SessionRemote session;
/*     */   private Transfer transfer;
/*     */   private int id;
/*     */   private final ResultColumn[] columns;
/*     */   private Value[] currentRow;
/*     */   private final int rowCount;
/*     */   private int rowId;
/*     */   private int rowOffset;
/*     */   private ArrayList<Value[]> result;
/*     */   private final Trace trace;
/*     */   
/*     */   public ResultRemote(SessionRemote paramSessionRemote, Transfer paramTransfer, int paramInt1, int paramInt2, int paramInt3) throws IOException {
/*  38 */     this.session = paramSessionRemote;
/*  39 */     this.trace = paramSessionRemote.getTrace();
/*  40 */     this.transfer = paramTransfer;
/*  41 */     this.id = paramInt1;
/*  42 */     this.columns = new ResultColumn[paramInt2];
/*  43 */     this.rowCount = paramTransfer.readInt();
/*  44 */     for (byte b = 0; b < paramInt2; b++) {
/*  45 */       this.columns[b] = new ResultColumn(paramTransfer);
/*     */     }
/*  47 */     this.rowId = -1;
/*  48 */     this.result = New.arrayList();
/*  49 */     this.fetchSize = paramInt3;
/*  50 */     fetchRows(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAlias(int paramInt) {
/*  55 */     return (this.columns[paramInt]).alias;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSchemaName(int paramInt) {
/*  60 */     return (this.columns[paramInt]).schemaName;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableName(int paramInt) {
/*  65 */     return (this.columns[paramInt]).tableName;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColumnName(int paramInt) {
/*  70 */     return (this.columns[paramInt]).columnName;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnType(int paramInt) {
/*  75 */     return (this.columns[paramInt]).columnType;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getColumnPrecision(int paramInt) {
/*  80 */     return (this.columns[paramInt]).precision;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnScale(int paramInt) {
/*  85 */     return (this.columns[paramInt]).scale;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize(int paramInt) {
/*  90 */     return (this.columns[paramInt]).displaySize;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAutoIncrement(int paramInt) {
/*  95 */     return (this.columns[paramInt]).autoIncrement;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNullable(int paramInt) {
/* 100 */     return (this.columns[paramInt]).nullable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 105 */     this.rowId = -1;
/* 106 */     this.currentRow = null;
/* 107 */     if (this.session == null) {
/*     */       return;
/*     */     }
/* 110 */     synchronized (this.session) {
/* 111 */       this.session.checkClosed();
/*     */       try {
/* 113 */         this.session.traceOperation("RESULT_RESET", this.id);
/* 114 */         this.transfer.writeInt(6).writeInt(this.id).flush();
/* 115 */       } catch (IOException iOException) {
/* 116 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Value[] currentRow() {
/* 123 */     return this.currentRow;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/* 128 */     if (this.rowId < this.rowCount) {
/* 129 */       this.rowId++;
/* 130 */       remapIfOld();
/* 131 */       if (this.rowId < this.rowCount) {
/* 132 */         if (this.rowId - this.rowOffset >= this.result.size()) {
/* 133 */           fetchRows(true);
/*     */         }
/* 135 */         this.currentRow = this.result.get(this.rowId - this.rowOffset);
/* 136 */         return true;
/*     */       } 
/* 138 */       this.currentRow = null;
/*     */     } 
/* 140 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowId() {
/* 145 */     return this.rowId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVisibleColumnCount() {
/* 150 */     return this.columns.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowCount() {
/* 155 */     return this.rowCount;
/*     */   }
/*     */   
/*     */   private void sendClose() {
/* 159 */     if (this.session == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 164 */       synchronized (this.session) {
/* 165 */         this.session.traceOperation("RESULT_CLOSE", this.id);
/* 166 */         this.transfer.writeInt(7).writeInt(this.id);
/*     */       } 
/* 168 */     } catch (IOException iOException) {
/* 169 */       this.trace.error(iOException, "close");
/*     */     } finally {
/* 171 */       this.transfer = null;
/* 172 */       this.session = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 178 */     this.result = null;
/* 179 */     sendClose();
/*     */   }
/*     */   
/*     */   private void remapIfOld() {
/* 183 */     if (this.session == null) {
/*     */       return;
/*     */     }
/*     */     try {
/* 187 */       if (this.id <= this.session.getCurrentId() - SysProperties.SERVER_CACHED_OBJECTS / 2)
/*     */       {
/* 189 */         int i = this.session.getNextId();
/* 190 */         this.session.traceOperation("CHANGE_ID", this.id);
/* 191 */         this.transfer.writeInt(9).writeInt(this.id).writeInt(i);
/* 192 */         this.id = i;
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 197 */     catch (IOException iOException) {
/* 198 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void fetchRows(boolean paramBoolean) {
/* 203 */     synchronized (this.session) {
/* 204 */       this.session.checkClosed();
/*     */       try {
/* 206 */         this.rowOffset += this.result.size();
/* 207 */         this.result.clear();
/* 208 */         int i = Math.min(this.fetchSize, this.rowCount - this.rowOffset);
/* 209 */         if (paramBoolean) {
/* 210 */           this.session.traceOperation("RESULT_FETCH_ROWS", this.id);
/* 211 */           this.transfer.writeInt(5).writeInt(this.id).writeInt(i);
/*     */           
/* 213 */           this.session.done(this.transfer);
/*     */         } 
/* 215 */         for (byte b = 0; b < i; b++) {
/* 216 */           boolean bool = this.transfer.readBoolean();
/* 217 */           if (!bool) {
/*     */             break;
/*     */           }
/* 220 */           int j = this.columns.length;
/* 221 */           Value[] arrayOfValue = new Value[j];
/* 222 */           for (byte b1 = 0; b1 < j; b1++) {
/* 223 */             Value value = this.transfer.readValue();
/* 224 */             arrayOfValue[b1] = value;
/*     */           } 
/* 226 */           this.result.add(arrayOfValue);
/*     */         } 
/* 228 */         if (this.rowOffset + this.result.size() >= this.rowCount) {
/* 229 */           sendClose();
/*     */         }
/* 231 */       } catch (IOException iOException) {
/* 232 */         throw DbException.convertIOException(iOException, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 239 */     return "columns: " + this.columns.length + " rows: " + this.rowCount + " pos: " + this.rowId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFetchSize() {
/* 244 */     return this.fetchSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFetchSize(int paramInt) {
/* 249 */     this.fetchSize = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needToClose() {
/* 254 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultRemote.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */