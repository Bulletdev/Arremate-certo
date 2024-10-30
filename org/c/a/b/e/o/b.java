/*     */ package org.c.a.b.e.o;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.q.d;
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
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
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
/*     */   protected a a(Connection paramConnection) {
/*  56 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hX() {
/*  65 */     l("Sybase ASE", "15.7");
/*  66 */     m("Sybase ASE", "16.2");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  75 */     return (k)new e(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/*  80 */     return new d("GO", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/*  85 */     return "sybasease";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/*  90 */     return ((a)a()).a().b("SELECT user_name()", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 105 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 110 */     return "0";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String aN(String paramString) {
/* 116 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\o\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */