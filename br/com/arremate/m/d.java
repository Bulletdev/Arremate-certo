/*     */ package br.com.arremate.m;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.c;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.w;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.l.p;
/*     */ import java.awt.HeadlessException;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileReader;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.commons.io.FilenameUtils;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.apache.commons.lang3.math.NumberUtils;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.IndexedColors;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFDataFormat;
/*     */ import org.apache.poi.xssf.usermodel.XSSFFont;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*  65 */   private static final Logger LOG = LoggerFactory.getLogger(d.class);
/*     */   
/*     */   private final p a;
/*  68 */   private String eu = "";
/*     */   
/*     */   public d(p paramp) {
/*  71 */     this.a = paramp;
/*     */   }
/*     */   
/*     */   private String cr() {
/*  75 */     String str = "";
/*  76 */     try (Statement null = a.a().createStatement()) {
/*  77 */       try (ResultSet null = statement.executeQuery("SELECT caminhoexportacao FROM tbconfiguracao WHERE concodigo = 1")) {
/*  78 */         if (resultSet.next()) {
/*  79 */           str = resultSet.getString("caminhoexportacao");
/*     */         }
/*     */       } 
/*  82 */       return str;
/*  83 */     } catch (Exception exception) {
/*  84 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void aH(String paramString) {
/*     */     try {
/*  90 */       paramString = paramString.replaceAll("[^0-9A-z]", "");
/*  91 */       byte b = 0;
/*     */       
/*  93 */       String str1 = cr();
/*  94 */       if (str1 == null || str1.isEmpty()) {
/*  95 */         str1 = y.fs;
/*     */       }
/*     */       
/*  98 */       String str2 = str1 + y.FILE_SEPARATOR + paramString + ".xlsx";
/*     */       
/* 100 */       if (SystemUtils.IS_OS_MAC) {
/* 101 */         str2 = str1 + y.FILE_SEPARATOR + "Desktop" + y.FILE_SEPARATOR + paramString + ".xlsx";
/*     */       }
/*     */       
/* 104 */       File file = new File(str2);
/*     */       
/* 106 */       if (file.exists()) {
/* 107 */         int i = JOptionPane.showConfirmDialog(null, "Já existe um arquivo com o nome \"" + file.getName() + "\" na pasta de destino, deseja sobrescrever?", "Informação", 0, 1);
/*     */ 
/*     */         
/* 110 */         if (i != 0) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 116 */       XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
/* 117 */       XSSFSheet xSSFSheet = xSSFWorkbook.createSheet(paramString);
/*     */ 
/*     */ 
/*     */       
/* 121 */       XSSFFont xSSFFont = xSSFWorkbook.createFont();
/* 122 */       xSSFFont.setFontHeightInPoints((short)10);
/* 123 */       xSSFFont.setFontName("Arial");
/* 124 */       xSSFFont.setColor(IndexedColors.BLACK.getIndex());
/* 125 */       xSSFFont.setBold(true);
/* 126 */       xSSFFont.setItalic(false);
/*     */       
/* 128 */       XSSFCellStyle xSSFCellStyle1 = xSSFWorkbook.createCellStyle();
/* 129 */       XSSFDataFormat xSSFDataFormat = xSSFWorkbook.createDataFormat();
/* 130 */       xSSFCellStyle1.setDataFormat(xSSFDataFormat.getFormat("###,###,###,##0.0000"));
/*     */       
/* 132 */       XSSFCellStyle xSSFCellStyle2 = xSSFWorkbook.createCellStyle();
/* 133 */       xSSFCellStyle2.setDataFormat(xSSFDataFormat
/* 134 */           .getFormat((this.a.a().b().E() < 2) ? "###,###,##0.0000" : "###,###,##0.00"));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       XSSFCellStyle xSSFCellStyle3 = xSSFWorkbook.createCellStyle();
/* 140 */       xSSFCellStyle3.setFont((Font)xSSFFont);
/*     */       
/* 142 */       XSSFRow xSSFRow = xSSFSheet.createRow(b);
/*     */       
/* 144 */       for (k k : this.a.D()) {
/*     */         
/* 146 */         int i = this.a.Q();
/*     */         
/* 148 */         if (!b) {
/* 149 */           for (Map.Entry entry : this.a.p().entrySet()) {
/* 150 */             XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 151 */             xSSFCell.setCellValue((String)entry.getValue());
/* 152 */             xSSFCell.setCellStyle((CellStyle)xSSFCellStyle3);
/* 153 */             i = this.a.P();
/*     */           } 
/* 155 */           b++;
/*     */         } 
/* 157 */         xSSFRow = xSSFSheet.createRow(b);
/*     */         
/* 159 */         if (this.a.p().containsKey(c.a)) {
/* 160 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 161 */           xSSFCell.setCellValue(k.bZ());
/* 162 */           i = this.a.P();
/*     */         } 
/*     */         
/* 165 */         if (this.a.p().containsKey(c.b)) {
/* 166 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 167 */           xSSFCell.setCellValue(k.ca());
/* 168 */           i = this.a.P();
/*     */         } 
/*     */         
/* 171 */         if (this.a.p().containsKey(c.c)) {
/* 172 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 173 */           xSSFCell.setCellValue(k.o());
/* 174 */           xSSFCell.setCellStyle((CellStyle)xSSFCellStyle1);
/* 175 */           i = this.a.P();
/*     */         } 
/*     */         
/* 178 */         if (this.a.p().containsKey(c.d)) {
/* 179 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 180 */           xSSFCell.setCellValue(k.v().doubleValue());
/* 181 */           xSSFCell.setCellStyle((CellStyle)xSSFCellStyle2);
/* 182 */           i = this.a.P();
/*     */         } 
/*     */         
/* 185 */         if (this.a.p().containsKey(c.e)) {
/* 186 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 187 */           xSSFCell.setCellValue(k.w().doubleValue());
/* 188 */           xSSFCell.setCellStyle((CellStyle)xSSFCellStyle2);
/* 189 */           i = this.a.P();
/*     */         } 
/*     */         
/* 192 */         if (this.a.p().containsKey(c.f)) {
/* 193 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 194 */           xSSFCell.setCellValue(k.cb());
/* 195 */           i = this.a.P();
/*     */         } 
/*     */         
/* 198 */         if (this.a.p().containsKey(c.g)) {
/* 199 */           XSSFCell xSSFCell = xSSFRow.createCell(i);
/* 200 */           xSSFCell.setCellValue(k.x().doubleValue());
/* 201 */           xSSFCell.setCellStyle((CellStyle)xSSFCellStyle1);
/* 202 */           i = this.a.P();
/*     */         } 
/*     */         
/* 205 */         b++;
/*     */         
/* 207 */         if (b == this.a.D().size() + 1) {
/* 208 */           for (Map.Entry entry : this.a.p().entrySet()) {
/* 209 */             xSSFSheet.autoSizeColumn(i);
/* 210 */             i = this.a.P();
/*     */           } 
/*     */         }
/*     */       } 
/* 214 */       FileOutputStream fileOutputStream = new FileOutputStream(str2);
/* 215 */       xSSFWorkbook.write(fileOutputStream);
/* 216 */       fileOutputStream.flush();
/* 217 */       fileOutputStream.close();
/*     */       
/* 219 */       JOptionPane.showMessageDialog(null, "Exportação dos itens realizada com sucesso. \nO arquivo encontra-se em " + str1 + " com o nome: \"" + paramString + "\".", "Sucesso", 1);
/*     */ 
/*     */       
/* 222 */       String str3 = y.ad(str2);
/* 223 */       if (!SystemUtils.IS_OS_LINUX && !SystemUtils.IS_OS_MAC) {
/* 224 */         y.aa("cmd.exe /c start " + str3);
/*     */       }
/* 226 */     } catch (Exception exception) {
/* 227 */       exception.printStackTrace();
/* 228 */       JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro", 0);
/*     */     } 
/*     */   }
/*     */   public Map<String, List<String>> q() {
/*     */     Map<String, List<String>> map;
/* 233 */     JFileChooser jFileChooser = new JFileChooser(y.fs);
/* 234 */     int i = jFileChooser.showOpenDialog(null);
/* 235 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 237 */     if (i == 0) {
/* 238 */       File file = jFileChooser.getSelectedFile();
/*     */       
/* 240 */       map = a(file);
/*     */       
/* 242 */       if (map.isEmpty()) {
/* 243 */         JOptionPane.showMessageDialog(null, "Não foi possível realizar a leitura das informações, entre em contato com Suporte da Effecti", "Erro", 0);
/*     */       }
/*     */     } 
/*     */     
/* 247 */     return map;
/*     */   }
/*     */   protected Map<String, List<String>> a(File paramFile) throws HeadlessException {
/*     */     Map<String, List<String>> map;
/* 251 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 253 */     if (paramFile != null)
/* 254 */     { String str = FilenameUtils.getExtension(paramFile.getAbsolutePath()).toLowerCase();
/*     */       
/* 256 */       switch (str)
/*     */       { case "xls":
/* 258 */           map = c(paramFile);
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
/* 271 */           return map;case "xlsx": map = d(paramFile); return map;case "csv": map = b(paramFile); return map; }  JOptionPane.showMessageDialog(null, "São permitidos apenas arquivos (XLS, XLSX, CSV)", "Erro", 0); }  return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void d(Map<String, List<String>> paramMap) {
/* 280 */     int i = this.a.D().size();
/*     */     
/* 282 */     if (i != paramMap.size()) {
/* 283 */       String str1 = "Existem " + paramMap.size() + " item(ns) na planilha e " + i + " item(ns) orçados. Deseja importar mesmo assim?";
/*     */       
/* 285 */       int j = JOptionPane.showConfirmDialog(null, str1, "Informação", 0, 1);
/*     */ 
/*     */       
/* 288 */       if (j != 0) {
/*     */         return;
/*     */       }
/*     */     } 
/* 292 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 293 */     StringBuilder stringBuilder1 = new StringBuilder();
/* 294 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 295 */     String str = "";
/*     */ 
/*     */     
/* 298 */     byte b1 = 0;
/* 299 */     byte b2 = 0;
/*     */     
/* 301 */     Iterator<String> iterator = paramMap.keySet().iterator(); while (true) { if (iterator.hasNext()) { String str1 = iterator.next();
/* 302 */         List<String> list = paramMap.get(str1);
/* 303 */         String str2 = list.get(0);
/* 304 */         String str3 = list.get(1);
/* 305 */         String str4 = list.get(2);
/* 306 */         String str5 = list.get(3);
/*     */         
/* 308 */         String str6 = (this.a.a().a() == m.c) ? list.get(4) : "";
/*     */ 
/*     */ 
/*     */         
/* 312 */         Iterator<k> iterator1 = this.a.D().iterator(); while (true) { if (iterator1.hasNext()) { k k = iterator1.next();
/* 313 */             if (k.bZ().equals(str1)) {
/* 314 */               String str7 = k.bE();
/* 315 */               Double[] arrayOfDouble = { Double.valueOf(0.0D), Double.valueOf(0.0D) };
/* 316 */               StringBuilder stringBuilder = new StringBuilder();
/*     */               
/*     */               try {
/* 319 */                 b b = k.a().b();
/* 320 */                 int j = k.a().v();
/*     */                 
/* 322 */                 if (str2 != null && !str2.isEmpty() && Double.parseDouble(str2) > 0.0D) {
/* 323 */                   stringBuilder.append(" itevalorminimo = ").append(a(str2, b));
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/* 328 */                 boolean bool1 = (str3 != null && str3.length() > 0 && Double.parseDouble(str3) > 0.0D) ? true : false;
/*     */ 
/*     */                 
/* 331 */                 boolean bool2 = (str4 != null && str4.length() > 0 && Double.parseDouble(str4) > 0.0D) ? true : false;
/*     */                 
/* 333 */                 if (bool1 || bool2) {
/* 334 */                   if (bool1 && bool2) {
/* 335 */                     arrayOfDouble[0] = Double.valueOf(Double.parseDouble(str3));
/* 336 */                     arrayOfDouble[1] = Double.valueOf(Double.parseDouble(str4));
/* 337 */                   } else if (bool1) {
/* 338 */                     arrayOfDouble[0] = Double.valueOf(Double.parseDouble(str3));
/* 339 */                     arrayOfDouble[1] = arrayOfDouble[0];
/* 340 */                     str4 = str3;
/* 341 */                   } else if (bool2) {
/* 342 */                     arrayOfDouble[1] = Double.valueOf(Double.parseDouble(str4));
/* 343 */                     arrayOfDouble[0] = arrayOfDouble[1];
/* 344 */                     str3 = str4;
/*     */                   } 
/*     */                   
/* 347 */                   if (stringBuilder.length() != 0) {
/* 348 */                     stringBuilder.append(", ");
/*     */                   }
/*     */                   
/* 351 */                   stringBuilder.append(" itevalorreducaoini = ").append(str3);
/* 352 */                   stringBuilder.append(", ");
/* 353 */                   stringBuilder.append(" itevalorreducaofim = ").append(str4);
/*     */                 } 
/*     */                 
/* 356 */                 if (str5 != null && str5.length() > 0) {
/* 357 */                   if (stringBuilder.length() != 0) {
/* 358 */                     stringBuilder.append(", ");
/*     */                   }
/*     */ 
/*     */                   
/* 362 */                   int i1 = str5.toLowerCase().equals("valor") ? w.a.y() : w.b.y();
/* 363 */                   stringBuilder.append(" itetiporeducao = ").append(i1);
/*     */                 } 
/*     */                 
/* 366 */                 if (!str6.isEmpty() && Double.parseDouble(str6) > 0.0D) {
/* 367 */                   if (stringBuilder.length() != 0) {
/* 368 */                     stringBuilder.append(", ");
/*     */                   }
/* 370 */                   stringBuilder.append(" itevalorlancefechado = ").append(a(str6, b));
/*     */                 } 
/*     */                 
/* 373 */                 if (stringBuilder.length() != 0) {
/* 374 */                   stringBuilder.append(", ");
/*     */                 }
/*     */                 
/* 377 */                 j j1 = this.a.a();
/* 378 */                 n n = j1.b();
/* 379 */                 br.com.arremate.l.d d1 = j1.a();
/* 380 */                 m m = j1.a();
/*     */                 
/* 382 */                 stringBuilder.append("iteinicioenviolances = ").append(b.a(j1).v());
/* 383 */                 stringBuilder.append(", itedisputameepp = ").append(b.a(n, d1, m));
/* 384 */                 stringBuilder.append(", iteenviarlancevlrminimo = ").append(b.aD());
/* 385 */                 stringBuilder.append(", itedisputasegundoquinto = ").append(b.aE());
/* 386 */                 stringBuilder.append(", iteenviarlanceviradaminuto = ").append(b.aG());
/* 387 */                 stringBuilder.append(", itecobrirlanceviradaminuto = ").append(b.aH());
/* 388 */                 stringBuilder.append(", itepercentualdisputameepp = ").append(b.h());
/* 389 */                 stringBuilder.append(", itearredondarcasasdecimais = ").append(b.E());
/* 390 */                 stringBuilder.append(", itetoptres = ").append(b.aJ());
/* 391 */                 stringBuilder.append(", itemanterdezporcentoprimeirolugar = ").append(b.aK());
/* 392 */                 stringBuilder.append(", itepercentualprimeirolugar = ").append(b.i());
/* 393 */                 stringBuilder.append(", iteexcluircompetidor = ").append(b.aL());
/* 394 */                 stringBuilder.append(", iteposicaoexcluircompetidor = ").append(b.F());
/* 395 */                 stringBuilder.append(", itetempoextraentrelances = ").append(b.t());
/* 396 */                 stringBuilder.append(", itemomentoenviarlanceaberto = ").append(b.u());
/* 397 */                 stringBuilder.append(", itemomentoenviarlancefechado = ").append(b.w());
/*     */ 
/*     */                 
/* 400 */                 if (str7 != null && !str7.isEmpty()) {
/* 401 */                   if (!hashMap.containsKey(str7)) {
/* 402 */                     hashMap.put(str7, arrayOfDouble);
/* 403 */                   } else if (!str.contains(str7) && (
/* 404 */                     Double.compare(arrayOfDouble[0].doubleValue(), ((Double[])hashMap.get(str7))[0].doubleValue()) != 0 || 
/* 405 */                     Double.compare(arrayOfDouble[1].doubleValue(), ((Double[])hashMap.get(str7))[1].doubleValue()) != 0)) {
/* 406 */                     if (!str.isEmpty()) {
/* 407 */                       str = str + ", ";
/*     */                     }
/* 409 */                     str = str + str7;
/* 410 */                     Double double_1 = ((Double[])hashMap.get(str7))[0];
/* 411 */                     Double double_2 = ((Double[])hashMap.get(str7))[1];
/* 412 */                     String str8 = "UPDATE tbitemlicitacao SET ";
/*     */                     
/* 414 */                     if (double_1.doubleValue() > 0.0D) {
/* 415 */                       str8 = str8 + "itevalorreducaoini = " + double_1;
/*     */                     }
/*     */                     
/* 418 */                     if (double_2.doubleValue() > 0.0D) {
/* 419 */                       if (double_1.doubleValue() > 0.0D) {
/* 420 */                         str8 = str8 + ", ";
/*     */                       }
/* 422 */                       str8 = str8 + "itevalorreducaofim = " + double_2;
/*     */                     } 
/*     */                     
/* 425 */                     if (double_1.doubleValue() > 0.0D || double_2.doubleValue() > 0.0D) {
/* 426 */                       str8 = str8 + " WHERE empcnpj = " + j1.C() + " AND liccodigo = " + j1.v() + " AND itegrupo = '" + str7 + "';";
/* 427 */                       stringBuilder2.append(str8);
/* 428 */                       b2++;
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */                 
/* 433 */                 if (stringBuilder.length() != 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 438 */                   String str8 = "UPDATE tbitemlicitacao SET " + stringBuilder.toString() + " WHERE empcnpj = " + j1.C() + " AND liccodigo = " + j1.v() + " AND itecodigo = " + j + " AND porcodigo = " + n.v() + ";";
/* 439 */                   stringBuilder1.append(str8);
/* 440 */                   b1++;
/*     */                 }  break;
/* 442 */               } catch (Exception exception) {
/* 443 */                 exception.printStackTrace();
/*     */               } 
/*     */             } else {
/*     */               continue;
/*     */             }  }
/*     */           else
/*     */           { break; }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 454 */           if (b1 >= 100) {
/* 455 */             aI(stringBuilder1.toString());
/*     */ 
/*     */             
/* 458 */             stringBuilder1 = new StringBuilder();
/* 459 */             b1 = 0;
/*     */           } 
/*     */           
/* 462 */           if (b2 >= 100)
/* 463 */           { aJ(stringBuilder2.toString());
/*     */ 
/*     */             
/* 466 */             stringBuilder2 = new StringBuilder();
/* 467 */             b2 = 0; }  }  } else { break; }  if (b1 >= 100) { aI(stringBuilder1.toString()); stringBuilder1 = new StringBuilder(); b1 = 0; }  if (b2 >= 100) { aJ(stringBuilder2.toString()); stringBuilder2 = new StringBuilder(); b2 = 0; }
/*     */        }
/*     */ 
/*     */     
/* 471 */     if (stringBuilder1.length() > 0) {
/* 472 */       aI(stringBuilder1.toString());
/*     */     }
/*     */     
/* 475 */     if (stringBuilder2.length() > 0) {
/* 476 */       aJ(stringBuilder2.toString());
/*     */     }
/*     */     
/* 479 */     if (!str.isEmpty()) {
/* 480 */       String str1 = "<html><body><div width='300px' align='left'>Não é possivel informar valores de variação diferentes para itens de um mesmo grupo. </br>Grupo(s) " + str + " apresentou variação inicial e/ou final diferentes, será assumido os valores de variação do primeiro item aos demais itens do mesmo grupo.</div></body></html>";
/* 481 */       JLabel jLabel = new JLabel(str1);
/* 482 */       JOptionPane.showMessageDialog(null, jLabel, "Alerta", 2);
/*     */     } 
/* 484 */     JOptionPane.showMessageDialog(null, "Arquivo importado com sucesso", "Sucesso", 1);
/*     */     
/* 486 */     if (!this.eu.isEmpty()) {
/* 487 */       JOptionPane.showMessageDialog(null, this.eu, "Alerta", 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private int b(String paramString) {
/* 492 */     int i = paramString.indexOf(".");
/* 493 */     if (i == -1) {
/* 494 */       return -1;
/*     */     }
/* 496 */     return paramString.length() - i - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean a(int paramInt1, int paramInt2) {
/* 501 */     return ((paramInt1 == -1 && paramInt2 >= 4) || paramInt1 <= 4 - paramInt2);
/*     */   }
/*     */   
/*     */   private String e(String paramString, int paramInt) {
/* 505 */     int i = 4 - paramInt;
/* 506 */     if (i < 0) {
/* 507 */       i = 0;
/*     */     }
/*     */     
/* 510 */     return (new BigDecimal(paramString)).setScale(i, RoundingMode.HALF_UP).toPlainString();
/*     */   }
/*     */   
/*     */   private String a(String paramString, b paramb) {
/* 514 */     boolean bool = a(b(paramString), paramb.E());
/*     */     
/* 516 */     if (!bool) {
/* 517 */       paramString = e(paramString, paramb.E());
/*     */       
/* 519 */       if (this.eu.isEmpty()) {
/* 520 */         this.eu = "Foram arredondados os limites dos itens que possuiam mais casas decimais do que o configurado.\nNúmero configurado no arredondamento de lance: " + paramb.E();
/*     */       }
/*     */     } 
/* 523 */     return paramString;
/*     */   }
/*     */   
/*     */   private void aI(String paramString) {
/* 527 */     try (Statement null = a.a().createStatement()) {
/* 528 */       if (paramString.length() > 0) {
/* 529 */         statement.executeUpdate(paramString);
/*     */       }
/* 531 */     } catch (SQLException sQLException) {
/* 532 */       sQLException.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aJ(String paramString) {
/* 537 */     try (Statement null = a.a().createStatement()) {
/* 538 */       if (paramString.length() > 0) {
/* 539 */         statement.executeUpdate(paramString);
/*     */       }
/* 541 */     } catch (SQLException sQLException) {
/* 542 */       sQLException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<String>> b(File paramFile) {
/* 553 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     try {
/* 556 */       BufferedReader bufferedReader = new BufferedReader(new FileReader(paramFile));
/*     */       
/*     */       String str;
/* 559 */       while ((str = bufferedReader.readLine()) != null) {
/* 560 */         String[] arrayOfString = str.split(";");
/* 561 */         String str1 = arrayOfString[((Integer)this.a.o().get(c.a)).intValue()];
/* 562 */         String str2 = arrayOfString[((Integer)this.a.o().get(c.c)).intValue()];
/* 563 */         String str3 = arrayOfString[((Integer)this.a.o().get(c.d)).intValue()];
/* 564 */         String str4 = arrayOfString[((Integer)this.a.o().get(c.e)).intValue()];
/* 565 */         String str5 = arrayOfString[((Integer)this.a.o().get(c.f)).intValue()];
/*     */         
/* 567 */         String str6 = null;
/* 568 */         boolean bool = (this.a.a().a() == m.c) ? true : false;
/*     */         
/* 570 */         if (bool) {
/* 571 */           str6 = arrayOfString[((Integer)this.a.o().get(c.g)).intValue()];
/*     */         }
/*     */         
/* 574 */         if (NumberUtils.isCreatable(str1.replaceAll("[^\\d.]", "")) && str2 != null && !str2.isEmpty()) {
/* 575 */           ArrayList<String> arrayList = new ArrayList();
/* 576 */           arrayList.add(str2);
/* 577 */           arrayList.add(str3);
/* 578 */           arrayList.add(str4);
/* 579 */           arrayList.add(str5);
/*     */           
/* 581 */           if (bool) {
/* 582 */             arrayList.add(str6);
/*     */           }
/*     */           
/* 585 */           if (Pattern.compile("[^\\d.]").matcher(str1).find()) {
/* 586 */             hashMap.put(str1, arrayList);
/*     */             continue;
/*     */           } 
/* 589 */           int i = (new Double(str1)).intValue();
/* 590 */           hashMap.put(Integer.toString(i), arrayList);
/*     */         }
/*     */       
/*     */       } 
/* 594 */     } catch (Exception exception) {
/* 595 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 598 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<String>> c(File paramFile) {
/* 606 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     try {
/* 609 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 610 */       HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(fileInputStream);
/* 611 */       HSSFSheet hSSFSheet = hSSFWorkbook.getSheetAt(0);
/* 612 */       Iterator<HSSFRow> iterator = hSSFSheet.rowIterator();
/* 613 */       HSSFFormulaEvaluator hSSFFormulaEvaluator = hSSFWorkbook.getCreationHelper().createFormulaEvaluator();
/*     */       
/* 615 */       while (iterator.hasNext()) {
/* 616 */         HSSFRow hSSFRow = iterator.next();
/* 617 */         HSSFCell hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.a)).intValue());
/*     */         
/* 619 */         String str1 = a(hSSFCell, new CellType[] { CellType.NUMERIC, CellType.STRING });
/* 620 */         hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.c)).intValue());
/*     */         
/* 622 */         if (hSSFCell != null && hSSFCell.getCellType() == 2 && hSSFFormulaEvaluator != null)
/*     */         {
/* 624 */           hSSFFormulaEvaluator.evaluate((Cell)hSSFCell);
/*     */         }
/* 626 */         String str2 = a(hSSFCell, new CellType[] { CellType.NUMERIC, CellType.FORMULA });
/*     */         
/* 628 */         hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.d)).intValue());
/* 629 */         String str3 = a(hSSFCell, new CellType[] { CellType.NUMERIC });
/*     */         
/* 631 */         hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.e)).intValue());
/* 632 */         String str4 = a(hSSFCell, new CellType[] { CellType.NUMERIC });
/*     */         
/* 634 */         hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.f)).intValue());
/* 635 */         String str5 = a(hSSFCell, new CellType[] { CellType.STRING });
/*     */         
/* 637 */         String str6 = null;
/* 638 */         boolean bool = (this.a.a().a() == m.c) ? true : false;
/*     */         
/* 640 */         if (bool) {
/* 641 */           hSSFCell = hSSFRow.getCell(((Integer)this.a.o().get(c.g)).intValue());
/* 642 */           str6 = a(hSSFCell, new CellType[] { CellType.NUMERIC, CellType.FORMULA });
/*     */         } 
/*     */         
/* 645 */         if (NumberUtils.isCreatable(str1.replaceAll("[^\\d.]", "")) && str2 != null && !str2.isEmpty()) {
/* 646 */           ArrayList<String> arrayList = new ArrayList();
/* 647 */           arrayList.add(str2);
/* 648 */           arrayList.add(str3);
/* 649 */           arrayList.add(str4);
/* 650 */           arrayList.add(str5);
/*     */           
/* 652 */           if (bool) {
/* 653 */             arrayList.add(str6);
/*     */           }
/*     */           
/* 656 */           if (Pattern.compile("[^\\d.]").matcher(str1).find()) {
/* 657 */             hashMap.put(str1, arrayList);
/*     */             continue;
/*     */           } 
/* 660 */           int i = (new Double(str1)).intValue();
/* 661 */           hashMap.put(Integer.toString(i), arrayList);
/*     */         }
/*     */       
/*     */       } 
/* 665 */     } catch (Exception exception) {
/* 666 */       exception.printStackTrace();
/*     */     } 
/* 668 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, List<String>> d(File paramFile) {
/* 676 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*     */     try {
/* 679 */       FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 680 */       XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(fileInputStream);
/* 681 */       XSSFSheet xSSFSheet = xSSFWorkbook.getSheetAt(0);
/* 682 */       Iterator<XSSFRow> iterator = xSSFSheet.rowIterator();
/*     */       
/* 684 */       while (iterator.hasNext()) {
/* 685 */         XSSFRow xSSFRow = iterator.next();
/*     */         
/* 687 */         XSSFCell xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.a)).intValue());
/* 688 */         String str1 = a(xSSFCell, new CellType[] { CellType.NUMERIC, CellType.STRING });
/*     */         
/* 690 */         xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.c)).intValue());
/* 691 */         String str2 = a(xSSFCell, new CellType[] { CellType.NUMERIC, CellType.FORMULA });
/*     */         
/* 693 */         xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.d)).intValue());
/* 694 */         String str3 = a(xSSFCell, new CellType[] { CellType.NUMERIC });
/*     */         
/* 696 */         xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.e)).intValue());
/* 697 */         String str4 = a(xSSFCell, new CellType[] { CellType.NUMERIC });
/*     */         
/* 699 */         xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.f)).intValue());
/* 700 */         String str5 = a(xSSFCell, new CellType[] { CellType.STRING });
/*     */         
/* 702 */         String str6 = null;
/* 703 */         boolean bool = (this.a.a().a() == m.c) ? true : false;
/*     */         
/* 705 */         if (bool) {
/* 706 */           xSSFCell = xSSFRow.getCell(((Integer)this.a.o().get(c.g)).intValue());
/* 707 */           str6 = a(xSSFCell, new CellType[] { CellType.NUMERIC, CellType.FORMULA });
/*     */         } 
/*     */         
/* 710 */         if (str1 != null) {
/* 711 */           str1 = str1.replaceFirst("^0+(?!$)", "");
/*     */         }
/*     */         
/* 714 */         if (NumberUtils.isCreatable(str1.replaceAll("[^\\d.]", "")) && str2 != null && !str2.isEmpty()) {
/* 715 */           ArrayList<String> arrayList = new ArrayList();
/* 716 */           arrayList.add(str2);
/* 717 */           arrayList.add(str3);
/* 718 */           arrayList.add(str4);
/* 719 */           arrayList.add(str5);
/*     */           
/* 721 */           if (bool) {
/* 722 */             arrayList.add(str6);
/*     */           }
/*     */           
/* 725 */           if (Pattern.compile("[^\\d.]").matcher(str1).find()) {
/* 726 */             hashMap.put(str1, arrayList);
/*     */             continue;
/*     */           } 
/* 729 */           int i = (new Double(str1)).intValue();
/* 730 */           hashMap.put(Integer.toString(i), arrayList);
/*     */         }
/*     */       
/*     */       } 
/* 734 */     } catch (Exception exception) {
/* 735 */       exception.printStackTrace();
/*     */     } 
/* 737 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private String a(HSSFCell paramHSSFCell, CellType... paramVarArgs) {
/* 741 */     if (paramHSSFCell == null) {
/* 742 */       return "";
/*     */     }
/*     */     
/* 745 */     if (!a(paramVarArgs, (Cell)paramHSSFCell)) {
/* 746 */       return "";
/*     */     }
/* 748 */     String str = "";
/*     */     try {
/*     */       double d1;
/* 751 */       switch (paramHSSFCell.getCellTypeEnum()) {
/*     */         case FORMULA:
/*     */         case NUMERIC:
/* 754 */           d1 = paramHSSFCell.getNumericCellValue();
/*     */           
/* 756 */           if (paramHSSFCell.getCellStyle().getDataFormatString().contains("%")) {
/* 757 */             d1 *= 100.0D;
/*     */           }
/* 759 */           str = Double.toString(d1);
/*     */           break;
/*     */         case STRING:
/* 762 */           str = paramHSSFCell.getStringCellValue();
/*     */           break;
/*     */       } 
/* 765 */     } catch (Exception exception) {
/* 766 */       LOG.warn("Error getting cell value", exception);
/*     */     } 
/* 768 */     return str;
/*     */   }
/*     */   
/*     */   private String a(XSSFCell paramXSSFCell, CellType... paramVarArgs) {
/* 772 */     if (paramXSSFCell == null) {
/* 773 */       return "";
/*     */     }
/*     */     
/* 776 */     if (!a(paramVarArgs, (Cell)paramXSSFCell)) {
/* 777 */       return "";
/*     */     }
/* 779 */     String str = "";
/*     */     try {
/*     */       double d1;
/* 782 */       switch (paramXSSFCell.getCellTypeEnum()) {
/*     */         case NUMERIC:
/* 784 */           d1 = paramXSSFCell.getNumericCellValue();
/*     */           
/* 786 */           if (paramXSSFCell.getCellStyle().getDataFormatString().contains("%")) {
/* 787 */             d1 *= 100.0D;
/*     */           }
/* 789 */           str = Double.toString(d1);
/*     */           break;
/*     */         case STRING:
/* 792 */           str = paramXSSFCell.getStringCellValue();
/*     */           break;
/*     */         case FORMULA:
/* 795 */           str = paramXSSFCell.getRawValue();
/*     */           break;
/*     */       } 
/* 798 */     } catch (Exception exception) {
/* 799 */       LOG.warn("Error getting cell value", exception);
/*     */     } 
/* 801 */     return str;
/*     */   }
/*     */   
/*     */   private boolean a(CellType[] paramArrayOfCellType, Cell paramCell) {
/* 805 */     for (CellType cellType : paramArrayOfCellType) {
/* 806 */       if (paramCell.getCellTypeEnum() == cellType) {
/* 807 */         return true;
/*     */       }
/*     */     } 
/* 810 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */