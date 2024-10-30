/*     */ package org.c.a.b.e.k;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.e.a.g;
/*     */ import org.c.a.b.h.d;
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
/*     */   extends d<b>
/*     */ {
/*     */   c(d paramd, b paramb, String paramString) {
/*  40 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  45 */     return (this.a.b("SELECT COUNT(*) FROM pg_namespace WHERE nspname=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  50 */     return !this.a.b("SELECT EXISTS (   SELECT 1\n   FROM   pg_catalog.pg_class c\n   JOIN   pg_catalog.pg_namespace n ON n.oid = c.relnamespace\n   WHERE  n.nspname = ?)", new String[] { this.name });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  58 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  63 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " CASCADE", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  68 */     for (String str : aI()) {
/*  69 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  72 */     for (f f : a()) {
/*  73 */       f.drop();
/*     */     }
/*     */     
/*  76 */     for (String str : aR()) {
/*  77 */       this.a.a(str, new Object[0]);
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
/*     */   private List<String> aR() throws SQLException {
/*  89 */     List list = this.a.a("SELECT proname, oidvectortypes(proargtypes) AS args FROM pg_proc INNER JOIN pg_namespace ns ON (pg_proc.pronamespace = ns.oid) LEFT JOIN pg_depend dep ON dep.objid = pg_proc.oid AND dep.deptype = 'e' WHERE pg_proc.proisagg = false AND ns.nspname = ? AND dep.objid IS NULL", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     ArrayList<String> arrayList = new ArrayList();
/* 100 */     for (Map map : list) {
/* 101 */       arrayList.add("DROP FUNCTION " + ((b)this.a).d(new String[] { this.name, (String)map.get("proname") }) + "(" + (String)map.get("args") + ") CASCADE");
/*     */     } 
/* 103 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aI() throws SQLException {
/* 114 */     List list = this.a.a("SELECT relname FROM pg_catalog.pg_class c JOIN pg_namespace n ON n.oid = c.relnamespace LEFT JOIN pg_depend dep ON dep.objid = c.oid AND dep.deptype = 'e' WHERE c.relkind = 'v' AND  n.nspname = ? AND dep.objid IS NULL", new String[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     ArrayList<String> arrayList = new ArrayList();
/* 122 */     for (String str : list) {
/* 123 */       arrayList.add("DROP VIEW IF EXISTS " + ((b)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*     */     
/* 126 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 132 */     List<String> list = this.a.a("SELECT t.table_name FROM information_schema.tables t WHERE table_schema=? AND table_type='BASE TABLE'", new String[] { this.name });
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
/* 143 */     f[] arrayOfF = new f[list.size()];
/* 144 */     for (byte b = 0; b < list.size(); b++) {
/* 145 */       arrayOfF[b] = new e(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 147 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 152 */     return new e(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(String paramString) {
/* 157 */     return new f(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\k\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */