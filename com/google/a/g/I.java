/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.c;
/*     */ import com.google.a.d.dj;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class i<N, V>
/*     */   implements u<N, V>
/*     */ {
/*     */   private static final class b
/*     */   {
/*     */     private final Object ai;
/*     */     
/*     */     b(Object param1Object) {
/*  62 */       this.ai = param1Object;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class a<N>
/*     */   {
/*     */     final N ah;
/*     */ 
/*     */ 
/*     */     
/*     */     a(N param1N) {
/*  76 */       this.ah = (N)D.checkNotNull(param1N);
/*     */     }
/*     */     
/*     */     static final class a<N> extends a<N> {
/*     */       a(N param2N) {
/*  81 */         super(param2N);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(Object param2Object) {
/*  86 */         if (param2Object instanceof a) {
/*  87 */           return this.ah.equals(((a)param2Object).ah);
/*     */         }
/*  89 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode() {
/*  96 */         return a.class.hashCode() + this.ah.hashCode();
/*     */       }
/*     */     }
/*     */     
/*     */     static final class b<N> extends a<N> {
/*     */       b(N param2N) {
/* 102 */         super(param2N);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean equals(Object param2Object) {
/* 107 */         if (param2Object instanceof b) {
/* 108 */           return this.ah.equals(((b)param2Object).ah);
/*     */         }
/* 110 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int hashCode()
/*     */       {
/* 117 */         return b.class.hashCode() + this.ah.hashCode(); } } } static final class a<N> extends a<N> { a(N param1N) { super(param1N); } public boolean equals(Object param1Object) { if (param1Object instanceof a) return this.ah.equals(((a)param1Object).ah);  return false; } public int hashCode() { return a.class.hashCode() + this.ah.hashCode(); } } static final class b<N> extends a<N> { public int hashCode() { return b.class.hashCode() + this.ah.hashCode(); } b(N param1N) { super(param1N); } public boolean equals(Object param1Object) {
/*     */       if (param1Object instanceof b)
/*     */         return this.ah.equals(((b)param1Object).ah); 
/*     */       return false;
/*     */     } }
/* 122 */    private static final Object af = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Map<N, Object> ac;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<a<N>> U;
/*     */ 
/*     */ 
/*     */   
/*     */   private int fp;
/*     */ 
/*     */ 
/*     */   
/*     */   private int fq;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i(Map<N, Object> paramMap, List<a<N>> paramList, int paramInt1, int paramInt2) {
/* 146 */     this.ac = (Map<N, Object>)D.checkNotNull(paramMap);
/* 147 */     this.U = paramList;
/* 148 */     this.fp = w.F(paramInt1);
/* 149 */     this.fq = w.F(paramInt2);
/* 150 */     D.ab((paramInt1 <= paramMap
/* 151 */         .size() && paramInt2 <= paramMap
/* 152 */         .size()));
/*     */   }
/*     */   
/*     */   static <N, V> i<N, V> a(m<N> paramm) {
/*     */     List<a<N>> list;
/* 157 */     byte b = 4;
/*     */ 
/*     */     
/* 160 */     switch (null.Q[paramm.a().ordinal()]) {
/*     */       case 1:
/* 162 */         list = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 171 */         return new i<>(new HashMap<>(b, 1.0F), list, 0, 0);case 2: list = new ArrayList(); return new i<>(new HashMap<>(b, 1.0F), list, 0, 0);
/*     */     } 
/*     */     throw new AssertionError(paramm.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <N, V> i<N, V> a(N paramN, Iterable<n<N>> paramIterable, s<N, V> params) {
/* 180 */     D.checkNotNull(paramN);
/* 181 */     D.checkNotNull(params);
/*     */     
/* 183 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 185 */     bh.a a = bh.a();
/* 186 */     byte b1 = 0;
/* 187 */     byte b2 = 0;
/*     */     
/* 189 */     for (n<N> n : paramIterable) {
/* 190 */       if (n.D().equals(paramN) && n.E().equals(paramN)) {
/*     */ 
/*     */         
/* 193 */         hashMap.put(paramN, new b(params.apply(paramN)));
/*     */         
/* 195 */         a.a(new a.a<>(paramN));
/* 196 */         a.a(new a.b<>(paramN));
/* 197 */         b1++;
/* 198 */         b2++; continue;
/* 199 */       }  if (n.E().equals(paramN)) {
/* 200 */         N n2 = n.D();
/*     */         
/* 202 */         Object object = hashMap.put(n2, af);
/* 203 */         if (object != null) {
/* 204 */           hashMap.put(n2, new b(object));
/*     */         }
/*     */         
/* 207 */         a.a(new a.a<>(n2));
/* 208 */         b1++; continue;
/*     */       } 
/* 210 */       D.checkArgument(n.D().equals(paramN));
/*     */       
/* 212 */       N n1 = n.E();
/* 213 */       Object object1 = params.apply(n1);
/*     */       
/* 215 */       Object object2 = hashMap.put(n1, object1);
/* 216 */       if (object2 != null) {
/* 217 */         D.checkArgument((object2 == af));
/* 218 */         hashMap.put(n1, new b(object1));
/*     */       } 
/*     */       
/* 221 */       a.a(new a.b<>(n1));
/* 222 */       b2++;
/*     */     } 
/*     */ 
/*     */     
/* 226 */     return new i<>((Map)hashMap, (List<a<N>>)a
/*     */         
/* 228 */         .g(), b1, b2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<N> w() {
/* 235 */     if (this.U == null) {
/* 236 */       return Collections.unmodifiableSet(this.ac.keySet());
/*     */     }
/* 238 */     return new AbstractSet<N>(this)
/*     */       {
/*     */         public dj<N> b() {
/* 241 */           Iterator iterator = i.a(this.a).iterator();
/* 242 */           HashSet hashSet = new HashSet();
/* 243 */           return (dj<N>)new c<N>(this, iterator, hashSet)
/*     */             {
/*     */               protected N b() {
/* 246 */                 while (this.K.hasNext()) {
/* 247 */                   i.a a = this.K.next();
/* 248 */                   boolean bool = this.x.add(a.ah);
/* 249 */                   if (bool) {
/* 250 */                     return a.ah;
/*     */                   }
/*     */                 } 
/* 253 */                 return (N)c();
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 260 */           return i.a(this.a).size();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean contains(Object param1Object) {
/* 265 */           return i.a(this.a).containsKey(param1Object);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<N> B() {
/* 273 */     return new AbstractSet<N>(this)
/*     */       {
/*     */         public dj<N> b() {
/* 276 */           if (i.a(this.a) == null) {
/* 277 */             Iterator iterator1 = i.a(this.a).entrySet().iterator();
/* 278 */             return (dj<N>)new c<N>(this, iterator1)
/*     */               {
/*     */                 protected N b() {
/* 281 */                   while (this.L.hasNext()) {
/* 282 */                     Map.Entry entry = this.L.next();
/* 283 */                     if (i.t(entry.getValue())) {
/* 284 */                       return (N)entry.getKey();
/*     */                     }
/*     */                   } 
/* 287 */                   return (N)c();
/*     */                 }
/*     */               };
/*     */           } 
/* 291 */           Iterator iterator = i.a(this.a).iterator();
/* 292 */           return (dj<N>)new c<N>(this, iterator)
/*     */             {
/*     */               protected N b() {
/* 295 */                 while (this.K.hasNext()) {
/* 296 */                   i.a a = this.K.next();
/* 297 */                   if (a instanceof i.a.a) {
/* 298 */                     return a.ah;
/*     */                   }
/*     */                 } 
/* 301 */                 return (N)c();
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int size() {
/* 309 */           return i.a(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean contains(Object param1Object) {
/* 314 */           return i.t(i.a(this.a).get(param1Object));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<N> C() {
/* 321 */     return new AbstractSet<N>(this)
/*     */       {
/*     */         public dj<N> b() {
/* 324 */           if (i.a(this.a) == null) {
/* 325 */             Iterator iterator1 = i.a(this.a).entrySet().iterator();
/* 326 */             return (dj<N>)new c<N>(this, iterator1)
/*     */               {
/*     */                 protected N b() {
/* 329 */                   while (this.L.hasNext()) {
/* 330 */                     Map.Entry entry = this.L.next();
/* 331 */                     if (i.u(entry.getValue())) {
/* 332 */                       return (N)entry.getKey();
/*     */                     }
/*     */                   } 
/* 335 */                   return (N)c();
/*     */                 }
/*     */               };
/*     */           } 
/* 339 */           Iterator iterator = i.a(this.a).iterator();
/* 340 */           return (dj<N>)new c<N>(this, iterator)
/*     */             {
/*     */               protected N b() {
/* 343 */                 while (this.K.hasNext()) {
/* 344 */                   i.a a = this.K.next();
/* 345 */                   if (a instanceof i.a.b) {
/* 346 */                     return a.ah;
/*     */                   }
/*     */                 } 
/* 349 */                 return (N)c();
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int size() {
/* 357 */           return i.b(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean contains(Object param1Object) {
/* 362 */           return i.u(i.a(this.a).get(param1Object));
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public Iterator<n<N>> b(N paramN) {
/*     */     Iterator iterator;
/* 369 */     D.checkNotNull(paramN);
/*     */ 
/*     */     
/* 372 */     if (this.U == null) {
/*     */       
/* 374 */       iterator = bH.a(
/* 375 */           bH.a(
/* 376 */             B().iterator(), new s<N, n<N>>(this, paramN)
/*     */             {
/*     */               public n<N> a(N param1N)
/*     */               {
/* 380 */                 return n.a(param1N, (N)this.ag);
/*     */               }
/* 383 */             }), bH.a(
/* 384 */             C().iterator(), new s<N, n<N>>(this, paramN)
/*     */             {
/*     */               public n<N> a(N param1N)
/*     */               {
/* 388 */                 return n.a((N)this.ag, param1N);
/*     */               }
/*     */             }));
/*     */     } else {
/*     */       
/* 393 */       iterator = bH.a(this.U
/* 394 */           .iterator(), new s<a<N>, n<N>>(this, paramN)
/*     */           {
/*     */             public n<N> a(i.a<N> param1a)
/*     */             {
/* 398 */               if (param1a instanceof i.a.b) {
/* 399 */                 return n.a((N)this.ag, param1a.ah);
/*     */               }
/* 401 */               return n.a(param1a.ah, (N)this.ag);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 407 */     AtomicBoolean atomicBoolean = new AtomicBoolean(false);
/* 408 */     return (Iterator<n<N>>)new c<n<N>>(this, iterator, atomicBoolean)
/*     */       {
/*     */         protected n<N> a() {
/* 411 */           while (this.M.hasNext()) {
/* 412 */             n<N> n = this.M.next();
/* 413 */             if (n.D().equals(n.E())) {
/* 414 */               if (!this.j.getAndSet(true))
/* 415 */                 return n; 
/*     */               continue;
/*     */             } 
/* 418 */             return n;
/*     */           } 
/*     */           
/* 421 */           return (n<N>)c();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V C(N paramN) {
/* 429 */     D.checkNotNull(paramN);
/* 430 */     Object object = this.ac.get(paramN);
/* 431 */     if (object == af) {
/* 432 */       return null;
/*     */     }
/* 434 */     if (object instanceof b) {
/* 435 */       return (V)b.a((b)object);
/*     */     }
/* 437 */     return (V)object;
/*     */   }
/*     */ 
/*     */   
/*     */   public void t(N paramN) {
/*     */     boolean bool;
/* 443 */     D.checkNotNull(paramN);
/*     */     
/* 445 */     Object object = this.ac.get(paramN);
/*     */ 
/*     */     
/* 448 */     if (object == af) {
/* 449 */       this.ac.remove(paramN);
/* 450 */       bool = true;
/* 451 */     } else if (object instanceof b) {
/* 452 */       this.ac.put(paramN, b.a((b)object));
/* 453 */       bool = true;
/*     */     } else {
/* 455 */       bool = false;
/*     */     } 
/*     */     
/* 458 */     if (bool) {
/* 459 */       w.F(--this.fp);
/*     */       
/* 461 */       if (this.U != null) {
/* 462 */         this.U.remove(new a.a<>(paramN));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public V D(Object paramObject) {
/*     */     Object object2;
/* 470 */     D.checkNotNull(paramObject);
/* 471 */     Object object1 = this.ac.get(paramObject);
/*     */ 
/*     */     
/* 474 */     if (object1 == null || object1 == af) {
/* 475 */       object2 = null;
/* 476 */     } else if (object1 instanceof b) {
/* 477 */       this.ac.put((N)paramObject, af);
/* 478 */       object2 = b.a((b)object1);
/*     */     } else {
/* 480 */       this.ac.remove(paramObject);
/* 481 */       object2 = object1;
/*     */     } 
/*     */     
/* 484 */     if (object2 != null) {
/* 485 */       w.F(--this.fq);
/*     */       
/* 487 */       if (this.U != null) {
/* 488 */         this.U.remove(new a.b(paramObject));
/*     */       }
/*     */     } 
/*     */     
/* 492 */     return (V)object2;
/*     */   }
/*     */   
/*     */   public void f(N paramN, V paramV) {
/*     */     boolean bool;
/* 497 */     Object object = this.ac.put(paramN, af);
/*     */ 
/*     */     
/* 500 */     if (object == null) {
/* 501 */       bool = true;
/* 502 */     } else if (object instanceof b) {
/*     */       
/* 504 */       this.ac.put(paramN, object);
/* 505 */       bool = false;
/* 506 */     } else if (object != af) {
/*     */       
/* 508 */       this.ac.put(paramN, new b(object));
/* 509 */       bool = true;
/*     */     } else {
/* 511 */       bool = false;
/*     */     } 
/*     */     
/* 514 */     if (bool) {
/* 515 */       w.G(++this.fp);
/*     */       
/* 517 */       if (this.U != null) {
/* 518 */         this.U.add(new a.a<>(paramN));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V m(N paramN, V paramV) {
/* 526 */     Object object2, object1 = this.ac.put(paramN, paramV);
/*     */ 
/*     */     
/* 529 */     if (object1 == null) {
/* 530 */       object2 = null;
/* 531 */     } else if (object1 instanceof b) {
/* 532 */       this.ac.put(paramN, new b(paramV));
/* 533 */       object2 = b.a((b)object1);
/* 534 */     } else if (object1 == af) {
/* 535 */       this.ac.put(paramN, new b(paramV));
/* 536 */       object2 = null;
/*     */     } else {
/* 538 */       object2 = object1;
/*     */     } 
/*     */     
/* 541 */     if (object2 == null) {
/* 542 */       w.G(++this.fq);
/*     */       
/* 544 */       if (this.U != null) {
/* 545 */         this.U.add(new a.b<>(paramN));
/*     */       }
/*     */     } 
/*     */     
/* 549 */     return (V)object2;
/*     */   }
/*     */   
/*     */   private static boolean r(Object paramObject) {
/* 553 */     return (paramObject == af || paramObject instanceof b);
/*     */   }
/*     */   
/*     */   private static boolean s(Object paramObject) {
/* 557 */     return (paramObject != af && paramObject != null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */