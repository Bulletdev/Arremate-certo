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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class CookieIdentityComparator
/*    */   implements Serializable, Comparator<Cookie>
/*    */ {
/*    */   private static final long serialVersionUID = 4466565437490631532L;
/*    */   
/*    */   public int compare(Cookie paramCookie1, Cookie paramCookie2) {
/* 51 */     int i = paramCookie1.getName().compareTo(paramCookie2.getName());
/* 52 */     if (i == 0) {
/*    */       
/* 54 */       String str1 = paramCookie1.getDomain();
/* 55 */       if (str1 == null) {
/* 56 */         str1 = "";
/* 57 */       } else if (str1.indexOf('.') == -1) {
/* 58 */         str1 = str1 + ".local";
/*    */       } 
/* 60 */       String str2 = paramCookie2.getDomain();
/* 61 */       if (str2 == null) {
/* 62 */         str2 = "";
/* 63 */       } else if (str2.indexOf('.') == -1) {
/* 64 */         str2 = str2 + ".local";
/*    */       } 
/* 66 */       i = str1.compareToIgnoreCase(str2);
/*    */     } 
/* 68 */     if (i == 0) {
/* 69 */       String str1 = paramCookie1.getPath();
/* 70 */       if (str1 == null) {
/* 71 */         str1 = "/";
/*    */       }
/* 73 */       String str2 = paramCookie2.getPath();
/* 74 */       if (str2 == null) {
/* 75 */         str2 = "/";
/*    */       }
/* 77 */       i = str1.compareTo(str2);
/*    */     } 
/* 79 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookieIdentityComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */