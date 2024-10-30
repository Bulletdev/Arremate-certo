/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.io.FilterOutputStream;
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
/*    */ public final class LittleEndianOutputStream
/*    */   extends FilterOutputStream
/*    */   implements LittleEndianOutput
/*    */ {
/*    */   public LittleEndianOutputStream(OutputStream paramOutputStream) {
/* 30 */     super(paramOutputStream);
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeByte(int paramInt) {
/*    */     try {
/* 36 */       this.out.write(paramInt);
/* 37 */     } catch (IOException iOException) {
/* 38 */       throw new RuntimeException(iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeDouble(double paramDouble) {
/* 44 */     writeLong(Double.doubleToLongBits(paramDouble));
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeInt(int paramInt) {
/* 49 */     int i = paramInt >>> 24 & 0xFF;
/* 50 */     int j = paramInt >>> 16 & 0xFF;
/* 51 */     int k = paramInt >>> 8 & 0xFF;
/* 52 */     int m = paramInt >>> 0 & 0xFF;
/*    */     try {
/* 54 */       this.out.write(m);
/* 55 */       this.out.write(k);
/* 56 */       this.out.write(j);
/* 57 */       this.out.write(i);
/* 58 */     } catch (IOException iOException) {
/* 59 */       throw new RuntimeException(iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeLong(long paramLong) {
/* 65 */     writeInt((int)(paramLong >> 0L));
/* 66 */     writeInt((int)(paramLong >> 32L));
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeShort(int paramInt) {
/* 71 */     int i = paramInt >>> 8 & 0xFF;
/* 72 */     int j = paramInt >>> 0 & 0xFF;
/*    */     try {
/* 74 */       this.out.write(j);
/* 75 */       this.out.write(i);
/* 76 */     } catch (IOException iOException) {
/* 77 */       throw new RuntimeException(iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte) {
/*    */     try {
/* 84 */       super.write(paramArrayOfbyte);
/* 85 */     } catch (IOException iOException) {
/* 86 */       throw new RuntimeException(iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*    */     try {
/* 93 */       super.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 94 */     } catch (IOException iOException) {
/* 95 */       throw new RuntimeException(iOException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */