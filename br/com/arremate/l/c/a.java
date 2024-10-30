/*     */ package br.com.arremate.l.c;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private boolean I = false;
/*  16 */   private String dA = "";
/*     */   
/*     */   public a(int paramInt, j paramj) {
/*  19 */     super(paramInt, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  24 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itevalorminimoentremelhorlance, itepercentualminimoentrelance, iteunitario";
/*     */     
/*  26 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  27 */     byte b = 1;
/*     */     
/*  29 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  31 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  32 */       preparedStatement.setInt(b++, a().v());
/*  33 */       preparedStatement.setInt(b++, a().b().v());
/*  34 */       preparedStatement.setLong(b++, a().C());
/*  35 */       preparedStatement.setInt(b++, v());
/*  36 */       preparedStatement.setString(b++, bo());
/*  37 */       preparedStatement.setString(b++, K());
/*  38 */       preparedStatement.setDouble(b++, i());
/*  39 */       preparedStatement.setBoolean(b++, false);
/*  40 */       preparedStatement.setDouble(b++, k());
/*  41 */       preparedStatement.setDouble(b++, j());
/*  42 */       preparedStatement.setInt(b++, w());
/*  43 */       preparedStatement.setInt(b++, j());
/*  44 */       preparedStatement.setBigDecimal(b++, r());
/*  45 */       preparedStatement.setBigDecimal(b++, s());
/*  46 */       preparedStatement.setBoolean(b++, aZ());
/*     */       
/*  48 */       preparedStatement.execute();
/*     */       
/*  50 */       return true;
/*  51 */     } catch (Exception exception) {
/*  52 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  58 */     return (g.b(bB(), g.aP) || 
/*  59 */       g.b(bB(), g.aQ));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  64 */     return (g.b(bB(), g.y) || 
/*  65 */       g.b(bB(), g.aU));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  70 */     return (g.b(bB(), g.aj) || 
/*  71 */       g.b(bB(), g.I));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  76 */     return g.b(bB(), g.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  81 */     return (g.b(bB(), g.i) || 
/*  82 */       g.b(bB(), g.p));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  87 */     return g.b(bB(), g.q);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/*  92 */     return (ax() || 
/*  93 */       g.b(bB(), g.aA) || 
/*  94 */       g.b(bB(), g.aR) || 
/*  95 */       g.b(bB(), g.aS) || 
/*  96 */       g.b(bB(), g.aT) || 
/*  97 */       g.b(bB(), g.H) || 
/*  98 */       g.b(bB(), g.ag));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 103 */     return (g.b(bB(), g.av) || 
/* 104 */       g.b(bB(), g.at));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public boolean aB() {
/* 113 */     return this.I;
/*     */   }
/*     */   
/*     */   public void o(boolean paramBoolean) {
/* 117 */     this.I = paramBoolean;
/*     */   }
/*     */   
/*     */   public String bh() {
/* 121 */     return this.dA.trim();
/*     */   }
/*     */   
/*     */   public void O(String paramString) {
/* 125 */     this.dA = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */