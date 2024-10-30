/*    */ package org.apache.http.client.utils;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class Punycode
/*    */ {
/*    */   private static final Idn impl;
/*    */   
/*    */   static {
/*    */     Rfc3492Idn rfc3492Idn;
/*    */     try {
/* 47 */       JdkIdn jdkIdn = new JdkIdn();
/* 48 */     } catch (Exception exception) {
/* 49 */       rfc3492Idn = new Rfc3492Idn();
/*    */     } 
/* 51 */     impl = rfc3492Idn;
/*    */   }
/*    */   
/*    */   public static String toUnicode(String paramString) {
/* 55 */     return impl.toUnicode(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\Punycode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */