/*     */ package org.c.a.b.e.h;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.h.d;
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
/*     */ public class b
/*     */   extends b<a>
/*     */ {
/*  35 */   private static final a a = c.b(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean cH;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/*  58 */     super(paramb, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.cH = b(paramConnection);
/*     */   }
/*     */   
/*     */   static boolean b(Connection paramConnection) {
/*     */     try {
/*  69 */       if ("ENFORCING".equals((new d(paramConnection)).b("select VARIABLE_VALUE from performance_schema.global_variables where variable_name = 'pxc_strict_mode'", new String[0]))) {
/*     */ 
/*     */         
/*  72 */         a.debug("Detected Percona XtraDB Cluster in strict mode");
/*  73 */         return true;
/*     */       } 
/*  75 */     } catch (SQLException sQLException) {
/*  76 */       a.debug("Unable to detect whether we are running in a Percona XtraDB Cluster. Assuming not to be.");
/*     */     } 
/*     */     
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   boolean fF() {
/*  83 */     return this.cG;
/*     */   }
/*     */   
/*     */   boolean fG() {
/*  87 */     return this.cH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected a a(Connection paramConnection) {
/*  96 */     return new a((org.c.a.a.c.b)this.a, this, paramConnection, this.cA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void hX() {
/*     */     boolean bool;
/*     */     try {
/* 107 */       this.cG = this.a.getDatabaseProductVersion().contains("MariaDB");
/* 108 */       bool = this.a.getDriverName().contains("MariaDB");
/* 109 */     } catch (SQLException sQLException) {
/* 110 */       throw new org.c.a.b.f.b("Unable to determine database product version and driver", sQLException);
/*     */     } 
/* 112 */     String str = this.cG ? "MariaDB" : "MySQL";
/*     */     
/* 114 */     l(str, "5.1");
/*     */     
/* 116 */     d(this.cG ? "MariaDB" : "Oracle", str, "5.5");
/*     */     
/* 118 */     if (this.cG) {
/* 119 */       m(str, "10.3");
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 124 */       if (bool) {
/* 125 */         a.warn("You are connected to a MySQL " + c() + " database using the MariaDB driver. This is known to cause issues. An upgrade to Oracle's MySQL JDBC driver is highly recommended.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 132 */       m(str, "8.0");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected k a(c paramc) {
/* 142 */     return (k)new f(paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public String ez() {
/* 147 */     return "mysql";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String eB() throws SQLException {
/* 152 */     return ((a)a()).a().b("SELECT SUBSTRING_INDEX(USER(),'@',1)", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fx() {
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fy() {
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eC() {
/* 167 */     return "1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String eD() {
/* 172 */     return "0";
/*     */   }
/*     */ 
/*     */   
/*     */   public String aN(String paramString) {
/* 177 */     return "`" + paramString + "`";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fz() {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 187 */     return !this.cH;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\h\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */