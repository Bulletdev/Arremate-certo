/*    */ package br.com.arremate.l.g;
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
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends g
/*    */ {
/* 17 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*    */   
/*    */   public a(int paramInt, j paramj) {
/* 20 */     super(paramInt, paramj);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ao() {
/* 25 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itevalortotal, itevalorunitario, itecodigogrupo, itegrupo, itetipo, iteposicao, itevalorminimoentremelhorlance, itepercentualminimoentrelance";
/*    */     
/* 27 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/* 28 */     byte b = 1;
/*    */     
/* 30 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*    */     
/* 32 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/* 33 */       preparedStatement.setInt(b++, a().v());
/* 34 */       preparedStatement.setInt(b++, a().b().v());
/* 35 */       preparedStatement.setLong(b++, a().C());
/* 36 */       preparedStatement.setInt(b++, v());
/* 37 */       preparedStatement.setString(b++, bo());
/* 38 */       preparedStatement.setString(b++, K());
/* 39 */       preparedStatement.setDouble(b++, i());
/* 40 */       preparedStatement.setDouble(b++, k());
/* 41 */       preparedStatement.setDouble(b++, j());
/* 42 */       preparedStatement.setInt(b++, H());
/* 43 */       preparedStatement.setString(b++, bE().isEmpty() ? null : bE());
/* 44 */       preparedStatement.setInt(b++, w());
/* 45 */       preparedStatement.setInt(b++, j());
/* 46 */       preparedStatement.setBigDecimal(b++, r());
/* 47 */       preparedStatement.setBigDecimal(b++, s());
/* 48 */       preparedStatement.execute();
/* 49 */     } catch (Exception exception) {
/* 50 */       a.error("Erro ao gravar dados dos itens disputa", exception);
/* 51 */       return false;
/*    */     } 
/*    */     
/* 54 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aq() {
/* 59 */     return g.b(bB(), g.g);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ar() {
/* 64 */     return g.b(bB(), g.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean as() {
/* 69 */     return g.b(bB(), g.k);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean au() {
/* 74 */     return g.b(bB(), g.aY);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aw() {
/* 79 */     return (ax() || g.b(bB(), g.s));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ax() {
/* 84 */     return g.b(bB(), g.at);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ay() {
/* 89 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */