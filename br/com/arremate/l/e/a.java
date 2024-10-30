/*     */ package br.com.arremate.l.e;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   private String dD;
/*  19 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   public a(int paramInt, c paramc) {
/*  22 */     super(paramInt, paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  27 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itecodigogrupo, itegrupo, itetipo, iteposicao, iteequalizacao, itedescricaocompleta, itevalorminimoentremelhorlance, itepercentualminimoentrelance, iteunidademedida";
/*     */     
/*  29 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  30 */     byte b = 1;
/*     */     
/*  32 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  34 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  35 */       preparedStatement.setInt(b++, a().v());
/*  36 */       preparedStatement.setInt(b++, a().b().v());
/*  37 */       preparedStatement.setLong(b++, a().C());
/*  38 */       preparedStatement.setInt(b++, v());
/*  39 */       preparedStatement.setString(b++, bo());
/*  40 */       preparedStatement.setString(b++, K());
/*  41 */       preparedStatement.setDouble(b++, i());
/*  42 */       preparedStatement.setBoolean(b++, aT());
/*  43 */       preparedStatement.setDouble(b++, k());
/*  44 */       preparedStatement.setDouble(b++, j());
/*  45 */       preparedStatement.setInt(b++, H());
/*  46 */       preparedStatement.setString(b++, bE().isEmpty() ? null : bE());
/*  47 */       preparedStatement.setInt(b++, w());
/*  48 */       preparedStatement.setInt(b++, j());
/*  49 */       preparedStatement.setDouble(b++, a());
/*  50 */       preparedStatement.setString(b++, bD());
/*  51 */       preparedStatement.setBigDecimal(b++, r());
/*  52 */       preparedStatement.setBigDecimal(b++, s());
/*  53 */       preparedStatement.setString(b++, bF());
/*  54 */       preparedStatement.execute();
/*  55 */     } catch (Exception exception) {
/*  56 */       a.error("Erro ao gravar dados dos itens disputa", exception);
/*  57 */       return false;
/*     */     } 
/*     */     
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  65 */     return (g.b(bB(), g.a) || 
/*  66 */       g.b(bB(), g.b) || 
/*  67 */       g.b(bB(), g.c) || 
/*  68 */       g.b(bB(), g.d) || 
/*  69 */       g.b(bB(), g.e));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  74 */     return (g.b(bB(), g.f) || 
/*  75 */       g.b(bB(), g.j) || 
/*     */       
/*  77 */       g.b(bB(), g.v));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  82 */     if (a() instanceof d)
/*  83 */       return g.b(bB(), g.w); 
/*  84 */     if (a().a() == m.b || a().a() == m.f)
/*  85 */       return g.b(bB(), g.aE); 
/*  86 */     if (a().a() == m.c) {
/*  87 */       return g.b(bB(), g.k);
/*     */     }
/*  89 */     return g.b(bB(), g.k);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean at() {
/*  95 */     return g.b(bB(), g.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean au() {
/* 100 */     return (g.b(bB(), g.n) || 
/* 101 */       g.b(bB(), g.i) || 
/* 102 */       g.b(bB(), g.m) || 
/* 103 */       g.b(bB(), g.p) || 
/* 104 */       g.b(bB(), g.o));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/* 109 */     return (g.b(bB(), g.aW) || 
/* 110 */       g.b(bB(), g.q) || 
/* 111 */       g.b(bB(), g.l));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/* 116 */     return (ax() || g.b(bB(), g.s));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/* 121 */     return g.b(bB(), g.av);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public String u() {
/* 130 */     return this.dD;
/*     */   }
/*     */   
/*     */   public void n(String paramString) {
/* 134 */     this.dD = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */