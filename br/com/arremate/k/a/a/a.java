/*     */ package br.com.arremate.k.a.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e.a.b;
/*     */ import br.com.arremate.d.e.p;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.c.c;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.c;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.l.q.c.n;
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
/*  41 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  46 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  48 */     try(Statement null = br.com.arremate.e.a.a().createStatement(); 
/*  49 */         ResultSet null = statement.executeQuery(aW())) {
/*  50 */       e e = null;
/*     */ 
/*     */ 
/*     */       
/*  54 */       while (resultSet.next()) {
/*     */         
/*  56 */         br.com.arremate.l.e.a a1 = new br.com.arremate.l.e.a(resultSet.getInt("itecodigo"), (c)a());
/*  57 */         a1.T(resultSet.getString("itenumero"));
/*  58 */         a1.ag(resultSet.getString("itedescricao"));
/*  59 */         a1.k(resultSet.getDouble("itequantidade"));
/*  60 */         a1.l(resultSet.getInt("iteposicao"));
/*  61 */         a1.ai(resultSet.getString("itegrupo"));
/*  62 */         a1.T(resultSet.getInt("itecodigogrupo"));
/*  63 */         a1.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  64 */         a1.o(resultSet.getDouble("itevalorminimo"));
/*  65 */         a1.n(resultSet.getDouble("itevalorproposta"));
/*  66 */         a1.a(b.a((g)a1));
/*  67 */         a1.R(resultSet.getInt("itetipo"));
/*  68 */         a1.p(resultSet.getDouble("iteequalizacao"));
/*  69 */         a1.ah(resultSet.getString("itedescricaocompleta"));
/*  70 */         a1.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  71 */         a1.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  72 */         a1.aj(resultSet.getString("iteunidademedida"));
/*     */ 
/*     */         
/*  75 */         boolean bool = (a1.bE() == null || a1.bE().isEmpty()) ? true : false;
/*     */         
/*  77 */         if (resultSet.getObject("itesituacao") != null) {
/*  78 */           a1.N(resultSet.getString("itesituacao"));
/*  79 */           a1.S(resultSet.getInt("itestatuslance"));
/*  80 */           a1.l(resultSet.getDouble("itemelhorlance"));
/*  81 */           a1.h(resultSet.getDouble("iteultimolance"));
/*     */           
/*  83 */           e e1 = new e((g)a1);
/*     */ 
/*     */           
/*  86 */           if (e1.br() && bool) {
/*  87 */             h h = a1.f();
/*     */             
/*  89 */             if (resultSet.getObject("itevencedorcnpj") != null) {
/*  90 */               h.D(resultSet.getString("itevencedorcnpj"));
/*  91 */               h.E(resultSet.getString("itevencedornomeempresa"));
/*  92 */               h.ap(resultSet.getString("itevencedorporte"));
/*  93 */               h.ao(resultSet.getString("itevencedormodelo"));
/*  94 */               h.al(resultSet.getString("itevencedormarca"));
/*  95 */               h.am(resultSet.getString("itevencedorfabricante"));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 100 */         if (bool) {
/*     */           
/* 102 */           if (e != null) {
/* 103 */             b(e, arrayList);
/* 104 */             e = null;
/*     */           } 
/*     */           
/* 107 */           e e1 = new e((g)a1);
/* 108 */           arrayList.add(e1); continue;
/*     */         } 
/* 110 */         if (e == null) {
/* 111 */           e = new e(a1.H(), a1.bE());
/* 112 */           e.l(a1.j());
/* 113 */           e.N(a1.bB());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 118 */         if (a1.H() != e.v()) {
/* 119 */           if (e.G() > 0) {
/* 120 */             b(e, arrayList);
/*     */           }
/*     */           
/* 123 */           e = new e(a1.H(), a1.bE());
/* 124 */           e.l(a1.j());
/* 125 */           e.N(a1.bB());
/*     */         } 
/*     */         
/* 128 */         e.f((g)a1);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 133 */       if (e != null) {
/* 134 */         b(e, arrayList);
/*     */       }
/*     */     }
/* 137 */     catch (Exception exception) {
/* 138 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/* 141 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 146 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 148 */     int i = ((Integer)map.get(Integer.valueOf(15))).intValue();
/* 149 */     int j = ((Integer)map.get(Integer.valueOf(16))).intValue();
/* 150 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 151 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*     */     
/* 153 */     int k = ((Integer)map.get(Integer.valueOf(7))).intValue() + i + j;
/*     */     
/* 155 */     if (ak()) {
/* 156 */       k -= 20;
/* 157 */       map.put(Integer.valueOf(0), Integer.valueOf(20));
/*     */     } 
/*     */     
/* 160 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 162 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 167 */     c c = (c)parami;
/*     */     
/* 169 */     l l = a().a();
/* 170 */     if (l.equals(l.g)) {
/* 171 */       b b1 = new b(paramb, (i)c, true);
/* 172 */       b1.setName("disputaDispensaCN_" + a().v());
/* 173 */       return (g)b1;
/*     */     } 
/* 175 */     p p = new p(paramb, c, true);
/* 176 */     p.setName("disputaCN_" + a().v());
/* 177 */     return (g)p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g b(b paramb, i parami) {
/* 184 */     c c = (c)parami;
/*     */     
/* 186 */     l l = a().a();
/* 187 */     if (l.equals(l.g)) {
/* 188 */       b b1 = new b(paramb, (i)c, false);
/* 189 */       b1.setName("disputaDispensaCN_" + a().v());
/* 190 */       return (g)b1;
/*     */     } 
/* 192 */     p p = new p(paramb, c, false);
/* 193 */     p.setName("disputaCN_" + a().v());
/* 194 */     return (g)p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 200 */     l l = a().a();
/* 201 */     if (l.equals(l.g)) {
/* 202 */       return ((b)d()).c(parame, paramDouble);
/*     */     }
/* 204 */     return ((p)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 210 */     l l = a().a();
/* 211 */     if (l.equals(l.g)) {
/* 212 */       return (g)new b(null, parami, false);
/*     */     }
/* 214 */     return (g)new p(null, (c)parami, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb, n paramn) {
/*     */     try {
/*     */       boolean bool1;
/* 228 */       p p = (p)d();
/* 229 */       boolean bool2 = false;
/*     */       do {
/* 231 */         int i = -1;
/* 232 */         bool1 = false;
/*     */         
/* 234 */         if (!n.bQ())
/* 235 */           continue;  int j = paramn.getRowCount();
/*     */ 
/*     */         
/* 238 */         for (byte b1 = 0; b1 < j; b1++) {
/* 239 */           f f = paramn.a(b1);
/* 240 */           h h = f.h();
/* 241 */           l l = a().a();
/*     */ 
/*     */ 
/*     */           
/* 245 */           if (!h.ba() && 
/* 246 */             !l.equals(l.h) && 
/* 247 */             !l.equals(l.k)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 253 */             if (i == -1) {
/* 254 */               bool1 = true;
/* 255 */               i = JOptionPane.showConfirmDialog(null, "Não foi possível capturar alguns dados dos itens encerrados. Deseja tentar buscar novamente do portal?", "Informação", 0, 1);
/*     */ 
/*     */ 
/*     */               
/* 259 */               if (i == 1) {
/* 260 */                 bool2 = false;
/* 261 */                 bool1 = false;
/*     */                 break;
/*     */               } 
/* 264 */               paramn.cH();
/* 265 */               paramn.fireTableDataChanged();
/*     */             } 
/*     */ 
/*     */             
/* 269 */             if (p == null || p.b() == null || !p.b().isRunning()) {
/* 270 */               Future<i> future = c.a(a());
/* 271 */               i i1 = future.get();
/* 272 */               p = new p(paramb, (c)i1, false);
/* 273 */               p.ab();
/*     */             } 
/*     */ 
/*     */             
/* 277 */             p.a(f, paramn, null);
/* 278 */             bool2 = true;
/*     */           } 
/*     */         } 
/* 281 */       } while (bool1);
/*     */ 
/*     */       
/* 284 */       if (bool2) {
/* 285 */         ArrayList arrayList = new ArrayList();
/* 286 */         paramn.M().stream().forEach(paramf -> paramList.add(paramf.b()));
/*     */ 
/*     */ 
/*     */         
/* 290 */         p.e(arrayList);
/*     */       } 
/* 292 */     } catch (Exception exception) {
/* 293 */       a.warn("Failed to check unloaded closed items", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 299 */     c c = (c)a();
/* 300 */     String str = c.bl();
/*     */     
/* 302 */     c c1 = super.a();
/* 303 */     c1.X(str);
/*     */     
/* 305 */     return c1;
/*     */   }
/*     */ 
/*     */   
/*     */   public long q() {
/* 310 */     return TimeUnit.MINUTES.toMillis(1L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */