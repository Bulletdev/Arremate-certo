/*    */ package org.c.a.b.e.n;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import java.util.concurrent.Callable;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.e.a.f;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends a<c>
/*    */ {
/*    */   private final String lg;
/*    */   private final String lh;
/*    */   
/*    */   b(org.c.a.a.c.b paramb, c paramc, Connection paramConnection, boolean paramBoolean) {
/* 40 */     super(paramb, paramc, paramConnection, paramBoolean);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 46 */       this.lg = this.a.b("SELECT DB_NAME()", new String[0]);
/* 47 */     } catch (SQLException sQLException) {
/* 48 */       throw new org.c.a.b.f.b("Unable to determine current database", sQLException);
/*    */     } 
/*    */     try {
/* 51 */       this
/* 52 */         .lh = paramc.fP() ? null : this.a.b("DECLARE @ANSI_NULLS VARCHAR(3) = 'OFF';\nIF ( (32 & @@OPTIONS) = 32 ) SET @ANSI_NULLS = 'ON';\nSELECT @ANSI_NULLS AS ANSI_NULLS;", new String[0]);
/*    */     
/*    */     }
/* 55 */     catch (SQLException sQLException) {
/* 56 */       throw new org.c.a.b.f.b("Unable to determine ANSI NULLS state", sQLException);
/*    */     } 
/*    */   }
/*    */   
/*    */   void bE(String paramString) throws SQLException {
/* 61 */     this.a.a("USE " + ((c)this.a).d(new String[] { paramString }, ), new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 67 */     return this.a.b("SELECT SCHEMA_NAME()", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hW() throws SQLException {
/* 72 */     bE(this.lg);
/* 73 */     if (!((c)this.a).fP()) {
/* 74 */       this.a.a("SET ANSI_NULLS " + this.lh, new Object[0]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 80 */     return new d(this.a, (c)this.a, this.lg, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public <T> T a(f paramf, Callable<T> paramCallable) {
/* 85 */     return (new a(this, this.a, this.lg, paramf.toString().hashCode())).execute(paramCallable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\n\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */