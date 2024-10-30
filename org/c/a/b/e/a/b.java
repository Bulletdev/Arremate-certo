/*     */ package org.c.a.b.e.a;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.nio.charset.Charset;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.f.a;
/*     */ import org.c.a.b.h.d;
/*     */ import org.c.a.b.h.e;
/*     */ import org.c.a.b.l.a;
/*     */ import org.c.a.b.l.c;
/*     */ import org.c.a.b.n.b.a;
/*     */ import org.c.a.b.n.f;
/*     */ import org.c.a.b.q.c;
/*     */ import org.c.a.b.q.d;
/*     */ import org.c.a.b.q.g;
/*     */ import org.c.a.b.q.h;
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
/*     */ public abstract class b<C extends a>
/*     */   implements Closeable
/*     */ {
/*  55 */   private static final a a = c.b(b.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final org.c.a.a.c.b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final DatabaseMetaData a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Connection c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean cA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private C e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private C f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final g f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(org.c.a.a.c.b paramb, Connection paramConnection, boolean paramBoolean) {
/* 113 */     this.a = (DatabaseMetaData)paramb;
/* 114 */     this.c = paramConnection;
/* 115 */     this.cA = paramBoolean;
/*     */     try {
/* 117 */       this.a = paramConnection.getMetaData();
/* 118 */     } catch (SQLException sQLException) {
/* 119 */       throw new org.c.a.b.f.b("Unable to get metadata for connection", sQLException);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     this.f = d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract C a(Connection paramConnection);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void hX();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g c() {
/* 150 */     return this.f;
/*     */   }
/*     */   
/*     */   protected final void l(String paramString1, String paramString2) {
/* 154 */     if (!this.f.H(paramString2)) {
/* 155 */       throw new a(paramString1, a(this.f), 
/* 156 */           a(g.a(paramString2)));
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void d(String paramString1, String paramString2, String paramString3) {
/* 161 */     if (!this.f.H(paramString3)) {
/* 162 */       throw new org.c.a.b.i.b(paramString1, paramString2, a(this.f));
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void m(String paramString1, String paramString2) {
/* 167 */     if (this.f.I(paramString2)) {
/* 168 */       a.warn("Flyway upgrade recommended: " + paramString1 + " " + a(this.f) + " is newer than this version of Flyway and support has not been tested.");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void n(String paramString1, String paramString2) {
/* 174 */     if (this.f.J(paramString2)) {
/* 175 */       a.warn("Flyway upgrade recommended: " + paramString1 + " " + a(this.f) + " is newer than this version of Flyway and support has not been tested.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String a(g paramg) {
/* 186 */     return paramg.getVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a() {
/* 194 */     return a(
/* 195 */         a(this.a
/* 196 */           .eY(), this.a.P(), this.a
/* 197 */           .eg(), this.a.eh()));
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
/*     */   protected abstract k a(c paramc);
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
/*     */   public h a(d paramd) {
/* 225 */     return (h)new c(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected c a(boolean paramBoolean, Map<String, String> paramMap, String paramString1, String paramString2) {
/* 234 */     if (paramBoolean) {
/* 235 */       return (c)new a(paramMap, paramString1, paramString2);
/*     */     }
/* 237 */     return (c)org.c.a.b.l.b.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d a() {
/* 244 */     return d.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String ez();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String eA() {
/*     */     try {
/* 257 */       return eB();
/* 258 */     } catch (SQLException sQLException) {
/* 259 */       throw new org.c.a.b.f.b("Error retrieving the database user", sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String eB() throws SQLException {
/* 264 */     return this.a.getUserName();
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
/*     */   public abstract boolean fx();
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
/*     */   public abstract boolean fy();
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
/*     */   public abstract String eC();
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
/*     */   public abstract String eD();
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
/*     */   public final String d(String... paramVarArgs) {
/* 322 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 324 */     boolean bool = true;
/* 325 */     for (String str : paramVarArgs) {
/* 326 */       if (!bool) {
/* 327 */         stringBuilder.append(".");
/*     */       }
/* 329 */       bool = false;
/* 330 */       stringBuilder.append(aN(str));
/*     */     } 
/*     */     
/* 333 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String aN(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean fz();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fA() {
/* 353 */     return false;
/*     */   }
/*     */   
/*     */   public DatabaseMetaData a() {
/* 357 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final C a() {
/* 364 */     if (this.e == null) {
/* 365 */       a(this, this.c, this.a.en());
/* 366 */       this.e = a(this.c);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 372 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final C b() {
/* 379 */     if (this.f == null) {
/* 380 */       if (fA()) {
/* 381 */         this.f = (g)this.e;
/*     */       } else {
/*     */         
/* 384 */         Connection connection = e.a(this.a.a(), this.a.bK());
/* 385 */         a(this, connection, this.a.en());
/* 386 */         this.f = (g)a(connection);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     return (C)this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(b paramb, Connection paramConnection, String paramString) {
/* 404 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 407 */     (new c(new d(paramConnection)))
/*     */ 
/*     */ 
/*     */       
/* 411 */       .a(new g(paramb.a(), (org.c.a.b.n.b)new f(paramString), true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected g d() {
/*     */     try {
/* 423 */       return g.a(this.a.getDatabaseMajorVersion() + "." + this.a.getDatabaseMinorVersion());
/* 424 */     } catch (SQLException sQLException) {
/* 425 */       throw new org.c.a.b.f.b("Unable to determine the major version of the database", sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final g a(f paramf) {
/* 430 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 431 */     hashMap.put("schema", paramf.c().getName());
/* 432 */     hashMap.put("table", paramf.getName());
/* 433 */     hashMap.put("table_quoted", paramf.toString());
/*     */ 
/*     */     
/* 436 */     c c = a(true, (Map)hashMap, "${", "}");
/*     */     
/* 438 */     k k = a(c);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 444 */     return new g(k, a(), false);
/*     */   }
/*     */   
/*     */   protected org.c.a.b.n.b a() {
/* 448 */     String str = "org/flywaydb/core/internal/database/" + ez() + "/createMetaDataTable.sql";
/* 449 */     return (org.c.a.b.n.b)new a(null, str, getClass().getClassLoader(), Charset.forName("UTF-8"));
/*     */   }
/*     */   
/*     */   public String a(f paramf) {
/* 453 */     return "INSERT INTO " + paramf + " (" + 
/* 454 */       d(new String[] { "installed_rank" }) + "," + 
/* 455 */       d(new String[] { "version" }) + "," + 
/* 456 */       d(new String[] { "description" }) + "," + 
/* 457 */       d(new String[] { "type" }) + "," + 
/* 458 */       d(new String[] { "script" }) + "," + 
/* 459 */       d(new String[] { "checksum" }) + "," + 
/* 460 */       d(new String[] { "installed_by" }) + "," + 
/* 461 */       d(new String[] { "execution_time" }) + "," + 
/* 462 */       d(new String[] { "success" }) + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String a(f paramf, int paramInt) {
/* 468 */     return "SELECT " + d(new String[] { "installed_rank" }) + "," + 
/* 469 */       d(new String[] { "version" }) + "," + 
/* 470 */       d(new String[] { "description" }) + "," + 
/* 471 */       d(new String[] { "type" }) + "," + 
/* 472 */       d(new String[] { "script" }) + "," + 
/* 473 */       d(new String[] { "checksum" }) + "," + 
/* 474 */       d(new String[] { "installed_on" }) + "," + 
/* 475 */       d(new String[] { "installed_by" }) + "," + 
/* 476 */       d(new String[] { "execution_time" }) + "," + 
/* 477 */       d(new String[] { "success" }) + " FROM " + paramf + " WHERE " + 
/*     */       
/* 479 */       d(new String[] { "installed_rank" }) + " > " + paramInt + " ORDER BY " + 
/* 480 */       d(new String[] { "installed_rank" });
/*     */   }
/*     */   
/*     */   public void close() {
/* 484 */     if (!fA() && this.f != null) {
/* 485 */       this.f.close();
/*     */     }
/* 487 */     if (this.e != null)
/* 488 */       this.e.close(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */