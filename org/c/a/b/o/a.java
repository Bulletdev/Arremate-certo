/*     */ package org.c.a.b.o;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.b.a;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.n.e;
/*     */ import org.c.a.b.o.a.a;
/*     */ import org.c.a.b.o.b.b;
/*     */ import org.c.a.b.o.b.h;
/*     */ import org.c.a.b.o.c.a;
/*     */ import org.c.a.b.r.g;
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
/*     */ public class a
/*     */   implements a, e
/*     */ {
/*  40 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */   
/*  42 */   private final List<b> ap = new ArrayList<>();
/*  43 */   private final List<Class<?>> aq = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(Collection<b> paramCollection, ClassLoader paramClassLoader, Charset paramCharset) {
/*  50 */     a a1 = new a(paramCharset);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     boolean bool = (new g(paramClassLoader)).gd();
/*     */     
/*  58 */     for (b b : paramCollection) {
/*  59 */       if (b.fp()) {
/*  60 */         this.ap.addAll(a1.a(b));
/*     */         
/*     */         continue;
/*     */       } 
/*  64 */       h h = (h)(bool ? new a(paramClassLoader, paramCharset, b) : new b(paramClassLoader, paramCharset, b));
/*  65 */       this.ap.addAll(h.i());
/*  66 */       this.aq.addAll(h.j());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public b a(String paramString) {
/*  73 */     for (b b : this.ap) {
/*  74 */       String str = b.getFilename();
/*  75 */       if (str.equals(paramString)) {
/*  76 */         return b;
/*     */       }
/*     */     } 
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<b> a(String paramString, String... paramVarArgs) {
/*  90 */     ArrayList<b> arrayList = new ArrayList();
/*  91 */     for (b b : this.ap) {
/*  92 */       String str = b.getFilename();
/*  93 */       if (n.b(str, paramString, paramVarArgs)) {
/*  94 */         arrayList.add(b); continue;
/*     */       } 
/*  96 */       a.debug("Filtering out resource: " + b.eI() + " (filename: " + str + ")");
/*     */     } 
/*     */     
/*  99 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <I> Collection<Class<? extends I>> a(Class<I> paramClass) {
/* 110 */     ArrayList<Class<?>> arrayList = new ArrayList();
/* 111 */     for (Class<?> clazz : this.aq) {
/* 112 */       if (!paramClass.isAssignableFrom(clazz)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 117 */       arrayList.add(clazz);
/*     */     } 
/* 119 */     return (Collection)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */