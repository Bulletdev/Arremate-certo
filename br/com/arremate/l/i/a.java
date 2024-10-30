/*     */ package br.com.arremate.l.i;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.g;
/*     */ import java.sql.PreparedStatement;
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private boolean ae;
/*     */   
/*     */   public a(int paramInt, b paramb) {
/*  14 */     super(paramInt, paramb);
/*  15 */     T(String.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  20 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itevalorminimoentremelhorlance, itepercentualminimoentrelance, itetipo, itedescricaocompleta, itetempominimoentremelhorlance";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  25 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  26 */     byte b = 1;
/*     */     
/*  28 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  30 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  31 */       preparedStatement.setInt(b++, a().v());
/*  32 */       preparedStatement.setInt(b++, a().b().v());
/*  33 */       preparedStatement.setLong(b++, a().C());
/*  34 */       preparedStatement.setInt(b++, v());
/*  35 */       preparedStatement.setString(b++, String.valueOf(v()));
/*  36 */       preparedStatement.setString(b++, K());
/*  37 */       preparedStatement.setInt(b++, 0);
/*  38 */       preparedStatement.setBoolean(b++, aT());
/*  39 */       preparedStatement.setDouble(b++, k());
/*  40 */       preparedStatement.setDouble(b++, j());
/*  41 */       preparedStatement.setBigDecimal(b++, r());
/*  42 */       preparedStatement.setBigDecimal(b++, s());
/*  43 */       preparedStatement.setInt(b++, w());
/*  44 */       preparedStatement.setString(b++, bD());
/*  45 */       preparedStatement.setLong(b++, B());
/*  46 */       preparedStatement.execute();
/*     */       
/*  48 */       return true;
/*  49 */     } catch (Exception exception) {
/*  50 */       exception.printStackTrace();
/*  51 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void E(boolean paramBoolean) {
/*  56 */     this.ae = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean bg() {
/*  60 */     return this.ae;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  65 */     return (g.b(bB(), g.x) || 
/*  66 */       g.b(bB(), g.D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  71 */     return g.b(bB(), g.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  76 */     if (a().a() == m.b) {
/*  77 */       return g.b(bB(), g.I);
/*     */     }
/*     */     
/*  80 */     return g.b(bB(), g.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  86 */     return g.b(bB(), g.J);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  91 */     return (g.b(bB(), g.p) || 
/*  92 */       g.b(bB(), g.i) || 
/*  93 */       g.b(bB(), g.K));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  98 */     return (g.b(bB(), g.F) || 
/*  99 */       g.b(bB(), g.E) || 
/* 100 */       g.b(bB(), g.G));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/* 105 */     return (ax() || 
/* 106 */       g.b(bB(), g.A) || 
/* 107 */       g.b(bB(), g.H) || 
/* 108 */       g.b(bB(), g.L));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 113 */     return (g.b(bB(), g.at) || 
/* 114 */       g.b(bB(), g.aW));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 124 */     return super.az();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void N(String paramString) {
/* 129 */     super.N(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */