/*     */ package org.c.a.b.e.e;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.q.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   boolean cC;
/*     */   
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  49 */     super(paramb, paramConnection, paramBoolean);
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
/*  62 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected g d() {
/*     */     try {
/*  72 */       int i = ((a)a()).a().b("SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME = 'info.BUILD_ID'", new String[0]);
/*     */       
/*  74 */       return g.a(super.d().getVersion() + "." + i);
/*  75 */     } catch (SQLException sQLException) {
/*  76 */       throw new org.c.a.b.f.b("Unable to determine H2 build ID", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  82 */     l("H2", "1.2.137");
/*     */     
/*  84 */     d("H2", "H2", "1.4");
/*     */     
/*  86 */     m("H2", "1.4.197");
/*  87 */     this.cC = c().H("1.4.197");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  96 */     return (k)new e(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/* 101 */     return "h2";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 106 */     return ((a)a()).a().b("SELECT USER()", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 121 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 126 */     return "0";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 131 */     return "\"" + paramString + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 136 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */