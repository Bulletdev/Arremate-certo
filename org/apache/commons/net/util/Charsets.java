/*    */ package org.apache.commons.net.util;
/*    */ 
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
/*    */ public class Charsets
/*    */ {
/*    */   public static Charset toCharset(String paramString) {
/* 38 */     return (paramString == null) ? Charset.defaultCharset() : Charset.forName(paramString);
/*    */   }
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
/*    */   public static Charset toCharset(String paramString1, String paramString2) {
/* 52 */     return (paramString1 == null) ? Charset.forName(paramString2) : Charset.forName(paramString1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\Charsets.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */