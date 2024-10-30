/*     */ package br.com.arremate.l.p;
/*     */ 
/*     */ import br.com.arremate.a.a;
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import com.google.gson.Gson;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.file.Files;
/*     */ import java.sql.Blob;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.StringJoiner;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.stream.Collectors;
/*     */ import javax.sql.rowset.serial.SerialBlob;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*  42 */   private static final Logger a = LoggerFactory.getLogger(f.class);
/*  43 */   private static final f a = new f();
/*     */   
/*     */   private final ReentrantLock a;
/*     */   private final ReentrantLock b;
/*     */   
/*     */   public static f a() {
/*  49 */     return (f)a;
/*     */   }
/*     */   
/*     */   private f() {
/*  53 */     this.a = new ReentrantLock();
/*  54 */     this.b = new ReentrantLock();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cs() {
/*  61 */     (new Thread(() -> ct()))
/*     */       
/*  63 */       .start();
/*     */   }
/*     */ 
/*     */   
/*     */   private void ct() {
/*  68 */     this.a.lock();
/*     */     
/*     */     try {
/*  71 */       LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet();
/*  72 */       String str = "SELECT * FROM tbarrematelog WHERE arrenviado is false ORDER BY arrcodigo";
/*     */       
/*  74 */       try(Statement null = a.a().createStatement(); 
/*  75 */           ResultSet null = statement.executeQuery(str)) {
/*     */         
/*  77 */         while (resultSet.next()) {
/*  78 */           Blob blob = resultSet.getBlob("arrloglinhadotempo");
/*  79 */           String str1 = a(blob);
/*     */           
/*  81 */           i i1 = new i();
/*  82 */           i1.a("tipo", 1);
/*  83 */           i1.c("data", (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS")).format(n.i().getTime()));
/*  84 */           i1.c("mensagem", String.join(" ", new CharSequence[] { "Os logs a seguir foram enviados do IP", A.a().cA() }));
/*     */           
/*  86 */           org.e.f f1 = (new org.e.f(str1)).a(i1.toString());
/*     */           
/*  88 */           int i = resultSet.getInt("liccodigo");
/*  89 */           long l = resultSet.getLong("empcnpj");
/*  90 */           int j = resultSet.getInt("porcodigo");
/*  91 */           j = (j == 22222) ? 2 : j;
/*  92 */           o o = o.a(j);
/*     */           
/*  94 */           b b = n.a().a(i, o, l);
/*  95 */           if (b == null) {
/*  96 */             a(Long.valueOf(l), i, j);
/*     */             
/*     */             continue;
/*     */           } 
/* 100 */           d d = new d(b.a().B());
/*     */           
/* 102 */           i i2 = new i();
/* 103 */           i2.a("codigoPortal", j);
/* 104 */           i2.c("cnpj", StringUtils.leftPad(Long.toString(l), 14, "0"));
/* 105 */           i2.a("codigo", i);
/* 106 */           i2.c("numero", resultSet.getString("arrnumero"));
/* 107 */           i2.a("uasg", resultSet.getInt("arruasg"));
/* 108 */           i2.c("uasgNome", resultSet.getString("arruasgnome"));
/* 109 */           i2.a("quantidadeItens", resultSet.getInt("arrquantidadeitens"));
/* 110 */           i2.a("quantidadeItensVencidos", resultSet.getInt("arrquantidadeitensvencidos"));
/* 111 */           i2.a("quantidadeItensFracassados", resultSet.getInt("arrquantidadeitensfracassados"));
/* 112 */           i2.a("quantidadeItensFracassadosComMargem", resultSet.getInt("arrquantidadeitensfracassadoscommargem"));
/* 113 */           i2.a("valorTotalVencido", resultSet.getDouble("arrvalortotalvencido"));
/* 114 */           i2.a("valorLucro", resultSet.getDouble("arrvalorlucro"));
/* 115 */           i2.a("variacaoInicial", resultSet.getDouble("arrvariacaoinicial"));
/* 116 */           i2.a("variacaoFinal", resultSet.getDouble("arrvariacaofinal"));
/* 117 */           i2.a("tipoReducao", resultSet.getInt("arrtiporeducao"));
/* 118 */           i2.b("lanceDerradeiro", resultSet.getBoolean("arrlancederradeiro"));
/* 119 */           i2.b("quatroCasasDecimais", resultSet.getBoolean("arrquatrocasasdecimais"));
/* 120 */           i2.a("modoDisputa", resultSet.getInt("arrmododedisputa"));
/* 121 */           i2.c("logConfiguracoes", d.f());
/* 122 */           i2.c("logLinhaDoTempo", f1);
/*     */           
/* 124 */           boolean bool = false;
/* 125 */           byte b1 = 0;
/*     */           
/*     */           do {
/* 128 */             i i3 = a.a().a(i2.toString());
/* 129 */             if (i3 != null && i3.has("status")) {
/* 130 */               bool = (i3.getInt("status") == 2) ? true : false;
/*     */             }
/*     */             
/* 133 */             b1++;
/* 134 */           } while (!bool && b1 < 2);
/*     */           
/* 136 */           int k = resultSet.getInt("arrcodigo");
/*     */           
/* 138 */           if (!bool) {
/* 139 */             a.warn("Falha ao enviar log número {}", Integer.valueOf(k));
/*     */             
/*     */             break;
/*     */           } 
/* 143 */           linkedHashSet.add(Integer.valueOf(k));
/*     */         } 
/* 145 */       } catch (Exception exception) {
/* 146 */         a.warn("Erro ao enviar o log da licitação", exception);
/*     */       } 
/*     */       
/* 149 */       for (Integer integer : linkedHashSet) {
/* 150 */         String str1 = "UPDATE tbarrematelog SET arrenviado = ? where arrcodigo = ?";
/* 151 */         try (CallableStatement null = a.a().prepareCall(str1)) {
/* 152 */           callableStatement.setBoolean(1, true);
/* 153 */           callableStatement.setInt(2, integer.intValue());
/* 154 */           callableStatement.executeUpdate();
/*     */         } 
/*     */       } 
/* 157 */     } catch (Exception exception) {
/* 158 */       a.warn("Erro ao enviar o log da licitação", exception);
/*     */     } finally {
/* 160 */       this.a.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Long paramLong, int paramInt1, int paramInt2) {
/*     */     try {
/* 166 */       String str = "DELETE FROM tbarrematelog WHERE empcnpj = " + paramLong + " AND liccodigo = " + paramInt1 + " AND porcodigo = " + paramInt2;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       Statement statement = a.a().createStatement();
/* 172 */       statement.execute(str);
/* 173 */       a.info("Delete log licitação {}, portal {} e empresa {}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramLong });
/* 174 */     } catch (Exception exception) {
/* 175 */       a.error("Error to delete log", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb) {
/* 187 */     this.b.lock();
/*     */     
/*     */     try {
/* 190 */       List<h> list = paramb.a().E();
/*     */       
/* 192 */       if (!list.isEmpty()) {
/* 193 */         Gson gson = new Gson();
/*     */         
/*     */         do {
/* 196 */           Long long_ = Long.valueOf((new Date()).getTime());
/* 197 */           String str1 = String.join(".", new CharSequence[] { String.valueOf(long_), "json" });
/* 198 */           String str2 = String.join("/", new CharSequence[] { y.ft, str1 });
/*     */           
/* 200 */           try (FileOutputStream null = new FileOutputStream(str2)) {
/* 201 */             int i = 0;
/*     */             
/* 203 */             byte[] arrayOfByte = "[".getBytes(Charset.forName("UTF-8"));
/* 204 */             fileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 205 */             i += arrayOfByte.length;
/*     */             
/* 207 */             for (byte b1 = 0; b1 < list.size(); b1++) {
/* 208 */               h h = list.get(b1);
/*     */               
/* 210 */               if (b1 > 0 && h.j().contains("Situação atual do pregão")) {
/* 211 */                 h h1 = list.get(b1 - 1);
/*     */                 
/* 213 */                 if (h1.j().equals(h.j())) {
/* 214 */                   h.N(true);
/*     */                   
/*     */                   continue;
/*     */                 } 
/*     */               } 
/* 219 */               if (b1 != 0) {
/* 220 */                 arrayOfByte = ",".getBytes(Charset.forName("UTF-8"));
/* 221 */                 i += arrayOfByte.length;
/* 222 */                 fileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/*     */               } 
/*     */               
/* 225 */               arrayOfByte = gson.toJson(h.q().toString()).getBytes();
/* 226 */               fileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/* 227 */               i += arrayOfByte.length;
/* 228 */               h.N(true);
/*     */ 
/*     */               
/* 231 */               if (i > 1000000) {
/*     */                 break;
/*     */               }
/*     */               continue;
/*     */             } 
/* 236 */             arrayOfByte = "]".getBytes(Charset.forName("UTF-8"));
/* 237 */             fileOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
/*     */           } 
/*     */           
/* 240 */           if (a().a(str2, paramb)) {
/* 241 */             list.removeAll((Collection)list
/* 242 */                 .stream()
/* 243 */                 .filter(paramh -> paramh.bq())
/* 244 */                 .collect(Collectors.toList()));
/*     */           } else {
/*     */             
/* 247 */             k(list);
/*     */             break;
/*     */           } 
/* 250 */         } while (list.size() > 0);
/*     */       } 
/* 252 */     } catch (Exception exception) {
/* 253 */       a.error("Erro ao gravar dados do log", exception);
/*     */     } finally {
/* 255 */       this.b.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void k(List<h> paramList) {
/* 260 */     paramList.forEach(paramh -> paramh.N(false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(String paramString, b paramb) {
/* 266 */     boolean bool = true;
/*     */     
/* 268 */     StringJoiner stringJoiner = new StringJoiner(", ");
/* 269 */     stringJoiner.add("liccodigo").add("empcnpj").add("porcodigo").add("arrenviado").add("arrnumero");
/* 270 */     stringJoiner.add("arruasg").add("arruasgNome").add("arrquantidadeItens").add("arrquantidadeItensVencidos");
/* 271 */     stringJoiner.add("arrquantidadeItensFracassados").add("arrquantidadeItensFracassadosComMargem");
/* 272 */     stringJoiner.add("arrvalorTotalVencido").add("arrvalorLucro").add("arrvariacaoInicial").add("arrvariacaoFinal");
/* 273 */     stringJoiner.add("arrtipoReducao").add("arrlanceDerradeiro").add("arrquatroCasasDecimais").add("arrmododedisputa").add("arrlogLinhaDoTempo");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     String str1 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/* 279 */     byte b1 = 1;
/*     */     
/* 281 */     String str2 = "INSERT INTO tbarrematelog (" + stringJoiner.toString() + ") VALUES (" + str1 + ");";
/* 282 */     b b2 = paramb.a().b();
/* 283 */     File file = new File(paramString);
/*     */     
/* 285 */     try (PreparedStatement null = a.a().prepareStatement(str2)) {
/* 286 */       byte[] arrayOfByte = Files.readAllBytes(file.toPath());
/* 287 */       SerialBlob serialBlob = new SerialBlob(arrayOfByte);
/*     */       
/* 289 */       preparedStatement.setInt(b1++, paramb.a().v());
/* 290 */       preparedStatement.setLong(b1++, paramb.a().C());
/* 291 */       preparedStatement.setInt(b1++, paramb.a().b().v());
/* 292 */       preparedStatement.setBoolean(b1++, false);
/* 293 */       preparedStatement.setString(b1++, paramb.a().bo());
/* 294 */       preparedStatement.setInt(b1++, paramb.a().K());
/* 295 */       preparedStatement.setString(b1++, paramb.a().bT());
/* 296 */       preparedStatement.setInt(b1++, paramb.U());
/* 297 */       preparedStatement.setInt(b1++, paramb.R());
/* 298 */       preparedStatement.setInt(b1++, paramb.S());
/* 299 */       preparedStatement.setInt(b1++, paramb.T());
/* 300 */       preparedStatement.setDouble(b1++, paramb.p());
/* 301 */       preparedStatement.setDouble(b1++, paramb.q());
/* 302 */       preparedStatement.setBigDecimal(b1++, b2.f());
/* 303 */       preparedStatement.setBigDecimal(b1++, b2.g());
/* 304 */       preparedStatement.setInt(b1++, b2.a().y());
/* 305 */       preparedStatement.setBoolean(b1++, b2.aD());
/* 306 */       preparedStatement.setBoolean(b1++, false);
/* 307 */       preparedStatement.setInt(b1++, paramb.a().a().getId());
/* 308 */       preparedStatement.setBlob(b1++, serialBlob);
/*     */       
/* 310 */       preparedStatement.executeUpdate();
/* 311 */     } catch (Exception exception) {
/* 312 */       a.warn("Failed to save log", exception);
/* 313 */       bool = false;
/*     */     } finally {
/*     */       try {
/* 316 */         file.delete();
/* 317 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */     
/* 321 */     return bool;
/*     */   }
/*     */   
/*     */   private String a(Blob paramBlob) throws Exception {
/* 325 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 326 */     byte[] arrayOfByte1 = new byte[1024];
/*     */     
/* 328 */     try (InputStream null = paramBlob.getBinaryStream()) {
/*     */       int i;
/*     */       
/* 331 */       while ((i = inputStream.read(arrayOfByte1)) >= 0) {
/* 332 */         byteArrayOutputStream.write(arrayOfByte1, 0, i);
/*     */       }
/*     */     } 
/*     */     
/* 336 */     byte[] arrayOfByte2 = byteArrayOutputStream.toByteArray();
/* 337 */     return new String(arrayOfByte2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */