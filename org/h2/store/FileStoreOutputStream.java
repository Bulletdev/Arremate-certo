/*    */ package org.h2.store;
/*    */ 
/*    */ import java.io.OutputStream;
/*    */ import org.h2.tools.CompressTool;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileStoreOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private FileStore store;
/*    */   private final Data page;
/*    */   private final String compressionAlgorithm;
/*    */   private final CompressTool compress;
/* 20 */   private final byte[] buffer = new byte[] { 0 };
/*    */ 
/*    */   
/*    */   public FileStoreOutputStream(FileStore paramFileStore, DataHandler paramDataHandler, String paramString) {
/* 24 */     this.store = paramFileStore;
/* 25 */     if (paramString != null) {
/* 26 */       this.compress = CompressTool.getInstance();
/* 27 */       this.compressionAlgorithm = paramString;
/*    */     } else {
/* 29 */       this.compress = null;
/* 30 */       this.compressionAlgorithm = null;
/*    */     } 
/* 32 */     this.page = Data.create(paramDataHandler, 16);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) {
/* 37 */     this.buffer[0] = (byte)paramInt;
/* 38 */     write(this.buffer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) {
/* 43 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 48 */     if (paramInt2 > 0) {
/* 49 */       this.page.reset();
/* 50 */       if (this.compress != null) {
/* 51 */         if (paramInt1 != 0 || paramInt2 != paramArrayOfbyte.length) {
/* 52 */           byte[] arrayOfByte = new byte[paramInt2];
/* 53 */           System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/* 54 */           paramArrayOfbyte = arrayOfByte;
/* 55 */           paramInt1 = 0;
/*    */         } 
/* 57 */         int i = paramInt2;
/* 58 */         paramArrayOfbyte = this.compress.compress(paramArrayOfbyte, this.compressionAlgorithm);
/* 59 */         paramInt2 = paramArrayOfbyte.length;
/* 60 */         this.page.checkCapacity(8 + paramInt2);
/* 61 */         this.page.writeInt(paramInt2);
/* 62 */         this.page.writeInt(i);
/* 63 */         this.page.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */       } else {
/* 65 */         this.page.checkCapacity(4 + paramInt2);
/* 66 */         this.page.writeInt(paramInt2);
/* 67 */         this.page.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */       } 
/* 69 */       this.page.fillAligned();
/* 70 */       this.store.write(this.page.getBytes(), 0, this.page.length());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 76 */     if (this.store != null)
/*    */       try {
/* 78 */         this.store.close();
/*    */       } finally {
/* 80 */         this.store = null;
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\FileStoreOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */