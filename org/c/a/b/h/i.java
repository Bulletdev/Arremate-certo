/*     */ package org.c.a.b.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.f.b;
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
/*     */ public class i
/*     */ {
/*  31 */   private static final a a = c.b(i.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Connection d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean cQ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i(Connection paramConnection) {
/*  49 */     this(paramConnection, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i(Connection paramConnection, boolean paramBoolean) {
/*  59 */     this.d = paramConnection;
/*  60 */     this.cQ = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(Callable<T> paramCallable) {
/*  70 */     boolean bool = true;
/*     */     try {
/*  72 */       bool = this.d.getAutoCommit();
/*  73 */       this.d.setAutoCommit(false);
/*  74 */       T t = paramCallable.call();
/*  75 */       this.d.commit();
/*  76 */       return t;
/*  77 */     } catch (Exception exception) {
/*     */       a a1;
/*  79 */       if (exception instanceof SQLException) {
/*  80 */         b b = new b("Unable to commit transaction", (SQLException)exception);
/*  81 */       } else if (exception instanceof RuntimeException) {
/*  82 */         RuntimeException runtimeException = (RuntimeException)exception;
/*     */       } else {
/*  84 */         a1 = new a(exception);
/*     */       } 
/*     */       
/*  87 */       if (this.cQ) {
/*     */         try {
/*  89 */           a.debug("Rolling back transaction...");
/*  90 */           this.d.rollback();
/*  91 */           a.debug("Transaction rolled back");
/*  92 */         } catch (SQLException sQLException) {
/*  93 */           a.a("Unable to rollback transaction", sQLException);
/*     */         } 
/*     */       } else {
/*     */         try {
/*  97 */           this.d.commit();
/*  98 */         } catch (SQLException sQLException) {
/*  99 */           a.a("Unable to commit transaction", sQLException);
/*     */         } 
/*     */       } 
/* 102 */       throw a1;
/*     */     } finally {
/*     */       try {
/* 105 */         this.d.setAutoCommit(bool);
/* 106 */       } catch (SQLException sQLException) {
/* 107 */         a.a("Unable to restore autocommit to original value for connection", sQLException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */