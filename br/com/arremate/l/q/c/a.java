/*     */ package br.com.arremate.l.q.c;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Color;
/*     */ import java.awt.HeadlessException;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FileWriter;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.apache.commons.lang3.mutable.MutableInt;
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellStyle;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.FillPatternType;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.IndexedColors;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*     */ import org.apache.poi.xssf.usermodel.XSSFCellStyle;
/*     */ import org.apache.poi.xssf.usermodel.XSSFColor;
/*     */ import org.apache.poi.xssf.usermodel.XSSFDataFormat;
/*     */ import org.apache.poi.xssf.usermodel.XSSFFont;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*     */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  50 */   private static final Logger a = LoggerFactory.getLogger(a.class.getClass());
/*     */   
/*     */   protected static final int cp = 20000;
/*     */   
/*     */   private final k a;
/*     */   private final g a;
/*     */   
/*     */   protected a(k paramk, g paramg) {
/*  58 */     this.a = (g)paramk;
/*  59 */     this.a = paramg;
/*     */   }
/*     */   
/*     */   private String cr() {
/*  63 */     String str = "";
/*  64 */     try (Statement null = br.com.arremate.e.a.a().createStatement()) {
/*  65 */       try (ResultSet null = statement.executeQuery("SELECT caminhoexportacao FROM tbconfiguracao WHERE concodigo = 1")) {
/*  66 */         if (resultSet.next()) {
/*  67 */           str = resultSet.getString("caminhoexportacao");
/*     */         }
/*     */       } 
/*  70 */       return str;
/*  71 */     } catch (Exception exception) {
/*  72 */       a.error("Erro ao criar arquivo de exportação", exception);
/*  73 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/*     */     try {
/*  79 */       n n = (n)this.a.getModel();
/*  80 */       this.a.a(paramb, n);
/*  81 */       if (a(n)) {
/*     */         return;
/*     */       }
/*  84 */       Calendar calendar = this.a.a().h();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  91 */       String str1 = "resultado_" + ((calendar != null) ? (y.formatDate(calendar.getTime(), "ddMMyyyy") + "_") : "") + Integer.toString(this.a.a().K()) + "_" + this.a.aU();
/*  92 */       str1 = str1.replaceAll("\\W", "");
/*     */       
/*  94 */       if (!cs().isEmpty()) {
/*  95 */         str1 = "crm_" + str1;
/*     */       }
/*     */       
/*  98 */       String str2 = cr();
/*  99 */       if (str2 == null || str2.isEmpty()) {
/* 100 */         str2 = y.fs;
/*     */       }
/*     */       
/* 103 */       String str3 = str2 + y.FILE_SEPARATOR + str1;
/* 104 */       if (SystemUtils.IS_OS_MAC) {
/* 105 */         str3 = str2 + y.FILE_SEPARATOR + "Desktop" + y.FILE_SEPARATOR + str1;
/*     */       }
/*     */       
/* 108 */       if (!k(str3)) {
/*     */         return;
/*     */       }
/*     */       
/* 112 */       XSSFWorkbook xSSFWorkbook = new XSSFWorkbook();
/* 113 */       XSSFSheet xSSFSheet = xSSFWorkbook.createSheet(str1);
/*     */       
/* 115 */       a(xSSFWorkbook, xSSFSheet);
/* 116 */       a(xSSFSheet, (k)this.a);
/* 117 */       a(xSSFSheet);
/*     */       
/* 119 */       if (cs().equals(".csv")) {
/* 120 */         str3 = str3 + ".csv";
/* 121 */         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str3));
/* 122 */         bufferedWriter.write(a(xSSFSheet));
/* 123 */         bufferedWriter.close();
/*     */       } else {
/* 125 */         str3 = str3 + ".xlsx";
/* 126 */         try (FileOutputStream null = new FileOutputStream(str3)) {
/* 127 */           xSSFWorkbook.write(fileOutputStream);
/* 128 */           fileOutputStream.flush();
/*     */         } 
/*     */       } 
/*     */       
/* 132 */       JOptionPane.showMessageDialog(null, "Exportação dos itens realizada com sucesso. \nO arquivo encontra-se em " + str2 + " com o nome: \"" + str1 + "\".", "Sucesso", 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       String str4 = y.ad(str3);
/* 139 */       if (!SystemUtils.IS_OS_LINUX && !SystemUtils.IS_OS_MAC) {
/* 140 */         y.aa("cmd.exe /c start " + str4);
/*     */       }
/* 142 */     } catch (HeadlessException|java.io.IOException headlessException) {
/* 143 */       a.error("Error ao criar arquivo de exportação", headlessException);
/* 144 */       JOptionPane.showMessageDialog(null, headlessException.getMessage(), "Erro", 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String a(XSSFSheet paramXSSFSheet) {
/* 149 */     NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
/* 150 */     numberFormat.setMaximumFractionDigits(4);
/* 151 */     numberFormat.setMinimumFractionDigits(4);
/* 152 */     numberFormat.setMinimumIntegerDigits(1);
/*     */     
/* 154 */     byte b = 0;
/* 155 */     StringBuilder stringBuilder = new StringBuilder();
/* 156 */     Iterator<Row> iterator = paramXSSFSheet.rowIterator();
/* 157 */     while (iterator.hasNext()) {
/* 158 */       Row row = iterator.next();
/* 159 */       Iterator<Cell> iterator1 = row.cellIterator();
/* 160 */       while (iterator1.hasNext()) {
/* 161 */         Cell cell = iterator1.next();
/* 162 */         CellType cellType = cell.getCellTypeEnum();
/* 163 */         if (cellType == CellType.NUMERIC) {
/* 164 */           stringBuilder.append(numberFormat.format(cell.getNumericCellValue()));
/* 165 */         } else if (cellType == CellType.STRING) {
/* 166 */           stringBuilder.append(cell.getStringCellValue().replaceAll(";", " "));
/*     */         } else {
/* 168 */           stringBuilder.append(" ");
/*     */         } 
/* 170 */         b++;
/* 171 */         stringBuilder.append(";");
/*     */       } 
/*     */       
/* 174 */       if (b < 16) {
/* 175 */         byte b1 = 2;
/* 176 */         if (b == 4) {
/* 177 */           b1 = 1;
/* 178 */         } else if (b % 4 == 0) {
/* 179 */           b1 = 0;
/*     */         } 
/* 181 */         for (byte b2 = b; b2 <= 16; b2++) {
/* 182 */           stringBuilder.insert(stringBuilder.lastIndexOf(";", stringBuilder.length() - b1), ";");
/*     */         }
/*     */       } 
/*     */       
/* 186 */       b = 0;
/* 187 */       stringBuilder.append(System.lineSeparator());
/*     */     } 
/*     */     
/* 190 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean k(String paramString) {
/* 201 */     File file = new File(paramString);
/*     */     
/* 203 */     if (!file.exists()) {
/* 204 */       return true;
/*     */     }
/*     */     
/* 207 */     int i = JOptionPane.showConfirmDialog(null, "Já existe um arquivo com o nome \"" + file
/*     */         
/* 209 */         .getName() + "\" na pasta de destino, deseja sobrescrever?", "Informação", 0, 1);
/*     */ 
/*     */ 
/*     */     
/* 213 */     return (i == 0);
/*     */   }
/*     */   
/*     */   protected boolean a(n paramn) {
/* 217 */     return false;
/*     */   }
/*     */   
/*     */   protected String cs() {
/* 221 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(XSSFWorkbook paramXSSFWorkbook, XSSFSheet paramXSSFSheet) {
/* 231 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(0);
/* 232 */     XSSFCellStyle xSSFCellStyle = a(paramXSSFWorkbook, true);
/* 233 */     MutableInt mutableInt = new MutableInt(1);
/*     */     
/* 235 */     if (bz()) {
/* 236 */       a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Posição" });
/*     */     }
/*     */     
/* 239 */     a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Item", "Descrição" });
/*     */     
/* 241 */     if (n.bQ()) {
/* 242 */       a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "CNPJ", "Nome Empresa", "Porte", "Modelo", "Marca", "Fabricante" });
/*     */     }
/*     */     
/* 245 */     a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Quantidade", "Unidade de medida" });
/*     */     
/* 247 */     if (bz()) {
/* 248 */       a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Valor Unitário", "Valor Total" });
/*     */     } else {
/* 250 */       a(xSSFCellStyle, xSSFRow, mutableInt, new String[] { "Seu último lance", "Melhor lance (unt)", "Melhor lance (tot)" });
/*     */     } 
/*     */     
/* 253 */     paramXSSFSheet.setColumnWidth(0, 1000);
/*     */   }
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet, k paramk) {
/* 257 */     byte b = 0;
/* 258 */     n n = (n)paramk.getModel();
/*     */     
/* 260 */     for (f f : n.M())
/* 261 */       a(f, b++, paramXSSFSheet); 
/*     */   }
/*     */   
/*     */   protected void a(f paramf, int paramInt, XSSFSheet paramXSSFSheet) {
/*     */     XSSFCellStyle xSSFCellStyle1, xSSFCellStyle2;
/* 266 */     e e = paramf.b();
/*     */     
/* 268 */     int i = paramInt + 1;
/* 269 */     MutableInt mutableInt = new MutableInt(0);
/* 270 */     XSSFRow xSSFRow = paramXSSFSheet.createRow(i);
/*     */ 
/*     */ 
/*     */     
/* 274 */     if (!bz() && paramInt % 2 == 0) {
/* 275 */       xSSFCellStyle1 = a(a(paramXSSFSheet.getWorkbook(), bz()));
/* 276 */       xSSFCellStyle2 = a(a(paramXSSFSheet.getWorkbook()));
/*     */     } else {
/* 278 */       xSSFCellStyle1 = b(a(paramXSSFSheet.getWorkbook(), bz()));
/* 279 */       xSSFCellStyle2 = b(a(paramXSSFSheet.getWorkbook()));
/*     */     } 
/*     */     
/* 282 */     a(a(e, paramXSSFSheet), xSSFRow, mutableInt, new String[] { " " });
/*     */     
/* 284 */     if (bz()) {
/* 285 */       a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { " " });
/*     */     }
/*     */     
/* 288 */     String str = e.K();
/*     */     
/* 290 */     if (!(e instanceof br.com.arremate.l.q.b.f) && !e.a().bD().isEmpty()) {
/* 291 */       str = str + " (" + e.a().bD() + ")";
/*     */     }
/*     */     
/* 294 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { e.bo(), str });
/*     */     
/* 296 */     if (n.bQ()) {
/* 297 */       if (bz()) {
/* 298 */         a(xSSFCellStyle2, xSSFRow, mutableInt, new String[] { " ", " ", " ", " ", " ", " " });
/*     */       } else {
/* 300 */         a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { paramf
/*     */ 
/*     */ 
/*     */               
/* 304 */               .h().av(), paramf
/* 305 */               .h().ay(), paramf
/* 306 */               .h().bL(), paramf
/* 307 */               .h().bK(), paramf
/* 308 */               .h().bH(), paramf
/* 309 */               .h().bI() });
/*     */       } 
/*     */     }
/*     */     
/* 313 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new Double[] { Double.valueOf(e.i()) });
/* 314 */     a(xSSFCellStyle1, xSSFRow, mutableInt, new String[] { (e instanceof br.com.arremate.l.q.b.f) ? " " : e.a().bF() });
/*     */     
/* 316 */     if (bz()) {
/* 317 */       a(xSSFCellStyle2, xSSFRow, mutableInt, new String[] { " ", " " });
/*     */     } else {
/* 319 */       a(xSSFCellStyle2, xSSFRow, mutableInt, new Double[] { Double.valueOf(e.f()), Double.valueOf(c(e)), Double.valueOf(d(e)) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSSFCellStyle a(e parame, XSSFSheet paramXSSFSheet) {
/* 325 */     switch (null.j[parame.a().ordinal()]) {
/*     */       case 1:
/* 327 */         return c(paramXSSFSheet.getWorkbook().createCellStyle());
/*     */       case 2:
/* 329 */         return d(paramXSSFSheet.getWorkbook().createCellStyle());
/*     */       case 3:
/* 331 */         return e(paramXSSFSheet.getWorkbook().createCellStyle());
/*     */     } 
/* 333 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(XSSFSheet paramXSSFSheet) {
/* 339 */     byte b1 = n.bQ() ? 13 : 7;
/* 340 */     for (byte b2 = 1; b2 <= b1; b2++) {
/* 341 */       paramXSSFSheet.autoSizeColumn(b2);
/*     */     }
/* 343 */     paramXSSFSheet.setColumnWidth(X(), 20000);
/*     */   }
/*     */   
/*     */   protected int X() {
/* 347 */     return 2;
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle a(XSSFWorkbook paramXSSFWorkbook) {
/* 351 */     XSSFCellStyle xSSFCellStyle = paramXSSFWorkbook.createCellStyle();
/* 352 */     XSSFDataFormat xSSFDataFormat = paramXSSFWorkbook.createDataFormat();
/* 353 */     xSSFCellStyle.setDataFormat(xSSFDataFormat.getFormat("###,###,###,##0.0000"));
/*     */     
/* 355 */     return xSSFCellStyle;
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle a(XSSFWorkbook paramXSSFWorkbook, boolean paramBoolean) {
/* 359 */     return a(paramXSSFWorkbook.createFont(), paramXSSFWorkbook.createCellStyle(), paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XSSFCellStyle a(XSSFFont paramXSSFFont, XSSFCellStyle paramXSSFCellStyle, boolean paramBoolean) {
/* 364 */     paramXSSFFont.setFontHeightInPoints((short)10);
/* 365 */     paramXSSFFont.setFontName("Arial");
/* 366 */     paramXSSFFont.setColor(IndexedColors.BLACK.getIndex());
/* 367 */     paramXSSFFont.setBold(paramBoolean);
/* 368 */     paramXSSFFont.setItalic(false);
/*     */     
/* 370 */     paramXSSFCellStyle.setFont((Font)paramXSSFFont);
/*     */     
/* 372 */     return paramXSSFCellStyle;
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle a(XSSFCellStyle paramXSSFCellStyle) {
/* 376 */     paramXSSFCellStyle.setFillForegroundColor(new XSSFColor(new Color(230, 230, 230)));
/*     */     
/* 378 */     return f(paramXSSFCellStyle);
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle b(XSSFCellStyle paramXSSFCellStyle) {
/* 382 */     paramXSSFCellStyle.setFillForegroundColor(new XSSFColor(Color.LIGHT_GRAY));
/*     */     
/* 384 */     return f(paramXSSFCellStyle);
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle c(XSSFCellStyle paramXSSFCellStyle) {
/* 388 */     paramXSSFCellStyle.setFillForegroundColor(new XSSFColor(new Color(140, 207, 183)));
/*     */     
/* 390 */     return f(paramXSSFCellStyle);
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle d(XSSFCellStyle paramXSSFCellStyle) {
/* 394 */     paramXSSFCellStyle.setFillForegroundColor(new XSSFColor(new Color(255, 128, 128)));
/*     */     
/* 396 */     return f(paramXSSFCellStyle);
/*     */   }
/*     */   
/*     */   protected XSSFCellStyle e(XSSFCellStyle paramXSSFCellStyle) {
/* 400 */     paramXSSFCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
/*     */     
/* 402 */     return f(paramXSSFCellStyle);
/*     */   }
/*     */   
/*     */   private XSSFCellStyle f(XSSFCellStyle paramXSSFCellStyle) {
/* 406 */     paramXSSFCellStyle.setBorderTop(BorderStyle.THIN);
/* 407 */     paramXSSFCellStyle.setBorderBottom(BorderStyle.THIN);
/* 408 */     paramXSSFCellStyle.setBorderLeft(BorderStyle.THIN);
/* 409 */     paramXSSFCellStyle.setBorderRight(BorderStyle.THIN);
/* 410 */     paramXSSFCellStyle.setBorderColor(XSSFCellBorder.BorderSide.RIGHT, new XSSFColor(Color.WHITE));
/* 411 */     paramXSSFCellStyle.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM, new XSSFColor(Color.WHITE));
/* 412 */     paramXSSFCellStyle.setBorderColor(XSSFCellBorder.BorderSide.LEFT, new XSSFColor(Color.WHITE));
/* 413 */     paramXSSFCellStyle.setBorderColor(XSSFCellBorder.BorderSide.TOP, new XSSFColor(Color.WHITE));
/* 414 */     paramXSSFCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
/* 415 */     return paramXSSFCellStyle;
/*     */   }
/*     */   
/*     */   protected void a(XSSFCellStyle paramXSSFCellStyle, XSSFRow paramXSSFRow, MutableInt paramMutableInt, String... paramVarArgs) {
/* 419 */     for (String str : paramVarArgs) {
/* 420 */       XSSFCell xSSFCell = paramXSSFRow.createCell(paramMutableInt.getAndIncrement());
/* 421 */       xSSFCell.setCellValue(str);
/* 422 */       xSSFCell.setCellStyle((CellStyle)paramXSSFCellStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(XSSFCellStyle paramXSSFCellStyle, XSSFRow paramXSSFRow, MutableInt paramMutableInt, Double... paramVarArgs) {
/* 427 */     for (Double double_ : paramVarArgs) {
/* 428 */       XSSFCell xSSFCell = paramXSSFRow.createCell(paramMutableInt.getAndIncrement());
/* 429 */       xSSFCell.setCellValue(double_.doubleValue());
/* 430 */       xSSFCell.setCellStyle((CellStyle)paramXSSFCellStyle);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected double c(e parame) {
/* 435 */     boolean bool = (parame.a().aZ() || (!parame.ay() && parame.a().aZ())) ? true : false;
/* 436 */     double d = parame.f().m();
/* 437 */     return bool ? d : (d / parame.i());
/*     */   }
/*     */   
/*     */   protected double d(e parame) {
/* 441 */     boolean bool = (parame.a().aZ() || (!parame.ay() && parame.a().aZ())) ? true : false;
/* 442 */     double d = parame.f().m();
/* 443 */     return bool ? (d * parame.i()) : d;
/*     */   }
/*     */   
/*     */   protected boolean bz() {
/* 447 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */