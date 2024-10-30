/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.SchemePortResolver;
/*    */ import org.apache.http.conn.UnsupportedSchemeException;
/*    */ import org.apache.http.util.Args;
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
/*    */ public class DefaultSchemePortResolver
/*    */   implements SchemePortResolver
/*    */ {
/* 44 */   public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();
/*    */ 
/*    */   
/*    */   public int resolve(HttpHost paramHttpHost) throws UnsupportedSchemeException {
/* 48 */     Args.notNull(paramHttpHost, "HTTP host");
/* 49 */     int i = paramHttpHost.getPort();
/* 50 */     if (i > 0) {
/* 51 */       return i;
/*    */     }
/* 53 */     String str = paramHttpHost.getSchemeName();
/* 54 */     if (str.equalsIgnoreCase("http"))
/* 55 */       return 80; 
/* 56 */     if (str.equalsIgnoreCase("https")) {
/* 57 */       return 443;
/*    */     }
/* 59 */     throw new UnsupportedSchemeException(str + " protocol is not supported");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultSchemePortResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */