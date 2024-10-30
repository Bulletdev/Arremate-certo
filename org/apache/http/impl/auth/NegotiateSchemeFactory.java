/*    */ package org.apache.http.impl.auth;
/*    */ 
/*    */ import org.apache.http.auth.AuthScheme;
/*    */ import org.apache.http.auth.AuthSchemeFactory;
/*    */ import org.apache.http.params.HttpParams;
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
/*    */ public class NegotiateSchemeFactory
/*    */   implements AuthSchemeFactory
/*    */ {
/*    */   private final SpnegoTokenGenerator spengoGenerator;
/*    */   private final boolean stripPort;
/*    */   
/*    */   public NegotiateSchemeFactory(SpnegoTokenGenerator paramSpnegoTokenGenerator, boolean paramBoolean) {
/* 49 */     this.spengoGenerator = paramSpnegoTokenGenerator;
/* 50 */     this.stripPort = paramBoolean;
/*    */   }
/*    */   
/*    */   public NegotiateSchemeFactory(SpnegoTokenGenerator paramSpnegoTokenGenerator) {
/* 54 */     this(paramSpnegoTokenGenerator, false);
/*    */   }
/*    */   
/*    */   public NegotiateSchemeFactory() {
/* 58 */     this(null, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public AuthScheme newInstance(HttpParams paramHttpParams) {
/* 63 */     return (AuthScheme)new NegotiateScheme(this.spengoGenerator, this.stripPort);
/*    */   }
/*    */   
/*    */   public boolean isStripPort() {
/* 67 */     return this.stripPort;
/*    */   }
/*    */   
/*    */   public SpnegoTokenGenerator getSpengoGenerator() {
/* 71 */     return this.spengoGenerator;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\NegotiateSchemeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */