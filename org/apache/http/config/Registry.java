/*    */ package org.apache.http.config;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public final class Registry<I>
/*    */   implements Lookup<I>
/*    */ {
/*    */   private final Map<String, I> map;
/*    */   
/*    */   Registry(Map<String, I> paramMap) {
/* 49 */     this.map = new ConcurrentHashMap<String, I>(paramMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public I lookup(String paramString) {
/* 54 */     if (paramString == null) {
/* 55 */       return null;
/*    */     }
/* 57 */     return this.map.get(paramString.toLowerCase(Locale.ROOT));
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return this.map.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\config\Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */