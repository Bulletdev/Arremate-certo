/*     */ package br.com.arremate.l.f;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*  18 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   public a(int paramInt, j paramj) {
/*  21 */     super(paramInt, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  26 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itevalorminimoentremelhorlance, itepercentualminimoentrelance, itecodigogrupo, itegrupo, iteunidademedida";
/*     */     
/*  28 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  29 */     byte b = 1;
/*     */     
/*  31 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  33 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  34 */       preparedStatement.setInt(b++, a().v());
/*  35 */       preparedStatement.setInt(b++, a().b().v());
/*  36 */       preparedStatement.setLong(b++, a().C());
/*  37 */       preparedStatement.setInt(b++, v());
/*  38 */       preparedStatement.setString(b++, bo());
/*  39 */       preparedStatement.setString(b++, K());
/*  40 */       preparedStatement.setDouble(b++, i());
/*  41 */       preparedStatement.setBoolean(b++, false);
/*  42 */       preparedStatement.setDouble(b++, k());
/*  43 */       preparedStatement.setDouble(b++, j());
/*  44 */       preparedStatement.setInt(b++, w());
/*  45 */       preparedStatement.setInt(b++, j());
/*  46 */       preparedStatement.setBigDecimal(b++, r());
/*  47 */       preparedStatement.setBigDecimal(b++, s());
/*  48 */       preparedStatement.setInt(b++, H());
/*  49 */       preparedStatement.setString(b++, bE().isEmpty() ? null : bE());
/*  50 */       preparedStatement.setString(b++, bF());
/*     */       
/*  52 */       preparedStatement.execute();
/*     */       
/*  54 */       return true;
/*  55 */     } catch (Exception exception) {
/*  56 */       a.error("Erro ao inserir item", exception);
/*  57 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  63 */     return g.b(bB(), g.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  68 */     return (g.b(bB(), g.f) || 
/*  69 */       g.b(bB(), g.aE));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  74 */     if (a().a() == m.b) {
/*  75 */       return g.b(bB(), g.aE);
/*     */     }
/*     */     
/*  78 */     return g.b(bB(), g.aF);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  83 */     return g.b(bB(), g.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  88 */     return (g.b(bB(), g.p) || 
/*  89 */       g.b(bB(), g.i));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  94 */     return (g.b(bB(), g.aX) || 
/*  95 */       g.b(bB(), g.aJ) || 
/*  96 */       g.b(bB(), g.l) || 
/*  97 */       g.b(bB(), g.q));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/* 102 */     return (ax() || 
/* 103 */       g.b(bB(), g.s) || 
/* 104 */       g.b(bB(), g.aG) || 
/* 105 */       g.b(bB(), g.aH) || 
/* 106 */       g.b(bB(), g.H) || 
/* 107 */       g.b(bB(), g.aK) || 
/* 108 */       g.b(bB(), g.ag) || 
/* 109 */       g.b(bB(), g.aL) || 
/* 110 */       g.b(bB(), g.aI) || 
/* 111 */       g.b(bB(), g.aJ));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 116 */     return (g.b(bB(), g.at) || 
/* 117 */       g.b(bB(), g.av) || 
/* 118 */       g.b(bB(), g.aX));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 128 */     return super.az();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\f\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */