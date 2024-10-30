/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.tools.CompressTool;
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
/*     */ public class FileStoreInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private FileStore store;
/*     */   private final Data page;
/*     */   private int remainingInBuffer;
/*     */   private final CompressTool compress;
/*     */   private boolean endOfFile;
/*     */   private final boolean alwaysClose;
/*     */   
/*     */   public FileStoreInputStream(FileStore paramFileStore, DataHandler paramDataHandler, boolean paramBoolean1, boolean paramBoolean2) {
/*  29 */     this.store = paramFileStore;
/*  30 */     this.alwaysClose = paramBoolean2;
/*  31 */     if (paramBoolean1) {
/*  32 */       this.compress = CompressTool.getInstance();
/*     */     } else {
/*  34 */       this.compress = null;
/*     */     } 
/*  36 */     this.page = Data.create(paramDataHandler, 16);
/*     */     try {
/*  38 */       if (paramFileStore.length() <= 48L) {
/*  39 */         close();
/*     */       } else {
/*  41 */         fillBuffer();
/*     */       } 
/*  43 */     } catch (IOException iOException) {
/*  44 */       throw DbException.convertIOException(iOException, paramFileStore.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/*  50 */     return (this.remainingInBuffer <= 0) ? 0 : this.remainingInBuffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  55 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  60 */     if (paramInt2 == 0) {
/*  61 */       return 0;
/*     */     }
/*  63 */     int i = 0;
/*  64 */     while (paramInt2 > 0) {
/*  65 */       int j = readBlock(paramArrayOfbyte, paramInt1, paramInt2);
/*  66 */       if (j < 0) {
/*     */         break;
/*     */       }
/*  69 */       i += j;
/*  70 */       paramInt1 += j;
/*  71 */       paramInt2 -= j;
/*     */     } 
/*  73 */     return (i == 0) ? -1 : i;
/*     */   }
/*     */   
/*     */   private int readBlock(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  77 */     fillBuffer();
/*  78 */     if (this.endOfFile) {
/*  79 */       return -1;
/*     */     }
/*  81 */     int i = Math.min(this.remainingInBuffer, paramInt2);
/*  82 */     this.page.read(paramArrayOfbyte, paramInt1, i);
/*  83 */     this.remainingInBuffer -= i;
/*  84 */     return i;
/*     */   }
/*     */   
/*     */   private void fillBuffer() throws IOException {
/*  88 */     if (this.remainingInBuffer > 0 || this.endOfFile) {
/*     */       return;
/*     */     }
/*  91 */     this.page.reset();
/*  92 */     this.store.openFile();
/*  93 */     if (this.store.length() == this.store.getFilePointer()) {
/*  94 */       close();
/*     */       return;
/*     */     } 
/*  97 */     this.store.readFully(this.page.getBytes(), 0, 16);
/*  98 */     this.page.reset();
/*  99 */     this.remainingInBuffer = this.page.readInt();
/* 100 */     if (this.remainingInBuffer < 0) {
/* 101 */       close();
/*     */       return;
/*     */     } 
/* 104 */     this.page.checkCapacity(this.remainingInBuffer);
/*     */     
/* 106 */     if (this.compress != null) {
/* 107 */       this.page.checkCapacity(4);
/* 108 */       this.page.readInt();
/*     */     } 
/* 110 */     this.page.setPos(this.page.length() + this.remainingInBuffer);
/* 111 */     this.page.fillAligned();
/* 112 */     int i = this.page.length() - 16;
/* 113 */     this.page.reset();
/* 114 */     this.page.readInt();
/* 115 */     this.store.readFully(this.page.getBytes(), 16, i);
/* 116 */     this.page.reset();
/* 117 */     this.page.readInt();
/* 118 */     if (this.compress != null) {
/* 119 */       int j = this.page.readInt();
/* 120 */       byte[] arrayOfByte = DataUtils.newBytes(this.remainingInBuffer);
/* 121 */       this.page.read(arrayOfByte, 0, this.remainingInBuffer);
/* 122 */       this.page.reset();
/* 123 */       this.page.checkCapacity(j);
/* 124 */       CompressTool.expand(arrayOfByte, this.page.getBytes(), 0);
/* 125 */       this.remainingInBuffer = j;
/*     */     } 
/* 127 */     if (this.alwaysClose) {
/* 128 */       this.store.closeFile();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 134 */     if (this.store != null) {
/*     */       try {
/* 136 */         this.store.close();
/* 137 */         this.endOfFile = true;
/*     */       } finally {
/* 139 */         this.store = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() {
/* 146 */     close();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 151 */     fillBuffer();
/* 152 */     if (this.endOfFile) {
/* 153 */       return -1;
/*     */     }
/* 155 */     int i = this.page.readByte() & 0xFF;
/* 156 */     this.remainingInBuffer--;
/* 157 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\FileStoreInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */