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
/*     */ public class KerberosScheme
/*     */   extends GGSSchemeBase
/*     */ {
/*     */   private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
/*     */   
/*     */   public KerberosScheme(boolean paramBoolean1, boolean paramBoolean2) {
/*  51 */     super(paramBoolean1, paramBoolean2);
/*     */   }
/*     */   
/*     */   public KerberosScheme(boolean paramBoolean) {
/*  55 */     super(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public KerberosScheme() {}
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/*  64 */     return "Kerberos";
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
/*  84 */     return super.authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString) throws GSSException {
/*  89 */     return super.generateToken(paramArrayOfbyte, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString, Credentials paramCredentials) throws GSSException {
/*  94 */     return generateGSSToken(paramArrayOfbyte, new Oid("1.2.840.113554.1.2.2"), paramString, paramCredentials);
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
/* 105 */     Args.notNull(paramString, "Parameter name");
/* 106 */     return null;
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
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\KerberosScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */