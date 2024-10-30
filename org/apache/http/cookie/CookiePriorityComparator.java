/*    */ package org.apache.http.cookie;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.Date;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.impl.cookie.BasicClientCookie;
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
/*    */ public class CookiePriorityComparator
/*    */   implements Comparator<Cookie>
/*    */ {
/* 47 */   public static final CookiePriorityComparator INSTANCE = new CookiePriorityComparator();
/*    */   
/*    */   private int getPathLength(Cookie paramCookie) {
/* 50 */     String str = paramCookie.getPath();
/* 51 */     return (str != null) ? str.length() : 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int compare(Cookie paramCookie1, Cookie paramCookie2) {
/* 56 */     int i = getPathLength(paramCookie1);
/* 57 */     int j = getPathLength(paramCookie2);
/*    */     
/* 59 */     int k = j - i;
/* 60 */     if (k == 0 && paramCookie1 instanceof BasicClientCookie && paramCookie2 instanceof BasicClientCookie) {
/* 61 */       Date date1 = ((BasicClientCookie)paramCookie1).getCreationDate();
/* 62 */       Date date2 = ((BasicClientCookie)paramCookie2).getCreationDate();
/* 63 */       if (date1 != null && date2 != null) {
/* 64 */         return (int)(date1.getTime() - date2.getTime());
/*    */       }
/*    */     } 
/* 67 */     return k;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookiePriorityComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */