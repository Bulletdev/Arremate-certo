/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.n.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.k.c;
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
/*     */ public class l
/*     */   extends g
/*     */ {
/*     */   public l(c paramc) {
/*  28 */     super((j)paramc);
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
/*  43 */           a a = new a(Integer.parseInt(resultSet.getString("itecodigo")), (j)a());
/*  44 */           a.ag(resultSet.getString("itedescricao"));
/*  45 */           a.T(resultSet.getString("itenumero"));
/*  46 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  47 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  48 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  49 */           a.l(resultSet.getInt("iteposicao"));
/*  50 */           a.a(b.a((g)a));
/*     */           
/*  52 */           if (resultSet.getObject("itevalorminimoentremelhorlance") != null) {
/*  53 */             a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*     */           }
/*     */           
/*  56 */           if (resultSet.getObject("iteidempresa") != null) {
/*  57 */             a.ak(resultSet.getString("iteidempresa"));
/*     */           }
/*     */           
/*  60 */           if (resultSet.getObject("itesituacao") != null) {
/*  61 */             a.N(resultSet.getString("itesituacao"));
/*  62 */             a.S(resultSet.getInt("itestatuslance"));
/*  63 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  64 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */ 
/*     */             
/*  67 */             if (a.aw()) {
/*  68 */               h h = a.f();
/*     */               
/*  70 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  71 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  72 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  73 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  74 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  75 */                 h.al(resultSet.getString("itevencedormarca"));
/*  76 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  81 */           e e = new e((g)a);
/*  82 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  85 */     } catch (Exception exception) {
/*  86 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  89 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  94 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  96 */     char c = 'ú';
/*  97 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/*  98 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  99 */     int k = j + i - c;
/*     */     
/* 101 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/* 102 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 104 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 109 */     c c = new c(paramb, parami, true);
/* 110 */     c.setName("disputaMG_" + a().v());
/* 111 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 116 */     return ((c)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 121 */     return (g)new c(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 126 */     StringBuilder stringBuilder = new StringBuilder(a().b().a().N());
/* 127 */     stringBuilder.append(": ");
/* 128 */     stringBuilder.append(a().bo());
/* 129 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 134 */     return (c)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */