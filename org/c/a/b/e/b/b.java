/*     */ package org.c.a.b.e.b;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.g;
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
/*     */ 
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public static boolean a(Connection paramConnection) {
/*     */     try {
/*  45 */       return (new d(paramConnection)).b("SELECT version()", new String[0]).contains("CockroachDB");
/*  46 */     } catch (Exception exception) {
/*  47 */       return false;
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
/*  62 */     super(paramb, paramConnection, paramBoolean);
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
/*  75 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  84 */     l("CockroachDB", "1.1");
/*  85 */     m("CockroachDB", "2.0");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  94 */     return (k)new a(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g d() {
/*     */     String str1;
/*     */     try {
/* 101 */       str1 = ((a)a()).a().b("SELECT value FROM crdb_internal.node_build_info where field='Version'", new String[0]);
/* 102 */       if (str1 == null) {
/* 103 */         str1 = ((a)a()).a().b("SELECT value FROM crdb_internal.node_build_info where field='Tag'", new String[0]);
/*     */       }
/* 105 */     } catch (SQLException sQLException) {
/* 106 */       throw new org.c.a.b.f.b("Unable to determine CockroachDB version", sQLException);
/*     */     } 
/* 108 */     int i = str1.indexOf(".");
/* 109 */     int j = Integer.parseInt(str1.substring(1, i));
/* 110 */     String str2 = str1.substring(i + 1);
/* 111 */     int k = Integer.parseInt(str2.substring(0, str2.indexOf(".")));
/* 112 */     return g.a(j + "." + k);
/*     */   }
/*     */   
/*     */   public String ez() {
/* 116 */     return "cockroachdb";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 121 */     return ((a)a()).a().b("(SELECT * FROM [SHOW SESSION_USER])", new String[0]);
/*     */   }
/*     */   
/*     */   public boolean fx() {
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 130 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eC() {
/* 141 */     return "TRUE";
/*     */   }
/*     */   
/*     */   public String eD() {
/* 145 */     return "FALSE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 150 */     return "\"" + n.replaceAll(paramString, "\"", "\"\"") + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 160 */     return false;
/*     */   }
/*     */   
/*     */   private static class a extends org.c.a.b.q.b {
/*     */     a(c param1c) {
/* 165 */       super(param1c);
/*     */     }
/*     */ 
/*     */     
/*     */     public j a() {
/* 170 */       return new d();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */