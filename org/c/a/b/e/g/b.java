/*     */ package org.c.a.b.e.g;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.n.f;
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
/*     */ 
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  46 */     super(paramb, paramConnection, paramBoolean);
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
/*  59 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  68 */     l("Informix", "12.10");
/*  69 */     m("Informix", "12.10");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  78 */     return (k)new a(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public org.c.a.b.n.b a() {
/*  83 */     return (org.c.a.b.n.b)new f("CREATE TABLE ${table} (\n    installed_rank INT NOT NULL,\n    version VARCHAR(50),\n    description VARCHAR(200) NOT NULL,\n    type VARCHAR(20) NOT NULL,\n    script LVARCHAR(1000) NOT NULL,\n    checksum INT,\n    installed_by VARCHAR(100) NOT NULL,\n    installed_on DATETIME YEAR TO FRACTION(3) DEFAULT CURRENT YEAR TO FRACTION(3) NOT NULL,\n    execution_time INT NOT NULL,\n    success SMALLINT NOT NULL\n);\nALTER TABLE ${table} ADD CONSTRAINT CHECK (success in (0,1)) CONSTRAINT ${table}_s;\nALTER TABLE ${table} ADD CONSTRAINT PRIMARY KEY (installed_rank) CONSTRAINT ${table}_pk;\nCREATE INDEX ${table}_s_idx ON ${table} (success);");
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
/*     */   public String ez() {
/* 102 */     return "informix";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 107 */     return a().getUserName();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 122 */     return "t";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 127 */     return "f";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 132 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   private static class a extends org.c.a.b.q.b {
/*     */     public a(c param1c) {
/* 147 */       super(param1c);
/*     */     }
/*     */ 
/*     */     
/*     */     public j a() {
/* 152 */       return new d();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */