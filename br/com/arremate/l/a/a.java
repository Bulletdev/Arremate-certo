/*     */ package br.com.arremate.l.a;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.l.g;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private BigDecimal d;
/*     */   private boolean G = false;
/*     */   private boolean H = false;
/*     */   
/*     */   public a(int paramInt, b paramb) {
/*  23 */     super(paramInt, paramb);
/*  24 */     T(String.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  29 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itevalorminimoentrepropriolance, itevalorminimoentremelhorlance, itepercentualminimoentrelance, itetipo, itedescricaocompleta, itetempominimoentremelhorlance";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  36 */     byte b = 1;
/*     */     
/*  38 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  40 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  41 */       preparedStatement.setInt(b++, a().v());
/*  42 */       preparedStatement.setInt(b++, a().b().v());
/*  43 */       preparedStatement.setLong(b++, a().C());
/*  44 */       preparedStatement.setInt(b++, v());
/*  45 */       preparedStatement.setString(b++, String.valueOf(v()));
/*  46 */       preparedStatement.setString(b++, K());
/*  47 */       preparedStatement.setInt(b++, 0);
/*  48 */       preparedStatement.setBoolean(b++, aT());
/*  49 */       preparedStatement.setDouble(b++, k());
/*  50 */       preparedStatement.setDouble(b++, j());
/*  51 */       preparedStatement.setBigDecimal(b++, e());
/*  52 */       preparedStatement.setBigDecimal(b++, r());
/*  53 */       preparedStatement.setBigDecimal(b++, s());
/*  54 */       preparedStatement.setInt(b++, w());
/*  55 */       preparedStatement.setString(b++, bD());
/*  56 */       preparedStatement.setLong(b++, B());
/*  57 */       preparedStatement.execute();
/*     */ 
/*     */ 
/*     */       
/*  61 */       return true;
/*  62 */     } catch (Exception exception) {
/*  63 */       exception.printStackTrace();
/*  64 */       return false;
/*     */     } 
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
/*     */   public i q() {
/*  80 */     i i = new i();
/*  81 */     i.c("class", "br.com.bb.aop.sala.base.SalaDisputaLotePK");
/*  82 */     i.a("codigoLicitacaoDisputaLotePK", a().v());
/*  83 */     i.a("codigoLoteDisputaLotePK", v());
/*     */     
/*  85 */     return i;
/*     */   }
/*     */   
/*     */   public BigDecimal e() {
/*  89 */     return this.d;
/*     */   }
/*     */   
/*     */   public void d(BigDecimal paramBigDecimal) {
/*  93 */     this.d = paramBigDecimal;
/*     */   }
/*     */   
/*     */   public boolean ap() {
/*  97 */     return this.G;
/*     */   }
/*     */   
/*     */   public void m(boolean paramBoolean) {
/* 101 */     this.G = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String K() {
/* 106 */     String str = super.K();
/*     */     
/* 108 */     if (ap()) {
/* 109 */       str = str + "#@#/img/exclamation.png";
/*     */     }
/* 111 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/* 116 */     return (g.b(bB(), g.x) || 
/* 117 */       g.b(bB(), g.D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/* 122 */     return g.b(bB(), g.y);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/* 127 */     if (a().a() == m.b) {
/* 128 */       return g.b(bB(), g.I);
/*     */     }
/*     */     
/* 131 */     return g.b(bB(), g.z);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean at() {
/* 137 */     return g.b(bB(), g.J);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/* 142 */     return (g.b(bB(), g.p) || 
/* 143 */       g.b(bB(), g.i) || 
/* 144 */       g.b(bB(), g.K));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/* 149 */     return (g.b(bB(), g.F) || 
/* 150 */       g.b(bB(), g.E) || 
/* 151 */       g.b(bB(), g.G));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/* 156 */     return (ax() || 
/* 157 */       g.b(bB(), g.A) || 
/* 158 */       g.b(bB(), g.H) || 
/* 159 */       g.b(bB(), g.L));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 164 */     return (g.b(bB(), g.at) || 
/* 165 */       g.b(bB(), g.aW));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 175 */     return super.az();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void N(String paramString) {
/* 180 */     super.N(paramString);
/*     */   }
/*     */   
/*     */   public void n(boolean paramBoolean) {
/* 184 */     this.H = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean aA() {
/* 188 */     return this.H;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */