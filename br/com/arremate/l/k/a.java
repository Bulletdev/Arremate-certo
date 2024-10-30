/*     */ package br.com.arremate.l.k;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private long Q;
/*     */   private boolean af = false;
/*     */   
/*     */   public a(int paramInt, j paramj) {
/*  17 */     super(paramInt, paramj);
/*  18 */     this.Q = 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  23 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao, itevalorminimoentremelhorlance, iteidempresa ";
/*     */ 
/*     */     
/*  26 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
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
/*  38 */       preparedStatement.setInt(b++, 1);
/*  39 */       preparedStatement.setBoolean(b++, false);
/*  40 */       preparedStatement.setDouble(b++, k());
/*  41 */       preparedStatement.setDouble(b++, j());
/*  42 */       preparedStatement.setInt(b++, w());
/*  43 */       preparedStatement.setInt(b++, j());
/*  44 */       preparedStatement.setBigDecimal(b++, r());
/*  45 */       preparedStatement.setString(b++, bG());
/*  46 */       preparedStatement.execute();
/*  47 */     } catch (Exception exception) {
/*  48 */       exception.printStackTrace();
/*  49 */       return false;
/*     */     } 
/*     */     
/*  52 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  57 */     return (g.b(bB(), g.V) || 
/*  58 */       g.b(bB(), g.W) || 
/*  59 */       g.b(bB(), g.r));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  64 */     return (g.b(bB(), g.aa) || 
/*  65 */       g.b(bB(), g.ac) || 
/*  66 */       g.b(bB(), g.R) || 
/*  67 */       g.b(bB(), g.T));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  72 */     return (g.b(bB(), g.ad) || 
/*  73 */       g.b(bB(), g.ab) || 
/*  74 */       g.b(bB(), g.M));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/*  79 */     return (g.b(bB(), g.N) || 
/*  80 */       g.b(bB(), g.U) || 
/*  81 */       g.b(bB(), g.p) || 
/*  82 */       g.b(bB(), g.O));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  87 */     return g.b(bB(), g.P);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/*  92 */     return (ax() || 
/*  93 */       g.b(bB(), g.ae) || 
/*  94 */       g.b(bB(), g.af) || 
/*  95 */       g.b(bB(), g.ag) || 
/*  96 */       g.b(bB(), g.ah) || 
/*  97 */       g.b(bB(), g.H) || 
/*  98 */       g.b(bB(), g.Y) || 
/*  99 */       g.b(bB(), g.Z) || 
/* 100 */       g.b(bB(), g.Q) || 
/* 101 */       g.b(bB(), g.S));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 106 */     return g.b(bB(), g.at);
/*     */   }
/*     */   
/*     */   public void e(Date paramDate) {
/* 110 */     this.Q = paramDate.getTime();
/*     */   }
/*     */   
/*     */   public long D() {
/* 114 */     return this.Q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/* 130 */     return super.az();
/*     */   }
/*     */   
/*     */   public boolean bh() {
/* 134 */     return this.af;
/*     */   }
/*     */   
/*     */   public void F(boolean paramBoolean) {
/* 138 */     this.af = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */