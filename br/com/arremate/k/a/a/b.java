/*     */ package br.com.arremate.k.a.a;
/*     */ 
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.c;
/*     */ import br.com.arremate.l.e.a;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.e.d;
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
/*     */ 
/*     */ public class b
/*     */   extends g
/*     */ {
/*     */   public b(j paramj) {
/*  33 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  38 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  40 */     try (Statement null = a.a().createStatement()) {
/*  41 */       String str = aW();
/*     */       
/*  43 */       try (ResultSet null = statement.executeQuery(str)) {
/*     */ 
/*     */         
/*  46 */         while (resultSet.next()) {
/*     */           
/*  48 */           a a = new a(resultSet.getInt("itecodigo"), (c)a());
/*  49 */           a.T(resultSet.getString("itenumero"));
/*  50 */           a.ag(resultSet.getString("itedescricao"));
/*  51 */           a.k(resultSet.getDouble("itequantidade"));
/*  52 */           a.l(resultSet.getInt("iteposicao"));
/*  53 */           a.ai("");
/*  54 */           a.T(0);
/*  55 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  56 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  57 */           a.a(br.com.arremate.l.b.a((g)a));
/*     */           
/*  59 */           if (resultSet.getObject("itesituacao") != null) {
/*  60 */             a.N(resultSet.getString("itesituacao"));
/*  61 */             a.S(resultSet.getInt("itestatuslance"));
/*  62 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  63 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  65 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  68 */             if (e1.br()) {
/*  69 */               h h = a.f();
/*     */               
/*  71 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  72 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  73 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  74 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  75 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  76 */                 h.al(resultSet.getString("itevencedormarca"));
/*  77 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  82 */           e e = new e((g)a);
/*  83 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  86 */     } catch (Exception exception) {
/*  87 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  90 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  95 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  97 */     int i = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  98 */     int j = ((Integer)map.get(Integer.valueOf(5))).intValue();
/*  99 */     int k = ((Integer)map.get(Integer.valueOf(15))).intValue();
/* 100 */     int m = ((Integer)map.get(Integer.valueOf(16))).intValue();
/*     */     
/* 102 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 103 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/* 104 */     map.put(Integer.valueOf(5), Integer.valueOf(0));
/* 105 */     map.put(Integer.valueOf(7), Integer.valueOf(i + j + k + m));
/*     */     
/* 107 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(br.com.arremate.d.b paramb, i parami) {
/* 112 */     br.com.arremate.d.f.b b1 = new br.com.arremate.d.f.b(paramb, parami, true);
/* 113 */     b1.setName("disputaCNCot_" + a().v());
/* 114 */     return (g)b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public g b(br.com.arremate.d.b paramb, i parami) {
/* 119 */     br.com.arremate.d.f.b b1 = new br.com.arremate.d.f.b(paramb, parami, false);
/* 120 */     b1.setName("disputaCNCot_" + a().v());
/* 121 */     return (g)b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 126 */     return ((br.com.arremate.d.f.b)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> a(e parame, i parami) {
/* 131 */     List<h> list = null;
/*     */     
/* 133 */     G(null);
/*     */     try {
/*     */       br.com.arremate.d.f.b b1;
/* 136 */       if (d() != null && d().isRunning()) {
/* 137 */         b1 = (br.com.arremate.d.f.b)d();
/*     */       } else {
/* 139 */         a(parame, parami);
/* 140 */         b1 = (br.com.arremate.d.f.b)e();
/*     */       } 
/*     */       
/* 143 */       t t = b1.a(parame.a().v());
/* 144 */       if (t != t.d) {
/* 145 */         G("Só é possível capturar os melhores lances do item após o encerramento da disputa");
/* 146 */         return new ArrayList<>();
/*     */       } 
/*     */       
/* 149 */       list = b1.b(parame);
/* 150 */     } catch (Exception exception) {
/* 151 */       a.error("Failed to get best bids", exception);
/*     */     } 
/*     */     
/* 154 */     e(null);
/* 155 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 160 */     return (g)new br.com.arremate.d.f.b(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 165 */     d d = (d)a();
/* 166 */     String str = d.bl();
/*     */     
/* 168 */     c c = super.a();
/* 169 */     c.X(str);
/*     */     
/* 171 */     return c;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */