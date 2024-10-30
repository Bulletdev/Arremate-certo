/*     */ package org.c.a.b.q;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.c.a.a.b.h;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.f;
/*     */ import org.c.a.b.h.g;
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
/*     */ public class c
/*     */   implements h
/*     */ {
/*  35 */   private static final a a = org.c.a.a.f.c.b(c.class);
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
/*     */   private final d a;
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
/*     */   public c(d paramd) {
/*  72 */     this.a = paramd;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/*  91 */     List<i> list = paramg.bb();
/*  92 */     for (byte b = 0; b < list.size(); b++) {
/*  93 */       i i = list.get(b);
/*  94 */       String str = i.ev();
/*  95 */       if (a.isDebugEnabled()) {
/*  96 */         a.debug("Executing SQL: " + str);
/*     */       }
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
/* 125 */       a(this.a, paramg, i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(d paramd, g paramg, i parami) {
/* 182 */     String str = parami.ev() + parami.eL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     g g1 = parami.a(paramd, this);
/* 190 */     if (g1.a() != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 196 */       b(g1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 202 */       a(g1, paramg, parami);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 211 */     b(g1);
/* 212 */     a(g1);
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
/*     */   protected void a(g paramg) {
/* 224 */     for (f f : paramg.aZ()) {
/* 225 */       long l = f.ak();
/* 226 */       if (l != -1L) {
/* 227 */         Y(l);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void Y(long paramLong) {
/* 245 */     a.debug("Update Count: " + paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(g paramg, g paramg1, i parami) {
/* 253 */     throw new e(paramg1.b(), parami, paramg.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(g paramg) {
/* 261 */     for (h h1 : paramg.aG()) {
/*     */ 
/*     */ 
/*     */       
/* 265 */       if ("00000".equals(h1.getState())) {
/* 266 */         a.info("DB: " + h1.getMessage()); continue;
/*     */       } 
/* 268 */       a.warn("DB: " + h1.getMessage() + " (SQL State: " + h1
/* 269 */           .getState() + " - Error Code: " + h1.getCode() + ")");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */