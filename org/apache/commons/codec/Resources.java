/*    */ package org.apache.commons.codec;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ public class Resources
/*    */ {
/*    */   public static InputStream getInputStream(String paramString) {
/* 36 */     InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(paramString);
/* 37 */     if (inputStream == null) {
/* 38 */       throw new IllegalArgumentException("Unable to resolve required resource: " + paramString);
/*    */     }
/* 40 */     return inputStream;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\Resources.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */