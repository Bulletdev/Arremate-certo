/*     */ package org.c.a.b.e.c;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.n.f;
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
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  45 */     super(paramb, paramConnection, paramBoolean);
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
/*  58 */     return new a(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  67 */     l("DB2", "9.7");
/*     */     
/*  69 */     d("IBM", "DB2", "10.5");
/*     */     
/*  71 */     m("DB2", "11.1");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/*  80 */     return (k)new f(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public org.c.a.b.n.b a() {
/*  85 */     return (org.c.a.b.n.b)new f("CREATE TABLE \"${schema}\".\"${table}\" (\n    \"installed_rank\" INT NOT NULL,\n    \"version\" VARCHAR(50),\n    \"description\" VARCHAR(200) NOT NULL,\n    \"type\" VARCHAR(20) NOT NULL,\n    \"script\" VARCHAR(1000) NOT NULL,\n    \"checksum\" INT,\n    \"installed_by\" VARCHAR(100) NOT NULL,\n    \"installed_on\" TIMESTAMP DEFAULT CURRENT TIMESTAMP NOT NULL,\n    \"execution_time\" INT NOT NULL,\n    \"success\" SMALLINT NOT NULL,\n    CONSTRAINT \"${table}_s\" CHECK (\"success\" in(0,1))\n) ORGANIZE BY ROW;\nALTER TABLE \"${schema}\".\"${table}\" ADD CONSTRAINT \"${table}_pk\" PRIMARY KEY (\"installed_rank\");\n\nCREATE INDEX \"${schema}\".\"${table}_s_idx\" ON \"${schema}\".\"${table}\" (\"success\");");
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
/*     */   public String a(f paramf, int paramInt) {
/* 111 */     return super.a(paramf, paramInt) + " WITH UR";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ez() {
/* 118 */     return "db2";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 123 */     return ((a)a()).a().b("select CURRENT_USER from sysibm.sysdummy1", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 138 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 143 */     return "0";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 148 */     return "\"" + paramString + "\"";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 158 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */