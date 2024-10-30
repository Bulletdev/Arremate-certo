/*    */ package org.apache.commons.net.io;
/*    */ 
/*    */ import java.io.BufferedReader;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class CRLFLineReader
/*    */   extends BufferedReader
/*    */ {
/*    */   private static final char LF = '\n';
/*    */   private static final char CR = '\r';
/*    */   
/*    */   public CRLFLineReader(Reader paramReader) {
/* 43 */     super(paramReader);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String readLine() throws IOException {
/* 54 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 56 */     boolean bool = false;
/* 57 */     synchronized (this.lock) {
/* 58 */       int i; while ((i = read()) != -1) {
/*    */         
/* 60 */         if (bool && i == 10) {
/* 61 */           return stringBuilder.substring(0, stringBuilder.length() - 1);
/*    */         }
/* 63 */         if (i == 13) {
/* 64 */           bool = true;
/*    */         } else {
/* 66 */           bool = false;
/*    */         } 
/* 68 */         stringBuilder.append((char)i);
/*    */       } 
/*    */     } 
/* 71 */     String str = stringBuilder.toString();
/* 72 */     if (str.isEmpty()) {
/* 73 */       return null;
/*    */     }
/* 75 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\CRLFLineReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */