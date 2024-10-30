/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LazyList<E>
/*     */   extends AbstractSerializableListDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -1708388017160694542L;
/*     */   private final Factory<? extends E> factory;
/*     */   
/*     */   public static <E> LazyList<E> lazyList(List<E> paramList, Factory<? extends E> paramFactory) {
/*  79 */     return new LazyList<E>(paramList, paramFactory);
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
/*     */   protected LazyList(List<E> paramList, Factory<? extends E> paramFactory) {
/*  91 */     super(paramList);
/*  92 */     if (paramFactory == null) {
/*  93 */       throw new IllegalArgumentException("Factory must not be null");
/*     */     }
/*  95 */     this.factory = paramFactory;
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
/*     */   public E get(int paramInt) {
/* 112 */     int i = decorated().size();
/* 113 */     if (paramInt < i) {
/*     */       
/* 115 */       E e = decorated().get(paramInt);
/* 116 */       if (e == null) {
/*     */         
/* 118 */         e = (E)this.factory.create();
/* 119 */         decorated().set(paramInt, e);
/* 120 */         return e;
/*     */       } 
/*     */       
/* 123 */       return e;
/*     */     } 
/*     */     
/* 126 */     for (int j = i; j < paramInt; j++) {
/* 127 */       decorated().add(null);
/*     */     }
/*     */     
/* 130 */     Object object = this.factory.create();
/* 131 */     decorated().add((E)object);
/* 132 */     return (E)object;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 137 */     List<E> list = decorated().subList(paramInt1, paramInt2);
/* 138 */     return new LazyList(list, this.factory);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\LazyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */