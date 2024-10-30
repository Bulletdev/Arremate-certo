/*     */ package org.c.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum e
/*     */ {
/*  25 */   a("Pending", true, false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  30 */   b("Above Target", true, false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   c("Below Baseline", true, false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   d("Baseline", true, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   e("Ignored", true, false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   f("Missing", false, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  69 */   g("Failed (Missing)", false, true, true),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  74 */   h("Success", true, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   i("Undone", true, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  84 */   j("Available", true, false, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   k("Failed", true, true, true),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   l("Out of Order", true, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 108 */   m("Future", false, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 118 */   n("Failed (Future)", false, true, true),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 123 */   o("Outdated", true, true, false),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   p("Superseded", true, true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String displayName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean ce;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean cf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean cg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   e(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 159 */     this.displayName = paramString1;
/* 160 */     this.ce = paramBoolean1;
/* 161 */     this.cf = paramBoolean2;
/* 162 */     this.cg = paramBoolean3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayName() {
/* 169 */     return this.displayName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fq() {
/* 176 */     return this.cf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isResolved() {
/* 183 */     return this.ce;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fr() {
/* 190 */     return this.cg;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */