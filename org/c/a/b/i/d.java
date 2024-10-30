/*     */ package org.c.a.b.i;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.nio.charset.Charset;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.n.b.a;
/*     */ import org.c.a.b.r.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*  34 */   private static final a a = c.b(d.class);
/*  35 */   private static final String version = eF();
/*     */   
/*     */   private static boolean cR;
/*  38 */   public static final a d = (a)a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printVersion() {
/*  68 */     if (cR) {
/*     */       return;
/*     */     }
/*  71 */     cR = true;
/*     */ 
/*     */     
/*  74 */     ih();
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
/*     */   public static void ih() {
/*  90 */     a.info(d + " " + version + " by Boxfuse");
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
/*     */   private static String eF() {
/*     */     String str;
/* 128 */     a a1 = new a(null, "org/flywaydb/core/internal/version.txt", d.class.getClassLoader(), Charset.forName("UTF-8"));
/* 129 */     org.c.a.b.j.d d1 = null;
/*     */     try {
/* 131 */       d1 = a1.a();
/* 132 */       str = d1.a().eG();
/*     */     } finally {
/* 134 */       i.close((Closeable)d1);
/*     */     } 
/* 136 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\i\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */