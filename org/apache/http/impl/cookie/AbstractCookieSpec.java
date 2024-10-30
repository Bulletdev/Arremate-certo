/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieAttributeHandler;
/*     */ import org.apache.http.cookie.CookieSpec;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public abstract class AbstractCookieSpec
/*     */   implements CookieSpec
/*     */ {
/*     */   private final Map<String, CookieAttributeHandler> attribHandlerMap;
/*     */   
/*     */   public AbstractCookieSpec() {
/*  64 */     this.attribHandlerMap = new ConcurrentHashMap<String, CookieAttributeHandler>(10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCookieSpec(HashMap<String, CookieAttributeHandler> paramHashMap) {
/*  72 */     Asserts.notNull(paramHashMap, "Attribute handler map");
/*  73 */     this.attribHandlerMap = new ConcurrentHashMap<String, CookieAttributeHandler>(paramHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractCookieSpec(CommonCookieAttributeHandler... paramVarArgs) {
/*  81 */     this.attribHandlerMap = new ConcurrentHashMap<String, CookieAttributeHandler>(paramVarArgs.length);
/*  82 */     for (CommonCookieAttributeHandler commonCookieAttributeHandler : paramVarArgs) {
/*  83 */       this.attribHandlerMap.put(commonCookieAttributeHandler.getAttributeName(), commonCookieAttributeHandler);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void registerAttribHandler(String paramString, CookieAttributeHandler paramCookieAttributeHandler) {
/*  95 */     Args.notNull(paramString, "Attribute name");
/*  96 */     Args.notNull(paramCookieAttributeHandler, "Attribute handler");
/*  97 */     this.attribHandlerMap.put(paramString, paramCookieAttributeHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CookieAttributeHandler findAttribHandler(String paramString) {
/* 109 */     return this.attribHandlerMap.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CookieAttributeHandler getAttribHandler(String paramString) {
/* 121 */     CookieAttributeHandler cookieAttributeHandler = findAttribHandler(paramString);
/* 122 */     Asserts.check((cookieAttributeHandler != null), "Handler not registered for " + paramString + " attribute");
/*     */     
/* 124 */     return cookieAttributeHandler;
/*     */   }
/*     */   
/*     */   protected Collection<CookieAttributeHandler> getAttribHandlers() {
/* 128 */     return this.attribHandlerMap.values();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\AbstractCookieSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */