/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HeaderIterator;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicListHeaderIterator
/*     */   implements HeaderIterator
/*     */ {
/*     */   protected final List<Header> allHeaders;
/*     */   protected int currentIndex;
/*     */   protected int lastIndex;
/*     */   protected String headerName;
/*     */   
/*     */   public BasicListHeaderIterator(List<Header> paramList, String paramString) {
/*  84 */     this.allHeaders = (List<Header>)Args.notNull(paramList, "Header list");
/*  85 */     this.headerName = paramString;
/*  86 */     this.currentIndex = findNext(-1);
/*  87 */     this.lastIndex = -1;
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
/* 101 */     int i = paramInt;
/* 102 */     if (i < -1) {
/* 103 */       return -1;
/*     */     }
/*     */     
/* 106 */     int j = this.allHeaders.size() - 1;
/* 107 */     boolean bool = false;
/* 108 */     while (!bool && i < j) {
/* 109 */       i++;
/* 110 */       bool = filterHeader(i);
/*     */     } 
/* 112 */     return bool ? i : -1;
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
/* 125 */     if (this.headerName == null) {
/* 126 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 130 */     String str = ((Header)this.allHeaders.get(paramInt)).getName();
/*     */     
/* 132 */     return this.headerName.equalsIgnoreCase(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 139 */     return (this.currentIndex >= 0);
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
/* 154 */     int i = this.currentIndex;
/* 155 */     if (i < 0) {
/* 156 */       throw new NoSuchElementException("Iteration already finished.");
/*     */     }
/*     */     
/* 159 */     this.lastIndex = i;
/* 160 */     this.currentIndex = findNext(i);
/*     */     
/* 162 */     return this.allHeaders.get(i);
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
/* 177 */     return nextHeader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() throws UnsupportedOperationException {
/* 187 */     Asserts.check((this.lastIndex >= 0), "No header to remove");
/* 188 */     this.allHeaders.remove(this.lastIndex);
/* 189 */     this.lastIndex = -1;
/* 190 */     this.currentIndex--;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicListHeaderIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */