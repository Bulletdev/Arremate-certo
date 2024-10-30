/*    */ package org.c.a.b.e.e;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.SQLException;
/*    */ import org.c.a.a.c.b;
/*    */ import org.c.a.b.e.a.a;
/*    */ import org.c.a.b.e.a.d;
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
/* 34 */     super(paramb, paramb1, paramConnection, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void bB(String paramString) throws SQLException {
/* 43 */     this.a.a("SET SCHEMA " + ((b)this.a).d(new String[] { paramString }, ), new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public d a(String paramString) {
/* 48 */     return new c(this.a, (b)this.a, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected String ey() throws SQLException {
/* 53 */     return this.a.b("CALL SCHEMA()", new String[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */