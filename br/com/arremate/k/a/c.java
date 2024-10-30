/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.c.d;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.c.a;
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
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   public c(j paramj) {
/*  30 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  35 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  37 */     try (Statement null = a.a().createStatement()) {
/*  38 */       String str = aW();
/*  39 */       try (ResultSet null = statement.executeQuery(str)) {
/*  40 */         while (resultSet.next()) {
/*     */           
/*  42 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  43 */           a.T(resultSet.getString("itenumero"));
/*  44 */           a.ag(resultSet.getString("itedescricao"));
/*  45 */           a.k(resultSet.getDouble("itequantidade"));
/*  46 */           a.l(resultSet.getInt("iteposicao"));
/*  47 */           a.ai(resultSet.getString("itegrupo"));
/*  48 */           a.T(resultSet.getInt("itecodigogrupo"));
/*  49 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  50 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  51 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  52 */           a.a(b.a((g)a));
/*  53 */           a.R(resultSet.getInt("itetipo"));
/*  54 */           a.p(resultSet.getDouble("iteequalizacao"));
/*  55 */           a.ah(resultSet.getString("itedescricaocompleta"));
/*  56 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  57 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  58 */           a.z(resultSet.getBoolean("iteunitario"));
/*     */           
/*  60 */           if (resultSet.getObject("itesituacao") != null) {
/*  61 */             a.N(resultSet.getString("itesituacao"));
/*  62 */             a.S(resultSet.getInt("itestatuslance"));
/*  63 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  64 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  66 */             if (a.aw()) {
/*  67 */               h h = a.f();
/*     */               
/*  69 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  70 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  71 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  72 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  73 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  74 */                 h.al(resultSet.getString("itevencedormarca"));
/*  75 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  80 */           e e = new e((g)a);
/*  81 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  84 */     } catch (Exception exception) {
/*  85 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  88 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  93 */     return a().b().a().N() + ": " + a().bo();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/*  98 */     d d = new d(paramb, (a)parami, true);
/*  99 */     d.setName("disputaBLL_" + a().bo());
/* 100 */     return (g)d;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 105 */     return (g)new d(null, (a)parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 110 */     return ((d)d()).b(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 115 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 117 */     int i = ((Integer)map.get(Integer.valueOf(15))).intValue();
/* 118 */     int j = ((Integer)map.get(Integer.valueOf(16))).intValue();
/* 119 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 120 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*     */     
/* 122 */     int k = ((Integer)map.get(Integer.valueOf(7))).intValue() + i + j;
/* 123 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 125 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */