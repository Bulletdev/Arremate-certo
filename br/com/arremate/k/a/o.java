/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.s.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.o.a;
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
/*     */ public class o
/*     */   extends g
/*     */ {
/*     */   public o(j paramj) {
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
/*  40 */         while (resultSet.next()) {
/*     */           
/*  42 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  43 */           a.T(resultSet.getString("itenumero"));
/*  44 */           a.ag(resultSet.getString("itedescricao"));
/*  45 */           a.k(resultSet.getDouble("itequantidade"));
/*  46 */           a.l(resultSet.getInt("iteposicao"));
/*  47 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  48 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  49 */           a.a(b.a((g)a));
/*     */           
/*  51 */           if (resultSet.getObject("itesituacao") != null) {
/*  52 */             a.N(resultSet.getString("itesituacao"));
/*  53 */             a.S(resultSet.getInt("itestatuslance"));
/*  54 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  55 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  57 */             e e1 = new e((g)a);
/*     */ 
/*     */             
/*  60 */             if (e1.br()) {
/*  61 */               h h = a.f();
/*     */               
/*  63 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  64 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  65 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  66 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  67 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  68 */                 h.al(resultSet.getString("itevencedormarca"));
/*  69 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  74 */           e e = new e((g)a);
/*  75 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  78 */     } catch (Exception exception) {
/*  79 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  82 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  87 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  89 */     char c = 'È';
/*  90 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/*  91 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  92 */     int k = j + i - c;
/*     */     
/*  94 */     map.put(Integer.valueOf(8), Integer.valueOf(c));
/*     */     
/*  96 */     int m = ((Integer)map.get(Integer.valueOf(15))).intValue();
/*  97 */     int n = ((Integer)map.get(Integer.valueOf(16))).intValue();
/*     */     
/*  99 */     k += m + n;
/*     */     
/* 101 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/* 103 */     map.put(Integer.valueOf(15), Integer.valueOf(0));
/* 104 */     map.put(Integer.valueOf(16), Integer.valueOf(0));
/*     */     
/* 106 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/* 111 */     c c = new c(paramb, parami, true);
/* 112 */     c.setName("disputaRJ_" + a().bo());
/* 113 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 118 */     return ((c)d()).c(parame, paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 123 */     return (g)new c(null, parami, false);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */