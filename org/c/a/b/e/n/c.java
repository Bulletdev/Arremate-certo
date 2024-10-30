/*     */ package org.c.a.b.e.n;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.f.b;
/*     */ import org.c.a.b.n.b;
/*     */ import org.c.a.b.n.f;
/*     */ import org.c.a.b.q.d;
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
/*     */ 
/*     */ public class c
/*     */   extends b<b>
/*     */ {
/*     */   private final boolean cL;
/*     */   
/*     */   public c(b paramb, Connection paramConnection, boolean paramBoolean) {
/*  50 */     super(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  56 */       this.cL = "SQL Azure".equals(((b)a()).a().b("SELECT CAST(SERVERPROPERTY('edition') AS VARCHAR)", new String[0]));
/*     */     }
/*  58 */     catch (SQLException sQLException) {
/*  59 */       throw new b("Unable to determine database edition", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected b a(Connection paramConnection) {
/*  69 */     return new b(this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*  78 */     l("SQL Server", "10.0");
/*     */     
/*  80 */     d("Microsoft", "SQL Server", "12");
/*     */     
/*  82 */     m("SQL Server", "14.0");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(g paramg) {
/*  87 */     if (c().H("8")) {
/*  88 */       if ("8".equals(c().et())) {
/*  89 */         return "2000";
/*     */       }
/*  91 */       if ("9".equals(c().et())) {
/*  92 */         return "2005";
/*     */       }
/*  94 */       if ("10".equals(c().et())) {
/*  95 */         if ("0".equals(c().eu())) {
/*  96 */           return "2008";
/*     */         }
/*  98 */         return "2008 R2";
/*     */       } 
/* 100 */       if ("11".equals(c().et())) {
/* 101 */         return "2012";
/*     */       }
/* 103 */       if ("12".equals(c().et())) {
/* 104 */         return "2014";
/*     */       }
/* 106 */       if ("13".equals(c().et())) {
/* 107 */         return "2016";
/*     */       }
/* 109 */       if ("14".equals(c().et())) {
/* 110 */         return "2017";
/*     */       }
/*     */     } 
/* 113 */     return super.a(paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(org.c.a.b.l.c paramc) {
/* 122 */     return (k)new f(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/* 127 */     return "sqlserver";
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 132 */     return new d("GO", true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 137 */     return ((b)a()).a().b("SELECT SUSER_SNAME()", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 152 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 157 */     return "0";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String escapeIdentifier(String paramString) {
/* 167 */     return n.replaceAll(paramString, "]", "]]");
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 172 */     return "[" + escapeIdentifier(paramString) + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected b a() {
/* 187 */     return (b)new f("CREATE TABLE ${table_quoted} (\n    [installed_rank] INT NOT NULL,\n    [version] NVARCHAR(50),\n    [description] NVARCHAR(200),\n    [type] NVARCHAR(20) NOT NULL,\n    [script] NVARCHAR(1000) NOT NULL,\n    [checksum] INT,\n    [installed_by] NVARCHAR(100) NOT NULL,\n    [installed_on] DATETIME NOT NULL DEFAULT GETDATE(),\n    [execution_time] INT NOT NULL,\n    [success] BIT NOT NULL\n);\nALTER TABLE ${table_quoted} ADD CONSTRAINT [${table}_pk] PRIMARY KEY ([installed_rank]);\n\nCREATE INDEX [${table}_s_idx] ON ${table_quoted} ([success]);\nGO\n");
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
/*     */   boolean fP() {
/* 209 */     return this.cL;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */