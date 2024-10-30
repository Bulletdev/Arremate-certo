/*     */ package org.h2.engine;
/*     */ 
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.table.Table;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UndoLogRecord
/*     */ {
/*     */   public static final short INSERT = 0;
/*     */   public static final short DELETE = 1;
/*     */   private static final int IN_MEMORY = 0;
/*     */   private static final int STORED = 1;
/*     */   private static final int IN_MEMORY_INVALID = 2;
/*     */   private Table table;
/*     */   private Row row;
/*     */   private short operation;
/*     */   private short state;
/*     */   private int filePos;
/*     */   
/*     */   UndoLogRecord(Table paramTable, short paramShort, Row paramRow) {
/*  46 */     this.table = paramTable;
/*  47 */     this.row = paramRow;
/*  48 */     this.operation = paramShort;
/*  49 */     this.state = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isStored() {
/*  58 */     return (this.state == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean canStore() {
/*  69 */     if (this.table.getUniqueIndex() != null) {
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void undo(Session paramSession) {
/*  82 */     Database database = paramSession.getDatabase();
/*  83 */     switch (this.operation) {
/*     */       case 0:
/*  85 */         if (this.state == 2) {
/*  86 */           this.state = 0;
/*     */         }
/*  88 */         if (database.getLockMode() == 0 && 
/*  89 */           this.row.isDeleted()) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*     */         try {
/*  95 */           this.row.setDeleted(false);
/*  96 */           this.table.removeRow(paramSession, this.row);
/*  97 */           this.table.fireAfterRow(paramSession, this.row, null, true);
/*  98 */         } catch (DbException dbException) {
/*  99 */           if (paramSession.getDatabase().getLockMode() != 0 || dbException.getErrorCode() != 90112)
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 104 */             throw dbException;
/*     */           }
/*     */         } 
/*     */         return;
/*     */       case 1:
/*     */         try {
/* 110 */           this.table.addRow(paramSession, this.row);
/* 111 */           this.table.fireAfterRow(paramSession, null, this.row, true);
/*     */ 
/*     */           
/* 114 */           this.row.commit();
/* 115 */         } catch (DbException dbException) {
/* 116 */           if (paramSession.getDatabase().getLockMode() != 0 || dbException.getSQLException().getErrorCode() != 23505)
/*     */           {
/*     */ 
/*     */ 
/*     */             
/* 121 */             throw dbException;
/*     */           }
/*     */         } 
/*     */         return;
/*     */     } 
/* 126 */     DbException.throwInternalError("op=" + this.operation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void append(Data paramData, UndoLog paramUndoLog) {
/* 137 */     int i = paramData.length();
/* 138 */     paramData.writeInt(0);
/* 139 */     paramData.writeInt(this.operation);
/* 140 */     paramData.writeByte(this.row.isDeleted() ? 1 : 0);
/* 141 */     paramData.writeInt(paramUndoLog.getTableId(this.table));
/* 142 */     paramData.writeLong(this.row.getKey());
/* 143 */     paramData.writeInt(this.row.getSessionId());
/* 144 */     int j = this.row.getColumnCount();
/* 145 */     paramData.writeInt(j);
/* 146 */     for (byte b = 0; b < j; b++) {
/* 147 */       Value value = this.row.getValue(b);
/* 148 */       paramData.checkCapacity(paramData.getValueLen(value));
/* 149 */       paramData.writeValue(value);
/*     */     } 
/* 151 */     paramData.fillAligned();
/* 152 */     paramData.setInt(i, (paramData.length() - i) / 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void save(Data paramData, FileStore paramFileStore, UndoLog paramUndoLog) {
/* 163 */     paramData.reset();
/* 164 */     append(paramData, paramUndoLog);
/* 165 */     this.filePos = (int)(paramFileStore.getFilePointer() / 16L);
/* 166 */     paramFileStore.write(paramData.getBytes(), 0, paramData.length());
/* 167 */     this.row = null;
/* 168 */     this.state = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static UndoLogRecord loadFromBuffer(Data paramData, UndoLog paramUndoLog) {
/* 179 */     UndoLogRecord undoLogRecord = new UndoLogRecord(null, (short)0, null);
/* 180 */     int i = paramData.length();
/* 181 */     int j = paramData.readInt() * 16;
/* 182 */     undoLogRecord.load(paramData, paramUndoLog);
/* 183 */     paramData.setPos(i + j);
/* 184 */     return undoLogRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void load(Data paramData, FileStore paramFileStore, UndoLog paramUndoLog) {
/* 195 */     byte b = 16;
/* 196 */     paramUndoLog.seek(this.filePos);
/* 197 */     paramData.reset();
/* 198 */     paramFileStore.readFully(paramData.getBytes(), 0, b);
/* 199 */     int i = paramData.readInt() * 16;
/* 200 */     paramData.checkCapacity(i);
/* 201 */     if (i - b > 0) {
/* 202 */       paramFileStore.readFully(paramData.getBytes(), b, i - b);
/*     */     }
/* 204 */     short s = this.operation;
/* 205 */     load(paramData, paramUndoLog);
/* 206 */     if (SysProperties.CHECK && 
/* 207 */       this.operation != s) {
/* 208 */       DbException.throwInternalError("operation=" + this.operation + " op=" + s);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void load(Data paramData, UndoLog paramUndoLog) {
/* 214 */     this.operation = (short)paramData.readInt();
/* 215 */     boolean bool = (paramData.readByte() == 1) ? true : false;
/* 216 */     this.table = paramUndoLog.getTable(paramData.readInt());
/* 217 */     long l = paramData.readLong();
/* 218 */     int i = paramData.readInt();
/* 219 */     int j = paramData.readInt();
/* 220 */     Value[] arrayOfValue = new Value[j];
/* 221 */     for (byte b = 0; b < j; b++) {
/* 222 */       arrayOfValue[b] = paramData.readValue();
/*     */     }
/* 224 */     this.row = getTable().getDatabase().createRow(arrayOfValue, -1);
/* 225 */     this.row.setKey(l);
/* 226 */     this.row.setDeleted(bool);
/* 227 */     this.row.setSessionId(i);
/* 228 */     this.state = 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getTable() {
/* 237 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFilePos() {
/* 246 */     return this.filePos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void commit() {
/* 254 */     this.table.commit(this.operation, this.row);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Row getRow() {
/* 263 */     return this.row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void invalidatePos() {
/* 272 */     if (this.state == 0)
/* 273 */       this.state = 2; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\UndoLogRecord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */