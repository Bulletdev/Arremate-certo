/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.junit.c.b.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   implements l
/*     */ {
/*     */   private final l a;
/*     */   private final boolean dm;
/*     */   
/*     */   public a(l paraml) {
/*  57 */     this(paraml, c.a().bh());
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
/*     */   a(l paraml, List<String> paramList) {
/*  69 */     this.a = paraml;
/*  70 */     this.dm = b(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public l a(l paraml, c paramc) {
/*  77 */     if (this.dm) {
/*  78 */       return paraml;
/*     */     }
/*  80 */     return this.a.a(paraml, paramc);
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
/*     */   private static boolean b(List<String> paramList) {
/* 105 */     for (String str : paramList) {
/* 106 */       if ("-Xdebug".equals(str) || str.startsWith("-agentlib:jdwp")) {
/* 107 */         return true;
/*     */       }
/*     */     } 
/* 110 */     return false;
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
/*     */   public boolean gn() {
/* 122 */     return this.dm;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */