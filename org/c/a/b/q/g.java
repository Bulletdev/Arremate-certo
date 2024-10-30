/*     */ package org.c.a.b.q;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.j.c;
/*     */ import org.c.a.b.j.d;
/*     */ import org.c.a.b.j.e;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.r.i;
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
/*     */ public class g
/*     */   implements Comparable<g>
/*     */ {
/*  39 */   private static final a a = c.b(g.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final k a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean cv;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<i> ar;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cU;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cV;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g(k paramk, b paramb, boolean paramBoolean) {
/*  78 */     this.a = paramb;
/*  79 */     this.a = (b)paramk;
/*  80 */     this.cv = paramBoolean;
/*     */     
/*  82 */     a.debug("Parsing " + paramb.getFilename() + " ...");
/*  83 */     d d = null;
/*     */     try {
/*  85 */       d = paramb.a();
/*  86 */       this.ar = a(d);
/*     */     } finally {
/*  88 */       i.close((Closeable)d);
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
/*     */   private List<i> a(d paramd) {
/* 102 */     ArrayList<i> arrayList = new ArrayList();
/*     */     
/* 104 */     d d1 = null;
/* 105 */     j j = this.a.a();
/*     */     c c;
/* 107 */     while ((c = paramd.a()) != null) {
/* 108 */       e e = new e(c, this.a.a());
/* 109 */       String str = e.eG();
/* 110 */       if (j.isEmpty() && !n.X(str)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 115 */       if (!j.fV()) {
/* 116 */         d d2 = j.a(str);
/* 117 */         if (d2 != null) {
/* 118 */           d1 = d2;
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 124 */         if (d1 != null) {
/* 125 */           j.a(d1);
/*     */         }
/*     */       } 
/*     */       
/*     */       try {
/* 130 */         j.a((c)e);
/* 131 */       } catch (Exception exception) {
/* 132 */         throw new a("Flyway parsing bug (" + exception.getMessage() + ") at line " + e.getLineNumber() + ": " + str, exception);
/*     */       } 
/*     */       
/* 135 */       if (j.fO()) {
/* 136 */         j = this.a.a(); continue;
/* 137 */       }  if (j.isTerminated()) {
/* 138 */         a(arrayList, j);
/* 139 */         j = this.a.a();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 144 */     if (!j.isEmpty() && j.fV()) {
/* 145 */       a(arrayList, j);
/*     */     }
/*     */     
/* 148 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(List<i> paramList, j paramj) {
/* 152 */     i i = paramj.a();
/* 153 */     paramList.add(i);
/*     */     
/* 155 */     if (paramj.fU()) {
/* 156 */       this.cU = true;
/*     */     } else {
/* 158 */       this.cV = true;
/*     */     } 
/*     */     
/* 161 */     if (!this.cv && this.cU && this.cV) {
/* 162 */       throw new a("Detected both transactional and non-transactional statements within the same migration (even though mixed is false). Offending statement found at line " + i
/*     */ 
/*     */           
/* 165 */           .getLineNumber() + ": " + i.ev() + (
/* 166 */           paramj.fU() ? "" : " [non-transactional]"));
/*     */     }
/*     */     
/* 169 */     a.debug("Found statement at line " + i.getLineNumber() + ": " + i.ev() + (
/* 170 */         paramj.fU() ? "" : " [non-transactional]"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<i> bb() {
/* 179 */     return this.ar;
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
/*     */   public final b b() {
/* 204 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fU() {
/* 214 */     return !this.cV;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(g paramg) {
/* 219 */     return this.a.eK().compareTo(paramg.a.eK());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */