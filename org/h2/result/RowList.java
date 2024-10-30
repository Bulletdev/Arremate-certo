/*     */ package org.h2.result;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.util.New;
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
/*     */ public class RowList
/*     */ {
/*     */   private final Session session;
/*  24 */   private final ArrayList<Row> list = New.arrayList();
/*     */   
/*     */   private int size;
/*     */   
/*     */   private int index;
/*     */   
/*     */   private int listIndex;
/*     */   
/*     */   private FileStore file;
/*     */   private Data rowBuff;
/*     */   private ArrayList<Value> lobs;
/*     */   private final int maxMemory;
/*     */   private int memory;
/*     */   private boolean written;
/*     */   private boolean readUncached;
/*     */   
/*     */   public RowList(Session paramSession) {
/*  41 */     this.session = paramSession;
/*  42 */     if (paramSession.getDatabase().isPersistent()) {
/*  43 */       this.maxMemory = paramSession.getDatabase().getMaxOperationMemory();
/*     */     } else {
/*  45 */       this.maxMemory = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeRow(Data paramData, Row paramRow) {
/*  50 */     paramData.checkCapacity(33);
/*  51 */     paramData.writeByte((byte)1);
/*  52 */     paramData.writeInt(paramRow.getMemory());
/*  53 */     int i = paramRow.getColumnCount();
/*  54 */     paramData.writeInt(i);
/*  55 */     paramData.writeLong(paramRow.getKey());
/*  56 */     paramData.writeInt(paramRow.getVersion());
/*  57 */     paramData.writeInt(paramRow.isDeleted() ? 1 : 0);
/*  58 */     paramData.writeInt(paramRow.getSessionId());
/*  59 */     for (byte b = 0; b < i; b++) {
/*  60 */       Value value = paramRow.getValue(b);
/*  61 */       paramData.checkCapacity(1);
/*  62 */       if (value == null) {
/*  63 */         paramData.writeByte((byte)0);
/*     */       } else {
/*  65 */         paramData.writeByte((byte)1);
/*  66 */         if (value.getType() == 16 || value.getType() == 15)
/*     */         {
/*     */           
/*  69 */           if (value.getSmall() == null && value.getTableId() == 0) {
/*  70 */             if (this.lobs == null) {
/*  71 */               this.lobs = New.arrayList();
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*  76 */             value = value.copyToTemp();
/*  77 */             this.lobs.add(value);
/*     */           } 
/*     */         }
/*  80 */         paramData.checkCapacity(paramData.getValueLen(value));
/*  81 */         paramData.writeValue(value);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeAllRows() {
/*  87 */     if (this.file == null) {
/*  88 */       Database database = this.session.getDatabase();
/*  89 */       String str = database.createTempFile();
/*  90 */       this.file = database.openFile(str, "rw", false);
/*  91 */       this.file.setCheckedWriting(false);
/*  92 */       this.file.seek(48L);
/*  93 */       this.rowBuff = Data.create((DataHandler)database, 4096);
/*  94 */       this.file.seek(48L);
/*     */     } 
/*  96 */     Data data = this.rowBuff;
/*  97 */     initBuffer(data); byte b; int i;
/*  98 */     for (b = 0, i = this.list.size(); b < i; b++) {
/*  99 */       if (b > 0 && data.length() > 4096) {
/* 100 */         flushBuffer(data);
/* 101 */         initBuffer(data);
/*     */       } 
/* 103 */       Row row = this.list.get(b);
/* 104 */       writeRow(data, row);
/*     */     } 
/* 106 */     flushBuffer(data);
/* 107 */     this.file.autoDelete();
/* 108 */     this.list.clear();
/* 109 */     this.memory = 0;
/*     */   }
/*     */   
/*     */   private static void initBuffer(Data paramData) {
/* 113 */     paramData.reset();
/* 114 */     paramData.writeInt(0);
/*     */   }
/*     */   
/*     */   private void flushBuffer(Data paramData) {
/* 118 */     paramData.checkCapacity(1);
/* 119 */     paramData.writeByte((byte)0);
/* 120 */     paramData.fillAligned();
/* 121 */     paramData.setInt(0, paramData.length() / 16);
/* 122 */     this.file.write(paramData.getBytes(), 0, paramData.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Row paramRow) {
/* 131 */     this.list.add(paramRow);
/* 132 */     this.memory += paramRow.getMemory() + 8;
/* 133 */     if (this.maxMemory > 0 && this.memory > this.maxMemory) {
/* 134 */       writeAllRows();
/*     */     }
/* 136 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 143 */     this.index = 0;
/* 144 */     if (this.file != null) {
/* 145 */       this.listIndex = 0;
/* 146 */       if (!this.written) {
/* 147 */         writeAllRows();
/* 148 */         this.written = true;
/*     */       } 
/* 150 */       this.list.clear();
/* 151 */       this.file.seek(48L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 161 */     return (this.index < this.size);
/*     */   }
/*     */   
/*     */   private Row readRow(Data paramData) {
/* 165 */     if (paramData.readByte() == 0) {
/* 166 */       return null;
/*     */     }
/* 168 */     int i = paramData.readInt();
/* 169 */     int j = paramData.readInt();
/* 170 */     long l = paramData.readLong();
/* 171 */     int k = paramData.readInt();
/* 172 */     if (this.readUncached) {
/* 173 */       l = 0L;
/*     */     }
/* 175 */     boolean bool = (paramData.readInt() == 1) ? true : false;
/* 176 */     int m = paramData.readInt();
/* 177 */     Value[] arrayOfValue = new Value[j];
/* 178 */     for (byte b = 0; b < j; b++) {
/*     */       Value value;
/* 180 */       if (paramData.readByte() == 0) {
/* 181 */         value = null;
/*     */       } else {
/* 183 */         value = paramData.readValue();
/* 184 */         if (value.isLinkedToTable())
/*     */         {
/*     */           
/* 187 */           if (value.getTableId() == 0) {
/* 188 */             this.session.removeAtCommit(value);
/*     */           }
/*     */         }
/*     */       } 
/* 192 */       arrayOfValue[b] = value;
/*     */     } 
/* 194 */     Row row = this.session.createRow(arrayOfValue, i);
/* 195 */     row.setKey(l);
/* 196 */     row.setVersion(k);
/* 197 */     row.setDeleted(bool);
/* 198 */     row.setSessionId(m);
/* 199 */     return row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Row next() {
/*     */     Row row;
/* 209 */     if (this.file == null) {
/* 210 */       row = this.list.get(this.index++);
/*     */     } else {
/* 212 */       if (this.listIndex >= this.list.size()) {
/* 213 */         this.list.clear();
/* 214 */         this.listIndex = 0;
/* 215 */         Data data = this.rowBuff;
/* 216 */         data.reset();
/* 217 */         byte b = 16;
/* 218 */         this.file.readFully(data.getBytes(), 0, b);
/* 219 */         int i = data.readInt() * 16;
/* 220 */         data.checkCapacity(i);
/* 221 */         if (i - b > 0) {
/* 222 */           this.file.readFully(data.getBytes(), b, i - b);
/*     */         }
/*     */         while (true) {
/* 225 */           Row row1 = readRow(data);
/* 226 */           if (row1 == null) {
/*     */             break;
/*     */           }
/* 229 */           this.list.add(row1);
/*     */         } 
/*     */       } 
/* 232 */       this.index++;
/* 233 */       row = this.list.get(this.listIndex++);
/*     */     } 
/* 235 */     return row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 244 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void invalidateCache() {
/* 251 */     this.readUncached = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 258 */     if (this.file != null) {
/* 259 */       this.file.autoDelete();
/* 260 */       this.file.closeAndDeleteSilently();
/* 261 */       this.file = null;
/* 262 */       this.rowBuff = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\RowList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */