/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.util.Args;
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
/*     */ public class BasicCredentialsProvider
/*     */   implements CredentialsProvider
/*     */ {
/*  54 */   private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap<AuthScope, Credentials>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials) {
/*  61 */     Args.notNull(paramAuthScope, "Authentication scope");
/*  62 */     this.credMap.put(paramAuthScope, paramCredentials);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static Credentials matchCredentials(Map<AuthScope, Credentials> paramMap, AuthScope paramAuthScope) {
/*  77 */     Credentials credentials = paramMap.get(paramAuthScope);
/*  78 */     if (credentials == null) {
/*     */ 
/*     */       
/*  81 */       int i = -1;
/*  82 */       AuthScope authScope = null;
/*  83 */       for (AuthScope authScope1 : paramMap.keySet()) {
/*  84 */         int j = paramAuthScope.match(authScope1);
/*  85 */         if (j > i) {
/*  86 */           i = j;
/*  87 */           authScope = authScope1;
/*     */         } 
/*     */       } 
/*  90 */       if (authScope != null) {
/*  91 */         credentials = paramMap.get(authScope);
/*     */       }
/*     */     } 
/*  94 */     return credentials;
/*     */   }
/*     */ 
/*     */   
/*     */   public Credentials getCredentials(AuthScope paramAuthScope) {
/*  99 */     Args.notNull(paramAuthScope, "Authentication scope");
/* 100 */     return matchCredentials(this.credMap, paramAuthScope);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 105 */     this.credMap.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 110 */     return this.credMap.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\BasicCredentialsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */