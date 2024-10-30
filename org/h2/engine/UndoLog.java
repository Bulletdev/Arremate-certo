/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UndoLog
/*     */ {
/*     */   private final Database database;
/*  22 */   private final ArrayList<Long> storedEntriesPos = New.arrayList();
/*  23 */   private final ArrayList<UndoLogRecord> records = New.arrayList();
/*     */   
/*     */   private FileStore file;
/*     */   
/*     */   private Data rowBuff;
/*     */   
/*     */   private int memoryUndo;
/*     */   
/*     */   private int storedEntries;
/*     */   
/*     */   private HashMap<Integer, Table> tables;
/*     */   private final boolean largeTransactions;
/*     */   
/*     */   UndoLog(Session paramSession) {
/*  37 */     this.database = paramSession.getDatabase();
/*  38 */     this.largeTransactions = (this.database.getSettings()).largeTransactions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int size() {
/*  47 */     if (this.largeTransactions) {
/*  48 */       return this.storedEntries + this.records.size();
/*     */     }
/*  50 */     if (SysProperties.CHECK && this.memoryUndo > this.records.size()) {
/*  51 */       DbException.throwInternalError();
/*     */     }
/*  53 */     return this.records.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void clear() {
/*  61 */     this.records.clear();
/*  62 */     this.storedEntries = 0;
/*  63 */     this.storedEntriesPos.clear();
/*  64 */     this.memoryUndo = 0;
/*  65 */     if (this.file != null) {
/*  66 */       this.file.closeAndDeleteSilently();
/*  67 */       this.file = null;
/*  68 */       this.rowBuff = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UndoLogRecord getLast() {
/*  78 */     int i = this.records.size() - 1;
/*  79 */     if (this.largeTransactions) {
/*  80 */       if (i < 0 && this.storedEntries > 0) {
/*  81 */         int j = this.storedEntriesPos.size() - 1;
/*  82 */         long l1 = ((Long)this.storedEntriesPos.get(j)).longValue();
/*  83 */         this.storedEntriesPos.remove(j);
/*  84 */         long l2 = this.file.length();
/*  85 */         int k = (int)(l2 - l1);
/*  86 */         Data data = Data.create(this.database, k);
/*  87 */         this.file.seek(l1);
/*  88 */         this.file.readFully(data.getBytes(), 0, k);
/*  89 */         while (data.length() < k) {
/*  90 */           UndoLogRecord undoLogRecord1 = UndoLogRecord.loadFromBuffer(data, this);
/*  91 */           this.records.add(undoLogRecord1);
/*  92 */           this.memoryUndo++;
/*     */         } 
/*  94 */         this.storedEntries -= this.records.size();
/*  95 */         this.file.setLength(l1);
/*  96 */         this.file.seek(l1);
/*     */       } 
/*  98 */       i = this.records.size() - 1;
/*     */     } 
/* 100 */     UndoLogRecord undoLogRecord = this.records.get(i);
/* 101 */     if (undoLogRecord.isStored()) {
/* 102 */       int j = Math.max(0, i - this.database.getMaxMemoryUndo() / 2);
/* 103 */       UndoLogRecord undoLogRecord1 = null; int k;
/* 104 */       for (k = j; k <= i; k++) {
/* 105 */         UndoLogRecord undoLogRecord2 = this.records.get(k);
/* 106 */         if (undoLogRecord2.isStored()) {
/* 107 */           undoLogRecord2.load(this.rowBuff, this.file, this);
/* 108 */           this.memoryUndo++;
/* 109 */           if (undoLogRecord1 == null) {
/* 110 */             undoLogRecord1 = undoLogRecord2;
/*     */           }
/*     */         } 
/*     */       } 
/* 114 */       for (k = 0; k < i; k++) {
/* 115 */         UndoLogRecord undoLogRecord2 = this.records.get(k);
/* 116 */         undoLogRecord2.invalidatePos();
/*     */       } 
/* 118 */       seek(undoLogRecord1.getFilePos());
/*     */     } 
/* 120 */     return undoLogRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void seek(long paramLong) {
/* 129 */     this.file.seek(paramLong * 16L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeLast(boolean paramBoolean) {
/* 138 */     int i = this.records.size() - 1;
/* 139 */     UndoLogRecord undoLogRecord = this.records.remove(i);
/* 140 */     if (!undoLogRecord.isStored()) {
/* 141 */       this.memoryUndo--;
/*     */     }
/* 143 */     if (paramBoolean && i > 1024 && (i & 0x3FF) == 0) {
/* 144 */       this.records.trimToSize();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(UndoLogRecord paramUndoLogRecord) {
/* 154 */     this.records.add(paramUndoLogRecord);
/* 155 */     if (this.largeTransactions) {
/* 156 */       this.memoryUndo++;
/* 157 */       if (this.memoryUndo > this.database.getMaxMemoryUndo() && this.database.isPersistent() && !this.database.isMultiVersion()) {
/*     */ 
/*     */         
/* 160 */         if (this.file == null) {
/* 161 */           String str = this.database.createTempFile();
/* 162 */           this.file = this.database.openFile(str, "rw", false);
/* 163 */           this.file.setCheckedWriting(false);
/* 164 */           this.file.setLength(48L);
/*     */         } 
/* 166 */         Data data = Data.create(this.database, 4096);
/* 167 */         for (byte b = 0; b < this.records.size(); b++) {
/* 168 */           UndoLogRecord undoLogRecord = this.records.get(b);
/* 169 */           data.checkCapacity(4096);
/* 170 */           undoLogRecord.append(data, this);
/* 171 */           if (b == this.records.size() - 1 || data.length() > 1048576) {
/* 172 */             this.storedEntriesPos.add(Long.valueOf(this.file.getFilePointer()));
/* 173 */             this.file.write(data.getBytes(), 0, data.length());
/* 174 */             data.reset();
/*     */           } 
/*     */         } 
/* 177 */         this.storedEntries += this.records.size();
/* 178 */         this.memoryUndo = 0;
/* 179 */         this.records.clear();
/* 180 */         this.file.autoDelete();
/*     */         return;
/*     */       } 
/*     */     } else {
/* 184 */       if (!paramUndoLogRecord.isStored()) {
/* 185 */         this.memoryUndo++;
/*     */       }
/* 187 */       if (this.memoryUndo > this.database.getMaxMemoryUndo() && this.database.isPersistent() && !this.database.isMultiVersion()) {
/*     */ 
/*     */         
/* 190 */         if (this.file == null) {
/* 191 */           String str = this.database.createTempFile();
/* 192 */           this.file = this.database.openFile(str, "rw", false);
/* 193 */           this.file.setCheckedWriting(false);
/* 194 */           this.file.seek(48L);
/* 195 */           this.rowBuff = Data.create(this.database, 4096);
/* 196 */           Data data = this.rowBuff;
/* 197 */           for (byte b = 0; b < this.records.size(); b++) {
/* 198 */             UndoLogRecord undoLogRecord = this.records.get(b);
/* 199 */             saveIfPossible(undoLogRecord, data);
/*     */           } 
/*     */         } else {
/* 202 */           saveIfPossible(paramUndoLogRecord, this.rowBuff);
/*     */         } 
/* 204 */         this.file.autoDelete();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void saveIfPossible(UndoLogRecord paramUndoLogRecord, Data paramData) {
/* 210 */     if (!paramUndoLogRecord.isStored() && paramUndoLogRecord.canStore()) {
/* 211 */       paramUndoLogRecord.save(paramData, this.file, this);
/* 212 */       this.memoryUndo--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getTableId(Table paramTable) {
/* 224 */     int i = paramTable.getId();
/* 225 */     if (this.tables == null) {
/* 226 */       this.tables = New.hashMap();
/*     */     }
/*     */ 
/*     */     
/* 230 */     this.tables.put(Integer.valueOf(i), paramTable);
/* 231 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Table getTable(int paramInt) {
/* 242 */     return this.tables.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\UndoLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */