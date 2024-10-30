/*     */ package br.com.arremate.k.a.b;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.a;
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
/*     */ public abstract class c
/*     */   extends g
/*     */ {
/*     */   public c(j paramj) {
/*  24 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  29 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  31 */     try (Statement null = a.a().createStatement()) {
/*  32 */       String str = aW();
/*  33 */       ResultSet resultSet = statement.executeQuery(str);
/*     */       
/*  35 */       while (resultSet.next()) {
/*     */         
/*  37 */         a a = new a(Integer.parseInt(resultSet.getString("itecodigo")), a());
/*  38 */         a.ag(resultSet.getString("itedescricao"));
/*  39 */         a.T(resultSet.getString("itenumero"));
/*  40 */         a.o(resultSet.getDouble("itevalorminimo"));
/*  41 */         a.n(resultSet.getDouble("itevalorproposta"));
/*  42 */         a.l(resultSet.getInt("iteposicao"));
/*  43 */         a.a(b.a((g)a));
/*  44 */         a.m(resultSet.getDouble("itevalorproposta"));
/*  45 */         a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*     */         
/*  47 */         if (resultSet.getObject("itesituacao") != null) {
/*  48 */           a.N(resultSet.getString("itesituacao"));
/*  49 */           a.S(resultSet.getInt("itestatuslance"));
/*  50 */           a.l(resultSet.getDouble("itemelhorlance"));
/*  51 */           a.h(resultSet.getDouble("iteultimolance"));
/*     */ 
/*     */           
/*  54 */           if (a.aw()) {
/*  55 */             h h = a.f();
/*     */             
/*  57 */             if (resultSet.getObject("itevencedornomeempresa") != null) {
/*  58 */               h.D(resultSet.getString("itevencedorcnpj"));
/*  59 */               h.E(resultSet.getString("itevencedornomeempresa"));
/*  60 */               h.ap(resultSet.getString("itevencedorporte"));
/*  61 */               h.ao(resultSet.getString("itevencedormodelo"));
/*  62 */               h.al(resultSet.getString("itevencedormarca"));
/*  63 */               h.am(resultSet.getString("itevencedorfabricante"));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  68 */         e e = new e((g)a);
/*  69 */         arrayList.add(e);
/*     */       } 
/*  71 */     } catch (Exception exception) {
/*  72 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  75 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, Integer> m() {
/*  80 */     Map<Integer, Integer> map = super.m();
/*     */     
/*  82 */     char c1 = 'È';
/*  83 */     int i = ((Integer)map.get(Integer.valueOf(8))).intValue();
/*  84 */     int j = ((Integer)map.get(Integer.valueOf(7))).intValue();
/*  85 */     int k = j + i - c1;
/*     */     
/*  87 */     map.put(Integer.valueOf(8), Integer.valueOf(c1));
/*  88 */     map.put(Integer.valueOf(7), Integer.valueOf(k));
/*     */     
/*  90 */     return map;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  95 */     StringBuilder stringBuilder = new StringBuilder(a().b().a().N());
/*  96 */     stringBuilder.append(": ");
/*  97 */     stringBuilder.append(a().bo());
/*  98 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String aV() {
/* 103 */     String str = a().bT();
/* 104 */     str = str + "(";
/* 105 */     str = str + Integer.toString(a().v());
/* 106 */     str = str + ")";
/* 107 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\b\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */