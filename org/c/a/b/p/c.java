/*     */ package org.c.a.b.p;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.d;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.r.a;
/*     */ import org.c.a.b.r.n;
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
/*     */ public abstract class c
/*     */ {
/*     */   protected f b;
/*     */   
/*     */   public abstract <T> T a(Callable<T> paramCallable);
/*     */   
/*     */   public abstract boolean exists();
/*     */   
/*     */   public abstract void hS();
/*     */   
/*     */   public final boolean fR() {
/*  62 */     for (a a : ba()) {
/*  63 */       if (!a.a().isSynthetic())
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*  68 */         return true;
/*     */       }
/*     */     } 
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract List<a> ba();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(g paramg, String paramString) {
/*  87 */     a(paramg, paramString, f.b, paramString, null, 0, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a b() {
/*  97 */     List<a> list = ba();
/*     */     
/*  99 */     for (byte b = 0; b < Math.min(list.size(), 2); b++) {
/* 100 */       a a = list.get(b);
/* 101 */       if (a.a() == f.b) {
/* 102 */         return a;
/*     */       }
/*     */     } 
/* 105 */     return null;
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
/*     */   public abstract void ij();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d[] paramArrayOfd) {
/* 126 */     a(null, "<< Flyway Schema Creation >>", f.a, 
/* 127 */         n.a((Object[])paramArrayOfd), null, 0, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean fS() {
/* 136 */     List<a> list = ba();
/* 137 */     return (!list.isEmpty() && ((a)list.get(0)).a() == f.a);
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
/*     */   public abstract void a(a parama, d paramd);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearCache() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(g paramg, String paramString1, f paramf, String paramString2, Integer paramInteger, int paramInt, boolean paramBoolean) {
/* 169 */     boolean bool = (paramf == f.a) ? false : bS();
/* 170 */     a(bool, paramg, 
/*     */ 
/*     */         
/* 173 */         a.be(paramString1), paramf, 
/*     */         
/* 175 */         a.bf(paramString2), paramInteger, paramInt, paramBoolean);
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
/*     */   private int bS() {
/* 187 */     List<a> list = ba();
/* 188 */     if (list.isEmpty()) {
/* 189 */       return 1;
/*     */     }
/* 191 */     return ((a)list.get(list.size() - 1)).bQ() + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void a(int paramInt1, g paramg, String paramString1, f paramf, String paramString2, Integer paramInteger, int paramInt2, boolean paramBoolean);
/*     */ 
/*     */   
/*     */   public String toString() {
/* 200 */     return this.b.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\p\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */