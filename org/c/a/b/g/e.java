/*     */ package org.c.a.b.g;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.d;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.b;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.p.a;
/*     */ import org.c.a.b.p.c;
/*     */ import org.c.a.b.r.k;
/*     */ import org.c.a.b.r.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   implements d
/*     */ {
/*     */   private final c a;
/*     */   private final b a;
/*     */   private final c a;
/*     */   private g d;
/*     */   private boolean cs;
/*     */   private final boolean cz;
/*     */   private final boolean cM;
/*     */   private final boolean cN;
/*     */   private final boolean cO;
/*     */   private List<d> am;
/*     */   
/*     */   public e(c paramc, c paramc1, b paramb, g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
/* 113 */     this.a = (c)paramc;
/* 114 */     this.a = paramc1;
/* 115 */     this.a = (c)new b(this, paramb)
/*     */       {
/*     */         public b a() {
/* 118 */           return (b)this.b;
/*     */         }
/*     */       };
/* 121 */     this.d = paramg;
/* 122 */     this.cs = paramBoolean1;
/* 123 */     this.cz = paramBoolean2;
/* 124 */     this.cM = paramBoolean3;
/* 125 */     this.cN = paramBoolean4;
/* 126 */     this.cO = paramBoolean5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cx() {
/* 133 */     Collection collection = this.a.a((b)this.a);
/* 134 */     List list = this.a.ba();
/*     */     
/* 136 */     b b1 = new b();
/* 137 */     b1.cs = this.cs;
/* 138 */     b1.cz = this.cz;
/* 139 */     b1.cM = this.cM;
/* 140 */     b1.cN = this.cN;
/* 141 */     b1.cO = this.cO;
/* 142 */     b1.d = this.d;
/*     */     
/* 144 */     TreeMap<Object, Object> treeMap1 = new TreeMap<>();
/*     */     
/* 146 */     TreeMap<Object, Object> treeMap2 = new TreeMap<>();
/*     */     
/* 148 */     for (d d1 : collection) {
/* 149 */       g g1 = d1.c();
/* 150 */       if (g1 != null) {
/* 151 */         if (g1.a(b1.i) > 0) {
/* 152 */           b1.i = g1;
/*     */         }
/*     */         
/* 155 */         treeMap1.put(l.a(g1, 
/*     */ 
/*     */ 
/*     */               
/* 159 */               Boolean.valueOf(false)), d1); continue;
/*     */       } 
/* 161 */       treeMap2.put(d1.getDescription(), d1);
/*     */     } 
/*     */ 
/*     */     
/* 165 */     ArrayList<l> arrayList = new ArrayList();
/* 166 */     ArrayList<a> arrayList1 = new ArrayList();
/* 167 */     for (a a : list) {
/* 168 */       g g1 = a.c();
/* 169 */       if (g1 == null) {
/* 170 */         arrayList1.add(a);
/*     */         continue;
/*     */       } 
/* 173 */       if (a.a() == f.a) {
/* 174 */         b1.g = g1;
/*     */       }
/* 176 */       if (a.a() == f.b) {
/* 177 */         b1.h = g1;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 184 */       arrayList.add(l.a(a, new a()));
/*     */     } 
/*     */     
/* 187 */     for (l l : arrayList) {
/* 188 */       g g1 = ((a)l.getLeft()).c();
/* 189 */       if (g1 != null) {
/* 190 */         if (g1.a(b1.j) > 0) {
/*     */ 
/*     */ 
/*     */           
/* 194 */           b1.j = g1;
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 199 */         ((a)l.getRight()).cs = true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 204 */     if (g.c == this.d) {
/* 205 */       b1.d = b1.j;
/*     */     }
/*     */     
/* 208 */     ArrayList<d> arrayList2 = new ArrayList();
/* 209 */     HashSet hashSet1 = new HashSet(treeMap1.values());
/* 210 */     for (l l : arrayList) {
/* 211 */       d d1 = (d)treeMap1.get(l.a(((a)l.getLeft()).c(), Boolean.valueOf(((a)l.getLeft()).a().fs())));
/* 212 */       if (d1 != null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 217 */         hashSet1.remove(d1);
/*     */       }
/* 219 */       arrayList2.add(new d(d1, (a)l.getLeft(), b1, ((a)l.getRight()).cs));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     for (d d1 : hashSet1) {
/* 227 */       arrayList2.add(new d(d1, null, b1, false));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     for (a a : arrayList1) {
/* 236 */       if (!b1.ar.containsKey(a.getDescription()) || a
/* 237 */         .bQ() > ((Integer)b1.ar.get(a.getDescription())).intValue()) {
/* 238 */         b1.ar.put(a.getDescription(), Integer.valueOf(a.bQ()));
/*     */       }
/*     */     } 
/*     */     
/* 242 */     HashSet hashSet2 = new HashSet(treeMap2.values());
/* 243 */     for (a a : arrayList1) {
/* 244 */       d d1 = (d)treeMap2.get(a.getDescription());
/* 245 */       int i = ((Integer)b1.ar.get(a.getDescription())).intValue();
/* 246 */       if (d1 != null && a.bQ() == i && k.j(a.d(), d1.d())) {
/* 247 */         hashSet2.remove(d1);
/*     */       }
/* 249 */       arrayList2.add(new d(d1, a, b1, false));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     for (d d1 : hashSet2) {
/* 257 */       arrayList2.add(new d(d1, null, b1, false));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     Collections.sort(arrayList2);
/* 265 */     this.am = arrayList2;
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
/*     */   public c[] a() {
/* 292 */     return this.am.<c>toArray((c[])new d[0]);
/*     */   }
/*     */   
/*     */   public c a() {
/* 296 */     c c1 = null;
/* 297 */     for (d d1 : this.am) {
/* 298 */       if (d1.a().fq() && d1
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 303 */         .c() != null && (c1 == null || d1
/* 304 */         .c().a(c1.c()) > 0)) {
/* 305 */         c1 = d1;
/*     */       }
/*     */     } 
/* 308 */     if (c1 != null) {
/* 309 */       return c1;
/*     */     }
/*     */ 
/*     */     
/* 313 */     for (int i = this.am.size() - 1; i >= 0; i--) {
/* 314 */       d d1 = this.am.get(i);
/* 315 */       if (d1.a().fq())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 321 */         return d1;
/*     */       }
/*     */     } 
/*     */     
/* 325 */     return null;
/*     */   }
/*     */   
/*     */   public d[] a() {
/* 329 */     ArrayList<d> arrayList = new ArrayList();
/* 330 */     for (d d1 : this.am) {
/* 331 */       if (org.c.a.a.e.a == d1.a()) {
/* 332 */         arrayList.add(d1);
/*     */       }
/*     */     } 
/*     */     
/* 336 */     return arrayList.<d>toArray(new d[0]);
/*     */   }
/*     */   
/*     */   public d[] b() {
/* 340 */     ArrayList<d> arrayList = new ArrayList();
/* 341 */     for (d d1 : this.am) {
/* 342 */       if (d1.a().fq()) {
/* 343 */         arrayList.add(d1);
/*     */       }
/*     */     } 
/*     */     
/* 347 */     return arrayList.<d>toArray(new d[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c[] d() {
/* 356 */     ArrayList<c> arrayList = new ArrayList();
/* 357 */     for (c c1 : this.am) {
/* 358 */       if (c1.a().isResolved()) {
/* 359 */         arrayList.add(c1);
/*     */       }
/*     */     } 
/*     */     
/* 363 */     return arrayList.<c>toArray(new c[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c[] e() {
/* 372 */     ArrayList<c> arrayList = new ArrayList();
/* 373 */     for (c c1 : this.am) {
/* 374 */       if (c1.a().fr()) {
/* 375 */         arrayList.add(c1);
/*     */       }
/*     */     } 
/*     */     
/* 379 */     return arrayList.<c>toArray(new c[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c[] f() {
/* 388 */     ArrayList<c> arrayList = new ArrayList();
/* 389 */     for (c c1 : this.am) {
/* 390 */       if (c1.a() == org.c.a.a.e.m || c1
/* 391 */         .a() == org.c.a.a.e.n) {
/* 392 */         arrayList.add(c1);
/*     */       }
/*     */     } 
/*     */     
/* 396 */     return arrayList.<c>toArray(new c[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c[] g() {
/* 405 */     ArrayList<c> arrayList = new ArrayList();
/* 406 */     for (c c1 : this.am) {
/* 407 */       if (c1.a() == org.c.a.a.e.l) {
/* 408 */         arrayList.add(c1);
/*     */       }
/*     */     } 
/*     */     
/* 412 */     return arrayList.<c>toArray(new c[0]);
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
/*     */   public String ex() {
/* 440 */     for (d d1 : this.am) {
/* 441 */       String str = d1.ex();
/* 442 */       if (str != null) {
/* 443 */         return str;
/*     */       }
/*     */     } 
/* 446 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\g\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */