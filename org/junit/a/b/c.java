/*     */ package org.junit.a.b;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.junit.runner.k;
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
/*     */ public class c
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public static c a(File paramFile) {
/*  34 */     if (paramFile.exists()) {
/*     */       try {
/*  36 */         return b(paramFile);
/*  37 */       } catch (a a) {
/*  38 */         a.printStackTrace();
/*  39 */         paramFile.delete();
/*     */       } 
/*     */     }
/*  42 */     return new c(paramFile);
/*     */   }
/*     */ 
/*     */   
/*     */   private static c b(File paramFile) throws a {
/*     */     try {
/*  48 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */       try {
/*  50 */         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
/*     */ 
/*     */       
/*     */       }
/*     */       finally {
/*     */ 
/*     */         
/*  57 */         fileInputStream.close();
/*     */       } 
/*  59 */     } catch (Exception exception) {
/*  60 */       throw new a(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   private final Map<String, Long> aw = new HashMap<String, Long>();
/*  70 */   private final Map<String, Long> ax = new HashMap<String, Long>();
/*     */   private final File d;
/*     */   
/*     */   private c(File paramFile) {
/*  74 */     this.d = paramFile;
/*     */   }
/*     */   
/*     */   private void in() throws IOException {
/*  78 */     ObjectOutputStream objectOutputStream = null;
/*     */     try {
/*  80 */       objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.d));
/*  81 */       objectOutputStream.writeObject(this);
/*     */     } finally {
/*  83 */       if (objectOutputStream != null) {
/*  84 */         objectOutputStream.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   Long a(org.junit.runner.c paramc) {
/*  90 */     return this.ax.get(paramc.toString());
/*     */   }
/*     */   
/*     */   void a(org.junit.runner.c paramc, long paramLong) {
/*  94 */     this.ax.put(paramc.toString(), Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   boolean d(org.junit.runner.c paramc) {
/*  98 */     return !this.aw.containsKey(paramc.toString());
/*     */   }
/*     */   
/*     */   Long b(org.junit.runner.c paramc) {
/* 102 */     return this.aw.get(paramc.toString());
/*     */   }
/*     */   
/*     */   void b(org.junit.runner.c paramc, long paramLong) {
/* 106 */     this.aw.put(paramc.toString(), Long.valueOf(paramLong));
/*     */   }
/*     */   
/*     */   private final class a extends org.junit.runner.b.b {
/* 110 */     private long bV = System.currentTimeMillis();
/*     */     
/* 112 */     private Map<org.junit.runner.c, Long> ay = new HashMap<org.junit.runner.c, Long>();
/*     */ 
/*     */     
/*     */     public void b(org.junit.runner.c param1c) throws Exception {
/* 116 */       this.ay.put(param1c, Long.valueOf(System.nanoTime()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(org.junit.runner.c param1c) throws Exception {
/* 122 */       long l1 = System.nanoTime();
/* 123 */       long l2 = ((Long)this.ay.get(param1c)).longValue();
/* 124 */       this.b.b(param1c, l1 - l2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(org.junit.runner.b.a param1a) throws Exception {
/* 129 */       this.b.a(param1a.a(), this.bV);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(k param1k) throws Exception {
/* 134 */       c.a(this.b);
/*     */     }
/*     */     
/*     */     private a(c this$0) {} }
/*     */   
/*     */   private class b implements Comparator<org.junit.runner.c> {
/*     */     public int a(org.junit.runner.c param1c1, org.junit.runner.c param1c2) {
/* 141 */       if (this.b.d(param1c1)) {
/* 142 */         return -1;
/*     */       }
/* 144 */       if (this.b.d(param1c2)) {
/* 145 */         return 1;
/*     */       }
/*     */       
/* 148 */       int i = c(param1c2).compareTo(c(param1c1));
/* 149 */       return (i != 0) ? i : this.b.b(param1c1).compareTo(this.b.b(param1c2));
/*     */     }
/*     */     
/*     */     private b(c this$0) {}
/*     */     
/*     */     private Long c(org.junit.runner.c param1c) {
/* 155 */       Long long_ = this.b.a(param1c);
/* 156 */       if (long_ == null) {
/* 157 */         return Long.valueOf(0L);
/*     */       }
/* 159 */       return long_;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public org.junit.runner.b.b a() {
/* 168 */     return new a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<org.junit.runner.c> j() {
/* 176 */     return new b();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\b\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */