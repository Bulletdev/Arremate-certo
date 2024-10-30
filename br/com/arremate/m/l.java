/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.n;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */ {
/*  28 */   private static final Logger a = LoggerFactory.getLogger(l.class);
/*     */   
/*  30 */   private static final l a = new l();
/*     */   
/*     */   private final LinkedHashMap<o, n> b;
/*     */   
/*     */   public static l a() {
/*  35 */     return a;
/*     */   }
/*     */   
/*     */   private l() {
/*  39 */     this.b = new LinkedHashMap<>();
/*     */   }
/*     */   
/*     */   public n a(int paramInt) {
/*  43 */     o o = o.a(paramInt);
/*  44 */     return a(o);
/*     */   }
/*     */   
/*     */   public n a(o paramo) {
/*  48 */     return this.b.get(paramo);
/*     */   }
/*     */   
/*     */   public int Z() {
/*  52 */     return this.b.size();
/*     */   }
/*     */   
/*     */   public Collection<n> values() {
/*  56 */     return this.b.values();
/*     */   }
/*     */ 
/*     */   
/*     */   void cO() {
/*  61 */     this.b.putAll(a(a.b()));
/*     */   }
/*     */   
/*     */   public void c(f paramf) {
/*  65 */     LinkedHashMap<o, n> linkedHashMap = a(a.a());
/*  66 */     List<i> list = (List)IntStream.range(0, paramf.length()).mapToObj(paramInt -> paramf.b(paramInt)).collect(Collectors.toList());
/*     */ 
/*     */     
/*  69 */     i i = new i();
/*  70 */     i.a("codigo", 22222);
/*  71 */     i.c("nome", "Novo Licitações-e");
/*  72 */     i.a("status", 1);
/*  73 */     list.add(i);
/*     */     
/*  75 */     TreeMap<Object, Object> treeMap = new TreeMap<>();
/*     */     
/*  77 */     for (i i1 : list) {
/*  78 */       if (!i1.isNull("codigo") && !i1.isNull("nome") && !i1.isNull("status")) {
/*  79 */         int j = i1.getInt("codigo");
/*  80 */         o o = o.a(j);
/*  81 */         if (o != null) {
/*  82 */           int k = i1.getInt("status");
/*  83 */           String str = i1.getString("nome");
/*  84 */           if (o == o.e)
/*     */           {
/*     */             
/*  87 */             str = "BEC - Bolsa Eletrônica de Compras/SP";
/*     */           }
/*     */           
/*  90 */           n n = linkedHashMap.get(o);
/*  91 */           if (n != null) {
/*  92 */             if (!n.K().equals(str) || n.getStatus() != k) {
/*  93 */               n = new n(j, str);
/*  94 */               n.setStatus(k);
/*  95 */               b(n);
/*     */             } 
/*     */           } else {
/*  98 */             n = new n(j, str);
/*  99 */             n.setStatus(k);
/* 100 */             a(n);
/*     */           } 
/*     */           
/* 103 */           treeMap.put(o, n);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     this.b.putAll(treeMap);
/*     */   }
/*     */   
/*     */   private LinkedHashMap<o, n> a(Connection paramConnection) {
/* 112 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */     
/*     */     try {
/* 115 */       Statement statement = paramConnection.createStatement();
/* 116 */       StringBuilder stringBuilder = new StringBuilder();
/* 117 */       stringBuilder.append("SELECT * FROM TBPORTAL WHERE PORSTATUS = 1 ");
/* 118 */       stringBuilder.append("UNION ALL ");
/* 119 */       stringBuilder.append("SELECT * FROM TBPORTAL WHERE PORSTATUS = 2 ");
/* 120 */       stringBuilder.append("UNION ALL ");
/* 121 */       stringBuilder.append("SELECT * FROM TBPORTAL WHERE PORSTATUS = 0");
/* 122 */       try (ResultSet null = statement.executeQuery(stringBuilder.toString())) {
/* 123 */         while (resultSet.next()) {
/* 124 */           int i = resultSet.getInt("porcodigo");
/*     */           
/* 126 */           if (o.a(i) != null) {
/* 127 */             n n = new n(i, resultSet.getString("pordescricao"));
/* 128 */             n.setStatus(resultSet.getInt("porstatus"));
/* 129 */             linkedHashMap.put(n.a(), n);
/*     */           } 
/*     */         } 
/*     */       } 
/* 133 */     } catch (SQLException sQLException) {
/* 134 */       a.warn("Failed to load portals from database", sQLException);
/*     */     } 
/*     */     
/* 137 */     return (LinkedHashMap)linkedHashMap;
/*     */   }
/*     */   
/*     */   private void a(n paramn) {
/*     */     try {
/* 142 */       String str = "INSERT INTO TBPORTAL(PORCODIGO, PORDESCRICAO, PORSTATUS) VALUES (?,?,?)";
/* 143 */       try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 144 */         preparedStatement.setInt(1, paramn.v());
/* 145 */         preparedStatement.setString(2, paramn.K());
/* 146 */         preparedStatement.setInt(3, paramn.getStatus());
/* 147 */         preparedStatement.execute();
/*     */       } 
/*     */       
/* 150 */       str = "INSERT INTO TBCONFIGURACAO (CONCODIGO, CONENVIARLANCEVLRMINIMO, CONCOLUNASEQUENCIA, CONCOLUNADESCRICAO, CONCOLUNAVALORMINIMO, CONCOLUNAVARIACAOINI, CONCOLUNAVARIACAOFIM, CONCOLUNATIPOREDUCAO, CONCOLUNAVALORLANCEFECHADO, CONTIPOREDUCAO, CONVALORREDUCAOINI, CONVALORREDUCAOFIM, CONINICIOENVIOLANCES, CONPERCENTUALDISPUTAMEEPP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*     */ 
/*     */       
/* 153 */       try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 154 */         byte b1 = 1;
/* 155 */         byte b2 = 0;
/*     */         
/* 157 */         preparedStatement.setInt(b1++, paramn.v());
/* 158 */         preparedStatement.setBoolean(b1++, true);
/* 159 */         preparedStatement.setInt(b1++, b2++);
/* 160 */         preparedStatement.setInt(b1++, b2++);
/* 161 */         preparedStatement.setInt(b1++, b2++);
/* 162 */         preparedStatement.setInt(b1++, b2++);
/* 163 */         preparedStatement.setInt(b1++, b2++);
/* 164 */         preparedStatement.setInt(b1++, b2++);
/* 165 */         preparedStatement.setInt(b1++, b2++);
/* 166 */         preparedStatement.setInt(b1++, 0);
/* 167 */         preparedStatement.setDouble(b1++, 0.01D);
/* 168 */         preparedStatement.setDouble(b1++, 0.01D);
/* 169 */         preparedStatement.setInt(b1++, a(paramn.a()));
/* 170 */         preparedStatement.setFloat(b1++, 5.01F);
/* 171 */         preparedStatement.execute();
/*     */       } 
/* 173 */     } catch (SQLException sQLException) {
/* 174 */       a.warn("Failed to add new portal", sQLException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int a(o paramo) {
/* 179 */     switch (null.g[paramo.ordinal()]) {
/*     */       
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/* 186 */         return 2;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(n paramn) {
/* 201 */     String str = "UPDATE TBPORTAL SET PORDESCRICAO = ?, PORSTATUS = ? WHERE PORCODIGO = ?";
/* 202 */     try (PreparedStatement null = a.a().prepareStatement(str)) {
/* 203 */       preparedStatement.setString(1, paramn.K());
/* 204 */       preparedStatement.setInt(2, paramn.getStatus());
/* 205 */       preparedStatement.setInt(3, paramn.v());
/* 206 */       preparedStatement.execute();
/* 207 */     } catch (SQLException sQLException) {
/* 208 */       a.warn("Failed to update portal in database", sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */