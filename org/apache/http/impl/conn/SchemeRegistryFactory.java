/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.scheme.PlainSocketFactory;
/*    */ import org.apache.http.conn.scheme.Scheme;
/*    */ import org.apache.http.conn.scheme.SchemeRegistry;
/*    */ import org.apache.http.conn.scheme.SchemeSocketFactory;
/*    */ import org.apache.http.conn.ssl.SSLSocketFactory;
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
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public final class SchemeRegistryFactory
/*    */ {
/*    */   public static SchemeRegistry createDefault() {
/* 50 */     SchemeRegistry schemeRegistry = new SchemeRegistry();
/* 51 */     schemeRegistry.register(new Scheme("http", 80, (SchemeSocketFactory)PlainSocketFactory.getSocketFactory()));
/*    */     
/* 53 */     schemeRegistry.register(new Scheme("https", 443, (SchemeSocketFactory)SSLSocketFactory.getSocketFactory()));
/*    */     
/* 55 */     return schemeRegistry;
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
/*    */   public static SchemeRegistry createSystemDefault() {
/* 83 */     SchemeRegistry schemeRegistry = new SchemeRegistry();
/* 84 */     schemeRegistry.register(new Scheme("http", 80, (SchemeSocketFactory)PlainSocketFactory.getSocketFactory()));
/*    */     
/* 86 */     schemeRegistry.register(new Scheme("https", 443, (SchemeSocketFactory)SSLSocketFactory.getSystemSocketFactory()));
/*    */     
/* 88 */     return schemeRegistry;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\SchemeRegistryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */