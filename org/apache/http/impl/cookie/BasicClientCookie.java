/*     */ package org.apache.http.impl.cookie;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.http.cookie.ClientCookie;
/*     */ import org.apache.http.cookie.SetCookie;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicClientCookie
/*     */   implements Serializable, Cloneable, ClientCookie, SetCookie
/*     */ {
/*     */   private static final long serialVersionUID = -3869795591041535538L;
/*     */   private final String name;
/*     */   private Map<String, String> attribs;
/*     */   private String value;
/*     */   private String cookieComment;
/*     */   private String cookieDomain;
/*     */   private Date cookieExpiryDate;
/*     */   private String cookiePath;
/*     */   private boolean isSecure;
/*     */   private int cookieVersion;
/*     */   private Date creationDate;
/*     */   
/*     */   public BasicClientCookie(String paramString1, String paramString2) {
/*  57 */     Args.notNull(paramString1, "Name");
/*  58 */     this.name = paramString1;
/*  59 */     this.attribs = new HashMap<String, String>();
/*  60 */     this.value = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  70 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  80 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue(String paramString) {
/*  90 */     this.value = paramString;
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
/*     */   public String getComment() {
/* 103 */     return this.cookieComment;
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
/*     */   public void setComment(String paramString) {
/* 116 */     this.cookieComment = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommentURL() {
/* 125 */     return null;
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
/*     */   public Date getExpiryDate() {
/* 142 */     return this.cookieExpiryDate;
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
/*     */   public void setExpiryDate(Date paramDate) {
/* 158 */     this.cookieExpiryDate = paramDate;
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
/*     */   public boolean isPersistent() {
/* 171 */     return (null != this.cookieExpiryDate);
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
/*     */   public String getDomain() {
/* 184 */     return this.cookieDomain;
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
/*     */   public void setDomain(String paramString) {
/* 196 */     if (paramString != null) {
/* 197 */       this.cookieDomain = paramString.toLowerCase(Locale.ROOT);
/*     */     } else {
/* 199 */       this.cookieDomain = null;
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
/*     */   
/*     */   public String getPath() {
/* 213 */     return this.cookiePath;
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
/*     */   public void setPath(String paramString) {
/* 226 */     this.cookiePath = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 235 */     return this.isSecure;
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
/*     */   public void setSecure(boolean paramBoolean) {
/* 252 */     this.isSecure = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getPorts() {
/* 261 */     return null;
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
/*     */   public int getVersion() {
/* 276 */     return this.cookieVersion;
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
/*     */   public void setVersion(int paramInt) {
/* 289 */     this.cookieVersion = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExpired(Date paramDate) {
/* 300 */     Args.notNull(paramDate, "Date");
/* 301 */     return (this.cookieExpiryDate != null && this.cookieExpiryDate.getTime() <= paramDate.getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getCreationDate() {
/* 309 */     return this.creationDate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreationDate(Date paramDate) {
/* 316 */     this.creationDate = paramDate;
/*     */   }
/*     */   
/*     */   public void setAttribute(String paramString1, String paramString2) {
/* 320 */     this.attribs.put(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getAttribute(String paramString) {
/* 325 */     return this.attribs.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAttribute(String paramString) {
/* 330 */     return this.attribs.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAttribute(String paramString) {
/* 337 */     return (this.attribs.remove(paramString) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 342 */     BasicClientCookie basicClientCookie = (BasicClientCookie)super.clone();
/* 343 */     basicClientCookie.attribs = new HashMap<String, String>(this.attribs);
/* 344 */     return basicClientCookie;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 349 */     StringBuilder stringBuilder = new StringBuilder();
/* 350 */     stringBuilder.append("[version: ");
/* 351 */     stringBuilder.append(Integer.toString(this.cookieVersion));
/* 352 */     stringBuilder.append("]");
/* 353 */     stringBuilder.append("[name: ");
/* 354 */     stringBuilder.append(this.name);
/* 355 */     stringBuilder.append("]");
/* 356 */     stringBuilder.append("[value: ");
/* 357 */     stringBuilder.append(this.value);
/* 358 */     stringBuilder.append("]");
/* 359 */     stringBuilder.append("[domain: ");
/* 360 */     stringBuilder.append(this.cookieDomain);
/* 361 */     stringBuilder.append("]");
/* 362 */     stringBuilder.append("[path: ");
/* 363 */     stringBuilder.append(this.cookiePath);
/* 364 */     stringBuilder.append("]");
/* 365 */     stringBuilder.append("[expiry: ");
/* 366 */     stringBuilder.append(this.cookieExpiryDate);
/* 367 */     stringBuilder.append("]");
/* 368 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicClientCookie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */