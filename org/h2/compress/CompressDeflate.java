/*    */ package org.h2.compress;
/*    */ 
/*    */ import java.util.StringTokenizer;
/*    */ import java.util.zip.DataFormatException;
/*    */ import java.util.zip.Deflater;
/*    */ import java.util.zip.Inflater;
/*    */ import org.h2.message.DbException;
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
/*    */ public class CompressDeflate
/*    */   implements Compressor
/*    */ {
/* 29 */   private int level = -1;
/* 30 */   private int strategy = 0;
/*    */ 
/*    */   
/*    */   public void setOptions(String paramString) {
/* 34 */     if (paramString == null) {
/*    */       return;
/*    */     }
/*    */     try {
/* 38 */       StringTokenizer stringTokenizer = new StringTokenizer(paramString);
/* 39 */       while (stringTokenizer.hasMoreElements()) {
/* 40 */         String str = stringTokenizer.nextToken();
/* 41 */         if ("level".equals(str) || "l".equals(str)) {
/* 42 */           this.level = Integer.parseInt(stringTokenizer.nextToken());
/* 43 */         } else if ("strategy".equals(str) || "s".equals(str)) {
/* 44 */           this.strategy = Integer.parseInt(stringTokenizer.nextToken());
/*    */         } 
/* 46 */         Deflater deflater = new Deflater(this.level);
/* 47 */         deflater.setStrategy(this.strategy);
/*    */       } 
/* 49 */     } catch (Exception exception) {
/* 50 */       throw DbException.get(90102, paramString);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int compress(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2) {
/* 56 */     Deflater deflater = new Deflater(this.level);
/* 57 */     deflater.setStrategy(this.strategy);
/* 58 */     deflater.setInput(paramArrayOfbyte1, 0, paramInt1);
/* 59 */     deflater.finish();
/* 60 */     int i = deflater.deflate(paramArrayOfbyte2, paramInt2, paramArrayOfbyte2.length - paramInt2);
/* 61 */     if (i == 0) {
/*    */ 
/*    */ 
/*    */       
/* 65 */       this.strategy = 0;
/* 66 */       this.level = -1;
/* 67 */       return compress(paramArrayOfbyte1, paramInt1, paramArrayOfbyte2, paramInt2);
/*    */     } 
/* 69 */     deflater.end();
/* 70 */     return paramInt2 + i;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getAlgorithm() {
/* 75 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void expand(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4) {
/* 81 */     Inflater inflater = new Inflater();
/* 82 */     inflater.setInput(paramArrayOfbyte1, paramInt1, paramInt2);
/* 83 */     inflater.finished();
/*    */     try {
/* 85 */       int i = inflater.inflate(paramArrayOfbyte2, paramInt3, paramInt4);
/* 86 */       if (i != paramInt4) {
/* 87 */         throw new DataFormatException(i + " " + paramInt4);
/*    */       }
/* 89 */     } catch (DataFormatException dataFormatException) {
/* 90 */       throw DbException.get(90104, dataFormatException, new String[0]);
/*    */     } 
/* 92 */     inflater.end();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\CompressDeflate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */