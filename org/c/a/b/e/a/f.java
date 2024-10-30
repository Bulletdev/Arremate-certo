/*     */ package org.c.a.b.e.a;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.e;
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
/*     */ public abstract class f<D extends b, S extends d>
/*     */   extends e<D, S>
/*     */ {
/*  31 */   private static final a a = c.b(f.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(d paramd, D paramD, S paramS, String paramString) {
/*  42 */     super(paramd, paramD, paramS, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean exists() {
/*     */     try {
/*  52 */       return fB();
/*  53 */     } catch (SQLException sQLException) {
/*  54 */       throw new b("Unable to check whether table " + this + " exists", sQLException);
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
/*     */   
/*     */   protected abstract boolean fB() throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(d paramd1, d paramd2, String paramString, String... paramVarArgs) throws SQLException {
/*     */     boolean bool;
/*  77 */     String[] arrayOfString = paramVarArgs;
/*  78 */     if (arrayOfString.length == 0) {
/*  79 */       arrayOfString = null;
/*     */     }
/*     */     
/*  82 */     ResultSet resultSet = null;
/*     */     
/*     */     try {
/*  85 */       resultSet = ((b)this.a).a.getTables(
/*  86 */           (paramd1 == null) ? null : paramd1.getName(), 
/*  87 */           (paramd2 == null) ? null : paramd2.getName(), paramString, arrayOfString);
/*     */ 
/*     */       
/*  90 */       bool = resultSet.next();
/*     */     } finally {
/*  92 */       e.a(resultSet);
/*     */     } 
/*     */     
/*  95 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void lock() {
/*     */     try {
/* 103 */       a.debug("Locking table " + this + "...");
/* 104 */       ib();
/* 105 */       a.debug("Lock acquired for table " + this);
/* 106 */     } catch (SQLException sQLException) {
/* 107 */       throw new b("Unable to lock table " + this, sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract void ib() throws SQLException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */