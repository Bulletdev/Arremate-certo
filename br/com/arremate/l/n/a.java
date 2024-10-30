/*    */ package br.com.arremate.l.n;
/*    */ 
/*    */ import br.com.arremate.f.g;
/*    */ import br.com.arremate.l.g;
/*    */ import br.com.arremate.l.j;
/*    */ import java.sql.PreparedStatement;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends g
/*    */ {
/* 15 */   protected static final Logger a = LoggerFactory.getLogger(a.class);
/*    */   
/*    */   public a(int paramInt, j paramj) {
/* 18 */     super(paramInt, paramj);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ao() {
/* 23 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao";
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
/*    */       
/* 43 */       preparedStatement.execute();
/*    */       
/* 45 */       return true;
/* 46 */     } catch (Exception exception) {
/* 47 */       a.error("Erro ao gravar dados dos itens", exception);
/* 48 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aq() {
/* 54 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ar() {
/* 59 */     return (g.b(bB(), g.br) || 
/* 60 */       g.b(bB(), g.bt) || 
/* 61 */       g.b(bB(), g.bs));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean as() {
/* 66 */     return g.b(bB(), g.bu);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aw() {
/* 71 */     return g.b(bB(), g.s);
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
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */