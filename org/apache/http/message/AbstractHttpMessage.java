/*     */ package org.apache.http.message;
/*     */ 
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.HttpMessage;
/*     */ import org.apache.http.params.BasicHttpParams;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractHttpMessage
/*     */   implements HttpMessage
/*     */ {
/*     */   protected HeaderGroup headergroup;
/*     */   @Deprecated
/*     */   protected HttpParams params;
/*     */   
/*     */   @Deprecated
/*     */   protected AbstractHttpMessage(HttpParams paramHttpParams) {
/*  59 */     this.headergroup = new HeaderGroup();
/*  60 */     this.params = paramHttpParams;
/*     */   }
/*     */   
/*     */   protected AbstractHttpMessage() {
/*  64 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsHeader(String paramString) {
/*  70 */     return this.headergroup.containsHeader(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header[] getHeaders(String paramString) {
/*  76 */     return this.headergroup.getHeaders(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header getFirstHeader(String paramString) {
/*  82 */     return this.headergroup.getFirstHeader(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header getLastHeader(String paramString) {
/*  88 */     return this.headergroup.getLastHeader(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Header[] getAllHeaders() {
/*  94 */     return this.headergroup.getAllHeaders();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeader(Header paramHeader) {
/* 100 */     this.headergroup.addHeader(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeader(String paramString1, String paramString2) {
/* 106 */     Args.notNull(paramString1, "Header name");
/* 107 */     this.headergroup.addHeader(new BasicHeader(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeader(Header paramHeader) {
/* 113 */     this.headergroup.updateHeader(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeader(String paramString1, String paramString2) {
/* 119 */     Args.notNull(paramString1, "Header name");
/* 120 */     this.headergroup.updateHeader(new BasicHeader(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaders(Header[] paramArrayOfHeader) {
/* 126 */     this.headergroup.setHeaders(paramArrayOfHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeader(Header paramHeader) {
/* 132 */     this.headergroup.removeHeader(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeaders(String paramString) {
/* 138 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 141 */     for (HeaderIterator headerIterator = this.headergroup.iterator(); headerIterator.hasNext(); ) {
/* 142 */       Header header = headerIterator.nextHeader();
/* 143 */       if (paramString.equalsIgnoreCase(header.getName())) {
/* 144 */         headerIterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderIterator headerIterator() {
/* 152 */     return this.headergroup.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderIterator headerIterator(String paramString) {
/* 158 */     return this.headergroup.iterator(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public HttpParams getParams() {
/* 167 */     if (this.params == null) {
/* 168 */       this.params = (HttpParams)new BasicHttpParams();
/*     */     }
/* 170 */     return this.params;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setParams(HttpParams paramHttpParams) {
/* 179 */     this.params = (HttpParams)Args.notNull(paramHttpParams, "HTTP parameters");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\AbstractHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */