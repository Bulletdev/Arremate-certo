/*    */ package org.apache.poi.openxml4j.opc.internal;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MemoryPackagePartOutputStream
/*    */   extends OutputStream
/*    */ {
/*    */   private MemoryPackagePart _part;
/*    */   private ByteArrayOutputStream _buff;
/*    */   
/*    */   public MemoryPackagePartOutputStream(MemoryPackagePart paramMemoryPackagePart) {
/* 36 */     this._part = paramMemoryPackagePart;
/* 37 */     this._buff = new ByteArrayOutputStream();
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int paramInt) {
/* 42 */     this._buff.write(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() throws IOException {
/* 51 */     flush();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 61 */     this._buff.flush();
/* 62 */     if (this._part.data != null) {
/* 63 */       byte[] arrayOfByte1 = new byte[this._part.data.length + this._buff.size()];
/*    */       
/* 65 */       System.arraycopy(this._part.data, 0, arrayOfByte1, 0, this._part.data.length);
/*    */ 
/*    */       
/* 68 */       byte[] arrayOfByte2 = this._buff.toByteArray();
/* 69 */       System.arraycopy(arrayOfByte2, 0, arrayOfByte1, this._part.data.length, arrayOfByte2.length);
/*    */ 
/*    */ 
/*    */       
/* 73 */       this._part.data = arrayOfByte1;
/*    */     } else {
/*    */       
/* 76 */       this._part.data = this._buff.toByteArray();
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 83 */     this._buff.reset();
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 88 */     this._buff.write(paramArrayOfbyte, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 93 */     this._buff.write(paramArrayOfbyte);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\MemoryPackagePartOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */