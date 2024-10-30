/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.auth.ChallengeState;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.message.BasicHeaderValueParser;
/*     */ import org.apache.http.message.ParserCursor;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ import org.apache.http.util.CharsetUtils;
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
/*     */ public abstract class RFC2617Scheme
/*     */   extends AuthSchemeBase
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2845454858205884623L;
/*     */   private final Map<String, String> params;
/*     */   private transient Charset credentialsCharset;
/*     */   
/*     */   @Deprecated
/*     */   public RFC2617Scheme(ChallengeState paramChallengeState) {
/*  76 */     super(paramChallengeState);
/*  77 */     this.params = new HashMap<String, String>();
/*  78 */     this.credentialsCharset = Consts.ASCII;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RFC2617Scheme(Charset paramCharset) {
/*  86 */     this.params = new HashMap<String, String>();
/*  87 */     this.credentialsCharset = (paramCharset != null) ? paramCharset : Consts.ASCII;
/*     */   }
/*     */   
/*     */   public RFC2617Scheme() {
/*  91 */     this(Consts.ASCII);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCredentialsCharset() {
/*  99 */     return (this.credentialsCharset != null) ? this.credentialsCharset : Consts.ASCII;
/*     */   }
/*     */   
/*     */   String getCredentialsCharset(HttpRequest paramHttpRequest) {
/* 103 */     String str = (String)paramHttpRequest.getParams().getParameter("http.auth.credential-charset");
/* 104 */     if (str == null) {
/* 105 */       str = getCredentialsCharset().name();
/*     */     }
/* 107 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void parseChallenge(CharArrayBuffer paramCharArrayBuffer, int paramInt1, int paramInt2) throws MalformedChallengeException {
/* 113 */     BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.INSTANCE;
/* 114 */     ParserCursor parserCursor = new ParserCursor(paramInt1, paramCharArrayBuffer.length());
/* 115 */     HeaderElement[] arrayOfHeaderElement = basicHeaderValueParser.parseElements(paramCharArrayBuffer, parserCursor);
/* 116 */     this.params.clear();
/* 117 */     for (HeaderElement headerElement : arrayOfHeaderElement) {
/* 118 */       this.params.put(headerElement.getName().toLowerCase(Locale.ROOT), headerElement.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<String, String> getParameters() {
/* 128 */     return this.params;
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
/*     */   public String getParameter(String paramString) {
/* 140 */     if (paramString == null) {
/* 141 */       return null;
/*     */     }
/* 143 */     return this.params.get(paramString.toLowerCase(Locale.ROOT));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRealm() {
/* 153 */     return getParameter("realm");
/*     */   }
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 157 */     paramObjectOutputStream.defaultWriteObject();
/* 158 */     paramObjectOutputStream.writeUTF(this.credentialsCharset.name());
/* 159 */     paramObjectOutputStream.writeObject(this.challengeState);
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 164 */     paramObjectInputStream.defaultReadObject();
/* 165 */     this.credentialsCharset = CharsetUtils.get(paramObjectInputStream.readUTF());
/* 166 */     if (this.credentialsCharset == null) {
/* 167 */       this.credentialsCharset = Consts.ASCII;
/*     */     }
/* 169 */     this.challengeState = (ChallengeState)paramObjectInputStream.readObject();
/*     */   }
/*     */   
/*     */   private void readObjectNoData() throws ObjectStreamException {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\RFC2617Scheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */