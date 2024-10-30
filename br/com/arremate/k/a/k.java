/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.m.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.k.b;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class k
/*     */   extends g
/*     */ {
/*     */   public k(b paramb) {
/*  27 */     super((j)paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  32 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  34 */     try (Statement null = a.a().createStatement()) {
/*  35 */       String str = aW();
/*     */       
/*  37 */       try (ResultSet null = statement.executeQuery(str)) {
/*     */ 
/*     */         
/*  40 */         while (resultSet.next()) {
/*     */           
/*  42 */           a a = new a(Integer.parseInt(resultSet.getString("itecodigo")), (j)a());
/*  43 */           a.ag(resultSet.getString("itedescricao"));
/*  44 */           a.T(resultSet.getString("itenumero"));
/*  45 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  46 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  47 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  48 */           a.l(resultSet.getInt("iteposicao"));
/*  49 */           a.a(b.a((g)a));
/*     */           
/*  51 */           if (resultSet.getObject("itevalorminimoentremelhorlance") != null) {
/*  52 */             a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*     */           }
/*     */           
/*  55 */           if (resultSet.getObject("iteidempresa") != null) {
/*  56 */             a.ak(resultSet.getString("iteidempresa"));
/*     */           }
/*     */           
/*  59 */           if (resultSet.getObject("itesituacao") != null) {
/*  60 */             a.N(resultSet.getString("itesituacao"));
/*  61 */             a.S(resultSet.getInt("itestatuslance"));
/*  62 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  63 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */ 
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
/*     */   public Map<Integer, Integer> m() {
/*  93 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  95 */     char c = 'ú';
/*  96 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/*  97 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  98 */     int m = j + i - c;
/*     */     
/* 100 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/* 101 */     map.put(Integer.valueOf(7), Integer.valueOf(m));
/*     */     
/* 103 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 108 */     c c = new c(paramb, parami);
/* 109 */     c.setName("disputaMG_" + a().v());
/* 110 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 115 */     return ((c)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 120 */     return (g)new c(null, parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 125 */     StringBuilder stringBuilder = new StringBuilder(a().b().a().N());
/* 126 */     stringBuilder.append(": ");
/* 127 */     stringBuilder.append(a().bo());
/* 128 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 133 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */