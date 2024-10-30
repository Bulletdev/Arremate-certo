/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
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
/*     */ @Deprecated
/*     */ public class NegotiateScheme
/*     */   extends GGSSchemeBase
/*     */ {
/*  53 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
/*     */ 
/*     */   
/*     */   private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
/*     */   
/*     */   private final SpnegoTokenGenerator spengoGenerator;
/*     */ 
/*     */   
/*     */   public NegotiateScheme(SpnegoTokenGenerator paramSpnegoTokenGenerator, boolean paramBoolean) {
/*  65 */     super(paramBoolean);
/*  66 */     this.spengoGenerator = paramSpnegoTokenGenerator;
/*     */   }
/*     */   
/*     */   public NegotiateScheme(SpnegoTokenGenerator paramSpnegoTokenGenerator) {
/*  70 */     this(paramSpnegoTokenGenerator, false);
/*     */   }
/*     */   
/*     */   public NegotiateScheme() {
/*  74 */     this(null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/*  84 */     return "Negotiate";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException {
/*  91 */     return authenticate(paramCredentials, paramHttpRequest, null);
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
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 112 */     return super.authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString) throws GSSException {
/* 117 */     return super.generateToken(paramArrayOfbyte, paramString);
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
/*     */   protected byte[] generateToken(byte[] paramArrayOfbyte, String paramString, Credentials paramCredentials) throws GSSException {
/* 137 */     Oid oid = new Oid("1.3.6.1.5.5.2");
/*     */     
/* 139 */     byte[] arrayOfByte = paramArrayOfbyte;
/* 140 */     boolean bool = false;
/*     */     try {
/* 142 */       arrayOfByte = generateGSSToken(arrayOfByte, oid, paramString, paramCredentials);
/* 143 */     } catch (GSSException gSSException) {
/*     */ 
/*     */       
/* 146 */       if (gSSException.getMajor() == 2) {
/* 147 */         this.log.debug("GSSException BAD_MECH, retry with Kerberos MECH");
/* 148 */         bool = true;
/*     */       } else {
/* 150 */         throw gSSException;
/*     */       } 
/*     */     } 
/*     */     
/* 154 */     if (bool) {
/*     */       
/* 156 */       this.log.debug("Using Kerberos MECH 1.2.840.113554.1.2.2");
/* 157 */       oid = new Oid("1.2.840.113554.1.2.2");
/* 158 */       arrayOfByte = generateGSSToken(arrayOfByte, oid, paramString, paramCredentials);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 164 */       if (arrayOfByte != null && this.spengoGenerator != null) {
/*     */         try {
/* 166 */           arrayOfByte = this.spengoGenerator.generateSpnegoDERObject(arrayOfByte);
/* 167 */         } catch (IOException iOException) {
/* 168 */           this.log.error(iOException.getMessage(), iOException);
/*     */         } 
/*     */       }
/*     */     } 
/* 172 */     return arrayOfByte;
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
/*     */   public String getParameter(String paramString) {
/* 187 */     Args.notNull(paramString, "Parameter name");
/* 188 */     return null;
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
/* 199 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 210 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\NegotiateScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */