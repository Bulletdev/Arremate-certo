/*    */ package org.apache.xmlbeans.impl.common;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.nio.charset.Charset;
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
/*    */ public class SniffedXmlReader
/*    */   extends BufferedReader
/*    */ {
/* 26 */   public static int MAX_SNIFFED_CHARS = 192;
/*    */ 
/*    */   
/*    */   public SniffedXmlReader(Reader paramReader) throws IOException {
/* 30 */     super(paramReader);
/* 31 */     this._encoding = sniffForXmlDecl();
/*    */   }
/*    */ 
/*    */   
/*    */   private int readAsMuchAsPossible(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 36 */     int i = 0;
/* 37 */     while (i < paramInt2) {
/*    */       
/* 39 */       int j = read(paramArrayOfchar, paramInt1 + i, paramInt2 - i);
/* 40 */       if (j < 0)
/*    */         break; 
/* 42 */       i += j;
/*    */     } 
/* 44 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 50 */   private static Charset dummy1 = Charset.forName("UTF-8");
/* 51 */   private static Charset dummy2 = Charset.forName("UTF-16");
/* 52 */   private static Charset dummy3 = Charset.forName("UTF-16BE");
/* 53 */   private static Charset dummy4 = Charset.forName("UTF-16LE");
/* 54 */   private static Charset dummy5 = Charset.forName("ISO-8859-1");
/* 55 */   private static Charset dummy6 = Charset.forName("US-ASCII");
/* 56 */   private static Charset dummy7 = Charset.forName("Cp1252");
/*    */   
/*    */   private String _encoding;
/*    */   
/*    */   private String sniffForXmlDecl() throws IOException {
/* 61 */     mark(MAX_SNIFFED_CHARS);
/*    */     
/*    */     try {
/* 64 */       char[] arrayOfChar = new char[MAX_SNIFFED_CHARS];
/* 65 */       int i = readAsMuchAsPossible(arrayOfChar, 0, MAX_SNIFFED_CHARS);
/* 66 */       return SniffedXmlInputStream.extractXmlDeclEncoding(arrayOfChar, 0, i);
/*    */     }
/*    */     finally {
/*    */       
/* 70 */       reset();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getXmlEncoding() {
/* 78 */     return this._encoding;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\SniffedXmlReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */