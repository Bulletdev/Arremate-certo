/*     */ package br.com.arremate.l.j;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class a
/*     */   extends g {
/*     */   public a(int paramInt, b paramb) {
/*  12 */     super(paramInt, paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  17 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itevalorminimoentremelhorlance, itepercentualminimoentrelance, iteidempresa";
/*     */     
/*  19 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  20 */     byte b = 1;
/*     */     
/*  22 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  24 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  25 */       preparedStatement.setInt(b++, a().v());
/*  26 */       preparedStatement.setInt(b++, a().b().v());
/*  27 */       preparedStatement.setLong(b++, a().C());
/*  28 */       preparedStatement.setInt(b++, v());
/*  29 */       preparedStatement.setString(b++, bo());
/*  30 */       preparedStatement.setString(b++, K());
/*  31 */       preparedStatement.setDouble(b++, i());
/*  32 */       preparedStatement.setBoolean(b++, false);
/*  33 */       preparedStatement.setDouble(b++, k());
/*  34 */       preparedStatement.setDouble(b++, j());
/*  35 */       preparedStatement.setInt(b++, w());
/*  36 */       preparedStatement.setInt(b++, j());
/*  37 */       preparedStatement.setBigDecimal(b++, r());
/*  38 */       preparedStatement.setBigDecimal(b++, s());
/*  39 */       preparedStatement.setString(b++, bG());
/*     */       
/*  41 */       preparedStatement.execute();
/*     */       
/*  43 */       return true;
/*  44 */     } catch (Exception exception) {
/*  45 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  51 */     return g.b(bB(), g.bc);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  56 */     return (g.b(bB(), g.bf) || 
/*  57 */       g.b(bB(), g.bn));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  62 */     if (a().a() == m.b) {
/*  63 */       return g.b(bB(), g.bn);
/*     */     }
/*     */     
/*  66 */     return g.b(bB(), g.bo);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  71 */     return g.b(bB(), g.bh);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  76 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/*  86 */     return (ax() || 
/*  87 */       g.b(bB(), g.aZ) || 
/*  88 */       g.b(bB(), g.ba) || 
/*  89 */       g.b(bB(), g.bb) || 
/*  90 */       g.b(bB(), g.bg) || 
/*  91 */       g.b(bB(), g.bj) || 
/*  92 */       g.b(bB(), g.bk) || 
/*  93 */       g.b(bB(), g.bp) || 
/*  94 */       g.b(bB(), g.bl) || 
/*  95 */       g.b(bB(), g.bm));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 100 */     return (g.b(bB(), g.bq) || 
/* 101 */       g.b(bB(), g.bi) || 
/* 102 */       g.b(bB(), g.be) || 
/* 103 */       g.b(bB(), g.bd));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 108 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 113 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */