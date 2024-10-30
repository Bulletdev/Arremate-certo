/*     */ package org.c.a.b.e.d;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.q.j;
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
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  44 */     super(paramb, paramConnection, paramBoolean);
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
/*  57 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  66 */     l("Derby", "10.11.1.1");
/*     */     
/*  68 */     d("Apache", "Derby", "10.14");
/*     */     
/*  70 */     m("Derby", "10.14");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  79 */     return (k)new a(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/*  84 */     return "derby";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/*  89 */     return ((a)a()).a().b("SELECT CURRENT_USER FROM SYSIBM.SYSDUMMY1", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 104 */     return "true";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 109 */     return "false";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 114 */     return "\"" + paramString + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   private static class a extends org.c.a.b.q.b {
/*     */     public a(c param1c) {
/* 129 */       super(param1c);
/*     */     }
/*     */ 
/*     */     
/*     */     public j a() {
/* 134 */       return new d();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */