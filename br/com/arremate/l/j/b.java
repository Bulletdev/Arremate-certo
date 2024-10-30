/*     */ package br.com.arremate.l.j;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.j;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ public class b extends j implements a {
/*     */   public b(d paramd, int paramInt) {
/*  29 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  35 */       byte b1 = 1;
/*  36 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licicms, licmododedisputa, liclimitecasasdecimais";
/*  37 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?";
/*     */       
/*  39 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  40 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  41 */       preparedStatement.setInt(b1++, b().v());
/*  42 */       preparedStatement.setLong(b1++, C());
/*  43 */       preparedStatement.setInt(b1++, v());
/*  44 */       preparedStatement.setString(b1++, bo());
/*  45 */       preparedStatement.setInt(b1++, K());
/*  46 */       preparedStatement.setString(b1++, bT());
/*  47 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  48 */       preparedStatement.setBoolean(b1++, bf());
/*  49 */       preparedStatement.setBoolean(b1++, aZ());
/*  50 */       preparedStatement.setBoolean(b1++, k());
/*  51 */       preparedStatement.setInt(b1++, a().getId());
/*  52 */       preparedStatement.setInt(b1++, N());
/*     */       
/*  54 */       return (preparedStatement.executeUpdate() == 1);
/*  55 */     } catch (SQLException sQLException) {
/*  56 */       a.error("Erro ao gravar dados da disputa", sQLException);
/*     */ 
/*     */       
/*  59 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  64 */     j j1 = new j(this);
/*  65 */     return new br.com.arremate.d.b((g)j1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  72 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/*     */     try {
/*  75 */       a a1 = (a)parami;
/*     */       
/*  77 */       e e = a1.t(v());
/*  78 */       i i1 = new i(e.getData().replaceAll("\\\\.", ""));
/*  79 */       Y(i1.getInt("precision"));
/*     */       
/*  81 */       e = a1.s(v());
/*     */       
/*  83 */       if (e.getData().isEmpty()) {
/*  84 */         return arrayList;
/*     */       }
/*     */       
/*  87 */       f f = new f(e.getData());
/*     */       
/*  89 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/*  90 */         i i2 = (i)f.get(b1);
/*  91 */         a a2 = new a(i2.getInt("batch"), this);
/*  92 */         a2.T(String.valueOf(i2.getInt("batch")));
/*  93 */         int k = 0;
/*     */         
/*  95 */         if (i2.has("bidIntervalCriteria") && !i2.isNull("bidIntervalCriteria")) {
/*  96 */           k = i2.getInt("bidIntervalCriteria");
/*     */         }
/*     */         
/*  99 */         if (i2.has("minimumBidInterval") && !i2.isNull("minimumBidInterval")) {
/* 100 */           if (k == 2) {
/* 101 */             a2.f(new BigDecimal(i2.getDouble("minimumBidInterval")));
/*     */           } else {
/* 103 */             a2.e(new BigDecimal(i2.getDouble("minimumBidInterval")));
/*     */           } 
/*     */         }
/*     */         
/* 107 */         f f1 = i2.c("batchItem");
/*     */         
/* 109 */         if (aZ()) {
/* 110 */           a(a2, f1);
/*     */         } else {
/* 112 */           b(a2, f1);
/*     */         } 
/* 114 */         arrayList.add(a2);
/*     */       }
/*     */     
/* 117 */     } catch (g g) {
/* 118 */       a.error("Bidding {} - Failed to capture dispute items data from Licitanet", bo(), g);
/*     */     } 
/*     */     
/* 121 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(g paramg, f paramf) {
/* 125 */     i i = (i)paramf.get(0);
/* 126 */     paramg.k(i.getInt("quantity"));
/*     */ 
/*     */     
/* 129 */     Object object = i.get("itemDetailedInfo");
/* 130 */     paramg.ag(object.toString());
/*     */     
/* 132 */     paramg.aj(i.bl("unity"));
/* 133 */     paramg.m(i.getDouble("proposalValue"));
/*     */   }
/*     */   
/*     */   private void b(g paramg, f paramf) {
/* 137 */     paramg.k(1.0D);
/* 138 */     paramg.ag("LOTE " + paramg.bo());
/* 139 */     double d = 0.0D;
/* 140 */     for (byte b1 = 0; b1 < paramf.length(); b1++) {
/* 141 */       i i = (i)paramf.get(b1);
/* 142 */       d += i.getDouble("proposalValue") * i.getInt("quantity");
/*     */     } 
/* 144 */     paramg.n(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 149 */     if (a() == l.c) {
/* 150 */       return "Dispensa";
/*     */     }
/*     */     
/* 153 */     if (a() == l.l) {
/* 154 */       return "Concorrência Pública";
/*     */     }
/*     */     
/* 157 */     if (a() == u.i) {
/* 158 */       return "Maior Lance";
/*     */     }
/*     */     
/* 161 */     if (a() == u.j) {
/* 162 */       return "Menor Taxa";
/*     */     }
/*     */     
/* 165 */     if (a() == u.d) {
/* 166 */       return "Maior Desconto";
/*     */     }
/*     */     
/* 169 */     if (k.b() && 
/* 170 */       a() == m.c) {
/* 171 */       return "modo Aberto/Fechado";
/*     */     }
/*     */ 
/*     */     
/* 175 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */