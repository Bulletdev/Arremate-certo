/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicHeaderIterator
/*     */   implements HeaderIterator
/*     */ {
/*     */   protected final Header[] allHeaders;
/*     */   protected int currentIndex;
/*     */   protected String headerName;
/*     */   
/*     */   public BasicHeaderIterator(Header[] paramArrayOfHeader, String paramString) {
/*  76 */     this.allHeaders = (Header[])Args.notNull(paramArrayOfHeader, "Header array");
/*  77 */     this.headerName = paramString;
/*  78 */     this.currentIndex = findNext(-1);
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
/*     */   protected int findNext(int paramInt) {
/*  92 */     int i = paramInt;
/*  93 */     if (i < -1) {
/*  94 */       return -1;
/*     */     }
/*     */     
/*  97 */     int j = this.allHeaders.length - 1;
/*  98 */     boolean bool = false;
/*  99 */     while (!bool && i < j) {
/* 100 */       i++;
/* 101 */       bool = filterHeader(i);
/*     */     } 
/* 103 */     return bool ? i : -1;
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
/*     */   protected boolean filterHeader(int paramInt) {
/* 116 */     return (this.headerName == null || this.headerName.equalsIgnoreCase(this.allHeaders[paramInt].getName()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 124 */     return (this.currentIndex >= 0);
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
/*     */   public Header nextHeader() throws NoSuchElementException {
/* 139 */     int i = this.currentIndex;
/* 140 */     if (i < 0) {
/* 141 */       throw new NoSuchElementException("Iteration already finished.");
/*     */     }
/*     */     
/* 144 */     this.currentIndex = findNext(i);
/*     */     
/* 146 */     return this.allHeaders[i];
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
/*     */   public final Object next() throws NoSuchElementException {
/* 161 */     return nextHeader();
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
/*     */   public void remove() throws UnsupportedOperationException {
/* 174 */     throw new UnsupportedOperationException("Removing headers is not supported.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHeaderIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */