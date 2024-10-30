/*     */ package br.com.arremate.l.e;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.g;
/*     */ import java.sql.PreparedStatement;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends g
/*     */ {
/*  17 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   public b(int paramInt, f paramf) {
/*  20 */     super(paramInt, paramf);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  25 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itecodigogrupo, itegrupo, itetipo, iteposicao, iteequalizacao, itedescricaocompleta, itevalorminimoentremelhorlance, itepercentualminimoentrelance";
/*  26 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  27 */     byte b1 = 1;
/*     */     
/*  29 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  31 */     try (PreparedStatement null = a.a().prepareStatement(str3)) {
/*  32 */       preparedStatement.setInt(b1++, a().v());
/*  33 */       preparedStatement.setInt(b1++, a().b().v());
/*  34 */       preparedStatement.setLong(b1++, a().C());
/*  35 */       preparedStatement.setInt(b1++, v());
/*  36 */       preparedStatement.setString(b1++, bo());
/*  37 */       preparedStatement.setString(b1++, K());
/*  38 */       preparedStatement.setDouble(b1++, i());
/*  39 */       preparedStatement.setBoolean(b1++, aT());
/*  40 */       preparedStatement.setDouble(b1++, k());
/*  41 */       preparedStatement.setDouble(b1++, j());
/*  42 */       preparedStatement.setInt(b1++, H());
/*  43 */       preparedStatement.setString(b1++, bE().isEmpty() ? null : bE());
/*  44 */       preparedStatement.setInt(b1++, w());
/*  45 */       preparedStatement.setInt(b1++, j());
/*  46 */       preparedStatement.setDouble(b1++, a());
/*  47 */       preparedStatement.setString(b1++, bD());
/*  48 */       preparedStatement.setBigDecimal(b1++, r());
/*  49 */       preparedStatement.setBigDecimal(b1++, s());
/*  50 */       preparedStatement.execute();
/*  51 */     } catch (Exception exception) {
/*  52 */       a.error("Erro ao gravar dados dos itens disputa", exception);
/*  53 */       return false;
/*     */     } 
/*     */     
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  71 */     return g.b(bB(), g.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  76 */     return (g.b(bB(), g.f) || 
/*  77 */       g.b(bB(), g.j) || 
/*     */       
/*  79 */       g.b(bB(), g.v));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  84 */     if (a() instanceof d)
/*  85 */       return g.b(bB(), g.w); 
/*  86 */     if (a().a() == m.b)
/*  87 */       return g.b(bB(), g.aE); 
/*  88 */     if (a().a() == m.c) {
/*  89 */       return g.b(bB(), g.k);
/*     */     }
/*  91 */     return g.b(bB(), g.k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  97 */     return g.b(bB(), g.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/* 102 */     return (g.b(bB(), g.n) || 
/* 103 */       g.b(bB(), g.i) || 
/* 104 */       g.b(bB(), g.m) || 
/* 105 */       g.b(bB(), g.p) || 
/* 106 */       g.b(bB(), g.o));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/* 111 */     return (g.b(bB(), g.aW) || 
/* 112 */       g.b(bB(), g.q) || 
/* 113 */       g.b(bB(), g.l));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/* 118 */     return (ax() || g.b(bB(), g.s));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 123 */     return g.b(bB(), g.av);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 128 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */