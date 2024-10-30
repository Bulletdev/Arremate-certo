/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ final class cz<E>
/*     */   extends bA<E>
/*     */ {
/*  43 */   static final cz<Comparable> c = new cz(
/*  44 */       bh.e(), cj.e());
/*     */   
/*     */   private final transient bh<E> o;
/*     */   
/*     */   cz(bh<E> parambh, Comparator<? super E> paramComparator) {
/*  49 */     super(paramComparator);
/*  50 */     this.o = parambh;
/*     */   }
/*     */ 
/*     */   
/*     */   Object[] d() {
/*  55 */     return this.o.d();
/*     */   }
/*     */ 
/*     */   
/*     */   int ap() {
/*  60 */     return this.o.ap();
/*     */   }
/*     */ 
/*     */   
/*     */   int aq() {
/*  65 */     return this.o.aq();
/*     */   }
/*     */ 
/*     */   
/*     */   public dj<E> b() {
/*  70 */     return this.o.b();
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   public dj<E> c() {
/*  76 */     return this.o.f().b();
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<E> spliterator() {
/*  81 */     return c().spliterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super E> paramConsumer) {
/*  86 */     this.o.forEach(paramConsumer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  91 */     return this.o.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*     */     try {
/*  97 */       return (paramObject != null && l(paramObject) >= 0);
/*  98 */     } catch (ClassCastException classCastException) {
/*  99 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 109 */     if (paramCollection instanceof cc) {
/* 110 */       paramCollection = ((cc)paramCollection).d();
/*     */     }
/* 112 */     if (!cM.a(comparator(), paramCollection) || paramCollection.size() <= 1) {
/* 113 */       return super.containsAll(paramCollection);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     dj<E> dj = b();
/*     */     
/* 122 */     Iterator<?> iterator = paramCollection.iterator();
/*     */ 
/*     */     
/* 125 */     if (!dj.hasNext()) {
/* 126 */       return false;
/*     */     }
/*     */     
/* 129 */     Object object = iterator.next();
/* 130 */     E e = dj.next();
/*     */     try {
/*     */       while (true) {
/* 133 */         int i = b(e, object);
/*     */         
/* 135 */         if (i < 0) {
/* 136 */           if (!dj.hasNext()) {
/* 137 */             return false;
/*     */           }
/* 139 */           e = dj.next(); continue;
/* 140 */         }  if (i == 0) {
/* 141 */           if (!iterator.hasNext()) {
/* 142 */             return true;
/*     */           }
/* 144 */           object = iterator.next(); continue;
/*     */         } 
/* 146 */         if (i > 0) {
/* 147 */           return false;
/*     */         }
/*     */       } 
/* 150 */     } catch (NullPointerException|ClassCastException nullPointerException) {
/* 151 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private int l(Object paramObject) throws ClassCastException {
/* 156 */     return Collections.binarySearch(this.o, (E)paramObject, (Comparator)a());
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 161 */     return this.o.cO();
/*     */   }
/*     */ 
/*     */   
/*     */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 166 */     return this.o.a(paramArrayOfObject, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 171 */     if (paramObject == this) {
/* 172 */       return true;
/*     */     }
/* 174 */     if (!(paramObject instanceof Set)) {
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     Set<?> set = (Set)paramObject;
/* 179 */     if (size() != set.size())
/* 180 */       return false; 
/* 181 */     if (isEmpty()) {
/* 182 */       return true;
/*     */     }
/*     */     
/* 185 */     if (cM.a(this.comparator, set)) {
/* 186 */       Iterator<?> iterator = set.iterator();
/*     */       try {
/* 188 */         dj<E> dj = b();
/* 189 */         while (dj.hasNext()) {
/* 190 */           E e = dj.next();
/* 191 */           Object object = iterator.next();
/* 192 */           if (object == null || b(e, object) != 0) {
/* 193 */             return false;
/*     */           }
/*     */         } 
/* 196 */         return true;
/* 197 */       } catch (ClassCastException classCastException) {
/* 198 */         return false;
/* 199 */       } catch (NoSuchElementException noSuchElementException) {
/* 200 */         return false;
/*     */       } 
/*     */     } 
/* 203 */     return containsAll(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public E first() {
/* 208 */     if (isEmpty()) {
/* 209 */       throw new NoSuchElementException();
/*     */     }
/* 211 */     return this.o.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public E last() {
/* 216 */     if (isEmpty()) {
/* 217 */       throw new NoSuchElementException();
/*     */     }
/* 219 */     return this.o.get(size() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public E lower(E paramE) {
/* 224 */     int i = a(paramE, false) - 1;
/* 225 */     return (i == -1) ? null : this.o.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public E floor(E paramE) {
/* 230 */     int i = a(paramE, true) - 1;
/* 231 */     return (i == -1) ? null : this.o.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public E ceiling(E paramE) {
/* 236 */     int i = b(paramE, true);
/* 237 */     return (i == size()) ? null : this.o.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public E higher(E paramE) {
/* 242 */     int i = b(paramE, false);
/* 243 */     return (i == size()) ? null : this.o.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   bA<E> b(E paramE, boolean paramBoolean) {
/* 248 */     return a(0, a(paramE, paramBoolean));
/*     */   }
/*     */   
/*     */   int a(E paramE, boolean paramBoolean) {
/* 252 */     int i = Collections.binarySearch(this.o, (E)D.checkNotNull(paramE), comparator());
/* 253 */     if (i >= 0) {
/* 254 */       return paramBoolean ? (i + 1) : i;
/*     */     }
/* 256 */     return i ^ 0xFFFFFFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   bA<E> a(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
/* 263 */     return a(paramE1, paramBoolean1).b(paramE2, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   bA<E> a(E paramE, boolean paramBoolean) {
/* 268 */     return a(b(paramE, paramBoolean), size());
/*     */   }
/*     */   
/*     */   int b(E paramE, boolean paramBoolean) {
/* 272 */     int i = Collections.binarySearch(this.o, (E)D.checkNotNull(paramE), comparator());
/* 273 */     if (i >= 0) {
/* 274 */       return paramBoolean ? i : (i + 1);
/*     */     }
/* 276 */     return i ^ 0xFFFFFFFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Comparator<Object> a() {
/* 285 */     return (Comparator)this.comparator;
/*     */   }
/*     */   
/*     */   cz<E> a(int paramInt1, int paramInt2) {
/* 289 */     if (paramInt1 == 0 && paramInt2 == size())
/* 290 */       return this; 
/* 291 */     if (paramInt1 < paramInt2) {
/* 292 */       return new cz(this.o
/* 293 */           .a(paramInt1, paramInt2), this.comparator);
/*     */     }
/* 295 */     return a(this.comparator);
/*     */   }
/*     */ 
/*     */   
/*     */   int indexOf(Object paramObject) {
/*     */     int i;
/* 301 */     if (paramObject == null) {
/* 302 */       return -1;
/*     */     }
/*     */     
/*     */     try {
/* 306 */       i = Collections.binarySearch(this.o, (E)paramObject, (Comparator)a());
/* 307 */     } catch (ClassCastException classCastException) {
/* 308 */       return -1;
/*     */     } 
/* 310 */     return (i >= 0) ? i : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   bh<E> h() {
/* 315 */     return (size() <= 1) ? this.o : new bv<>(this, this.o);
/*     */   }
/*     */ 
/*     */   
/*     */   bA<E> a() {
/* 320 */     Comparator<? super E> comparator = Collections.reverseOrder(this.comparator);
/* 321 */     return isEmpty() ? 
/* 322 */       a(comparator) : 
/* 323 */       new cz(this.o.f(), comparator);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cz.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */