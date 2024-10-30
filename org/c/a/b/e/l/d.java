/*     */ package org.c.a.b.e.l;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.q.j;
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
/*     */ public class d
/*     */   extends j
/*     */ {
/*  30 */   private static final a a = c.b(d.class);
/*     */   
/*  32 */   private static final Pattern f = Pattern.compile("^((((CREATE( OR REPLACE)?)|ALTER) (PROCEDURE|FUNCTION))|CREATE TRIGGER|DO).*");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private int iD = 0;
/*  39 */   private String le = "";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   d() {
/*  45 */     super(org.c.a.b.q.d.e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/*  50 */     if (paramString.startsWith("N'") || paramString.startsWith("X'") || paramString
/*  51 */       .startsWith("DATE'") || paramString.startsWith("TIME'") || paramString.startsWith("TIMESTAMP'")) {
/*  52 */       return paramString.substring(paramString.indexOf("'"));
/*     */     }
/*  54 */     return super.aP(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected org.c.a.b.q.d a(String paramString, org.c.a.b.q.d paramd) {
/*  60 */     if (fV() && this.le.length() < 16) {
/*  61 */       String str = aW(paramString);
/*  62 */       this.le += str + " ";
/*  63 */       this.le = n.bh(n.bg(this.le));
/*     */     } 
/*  65 */     boolean bool = f.matcher(this.le).matches();
/*     */     
/*  67 */     if (bool) {
/*  68 */       if (paramString.startsWith("BEGIN")) {
/*  69 */         this.iD++;
/*     */       }
/*     */       
/*  72 */       if (paramString.endsWith("END;")) {
/*  73 */         this.iD--;
/*  74 */         if (this.iD < 0) {
/*  75 */           a.warn("SQL statement parsed unsuccessfully: found unpaired 'END;' in statement");
/*     */         }
/*  77 */         if (this.iD <= 0) {
/*  78 */           bool = false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     if (bool) {
/*  84 */       return null;
/*     */     }
/*  86 */     return this.g;
/*     */   }
/*     */   
/*     */   private static String aW(String paramString) {
/*  90 */     int i = paramString.indexOf("--");
/*  91 */     int k = paramString.indexOf("/*");
/*  92 */     if (-1 != i) {
/*  93 */       if (-1 != k) {
/*  94 */         return paramString.substring(0, Math.min(k, i));
/*     */       }
/*  96 */       return paramString.substring(0, i);
/*     */     } 
/*     */     
/*  99 */     if (-1 != k) {
/* 100 */       return paramString.substring(0, k);
/*     */     }
/*     */     
/* 103 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\l\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */