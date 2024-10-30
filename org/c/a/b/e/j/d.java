/*     */ package org.c.a.b.e.j;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.l.c;
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
/*     */ public class d
/*     */   extends b<b>
/*     */ {
/*     */   public d(b paramb, Connection paramConnection, boolean paramBoolean) {
/*  43 */     super(paramb, paramConnection, paramBoolean);
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
/*     */   protected b a(Connection paramConnection) {
/*  56 */     return new b(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  65 */     l("PostgreSQL", "9.0");
/*     */     
/*  67 */     d("PostgreSQL", "PostgreSQL", "9.3");
/*     */     
/*  69 */     n("PostgreSQL", "10");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  78 */     return (k)new g(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/*  83 */     return "postgresql";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/*  88 */     return ((b)a()).a().b("SELECT current_user", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/*  98 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 103 */     return "TRUE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 108 */     return "FALSE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 113 */     return aU(paramString);
/*     */   }
/*     */   
/*     */   static String aU(String paramString) {
/* 117 */     return "\"" + n.replaceAll(paramString, "\"", "\"\"") + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 127 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */