/*     */ package br.com.arremate.l;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.p;
/*     */ import br.com.arremate.m.y;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.security.KeyStore;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.text.ParseException;
/*     */ import java.util.Base64;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*  23 */   private static final Logger a = LoggerFactory.getLogger(d.class);
/*     */   
/*     */   private final n a;
/*     */   
/*     */   private long L;
/*     */   
/*     */   private long M;
/*     */   private String dQ;
/*     */   private String user;
/*     */   private String password;
/*     */   private p d;
/*     */   private boolean T;
/*     */   private boolean U;
/*     */   private String dR;
/*     */   private String dS;
/*     */   private String dT;
/*     */   private String dU;
/*     */   
/*     */   public d(n paramn, long paramLong) {
/*  42 */     this(paramn);
/*  43 */     this.L = paramLong;
/*     */   }
/*     */   
/*     */   public d(n paramn) {
/*  47 */     this.a = paramn;
/*  48 */     this.T = true;
/*     */   }
/*     */   
/*     */   public void load() {
/*     */     try {
/*  53 */       if (x() != 0L) {
/*  54 */         String str = "SELECT * FROM tbempresa WHERE empcnpj = ? AND porcodigo = ?";
/*     */         
/*  56 */         PreparedStatement preparedStatement = a.a().prepareStatement(str);
/*  57 */         preparedStatement.setLong(1, x());
/*  58 */         preparedStatement.setInt(2, b().v());
/*  59 */         ResultSet resultSet = preparedStatement.executeQuery();
/*     */         
/*  61 */         if (resultSet.next()) {
/*  62 */           aa(resultSet.getString("empnome"));
/*  63 */           setUser(resultSet.getString("emplogin"));
/*  64 */           setPassword(resultSet.getString("empsenha"));
/*  65 */           a(p.a(resultSet.getInt("empporte")));
/*  66 */           u(resultSet.getBoolean("ssc"));
/*  67 */           w(resultSet.getLong("empcpf"));
/*  68 */           ae(resultSet.getString("empprofile"));
/*     */         } 
/*     */       } 
/*  71 */     } catch (Exception exception) {
/*  72 */       a.error("Falha ao carregar empresas", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  83 */     String str1 = y.R(getUser());
/*  84 */     String str2 = y.R(getPassword());
/*  85 */     String str3 = null;
/*     */     
/*  87 */     if (bx() != null) {
/*  88 */       str3 = y.R(bx());
/*     */     }
/*     */     
/*     */     try {
/*  92 */       String str = "INSERT INTO tbempresa (empcnpj, empnome, emplogin, empsenha, empativo, porcodigo, empporte, emppfx, emppfxcodigo, emppfxsenha, ssc, empcpf, empprofile) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  97 */       try (CallableStatement null = a.a().prepareCall(str)) {
/*  98 */         byte b = 1;
/*  99 */         callableStatement.setLong(b++, x());
/* 100 */         callableStatement.setString(b++, bv());
/* 101 */         callableStatement.setString(b++, str1.replace("'", "''"));
/* 102 */         callableStatement.setString(b++, str2.replace("'", "''"));
/* 103 */         callableStatement.setBoolean(b++, aO());
/* 104 */         callableStatement.setInt(b++, b().v());
/* 105 */         callableStatement.setInt(b++, a().getIndex());
/* 106 */         callableStatement.setString(b++, bw());
/* 107 */         callableStatement.setString(b++, by());
/* 108 */         callableStatement.setString(b++, str3);
/* 109 */         callableStatement.setBoolean(b++, aP());
/* 110 */         callableStatement.setLong(b++, y());
/* 111 */         callableStatement.setString(b++, bz());
/*     */         
/* 113 */         return (callableStatement.executeUpdate() == 1);
/*     */       } 
/* 115 */     } catch (Exception exception) {
/* 116 */       a.warn("Falha ao adicionar empresa", exception);
/*     */ 
/*     */       
/* 119 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aN() {
/* 130 */     String str1 = "UPDATE tbempresa SET emplogin = ?, empsenha = ?, empativo = ?, empporte = ?, emppfx = ?, emppfxcodigo = ?, emppfxsenha = ?, ssc = ?, empcpf = ?, empprofile = ? WHERE empcnpj = ? AND porcodigo = ?";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     String str2 = y.R(getUser());
/* 137 */     String str3 = y.R(getPassword());
/* 138 */     String str4 = null;
/*     */     
/* 140 */     if (bx() != null) {
/* 141 */       str4 = y.R(bx());
/*     */     }
/*     */     
/* 144 */     try (PreparedStatement null = a.a().prepareStatement(str1)) {
/* 145 */       byte b = 1;
/* 146 */       preparedStatement.setString(b++, str2);
/* 147 */       preparedStatement.setString(b++, str3);
/* 148 */       preparedStatement.setBoolean(b++, aO());
/* 149 */       preparedStatement.setInt(b++, a().getIndex());
/* 150 */       preparedStatement.setString(b++, bw());
/* 151 */       preparedStatement.setString(b++, by());
/* 152 */       preparedStatement.setString(b++, str4);
/* 153 */       preparedStatement.setBoolean(b++, aP());
/* 154 */       preparedStatement.setLong(b++, y());
/* 155 */       preparedStatement.setString(b++, bz());
/* 156 */       preparedStatement.setLong(b++, x());
/* 157 */       preparedStatement.setInt(b++, b().v());
/*     */       
/* 159 */       return (preparedStatement.executeUpdate() == 1);
/* 160 */     } catch (Exception exception) {
/* 161 */       a.warn("Falha ao atualizar empresa", exception);
/*     */ 
/*     */       
/* 164 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean delete() {
/* 173 */     try (Statement null = a.a().createStatement()) {
/* 174 */       String str1 = "WHERE empcnpj = " + this.L + " AND porcodigo = " + b().v();
/*     */       
/* 176 */       String str2 = "DELETE FROM tbitemlicitacao " + str1;
/* 177 */       statement.executeUpdate(str2);
/*     */       
/* 179 */       str2 = "DELETE FROM tblicitacao " + str1;
/* 180 */       statement.executeUpdate(str2);
/*     */       
/* 182 */       str2 = "DELETE FROM tbempresa " + str1;
/*     */       
/* 184 */       return (statement.executeUpdate(str2) > 0);
/* 185 */     } catch (Exception exception) {
/* 186 */       a.warn("Falha ao remover empresa", exception);
/*     */ 
/*     */       
/* 189 */       return false;
/*     */     } 
/*     */   }
/*     */   public KeyStore a() {
/*     */     try {
/* 194 */       if (this.dS == null || this.dS.isEmpty() || this.dT == null || this.dT.isEmpty()) {
/* 195 */         return null;
/*     */       }
/*     */       
/* 198 */       byte[] arrayOfByte = Base64.getDecoder().decode(this.dS);
/*     */       
/* 200 */       KeyStore keyStore = KeyStore.getInstance("PKCS12");
/* 201 */       keyStore.load(new ByteArrayInputStream(arrayOfByte), this.dT.toCharArray());
/*     */       
/* 203 */       return keyStore;
/* 204 */     } catch (Exception exception) {
/* 205 */       a.error("Failed to load {} company certificate", this.dQ, exception);
/*     */ 
/*     */       
/* 208 */       return null;
/*     */     } 
/*     */   }
/*     */   public n b() {
/* 212 */     return this.a;
/*     */   }
/*     */   
/*     */   public long x() {
/* 216 */     return this.L;
/*     */   }
/*     */   
/*     */   public String aw() {
/* 220 */     return StringUtils.leftPad(String.valueOf(this.L), 14, "0");
/*     */   }
/*     */   
/*     */   public String ax() {
/*     */     String str;
/*     */     try {
/* 226 */       str = StringUtils.leftPad(String.valueOf(this.L), 14, "0");
/*     */       
/* 228 */       MaskFormatter maskFormatter = new MaskFormatter("##.###.###/####-##");
/* 229 */       maskFormatter.setValueContainsLiteralCharacters(false);
/* 230 */       str = maskFormatter.valueToString(str);
/* 231 */     } catch (ParseException parseException) {
/* 232 */       str = "00.000.000/0000-00";
/*     */     } 
/*     */     
/* 235 */     return str;
/*     */   }
/*     */   
/*     */   public void v(long paramLong) {
/* 239 */     this.L = paramLong;
/*     */   }
/*     */   
/*     */   public String bv() {
/* 243 */     return this.dQ;
/*     */   }
/*     */   
/*     */   public void aa(String paramString) {
/* 247 */     this.dQ = paramString;
/*     */   }
/*     */   
/*     */   public String getUser() {
/* 251 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(String paramString) {
/* 255 */     this.user = paramString;
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 259 */     return this.password;
/*     */   }
/*     */   
/*     */   public void setPassword(String paramString) {
/* 263 */     this.password = paramString;
/*     */   }
/*     */   
/*     */   public p a() {
/* 267 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(p paramp) {
/* 271 */     this.d = paramp;
/*     */   }
/*     */   
/*     */   public boolean aO() {
/* 275 */     return this.T;
/*     */   }
/*     */   
/*     */   public void t(boolean paramBoolean) {
/* 279 */     this.T = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean aP() {
/* 283 */     return this.U;
/*     */   }
/*     */   
/*     */   public void u(boolean paramBoolean) {
/* 287 */     this.U = paramBoolean;
/*     */   }
/*     */   
/*     */   public String bw() {
/* 291 */     return this.dS;
/*     */   }
/*     */   
/*     */   public void ab(String paramString) {
/* 295 */     this.dS = paramString;
/*     */   }
/*     */   
/*     */   public String bx() {
/* 299 */     return this.dT;
/*     */   }
/*     */   
/*     */   public void ac(String paramString) {
/* 303 */     this.dT = paramString;
/*     */   }
/*     */   
/*     */   public String by() {
/* 307 */     return this.dU;
/*     */   }
/*     */   
/*     */   public void ad(String paramString) {
/* 311 */     this.dU = paramString;
/*     */   }
/*     */   
/*     */   public long y() {
/* 315 */     return this.M;
/*     */   }
/*     */   
/*     */   public void w(long paramLong) {
/* 319 */     this.M = paramLong;
/*     */   }
/*     */   
/*     */   public String bz() {
/* 323 */     return this.dR;
/*     */   }
/*     */   
/*     */   public void ae(String paramString) {
/* 327 */     this.dR = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */