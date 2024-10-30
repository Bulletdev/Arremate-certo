/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.io.FileNotFoundException;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
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
/*    */ public class LocationUtil
/*    */ {
/*    */   public static final String SCHEME_PATTERN = "^\\p{Alpha}[\\p{Alnum}+.-]*:.*$";
/*    */   public static final String CLASSPATH_SCHEME = "classpath:";
/*    */   
/*    */   public static URL urlForResource(String paramString) throws MalformedURLException, FileNotFoundException {
/* 45 */     if (paramString == null) {
/* 46 */       throw new NullPointerException("location is required");
/*    */     }
/* 48 */     URL uRL = null;
/* 49 */     if (!paramString.matches("^\\p{Alpha}[\\p{Alnum}+.-]*:.*$")) {
/* 50 */       uRL = Loader.getResourceBySelfClassLoader(paramString);
/* 51 */     } else if (paramString.startsWith("classpath:")) {
/* 52 */       String str = paramString.substring("classpath:".length());
/* 53 */       if (str.startsWith("/")) {
/* 54 */         str = str.substring(1);
/*    */       }
/* 56 */       if (str.length() == 0) {
/* 57 */         throw new MalformedURLException("path is required");
/*    */       }
/* 59 */       uRL = Loader.getResourceBySelfClassLoader(str);
/*    */     } else {
/* 61 */       uRL = new URL(paramString);
/*    */     } 
/* 63 */     if (uRL == null) {
/* 64 */       throw new FileNotFoundException(paramString);
/*    */     }
/* 66 */     return uRL;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\LocationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */