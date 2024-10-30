/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.ObjIntConsumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ abstract class f<E>
/*     */   extends i<E>
/*     */   implements Serializable
/*     */ {
/*     */   private transient Map<E, S> H;
/*     */   private transient long size;
/*     */   @c
/*     */   private static final long serialVersionUID = -2250766705698539974L;
/*     */   
/*     */   protected f(Map<E, S> paramMap) {
/*  60 */     D.checkArgument(paramMap.isEmpty());
/*  61 */     this.H = paramMap;
/*     */   }
/*     */ 
/*     */   
/*     */   void e(Map<E, S> paramMap) {
/*  66 */     this.H = paramMap;
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
/*     */   public Set<cc.a<E>> entrySet() {
/*  80 */     return super.entrySet();
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<E> e() {
/*  85 */     Iterator iterator = this.H.entrySet().iterator();
/*  86 */     return new Iterator<E>(this, iterator)
/*     */       {
/*     */         Map.Entry<E, S> b;
/*     */         
/*     */         public boolean hasNext() {
/*  91 */           return this.e.hasNext();
/*     */         }
/*     */ 
/*     */         
/*     */         public E next() {
/*  96 */           Map.Entry<E, S> entry = this.e.next();
/*  97 */           this.b = entry;
/*  98 */           return entry.getKey();
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 103 */           C.ad((this.b != null));
/* 104 */           f.a(this.a, ((S)this.b.getValue()).n(0));
/* 105 */           this.e.remove();
/* 106 */           this.b = null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<cc.a<E>> c() {
/* 113 */     Iterator iterator = this.H.entrySet().iterator();
/* 114 */     return (Iterator)new Iterator<cc.a<cc.a<E>>>(this, iterator)
/*     */       {
/*     */         Map.Entry<E, S> b;
/*     */         
/*     */         public boolean hasNext() {
/* 119 */           return this.e.hasNext();
/*     */         }
/*     */ 
/*     */         
/*     */         public cc.a<E> a() {
/* 124 */           final Map.Entry<E, S> mapEntry = this.e.next();
/* 125 */           this.b = entry;
/* 126 */           return new cd.a<E>(this)
/*     */             {
/*     */               public E getElement() {
/* 129 */                 return (E)mapEntry.getKey();
/*     */               }
/*     */ 
/*     */               
/*     */               public int getCount() {
/* 134 */                 S s = (S)mapEntry.getValue();
/* 135 */                 if (s == null || s.get() == 0) {
/* 136 */                   S s1 = (S)f.a(this.a.a).get(getElement());
/* 137 */                   if (s1 != null) {
/* 138 */                     return s1.get();
/*     */                   }
/*     */                 } 
/* 141 */                 return (s == null) ? 0 : s.get();
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 148 */           C.ad((this.b != null));
/* 149 */           f.a(this.a, ((S)this.b.getValue()).n(0));
/* 150 */           this.e.remove();
/* 151 */           this.b = null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ObjIntConsumer<? super E> paramObjIntConsumer) {
/* 158 */     D.checkNotNull(paramObjIntConsumer);
/* 159 */     this.H.forEach((paramObject, paramS) -> paramObjIntConsumer.accept(paramObject, paramS.get()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 164 */     for (S s : this.H.values()) {
/* 165 */       s.set(0);
/*     */     }
/* 167 */     this.H.clear();
/* 168 */     this.size = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   int ah() {
/* 173 */     return this.H.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 180 */     return k.e(this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 185 */     return new a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private class a
/*     */     implements Iterator<E>
/*     */   {
/*     */     final Iterator<Map.Entry<E, S>> entryIterator;
/*     */     
/*     */     Map.Entry<E, S> c;
/*     */     
/*     */     int dS;
/*     */     boolean canRemove;
/*     */     
/*     */     a(f this$0) {
/* 200 */       this.entryIterator = f.a(this$0).entrySet().iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 205 */       return (this.dS > 0 || this.entryIterator.hasNext());
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 210 */       if (this.dS == 0) {
/* 211 */         this.c = this.entryIterator.next();
/* 212 */         this.dS = ((S)this.c.getValue()).get();
/*     */       } 
/* 214 */       this.dS--;
/* 215 */       this.canRemove = true;
/* 216 */       return this.c.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 221 */       C.ad(this.canRemove);
/* 222 */       int i = ((S)this.c.getValue()).get();
/* 223 */       if (i <= 0) {
/* 224 */         throw new ConcurrentModificationException();
/*     */       }
/* 226 */       if (((S)this.c.getValue()).addAndGet(-1) == 0) {
/* 227 */         this.entryIterator.remove();
/*     */       }
/* 229 */       f.a(this.a);
/* 230 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int b(Object paramObject) {
/* 236 */     S s = bW.<S>a(this.H, paramObject);
/* 237 */     return (s == null) ? 0 : s.get();
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
/*     */   @com.google.b.a.a
/*     */   public int add(E paramE, int paramInt) {
/*     */     int j;
/* 251 */     if (paramInt == 0) {
/* 252 */       return b(paramE);
/*     */     }
/* 254 */     D.a((paramInt > 0), "occurrences cannot be negative: %s", paramInt);
/* 255 */     S s = this.H.get(paramE);
/*     */     
/* 257 */     if (s == null) {
/* 258 */       j = 0;
/* 259 */       this.H.put(paramE, new S(paramInt));
/*     */     } else {
/* 261 */       j = s.get();
/* 262 */       long l = j + paramInt;
/* 263 */       D.a((l <= 2147483647L), "too many occurrences: %s", l);
/* 264 */       s.add(paramInt);
/*     */     } 
/* 266 */     this.size += paramInt;
/* 267 */     return j;
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int remove(Object paramObject, int paramInt) {
/*     */     int k;
/* 273 */     if (paramInt == 0) {
/* 274 */       return b(paramObject);
/*     */     }
/* 276 */     D.a((paramInt > 0), "occurrences cannot be negative: %s", paramInt);
/* 277 */     S s = this.H.get(paramObject);
/* 278 */     if (s == null) {
/* 279 */       return 0;
/*     */     }
/*     */     
/* 282 */     int j = s.get();
/*     */ 
/*     */     
/* 285 */     if (j > paramInt) {
/* 286 */       k = paramInt;
/*     */     } else {
/* 288 */       k = j;
/* 289 */       this.H.remove(paramObject);
/*     */     } 
/*     */     
/* 292 */     s.add(-k);
/* 293 */     this.size -= k;
/* 294 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int setCount(E paramE, int paramInt) {
/*     */     int j;
/* 301 */     C.b(paramInt, "count");
/*     */ 
/*     */ 
/*     */     
/* 305 */     if (paramInt == 0) {
/* 306 */       S s = this.H.remove(paramE);
/* 307 */       j = a(s, paramInt);
/*     */     } else {
/* 309 */       S s = this.H.get(paramE);
/* 310 */       j = a(s, paramInt);
/*     */       
/* 312 */       if (s == null) {
/* 313 */         this.H.put(paramE, new S(paramInt));
/*     */       }
/*     */     } 
/*     */     
/* 317 */     this.size += (paramInt - j);
/* 318 */     return j;
/*     */   }
/*     */   
/*     */   private static int a(S paramS, int paramInt) {
/* 322 */     if (paramS == null) {
/* 323 */       return 0;
/*     */     }
/*     */     
/* 326 */     return paramS.n(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   private void readObjectNoData() throws ObjectStreamException {
/* 332 */     throw new InvalidObjectException("Stream data required");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */