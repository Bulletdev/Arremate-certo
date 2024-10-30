/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.m.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*  30 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*  32 */   private static b b = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean N = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean O = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean P = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   protected long J = TimeUnit.MINUTES.toMillis(20L);
/*     */ 
/*     */   
/*  67 */   protected long I = TimeUnit.SECONDS.toMillis(105L);
/*     */   
/*     */   protected boolean Q = false;
/*     */   protected boolean R = false;
/*  71 */   protected BigDecimal h = BigDecimal.TEN;
/*     */   protected boolean S = false;
/*  73 */   protected int aN = 4;
/*  74 */   protected long K = TimeUnit.MINUTES.toMillis(4L);
/*     */   
/*     */   protected boolean J;
/*     */   protected boolean K;
/*     */   protected boolean L;
/*     */   protected BigDecimal e;
/*     */   protected BigDecimal f;
/*     */   
/*     */   public static b a() {
/*  83 */     if (b == null) {
/*  84 */       cn();
/*     */     }
/*     */     
/*  87 */     return b;
/*     */   }
/*     */   protected int aL; protected w c; protected boolean M; protected long H; protected int aM; protected BigDecimal g;
/*     */   public static void cn() {
/*  91 */     b = a((j)null);
/*     */   }
/*     */   
/*     */   static b a(j paramj) {
/*  95 */     b b1 = null;
/*  96 */     int i = 0;
/*  97 */     boolean bool = false;
/*  98 */     boolean bool1 = n.aE();
/*  99 */     long l = TimeUnit.SECONDS.toMillis(105L);
/*     */     
/* 101 */     if (paramj != null) {
/* 102 */       o o = paramj.b().a();
/* 103 */       l l1 = paramj.a();
/* 104 */       boolean bool2 = (o.equals(o.a) && l1.equals(l.c)) ? true : false;
/* 105 */       boolean bool3 = o.equals(o.k);
/* 106 */       bool1 = (bool1 && !bool3 && !bool2);
/* 107 */       i = paramj.N();
/*     */ 
/*     */       
/* 110 */       if (o == o.d) {
/* 111 */         l = TimeUnit.MINUTES.toMillis(2L);
/*     */       }
/*     */     } 
/*     */     
/* 115 */     try(Statement null = a.a().createStatement(); ResultSet null = statement.executeQuery("SELECT * FROM tbconfiguracao WHERE concodigo = 1")) {
/* 116 */       if (resultSet.next()) {
/* 117 */         b1 = new b();
/* 118 */         b1.e = resultSet.getBigDecimal("convalorreducaoini");
/* 119 */         b1.f = resultSet.getBigDecimal("convalorreducaofim");
/* 120 */         b1.aL = resultSet.getInt("coninicioenviolances");
/* 121 */         b1.c = w.a(resultSet.getInt("contiporeducao"));
/* 122 */         b1.L = resultSet.getBoolean("condisputameepp");
/* 123 */         b1.H = resultSet.getLong("contempoextraentrelances");
/* 124 */         b1.aM = resultSet.getInt("conarredondarcasasdecimais");
/* 125 */         b1.g = resultSet.getBigDecimal("conpercentualdisputameepp");
/*     */         
/* 127 */         boolean bool2 = (bool1 && resultSet.getBoolean("condisputarmelhorposicaopossivel")) ? true : false;
/* 128 */         b1.M = bool2;
/* 129 */         b1.J = (!bool2 && resultSet.getBoolean("conenviarlancevlrminimo")) ? 1L : 0L;
/*     */       } else {
/* 131 */         b1 = new b();
/* 132 */         b1.e = BigDecimal.valueOf(0.01D);
/* 133 */         b1.f = BigDecimal.valueOf(0.01D);
/* 134 */         b1.aL = 2;
/* 135 */         b1.c = w.a;
/* 136 */         b1.J = !bool1 ? 1L : 0L;
/* 137 */         b1.L = false;
/* 138 */         b1.M = bool1;
/* 139 */         b1.H = 0L;
/* 140 */         b1.aM = 2;
/* 141 */         b1.g = BigDecimal.valueOf(5.01D);
/*     */ 
/*     */         
/* 144 */         byte b2 = 1;
/* 145 */         String str = "INSERT INTO tbconfiguracao(concodigo, conenviarlancevlrminimo, convalorreducaoini, convalorreducaofim, coninicioenviolances, contiporeducao, condisputameepp, conarredondarcasasdecimais, conpercentualdisputameepp, condisputarmelhorposicaopossivel) VALUES (?,?,?,?,?,?,?,?,?,?)";
/*     */ 
/*     */ 
/*     */         
/* 149 */         try (CallableStatement null = a.a().prepareCall(str)) {
/* 150 */           callableStatement.setInt(b2++, 1);
/* 151 */           callableStatement.setBoolean(b2++, b1.J);
/* 152 */           callableStatement.setBigDecimal(b2++, b1.e);
/* 153 */           callableStatement.setBigDecimal(b2++, b1.f);
/* 154 */           callableStatement.setInt(b2++, b1.aL);
/* 155 */           callableStatement.setInt(b2++, b1.c.y());
/* 156 */           callableStatement.setBoolean(b2++, b1.L);
/* 157 */           callableStatement.setInt(b2++, b1.aM);
/* 158 */           callableStatement.setBigDecimal(b2++, b1.g);
/* 159 */           callableStatement.setBoolean(b2++, b1.M);
/*     */           
/* 161 */           callableStatement.execute();
/*     */         } 
/*     */       } 
/*     */       
/* 165 */       b1.I = l;
/*     */       
/* 167 */       if (bool && b1.H < bool) {
/* 168 */         b1.H = bool;
/*     */       }
/*     */       
/* 171 */       if (i > 0) {
/* 172 */         int k = 4 - i;
/*     */         
/* 174 */         if (k > b1.aM) {
/* 175 */           b1.aM = k;
/*     */           
/* 177 */           BigDecimal bigDecimal = a(k);
/* 178 */           b1.e = bigDecimal;
/*     */           
/* 180 */           if (b1.f.compareTo(bigDecimal) > 0) {
/* 181 */             b1.f = b1.f.setScale(k, RoundingMode.DOWN);
/*     */           } else {
/* 183 */             b1.f = bigDecimal;
/*     */           } 
/*     */         } 
/*     */       } 
/* 187 */     } catch (Exception exception) {
/* 188 */       a.warn("Failed do load general confs", exception);
/*     */     } 
/*     */     
/* 191 */     return b1;
/*     */   }
/*     */   private static BigDecimal a(int paramInt) {
/*     */     String str;
/* 195 */     byte b1 = 4;
/*     */ 
/*     */     
/* 198 */     if (paramInt < b1) {
/* 199 */       paramInt = Math.abs(paramInt - b1);
/* 200 */       str = String.join("", new CharSequence[] { "0.", StringUtils.leftPad("1", paramInt, "0") });
/*     */     } else {
/* 202 */       paramInt = paramInt - b1 + 1;
/* 203 */       str = StringUtils.rightPad("1", paramInt, "0");
/*     */     } 
/*     */     
/* 206 */     return new BigDecimal(str);
/*     */   }
/*     */   
/*     */   public static b b(j paramj) {
/* 210 */     return a(paramj.v(), paramj.C(), paramj.b());
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
/*     */   public static b a(int paramInt, long paramLong, n paramn) {
/* 222 */     String str = "SELECT * FROM tblicitacao WHERE liccodigo = ? AND porcodigo = ? AND empcnpj = ?";
/* 223 */     b b1 = null;
/*     */     
/*     */     try {
/* 226 */       PreparedStatement preparedStatement = a.a().prepareStatement(str);
/* 227 */       preparedStatement.setInt(1, paramInt);
/* 228 */       preparedStatement.setInt(2, paramn.v());
/* 229 */       preparedStatement.setLong(3, paramLong);
/* 230 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */ 
/*     */ 
/*     */       
/* 234 */       if (resultSet.next() && resultSet.getObject("licinicioenviolances") != null) {
/* 235 */         b1 = new b();
/* 236 */         b1.e = resultSet.getBigDecimal("licvalorreducaoini");
/* 237 */         b1.f = resultSet.getBigDecimal("licvalorreducaofim");
/* 238 */         b1.aL = resultSet.getInt("licinicioenviolances");
/* 239 */         b1.c = w.a(resultSet.getInt("lictiporeducao"));
/* 240 */         b1.L = resultSet.getBoolean("licdisputameepp");
/* 241 */         b1.J = resultSet.getBoolean("licenviarlancevlrminimo");
/* 242 */         b1.H = resultSet.getLong("lictempoextraentrelances");
/*     */         
/* 244 */         if (n.bT()) {
/* 245 */           b1.N = resultSet.getBoolean("licenviarlanceviradaminuto");
/* 246 */           b1.O = resultSet.getBoolean("liccobrirlanceviradaminuto");
/* 247 */           b1.P = resultSet.getBoolean("liclancesdispensarestando");
/* 248 */           b1.J = resultSet.getInt("licmomentoenviarlancedispensa");
/*     */         } else {
/* 250 */           b1.N = false;
/* 251 */           b1.O = false;
/* 252 */           b1.P = false;
/*     */         } 
/*     */         
/* 255 */         if (n.aE()) {
/* 256 */           b1.M = resultSet.getBoolean("licdisputasegundoquinto");
/*     */         } else {
/* 258 */           b1.M = false;
/*     */         } 
/*     */         
/* 261 */         b1.K = resultSet.getBoolean("licenvialanceiniciodisputa");
/* 262 */         b1.aM = resultSet.getInt("licarredondarcasasdecimais");
/* 263 */         b1.g = resultSet.getBigDecimal("licpercentualdisputameepp");
/* 264 */         b1.I = resultSet.getLong("licmomentoenviarlanceaberto");
/* 265 */         b1.Q = resultSet.getBoolean("lictoptres");
/* 266 */         b1.R = resultSet.getBoolean("licmanterdezporcentoprimeirolugar");
/* 267 */         b1.h = resultSet.getBigDecimal("licpercentualprimeirolugar");
/* 268 */         b1.S = resultSet.getBoolean("licexcluircompetidor");
/* 269 */         b1.aN = resultSet.getInt("licposicaoexcluircompetidor");
/* 270 */         b1.K = resultSet.getLong("licmomentoenviarlancefechado");
/*     */       } 
/* 272 */     } catch (Exception exception) {
/* 273 */       a.warn("Failed to get dispute settings", exception);
/*     */     } 
/*     */     
/* 276 */     return b1;
/*     */   }
/*     */   
/*     */   public static b a(e parame) {
/* 280 */     if (parame.G() > 0) {
/* 281 */       g g = parame.a(0);
/* 282 */       return a(g);
/*     */     } 
/*     */     
/* 285 */     return b(parame.a());
/*     */   }
/*     */   
/*     */   public static b a(g paramg) {
/* 289 */     return a(paramg.v(), paramg.a().v(), paramg.a().C(), paramg.a().b());
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
/*     */   public static b a(int paramInt1, int paramInt2, long paramLong, n paramn) {
/* 302 */     String str = "SELECT * FROM tbitemlicitacao WHERE liccodigo = ? AND porcodigo = ? AND empcnpj = ? AND itecodigo = ?";
/* 303 */     b b1 = null;
/*     */     
/*     */     try {
/* 306 */       PreparedStatement preparedStatement = a.a().prepareStatement(str);
/* 307 */       preparedStatement.setInt(1, paramInt2);
/* 308 */       preparedStatement.setInt(2, paramn.v());
/* 309 */       preparedStatement.setLong(3, paramLong);
/* 310 */       preparedStatement.setInt(4, paramInt1);
/* 311 */       ResultSet resultSet = preparedStatement.executeQuery();
/*     */       
/* 313 */       if (resultSet.next() && resultSet.getObject("itevalorreducaoini") != null) {
/* 314 */         b1 = new b();
/* 315 */         b1.e = resultSet.getBigDecimal("itevalorreducaoini");
/* 316 */         b1.f = resultSet.getBigDecimal("itevalorreducaofim");
/* 317 */         b1.aL = resultSet.getInt("iteinicioenviolances");
/* 318 */         b1.c = w.a(resultSet.getInt("itetiporeducao"));
/* 319 */         b1.L = resultSet.getBoolean("itedisputameepp");
/* 320 */         b1.J = resultSet.getBoolean("iteenviarlancevlrminimo");
/* 321 */         b1.H = resultSet.getLong("itetempoextraentrelances");
/*     */         
/* 323 */         if (n.bT()) {
/* 324 */           b1.N = resultSet.getBoolean("iteenviarlanceviradaminuto");
/* 325 */           b1.O = resultSet.getBoolean("itecobrirlanceviradaminuto");
/* 326 */           b1.P = resultSet.getBoolean("itelancesdispensarestando");
/* 327 */           b1.J = resultSet.getInt("itemomentoenviarlancedispensa");
/*     */         } else {
/* 329 */           b1.N = false;
/* 330 */           b1.O = false;
/* 331 */           b1.P = false;
/*     */         } 
/*     */         
/* 334 */         if (n.aE()) {
/* 335 */           b1.M = resultSet.getBoolean("itedisputasegundoquinto");
/*     */         } else {
/* 337 */           b1.M = false;
/*     */         } 
/*     */         
/* 340 */         b1.aM = resultSet.getBoolean("itequatrocasas") ? 4 : resultSet.getInt("itearredondarcasasdecimais");
/* 341 */         b1.g = resultSet.getBigDecimal("itepercentualdisputameepp");
/* 342 */         b1.I = resultSet.getLong("itemomentoenviarlanceaberto");
/* 343 */         b1.Q = resultSet.getBoolean("itetoptres");
/* 344 */         b1.R = resultSet.getBoolean("itemanterdezporcentoprimeirolugar");
/* 345 */         b1.h = resultSet.getBigDecimal("itepercentualprimeirolugar");
/* 346 */         b1.S = resultSet.getBoolean("iteexcluircompetidor");
/* 347 */         b1.aN = resultSet.getInt("iteposicaoexcluircompetidor");
/* 348 */         b1.K = resultSet.getLong("itemomentoenviarlancefechado");
/*     */       } 
/* 350 */     } catch (Exception exception) {
/* 351 */       a.warn("Failed to load item configuration", exception);
/*     */     } 
/*     */     
/* 354 */     return b1;
/*     */   }
/*     */   
/*     */   public boolean aC() {
/* 358 */     String str = "";
/*     */     
/* 360 */     if (f().compareTo(BigDecimal.ZERO) != 1) {
/* 361 */       str = "Variação inicial deve ser maior que 0,00";
/*     */     }
/*     */     
/* 364 */     if (g().compareTo(f()) == -1) {
/* 365 */       if (!str.isEmpty()) {
/* 366 */         str = str + "\n";
/*     */       }
/*     */       
/* 369 */       str = str + "Variação final deve ser maior ou igual a variação inicial";
/*     */     } 
/*     */     
/* 372 */     if (!str.isEmpty()) {
/* 373 */       str = "Para iniciar a disputa é necessário ajustar as situações abaixo:\n\n" + str;
/* 374 */       JOptionPane.showMessageDialog(null, str, "Mensagem", 0);
/*     */     } 
/*     */     
/* 377 */     return str.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal f() {
/* 386 */     BigDecimal bigDecimal = this.e;
/*     */     
/* 388 */     if (this.c == w.b) {
/* 389 */       bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/*     */     }
/*     */     
/* 392 */     return bigDecimal;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal g() {
/* 401 */     BigDecimal bigDecimal = this.f;
/*     */     
/* 403 */     if (this.c == w.b) {
/* 404 */       bigDecimal = bigDecimal.divide(BigDecimal.valueOf(100L));
/*     */     }
/* 406 */     return bigDecimal;
/*     */   }
/*     */   
/*     */   public i a(j paramj) {
/* 410 */     return i.a(this.aL, paramj);
/*     */   }
/*     */   
/*     */   public w a() {
/* 414 */     return this.c;
/*     */   }
/*     */   
/*     */   public boolean aD() {
/* 418 */     return this.J;
/*     */   }
/*     */   
/*     */   public void p(boolean paramBoolean) {
/* 422 */     this.J = paramBoolean;
/*     */   }
/*     */   
/*     */   public void q(boolean paramBoolean) {
/* 426 */     this.L = paramBoolean;
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
/*     */   public boolean a(n paramn, d paramd, m paramm) {
/* 441 */     boolean bool = (paramd == null || paramd.a() != p.b) ? true : false;
/* 442 */     return (paramn.bk() && bool && paramm != m.c) ? this.L : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aE() {
/* 448 */     return this.M;
/*     */   }
/*     */   
/*     */   public boolean aF() {
/* 452 */     return this.K;
/*     */   }
/*     */   
/*     */   public void r(boolean paramBoolean) {
/* 456 */     this.K = paramBoolean;
/*     */   }
/*     */   
/*     */   public long t() {
/* 460 */     return this.H;
/*     */   }
/*     */   
/*     */   public int E() {
/* 464 */     return this.aM;
/*     */   }
/*     */   
/*     */   public BigDecimal h() {
/* 468 */     return this.g;
/*     */   }
/*     */   
/*     */   public long u() {
/* 472 */     return this.I;
/*     */   }
/*     */   
/*     */   public boolean aG() {
/* 476 */     return this.N;
/*     */   }
/*     */   
/*     */   public boolean aH() {
/* 480 */     return this.O;
/*     */   }
/*     */   
/*     */   public boolean aI() {
/* 484 */     return this.P;
/*     */   }
/*     */   
/*     */   public long v() {
/* 488 */     return this.J;
/*     */   }
/*     */   
/*     */   public boolean aJ() {
/* 492 */     return this.Q;
/*     */   }
/*     */   
/*     */   public boolean aK() {
/* 496 */     return this.R;
/*     */   }
/*     */   
/*     */   public BigDecimal i() {
/* 500 */     return this.h;
/*     */   }
/*     */   
/*     */   public boolean aL() {
/* 504 */     return this.S;
/*     */   }
/*     */   
/*     */   public int F() {
/* 508 */     return this.aN;
/*     */   }
/*     */   
/*     */   public long w() {
/* 512 */     return this.K;
/*     */   }
/*     */   
/*     */   public void u(long paramLong) {
/* 516 */     this.K = paramLong;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */