/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.d.a;
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
/*     */ public class d
/*     */   extends g
/*     */ {
/*     */   public d(j paramj) {
/*  25 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  30 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  32 */     try (Statement null = a.a().createStatement()) {
/*  33 */       String str = aW();
/*  34 */       try (ResultSet null = statement.executeQuery(str)) {
/*  35 */         while (resultSet.next()) {
/*     */           
/*  37 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  38 */           a.T(resultSet.getString("itenumero"));
/*  39 */           a.ag(resultSet.getString("itedescricao"));
/*  40 */           a.k(resultSet.getDouble("itequantidade"));
/*  41 */           a.l(resultSet.getInt("iteposicao"));
/*  42 */           a.ai(resultSet.getString("itegrupo"));
/*  43 */           a.T(resultSet.getInt("itecodigogrupo"));
/*  44 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  45 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  46 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  47 */           a.a(b.a((g)a));
/*  48 */           a.R(resultSet.getInt("itetipo"));
/*  49 */           a.p(resultSet.getDouble("iteequalizacao"));
/*  50 */           a.ah(resultSet.getString("itedescricaocompleta"));
/*  51 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  52 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  53 */           a.z(resultSet.getBoolean("iteunitario"));
/*     */           
/*  55 */           if (resultSet.getObject("itesituacao") != null) {
/*  56 */             a.N(resultSet.getString("itesituacao"));
/*  57 */             a.S(resultSet.getInt("itestatuslance"));
/*  58 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  59 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  61 */             if (a.aw()) {
/*  62 */               h h = a.f();
/*     */               
/*  64 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  65 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  66 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  67 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  68 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  69 */                 h.al(resultSet.getString("itevencedormarca"));
/*  70 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  75 */           e e = new e((g)a);
/*  76 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  79 */     } catch (Exception exception) {
/*  80 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  83 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  88 */     return a().b().a().N() + ": " + a().bo();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/*  93 */     br.com.arremate.d.d.d d1 = new br.com.arremate.d.d.d(paramb, (a)parami, true);
/*  94 */     d1.setName("disputaBNC_" + a().bo());
/*  95 */     return (g)d1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 100 */     return (g)new br.com.arremate.d.d.d(null, (a)parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 105 */     return ((br.com.arremate.d.d.d)d()).b(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 110 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 112 */     int i = ((Integer)map.get(Integer.valueOf(15))).intValue();
/* 113 */     int j = ((Integer)map.get(Integer.valueOf(16))).intValue();
/* 114 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 115 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*     */     
/* 117 */     int k = ((Integer)map.get(Integer.valueOf(7))).intValue() + i + j;
/* 118 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 120 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */