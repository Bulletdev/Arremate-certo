/*     */ package org.c.a.b.o.a;
/*     */ 
/*     */ import android.content.Context;
/*     */ import dalvik.system.DexFile;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.o.b.h;
/*     */ import org.c.a.b.r.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements h
/*     */ {
/*  41 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */   
/*     */   private final Context a;
/*     */   
/*     */   private final ClassLoader classLoader;
/*     */   private final Charset encoding;
/*     */   private final b a;
/*     */   
/*     */   public a(ClassLoader paramClassLoader, Charset paramCharset, b paramb) {
/*  50 */     this.classLoader = paramClassLoader;
/*  51 */     this.encoding = paramCharset;
/*  52 */     this.a = paramb;
/*  53 */     this.a = (b)org.c.a.a.a.a.a();
/*  54 */     if (this.a == null) {
/*  55 */       throw new org.c.a.a.a("Unable to scan for Migrations! Context not set. Within an activity you can fix this with org.flywaydb.core.api.android.ContextHolder.setContext(this);");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<b> i() {
/*  62 */     ArrayList<org.c.a.b.n.a.a> arrayList = new ArrayList();
/*     */     
/*  64 */     String str = this.a.getPath();
/*     */     try {
/*  66 */       for (String str1 : this.a.getAssets().list(str)) {
/*  67 */         arrayList.add(new org.c.a.b.n.a.a(this.a, this.a.getAssets(), str, str1, this.encoding));
/*     */       }
/*  69 */     } catch (IOException iOException) {
/*  70 */       a.warn("Unable to scan for resources: " + iOException.getMessage());
/*     */     } 
/*     */     
/*  73 */     return (Collection)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Class<?>> j() {
/*  78 */     String str1 = this.a.getPath().replace("/", ".");
/*     */     
/*  80 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*  81 */     String str2 = (this.a.getApplicationInfo()).sourceDir;
/*  82 */     DexFile dexFile = null;
/*     */     try {
/*  84 */       dexFile = new DexFile(str2);
/*  85 */       Enumeration<String> enumeration = dexFile.entries();
/*  86 */       while (enumeration.hasMoreElements()) {
/*  87 */         String str = enumeration.nextElement();
/*  88 */         if (str.startsWith(str1)) {
/*  89 */           Class<?> clazz = d.a(str, this.classLoader);
/*  90 */           if (clazz != null) {
/*  91 */             arrayList.add(clazz);
/*     */           }
/*     */         } 
/*     */       } 
/*  95 */     } catch (IOException iOException) {
/*  96 */       a.warn("Unable to scan DEX file (" + str2 + "): " + iOException.getMessage());
/*     */     } finally {
/*  98 */       if (dexFile != null) {
/*     */         try {
/* 100 */           dexFile.close();
/* 101 */         } catch (IOException iOException) {
/* 102 */           a.debug("Unable to close DEX file (" + str2 + "): " + iOException.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/* 106 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */