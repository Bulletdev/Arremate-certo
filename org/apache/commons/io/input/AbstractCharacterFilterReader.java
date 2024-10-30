/*    */ package org.apache.commons.io.input;
/*    */ 
/*    */ import java.io.FilterReader;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
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
/*    */ 
/*    */ 
/*    */ public abstract class AbstractCharacterFilterReader
/*    */   extends FilterReader
/*    */ {
/*    */   protected AbstractCharacterFilterReader(Reader paramReader) {
/* 35 */     super(paramReader);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int read() throws IOException {
/*    */     while (true) {
/* 42 */       int i = this.in.read();
/* 43 */       if (!filter(i)) {
/* 44 */         return i;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract boolean filter(int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 58 */     int i = super.read(paramArrayOfchar, paramInt1, paramInt2);
/* 59 */     if (i == -1) {
/* 60 */       return -1;
/*    */     }
/* 62 */     int j = paramInt1 - 1;
/* 63 */     for (int k = paramInt1; k < paramInt1 + i; k++) {
/* 64 */       if (!filter(paramArrayOfchar[k])) {
/*    */ 
/*    */         
/* 67 */         j++;
/* 68 */         if (j < k)
/* 69 */           paramArrayOfchar[j] = paramArrayOfchar[k]; 
/*    */       } 
/*    */     } 
/* 72 */     return j - paramInt1 + 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\AbstractCharacterFilterReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */