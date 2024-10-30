/*     */ package org.c.a.b.m;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.e.b;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.g.d;
/*     */ import org.c.a.a.g.e;
/*     */ import org.c.a.a.h.b;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.r.d;
/*     */ import org.c.a.b.r.l;
/*     */ import org.c.a.b.r.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a<M, E extends b>
/*     */   implements c
/*     */ {
/*  45 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.c.a.b.b.a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(org.c.a.b.b.a parama, b paramb) {
/*  64 */     this.a = (b)parama;
/*  65 */     this.a = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<d> a(b paramb) {
/*  70 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  72 */     for (Class clazz : this.a.a(j())) {
/*  73 */       Object object = d.a(clazz.getName(), this.a.getClassLoader());
/*  74 */       org.c.a.b.d.a.a(object, this.a);
/*     */       
/*  76 */       e e = a((M)object);
/*  77 */       e.bI(d.c(clazz));
/*  78 */       e.a((b)a((M)object));
/*     */       
/*  80 */       arrayList.add(e);
/*     */     } 
/*     */     
/*  83 */     Collections.sort(arrayList, new d());
/*  84 */     return (List)arrayList;
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
/*     */   public e a(M paramM) {
/*     */     g g;
/*     */     String str;
/* 112 */     Integer integer = null;
/* 113 */     if (paramM instanceof d) {
/* 114 */       d d = (d)paramM;
/* 115 */       integer = d.d();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     if (paramM instanceof e) {
/* 124 */       e e1 = (e)paramM;
/* 125 */       g = e1.c();
/* 126 */       str = e1.getDescription();
/* 127 */       if (!n.X(str)) {
/* 128 */         throw new org.c.a.a.a("Missing description for migration " + g);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       String str2, str1 = d.b(paramM.getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 147 */       boolean bool = str1.startsWith("R");
/* 148 */       if (str1.startsWith("V") || bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 153 */         str2 = str1.substring(0, 1);
/*     */       } else {
/* 155 */         throw new org.c.a.a.a("Invalid " + eH() + " migration class name: " + paramM.getClass().getName() + " => ensure it starts with V or R, or implement org.flywaydb.core.api.migration.MigrationInfoProvider for non-default naming");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 163 */       l<g, String> l = c.a(str1, str2, "__", new String[] { "" }, bool);
/* 164 */       g = (g)l.getLeft();
/* 165 */       str = (String)l.getRight();
/*     */     } 
/*     */     
/* 168 */     e e = new e();
/* 169 */     e.c(g);
/* 170 */     e.setDescription(str);
/* 171 */     e.bH(paramM.getClass().getName());
/* 172 */     e.c(integer);
/* 173 */     e.a(b());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     return e;
/*     */   }
/*     */   
/*     */   protected abstract String eH();
/*     */   
/*     */   protected abstract Class<M> j();
/*     */   
/*     */   protected abstract E a(M paramM);
/*     */   
/*     */   protected abstract f b();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\m\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */