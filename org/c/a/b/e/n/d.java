/*     */ package org.c.a.b.e.n;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
/*     */ import org.c.a.b.h.h;
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
/*     */   extends d<c>
/*     */ {
/*  34 */   private static final org.c.a.a.f.a a = c.b(d.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String databaseName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum b
/*     */   {
/*  48 */     a("AF"),
/*     */ 
/*     */ 
/*     */     
/*  52 */     b("C"),
/*     */ 
/*     */ 
/*     */     
/*  56 */     c("D"),
/*     */ 
/*     */ 
/*     */     
/*  60 */     d("F"),
/*     */ 
/*     */ 
/*     */     
/*  64 */     e("IF"),
/*     */ 
/*     */ 
/*     */     
/*  68 */     f("FN"),
/*     */ 
/*     */ 
/*     */     
/*  72 */     g("FS"),
/*     */ 
/*     */ 
/*     */     
/*  76 */     h("FT"),
/*     */ 
/*     */ 
/*     */     
/*  80 */     i("P"),
/*     */ 
/*     */ 
/*     */     
/*  84 */     j("PC"),
/*     */ 
/*     */ 
/*     */     
/*  88 */     k("R"),
/*     */ 
/*     */ 
/*     */     
/*  92 */     l("SN"),
/*     */ 
/*     */ 
/*     */     
/*  96 */     m("TF"),
/*     */ 
/*     */ 
/*     */     
/* 100 */     n("TA"),
/*     */ 
/*     */ 
/*     */     
/* 104 */     o("TR"),
/*     */ 
/*     */ 
/*     */     
/* 108 */     p("UQ"),
/*     */ 
/*     */ 
/*     */     
/* 112 */     q("U"),
/*     */ 
/*     */ 
/*     */     
/* 116 */     r("V"),
/*     */ 
/*     */ 
/*     */     
/* 120 */     s("SO");
/*     */     
/*     */     final String code;
/*     */     
/*     */     b(String param1String1) {
/* 125 */       assert param1String1 != null;
/* 126 */       this.code = param1String1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class a
/*     */   {
/*     */     final String name;
/*     */ 
/*     */ 
/*     */     
/*     */     final long bP;
/*     */ 
/*     */ 
/*     */     
/*     */     a(d this$0, long param1Long, String param1String) {
/* 144 */       assert param1String != null;
/* 145 */       this.bP = param1Long;
/* 146 */       this.name = param1String;
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
/*     */   
/*     */   d(org.c.a.b.h.d paramd, c paramc, String paramString1, String paramString2) {
/* 159 */     super(paramd, paramc, paramString2);
/* 160 */     this.databaseName = paramString1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean fB() throws SQLException {
/* 165 */     return (this.a.b("SELECT COUNT(*) FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME=?", new String[] { this.name }) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fC() throws SQLException {
/* 173 */     boolean bool = a(new b[] { b.f, (b)b.a, b.g, b.h, b.m, b.i, b.j, b.q, b.l, b.s, b.d, b.r }).isEmpty();
/* 174 */     if (bool) {
/* 175 */       int i = this.a.b("SELECT count(*) FROM ( SELECT t.name FROM sys.types t INNER JOIN sys.schemas s ON t.schema_id = s.schema_id WHERE t.is_user_defined = 1 AND s.name = ? Union SELECT name FROM sys.assemblies WHERE is_user_defined=1) R", new String[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       bool = (i == 0);
/*     */     } 
/*     */     
/* 185 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hY() throws SQLException {
/* 190 */     this.a.a("CREATE SCHEMA " + ((c)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hZ() throws SQLException {
/* 195 */     clean();
/* 196 */     this.a.a("DROP SCHEMA " + ((c)this.a).d(new String[] { this.name }, ), new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ia() throws SQLException {
/* 201 */     List<a> list = a(new b[] { b.q });
/*     */     
/* 203 */     for (String str : aX()) {
/* 204 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 207 */     for (String str : l(list)) {
/* 208 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 211 */     for (String str : o(list)) {
/* 212 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 215 */     for (String str : p(list)) {
/* 216 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 219 */     for (String str : n(list)) {
/* 220 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 225 */     for (String str : m(list)) {
/*     */       try {
/* 227 */         this.a.a(str, new Object[0]);
/* 228 */       } catch (SQLException sQLException) {
/* 229 */         a.debug("Ignoring dependency-related error: " + sQLException.getMessage());
/*     */       } 
/*     */     } 
/* 232 */     for (String str : a("FUNCTION", new b[] { b.f, b.g, b.h, b.m, b.e })) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */         
/* 239 */         this.a.a(str, new Object[0]);
/* 240 */       } catch (SQLException sQLException) {
/* 241 */         a.debug("Ignoring dependency-related error: " + sQLException.getMessage());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 246 */     for (String str : m(list)) {
/* 247 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 250 */     for (String str : a("PROCEDURE", new b[] { b.i, b.j
/*     */         }))
/*     */     {
/* 253 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 256 */     for (String str : a("VIEW", new b[] { b.r })) {
/* 257 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 260 */     for (String str : a("FUNCTION", new b[] { b.f, b.g, b.h, b.m, b.e
/*     */ 
/*     */ 
/*     */         
/*     */         }))
/*     */     {
/* 266 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 269 */     for (f f : a()) {
/* 270 */       f.drop();
/*     */     }
/*     */     
/* 273 */     for (String str : a("AGGREGATE", new b[] { (b)b.a })) {
/* 274 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 277 */     for (String str : aV()) {
/* 278 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 281 */     for (String str : aW()) {
/* 282 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 285 */     for (String str : a("SYNONYM", new b[] { b.l })) {
/* 286 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 289 */     for (String str : a("RULE", new b[] { b.k })) {
/* 290 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */     
/* 293 */     for (String str : a("DEFAULT", new b[] { b.c })) {
/* 294 */       this.a.a(str, new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     for (String str : a("SEQUENCE", new b[] { b.s })) {
/* 301 */       this.a.a(str, new Object[0]);
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
/*     */ 
/*     */ 
/*     */   
/*     */   private List<a> a(b... paramVarArgs) throws SQLException {
/* 316 */     return a((a)null, paramVarArgs);
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
/*     */   private List<a> a(a parama, b... paramVarArgs) throws SQLException {
/* 328 */     assert paramVarArgs != null && paramVarArgs.length > 0;
/* 329 */     StringBuilder stringBuilder = new StringBuilder("SELECT obj.object_id, obj.name FROM sys.objects AS obj LEFT JOIN sys.extended_properties AS eps ON obj.object_id = eps.major_id AND eps.class = 1 AND eps.minor_id = 0 AND eps.name='microsoft_database_tools_support' WHERE SCHEMA_NAME(obj.schema_id) = '" + this.name + "'  AND eps.major_id IS NULL AND obj.is_ms_shipped = 0 AND obj.type IN (");
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
/* 343 */     boolean bool = true;
/* 344 */     for (b b1 : paramVarArgs) {
/* 345 */       if (!bool) {
/* 346 */         stringBuilder.append(", ");
/*     */       }
/* 348 */       stringBuilder.append("'").append(b1.code).append("'");
/* 349 */       bool = false;
/*     */     } 
/* 351 */     stringBuilder.append(")");
/*     */     
/* 353 */     if (parama != null)
/*     */     {
/* 355 */       stringBuilder.append(" AND obj.parent_object_id = ").append(parama.bP);
/*     */     }
/*     */     
/* 358 */     stringBuilder.append(" order by create_date desc");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     return this.a.a(stringBuilder.toString(), new h<a>(this)
/*     */         {
/*     */           public d.a a(ResultSet param1ResultSet) throws SQLException {
/* 368 */             return new d.a(this.a, param1ResultSet.getLong("object_id"), param1ResultSet.getString("name"));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> l(List<a> paramList) throws SQLException {
/* 381 */     ArrayList<String> arrayList = new ArrayList();
/* 382 */     for (a a1 : paramList) {
/* 383 */       List<a> list = a(a1, new b[] { b.d, b.b });
/*     */       
/* 385 */       for (a a2 : list) {
/* 386 */         arrayList.add("ALTER TABLE " + ((c)this.a).d(new String[] { this.name, a1.name }) + " DROP CONSTRAINT " + ((c)this.a)
/* 387 */             .d(new String[] { a2.name }));
/*     */       } 
/*     */     } 
/* 390 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> m(List<a> paramList) throws SQLException {
/* 401 */     ArrayList<String> arrayList = new ArrayList();
/* 402 */     for (a a1 : paramList) {
/* 403 */       String str = ((c)this.a).d(new String[] { this.name, a1.name });
/* 404 */       List list = this.a.a("SELECT name FROM sys.computed_columns WHERE object_id=OBJECT_ID(N'" + str + "')", new String[0]);
/*     */       
/* 406 */       for (String str1 : list) {
/* 407 */         arrayList.add("ALTER TABLE " + str + " DROP COLUMN " + ((c)this.a).d(new String[] { str1 }));
/*     */       } 
/*     */     } 
/* 410 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> n(List<a> paramList) throws SQLException {
/* 421 */     ArrayList<String> arrayList = new ArrayList();
/* 422 */     for (a a1 : paramList) {
/* 423 */       String str = ((c)this.a).d(new String[] { this.name, a1.name });
/* 424 */       List list = this.a.a("SELECT name FROM sys.indexes WHERE object_id=OBJECT_ID(N'" + str + "') AND is_primary_key = 0 AND is_unique_constraint = 0 AND name IS NOT NULL", new String[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 430 */       for (String str1 : list) {
/* 431 */         arrayList.add("DROP INDEX " + ((c)this.a).d(new String[] { str1 }) + " ON " + str);
/*     */       } 
/*     */     } 
/* 434 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> o(List<a> paramList) throws SQLException {
/* 445 */     ArrayList<String> arrayList = new ArrayList();
/* 446 */     for (a a1 : paramList) {
/* 447 */       String str = ((c)this.a).d(new String[] { this.name, a1.name });
/* 448 */       List list = this.a.a("SELECT name FROM sys.indexes WHERE object_id=OBJECT_ID(N'" + str + "') AND is_primary_key = 0 AND is_unique_constraint = 1 AND name IS NOT NULL", new String[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 454 */       for (String str1 : list) {
/* 455 */         arrayList.add("ALTER TABLE " + str + " DROP CONSTRAINT " + ((c)this.a).d(new String[] { str1 }));
/*     */       } 
/*     */     } 
/* 458 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> p(List<a> paramList) throws SQLException {
/* 469 */     ArrayList<String> arrayList = new ArrayList();
/* 470 */     for (a a1 : paramList) {
/* 471 */       List<a> list = a(a1, new b[] { b.c });
/* 472 */       for (a a2 : list) {
/* 473 */         arrayList.add("ALTER TABLE " + ((c)this.a).d(new String[] { this.name, a1.name }) + " DROP CONSTRAINT " + ((c)this.a).d(new String[] { a2.name }));
/*     */       } 
/*     */     } 
/*     */     
/* 477 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aV() throws SQLException {
/* 488 */     List list = this.a.a("SELECT t.name FROM sys.types t INNER JOIN sys.schemas s ON t.schema_id = s.schema_id WHERE t.is_user_defined = 1 AND s.name = ?", new String[] { this.name });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 494 */     ArrayList<String> arrayList = new ArrayList();
/* 495 */     for (String str : list) {
/* 496 */       arrayList.add("DROP TYPE " + ((c)this.a).d(new String[] { this.name, str }));
/*     */     } 
/* 498 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aW() throws SQLException {
/* 509 */     List list = this.a.a("SELECT * FROM sys.assemblies WHERE is_user_defined=1", new String[0]);
/* 510 */     ArrayList<String> arrayList = new ArrayList();
/* 511 */     for (String str : list) {
/* 512 */       arrayList.add("DROP ASSEMBLY " + ((c)this.a).d(new String[] { str }));
/*     */     } 
/* 514 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> aX() throws SQLException {
/* 525 */     List list = this.a.a("SELECT * FROM sys.triggers WHERE is_ms_shipped=0 AND parent_id=0 AND parent_class_desc='DATABASE'", new String[0]);
/*     */     
/* 527 */     ArrayList<String> arrayList = new ArrayList();
/* 528 */     for (String str : list) {
/* 529 */       arrayList.add("DROP TRIGGER " + ((c)this.a).d(new String[] { str }) + " ON DATABASE");
/*     */     } 
/* 531 */     return arrayList;
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
/*     */   private List<String> a(String paramString, b... paramVarArgs) throws SQLException {
/* 543 */     ArrayList<String> arrayList = new ArrayList();
/* 544 */     List<a> list = a(paramVarArgs);
/* 545 */     for (a a1 : list) {
/* 546 */       arrayList.add("DROP " + paramString + " " + ((c)this.a).d(new String[] { this.name, a1.name }));
/*     */     } 
/*     */     
/* 549 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected f[] b() throws SQLException {
/* 554 */     ArrayList<String> arrayList = new ArrayList();
/* 555 */     for (a a1 : a(new b[] { b.q })) {
/* 556 */       arrayList.add(a1.name);
/*     */     }
/*     */     
/* 559 */     f[] arrayOfF = new f[arrayList.size()];
/* 560 */     for (byte b = 0; b < arrayList.size(); b++) {
/* 561 */       arrayOfF[b] = new g((org.c.a.b.h.d)this.a, (org.c.a.b.e.a.b)this.a, this.databaseName, this, arrayList.get(b));
/*     */     }
/* 563 */     return arrayOfF;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a(String paramString) {
/* 568 */     return new g((org.c.a.b.h.d)this.a, (org.c.a.b.e.a.b)this.a, this.databaseName, this, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */