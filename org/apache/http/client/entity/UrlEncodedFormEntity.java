/*     */ package org.apache.http.client.entity;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.List;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.client.utils.URLEncodedUtils;
/*     */ import org.apache.http.entity.ContentType;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UrlEncodedFormEntity
/*     */   extends StringEntity
/*     */ {
/*     */   public UrlEncodedFormEntity(List<? extends NameValuePair> paramList, String paramString) throws UnsupportedEncodingException {
/*  58 */     super(URLEncodedUtils.format(paramList, (paramString != null) ? paramString : HTTP.DEF_CONTENT_CHARSET.name()), ContentType.create("application/x-www-form-urlencoded", paramString));
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
/*     */   public UrlEncodedFormEntity(Iterable<? extends NameValuePair> paramIterable, Charset paramCharset) {
/*  75 */     super(URLEncodedUtils.format(paramIterable, (paramCharset != null) ? paramCharset : HTTP.DEF_CONTENT_CHARSET), ContentType.create("application/x-www-form-urlencoded", paramCharset));
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
/*     */   public UrlEncodedFormEntity(List<? extends NameValuePair> paramList) throws UnsupportedEncodingException {
/*  89 */     this(paramList, (Charset)null);
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
/*     */   public UrlEncodedFormEntity(Iterable<? extends NameValuePair> paramIterable) {
/* 102 */     this(paramIterable, (Charset)null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\UrlEncodedFormEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */