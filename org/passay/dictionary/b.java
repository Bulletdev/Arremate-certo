/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class b
/*     */   implements k
/*     */ {
/*     */   protected Comparator<String> comparator;
/*     */   
/*     */   public Comparator<String> getComparator() {
/*  22 */     return this.comparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<String> iterator() {
/*  29 */     return new c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<String> p() {
/*  36 */     return new b();
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
/*     */   protected void bz(int paramInt) {
/*  48 */     if (paramInt < 0 || paramInt >= size()) {
/*  49 */       throw new IndexOutOfBoundsException("Supplied index (" + paramInt + ") does not exist");
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
/*     */   protected void J(Object paramObject) {
/*  61 */     if (!String.class.isInstance(paramObject)) {
/*  62 */       throw new ClassCastException("Parameter must be of type String");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class a
/*     */     implements Iterator<String>
/*     */   {
/*     */     protected int index;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(b this$0) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/*  82 */       throw new UnsupportedOperationException("Remove not supported.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class c
/*     */     extends a
/*     */   {
/*     */     private c(b this$0) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 100 */       return (this.index < this.a.size());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String next() {
/* 107 */       return this.a.get(this.index++);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class b
/*     */     extends a
/*     */   {
/*     */     private final int jf;
/*     */ 
/*     */     
/*     */     private int jg;
/*     */ 
/*     */     
/*     */     private b(b this$0) {
/* 123 */       this.jf = this.a.size() / 2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/*     */       boolean bool;
/* 132 */       int i = this.a.size();
/*     */       
/* 134 */       if (this.jg > 0) {
/* 135 */         bool = (this.jf + this.index < i) ? true : false;
/* 136 */       } else if (this.jg < 0) {
/* 137 */         bool = (this.jf - this.index >= 0) ? true : false;
/*     */       } else {
/* 139 */         bool = (i > 0) ? true : false;
/*     */       } 
/* 141 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String next() {
/*     */       String str;
/* 149 */       if (this.jg > 0) {
/* 150 */         str = this.a.get(this.jf + this.index);
/* 151 */         this.jg = -1;
/* 152 */         this.index++;
/* 153 */       } else if (this.jg < 0) {
/* 154 */         str = this.a.get(this.jf - this.index);
/* 155 */         this.jg = 1;
/*     */       } else {
/* 157 */         str = this.a.get(this.jf);
/* 158 */         this.jg = -1;
/* 159 */         this.index = 1;
/*     */       } 
/* 161 */       return str;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */