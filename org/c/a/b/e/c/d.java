/*     */ package org.c.a.b.e.c;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.e.a.c;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.e.a.g;
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
/*     */ public class d
/*     */   extends d<b>
/*     */ {
/*     */   d(org.c.a.b.h.d paramd, b paramb, String paramString) {
/*  42 */     super(paramd, paramb, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/*  47 */     return (this.a.b("SELECT COUNT(*) FROM syscat.schemata WHERE schemaname=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/*  52 */     int i = this.a.b("select count(*) from syscat.tables where tabschema = ?", new String[] { this.name });
/*  53 */     i += this.a.b("select count(*) from syscat.views where viewschema = ?", new String[] { this.name });
/*  54 */     i += this.a.b("select count(*) from syscat.sequences where seqschema = ?", new String[] { this.name });
/*  55 */     i += this.a.b("select count(*) from syscat.indexes where indschema = ?", new String[] { this.name });
/*  56 */     i += this.a.b("select count(*) from syscat.procedures where procschema = ?", new String[] { this.name });
/*  57 */     i += this.a.b("select count(*) from syscat.functions where funcschema = ?", new String[] { this.name });
/*  58 */     i += this.a.b("select count(*) from syscat.triggers where trigschema = ?", new String[] { this.name });
/*  59 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/*  64 */     this.a.a("CREATE SCHEMA " + ((b)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/*  69 */     clean();
/*  70 */     this.a.a("DROP SCHEMA " + ((b)this.a).d(new String[] { this.name }, ) + " RESTRICT", new Object[0]);
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
/*     */   protected void ia() throws SQLException {
/*  82 */     List<String> list = aM();
/*  83 */     if (!list.isEmpty())
/*     */     {
/*  85 */       for (String str : c("S", "TABLE")) {
/*  86 */         this.a.a(str, new Object[0]);
/*     */       }
/*     */     }
/*     */     
/*  90 */     for (String str : list) {
/*  91 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     for (String str : aI()) {
/*  99 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 103 */     for (String str : c("A", "ALIAS")) {
/* 104 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 108 */     for (String str : c("G", "TABLE")) {
/* 109 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 112 */     for (f f : a()) {
/* 113 */       f.drop();
/*     */     }
/*     */ 
/*     */     
/* 117 */     for (String str : aJ()) {
/* 118 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 122 */     for (String str : aK()) {
/* 123 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */     
/* 127 */     for (String str : aL()) {
/* 128 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 131 */     for (c c : a()) {
/* 132 */       c.drop();
/*     */     }
/*     */     
/* 135 */     for (g g : a()) {
/* 136 */       g.drop();
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
/*     */   private List<String> aK() throws SQLException {
/* 148 */     String str = "select SPECIFICNAME from SYSCAT.PROCEDURES where PROCSCHEMA = '" + this.name + "'";
/* 149 */     return d("DROP SPECIFIC PROCEDURE", str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aL() throws SQLException {
/* 159 */     String str = "select TRIGNAME from SYSCAT.TRIGGERS where TRIGSCHEMA = '" + this.name + "'";
/* 160 */     return d("DROP TRIGGER", str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aJ() throws SQLException {
/* 170 */     String str = "select SEQNAME from SYSCAT.SEQUENCES where SEQSCHEMA = '" + this.name + "' and SEQTYPE='S'";
/*     */     
/* 172 */     return d("DROP SEQUENCE", str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aI() throws SQLException {
/* 182 */     String str = "select TABNAME from SYSCAT.TABLES where TABSCHEMA = '" + this.name + "' and TABNAME NOT LIKE '%_V' and TYPE='V'";
/*     */     
/* 184 */     return d("DROP VIEW", str);
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
/*     */   private List<String> c(String paramString1, String paramString2) throws SQLException {
/* 196 */     String str = "select TABNAME from SYSCAT.TABLES where TYPE='" + paramString1 + "' and TABSCHEMA = '" + this.name + "'";
/*     */     
/* 198 */     return d("DROP " + paramString2, str);
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
/*     */   private List<String> d(String paramString1, String paramString2) throws SQLException {
/* 210 */     ArrayList<String> arrayList = new ArrayList();
/* 211 */     List list = this.a.a(paramString2, new String[0]);
/* 212 */     for (String str : list) {
/* 213 */       arrayList.add(paramString1 + " " + ((b)this.a).d(new String[] { this.name, str }));
/*     */     } 
/* 215 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aM() throws SQLException {
/* 222 */     ArrayList<String> arrayList = new ArrayList();
/* 223 */     f[] arrayOfF = a("select TABNAME from SYSCAT.TABLES where TEMPORALTYPE <> 'N' and TABSCHEMA = ?", new String[] { this.name });
/* 224 */     for (f f : arrayOfF) {
/* 225 */       arrayList.add("ALTER TABLE " + f.toString() + " DROP VERSIONING");
/*     */     }
/*     */     
/* 228 */     return arrayList;
/*     */   }
/*     */   
/*     */   private f[] a(String paramString, String... paramVarArgs) throws SQLException {
/* 232 */     List<String> list = this.a.a(paramString, paramVarArgs);
/* 233 */     f[] arrayOfF = new f[list.size()];
/* 234 */     for (byte b = 0; b < list.size(); b++) {
/* 235 */       arrayOfF[b] = new g(this.a, (b)this.a, this, list.get(b));
/*     */     }
/* 237 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 242 */     return a("select TABNAME from SYSCAT.TABLES where TYPE='T' and TABSCHEMA = ?", new String[] { this.name });
/*     */   }
/*     */ 
/*     */   
/*     */   protected c[] b() throws SQLException {
/* 247 */     List list = this.a.a("select p.SPECIFICNAME, p.FUNCNAME, substr( xmlserialize( xmlagg( xmltext( concat( ', ', TYPENAME ) ) ) as varchar( 1024 ) ), 3 ) as PARAMS from SYSCAT.FUNCTIONS f inner join SYSCAT.FUNCPARMS p on f.SPECIFICNAME = p.SPECIFICNAME where f.ORIGIN = 'Q' and p.FUNCSCHEMA = ? and p.ROWTYPE = 'P' group by p.SPECIFICNAME, p.FUNCNAME order by p.SPECIFICNAME", new Object[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 256 */     ArrayList<c> arrayList = new ArrayList();
/* 257 */     for (Map map : list) {
/* 258 */       arrayList.add(a((String)map
/* 259 */             .get("FUNCNAME"), 
/* 260 */             n.a((String)map.get("PARAMS"), ",")));
/*     */     }
/*     */     
/* 263 */     return arrayList.<c>toArray(new c[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 268 */     return new g(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(String paramString) {
/* 273 */     return new h(this.a, (b)this.a, this, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public c a(String paramString, String... paramVarArgs) {
/* 278 */     return new c(this.a, (b)this.a, this, paramString, paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */