/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.ReasonPhraseCatalog;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.TextUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicHttpResponse
/*     */   extends AbstractHttpMessage
/*     */   implements HttpResponse
/*     */ {
/*     */   private StatusLine statusline;
/*     */   private ProtocolVersion ver;
/*     */   private int code;
/*     */   private String reasonPhrase;
/*     */   private HttpEntity entity;
/*     */   private final ReasonPhraseCatalog reasonCatalog;
/*     */   private Locale locale;
/*     */   
/*     */   public BasicHttpResponse(StatusLine paramStatusLine, ReasonPhraseCatalog paramReasonPhraseCatalog, Locale paramLocale) {
/*  73 */     this.statusline = (StatusLine)Args.notNull(paramStatusLine, "Status line");
/*  74 */     this.ver = paramStatusLine.getProtocolVersion();
/*  75 */     this.code = paramStatusLine.getStatusCode();
/*  76 */     this.reasonPhrase = paramStatusLine.getReasonPhrase();
/*  77 */     this.reasonCatalog = paramReasonPhraseCatalog;
/*  78 */     this.locale = paramLocale;
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
/*     */   public BasicHttpResponse(StatusLine paramStatusLine) {
/*  90 */     this.statusline = (StatusLine)Args.notNull(paramStatusLine, "Status line");
/*  91 */     this.ver = paramStatusLine.getProtocolVersion();
/*  92 */     this.code = paramStatusLine.getStatusCode();
/*  93 */     this.reasonPhrase = paramStatusLine.getReasonPhrase();
/*  94 */     this.reasonCatalog = null;
/*  95 */     this.locale = null;
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
/*     */   public BasicHttpResponse(ProtocolVersion paramProtocolVersion, int paramInt, String paramString) {
/* 112 */     Args.notNegative(paramInt, "Status code");
/* 113 */     this.statusline = null;
/* 114 */     this.ver = paramProtocolVersion;
/* 115 */     this.code = paramInt;
/* 116 */     this.reasonPhrase = paramString;
/* 117 */     this.reasonCatalog = null;
/* 118 */     this.locale = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/* 125 */     return this.ver;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StatusLine getStatusLine() {
/* 131 */     if (this.statusline == null) {
/* 132 */       this.statusline = new BasicStatusLine((this.ver != null) ? this.ver : (ProtocolVersion)HttpVersion.HTTP_1_1, this.code, (this.reasonPhrase != null) ? this.reasonPhrase : getReason(this.code));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 137 */     return this.statusline;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpEntity getEntity() {
/* 143 */     return this.entity;
/*     */   }
/*     */ 
/*     */   
/*     */   public Locale getLocale() {
/* 148 */     return this.locale;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusLine(StatusLine paramStatusLine) {
/* 154 */     this.statusline = (StatusLine)Args.notNull(paramStatusLine, "Status line");
/* 155 */     this.ver = paramStatusLine.getProtocolVersion();
/* 156 */     this.code = paramStatusLine.getStatusCode();
/* 157 */     this.reasonPhrase = paramStatusLine.getReasonPhrase();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt) {
/* 163 */     Args.notNegative(paramInt, "Status code");
/* 164 */     this.statusline = null;
/* 165 */     this.ver = paramProtocolVersion;
/* 166 */     this.code = paramInt;
/* 167 */     this.reasonPhrase = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString) {
/* 174 */     Args.notNegative(paramInt, "Status code");
/* 175 */     this.statusline = null;
/* 176 */     this.ver = paramProtocolVersion;
/* 177 */     this.code = paramInt;
/* 178 */     this.reasonPhrase = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusCode(int paramInt) {
/* 184 */     Args.notNegative(paramInt, "Status code");
/* 185 */     this.statusline = null;
/* 186 */     this.code = paramInt;
/* 187 */     this.reasonPhrase = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReasonPhrase(String paramString) {
/* 193 */     this.statusline = null;
/* 194 */     this.reasonPhrase = TextUtils.isBlank(paramString) ? null : paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEntity(HttpEntity paramHttpEntity) {
/* 200 */     this.entity = paramHttpEntity;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLocale(Locale paramLocale) {
/* 205 */     this.locale = (Locale)Args.notNull(paramLocale, "Locale");
/* 206 */     this.statusline = null;
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
/*     */   protected String getReason(int paramInt) {
/* 219 */     return (this.reasonCatalog != null) ? this.reasonCatalog.getReason(paramInt, (this.locale != null) ? this.locale : Locale.getDefault()) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 225 */     StringBuilder stringBuilder = new StringBuilder();
/* 226 */     stringBuilder.append(getStatusLine());
/* 227 */     stringBuilder.append(' ');
/* 228 */     stringBuilder.append(this.headergroup);
/* 229 */     if (this.entity != null) {
/* 230 */       stringBuilder.append(' ');
/* 231 */       stringBuilder.append(this.entity);
/*     */     } 
/* 233 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHttpResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */