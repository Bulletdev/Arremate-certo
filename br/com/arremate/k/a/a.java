/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.a.i;
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.c;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.j.d.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.c.c;
/*     */ import br.com.arremate.l.a.b;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k;
/*     */ import br.com.arremate.l.p;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.h;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.l.q.c.n;
/*     */ import br.com.arremate.m.d;
/*     */ import br.com.arremate.m.n;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*     */   public a(j paramj) {
/*  43 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  48 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  50 */     try (Statement null = br.com.arremate.e.a.a().createStatement()) {
/*  51 */       String str = aW();
/*     */       
/*  53 */       try (ResultSet null = statement.executeQuery(str)) {
/*     */ 
/*     */         
/*  56 */         while (resultSet.next()) {
/*     */           
/*  58 */           br.com.arremate.l.a.a a1 = new br.com.arremate.l.a.a(Integer.parseInt(resultSet.getString("itecodigo")), (b)a());
/*  59 */           a1.ag(resultSet.getString("itedescricao"));
/*  60 */           a1.o(resultSet.getDouble("itevalorminimo"));
/*  61 */           a1.n(resultSet.getDouble("itevalorproposta"));
/*  62 */           a1.l(resultSet.getInt("iteposicao"));
/*  63 */           a1.d(resultSet.getBigDecimal("itevalorminimoentrepropriolance"));
/*  64 */           a1.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*     */ 
/*     */           
/*  67 */           a1.z(resultSet.getLong("itetempominimoentremelhorlance"));
/*  68 */           a1.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  69 */           a1.a(b.a((g)a1));
/*  70 */           a1.R(resultSet.getInt("itetipo"));
/*  71 */           a1.ah(resultSet.getString("itedescricaocompleta"));
/*  72 */           a1.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*     */           
/*  74 */           if (resultSet.getObject("itesituacao") != null) {
/*  75 */             a1.N(resultSet.getString("itesituacao"));
/*  76 */             a1.S(resultSet.getInt("itestatuslance"));
/*  77 */             a1.l(resultSet.getDouble("itemelhorlance"));
/*  78 */             a1.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  80 */             e e1 = new e((g)a1);
/*     */ 
/*     */             
/*  83 */             if (e1.br()) {
/*  84 */               h h = a1.f();
/*     */               
/*  86 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  87 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  88 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  89 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  90 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  91 */                 h.al(resultSet.getString("itevencedormarca"));
/*  92 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*  96 */           e e = new e((g)a1);
/*  97 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/* 100 */     } catch (Exception exception) {
/* 101 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/* 104 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 109 */     StringBuilder stringBuilder = new StringBuilder(a().b().a().N());
/* 110 */     stringBuilder.append(": ");
/* 111 */     stringBuilder.append(a().v());
/* 112 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String aU() {
/* 117 */     return Integer.toString(a().v());
/*     */   }
/*     */ 
/*     */   
/*     */   public String aV() {
/* 122 */     return a().bT();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 127 */     i i1 = new i(paramb, parami, true);
/* 128 */     i1.setName("disputaBB_" + a().v());
/* 129 */     return (g)i1;
/*     */   }
/*     */ 
/*     */   
/*     */   public g b(b paramb, i parami) {
/* 134 */     i i1 = new i(paramb, parami, false);
/* 135 */     i1.setName("disputaBB_" + a().v());
/* 136 */     return (g)i1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 141 */     return ((i)d()).a(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public void y(e parame) {
/* 146 */     if (a().a().a() != p.c) {
/* 147 */       JOptionPane.showMessageDialog(null, "A disputa contra ME/EPP está disponível somente para indústrias, e sua empresa (" + 
/* 148 */           a().a().bv().toUpperCase() + ") está enquadrada no regime ME/EPP.", "Erro", 0);
/*     */     } else {
/* 150 */       parame.q(!parame.aU());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 156 */     return (g)new i(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected p a(h paramh) {
/* 161 */     p p = new p(a());
/* 162 */     p.p().put(c.a, "Lote");
/* 163 */     p.p().remove(c.b);
/*     */     
/* 165 */     i i = (i)paramh.getModel();
/* 166 */     ArrayList arrayList = new ArrayList(i.L());
/*     */ 
/*     */     
/* 169 */     arrayList.forEach(parame -> {
/*     */           k k = new k(parame.a());
/*     */           
/*     */           k.aC(null);
/*     */           paramp.a(k);
/*     */         });
/* 175 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 180 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 182 */     int i = ((Integer)map.get(Integer.valueOf(7))).intValue();
/* 183 */     map.put(Integer.valueOf(7), Integer.valueOf(i - 60));
/*     */     
/* 185 */     int j = ((Integer)map.get(Integer.valueOf(8))).intValue();
/* 186 */     map.put(Integer.valueOf(8), Integer.valueOf(j + 60));
/*     */     
/* 188 */     return map;
/*     */   }
/*     */   
/*     */   public void a(b paramb, n paramn) {
/*     */     try {
/*     */       boolean bool1;
/* 194 */       if (!n.bQ()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 199 */       i i = (i)d();
/* 200 */       boolean bool2 = false;
/*     */       
/*     */       do {
/* 203 */         int j = -1;
/* 204 */         bool1 = false;
/* 205 */         int k = paramn.getRowCount();
/*     */ 
/*     */         
/* 208 */         for (byte b1 = 0; b1 < k; b1++) {
/* 209 */           f f = paramn.a(b1);
/* 210 */           h h = f.h();
/*     */ 
/*     */           
/* 213 */           if (!h.ba()) {
/*     */             
/* 215 */             if (j == -1) {
/* 216 */               bool1 = true;
/* 217 */               j = JOptionPane.showConfirmDialog(null, "Não foi possível capturar alguns dados dos itens encerrados. Deseja tentar buscar novamente do portal?", "Informação", 0, 1);
/*     */ 
/*     */ 
/*     */               
/* 221 */               if (j == 1) {
/* 222 */                 bool2 = false;
/* 223 */                 bool1 = false;
/*     */                 
/*     */                 break;
/*     */               } 
/* 227 */               paramn.cH();
/* 228 */               paramn.fireTableDataChanged();
/*     */             } 
/*     */ 
/*     */             
/* 232 */             if (i == null || i.a() == null || !i.a().isRunning()) {
/* 233 */               Future<c> future = c.b(a());
/* 234 */               c c = future.get();
/* 235 */               i = new i(null, (i)c, false);
/*     */             } 
/*     */ 
/*     */             
/* 239 */             i.a(f, paramn, null);
/* 240 */             bool2 = true;
/*     */           } 
/*     */         } 
/* 243 */       } while (bool1);
/*     */ 
/*     */       
/* 246 */       if (bool2) {
/* 247 */         ArrayList arrayList = new ArrayList();
/* 248 */         paramn.M().parallelStream().forEach(paramf -> paramList.add(paramf.b()));
/*     */ 
/*     */ 
/*     */         
/* 252 */         i.e(arrayList);
/*     */       } 
/* 254 */     } catch (Exception exception) {
/* 255 */       a.warn("Failed to check unloaded closed items", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(h paramh) {
/* 261 */     StringBuilder stringBuilder = new StringBuilder("Arremate_");
/* 262 */     stringBuilder.append(a().b().a().N());
/* 263 */     stringBuilder.append("_");
/* 264 */     stringBuilder.append(a().v());
/*     */     
/* 266 */     p p = a(paramh);
/* 267 */     d d = new d(p);
/* 268 */     d.aH(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public long q() {
/* 273 */     return TimeUnit.SECONDS.toMillis(30L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */