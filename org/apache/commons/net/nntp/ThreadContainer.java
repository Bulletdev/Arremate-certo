/*     */ package org.apache.commons.net.nntp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ThreadContainer
/*     */ {
/*     */   Threadable threadable;
/*     */   ThreadContainer parent;
/*     */   ThreadContainer next;
/*     */   ThreadContainer child;
/*     */   
/*     */   boolean findChild(ThreadContainer paramThreadContainer) {
/*  40 */     if (this.child == null)
/*  41 */       return false; 
/*  42 */     if (this.child == paramThreadContainer) {
/*  43 */       return true;
/*     */     }
/*  45 */     return this.child.findChild(paramThreadContainer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void flush() {
/*  54 */     if (this.parent != null && this.threadable == null) {
/*  55 */       throw new RuntimeException("no threadable in " + toString());
/*     */     }
/*     */     
/*  58 */     this.parent = null;
/*     */     
/*  60 */     if (this.threadable != null) {
/*  61 */       this.threadable.setChild((this.child == null) ? null : this.child.threadable);
/*     */     }
/*     */     
/*  64 */     if (this.child != null) {
/*  65 */       this.child.flush();
/*  66 */       this.child = null;
/*     */     } 
/*     */     
/*  69 */     if (this.threadable != null) {
/*  70 */       this.threadable.setNext((this.next == null) ? null : this.next.threadable);
/*     */     }
/*     */     
/*  73 */     if (this.next != null) {
/*  74 */       this.next.flush();
/*  75 */       this.next = null;
/*     */     } 
/*     */     
/*  78 */     this.threadable = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void reverseChildren() {
/*  86 */     if (this.child != null) {
/*     */       
/*  88 */       ThreadContainer threadContainer2 = null, threadContainer1 = this.child, threadContainer3 = threadContainer1.next;
/*  89 */       for (; threadContainer1 != null; 
/*  90 */         threadContainer2 = threadContainer1, 
/*  91 */         threadContainer1 = threadContainer3, 
/*  92 */         threadContainer3 = (threadContainer3 == null) ? null : threadContainer3.next)
/*     */       {
/*  94 */         threadContainer1.next = threadContainer2;
/*     */       }
/*     */       
/*  97 */       this.child = threadContainer2;
/*     */ 
/*     */       
/* 100 */       for (threadContainer1 = this.child; threadContainer1 != null; threadContainer1 = threadContainer1.next)
/* 101 */         threadContainer1.reverseChildren(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\ThreadContainer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */