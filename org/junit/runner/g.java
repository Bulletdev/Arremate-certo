/*     */ package org.junit.runner;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.c.d;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.runner.a.b;
/*     */ 
/*     */ 
/*     */ class g
/*     */ {
/*  13 */   private final List<String> aL = new ArrayList<String>();
/*  14 */   private final List<Class<?>> aq = new ArrayList<Class<?>>();
/*  15 */   private final List<Throwable> aM = new ArrayList<Throwable>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> bo() {
/*  26 */     return Collections.unmodifiableList(this.aL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Class<?>> bp() {
/*  33 */     return Collections.unmodifiableList(this.aq);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a(String[] paramArrayOfString) {
/*  42 */     g g1 = new g();
/*     */     
/*  44 */     g1.i(paramArrayOfString);
/*     */     
/*  46 */     return g1;
/*     */   }
/*     */   
/*     */   private void i(String[] paramArrayOfString) {
/*  50 */     j(b(paramArrayOfString));
/*     */   }
/*     */   
/*     */   String[] b(String... paramVarArgs) {
/*  54 */     for (byte b = 0; b != paramVarArgs.length; b++) {
/*  55 */       String str = paramVarArgs[b];
/*     */       
/*  57 */       if (str.equals("--"))
/*  58 */         return a(paramVarArgs, b + 1, paramVarArgs.length); 
/*  59 */       if (str.startsWith("--")) {
/*  60 */         if (str.startsWith("--filter=") || str.equals("--filter")) {
/*     */           String str1;
/*  62 */           if (str.equals("--filter")) {
/*  63 */             b++;
/*     */             
/*  65 */             if (b < paramVarArgs.length) {
/*  66 */               str1 = paramVarArgs[b];
/*     */             } else {
/*  68 */               this.aM.add(new a(str + " value not specified"));
/*     */               break;
/*     */             } 
/*     */           } else {
/*  72 */             str1 = str.substring(str.indexOf('=') + 1);
/*     */           } 
/*     */           
/*  75 */           this.aL.add(str1);
/*     */         } else {
/*  77 */           this.aM.add(new a("JUnit knows nothing about the " + str + " option"));
/*     */         } 
/*     */       } else {
/*  80 */         return a(paramVarArgs, b, paramVarArgs.length);
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     return new String[0];
/*     */   }
/*     */   
/*     */   private String[] a(String[] paramArrayOfString, int paramInt1, int paramInt2) {
/*  88 */     String[] arrayOfString = new String[paramInt2 - paramInt1];
/*  89 */     for (int i = paramInt1; i != paramInt2; i++) {
/*  90 */       arrayOfString[i - paramInt1] = paramArrayOfString[i];
/*     */     }
/*  92 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   void j(String[] paramArrayOfString) {
/*  96 */     for (String str : paramArrayOfString) {
/*     */       try {
/*  98 */         this.aq.add(d.getClass(str));
/*  99 */       } catch (ClassNotFoundException classNotFoundException) {
/* 100 */         this.aM.add(new IllegalArgumentException("Could not find class [" + str + "]", classNotFoundException));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private j a(Throwable paramThrowable) {
/* 106 */     return j.a(g.class, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(a parama) {
/* 115 */     if (this.aM.isEmpty()) {
/* 116 */       j j = j.a(parama, (Class[])this.aq.<Class<?>[]>toArray((Class<?>[][])new Class[this.aq.size()]));
/*     */       
/* 118 */       return b(j);
/*     */     } 
/* 120 */     return a((Throwable)new e(this.aM));
/*     */   }
/*     */ 
/*     */   
/*     */   private j b(j paramj) {
/*     */     try {
/* 126 */       for (String str : this.aL) {
/* 127 */         b b = d.a(paramj, str);
/*     */         
/* 129 */         paramj = paramj.a(b);
/*     */       } 
/* 131 */       return paramj;
/* 132 */     } catch (a a) {
/* 133 */       return a(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class a
/*     */     extends Exception
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public a(String param1String) {
/* 144 */       super(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */