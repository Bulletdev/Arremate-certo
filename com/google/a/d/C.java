/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public abstract class c<T>
/*     */   extends dj<T>
/*     */ {
/*  65 */   private a a = a.c;
/*     */   private T next;
/*     */   
/*     */   protected abstract T b();
/*     */   
/*     */   private enum a
/*     */   {
/*  72 */     b,
/*     */ 
/*     */     
/*  75 */     c,
/*     */ 
/*     */     
/*  78 */     d,
/*     */ 
/*     */     
/*  81 */     e;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   protected final T c() {
/* 121 */     this.a = a.d;
/* 122 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final boolean hasNext() {
/* 128 */     D.ab((this.a != a.e));
/* 129 */     switch (null.B[this.a.ordinal()]) {
/*     */       case 1:
/* 131 */         return false;
/*     */       case 2:
/* 133 */         return true;
/*     */     } 
/*     */     
/* 136 */     return cn();
/*     */   }
/*     */   
/*     */   private boolean cn() {
/* 140 */     this.a = a.e;
/* 141 */     this.next = b();
/* 142 */     if (this.a != a.d) {
/* 143 */       this.a = a.b;
/* 144 */       return true;
/*     */     } 
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final T next() {
/* 152 */     if (!hasNext()) {
/* 153 */       throw new NoSuchElementException();
/*     */     }
/* 155 */     this.a = a.c;
/* 156 */     T t = this.next;
/* 157 */     this.next = null;
/* 158 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T peek() {
/* 169 */     if (!hasNext()) {
/* 170 */       throw new NoSuchElementException();
/*     */     }
/* 172 */     return this.next;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */