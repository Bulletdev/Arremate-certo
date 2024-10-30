/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.r.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.n.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class n
/*     */   extends g {
/*     */   public n(j paramj) {
/*  22 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  27 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  29 */     try (Statement null = a.a().createStatement()) {
/*  30 */       String str = aW();
/*  31 */       try (ResultSet null = statement.executeQuery(str)) {
/*  32 */         while (resultSet.next()) {
/*  33 */           a a = new a(resultSet.getInt("itecodigo"), a());
/*  34 */           a.T(resultSet.getString("itenumero"));
/*  35 */           a.ag(resultSet.getString("itedescricao"));
/*  36 */           a.k(resultSet.getDouble("itequantidade"));
/*  37 */           a.l(resultSet.getInt("iteposicao"));
/*  38 */           a.ai(resultSet.getString("itegrupo"));
/*  39 */           a.T(resultSet.getInt("itecodigogrupo"));
/*  40 */           a.g(resultSet.getBigDecimal("itevalorlancefechado"));
/*  41 */           a.o(resultSet.getDouble("itevalorminimo"));
/*  42 */           a.n(resultSet.getDouble("itevalorproposta"));
/*  43 */           a.a(b.a((g)a));
/*  44 */           a.R(resultSet.getInt("itetipo"));
/*  45 */           a.p(resultSet.getDouble("iteequalizacao"));
/*  46 */           a.ah(resultSet.getString("itedescricaocompleta"));
/*  47 */           a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  48 */           a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*  49 */           a.ak(resultSet.getString("iteidempresa"));
/*     */           
/*  51 */           if (resultSet.getObject("itesituacao") != null) {
/*  52 */             a.N(resultSet.getString("itesituacao"));
/*  53 */             a.S(resultSet.getInt("itestatuslance"));
/*  54 */             a.l(resultSet.getDouble("itemelhorlance"));
/*  55 */             a.h(resultSet.getDouble("iteultimolance"));
/*     */             
/*  57 */             if (a.aw()) {
/*  58 */               h h = a.f();
/*     */               
/*  60 */               if (resultSet.getObject("itevencedorcnpj") != null) {
/*  61 */                 h.D(resultSet.getString("itevencedorcnpj"));
/*  62 */                 h.E(resultSet.getString("itevencedornomeempresa"));
/*  63 */                 h.ap(resultSet.getString("itevencedorporte"));
/*  64 */                 h.ao(resultSet.getString("itevencedormodelo"));
/*  65 */                 h.al(resultSet.getString("itevencedormarca"));
/*  66 */                 h.am(resultSet.getString("itevencedorfabricante"));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*  71 */           e e = new e((g)a);
/*  72 */           arrayList.add(e);
/*     */         } 
/*     */       } 
/*  75 */     } catch (Exception exception) {
/*  76 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/*  79 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/*  84 */     return a().b().a().N() + ": " + a().bo();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a(b paramb, i parami) {
/*  89 */     c c = new c(paramb, parami, true);
/*  90 */     c.setName("disputaPublinexo_" + a().bo());
/*  91 */     return (g)c;
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/*  96 */     return (g)new c(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 101 */     return ((c)d()).b(parame, paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */