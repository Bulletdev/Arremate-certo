/*    */ package org.c.a.b.e.k;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.f.b;
/*    */ import org.c.a.b.r.n;
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
/*    */ public class a
/*    */   extends a<b>
/*    */ {
/*    */   a(b paramb, b paramb1, Connection paramConnection, boolean paramBoolean) {
/* 37 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 46 */     return this.a.b("SHOW search_path", new String[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void c(d paramd) {
/*    */     try {
/* 52 */       if (paramd.getName().equals(this.kS) || this.kS.startsWith(paramd.getName() + ",") || !paramd.exists()) {
/*    */         return;
/*    */       }
/*    */       
/* 56 */       if (n.X(this.kS) && !"unset".equals(this.kS)) {
/* 57 */         bB(paramd.toString() + "," + this.kS);
/*    */       } else {
/* 59 */         bB(paramd.toString());
/*    */       } 
/* 61 */     } catch (SQLException sQLException) {
/* 62 */       throw new b("Error setting current schema to " + paramd, sQLException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 68 */     if ("unset".equals(paramString)) {
/* 69 */       paramString = "";
/*    */     }
/* 71 */     this.a.a("SELECT set_config('search_path', ?, false)", new Object[] { paramString });
/*    */   }
/*    */ 
/*    */   
/*    */   public d b() throws SQLException {
/* 76 */     String str = this.a.b("SELECT current_schema()", new String[0]);
/* 77 */     if (!n.X(str)) {
/* 78 */       throw new org.c.a.a.a("Unable to determine current schema as search_path is empty. Set the current schema in currentSchema parameter of the JDBC URL or in Flyway's schemas property.");
/*    */     }
/*    */     
/* 81 */     return a(str);
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 86 */     return new c(this.a, (b)this.a, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */