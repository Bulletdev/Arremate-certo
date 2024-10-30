/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.n;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*  19 */   private static List<d> E = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(d paramd) {
/*  25 */     return a(paramd.b(), paramd.x());
/*     */   }
/*     */   
/*     */   public static d a(n paramn, long paramLong) {
/*  29 */     d d = null;
/*     */     
/*  31 */     for (d d1 : N()) {
/*  32 */       if (paramLong == d1.x() && paramn.v() == d1.b().v()) {
/*  33 */         d = d1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  38 */     if (d == null && o.k == paramn.a()) {
/*  39 */       d d1 = a(l.a().a(o.a), paramLong);
/*     */       
/*  41 */       if (d1 != null) {
/*  42 */         d d2 = a(d1, l.a().a(o.k));
/*     */         
/*  44 */         if (d2.ao()) {
/*  45 */           E.add(d2);
/*  46 */           d = d2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  51 */     if (d == null && o.c == paramn.a()) {
/*  52 */       d d1 = a(l.a().a(o.b), paramLong);
/*     */       
/*  54 */       if (d1 != null) {
/*  55 */         d d2 = a(d1, l.a().a(o.c));
/*     */         
/*  57 */         if (d2.ao()) {
/*  58 */           E.add(d2);
/*  59 */           d = d2;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  65 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void cK() {
/*     */     try {
/*  76 */       E = new ArrayList<>();
/*     */       
/*  78 */       Statement statement = a.a().createStatement();
/*  79 */       String str = "SELECT * FROM tbempresa";
/*  80 */       ResultSet resultSet = statement.executeQuery(str);
/*     */       
/*  82 */       while (resultSet.next()) {
/*  83 */         n n = l.a().a(resultSet.getInt("porcodigo"));
/*     */         
/*  85 */         if (n != null) {
/*  86 */           String str1 = y.S(resultSet.getString("emplogin"));
/*     */           
/*  88 */           if (n.a() == o.b) {
/*  89 */             str1 = str1.toUpperCase();
/*     */           }
/*  91 */           d d = new d(n, resultSet.getLong("empcnpj"));
/*  92 */           d.aa(resultSet.getString("empnome"));
/*  93 */           d.setUser(str1);
/*  94 */           d.setPassword(y.S(resultSet.getString("empsenha")));
/*  95 */           d.a(p.a(resultSet.getInt("empporte")));
/*  96 */           d.t(resultSet.getBoolean("empativo"));
/*  97 */           d.ab(resultSet.getString("emppfx"));
/*  98 */           d.ad(resultSet.getString("emppfxcodigo"));
/*  99 */           d.u(resultSet.getBoolean("ssc"));
/* 100 */           d.w(resultSet.getLong("empcpf"));
/* 101 */           d.ae(resultSet.getString("empprofile"));
/* 102 */           String str2 = resultSet.getString("emppfxsenha");
/*     */           
/* 104 */           if (str2 != null) {
/* 105 */             str2 = y.S(str2);
/*     */           }
/* 107 */           d.ac(str2);
/*     */           
/* 109 */           E.add(d);
/*     */         } 
/*     */       } 
/* 112 */       cL();
/* 113 */     } catch (Exception exception) {
/* 114 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void cL() {
/* 122 */     E.sort((paramd1, paramd2) -> (paramd1.b().v() < paramd2.b().v()) ? -1 : ((paramd1.b().v() > paramd2.b().v()) ? 1 : ((paramd1.x() < paramd2.x()) ? -1 : 1)));
/*     */   }
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
/*     */   
/*     */   public static boolean a(d paramd) {
/* 146 */     boolean bool = false;
/*     */     
/* 148 */     if (b(paramd)) {
/* 149 */       bool = true;
/*     */       
/* 151 */       if (paramd.b().a() == o.a || paramd.b().a() == o.k) {
/* 152 */         d d1 = a(paramd, 
/*     */             
/* 154 */             (paramd.b().a() == o.a) ? 
/* 155 */             l.a().a(o.k) : 
/* 156 */             l.a().a(o.a));
/*     */ 
/*     */         
/* 159 */         b(d1);
/*     */       } 
/*     */       
/* 162 */       if (paramd.b().a() == o.b || paramd.b().a() == o.c) {
/* 163 */         d d1 = a(paramd, 
/*     */             
/* 165 */             (paramd.b().a() == o.b) ? 
/* 166 */             l.a().a(o.c) : 
/* 167 */             l.a().a(o.b));
/*     */ 
/*     */         
/* 170 */         b(d1);
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     return bool;
/*     */   }
/*     */   
/*     */   private static boolean b(d paramd) {
/* 178 */     boolean bool = false;
/*     */ 
/*     */     
/* 181 */     if (a(paramd) == null && 
/* 182 */       paramd.ao()) {
/* 183 */       E.add(paramd);
/* 184 */       bool = true;
/*     */     } 
/*     */ 
/*     */     
/* 188 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean c(d paramd) {
/* 200 */     boolean bool = false;
/*     */ 
/*     */     
/* 203 */     if (d(paramd)) {
/* 204 */       bool = true;
/*     */       
/* 206 */       if (paramd.b().a() == o.a || paramd.b().a() == o.k) {
/* 207 */         d d1 = a(paramd, 
/*     */             
/* 209 */             (paramd.b().a() == o.a) ? 
/* 210 */             l.a().a(o.k) : 
/* 211 */             l.a().a(o.a));
/*     */         
/* 213 */         d(d1);
/*     */       } 
/*     */     } 
/*     */     
/* 217 */     return bool;
/*     */   }
/*     */   
/*     */   private static boolean d(d paramd) {
/* 221 */     boolean bool = false;
/* 222 */     d d1 = a(paramd);
/*     */ 
/*     */     
/* 225 */     if (d1 != null && 
/* 226 */       paramd.aN()) {
/* 227 */       a(paramd, d1);
/* 228 */       bool = true;
/*     */     } 
/*     */ 
/*     */     
/* 232 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean e(d paramd) {
/* 244 */     boolean bool = false;
/*     */ 
/*     */     
/* 247 */     if (f(paramd)) {
/* 248 */       bool = true;
/*     */       
/* 250 */       if (paramd.b().a() == o.a || paramd.b().a() == o.k) {
/* 251 */         d d1 = a(paramd, 
/*     */             
/* 253 */             (paramd.b().a() == o.a) ? 
/* 254 */             l.a().a(o.k) : 
/* 255 */             l.a().a(o.a));
/*     */         
/* 257 */         f(d1);
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     return bool;
/*     */   }
/*     */   
/*     */   private static boolean f(d paramd) {
/* 265 */     boolean bool = false;
/*     */     
/* 267 */     paramd = a(paramd);
/*     */     
/* 269 */     if (paramd != null && paramd.delete()) {
/* 270 */       E.remove(paramd);
/* 271 */       bool = true;
/*     */     } 
/*     */     
/* 274 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(d paramd) {
/* 283 */     paramd.t(false);
/* 284 */     c(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static d a(d paramd, n paramn) {
/* 295 */     d d1 = new d(paramn);
/* 296 */     a(paramd, d1);
/*     */     
/* 298 */     return d1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(d paramd1, d paramd2) {
/* 308 */     paramd2.v(paramd1.x());
/* 309 */     paramd2.aa(paramd1.bv());
/* 310 */     paramd2.a(paramd1.a());
/* 311 */     paramd2.setUser(paramd1.getUser());
/* 312 */     paramd2.setPassword(paramd1.getPassword());
/* 313 */     paramd2.t(paramd1.aO());
/* 314 */     paramd2.ab(paramd1.bw());
/* 315 */     paramd2.ac(paramd1.bx());
/* 316 */     paramd2.ad(paramd1.by());
/* 317 */     paramd2.u(paramd1.aP());
/* 318 */     paramd2.w(paramd1.y());
/* 319 */     paramd2.ae(paramd1.bz());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<d> N() {
/* 328 */     if (E == null || E.isEmpty()) {
/* 329 */       cK();
/*     */     }
/*     */     
/* 332 */     return E;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */