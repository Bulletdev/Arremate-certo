/*    */ package org.apache.http.cookie;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Comparator;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class CookiePathComparator
/*    */   implements Serializable, Comparator<Cookie>
/*    */ {
/* 54 */   public static final CookiePathComparator INSTANCE = new CookiePathComparator();
/*    */   
/*    */   private static final long serialVersionUID = 7523645369616405818L;
/*    */   
/*    */   private String normalizePath(Cookie paramCookie) {
/* 59 */     String str = paramCookie.getPath();
/* 60 */     if (str == null) {
/* 61 */       str = "/";
/*    */     }
/* 63 */     if (!str.endsWith("/")) {
/* 64 */       str = str + '/';
/*    */     }
/* 66 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Cookie paramCookie1, Cookie paramCookie2) {
/* 71 */     String str1 = normalizePath(paramCookie1);
/* 72 */     String str2 = normalizePath(paramCookie2);
/* 73 */     if (str1.equals(str2))
/* 74 */       return 0; 
/* 75 */     if (str1.startsWith(str2))
/* 76 */       return -1; 
/* 77 */     if (str2.startsWith(str1)) {
/* 78 */       return 1;
/*    */     }
/*    */     
/* 81 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookiePathComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */