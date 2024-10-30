/*    */ package br.com.arremate.l.b;
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
/*    */ 
/*    */ public class a
/*    */   extends g
/*    */ {
/* 18 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*    */   
/*    */   public a(int paramInt, j paramj) {
/* 21 */     super(paramInt, paramj);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ao() {
/* 26 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itecodigogrupo, itegrupo, iteunidademedida";
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
/* 40 */       preparedStatement.setBoolean(b++, false);
/* 41 */       preparedStatement.setDouble(b++, k());
/* 42 */       preparedStatement.setDouble(b++, j());
/* 43 */       preparedStatement.setInt(b++, w());
/* 44 */       preparedStatement.setInt(b++, j());
/* 45 */       preparedStatement.setInt(b++, H());
/* 46 */       preparedStatement.setString(b++, bE().isEmpty() ? null : bE());
/* 47 */       preparedStatement.setString(b++, bF());
/* 48 */       preparedStatement.execute();
/*    */       
/* 50 */       return true;
/* 51 */     } catch (Exception exception) {
/* 52 */       a.error("Erro ao inserir item", exception);
/* 53 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aq() {
/* 59 */     return g.b(bB(), g.x);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ar() {
/* 64 */     return g.b(bB(), g.aM);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean as() {
/* 69 */     return g.b(bB(), g.aE);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean av() {
/* 74 */     return (g.b(bB(), g.an) || 
/* 75 */       g.b(bB(), g.aN) || 
/* 76 */       g.b(bB(), g.aO));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean aw() {
/* 81 */     return (ax() || 
/* 82 */       g.b(bB(), g.s) || 
/* 83 */       g.b(bB(), g.ai));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ax() {
/* 88 */     return g.b(bB(), g.at);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ay() {
/* 93 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean az() {
/* 98 */     return super.az();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */