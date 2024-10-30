/*     */ package br.com.arremate.k.a.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.g.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.e.a;
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
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   public c(j paramj) {
/*  28 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  33 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  35 */     try (Statement null = a.a().createStatement()) {
/*  36 */       String str = aW();
/*     */       
/*  38 */       try (ResultSet null = statement.executeQuery(str)) {
/*     */ 
/*     */         
/*  41 */         while (resultSet.next()) {
/*     */           
/*  43 */           a a = new a(resultSet.getInt("itecodigo"), (br.com.arremate.l.e.c)a());
/*  44 */           a.T(resultSet.getString("itenumero"));
/*  45 */           a.ag(resultSet.getString("itedescricao"));
/*  46 */           a.k(resultSet.getDouble("itequantidade"));
/*  47 */           a.l(resultSet.getInt("iteposicao"));
/*  48 */           a.ai("");
/*  49 */           a.T(0);
/*  50 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  51 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  52 */           a.a(b.a((g)a));
/*     */           
/*  54 */           if (resultSet.getObject("itesituacao") != null) {
/*  55 */             a.N(resultSet.getString("itesituacao"));
/*  56 */             a.S(resultSet.getInt("itestatuslance"));
/*  57 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  58 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  60 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  63 */             if (e1.br()) {
/*  64 */               h h = a.f();
/*     */               
/*  66 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  67 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  68 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  69 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  70 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  71 */                 h.al(resultSet.getString("itevencedormarca"));
/*  72 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  77 */           e e = new e((g)a);
/*  78 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  81 */     } catch (Exception exception) {
/*  82 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  85 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  90 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  92 */     int i = ((Integer)map.get(Integer.valueOf(5))).intValue();
/*  93 */     int j = ((Integer)map.get(Integer.valueOf(15))).intValue();
/*  94 */     int k = ((Integer)map.get(Integer.valueOf(16))).intValue();
/*     */     
/*  96 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/*  97 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*  98 */     map.put(Integer.valueOf(5), Integer.valueOf(0));
/*     */     
/* 100 */     int m = ((Integer)map.get(Integer.valueOf(14))).intValue();
/* 101 */     map.put(Integer.valueOf(14), Integer.valueOf(m + j));
/*     */     
/* 103 */     int n = ((Integer)map.get(Integer.valueOf(7))).intValue();
/* 104 */     map.put(Integer.valueOf(7), Integer.valueOf(n + i + k));
/*     */     
/* 106 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 111 */     b b1 = new b(paramb, parami, true);
/* 112 */     b1.setName("disputaCDisp_" + a().v());
/* 113 */     return (g)b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public g b(b paramb, i parami) {
/* 118 */     b b1 = new b(paramb, parami, false);
/* 119 */     b1.setName("disputaCDisp_" + a().v());
/* 120 */     return (g)b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 125 */     return ((b)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> a(e parame, i parami) {
/* 130 */     List<h> list = null;
/*     */     
/* 132 */     G(null);
/*     */     try {
/*     */       b b;
/* 135 */       if (d() != null && d().isRunning()) {
/* 136 */         b = (b)d();
/*     */       } else {
/* 138 */         a(parame, parami);
/* 139 */         b = (b)e();
/*     */       } 
/*     */       
/* 142 */       t t = b.a((br.com.arremate.l.e.c)parame.a());
/* 143 */       if (t != t.d) {
/* 144 */         G("Só é possível capturar os melhores lances do item após o encerramento da disputa");
/* 145 */         return new ArrayList<>();
/*     */       } 
/*     */       
/* 148 */       list = b.b(parame);
/* 149 */     } catch (Exception exception) {
/* 150 */       a.error("Failed to get best bids", exception);
/*     */     } 
/*     */     
/* 153 */     e(null);
/* 154 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 159 */     return (g)new b(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.l.c a() {
/* 164 */     br.com.arremate.l.e.c c1 = (br.com.arremate.l.e.c)a();
/* 165 */     String str = c1.bl();
/*     */     
/* 167 */     br.com.arremate.l.c c2 = super.a();
/* 168 */     c2.X(str);
/*     */     
/* 170 */     return c2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */