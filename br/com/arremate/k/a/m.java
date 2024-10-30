/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.o.a;
/*     */ import br.com.arremate.d.o.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.f;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.l.a;
/*     */ import br.com.arremate.l.l.b;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */   extends g
/*     */ {
/*     */   public m(j paramj) {
/*  30 */     super(paramj);
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
/*     */         
/*  42 */         while (resultSet.next()) {
/*     */           
/*  44 */           a a = new a(resultSet.getInt("itecodigo"), (j)a());
/*  45 */           a.T(resultSet.getString("itenumero"));
/*  46 */           a.ag(resultSet.getString("itedescricao"));
/*  47 */           a.k(resultSet.getDouble("itequantidade"));
/*  48 */           a.l(resultSet.getInt("iteposicao"));
/*  49 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  50 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  51 */           a.a(b.a((g)a));
/*     */           
/*  53 */           if (resultSet.getObject("itesituacao") != null) {
/*  54 */             a.N(resultSet.getString("itesituacao"));
/*  55 */             a.S(resultSet.getInt("itestatuslance"));
/*  56 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  57 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  59 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  62 */             if (e1.br()) {
/*  63 */               h h = a.f();
/*     */               
/*  65 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  66 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  67 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  68 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  69 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  70 */                 h.al(resultSet.getString("itevencedormarca"));
/*  71 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  76 */           e e = new e((g)a);
/*  77 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  80 */     } catch (Exception exception) {
/*  81 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  84 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  89 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  91 */     char c = 'È';
/*  92 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/*  93 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  94 */     int k = j + i - c;
/*     */     
/*  96 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/*  97 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/*  99 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 104 */     c c = new c(paramb, parami);
/* 105 */     c.setName("disputaMT_" + a().v());
/* 106 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(e parame, i parami) throws Exception {
/* 111 */     super.a(parame, parami);
/* 112 */     f f = (f)e().a();
/* 113 */     c c = (c)e();
/*     */     
/* 115 */     a a = new a(c, f);
/* 116 */     a.a(parame.a());
/* 117 */     c.a((e)a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 122 */     return (g)new c(null, parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 127 */     return c().b(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   protected c c() {
/* 132 */     return (c)super.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 137 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */