/*     */ package org.c.a.a.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  25 */   a("beforeClean"),
/*     */ 
/*     */ 
/*     */   
/*  29 */   b("afterClean"),
/*     */ 
/*     */ 
/*     */   
/*  33 */   c("afterCleanError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   d("beforeMigrate"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   e("beforeEachMigrate"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   f("beforeEachMigrateStatement"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   g("afterEachMigrateStatement"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   h("afterEachMigrateStatementError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   i("afterEachMigrate"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   j("afterEachMigrateError"),
/*     */ 
/*     */ 
/*     */   
/*  75 */   k("afterMigrate"),
/*     */ 
/*     */ 
/*     */   
/*  79 */   l("afterMigrateError"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   m("beforeUndo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   n("beforeEachUndo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  97 */   o("beforeEachUndoStatement"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 103 */   p("afterEachUndoStatement"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 109 */   q("afterEachUndoStatementError"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   r("afterEachUndo"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 121 */   s("afterEachUndoError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 126 */   t("afterUndo"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 131 */   u("afterUndoError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 136 */   v("beforeValidate"),
/*     */ 
/*     */ 
/*     */   
/* 140 */   w("afterValidate"),
/*     */ 
/*     */ 
/*     */   
/* 144 */   x("afterValidateError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 149 */   y("beforeBaseline"),
/*     */ 
/*     */ 
/*     */   
/* 153 */   z("afterBaseline"),
/*     */ 
/*     */ 
/*     */   
/* 157 */   A("afterBaselineError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   B("beforeRepair"),
/*     */ 
/*     */ 
/*     */   
/* 166 */   C("afterRepair"),
/*     */ 
/*     */ 
/*     */   
/* 170 */   D("afterRepairError"),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 175 */   E("beforeInfo"),
/*     */ 
/*     */ 
/*     */   
/* 179 */   F("afterInfo"),
/*     */ 
/*     */ 
/*     */   
/* 183 */   G("afterInfoError");
/*     */   
/*     */   private final String id;
/*     */   
/*     */   e(String paramString1) {
/* 188 */     this.id = paramString1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 195 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static e a(String paramString) {
/* 204 */     for (e e1 : values()) {
/* 205 */       if (e1.id.equals(paramString)) {
/* 206 */         return e1;
/*     */       }
/*     */     } 
/* 209 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 214 */     return this.id;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */