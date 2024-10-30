/*     */ package org.junit.runner.a;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class h
/*     */ {
/*     */   private static final String mc = "Ordering class %s should have a public constructor with signature %s(Ordering.Context context)";
/*     */   
/*     */   public static h a(Random paramRandom) {
/*  32 */     return new h(paramRandom)
/*     */       {
/*     */         boolean gu() {
/*  35 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected List<c> c(Collection<c> param1Collection) {
/*  40 */           ArrayList<c> arrayList = new ArrayList<c>(param1Collection);
/*  41 */           Collections.shuffle(arrayList, this.b);
/*  42 */           return arrayList;
/*     */         }
/*     */       };
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
/*     */   public static h a(Class<? extends b> paramClass, c paramc) throws d {
/*     */     b b;
/*  58 */     if (paramClass == null) {
/*  59 */       throw new NullPointerException("factoryClass cannot be null");
/*     */     }
/*  61 */     if (paramc == null) {
/*  62 */       throw new NullPointerException("annotatedTestClass cannot be null");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  67 */       Constructor<? extends b> constructor = paramClass.getConstructor(new Class[0]);
/*  68 */       b = constructor.newInstance(new Object[0]);
/*  69 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  70 */       throw new d(String.format("Ordering class %s should have a public constructor with signature %s(Ordering.Context context)", new Object[] { f(paramClass), paramClass.getSimpleName() }));
/*     */ 
/*     */     
/*     */     }
/*  74 */     catch (Exception exception) {
/*  75 */       throw new d("Could not create ordering for " + paramc, exception);
/*     */     } 
/*     */     
/*  78 */     return a(b, paramc);
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
/*     */   public static h a(b paramb, c paramc) throws d {
/*  91 */     if (paramb == null) {
/*  92 */       throw new NullPointerException("factory cannot be null");
/*     */     }
/*  94 */     if (paramc == null) {
/*  95 */       throw new NullPointerException("annotatedTestClass cannot be null");
/*     */     }
/*     */     
/*  98 */     return paramb.a(new a(paramc));
/*     */   }
/*     */   
/*     */   private static String f(Class<?> paramClass) {
/* 102 */     String str = paramClass.getCanonicalName();
/* 103 */     if (str == null) {
/* 104 */       return paramClass.getName();
/*     */     }
/* 106 */     return str;
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
/*     */   public void I(Object paramObject) throws d {
/* 121 */     if (paramObject instanceof f) {
/* 122 */       f f = (f)paramObject;
/* 123 */       f.a(new g(this));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean gu() {
/* 132 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract List<c> c(Collection<c> paramCollection);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private final c b;
/*     */ 
/*     */ 
/*     */     
/*     */     public c e() {
/* 150 */       return this.b;
/*     */     }
/*     */     
/*     */     private a(c param1c) {
/* 154 */       this.b = param1c;
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface b {
/*     */     h a(h.a param1a);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */