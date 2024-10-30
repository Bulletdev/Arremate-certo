/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a.b;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ final class bg<E extends Enum<E>>
/*     */   extends bt<E>
/*     */ {
/*     */   private final transient EnumSet<E> a;
/*     */   @b
/*     */   private transient int hashCode;
/*     */   
/*     */   static bt a(EnumSet<?> paramEnumSet) {
/*  37 */     switch (paramEnumSet.size()) {
/*     */       case 0:
/*  39 */         return bt.n();
/*     */       case 1:
/*  41 */         return bt.b(bG.a(paramEnumSet));
/*     */     } 
/*  43 */     return new bg(paramEnumSet);
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
/*     */   private bg(EnumSet<E> paramEnumSet) {
/*  58 */     this.a = paramEnumSet;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public dj<E> b() {
/*  68 */     return bH.a(this.a.iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<E> spliterator() {
/*  73 */     return this.a.spliterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super E> paramConsumer) {
/*  78 */     this.a.forEach(paramConsumer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  83 */     return this.a.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  88 */     return this.a.contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/*  93 */     if (paramCollection instanceof bg) {
/*  94 */       paramCollection = ((bg)paramCollection).a;
/*     */     }
/*  96 */     return this.a.containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 101 */     return this.a.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object<E> paramObject) {
/* 106 */     if (paramObject == this) {
/* 107 */       return true;
/*     */     }
/* 109 */     if (paramObject instanceof bg) {
/* 110 */       paramObject = (Object<E>)((bg)paramObject).a;
/*     */     }
/* 112 */     return this.a.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cR() {
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 124 */     int i = this.hashCode;
/* 125 */     return (i == 0) ? (this.hashCode = this.a.hashCode()) : i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     return this.a.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 136 */     return new a<>(this.a);
/*     */   }
/*     */   
/*     */   private static class a<E extends Enum<E>>
/*     */     implements Serializable
/*     */   {
/*     */     final EnumSet<E> a;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(EnumSet<E> param1EnumSet) {
/* 146 */       this.a = param1EnumSet;
/*     */     }
/*     */ 
/*     */     
/*     */     Object readResolve() {
/* 151 */       return new bg<>(this.a.clone());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */