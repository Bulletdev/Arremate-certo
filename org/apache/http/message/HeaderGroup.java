/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeaderGroup
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 2608834160639271617L;
/*  52 */   private static final Header[] EMPTY = new Header[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   private final List<Header> headers = new ArrayList<Header>(16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  68 */     this.headers.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeader(Header paramHeader) {
/*  78 */     if (paramHeader == null) {
/*     */       return;
/*     */     }
/*  81 */     this.headers.add(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeader(Header paramHeader) {
/*  90 */     if (paramHeader == null) {
/*     */       return;
/*     */     }
/*  93 */     this.headers.remove(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateHeader(Header paramHeader) {
/* 104 */     if (paramHeader == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 110 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 111 */       Header header = this.headers.get(b);
/* 112 */       if (header.getName().equalsIgnoreCase(paramHeader.getName())) {
/* 113 */         this.headers.set(b, paramHeader);
/*     */         return;
/*     */       } 
/*     */     } 
/* 117 */     this.headers.add(paramHeader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaders(Header[] paramArrayOfHeader) {
/* 128 */     clear();
/* 129 */     if (paramArrayOfHeader == null) {
/*     */       return;
/*     */     }
/* 132 */     Collections.addAll(this.headers, paramArrayOfHeader);
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
/*     */   public Header getCondensedHeader(String paramString) {
/* 147 */     Header[] arrayOfHeader = getHeaders(paramString);
/*     */     
/* 149 */     if (arrayOfHeader.length == 0)
/* 150 */       return null; 
/* 151 */     if (arrayOfHeader.length == 1) {
/* 152 */       return arrayOfHeader[0];
/*     */     }
/* 154 */     CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
/* 155 */     charArrayBuffer.append(arrayOfHeader[0].getValue());
/* 156 */     for (byte b = 1; b < arrayOfHeader.length; b++) {
/* 157 */       charArrayBuffer.append(", ");
/* 158 */       charArrayBuffer.append(arrayOfHeader[b].getValue());
/*     */     } 
/*     */     
/* 161 */     return new BasicHeader(paramString.toLowerCase(Locale.ROOT), charArrayBuffer.toString());
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
/*     */   public Header[] getHeaders(String paramString) {
/* 176 */     ArrayList<Header> arrayList = null;
/*     */ 
/*     */ 
/*     */     
/* 180 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 181 */       Header header = this.headers.get(b);
/* 182 */       if (header.getName().equalsIgnoreCase(paramString)) {
/* 183 */         if (arrayList == null) {
/* 184 */           arrayList = new ArrayList();
/*     */         }
/* 186 */         arrayList.add(header);
/*     */       } 
/*     */     } 
/* 189 */     return (arrayList != null) ? arrayList.<Header>toArray(new Header[arrayList.size()]) : EMPTY;
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
/*     */   public Header getFirstHeader(String paramString) {
/* 204 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 205 */       Header header = this.headers.get(b);
/* 206 */       if (header.getName().equalsIgnoreCase(paramString)) {
/* 207 */         return header;
/*     */       }
/*     */     } 
/* 210 */     return null;
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
/*     */   public Header getLastHeader(String paramString) {
/* 223 */     for (int i = this.headers.size() - 1; i >= 0; i--) {
/* 224 */       Header header = this.headers.get(i);
/* 225 */       if (header.getName().equalsIgnoreCase(paramString)) {
/* 226 */         return header;
/*     */       }
/*     */     } 
/*     */     
/* 230 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Header[] getAllHeaders() {
/* 239 */     return this.headers.<Header>toArray(new Header[this.headers.size()]);
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
/*     */   public boolean containsHeader(String paramString) {
/* 255 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 256 */       Header header = this.headers.get(b);
/* 257 */       if (header.getName().equalsIgnoreCase(paramString)) {
/* 258 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 262 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderIterator iterator() {
/* 273 */     return new BasicListHeaderIterator(this.headers, null);
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
/*     */   public HeaderIterator iterator(String paramString) {
/* 287 */     return new BasicListHeaderIterator(this.headers, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderGroup copy() {
/* 298 */     HeaderGroup headerGroup = new HeaderGroup();
/* 299 */     headerGroup.headers.addAll(this.headers);
/* 300 */     return headerGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 305 */     return super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 310 */     return this.headers.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\HeaderGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */