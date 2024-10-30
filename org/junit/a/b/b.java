/*     */ package org.junit.a.b;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import junit.b.i;
/*     */ import junit.b.n;
/*     */ import org.junit.c.e.e;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.h;
/*     */ import org.junit.runner.JUnitCore;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.j;
/*     */ import org.junit.runner.k;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*     */   private static final String lZ = "malformed JUnit 3 test class: ";
/*     */   private final c a;
/*     */   
/*     */   @Deprecated
/*     */   public static b a(String paramString) {
/*  42 */     return a(new File(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b a(File paramFile) {
/*  49 */     return new b(paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private b(File paramFile) {
/*  55 */     this.a = c.a(paramFile);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a(Class<?> paramClass) {
/*  64 */     return a(j.a(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a(j paramj) {
/*  74 */     return a(paramj, new JUnitCore());
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
/*     */   public k a(j paramj, JUnitCore paramJUnitCore) {
/*  88 */     paramJUnitCore.a(this.a.a());
/*  89 */     return paramJUnitCore.a(a(paramj).a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(j paramj) {
/*  96 */     if (paramj instanceof org.junit.c.d.e)
/*     */     {
/*  98 */       return paramj;
/*     */     }
/* 100 */     List<c> list = b(paramj);
/* 101 */     Collections.sort(list, this.a.j());
/* 102 */     return a(list);
/*     */   }
/*     */   
/*     */   private j a(List<c> paramList) {
/* 106 */     ArrayList<m> arrayList = new ArrayList();
/* 107 */     for (c c1 : paramList) {
/* 108 */       arrayList.add(a(c1));
/*     */     }
/* 110 */     return new j(this, arrayList)
/*     */       {
/*     */         public m a() {
/*     */           try {
/* 114 */             return (m)new h(this, (Class)null, this.aw) {  }
/*     */               ;
/* 116 */           } catch (e e) {
/* 117 */             return (m)new org.junit.c.e.b(null, (Throwable)e);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private m a(c paramc) {
/* 124 */     if (paramc.toString().equals("TestSuite with 0 tests")) {
/* 125 */       return h.c();
/*     */     }
/* 127 */     if (paramc.toString().startsWith("malformed JUnit 3 test class: "))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 132 */       return (m)new e((i)new n(a(paramc)));
/*     */     }
/* 134 */     Class clazz = paramc.f();
/* 135 */     if (clazz == null) {
/* 136 */       throw new RuntimeException("Can't build a runner from description [" + paramc + "]");
/*     */     }
/* 138 */     String str = paramc.getMethodName();
/* 139 */     if (str == null) {
/* 140 */       return j.a(clazz).a();
/*     */     }
/* 142 */     return j.a(clazz, str).a();
/*     */   }
/*     */   
/*     */   private Class<?> a(c paramc) {
/*     */     try {
/* 147 */       return Class.forName(paramc.toString().replace("malformed JUnit 3 test class: ", ""));
/* 148 */     } catch (ClassNotFoundException classNotFoundException) {
/* 149 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<c> a(j paramj) {
/* 159 */     return b(a(paramj));
/*     */   }
/*     */   
/*     */   private List<c> b(j paramj) {
/* 163 */     ArrayList<c> arrayList = new ArrayList();
/* 164 */     a(null, paramj.a().a(), arrayList);
/* 165 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(c paramc1, c paramc2, List<c> paramList) {
/* 169 */     if (paramc2.getChildren().isEmpty()) {
/* 170 */       if (paramc2.toString().equals("warning(junit.framework.TestSuite$1)")) {
/* 171 */         paramList.add(c.a("malformed JUnit 3 test class: " + paramc1, new java.lang.annotation.Annotation[0]));
/*     */       } else {
/* 173 */         paramList.add(paramc2);
/*     */       } 
/*     */     } else {
/* 176 */       for (c c1 : paramc2.getChildren())
/* 177 */         a(paramc2, c1, paramList); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\b\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */