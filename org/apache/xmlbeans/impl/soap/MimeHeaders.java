/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MimeHeaders
/*     */ {
/*     */   protected Vector headers;
/*     */   
/*     */   class MatchingIterator
/*     */     implements Iterator
/*     */   {
/*     */     private boolean match;
/*     */     private Iterator iterator;
/*     */     private String[] names;
/*     */     private Object nextHeader;
/*     */     private final MimeHeaders this$0;
/*     */     
/*     */     private Object nextMatch() {
/*  41 */       label22: while (this.iterator.hasNext()) {
/*  42 */         MimeHeader mimeHeader = this.iterator.next();
/*     */         
/*  44 */         if (this.names == null) {
/*  45 */           return this.match ? null : mimeHeader;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  50 */         for (byte b = 0; b < this.names.length; ) {
/*  51 */           if (!mimeHeader.getName().equalsIgnoreCase(this.names[b])) {
/*     */             b++;
/*     */             continue;
/*     */           } 
/*  55 */           if (this.match) {
/*  56 */             return mimeHeader;
/*     */           }
/*     */           
/*     */           continue label22;
/*     */         } 
/*     */         
/*  62 */         if (!this.match) {
/*  63 */           return mimeHeader;
/*     */         }
/*     */       } 
/*     */       
/*  67 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/*  72 */       if (this.nextHeader == null) {
/*  73 */         this.nextHeader = nextMatch();
/*     */       }
/*     */       
/*  76 */       return (this.nextHeader != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public Object next() {
/*  81 */       if (this.nextHeader != null) {
/*  82 */         Object object = this.nextHeader;
/*     */         
/*  84 */         this.nextHeader = null;
/*     */         
/*  86 */         return object;
/*     */       } 
/*     */       
/*  89 */       if (hasNext()) {
/*  90 */         return this.nextHeader;
/*     */       }
/*  92 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/*  97 */       this.iterator.remove();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MatchingIterator(String[] param1ArrayOfString, boolean param1Boolean) {
/* 110 */       this.match = param1Boolean;
/* 111 */       this.names = param1ArrayOfString;
/* 112 */       this.iterator = MimeHeaders.this.headers.iterator();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MimeHeaders() {
/* 122 */     this.headers = new Vector();
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
/*     */   public String[] getHeader(String paramString) {
/* 136 */     Vector vector = new Vector();
/*     */     
/* 138 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 139 */       MimeHeader mimeHeader = this.headers.elementAt(b);
/*     */       
/* 141 */       if (mimeHeader.getName().equalsIgnoreCase(paramString) && mimeHeader.getValue() != null)
/*     */       {
/* 143 */         vector.addElement(mimeHeader.getValue());
/*     */       }
/*     */     } 
/*     */     
/* 147 */     if (vector.size() == 0) {
/* 148 */       return null;
/*     */     }
/* 150 */     String[] arrayOfString = new String[vector.size()];
/*     */     
/* 152 */     vector.copyInto((Object[])arrayOfString);
/*     */     
/* 154 */     return arrayOfString;
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
/*     */ 
/*     */   
/*     */   public void setHeader(String paramString1, String paramString2) {
/* 177 */     boolean bool = false;
/*     */     
/* 179 */     if (paramString1 == null || paramString1.equals("")) {
/* 180 */       throw new IllegalArgumentException("Illegal MimeHeader name");
/*     */     }
/*     */ 
/*     */     
/* 184 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 185 */       MimeHeader mimeHeader = this.headers.elementAt(b);
/*     */       
/* 187 */       if (mimeHeader.getName().equalsIgnoreCase(paramString1)) {
/* 188 */         if (!bool) {
/* 189 */           this.headers.setElementAt(new MimeHeader(mimeHeader.getName(), paramString2), b);
/*     */ 
/*     */           
/* 192 */           bool = true;
/*     */         } else {
/* 194 */           this.headers.removeElementAt(b--);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 199 */     if (!bool) {
/* 200 */       addHeader(paramString1, paramString2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addHeader(String paramString1, String paramString2) {
/* 221 */     if (paramString1 == null || paramString1.equals("")) {
/* 222 */       throw new IllegalArgumentException("Illegal MimeHeader name");
/*     */     }
/*     */ 
/*     */     
/* 226 */     int i = this.headers.size();
/*     */     
/* 228 */     for (int j = i - 1; j >= 0; j--) {
/* 229 */       MimeHeader mimeHeader = this.headers.elementAt(j);
/*     */       
/* 231 */       if (mimeHeader.getName().equalsIgnoreCase(paramString1)) {
/* 232 */         this.headers.insertElementAt(new MimeHeader(paramString1, paramString2), j + 1);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 238 */     this.headers.addElement(new MimeHeader(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeader(String paramString) {
/* 249 */     for (byte b = 0; b < this.headers.size(); b++) {
/* 250 */       MimeHeader mimeHeader = this.headers.elementAt(b);
/*     */       
/* 252 */       if (mimeHeader.getName().equalsIgnoreCase(paramString)) {
/* 253 */         this.headers.removeElementAt(b--);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllHeaders() {
/* 263 */     this.headers.removeAllElements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator getAllHeaders() {
/* 274 */     return this.headers.iterator();
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
/*     */   public Iterator getMatchingHeaders(String[] paramArrayOfString) {
/* 287 */     return new MatchingIterator(paramArrayOfString, true);
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
/*     */   public Iterator getNonMatchingHeaders(String[] paramArrayOfString) {
/* 300 */     return new MatchingIterator(paramArrayOfString, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\MimeHeaders.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */