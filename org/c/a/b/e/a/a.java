/*     */ package org.c.a.b.e.a;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.e;
/*     */ import org.c.a.b.h.i;
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
/*     */ public abstract class a<D extends b>
/*     */   implements Closeable
/*     */ {
/*     */   protected final D a;
/*     */   protected final d a;
/*     */   private final Connection b;
/*     */   protected final String kS;
/*     */   private boolean cA;
/*     */   
/*     */   protected a(b paramb, D paramD, Connection paramConnection, boolean paramBoolean) {
/*  49 */     this.a = (d)paramD;
/*  50 */     this.cA = paramBoolean;
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
/*  67 */     this.b = paramConnection;
/*     */ 
/*     */ 
/*     */     
/*  71 */     this.a = new d(this.b);
/*     */     try {
/*  73 */       this.kS = ey();
/*  74 */     } catch (SQLException sQLException) {
/*  75 */       throw new b("Unable to retrieve the current schema for the connection", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String ey() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a() {
/*     */     try {
/*  92 */       return b();
/*  93 */     } catch (SQLException sQLException) {
/*  94 */       throw new b("Unable to retrieve the current schema for the connection", sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected d b() throws SQLException {
/*  99 */     return a(ey());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract d a(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(d paramd) {
/*     */     try {
/* 117 */       if (!paramd.exists()) {
/*     */         return;
/*     */       }
/* 120 */       bB(paramd.getName());
/* 121 */     } catch (SQLException sQLException) {
/* 122 */       throw new b("Error setting current schema to " + paramd, sQLException);
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
/*     */   protected void bB(String paramString) throws SQLException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T a(f paramf, Callable<T> paramCallable) {
/* 143 */     return (T)(new i(this.a.getConnection(), this.a.fx())).execute(new Callable<T>(this, paramf, paramCallable)
/*     */         {
/*     */           public T call() throws Exception {
/* 146 */             this.a.lock();
/* 147 */             return this.d.call();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public final d a() {
/* 153 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void close() {
/* 158 */     hU();
/* 159 */     hT();
/* 160 */     hV();
/* 161 */     e.p(this.b);
/*     */   }
/*     */   
/*     */   private void hT() {
/* 165 */     (new i(this.b)).execute(new Callable<Void>(this)
/*     */         {
/*     */           public Void b() {
/*     */             try {
/* 169 */               this.d.bB(this.d.kS);
/* 170 */             } catch (SQLException sQLException) {
/* 171 */               throw new b("Unable to restore original schema", sQLException);
/*     */             } 
/* 173 */             return null;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hU() {
/*     */     try {
/* 183 */       hW();
/* 184 */     } catch (SQLException sQLException) {
/* 185 */       throw new b("Unable to restore connection to its original state", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void hV() {
/*     */     try {
/* 194 */       this.b.setAutoCommit(this.cA);
/* 195 */     } catch (SQLException sQLException) {
/* 196 */       throw new b("Unable to restore connection to its original auto-commit setting", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hW() throws SQLException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final Connection c() {
/* 207 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */