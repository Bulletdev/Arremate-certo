/*     */ package org.c.a.b.e.j;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
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
/*     */ public class e
/*     */   extends d<d>
/*     */ {
/*     */   e(d paramd, d paramd1, String paramString) {
/*  42 */     super(paramd, paramd1, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  47 */     return (this.a.b("SELECT COUNT(*) FROM pg_namespace WHERE nspname=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  52 */     return !this.a.b("SELECT EXISTS (\n    SELECT c.oid FROM pg_catalog.pg_class c\n    JOIN pg_catalog.pg_namespace n ON n.oid = c.relnamespace\n    LEFT JOIN pg_catalog.pg_depend d ON d.objid = c.oid AND d.deptype = 'e'\n    WHERE  n.nspname = ? AND d.objid IS NULL AND c.relkind IN ('r', 'v', 'S', 't')\n  UNION ALL\n    SELECT t.oid FROM pg_catalog.pg_type t\n    JOIN pg_catalog.pg_namespace n ON n.oid = t.typnamespace\n    LEFT JOIN pg_catalog.pg_depend d ON d.objid = t.oid AND d.deptype = 'e'\n    WHERE n.nspname = ? AND d.objid IS NULL AND t.typcategory NOT IN ('A', 'C')\n  UNION ALL\n    SELECT p.oid FROM pg_catalog.pg_proc p\n    JOIN pg_catalog.pg_namespace n ON n.oid = p.pronamespace\n    LEFT JOIN pg_catalog.pg_depend d ON d.objid = p.oid AND d.deptype = 'e'\n    WHERE n.nspname = ? AND d.objid IS NULL\n)", new String[] { this.name, this.name, this.name });
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
/*     */   protected void hY() throws SQLException {
/*  72 */     this.a.a("CREATE SCHEMA " + ((d)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  77 */     this.a.a("DROP SCHEMA " + ((d)this.a).d(new String[] { this.name }, ) + " CASCADE", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/*  85 */     for (String str : aU()) {
/*  86 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     for (String str : aI()) {
/*  93 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/*  96 */     for (f f : a()) {
/*  97 */       f.drop();
/*     */     }
/*     */     
/* 100 */     for (String str : a(true)) {
/* 101 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 104 */     for (String str : aR()) {
/* 105 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 108 */     for (String str : aS()) {
/* 109 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 112 */     for (String str : aT()) {
/* 113 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 116 */     for (String str : aJ()) {
/* 117 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 120 */     for (String str : a(false)) {
/* 121 */       this.a.a(str, new Object[0]);
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
/*     */   private List<String> aJ() throws SQLException {
/* 133 */     List list = this.a.a("SELECT sequence_name FROM information_schema.sequences WHERE sequence_schema=?", new String[] { this.name });
/*     */ 
/*     */     
/* 136 */     ArrayList<String> arrayList = new ArrayList();
/* 137 */     for (String str : list) {
/* 138 */       arrayList.add("DROP SEQUENCE IF EXISTS " + ((d)this.a).d(new String[] { this.name, str }));
/*     */     } 
/*     */     
/* 141 */     return arrayList;
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
/*     */   private List<String> a(boolean paramBoolean) throws SQLException {
/* 153 */     List list = this.a.a("select typname, typcategory from pg_catalog.pg_type t left join pg_depend dep on dep.objid = t.oid and dep.deptype = 'e' where (t.typrelid = 0 OR (SELECT c.relkind = 'c' FROM pg_catalog.pg_class c WHERE c.oid = t.typrelid)) and NOT EXISTS(SELECT 1 FROM pg_catalog.pg_type el WHERE el.oid = t.typelem AND el.typarray = t.oid) and t.typnamespace in (select oid from pg_catalog.pg_namespace where nspname = ?) and dep.objid is null and t.typtype != 'd'", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     ArrayList<String> arrayList = new ArrayList();
/* 164 */     for (Map map : list) {
/* 165 */       arrayList.add("DROP TYPE IF EXISTS " + ((d)this.a).d(new String[] { this.name, (String)map.get("typname") }) + " CASCADE");
/*     */     } 
/*     */     
/* 168 */     if (paramBoolean) {
/* 169 */       for (Map map : list) {
/*     */         
/* 171 */         if (Arrays.<String>asList(new String[] { "P", "U" }).contains(map.get("typcategory"))) {
/* 172 */           arrayList.add("CREATE TYPE " + ((d)this.a).d(new String[] { this.name, (String)map.get("typname") }));
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 177 */     return arrayList;
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
/* 188 */     List list = this.a.a("SELECT proname, oidvectortypes(proargtypes) AS args, pg_proc.proisagg as agg FROM pg_proc INNER JOIN pg_namespace ns ON (pg_proc.pronamespace = ns.oid) LEFT JOIN pg_depend dep ON dep.objid = pg_proc.oid AND dep.deptype = 'e' WHERE ns.nspname = ? AND dep.objid IS NULL", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     ArrayList<String> arrayList = new ArrayList();
/* 199 */     for (Map map : list) {
/* 200 */       String str = Q((String)map.get("agg")) ? "AGGREGATE" : "FUNCTION";
/* 201 */       arrayList.add("DROP " + str + " IF EXISTS " + ((d)this.a)
/* 202 */           .d(new String[] { this.name, (String)map.get("proname") }) + "(" + (String)map.get("args") + ") CASCADE");
/*     */     } 
/* 204 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean Q(String paramString) {
/* 208 */     return (paramString != null && paramString.toLowerCase(Locale.ENGLISH).startsWith("t"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aS() throws SQLException {
/* 219 */     List list = this.a.a("SELECT t.typname FROM pg_catalog.pg_type t INNER JOIN pg_catalog.pg_namespace n ON n.oid = t.typnamespace WHERE n.nspname = ? and t.typtype = 'e'", new String[] { this.name });
/*     */ 
/*     */     
/* 222 */     ArrayList<String> arrayList = new ArrayList();
/* 223 */     for (String str : list) {
/* 224 */       arrayList.add("DROP TYPE " + ((d)this.a).d(new String[] { this.name, str }));
/*     */     } 
/*     */     
/* 227 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aT() throws SQLException {
/* 238 */     List list = this.a.a("SELECT domain_name FROM information_schema.domains WHERE domain_schema=?", new String[] { this.name });
/*     */ 
/*     */     
/* 241 */     ArrayList<String> arrayList = new ArrayList();
/* 242 */     for (String str : list) {
/* 243 */       arrayList.add("DROP DOMAIN " + ((d)this.a).d(new String[] { this.name, str }));
/*     */     } 
/*     */     
/* 246 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aU() throws SQLException {
/* 257 */     List list = this.a.a("SELECT relname FROM pg_catalog.pg_class c JOIN pg_namespace n ON n.oid = c.relnamespace WHERE c.relkind = 'm' AND n.nspname = ?", new String[] { this.name });
/*     */ 
/*     */ 
/*     */     
/* 261 */     ArrayList<String> arrayList = new ArrayList();
/* 262 */     for (String str : list) {
/* 263 */       arrayList.add("DROP MATERIALIZED VIEW IF EXISTS " + ((d)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*     */     
/* 266 */     return arrayList;
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
/* 277 */     List list = this.a.a("SELECT relname FROM pg_catalog.pg_class c JOIN pg_namespace n ON n.oid = c.relnamespace LEFT JOIN pg_depend dep ON dep.objid = c.oid AND dep.deptype = 'e' WHERE c.relkind = 'v' AND  n.nspname = ? AND dep.objid IS NULL", new String[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     ArrayList<String> arrayList = new ArrayList();
/* 285 */     for (String str : list) {
/* 286 */       arrayList.add("DROP VIEW IF EXISTS " + ((d)this.a).d(new String[] { this.name, str }) + " CASCADE");
/*     */     } 
/*     */     
/* 289 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 295 */     List<String> list = this.a.a("SELECT t.table_name FROM information_schema.tables t WHERE table_schema=? AND table_type='BASE TABLE' AND NOT (SELECT EXISTS (SELECT inhrelid FROM pg_catalog.pg_inherits WHERE inhrelid = (quote_ident(t.table_schema)||'.'||quote_ident(t.table_name))::regclass::oid))", new String[] { this.name });
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
/* 309 */     f[] arrayOfF = new f[list.size()];
/* 310 */     for (byte b = 0; b < list.size(); b++) {
/* 311 */       arrayOfF[b] = new h(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 313 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 318 */     return new h(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(String paramString) {
/* 323 */     return new i(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */