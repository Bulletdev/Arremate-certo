/*     */ package br.com.arremate.l.i;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*  33 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   private Date c;
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  38 */     super(paramd, paramInt);
/*  39 */     super.Q(999);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] a() {
/*  44 */     Object[] arrayOfObject = super.a();
/*  45 */     arrayOfObject[2] = Integer.valueOf(v());
/*  46 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  52 */       byte b1 = 1;
/*  53 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, lictipoapuracao, licmododedisputa, liclimitecasasdecimais, licicms, licmodalidade, licdataencerramento";
/*  54 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, FALSE, FALSE, ?, ?, ?, ?, ?, ?";
/*     */       
/*  56 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  57 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  58 */       preparedStatement.setInt(b1++, b().v());
/*  59 */       preparedStatement.setLong(b1++, C());
/*  60 */       preparedStatement.setInt(b1++, v());
/*  61 */       preparedStatement.setString(b1++, bo());
/*  62 */       preparedStatement.setInt(b1++, K());
/*  63 */       preparedStatement.setString(b1++, bT());
/*  64 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  65 */       preparedStatement.setInt(b1++, a().w());
/*  66 */       preparedStatement.setInt(b1++, a().getId());
/*  67 */       preparedStatement.setInt(b1++, N());
/*  68 */       preparedStatement.setBoolean(b1++, k());
/*  69 */       preparedStatement.setInt(b1++, a().getId());
/*  70 */       preparedStatement.setTimestamp(b1++, (c() != null) ? new Timestamp(c().getTime()) : null);
/*     */       
/*  72 */       return (preparedStatement.executeUpdate() == 1);
/*  73 */     } catch (Exception exception) {
/*  74 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  77 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  82 */     i i = new i(this);
/*  83 */     return new br.com.arremate.d.b((g)i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  90 */     ArrayList<a> arrayList = new ArrayList();
/*     */     
/*     */     try {
/*  93 */       br.com.arremate.j.i.b b1 = (br.com.arremate.j.i.b)parami;
/*     */ 
/*     */       
/*  96 */       f f = null;
/*     */       
/*  98 */       e e = b1.p(v());
/*  99 */       f = (new i(e.getData())).c("data");
/*     */       
/* 101 */       for (byte b2 = 0; b2 < f.length(); b2++) {
/* 102 */         i i1 = (i)f.get(b2);
/* 103 */         int k = i1.getInt("numeroLote");
/*     */         
/* 105 */         if (a() == m.e && a() != l.i) {
/* 106 */           a(b(i1.getInt("codigoTipoDisputa")));
/*     */         }
/*     */         
/* 109 */         a a1 = new a(k, this);
/* 110 */         a1.T(String.valueOf(k));
/* 111 */         a1.k(1.0D);
/* 112 */         a1.ag("LOTE " + k);
/* 113 */         a1.R(O());
/* 114 */         if (i1.has("valorProposta") && !i1.isNull("valorProposta"))
/* 115 */         { a1.m(i1.getDouble("valorProposta"));
/* 116 */           a1.n(i1.getDouble("valorProposta"));
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 121 */           arrayList.add(a1); } 
/*     */       } 
/* 123 */     } catch (g g) {
/* 124 */       a.error("Bidding {} - Failed to capture dispute items data from Licitacoes-e", bo(), g);
/*     */     } 
/*     */     
/* 127 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private int O() {
/* 131 */     if (a() == u.d) {
/* 132 */       return v.b.v();
/*     */     }
/* 134 */     return v.a.v();
/*     */   }
/*     */ 
/*     */   
/*     */   private m b(int paramInt) {
/* 139 */     switch (paramInt) {
/*     */       case 11:
/* 141 */         return m.b;
/*     */       case 12:
/* 143 */         return m.c;
/*     */     } 
/* 145 */     return m.e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void Q(int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String bf() {
/* 155 */     return Integer.toString(v());
/*     */   }
/*     */ 
/*     */   
/*     */   public Date c() {
/* 160 */     return this.c;
/*     */   }
/*     */   
/*     */   public void d(Date paramDate) {
/* 164 */     this.c = paramDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 169 */     if (k.b() && 
/* 170 */       k()) {
/* 171 */       return "Equalização ICMS";
/*     */     }
/*     */ 
/*     */     
/* 175 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */