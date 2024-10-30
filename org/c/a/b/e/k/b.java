/*     */ package org.c.a.b.e.k;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.q.j;
/*     */ import org.c.a.b.q.k;
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
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public static boolean c(Connection paramConnection) {
/*     */     try {
/*  43 */       return (new d(paramConnection)).b("SELECT version()", new String[0]).contains("Redshift");
/*  44 */     } catch (Exception exception) {
/*  45 */       return false;
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
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  60 */     super(paramb, paramConnection, paramBoolean);
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
/*     */   protected a a(Connection paramConnection) {
/*  73 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  91 */     return (k)new a(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/*  96 */     return "redshift";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 101 */     return ((a)a()).a().b("SELECT current_user", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 106 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 116 */     return "TRUE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 121 */     return "FALSE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 126 */     return aV(paramString);
/*     */   }
/*     */   
/*     */   static String aV(String paramString) {
/* 130 */     return "\"" + n.replaceAll(paramString, "\"", "\"\"") + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 135 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   private static class a extends org.c.a.b.q.b {
/*     */     public a(c param1c) {
/* 145 */       super(param1c);
/*     */     }
/*     */ 
/*     */     
/*     */     public j a() {
/* 150 */       return new d();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */