/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.InvalidCredentialsException;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.auth.NTCredentials;
/*     */ import org.apache.http.message.BufferedHeader;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
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
/*     */ public class NTLMScheme
/*     */   extends AuthSchemeBase
/*     */ {
/*     */   private final NTLMEngine engine;
/*     */   private State state;
/*     */   private String challenge;
/*     */   
/*     */   enum State
/*     */   {
/*  50 */     UNINITIATED,
/*  51 */     CHALLENGE_RECEIVED,
/*  52 */     MSG_TYPE1_GENERATED,
/*  53 */     MSG_TYPE2_RECEVIED,
/*  54 */     MSG_TYPE3_GENERATED,
/*  55 */     FAILED;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NTLMScheme(NTLMEngine paramNTLMEngine) {
/*  65 */     Args.notNull(paramNTLMEngine, "NTLM engine");
/*  66 */     this.engine = paramNTLMEngine;
/*  67 */     this.state = State.UNINITIATED;
/*  68 */     this.challenge = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NTLMScheme() {
/*  75 */     this(new NTLMEngineImpl());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/*  80 */     return "ntlm";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameter(String paramString) {
/*  86 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRealm() {
/*  92 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/*  97 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) throws MalformedChallengeException {
/* 104 */     this.challenge = paramCharArrayBuffer.substringTrimmed(paramInt1, paramInt2);
/* 105 */     if (this.challenge.isEmpty()) {
/* 106 */       if (this.state == State.UNINITIATED) {
/* 107 */         this.state = State.CHALLENGE_RECEIVED;
/*     */       } else {
/* 109 */         this.state = State.FAILED;
/*     */       } 
/*     */     } else {
/* 112 */       if (this.state.compareTo(State.MSG_TYPE1_GENERATED) < 0) {
/* 113 */         this.state = State.FAILED;
/* 114 */         throw new MalformedChallengeException("Out of sequence NTLM response message");
/* 115 */       }  if (this.state == State.MSG_TYPE1_GENERATED) {
/* 116 */         this.state = State.MSG_TYPE2_RECEVIED;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException {
/* 125 */     NTCredentials nTCredentials = null;
/*     */     try {
/* 127 */       nTCredentials = (NTCredentials)paramCredentials;
/* 128 */     } catch (ClassCastException classCastException) {
/* 129 */       throw new InvalidCredentialsException("Credentials cannot be used for NTLM authentication: " + paramCredentials.getClass().getName());
/*     */     } 
/*     */ 
/*     */     
/* 133 */     String str = null;
/* 134 */     if (this.state == State.FAILED)
/* 135 */       throw new AuthenticationException("NTLM authentication failed"); 
/* 136 */     if (this.state == State.CHALLENGE_RECEIVED) {
/* 137 */       str = this.engine.generateType1Msg(nTCredentials.getDomain(), nTCredentials.getWorkstation());
/*     */ 
/*     */       
/* 140 */       this.state = State.MSG_TYPE1_GENERATED;
/* 141 */     } else if (this.state == State.MSG_TYPE2_RECEVIED) {
/* 142 */       str = this.engine.generateType3Msg(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getDomain(), nTCredentials.getWorkstation(), this.challenge);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       this.state = State.MSG_TYPE3_GENERATED;
/*     */     } else {
/* 150 */       throw new AuthenticationException("Unexpected state: " + this.state);
/*     */     } 
/* 152 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
/* 153 */     if (isProxy()) {
/* 154 */       charArrayBuffer.append("Proxy-Authorization");
/*     */     } else {
/* 156 */       charArrayBuffer.append("Authorization");
/*     */     } 
/* 158 */     charArrayBuffer.append(": NTLM ");
/* 159 */     charArrayBuffer.append(str);
/* 160 */     return (Header)new BufferedHeader(charArrayBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/* 165 */     return (this.state == State.MSG_TYPE3_GENERATED || this.state == State.FAILED);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\NTLMScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */