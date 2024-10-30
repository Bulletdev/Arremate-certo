/*     */ package br.com.arremate.k.a;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.i.c;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.g.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends g
/*     */ {
/*     */   public f(j paramj) {
/*  26 */     super(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<e> x() {
/*  31 */     ArrayList<e> arrayList = new ArrayList();
/*     */     
/*  33 */     try(Statement null = a.a().createStatement(); 
/*  34 */         ResultSet null = statement.executeQuery(aW())) {
/*  35 */       e e = null;
/*     */ 
/*     */ 
/*     */       
/*  39 */       while (resultSet.next()) {
/*     */         
/*  41 */         a a = new a(resultSet.getInt("itecodigo"), a());
/*  42 */         a.T(resultSet.getString("itenumero"));
/*  43 */         a.ag(resultSet.getString("itedescricao"));
/*  44 */         a.k(resultSet.getDouble("itequantidade"));
/*  45 */         a.l(resultSet.getInt("iteposicao"));
/*  46 */         a.ai(resultSet.getString("itegrupo"));
/*  47 */         a.T(resultSet.getInt("itecodigogrupo"));
/*     */         
/*  49 */         a.o(resultSet.getDouble("itevalorminimo"));
/*  50 */         a.n(resultSet.getDouble("itevalorproposta"));
/*  51 */         a.a(b.a((g)a));
/*  52 */         a.R(resultSet.getInt("itetipo"));
/*     */         
/*  54 */         a.e(resultSet.getBigDecimal("itevalorminimoentremelhorlance"));
/*  55 */         a.f(resultSet.getBigDecimal("itepercentualminimoentrelance"));
/*     */ 
/*     */         
/*  58 */         boolean bool = (a.bE() == null || a.bE().isEmpty()) ? true : false;
/*     */         
/*  60 */         if (resultSet.getObject("itesituacao") != null) {
/*  61 */           a.N(resultSet.getString("itesituacao"));
/*  62 */           a.S(resultSet.getInt("itestatuslance"));
/*  63 */           a.l(resultSet.getDouble("itemelhorlance"));
/*  64 */           a.h(resultSet.getDouble("iteultimolance"));
/*     */           
/*  66 */           e e1 = new e((g)a);
/*     */ 
/*     */           
/*  69 */           if (e1.br() && bool) {
/*  70 */             h h = a.f();
/*     */             
/*  72 */             if (resultSet.getObject("itevencedorcnpj") != null) {
/*  73 */               h.D(resultSet.getString("itevencedorcnpj"));
/*  74 */               h.E(resultSet.getString("itevencedornomeempresa"));
/*  75 */               h.ap(resultSet.getString("itevencedorporte"));
/*  76 */               h.ao(resultSet.getString("itevencedormodelo"));
/*  77 */               h.al(resultSet.getString("itevencedormarca"));
/*  78 */               h.am(resultSet.getString("itevencedorfabricante"));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/*  83 */         if (bool) {
/*     */           
/*  85 */           if (e != null) {
/*  86 */             b(e, arrayList);
/*  87 */             e = null;
/*     */           } 
/*     */           
/*  90 */           e e1 = new e((g)a);
/*  91 */           arrayList.add(e1); continue;
/*     */         } 
/*  93 */         if (e == null) {
/*  94 */           e = new e(a.H(), a.bE());
/*  95 */           e.l(a.j());
/*  96 */           e.N(a.bB());
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 101 */         if (a.H() != e.v()) {
/* 102 */           if (e.G() > 0) {
/* 103 */             b(e, arrayList);
/*     */           }
/*     */           
/* 106 */           e = new e(a.H(), a.bE());
/* 107 */           e.l(a.j());
/* 108 */           e.N(a.bB());
/*     */         } 
/*     */         
/* 111 */         e.f((g)a);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 116 */       if (e != null) {
/* 117 */         b(e, arrayList);
/*     */       }
/*     */     }
/* 120 */     catch (Exception exception) {
/* 121 */       a.warn("Falha ao carregar os itens da licitação", exception);
/*     */     } 
/*     */     
/* 124 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 129 */     return a().b().a().N() + ": " + a().bo();
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(b paramb, i parami) {
/* 134 */     return (g)new c(paramb, parami, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected g a(i parami) {
/* 139 */     return (g)new c(null, parami, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean d(e parame, double paramDouble) {
/* 144 */     return ((c)d()).c(parame, paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */