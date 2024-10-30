/*     */ package br.com.arremate.k.a.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.u.f;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.e.b;
/*     */ import br.com.arremate.l.e.f;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends g
/*     */ {
/*     */   public d(j paramj) {
/*  33 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  38 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  40 */     try(Statement null = a.a().createStatement(); 
/*  41 */         ResultSet null = statement.executeQuery(aW())) {
/*  42 */       e e = null;
/*     */ 
/*     */ 
/*     */       
/*  46 */       while (resultSet.next()) {
/*     */         
/*  48 */         b b = new b(resultSet.getInt("itecodigo"), (f)a());
/*  49 */         b.T(resultSet.getString("itenumero"));
/*  50 */         b.ag(resultSet.getString("itedescricao"));
/*  51 */         b.k(resultSet.getDouble("itequantidade"));
/*  52 */         b.l(resultSet.getInt("iteposicao"));
/*  53 */         b.ai(resultSet.getString("itegrupo"));
/*  54 */         b.T(resultSet.getInt("itecodigogrupo"));
/*  55 */         b.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  56 */         b.o(resultSet.getDouble("itevalorminimo"));
/*  57 */         b.n(resultSet.getDouble("itevalorproposta"));
/*  58 */         b.a(b.a((g)b));
/*  59 */         b.R(resultSet.getInt("itetipo"));
/*  60 */         b.p(resultSet.getDouble("iteequalizacao"));
/*  61 */         b.ah(resultSet.getString("itedescricaocompleta"));
/*  62 */         b.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  63 */         b.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*     */ 
/*     */         
/*  66 */         boolean bool = (b.bE() == null || b.bE().isEmpty()) ? true : false;
/*     */         
/*  68 */         if (resultSet.getObject("itesituacao") != null) {
/*  69 */           b.N(resultSet.getString("itesituacao"));
/*  70 */           b.S(resultSet.getInt("itestatuslance"));
/*  71 */           b.l(resultSet.getDouble("itemelhorlance"));
/*  72 */           b.h(resultSet.getDouble("iteultimolance"));
/*     */           
/*  74 */           e e1 = new e((g)b);
/*     */ 
/*     */           
/*  77 */           if (e1.br() && bool) {
/*  78 */             h h = b.f();
/*     */             
/*  80 */             if (resultSet.getObject("itevencedorcnpj") != null) {
/*  81 */               h.D(resultSet.getString("itevencedorcnpj"));
/*  82 */               h.E(resultSet.getString("itevencedornomeempresa"));
/*  83 */               h.ap(resultSet.getString("itevencedorporte"));
/*  84 */               h.ao(resultSet.getString("itevencedormodelo"));
/*  85 */               h.al(resultSet.getString("itevencedormarca"));
/*  86 */               h.am(resultSet.getString("itevencedorfabricante"));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  91 */         if (bool) {
/*     */           
/*  93 */           if (e != null) {
/*  94 */             b(e, arrayList);
/*  95 */             e = null;
/*     */           } 
/*     */           
/*  98 */           e e1 = new e((g)b);
/*  99 */           arrayList.add(e1); continue;
/*     */         } 
/* 101 */         if (e == null) {
/* 102 */           e = new e(b.H(), b.bE());
/* 103 */           e.l(b.j());
/* 104 */           e.N(b.bB());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 109 */         if (b.H() != e.v()) {
/* 110 */           if (e.G() > 0) {
/* 111 */             b(e, arrayList);
/*     */           }
/*     */           
/* 114 */           e = new e(b.H(), b.bE());
/* 115 */           e.l(b.j());
/* 116 */           e.N(b.bB());
/*     */         } 
/*     */         
/* 119 */         e.f((g)b);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 124 */       if (e != null) {
/* 125 */         b(e, arrayList);
/*     */       }
/*     */     }
/* 128 */     catch (Exception exception) {
/* 129 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/* 132 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 137 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 139 */     if (ak()) {
/* 140 */       int i = ((Integer)map.get(Integer.valueOf(7))).intValue();
/* 141 */       map.put(Integer.valueOf(0), Integer.valueOf(20));
/* 142 */       map.put(Integer.valueOf(7), Integer.valueOf(i - 20));
/*     */     } 
/*     */     
/* 145 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 150 */     br.com.arremate.j.l.a.d d1 = (br.com.arremate.j.l.a.d)parami;
/* 151 */     f f = new f(paramb, d1);
/* 152 */     f.setName("disputaCN_" + a().v());
/* 153 */     return (g)f;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 158 */     return ((f)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> a(e parame, i parami) {
/* 163 */     List<h> list = new ArrayList();
/*     */     
/*     */     try {
/*     */       g g1;
/*     */       
/* 168 */       if (d() != null && d().isRunning()) {
/* 169 */         g1 = d();
/*     */       } else {
/* 171 */         a(parame, parami);
/* 172 */         g1 = e();
/*     */       } 
/*     */       
/* 175 */       byte b = 0;
/*     */ 
/*     */       
/*     */       do {
/*     */         try {
/* 180 */           list = g1.b(parame);
/* 181 */         } catch (br.com.arremate.g.d d1) {
/* 182 */           a.info("Não foi possível carregar os melhores lances. Motivo: Tempo limite para captura excedido.");
/* 183 */           b++;
/*     */         } finally {
/* 185 */           b++;
/*     */         } 
/* 187 */       } while (list.isEmpty() && b <= 5);
/*     */       
/* 189 */       if (!list.isEmpty())
/*     */       {
/* 191 */         s(System.currentTimeMillis());
/*     */       }
/* 193 */     } catch (Exception exception) {
/* 194 */       a.error("Failed to get best bids", exception);
/*     */     } 
/*     */     
/* 197 */     e(null);
/* 198 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 203 */     return (g)new f(null, (br.com.arremate.j.l.a.d)parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public long q() {
/* 208 */     return TimeUnit.MINUTES.toMillis(1L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */