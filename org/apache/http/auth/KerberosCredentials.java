/*    */ package org.apache.http.auth;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.security.Principal;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.ietf.jgss.GSSCredential;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class KerberosCredentials
/*    */   implements Serializable, Credentials
/*    */ {
/*    */   private static final long serialVersionUID = 487421613855550713L;
/*    */   private final GSSCredential gssCredential;
/*    */   
/*    */   public KerberosCredentials(GSSCredential paramGSSCredential) {
/* 55 */     this.gssCredential = paramGSSCredential;
/*    */   }
/*    */   
/*    */   public GSSCredential getGSSCredential() {
/* 59 */     return this.gssCredential;
/*    */   }
/*    */ 
/*    */   
/*    */   public Principal getUserPrincipal() {
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPassword() {
/* 69 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\KerberosCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */