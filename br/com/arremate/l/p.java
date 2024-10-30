/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.c;
/*     */ import br.com.arremate.f.m;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class p
/*     */ {
/*  23 */   private static final Logger a = LoggerFactory.getLogger(p.class);
/*     */   
/*     */   private static final int aZ = 0;
/*     */   
/*     */   private static final int ba = 1;
/*     */   
/*     */   private static final int bb = 2;
/*     */   private static final int bc = 3;
/*     */   private static final int bd = 4;
/*     */   private static final int be = 5;
/*     */   private static final int bf = 6;
/*     */   private static final int bg = 7;
/*     */   private static final int bh = 8;
/*     */   private static final int bi = 9;
/*     */   private static final int bj = 10;
/*     */   private static final int bk = 11;
/*     */   private static final int bl = 12;
/*     */   private static final int bm = 13;
/*     */   private static final int bn = 14;
/*     */   private static final int bo = 15;
/*     */   private static final int bp = 16;
/*     */   private static final int bq = 17;
/*     */   private static final int br = 18;
/*     */   private static final int bs = 19;
/*     */   private static final int bt = 20;
/*     */   private static final int bu = 21;
/*     */   private static final int bv = 22;
/*     */   private static final int bw = 23;
/*     */   private static final int bx = 24;
/*     */   private static final int by = 25;
/*     */   private final j a;
/*     */   private final List<k> z;
/*     */   private final Map<c, Integer> B;
/*     */   private Map<c, String> C;
/*     */   private int bz;
/*     */   
/*     */   public p(j paramj) {
/*  60 */     this.a = paramj;
/*  61 */     this.z = new ArrayList<>();
/*  62 */     this.B = new HashMap<>();
/*  63 */     this.C = new LinkedHashMap<>();
/*  64 */     this.bz = 0;
/*     */     
/*  66 */     co();
/*     */     
/*  68 */     for (c c : c.values()) {
/*  69 */       if (c != c.g || paramj
/*  70 */         .a() == m.c)
/*     */       {
/*     */ 
/*     */         
/*  74 */         this.C.put(c, c.J()); } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(k paramk) {
/*  79 */     this.z.add(paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int P() {
/*  88 */     return b(this.B.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int b(int paramInt) {
/*  98 */     this.bz++;
/*     */     
/* 100 */     if (this.bz > this.B.size()) {
/* 101 */       this.bz = 0;
/*     */     }
/*     */     
/* 104 */     if (!this.C.containsKey(c.a(this.bz)) && 
/* 105 */       paramInt != 0) {
/* 106 */       return b(--paramInt);
/*     */     }
/*     */ 
/*     */     
/* 110 */     return ((Integer)this.B.get(c.a(this.bz))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void co() {
/* 118 */     try (Statement null = a.a().createStatement()) {
/* 119 */       String str = "SELECT tbconfiguracao.concolunasequencia, tbconfiguracao.concolunadescricao, tbconfiguracao.concolunavalorminimo, tbconfiguracao.concolunavariacaoini, tbconfiguracao.concolunavariacaofim, tbconfiguracao.concolunatiporeducao, tbconfiguracao.concolunavalorlancefechado FROM tbconfiguracao WHERE concodigo = 1";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 130 */       ResultSet resultSet = statement.executeQuery(str);
/*     */       
/* 132 */       if (resultSet.next()) {
/* 133 */         this.B.put(c.a, Integer.valueOf(resultSet.getInt("concolunasequencia")));
/* 134 */         this.B.put(c.b, Integer.valueOf(resultSet.getInt("concolunadescricao")));
/* 135 */         this.B.put(c.c, Integer.valueOf(resultSet.getInt("concolunavalorminimo")));
/* 136 */         this.B.put(c.d, Integer.valueOf(resultSet.getInt("concolunavariacaoini")));
/* 137 */         this.B.put(c.e, Integer.valueOf(resultSet.getInt("concolunavariacaofim")));
/* 138 */         this.B.put(c.f, Integer.valueOf(resultSet.getInt("concolunatiporeducao")));
/* 139 */         this.B.put(c.g, Integer.valueOf(resultSet.getInt("concolunavalorlancefechado")));
/*     */       } 
/* 141 */     } catch (Exception exception) {
/* 142 */       a.warn("Failed to load excel columns", exception);
/*     */     } finally {
/* 144 */       cp();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cp() {
/* 154 */     if (((Integer)this.B.get(c.a)).intValue() == 0 && ((Integer)this.B
/* 155 */       .get(c.b)).intValue() == 0 && ((Integer)this.B
/* 156 */       .get(c.c)).intValue() == 0 && ((Integer)this.B
/* 157 */       .get(c.d)).intValue() == 0 && ((Integer)this.B
/* 158 */       .get(c.e)).intValue() == 0 && ((Integer)this.B
/* 159 */       .get(c.g)).intValue() == 0 && ((Integer)this.B
/* 160 */       .get(c.f)).intValue() == 0) {
/* 161 */       this.B.put(c.a, Integer.valueOf(0));
/* 162 */       this.B.put(c.b, Integer.valueOf(1));
/* 163 */       this.B.put(c.c, Integer.valueOf(2));
/* 164 */       this.B.put(c.d, Integer.valueOf(3));
/* 165 */       this.B.put(c.e, Integer.valueOf(4));
/* 166 */       this.B.put(c.f, Integer.valueOf(5));
/* 167 */       this.B.put(c.g, Integer.valueOf(6));
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<k> D() {
/* 172 */     return this.z;
/*     */   }
/*     */   
/*     */   public j a() {
/* 176 */     return this.a;
/*     */   }
/*     */   
/*     */   public int Q() {
/* 180 */     return ((Integer)this.B.get(c.a(this.bz))).intValue();
/*     */   }
/*     */   
/*     */   public Map<c, Integer> o() {
/* 184 */     return this.B;
/*     */   }
/*     */   
/*     */   public Map<c, String> p() {
/* 188 */     return this.C;
/*     */   }
/*     */   
/*     */   public void b(Map<c, String> paramMap) {
/* 192 */     this.C = paramMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */