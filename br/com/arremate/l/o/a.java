/*    */ package br.com.arremate.l.o;
/*    */ 
/*    */ import br.com.arremate.f.g;
/*    */ import br.com.arremate.l.g;
/*    */ import br.com.arremate.l.j;
/*    */ import java.sql.PreparedStatement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends g
/*    */ {
/*    */   public a(int paramInt, j paramj) {
/* 16 */     super(paramInt, paramj);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ao() {
/* 21 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao";
/*    */ 
/*    */     
/* 24 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/* 25 */     byte b = 1;
/*    */     
/* 27 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*    */     
/* 29 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/* 30 */       preparedStatement.setInt(b++, a().v());
/* 31 */       preparedStatement.setInt(b++, a().b().v());
/* 32 */       preparedStatement.setLong(b++, a().C());
/* 33 */       preparedStatement.setInt(b++, v());
/* 34 */       preparedStatement.setString(b++, bo());
/* 35 */       preparedStatement.setString(b++, K());
/* 36 */       preparedStatement.setDouble(b++, i());
/* 37 */       preparedStatement.setBoolean(b++, false);
/* 38 */       preparedStatement.setDouble(b++, k());
/* 39 */       preparedStatement.setDouble(b++, j());
/* 40 */       preparedStatement.setInt(b++, w());
/* 41 */       preparedStatement.setInt(b++, j());
/* 42 */       preparedStatement.execute();
/* 43 */     } catch (Exception exception) {
/* 44 */       exception.printStackTrace();
/* 45 */       return false;
/*    */     } 
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aq() {
/* 53 */     return g.b(bB(), g.al);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ar() {
/* 58 */     return g.b(bB(), g.am);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean as() {
/* 63 */     return g.b(bB(), g.aj);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aw() {
/* 68 */     return (g.b(bB(), g.ai) || 
/* 69 */       g.b(bB(), g.ao) || 
/* 70 */       g.b(bB(), g.ap) || 
/* 71 */       g.b(bB(), g.an));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ax() {
/* 76 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ay() {
/* 81 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean az() {
/* 86 */     return super.az();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\o\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */