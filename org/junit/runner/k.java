/*     */ package org.junit.runner;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.io.ObjectStreamField;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.junit.runner.b.a;
/*     */ import org.junit.runner.b.b;
/*     */ import org.junit.runner.b.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class k
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final ObjectStreamField[] a = ObjectStreamClass.lookup(b.class).getFields();
/*     */   
/*     */   private final AtomicInteger k;
/*     */   
/*     */   private final AtomicInteger l;
/*     */   
/*     */   private final AtomicInteger m;
/*     */   private final CopyOnWriteArrayList<a> a;
/*     */   private final AtomicLong f;
/*     */   private final AtomicLong g;
/*     */   private b a;
/*     */   
/*     */   public k() {
/*  40 */     this.k = new AtomicInteger();
/*  41 */     this.l = new AtomicInteger();
/*  42 */     this.m = new AtomicInteger();
/*  43 */     this.a = (b)new CopyOnWriteArrayList();
/*  44 */     this.f = new AtomicLong();
/*  45 */     this.g = new AtomicLong();
/*     */   }
/*     */   
/*     */   private k(b paramb) {
/*  49 */     this.k = b.a(paramb);
/*  50 */     this.l = b.b(paramb);
/*  51 */     this.m = b.c(paramb);
/*  52 */     this.a = (b)new CopyOnWriteArrayList(b.a(paramb));
/*  53 */     this.f = new AtomicLong(b.a(paramb));
/*  54 */     this.g = new AtomicLong(b.b(paramb));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bV() {
/*  61 */     return this.k.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bW() {
/*  68 */     return this.a.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long ao() {
/*  75 */     return this.f.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<a> bq() {
/*  82 */     return (List<a>)this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bX() {
/*  89 */     return this.l.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bY() {
/*  99 */     if (this.m == null) {
/* 100 */       throw new UnsupportedOperationException("Result was serialized from a version of JUnit that doesn't support this method");
/*     */     }
/*     */     
/* 103 */     return this.m.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean er() {
/* 110 */     return (bW() == 0);
/*     */   }
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 114 */     b b1 = new b(this);
/* 115 */     b1.b(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws ClassNotFoundException, IOException {
/* 120 */     this.a = b.a(paramObjectInputStream);
/*     */   }
/*     */   
/*     */   private Object readResolve() {
/* 124 */     return new k(this.a);
/*     */   }
/*     */   
/*     */   @a
/*     */   private class a
/*     */     extends b {
/*     */     public void h(c param1c) throws Exception {
/* 131 */       k.a(this.b).set(System.currentTimeMillis());
/*     */     }
/*     */     private a(k this$0) {}
/*     */     
/*     */     public void a(k param1k) throws Exception {
/* 136 */       long l = System.currentTimeMillis();
/* 137 */       k.b(this.b).addAndGet(l - k.a(this.b).get());
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(c param1c) throws Exception {
/* 142 */       k.a(this.b).getAndIncrement();
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(a param1a) throws Exception {
/* 147 */       k.a(this.b).add(param1a);
/*     */     }
/*     */ 
/*     */     
/*     */     public void c(c param1c) throws Exception {
/* 152 */       k.b(this.b).getAndIncrement();
/*     */     }
/*     */ 
/*     */     
/*     */     public void b(a param1a) {
/* 157 */       k.c(this.b).getAndIncrement();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b b() {
/* 165 */     return new a();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class b
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final AtomicInteger n;
/*     */     private final AtomicInteger o;
/*     */     private final AtomicInteger m;
/*     */     private final List<a> ac;
/*     */     private final long bZ;
/*     */     private final long ca;
/*     */     
/*     */     public b(k param1k) {
/* 182 */       this.n = k.a(param1k);
/* 183 */       this.o = k.b(param1k);
/* 184 */       this.m = k.c(param1k);
/* 185 */       this.ac = Collections.synchronizedList(new ArrayList<a>(k.a(param1k)));
/* 186 */       this.bZ = k.b(param1k).longValue();
/* 187 */       this.ca = k.a(param1k).longValue();
/*     */     }
/*     */ 
/*     */     
/*     */     private b(ObjectInputStream.GetField param1GetField) throws IOException {
/* 192 */       this.n = (AtomicInteger)param1GetField.get("fCount", (Object)null);
/* 193 */       this.o = (AtomicInteger)param1GetField.get("fIgnoreCount", (Object)null);
/* 194 */       this.m = (AtomicInteger)param1GetField.get("assumptionFailureCount", (Object)null);
/* 195 */       this.ac = (List<a>)param1GetField.get("fFailures", (Object)null);
/* 196 */       this.bZ = param1GetField.get("fRunTime", 0L);
/* 197 */       this.ca = param1GetField.get("fStartTime", 0L);
/*     */     }
/*     */     
/*     */     public void b(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/* 201 */       ObjectOutputStream.PutField putField = param1ObjectOutputStream.putFields();
/* 202 */       putField.put("fCount", this.n);
/* 203 */       putField.put("fIgnoreCount", this.o);
/* 204 */       putField.put("fFailures", this.ac);
/* 205 */       putField.put("fRunTime", this.bZ);
/* 206 */       putField.put("fStartTime", this.ca);
/* 207 */       putField.put("assumptionFailureCount", this.m);
/* 208 */       param1ObjectOutputStream.writeFields();
/*     */     }
/*     */ 
/*     */     
/*     */     public static b a(ObjectInputStream param1ObjectInputStream) throws ClassNotFoundException, IOException {
/* 213 */       ObjectInputStream.GetField getField = param1ObjectInputStream.readFields();
/* 214 */       return new b(getField);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */