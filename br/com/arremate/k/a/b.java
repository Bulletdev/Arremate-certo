/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b.c;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.a.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b.a;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends g
/*     */ {
/*     */   public b(br.com.arremate.l.b.b paramb) {
/*  30 */     super((j)paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  35 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  37 */     try (Statement null = a.a().createStatement()) {
/*  38 */       String str = aW();
/*     */       
/*  40 */       try (ResultSet null = statement.executeQuery(str)) {
/*  41 */         e e = null;
/*     */ 
/*     */         
/*  44 */         while (resultSet.next()) {
/*     */           
/*  46 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  47 */           a.T(resultSet.getString("itenumero"));
/*  48 */           a.ag(resultSet.getString("itedescricao"));
/*  49 */           a.k(resultSet.getDouble("itequantidade"));
/*  50 */           a.aj(resultSet.getString("iteunidademedida"));
/*  51 */           a.l(resultSet.getInt("iteposicao"));
/*  52 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  53 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  54 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  55 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  56 */           a.ai(resultSet.getString("itegrupo"));
/*  57 */           a.T(resultSet.getInt("itecodigogrupo"));
/*     */           
/*  59 */           a.a(br.com.arremate.l.b.a((g)a));
/*     */           
/*  61 */           if (resultSet.getObject("itesituacao") != null) {
/*  62 */             a.N(resultSet.getString("itesituacao"));
/*  63 */             a.S(resultSet.getInt("itestatuslance"));
/*  64 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  65 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  67 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  70 */             if (e1.br()) {
/*  71 */               h h = a.f();
/*     */               
/*  73 */               if (resultSet.getObject("itevencedornomeempresa") != null) {
/*  74 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  75 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  76 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  77 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  78 */                 h.al(resultSet.getString("itevencedormarca"));
/*  79 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  84 */           boolean bool = (a.bE() == null || a.bE().isEmpty()) ? true : false;
/*  85 */           if (bool) {
/*     */             
/*  87 */             if (e != null) {
/*  88 */               b(e, arrayList);
/*  89 */               e = null;
/*     */             } 
/*     */             
/*  92 */             e e1 = new e((g)a);
/*  93 */             arrayList.add(e1); continue;
/*     */           } 
/*  95 */           if (e == null) {
/*  96 */             e = new e(a.H(), a.bE());
/*  97 */             e.l(a.j());
/*  98 */             e.N(a.bB());
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 103 */           if (a.H() != e.v()) {
/* 104 */             if (e.G() > 0) {
/* 105 */               b(e, arrayList);
/*     */             }
/*     */             
/* 108 */             e = new e(a.H(), a.bE());
/* 109 */             e.l(a.j());
/* 110 */             e.N(a.bB());
/*     */           } 
/*     */           
/* 113 */           e.f((g)a);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 118 */         if (e != null) {
/* 119 */           b(e, arrayList);
/*     */         }
/*     */       } 
/* 122 */     } catch (Exception exception) {
/* 123 */       a.warn("BEC - Erro ao carregar istens do pregão", exception);
/*     */     } 
/*     */     
/* 126 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 131 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 133 */     char c = 'È';
/* 134 */     byte b1 = 0;
/*     */     
/* 136 */     if (ak()) {
/* 137 */       b1 = 20;
/* 138 */       map.put(Integer.valueOf(0), Integer.valueOf(b1));
/*     */     } 
/*     */     
/* 141 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/* 142 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/* 143 */     int k = j + i - c - b1;
/*     */     
/* 145 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/* 146 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 148 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(br.com.arremate.d.b paramb, i parami) {
/* 153 */     c c = new c(paramb, (a)parami, true);
/* 154 */     c.setName("disputaBEC_" + a().bo());
/* 155 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 160 */     return a().b().a().N() + ": " + a().bo();
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 165 */     return (g)new c(null, (a)parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 170 */     if (c() == null || !c().isRunning()) {
/* 171 */       return false;
/*     */     }
/*     */     
/* 174 */     return c().b(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   protected c c() {
/* 179 */     return (c)super.d();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */