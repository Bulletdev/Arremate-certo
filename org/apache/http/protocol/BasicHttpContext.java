/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*    */ public class BasicHttpContext
/*    */   implements HttpContext
/*    */ {
/*    */   private final HttpContext parentContext;
/*    */   private final Map<String, Object> map;
/*    */   
/*    */   public BasicHttpContext() {
/* 52 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public BasicHttpContext(HttpContext paramHttpContext) {
/* 57 */     this.map = new ConcurrentHashMap<String, Object>();
/* 58 */     this.parentContext = paramHttpContext;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getAttribute(String paramString) {
/* 63 */     Args.notNull(paramString, "Id");
/* 64 */     Object object = this.map.get(paramString);
/* 65 */     if (object == null && this.parentContext != null) {
/* 66 */       object = this.parentContext.getAttribute(paramString);
/*    */     }
/* 68 */     return object;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAttribute(String paramString, Object paramObject) {
/* 73 */     Args.notNull(paramString, "Id");
/* 74 */     if (paramObject != null) {
/* 75 */       this.map.put(paramString, paramObject);
/*    */     } else {
/* 77 */       this.map.remove(paramString);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Object removeAttribute(String paramString) {
/* 83 */     Args.notNull(paramString, "Id");
/* 84 */     return this.map.remove(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 91 */     this.map.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 96 */     return this.map.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\BasicHttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */