/*     */ package org.c.a.b.m;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.b.a;
/*     */ import org.c.a.b.m.a.b;
/*     */ import org.c.a.b.m.b.b;
/*     */ import org.c.a.b.m.c.b;
/*     */ import org.c.a.b.m.d.d;
/*     */ import org.c.a.b.n.e;
/*     */ import org.c.a.b.q.k;
/*     */ import org.c.a.b.r.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   implements c
/*     */ {
/*  50 */   private Collection<c> l = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<d> ao;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.c.a.b.e.a.b paramb, e parame, a parama, org.c.a.a.c.b paramb1, k paramk, c... paramVarArgs) {
/*  79 */     this.l.add(new d(paramb, parame, paramk, paramb1));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     this.l.add(new b(parama, paramb1));
/*  85 */     this.l.add(new b(parama, paramb1));
/*     */     
/*  87 */     if (!paramb1.fi() && (new g(paramb1.getClassLoader())).fZ()) {
/*  88 */       this.l.add(new b(parama, paramb1));
/*     */     }
/*     */ 
/*     */     
/*  92 */     this.l.addAll(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<d> a(org.c.a.a.h.b paramb) {
/* 103 */     if (this.ao == null) {
/* 104 */       this.ao = b(paramb);
/*     */     }
/*     */     
/* 107 */     return this.ao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<d> b(org.c.a.a.h.b paramb) throws a {
/* 118 */     ArrayList<d> arrayList = new ArrayList<>(a(this.l, paramb));
/* 119 */     Collections.sort(arrayList, new d());
/*     */     
/* 121 */     r(arrayList);
/*     */     
/* 123 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Collection<d> a(Collection<c> paramCollection, org.c.a.a.h.b paramb) {
/* 134 */     HashSet<d> hashSet = new HashSet();
/* 135 */     for (c c1 : paramCollection) {
/* 136 */       hashSet.addAll(c1.a(paramb));
/*     */     }
/* 138 */     return hashSet;
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
/*     */   static void r(List<d> paramList) {
/* 150 */     for (byte b1 = 0; b1 < paramList.size() - 1; b1++) {
/* 151 */       d d1 = paramList.get(b1);
/* 152 */       d d2 = paramList.get(b1 + 1);
/* 153 */       if ((new d()).a(d1, d2) == 0) {
/* 154 */         if (d1.c() != null) {
/* 155 */           throw new a(String.format("Found more than one migration with version %s\nOffenders:\n-> %s (%s)\n-> %s (%s)", new Object[] { d1
/* 156 */                   .c(), d1
/* 157 */                   .ew(), d1
/* 158 */                   .a(), d2
/* 159 */                   .ew(), d2
/* 160 */                   .a() }));
/*     */         }
/* 162 */         throw new a(String.format("Found more than one repeatable migration with description %s\nOffenders:\n-> %s (%s)\n-> %s (%s)", new Object[] { d1
/* 163 */                 .getDescription(), d1
/* 164 */                 .ew(), d1
/* 165 */                 .a(), d2
/* 166 */                 .ew(), d2
/* 167 */                 .a() }));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */