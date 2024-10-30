/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.junit.c.e.c.c;
/*     */ import org.junit.f.a.l;
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
/*     */ public class o
/*     */   implements l
/*     */ {
/*     */   private final long timeout;
/*     */   private final TimeUnit timeUnit;
/*     */   private final boolean dl;
/*     */   
/*     */   public static a a() {
/*  51 */     return new a();
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
/*     */   @Deprecated
/*     */   public o(int paramInt) {
/*  68 */     this(paramInt, TimeUnit.MILLISECONDS);
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
/*     */   public o(long paramLong, TimeUnit paramTimeUnit) {
/*  81 */     this.timeout = paramLong;
/*  82 */     this.timeUnit = paramTimeUnit;
/*  83 */     this.dl = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o(a parama) {
/*  93 */     this.timeout = parama.getTimeout();
/*  94 */     this.timeUnit = parama.a();
/*  95 */     this.dl = parama.gr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o a(long paramLong) {
/* 105 */     return new o(paramLong, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static o b(long paramLong) {
/* 115 */     return new o(paramLong, TimeUnit.SECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final long c(TimeUnit paramTimeUnit) {
/* 124 */     return paramTimeUnit.convert(this.timeout, this.timeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean gr() {
/* 134 */     return this.dl;
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
/*     */   protected l b(l paraml) throws Exception {
/* 147 */     return (l)c.a().a(this.timeout, this.timeUnit).a(this.dl).a(paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l a(l paraml, c paramc) {
/*     */     try {
/* 155 */       return b(paraml);
/* 156 */     } catch (Exception exception) {
/* 157 */       return new l(this, exception) {
/*     */           public void io() throws Throwable {
/* 159 */             throw new RuntimeException("Invalid parameters for Timeout", this.b);
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private boolean dl = false;
/*     */ 
/*     */     
/* 172 */     private long timeout = 0L;
/* 173 */     private TimeUnit timeUnit = TimeUnit.SECONDS;
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
/*     */     public a a(long param1Long, TimeUnit param1TimeUnit) {
/* 194 */       this.timeout = param1Long;
/* 195 */       this.timeUnit = param1TimeUnit;
/* 196 */       return this;
/*     */     }
/*     */     
/*     */     protected long getTimeout() {
/* 200 */       return this.timeout;
/*     */     }
/*     */     
/*     */     protected TimeUnit a() {
/* 204 */       return this.timeUnit;
/*     */     }
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
/*     */     public a a(boolean param1Boolean) {
/* 217 */       this.dl = param1Boolean;
/* 218 */       return this;
/*     */     }
/*     */     
/*     */     protected boolean gr() {
/* 222 */       return this.dl;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public o a() {
/* 230 */       return new o(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\o.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */