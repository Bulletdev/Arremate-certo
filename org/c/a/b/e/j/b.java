/*     */ package org.c.a.b.e.j;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.b.e.a.a;
/*     */ import org.c.a.b.e.a.d;
/*     */ import org.c.a.b.e.a.f;
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
/*     */ public class b
/*     */   extends a<d>
/*     */ {
/*     */   private final String lc;
/*     */   
/*     */   b(org.c.a.a.c.b paramb, d paramd, Connection paramConnection, boolean paramBoolean) {
/*  41 */     super(paramb, paramd, paramConnection, paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  48 */       this.lc = this.a.b("SELECT CURRENT_USER", new String[0]);
/*  49 */     } catch (SQLException sQLException) {
/*  50 */       throw new org.c.a.b.f.b("Unable to determine current user", sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hW() throws SQLException {
/*  57 */     this.a.a("SET ROLE '" + this.lc + "'", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public d b() throws SQLException {
/*  62 */     String str = this.a.b("SELECT current_schema", new String[0]);
/*  63 */     if (!n.X(str)) {
/*  64 */       throw new a("Unable to determine current schema as search_path is empty. Set the current schema in currentSchema parameter of the JDBC URL or in Flyway's schemas property.");
/*     */     }
/*     */     
/*  67 */     return a(str);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ey() throws SQLException {
/*  72 */     return this.a.b("SHOW search_path", new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void c(d paramd) {
/*     */     try {
/*  78 */       if (paramd.getName().equals(this.kS) || this.kS.startsWith(paramd.getName() + ",") || !paramd.exists()) {
/*     */         return;
/*     */       }
/*     */       
/*  82 */       if (n.X(this.kS)) {
/*  83 */         bB(paramd.toString() + "," + this.kS);
/*     */       } else {
/*  85 */         bB(paramd.toString());
/*     */       } 
/*  87 */     } catch (SQLException sQLException) {
/*  88 */       throw new org.c.a.b.f.b("Error setting current schema to " + paramd, sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void bB(String paramString) throws SQLException {
/*  94 */     this.a.a("SELECT set_config('search_path', ?, false)", new Object[] { paramString });
/*     */   }
/*     */ 
/*     */   
/*     */   public d a(String paramString) {
/*  99 */     return new e(this.a, (d)this.a, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T a(f paramf, Callable<T> paramCallable) {
/* 104 */     return (new a(this.a, paramf.toString().hashCode())).execute(paramCallable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */