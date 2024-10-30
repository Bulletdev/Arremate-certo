/*    */ package br.com.arremate.l.m;
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
/* 22 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/* 23 */     byte b = 1;
/*    */     
/* 25 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*    */     
/* 27 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/* 28 */       preparedStatement.setInt(b++, a().v());
/* 29 */       preparedStatement.setInt(b++, a().b().v());
/* 30 */       preparedStatement.setLong(b++, a().C());
/* 31 */       preparedStatement.setInt(b++, v());
/* 32 */       preparedStatement.setString(b++, bo());
/* 33 */       preparedStatement.setString(b++, K());
/* 34 */       preparedStatement.setDouble(b++, i());
/* 35 */       preparedStatement.setBoolean(b++, aT());
/* 36 */       preparedStatement.setDouble(b++, k());
/* 37 */       preparedStatement.setDouble(b++, j());
/* 38 */       preparedStatement.setInt(b++, w());
/* 39 */       preparedStatement.setInt(b++, j());
/* 40 */       preparedStatement.execute();
/*    */       
/* 42 */       return true;
/* 43 */     } catch (Exception exception) {
/* 44 */       exception.printStackTrace();
/* 45 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aq() {
/* 51 */     return (g.b(bB(), g.g) || 
/* 52 */       g.b(bB(), g.aq));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ar() {
/* 57 */     return (g.b(bB(), g.f) || 
/* 58 */       g.b(bB(), g.I));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean as() {
/* 63 */     return g.b(bB(), g.ar);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aw() {
/* 68 */     return (ax() || 
/* 69 */       g.b(bB(), g.s));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean at() {
/* 74 */     return g.b(bB(), g.h);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean au() {
/* 79 */     return g.b(bB(), g.n);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ax() {
/* 84 */     return (g.b(bB(), g.at) || 
/* 85 */       g.b(bB(), g.au) || 
/* 86 */       g.b(bB(), g.av));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean az() {
/* 91 */     return super.az();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ay() {
/* 96 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\m\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */