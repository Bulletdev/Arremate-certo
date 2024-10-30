/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.ietf.jgss.GSSException;
/*     */ import org.ietf.jgss.Oid;
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
/*     */ public class SPNegoScheme
/*     */   extends GGSSchemeBase
/*     */ {
/*     */   private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
/*     */   
/*     */   public SPNegoScheme(boolean paramBoolean1, boolean paramBoolean2) {
/*  52 */     super(paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public SPNegoScheme(boolean paramBoolean) {
/*  56 */     super(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPNegoScheme() {}
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/*  65 */     return "Negotiate";
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/*  85 */     return super.authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString) throws GSSException {
/*  90 */     return super.generateToken(paramArrayOfbyte, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString, Credentials paramCredentials) throws GSSException {
/*  95 */     return generateGSSToken(paramArrayOfbyte, new Oid("1.3.6.1.5.5.2"), paramString, paramCredentials);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameter(String paramString) {
/* 106 */     Args.notNull(paramString, "Parameter name");
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRealm() {
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\SPNegoScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */