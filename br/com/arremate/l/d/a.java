/*     */ package br.com.arremate.l.d;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private boolean I = false;
/*  12 */   private String dA = "";
/*     */   
/*     */   public a(int paramInt, j paramj) {
/*  15 */     super(paramInt, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  20 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itevalorminimoentremelhorlance, itepercentualminimoentrelance, iteunitario";
/*     */     
/*  22 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  23 */     byte b = 1;
/*     */     
/*  25 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  27 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  28 */       preparedStatement.setInt(b++, a().v());
/*  29 */       preparedStatement.setInt(b++, a().b().v());
/*  30 */       preparedStatement.setLong(b++, a().C());
/*  31 */       preparedStatement.setInt(b++, v());
/*  32 */       preparedStatement.setString(b++, bo());
/*  33 */       preparedStatement.setString(b++, K());
/*  34 */       preparedStatement.setDouble(b++, i());
/*  35 */       preparedStatement.setBoolean(b++, false);
/*  36 */       preparedStatement.setDouble(b++, k());
/*  37 */       preparedStatement.setDouble(b++, j());
/*  38 */       preparedStatement.setInt(b++, w());
/*  39 */       preparedStatement.setInt(b++, j());
/*  40 */       preparedStatement.setBigDecimal(b++, r());
/*  41 */       preparedStatement.setBigDecimal(b++, s());
/*  42 */       preparedStatement.setBoolean(b++, aZ());
/*     */       
/*  44 */       preparedStatement.execute();
/*     */       
/*  46 */       return true;
/*  47 */     } catch (Exception exception) {
/*  48 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  54 */     return (g.b(bB(), g.aP) || 
/*  55 */       g.b(bB(), g.aQ));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  60 */     return (g.b(bB(), g.y) || 
/*  61 */       g.b(bB(), g.aU));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  66 */     return (g.b(bB(), g.aj) || 
/*  67 */       g.b(bB(), g.I));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  72 */     return g.b(bB(), g.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  77 */     return (g.b(bB(), g.i) || 
/*  78 */       g.b(bB(), g.p));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  83 */     return g.b(bB(), g.q);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/*  88 */     return (ax() || 
/*  89 */       g.b(bB(), g.aA) || 
/*  90 */       g.b(bB(), g.aR) || 
/*  91 */       g.b(bB(), g.aS) || 
/*  92 */       g.b(bB(), g.aT) || 
/*  93 */       g.b(bB(), g.H) || 
/*  94 */       g.b(bB(), g.ag));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/*  99 */     return (g.b(bB(), g.av) || 
/* 100 */       g.b(bB(), g.at));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   public boolean aB() {
/* 109 */     return this.I;
/*     */   }
/*     */   
/*     */   public void o(boolean paramBoolean) {
/* 113 */     this.I = paramBoolean;
/*     */   }
/*     */   
/*     */   public String bh() {
/* 117 */     return this.dA.trim();
/*     */   }
/*     */   
/*     */   public void O(String paramString) {
/* 121 */     this.dA = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */