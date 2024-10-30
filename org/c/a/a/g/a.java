/*     */ package org.c.a.a.g;
/*     */ 
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.m.c;
/*     */ import org.c.a.b.r.d;
/*     */ import org.c.a.b.r.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements c
/*     */ {
/*     */   private final g f;
/*     */   private final String description;
/*     */   
/*     */   public a() {
/*  55 */     String str2, str1 = d.b(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     boolean bool = str1.startsWith("R");
/*  61 */     if (str1.startsWith("V") || bool) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  66 */       str2 = str1.substring(0, 1);
/*     */     } else {
/*  68 */       throw new org.c.a.a.a("Invalid Java-based migration class name: " + getClass().getName() + " => ensure it starts with V or R, or implement org.flywaydb.core.api.migration.JavaMigration directly for non-default naming");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     l l = c.a(str1, str2, "__", new String[] { "" }, bool);
/*  78 */     this.f = (g)l.getLeft();
/*  79 */     this.description = (String)l.getRight();
/*     */   }
/*     */ 
/*     */   
/*     */   public g c() {
/*  84 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  89 */     return this.description;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer d() {
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fs() {
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fv() {
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */