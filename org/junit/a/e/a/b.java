/*     */ package org.junit.a.e.a;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.a.e.d;
/*     */ import org.junit.a.e.e;
/*     */ import org.junit.a.e.f;
/*     */ import org.junit.a.e.g;
/*     */ import org.junit.f.a.m;
/*     */ 
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
/*     */   private final List<g> az;
/*     */   private final List<d> aA;
/*     */   private final m b;
/*     */   
/*     */   private b(List<g> paramList, List<d> paramList1, m paramm) {
/*  30 */     this.aA = paramList1;
/*  31 */     this.az = paramList;
/*  32 */     this.b = paramm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b a(Method paramMethod, m paramm) {
/*  42 */     List<d> list = d.a(paramm.c());
/*     */     
/*  44 */     list.addAll(d.a(paramMethod));
/*  45 */     return new b(new ArrayList<g>(), list, paramm);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isComplete() {
/*  50 */     return this.aA.isEmpty();
/*     */   }
/*     */   
/*     */   public d a() {
/*  54 */     return this.aA.get(0);
/*     */   }
/*     */   
/*     */   public b a(g paramg) {
/*  58 */     ArrayList<g> arrayList = new ArrayList<g>(this.az);
/*  59 */     arrayList.add(paramg);
/*     */     
/*  61 */     return new b(arrayList, this.aA.subList(1, this.aA.size()), this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] a(int paramInt1, int paramInt2) throws g.a {
/*  67 */     Object[] arrayOfObject = new Object[paramInt2 - paramInt1];
/*  68 */     for (int i = paramInt1; i < paramInt2; i++) {
/*  69 */       arrayOfObject[i - paramInt1] = ((g)this.az.get(i)).getValue();
/*     */     }
/*  71 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<g> bg() throws Throwable {
/*  76 */     d d = a();
/*  77 */     List<g> list = a(d).a(d);
/*     */     
/*  79 */     if (list.isEmpty()) {
/*  80 */       list = b(d);
/*     */     }
/*     */     
/*  83 */     return list;
/*     */   }
/*     */   
/*     */   private List<g> b(d paramd) {
/*  87 */     Class<?> clazz = paramd.getType();
/*     */     
/*  89 */     if (clazz.isEnum())
/*  90 */       return (new d(clazz)).a(paramd); 
/*  91 */     if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
/*  92 */       return (new c()).a(paramd);
/*     */     }
/*  94 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(d paramd) throws Exception {
/* 100 */     f f = (f)paramd.a(f.class);
/*     */ 
/*     */     
/* 103 */     if (f != null) {
/* 104 */       return a(f.value());
/*     */     }
/* 106 */     return new a(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(Class<? extends e> paramClass) throws Exception {
/* 112 */     Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
/*     */     
/* 114 */     for (Constructor<e> constructor : arrayOfConstructor) {
/* 115 */       Class[] arrayOfClass = constructor.getParameterTypes();
/* 116 */       if (arrayOfClass.length == 1 && arrayOfClass[0].equals(m.class))
/*     */       {
/* 118 */         return constructor.newInstance(new Object[] { this.b });
/*     */       }
/*     */     } 
/*     */     
/* 122 */     return paramClass.newInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] e() throws g.a {
/* 127 */     return a(0, bU());
/*     */   }
/*     */   
/*     */   public Object[] f() throws g.a {
/* 131 */     return a(bU(), this.az.size());
/*     */   }
/*     */   
/*     */   public Object[] g() throws g.a {
/* 135 */     return a(0, this.az.size());
/*     */   }
/*     */   
/*     */   private int bU() {
/* 139 */     List list = d.a(this.b.c());
/*     */     
/* 141 */     return list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] a(boolean paramBoolean) throws g.a {
/* 147 */     Object[] arrayOfObject = new Object[this.az.size()];
/* 148 */     for (byte b1 = 0; b1 < arrayOfObject.length; b1++) {
/* 149 */       arrayOfObject[b1] = ((g)this.az.get(b1)).getDescription();
/*     */     }
/* 151 */     return arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */