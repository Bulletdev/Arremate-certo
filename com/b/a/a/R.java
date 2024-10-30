/*     */ package com.b.a.a;
/*     */ 
/*     */ import javax.net.ssl.SSLSocket;
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
/*     */ 
/*     */ 
/*     */ public class r
/*     */   extends U
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final SSLSocket a;
/*     */   private final String ji;
/*     */   
/*     */   public r(SSLSocket paramSSLSocket, String paramString) {
/*  57 */     super(T.W, 
/*  58 */         String.format("The certificate of the peer%s does not match the expected hostname (%s)", new Object[] {
/*  59 */             a(paramSSLSocket), paramString
/*     */           }));
/*  61 */     this.a = paramSSLSocket;
/*  62 */     this.ji = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(SSLSocket paramSSLSocket) {
/*     */     try {
/*  70 */       return String.format(" (%s)", new Object[] { paramSSLSocket.getSession().getPeerPrincipal().toString() });
/*     */     }
/*  72 */     catch (Exception exception) {
/*     */ 
/*     */       
/*  75 */       return "";
/*     */     } 
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
/*     */   public SSLSocket a() {
/*  88 */     return this.a;
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
/*     */   public String dD() {
/* 100 */     return this.ji;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */