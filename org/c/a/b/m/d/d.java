/*     */ package org.c.a.b.m.d;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.b;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.m.c;
/*     */ import org.c.a.b.m.e;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.n.e;
/*     */ import org.c.a.b.q.g;
/*     */ import org.c.a.b.q.k;
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
/*     */ public class d
/*     */   implements c
/*     */ {
/*     */   private final b a;
/*     */   private final e a;
/*     */   private final k a;
/*     */   private final b a;
/*     */   
/*     */   public d(b paramb, e parame, k paramk, b paramb1) {
/*  86 */     this.a = (b)paramb;
/*  87 */     this.a = (b)parame;
/*  88 */     this.a = (b)paramk;
/*     */ 
/*     */ 
/*     */     
/*  92 */     this.a = paramb1;
/*     */   }
/*     */   
/*     */   public List<org.c.a.a.h.d> a(b paramb) {
/*  96 */     ArrayList<org.c.a.a.h.d> arrayList = new ArrayList();
/*     */     
/*  98 */     String str = this.a.ek();
/*  99 */     String[] arrayOfString = this.a.m();
/* 100 */     a(arrayList, this.a.ei(), str, arrayOfString, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     a(arrayList, this.a.ej(), str, arrayOfString, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     Collections.sort(arrayList, (Comparator<? super org.c.a.a.h.d>)new org.c.a.b.m.d());
/* 118 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<org.c.a.a.h.d> paramList, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean) {
/* 127 */     for (b b1 : this.a.a(paramString1, paramArrayOfString)) {
/* 128 */       String str = b1.getFilename();
/* 129 */       if (a(str, paramString2, paramArrayOfString)) {
/*     */         continue;
/*     */       }
/*     */       
/* 133 */       l l = c.a(str, paramString1, paramString2, paramArrayOfString, paramBoolean);
/*     */       
/* 135 */       e e1 = new e();
/* 136 */       e1.c((g)l.getLeft());
/* 137 */       e1.setDescription((String)l.getRight());
/* 138 */       e1.bH(b1.eK());
/*     */       
/* 140 */       g g = new g((k)this.a, b1, this.a.fj());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 157 */       int i = b1.bP();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       e1.c(Integer.valueOf(i));
/* 170 */       e1.a(f.c);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 175 */       e1.bI(b1.eJ());
/* 176 */       e1.a(new b((b)this.a, g));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       paramList.add(e1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean a(String paramString1, String paramString2, String... paramVarArgs) {
/* 212 */     for (String str1 : paramVarArgs) {
/* 213 */       String str2 = paramString1.substring(0, paramString1.length() - str1.length());
/* 214 */       int i = str2.indexOf(paramString2);
/* 215 */       if (i >= 0) {
/* 216 */         str2 = str2.substring(0, i);
/*     */       }
/* 218 */       if (e.a(str2) != null) {
/* 219 */         return true;
/*     */       }
/*     */     } 
/* 222 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */