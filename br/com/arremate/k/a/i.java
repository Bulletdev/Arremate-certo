/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.k.e;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.c;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.i.a;
/*     */ import br.com.arremate.l.i.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k;
/*     */ import br.com.arremate.l.p;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.h;
/*     */ import br.com.arremate.m.d;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */   extends g
/*     */ {
/*     */   public i(j paramj) {
/*  37 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  42 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  44 */     try (Statement null = a.a().createStatement()) {
/*  45 */       String str = aW();
/*     */       
/*  47 */       try (ResultSet null = statement.executeQuery(str)) {
/*     */ 
/*     */         
/*  50 */         while (resultSet.next()) {
/*     */           
/*  52 */           a a = new a(Integer.parseInt(resultSet.getString("itecodigo")), (b)a());
/*  53 */           a.ag(resultSet.getString("itedescricao"));
/*  54 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  55 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  56 */           a.l(resultSet.getInt("iteposicao"));
/*     */           
/*  58 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*     */ 
/*     */           
/*  61 */           a.z(resultSet.getLong("itetempominimoentremelhorlance"));
/*  62 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  63 */           a.a(b.a((g)a));
/*  64 */           a.R(resultSet.getInt("itetipo"));
/*  65 */           a.ah(resultSet.getString("itedescricaocompleta"));
/*  66 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*     */           
/*  68 */           if (resultSet.getObject("itesituacao") != null) {
/*  69 */             a.N(resultSet.getString("itesituacao"));
/*  70 */             a.S(resultSet.getInt("itestatuslance"));
/*  71 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  72 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  74 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  77 */             if (e1.br()) {
/*  78 */               h h = a.f();
/*     */               
/*  80 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  81 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  82 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  83 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  84 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  85 */                 h.al(resultSet.getString("itevencedormarca"));
/*  86 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*  90 */           e e = new e((g)a);
/*  91 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  94 */     } catch (Exception exception) {
/*  95 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  98 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 103 */     StringBuilder stringBuilder = new StringBuilder(a().b().a().N());
/* 104 */     stringBuilder.append(": ");
/* 105 */     stringBuilder.append(a().v());
/* 106 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String aU() {
/* 111 */     return Integer.toString(a().v());
/*     */   }
/*     */ 
/*     */   
/*     */   public String aV() {
/* 116 */     return a().bT();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, br.com.arremate.j.i parami) {
/* 121 */     e e = new e(paramb, parami, true);
/* 122 */     e.setName("disputaLicitacoesE_" + a().v());
/* 123 */     return (g)e;
/*     */   }
/*     */ 
/*     */   
/*     */   public g b(b paramb, br.com.arremate.j.i parami) {
/* 128 */     e e = new e(paramb, parami, false);
/* 129 */     e.setName("disputaLicitacoesE_" + a().v());
/* 130 */     return (g)e;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 135 */     return ((e)d()).b(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public void y(e parame) {
/* 140 */     if (a().a().a() != p.c) {
/* 141 */       JOptionPane.showMessageDialog(null, "A disputa contra ME/EPP está disponível somente para indústrias, e sua empresa (" + 
/* 142 */           a().a().bv().toUpperCase() + ") está enquadrada no regime ME/EPP.", "Erro", 0);
/*     */     } else {
/* 144 */       parame.q(!parame.aU());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(br.com.arremate.j.i parami) {
/* 150 */     return (g)new e(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected p a(h paramh) {
/* 155 */     p p = new p(a());
/* 156 */     p.p().put(c.a, "Lote");
/* 157 */     p.p().remove(c.b);
/*     */     
/* 159 */     br.com.arremate.l.q.b.i i1 = (br.com.arremate.l.q.b.i)paramh.getModel();
/* 160 */     ArrayList arrayList = new ArrayList(i1.L());
/*     */ 
/*     */     
/* 163 */     arrayList.forEach(parame -> {
/*     */           k k = new k(parame.a());
/*     */           
/*     */           k.aC(null);
/*     */           paramp.a(k);
/*     */         });
/* 169 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/* 174 */     Map<Integer, Integer> map = super.m();
/*     */     
/* 176 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/* 177 */     map.put(Integer.valueOf(7), Integer.valueOf(j - 60));
/*     */     
/* 179 */     int k = ((Integer)map.get(Integer.valueOf(8))).intValue();
/* 180 */     map.put(Integer.valueOf(8), Integer.valueOf(k + 60));
/*     */     
/* 182 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(h paramh) {
/* 187 */     StringBuilder stringBuilder = new StringBuilder("Arremate_");
/* 188 */     stringBuilder.append(a().b().a().N());
/* 189 */     stringBuilder.append("_");
/* 190 */     stringBuilder.append(a().v());
/*     */     
/* 192 */     p p = a(paramh);
/* 193 */     d d = new d(p);
/* 194 */     d.aH(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public long q() {
/* 199 */     return TimeUnit.SECONDS.toMillis(30L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */