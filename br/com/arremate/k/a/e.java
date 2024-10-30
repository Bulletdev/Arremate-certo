/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.f.a;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
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
/*     */ 
/*     */ public class e
/*     */   extends g
/*     */ {
/*     */   public e(j paramj) {
/*  30 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<br.com.arremate.l.q.b.e> x() {
/*  35 */     ArrayList<br.com.arremate.l.q.b.e> arrayList = new ArrayList();
/*     */     
/*  37 */     try (Statement null = a.a().createStatement()) {
/*  38 */       String str = aW();
/*  39 */       try (ResultSet null = statement.executeQuery(str)) {
/*  40 */         br.com.arremate.l.e e1 = null;
/*     */ 
/*     */         
/*  43 */         while (resultSet.next()) {
/*     */           
/*  45 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  46 */           a.T(resultSet.getString("itenumero"));
/*  47 */           a.ag(resultSet.getString("itedescricao"));
/*  48 */           a.k(resultSet.getDouble("itequantidade"));
/*  49 */           a.aj(resultSet.getString("iteunidademedida"));
/*  50 */           a.l(resultSet.getInt("iteposicao"));
/*  51 */           a.ai(resultSet.getString("itegrupo"));
/*  52 */           a.T(resultSet.getInt("itecodigogrupo"));
/*  53 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  54 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  55 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  56 */           a.a(b.a((g)a));
/*  57 */           a.R(resultSet.getInt("itetipo"));
/*  58 */           a.p(resultSet.getDouble("iteequalizacao"));
/*  59 */           a.ah(resultSet.getString("itedescricaocompleta"));
/*  60 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  61 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*     */ 
/*     */           
/*  64 */           boolean bool = (a.bE() == null || a.bE().isEmpty()) ? true : false;
/*     */           
/*  66 */           if (resultSet.getObject("itesituacao") != null) {
/*  67 */             a.N(resultSet.getString("itesituacao"));
/*  68 */             a.S(resultSet.getInt("itestatuslance"));
/*  69 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  70 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  72 */             br.com.arremate.l.q.b.e e2 = new br.com.arremate.l.q.b.e((g)a);
/*     */ 
/*     */             
/*  75 */             if (e2.br() && bool) {
/*  76 */               h h = a.f();
/*     */               
/*  78 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  79 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  80 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  81 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  82 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  83 */                 h.al(resultSet.getString("itevencedormarca"));
/*  84 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  89 */           if (bool) {
/*     */             
/*  91 */             if (e1 != null) {
/*  92 */               b(e1, arrayList);
/*  93 */               e1 = null;
/*     */             } 
/*     */             
/*  96 */             br.com.arremate.l.q.b.e e2 = new br.com.arremate.l.q.b.e((g)a);
/*  97 */             arrayList.add(e2); continue;
/*     */           } 
/*  99 */           if (e1 == null) {
/* 100 */             e1 = new br.com.arremate.l.e(a.H(), a.bE());
/* 101 */             e1.l(a.j());
/* 102 */             e1.N(a.bB());
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 107 */           if (a.H() != e1.v()) {
/* 108 */             if (e1.G() > 0) {
/* 109 */               b(e1, arrayList);
/*     */             }
/*     */             
/* 112 */             e1 = new br.com.arremate.l.e(a.H(), a.bE());
/* 113 */             e1.l(a.j());
/* 114 */             e1.N(a.bB());
/*     */           } 
/*     */           
/* 117 */           e1.f((g)a);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 122 */         if (e1 != null) {
/* 123 */           b(e1, arrayList);
/*     */         }
/*     */       } 
/* 126 */     } catch (Exception exception) {
/* 127 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/* 130 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 135 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 137 */     char c = 'È';
/* 138 */     byte b = 0;
/*     */     
/* 140 */     if (ak()) {
/* 141 */       b = 20;
/* 142 */       map.put(Integer.valueOf(0), Integer.valueOf(b));
/*     */     } 
/*     */     
/* 145 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/* 146 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*     */     
/* 148 */     int k = ((Integer)map.get(Integer.valueOf(15))).intValue();
/* 149 */     int m = ((Integer)map.get(Integer.valueOf(16))).intValue();
/* 150 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 151 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*     */     
/* 153 */     int n = j + i + k + m - c - b;
/*     */     
/* 155 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/* 156 */     map.put(Integer.valueOf(7), Integer.valueOf(n));
/*     */     
/* 158 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 163 */     br.com.arremate.d.h.e e1 = new br.com.arremate.d.h.e(paramb, (a)parami, true);
/* 164 */     e1.setName("disputaCP_" + a().v());
/* 165 */     return (g)e1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 170 */     return (g)new br.com.arremate.d.h.e(null, (a)parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(br.com.arremate.l.q.b.e parame, double paramDouble) {
/* 175 */     if (c() != null && c().isRunning()) {
/* 176 */       return c().b(parame, paramDouble);
/*     */     }
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected br.com.arremate.d.h.e c() {
/* 183 */     return (br.com.arremate.d.h.e)super.d();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */