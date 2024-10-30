/*    */ package org.c.a.b.e.c;
/*    */ 
/*    */ import java.sql.SQLException;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import org.c.a.b.e.a.b;
/*    */ import org.c.a.b.e.a.c;
/*    */ import org.c.a.b.e.a.d;
/*    */ import org.c.a.b.h.d;
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
/*    */ public class c
/*    */   extends c
/*    */ {
/* 36 */   private static final Collection<String> k = Arrays.asList(new String[] { "character", "char", "varchar", "graphic", "vargraphic", "decimal", "float", "varbinary" });
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
/*    */   c(d paramd, b paramb, d paramd1, String paramString, String... paramVarArgs) {
/* 56 */     super(paramd, paramb, paramd1, paramString, paramVarArgs);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void hZ() throws SQLException {
/*    */     try {
/* 62 */       this.a.a("DROP FUNCTION " + this.a
/* 63 */           .d(new String[] { this.a.getName(), this.name }, ) + "(" + 
/* 64 */           e(this.args) + ")", new Object[0]);
/* 65 */     } catch (SQLException sQLException) {
/*    */ 
/*    */       
/* 68 */       this.a.a("DROP FUNCTION " + this.a.d(new String[] { this.a.getName(), this.name }, ), new Object[0]);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String e(String[] paramArrayOfString) {
/* 80 */     StringBuilder stringBuilder = new StringBuilder();
/* 81 */     for (String str : paramArrayOfString) {
/* 82 */       if (stringBuilder.length() > 0) {
/* 83 */         stringBuilder.append(",");
/*    */       }
/* 85 */       stringBuilder.append(str);
/* 86 */       if (k.contains(str.toLowerCase())) {
/* 87 */         stringBuilder.append("()");
/*    */       }
/*    */     } 
/* 90 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 95 */     return super.toString() + "(" + n.a((Object[])this.args) + ")";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\e\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */