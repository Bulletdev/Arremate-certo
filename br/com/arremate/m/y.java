/*      */ package br.com.arremate.m;
/*      */ 
/*      */ import br.com.arremate.a.k;
/*      */ import br.com.arremate.f.v;
/*      */ import br.com.arremate.l.q.b.e;
/*      */ import br.com.arremate.l.q.b.i;
/*      */ import br.com.arremate.l.q.c.f;
/*      */ import br.com.arremate.l.q.c.p;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Desktop;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.RoundingMode;
/*      */ import java.net.InetAddress;
/*      */ import java.net.URI;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ import java.nio.file.Files;
/*      */ import java.nio.file.Paths;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.DecimalFormatSymbols;
/*      */ import java.text.Normalizer;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Base64;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collections;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.zip.GZIPInputStream;
/*      */ import java.util.zip.GZIPOutputStream;
/*      */ import javax.crypto.Cipher;
/*      */ import javax.crypto.spec.IvParameterSpec;
/*      */ import javax.crypto.spec.SecretKeySpec;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.filechooser.FileSystemView;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableModel;
/*      */ import javax.swing.text.MaskFormatter;
/*      */ import org.apache.commons.io.IOUtils;
/*      */ import org.apache.commons.lang3.StringUtils;
/*      */ import org.apache.commons.lang3.SystemUtils;
/*      */ import org.apache.commons.net.ntp.NTPUDPClient;
/*      */ import org.apache.commons.net.ntp.NtpV3Packet;
/*      */ import org.apache.commons.net.ntp.TimeInfo;
/*      */ import org.apache.commons.net.ntp.TimeStamp;
/*      */ import org.e.f;
/*      */ import org.e.g;
/*      */ import org.e.i;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class y
/*      */ {
/*      */   public static final String eE = "a.ntp.br";
/*      */   public static final String eF = "./backup";
/*   72 */   public static final String eG = System.getProperty("user.home") + "/Library/Application Support/Arremate";
/*      */   
/*      */   public static final String eH = "/img/arrow_circle.png";
/*      */   
/*      */   public static final String eI = "/img/loading-blue.gif";
/*      */   
/*      */   public static final String eJ = "/img/loading-green.gif";
/*      */   
/*      */   public static final String eK = "/img/loading-orange.gif";
/*      */   public static final String eL = "/img/loading-red.gif";
/*      */   public static final String eM = "/img/exclamation.png";
/*      */   public static final String eN = "/img/transparent.png";
/*      */   public static final String eO = "/img/config.png";
/*      */   public static final String eP = "/img/config_warn.png";
/*      */   public static final String eQ = "/img/config_edit.png";
/*      */   public static final String eR = "/img/config_edit_warn.png";
/*      */   public static final String eS = "/img/page.png";
/*      */   public static final String eT = "/img/hide.png";
/*      */   public static final String eU = "/img/bullet_error.png";
/*      */   public static final String eV = "/img/delete.png";
/*      */   public static final String eW = "/img/pencil.png";
/*      */   public static final String eX = "/img/excel.png";
/*      */   public static final String eY = "/img/mais.png";
/*      */   public static final String eZ = "/img/menos.png";
/*      */   public static final String fa = "/img/hammer.png";
/*      */   public static final String fb = "/img/hammer_closed.png";
/*      */   public static final String fc = "/img/refresh.png";
/*      */   public static final String fd = "/img/play.png";
/*      */   public static final String fe = "/img/pause.png";
/*      */   public static final String ff = "/img/disputa_parada.png";
/*      */   public static final String fg = "/img/bullet_green.png";
/*      */   public static final String fh = "/img/bullet_yellow.png";
/*      */   public static final String fi = "/img/bullet_red.png";
/*      */   public static final String fj = "/img/online-icon.png";
/*      */   public static final String fk = "/img/offline-icon.png";
/*      */   public static final String fl = "/img/switch_on.png";
/*      */   public static final String fm = "/img/switch_off.png";
/*      */   public static final String fn = "/img/clock.png";
/*      */   public static final String fo = "/img/icone.jpg";
/*      */   public static final String fp = "/img/date.png";
/*      */   public static final String fq = "/img/backgroundSobre.png";
/*      */   public static final String fr = "/img/blue-circle.png";
/*  114 */   public static final String fs = FileSystemView.getFileSystemView().getHomeDirectory().toString();
/*  115 */   public static final String ft = System.getProperty("user.dir");
/*  116 */   public static final String FILE_SEPARATOR = System.getProperty("file.separator");
/*  117 */   public static final String fu = System.getProperty("line.separator");
/*      */   
/*      */   public static final String fv = "dd/MM/yyyy HH:mm:ss";
/*      */   
/*      */   public static final String fw = "yyyy-MM-dd HH:mm:ss";
/*      */   
/*      */   public static final String fx = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
/*      */   
/*      */   public static final String fy = "###,###,##0.00";
/*      */   
/*      */   public static final String fz = "###,###,##0.0000";
/*      */   
/*      */   public static final String fA = "###,###,###,##0.0000";
/*      */   public static final String fB = "##.###.###/####-##";
/*      */   public static final int cK = 4;
/*      */   public static final int cL = 2;
/*      */   private static final String fC = "mock-files/";
/*      */   private static final String fD = "/files/";
/*  135 */   private static final Logger a = LoggerFactory.getLogger(y.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String cx() {
/*  147 */     String str = "";
/*  148 */     if (k.b()) {
/*  149 */       str = "Versão: 2.97.0";
/*      */     } else {
/*  151 */       str = "Ambiente: Teste  |  Versão: 2.97.0";
/*      */     } 
/*  153 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Color c() {
/*  163 */     return k.b() ? 
/*  164 */       d() : 
/*  165 */       f();
/*      */   }
/*      */   
/*      */   public static Color d() {
/*  169 */     return new Color(32, 97, 169);
/*      */   }
/*      */   
/*      */   public static Color e() {
/*  173 */     return new Color(0, 128, 0);
/*      */   }
/*      */   
/*      */   public static Color f() {
/*  177 */     return Color.RED;
/*      */   }
/*      */   
/*      */   public static Color g() {
/*  181 */     return new Color(255, 128, 0);
/*      */   }
/*      */   
/*      */   public static Color h() {
/*  185 */     return Color.GRAY;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Component a(Component paramComponent, int paramInt) {
/*  197 */     paramComponent.setForeground(Color.BLACK);
/*      */     
/*  199 */     if (paramInt % 2 == 0) {
/*  200 */       paramComponent.setBackground(new Color(240, 248, 255));
/*      */     } else {
/*  202 */       paramComponent.setBackground(new Color(255, 255, 255));
/*      */     } 
/*      */     
/*  205 */     return paramComponent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Component a(Component paramComponent) {
/*  216 */     paramComponent.setBackground(new Color(51, 153, 255));
/*  217 */     paramComponent.setForeground(Color.WHITE);
/*  218 */     return paramComponent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Component a(JTable paramJTable, Component paramComponent, int paramInt) {
/*  231 */     TableModel tableModel = paramJTable.getModel();
/*      */     
/*  233 */     if (tableModel instanceof i) {
/*  234 */       i i = (i)tableModel;
/*  235 */       int j = paramJTable.convertRowIndexToModel(paramInt);
/*  236 */       e e = i.b(j);
/*      */       
/*  238 */       String str = String.valueOf(paramJTable.getValueAt(paramInt, 0));
/*  239 */       boolean bool = e instanceof br.com.arremate.l.q.b.g;
/*      */ 
/*      */       
/*  242 */       if (str != null && str.equals("/img/menos.png")) {
/*  243 */         paramComponent.setBackground(Color.YELLOW);
/*  244 */         paramComponent.setFont(new Font("Dialog", 1, 12));
/*  245 */       } else if (bool) {
/*      */         
/*  247 */         paramComponent.setBackground(new Color(255, 255, 204));
/*      */       } 
/*  249 */     } else if (tableModel instanceof p) {
/*  250 */       p p = (p)tableModel;
/*  251 */       int i = paramJTable.convertRowIndexToModel(paramInt);
/*  252 */       f f = p.a(i);
/*      */       
/*  254 */       String str = String.valueOf(paramJTable.getValueAt(paramInt, 0));
/*  255 */       boolean bool = f instanceof br.com.arremate.l.q.c.g;
/*      */ 
/*      */       
/*  258 */       if (str != null && str.equals("/img/menos.png")) {
/*  259 */         paramComponent.setBackground(Color.LIGHT_GRAY);
/*  260 */         paramComponent.setFont(new Font("Dialog", 1, 12));
/*  261 */       } else if (bool) {
/*      */         
/*  263 */         paramComponent.setBackground(new Color(230, 230, 230));
/*      */       } 
/*      */     } 
/*      */     
/*  267 */     return paramComponent;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(JTable paramJTable, Component paramComponent, int paramInt) {
/*      */     Color color;
/*  279 */     if (!(paramJTable.getModel() instanceof i)) {
/*  280 */       return null;
/*      */     }
/*  282 */     i i = (i)paramJTable.getModel();
/*  283 */     int j = paramJTable.convertRowIndexToModel(paramInt);
/*  284 */     e e = i.b(j);
/*  285 */     double d1 = e.f().m();
/*  286 */     double d2 = e.l();
/*      */ 
/*      */     
/*  289 */     if (d2 == 0.0D || d1 == 0.0D) {
/*  290 */       return null;
/*      */     }
/*  292 */     if (e.w() == v.b.v()) {
/*  293 */       return a(paramComponent, d2, d1);
/*      */     }
/*  295 */     String str = null;
/*      */ 
/*      */     
/*  298 */     if (d1 < d2) {
/*  299 */       color = f();
/*  300 */       str = "Sem margem para disputar a 1ª colocação";
/*      */     } else {
/*  302 */       double d = d1 * 100.0D / d2 - 100.0D;
/*      */       
/*  304 */       if (d > 10.0D) {
/*  305 */         color = e();
/*      */       } else {
/*  307 */         color = g();
/*  308 */         str = "Lance próximo do valor mínimo(" + BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_EVEN).doubleValue() + "%)";
/*  309 */         if (d == 0.0D) {
/*  310 */           str = "Lance igual ao valor mínimo";
/*      */         }
/*      */       } 
/*      */     } 
/*  314 */     paramComponent.setForeground(color);
/*  315 */     paramComponent.setFont(new Font("Dialog", 1, 12));
/*  316 */     return str;
/*      */   }
/*      */   
/*      */   private static String a(Component paramComponent, double paramDouble1, double paramDouble2) {
/*      */     Color color;
/*  321 */     String str = null;
/*      */     
/*  323 */     if (paramDouble2 > paramDouble1) {
/*  324 */       color = f();
/*  325 */       str = "Sem margem para disputar a 1ª colocação";
/*      */     } else {
/*  327 */       double d = paramDouble1 * 100.0D / paramDouble2 - 100.0D;
/*      */ 
/*      */       
/*  330 */       if (d > 10.0D) {
/*  331 */         color = new Color(4, 126, 66);
/*      */       } else {
/*  333 */         color = new Color(255, 128, 0);
/*  334 */         str = "Lance próximo do valor mínimo(" + BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_EVEN).doubleValue() + "%)";
/*      */         
/*  336 */         if (d == 0.0D) {
/*  337 */           str = "Lance igual ao valor mínimo";
/*      */         }
/*      */       } 
/*      */     } 
/*  341 */     paramComponent.setForeground(color);
/*  342 */     paramComponent.setFont(new Font("Dialog", 1, 12));
/*  343 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(JTable paramJTable, int paramInt1, int paramInt2) {
/*  354 */     paramJTable.getColumnModel().getColumn(paramInt1).setWidth(paramInt2);
/*  355 */     paramJTable.getColumnModel().getColumn(paramInt1).setMaxWidth(paramInt2);
/*  356 */     paramJTable.getColumnModel().getColumn(paramInt1).setMinWidth(paramInt2);
/*  357 */     paramJTable.getColumnModel().getColumn(paramInt1).setPreferredWidth(paramInt2);
/*      */   }
/*      */   
/*      */   public static void a(TableColumn paramTableColumn, int paramInt) {
/*  361 */     paramTableColumn.setWidth(paramInt);
/*  362 */     paramTableColumn.setMaxWidth(paramInt);
/*  363 */     paramTableColumn.setMinWidth(paramInt);
/*  364 */     paramTableColumn.setPreferredWidth(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Double a(String paramString) {
/*  374 */     paramString = paramString.replace(".", "").replace(",", ".");
/*  375 */     return Double.valueOf(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String Q(String paramString) {
/*  385 */     paramString = paramString.replace(".", "");
/*  386 */     paramString = paramString.replace(",", ".");
/*      */     
/*  388 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String R(String paramString) {
/*  399 */     if (paramString == null) {
/*  400 */       return "";
/*      */     }
/*  402 */     String str = "";
/*      */     
/*      */     try {
/*  405 */       str = Base64.getEncoder().encodeToString(paramString.getBytes("utf-8"));
/*  406 */     } catch (Exception exception) {}
/*      */     
/*  408 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String S(String paramString) {
/*  419 */     if (paramString == null) {
/*  420 */       return "";
/*      */     }
/*  422 */     String str = "";
/*      */     
/*      */     try {
/*  425 */       str = new String(Base64.getDecoder().decode(paramString), StandardCharsets.UTF_8);
/*  426 */     } catch (Exception exception) {}
/*      */     
/*  428 */     return str;
/*      */   }
/*      */   
/*      */   public static String urlEncode(String paramString) {
/*      */     try {
/*  433 */       paramString = URLEncoder.encode(paramString, "UTF-8");
/*  434 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  437 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String T(String paramString) throws IOException {
/*  448 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramString.length());
/*  449 */     GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
/*  450 */     gZIPOutputStream.write(paramString.getBytes());
/*  451 */     gZIPOutputStream.close();
/*  452 */     byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/*  453 */     byteArrayOutputStream.close();
/*  454 */     return new String(arrayOfByte);
/*      */   }
/*      */   
/*      */   public static String U(String paramString) throws IOException {
/*  458 */     byte[] arrayOfByte = paramString.getBytes();
/*  459 */     StringBuilder stringBuilder = new StringBuilder();
/*  460 */     if (arrayOfByte == null || arrayOfByte.length == 0) {
/*  461 */       return "";
/*      */     }
/*  463 */     if (a(arrayOfByte)) {
/*  464 */       GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(arrayOfByte));
/*  465 */       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
/*      */       
/*      */       String str;
/*  468 */       while ((str = bufferedReader.readLine()) != null) {
/*  469 */         stringBuilder.append(str);
/*      */       }
/*      */     } else {
/*  472 */       stringBuilder.append(arrayOfByte);
/*      */     } 
/*  474 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   public static boolean a(byte[] paramArrayOfbyte) {
/*  478 */     return (paramArrayOfbyte[0] == 31 && paramArrayOfbyte[1] == -117);
/*      */   }
/*      */   
/*      */   public static String V(String paramString) {
/*  482 */     return paramString.replaceAll("[^0-9]*", "");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String i(String paramString1, String paramString2) {
/*  493 */     String str = "";
/*      */     try {
/*  495 */       byte[] arrayOfByte = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
/*  496 */       IvParameterSpec ivParameterSpec = new IvParameterSpec(arrayOfByte);
/*      */       
/*  498 */       Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/*  499 */       cipher.init(1, new SecretKeySpec(paramString2.getBytes("ISO-8859-1"), "AES"), ivParameterSpec);
/*  500 */       str = new String(cipher.doFinal(paramString1.getBytes("ISO-8859-1")), StandardCharsets.ISO_8859_1);
/*  501 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  504 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String j(String paramString1, String paramString2) {
/*  515 */     String str = "";
/*      */     try {
/*  517 */       byte[] arrayOfByte = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
/*  518 */       IvParameterSpec ivParameterSpec = new IvParameterSpec(arrayOfByte);
/*      */       
/*  520 */       Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
/*  521 */       cipher.init(2, new SecretKeySpec(paramString2.getBytes("ISO-8859-1"), "AES"), ivParameterSpec);
/*  522 */       str = new String(cipher.doFinal(paramString1.getBytes("ISO-8859-1")), StandardCharsets.ISO_8859_1);
/*  523 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  526 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String k(String paramString1, String paramString2) {
/*  538 */     String str = "";
/*      */     try {
/*  540 */       switch (paramString1) {
/*      */         case "##.###.###/####-##":
/*  542 */           paramString2 = StringUtils.leftPad(paramString2, 14, "0");
/*      */           break;
/*      */       } 
/*  545 */       MaskFormatter maskFormatter = new MaskFormatter(paramString1);
/*  546 */       maskFormatter.setValueContainsLiteralCharacters(false);
/*  547 */       str = maskFormatter.valueToString(paramString2);
/*  548 */     } catch (Exception exception) {}
/*      */     
/*  550 */     return str;
/*      */   }
/*      */   
/*      */   public static String h(int paramInt, String paramString) {
/*  554 */     while (paramString.length() < paramInt) {
/*  555 */       paramString = "0" + paramString;
/*      */     }
/*      */     
/*  558 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int a(float[] paramArrayOffloat, double paramDouble, int paramInt) {
/*  572 */     if (paramArrayOffloat == null || paramArrayOffloat.length == 0) {
/*  573 */       return -1;
/*      */     }
/*  575 */     if (paramInt < 0) {
/*  576 */       paramInt = 0;
/*      */     }
/*  578 */     for (int i = paramInt; i < paramArrayOffloat.length; i++) {
/*  579 */       if (paramDouble == paramArrayOffloat[i]) {
/*  580 */         return i;
/*      */       }
/*      */     } 
/*  583 */     return -1;
/*      */   }
/*      */   
/*      */   public static Calendar c(String paramString) {
/*  587 */     String[] arrayOfString1 = paramString.split(" ");
/*  588 */     String[] arrayOfString2 = arrayOfString1[1].split(":");
/*  589 */     arrayOfString1 = arrayOfString1[0].split("/");
/*      */     
/*  591 */     Calendar calendar = Calendar.getInstance();
/*  592 */     calendar.set(5, Integer.parseInt(arrayOfString1[0]));
/*  593 */     calendar.set(2, Integer.parseInt(arrayOfString1[1]) - 1);
/*  594 */     calendar.set(1, Integer.parseInt(arrayOfString1[2]));
/*  595 */     calendar.set(11, Integer.parseInt(arrayOfString2[0]));
/*  596 */     calendar.set(12, Integer.parseInt(arrayOfString2[1]));
/*      */     
/*  598 */     if (arrayOfString2.length > 2) {
/*  599 */       calendar.set(13, Integer.parseInt(arrayOfString2[2]));
/*      */     } else {
/*  601 */       calendar.set(13, 0);
/*      */     } 
/*  603 */     return calendar;
/*      */   }
/*      */   
/*      */   public static Calendar d(String paramString) {
/*  607 */     String[] arrayOfString = paramString.split("/");
/*      */     
/*  609 */     Calendar calendar = Calendar.getInstance();
/*  610 */     calendar.set(5, Integer.parseInt(arrayOfString[0]));
/*  611 */     calendar.set(2, Integer.parseInt(arrayOfString[1]) - 1);
/*  612 */     calendar.set(1, Integer.parseInt(arrayOfString[2]));
/*  613 */     calendar.set(11, 0);
/*  614 */     calendar.set(12, 0);
/*  615 */     calendar.set(13, 0);
/*      */     
/*  617 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String formatDate(Date paramDate) {
/*  627 */     return formatDate(paramDate, "dd/MM/yyyy HH:mm:ss");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String formatDate(Date paramDate, String paramString) {
/*  638 */     if (paramDate == null || paramString == null || paramString.isEmpty()) {
/*  639 */       return null;
/*      */     }
/*  641 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(paramString);
/*      */     
/*      */     try {
/*  644 */       return simpleDateFormat.format(paramDate);
/*  645 */     } catch (Exception exception) {
/*      */       
/*  647 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String W(String paramString) {
/*  658 */     SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  659 */     SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  660 */     String str = null;
/*      */     
/*      */     try {
/*  663 */       str = simpleDateFormat2.format(simpleDateFormat1.parse(paramString));
/*  664 */     } catch (ParseException parseException) {}
/*      */     
/*  666 */     return String.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String X(String paramString) {
/*  677 */     SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  678 */     SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  679 */     String str = null;
/*      */     
/*      */     try {
/*  682 */       str = simpleDateFormat2.format(simpleDateFormat1.parse(paramString));
/*  683 */     } catch (ParseException parseException) {}
/*      */     
/*  685 */     return String.valueOf(str);
/*      */   }
/*      */   
/*      */   public static String Y(String paramString) {
/*  689 */     SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
/*  690 */     SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  691 */     String str = null;
/*      */     
/*      */     try {
/*  694 */       str = simpleDateFormat2.format(simpleDateFormat1.parse(paramString));
/*  695 */     } catch (ParseException parseException) {}
/*      */     
/*  697 */     return String.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String Z(String paramString) {
/*  708 */     paramString = Normalizer.normalize(paramString, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
/*  709 */     return paramString;
/*      */   }
/*      */   
/*      */   public static ArrayList<String> a(ArrayList<String> paramArrayList) {
/*  713 */     ArrayList<String> arrayList = new ArrayList();
/*  714 */     paramArrayList.forEach(paramString -> paramArrayList.add(Normalizer.normalize(paramString, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")));
/*      */ 
/*      */     
/*  717 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String aa(String paramString) {
/*  728 */     String str = "";
/*  729 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*      */     try {
/*  732 */       Process process = Runtime.getRuntime().exec(paramString);
/*      */       
/*  734 */       BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(process.getInputStream()));
/*  735 */       BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
/*      */ 
/*      */       
/*  738 */       while ((str = bufferedReader1.readLine()) != null) {
/*  739 */         stringBuilder.append(str).append(fu);
/*      */       }
/*      */ 
/*      */       
/*  743 */       while ((str = bufferedReader2.readLine()) != null) {
/*  744 */         stringBuilder.append(str).append(fu);
/*      */       }
/*      */     }
/*  747 */     catch (Exception exception) {
/*  748 */       exception.printStackTrace();
/*      */     } 
/*      */     
/*  751 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar i() {
/*      */     long l;
/*  760 */     NTPUDPClient nTPUDPClient = new NTPUDPClient();
/*      */ 
/*      */     
/*      */     try {
/*  764 */       nTPUDPClient.setDefaultTimeout(5000);
/*  765 */       nTPUDPClient.open();
/*  766 */       InetAddress inetAddress = InetAddress.getByName("a.ntp.br");
/*  767 */       TimeInfo timeInfo = nTPUDPClient.getTime(inetAddress);
/*  768 */       timeInfo.computeDetails();
/*  769 */       NtpV3Packet ntpV3Packet = timeInfo.getMessage();
/*  770 */       TimeStamp timeStamp = ntpV3Packet.getTransmitTimeStamp();
/*  771 */       l = timeStamp.getTime();
/*  772 */       nTPUDPClient.close();
/*  773 */     } catch (IOException iOException) {
/*  774 */       if (nTPUDPClient.isOpen()) {
/*  775 */         nTPUDPClient.close();
/*      */       }
/*      */       
/*  778 */       l = TimeStamp.getCurrentTime().getTime();
/*  779 */       a.info("Error getting DF date", iOException);
/*      */     } 
/*      */     
/*  782 */     Calendar calendar = Calendar.getInstance();
/*  783 */     calendar.setTimeInMillis(l);
/*      */     
/*  785 */     return calendar;
/*      */   }
/*      */   
/*      */   public static Date a(String paramString) {
/*  789 */     String str1 = paramString.split(" ")[0];
/*  790 */     String str2 = paramString.split(" ")[1];
/*  791 */     return a(str1, str2);
/*      */   }
/*      */   
/*      */   public static Date a(String paramString1, String paramString2) {
/*  795 */     Calendar calendar = Calendar.getInstance();
/*  796 */     String[] arrayOfString1 = paramString1.split("/");
/*  797 */     String[] arrayOfString2 = paramString2.split(":");
/*  798 */     int i = Integer.parseInt(arrayOfString1[0]);
/*  799 */     int j = Integer.parseInt(arrayOfString1[1]) - 1;
/*  800 */     int k = Integer.parseInt(arrayOfString1[2]);
/*  801 */     int m = Integer.parseInt(arrayOfString2[0]);
/*  802 */     int n = Integer.parseInt(arrayOfString2[1]);
/*  803 */     boolean bool1 = (arrayOfString2.length > 2) ? Integer.parseInt(arrayOfString2[2]) : false;
/*  804 */     boolean bool2 = (arrayOfString2.length > 3) ? Integer.parseInt(arrayOfString2[3]) : false;
/*  805 */     calendar.set(k, j, i, m, n, bool1);
/*  806 */     calendar.set(14, bool2);
/*  807 */     return calendar.getTime();
/*      */   }
/*      */   
/*      */   public static boolean l(String paramString) {
/*  811 */     if (paramString == null || paramString.isEmpty()) {
/*  812 */       return false;
/*      */     }
/*      */     try {
/*  815 */       URL uRL = new URL(paramString);
/*  816 */       return a(uRL.toURI());
/*  817 */     } catch (Exception exception) {
/*      */       
/*  819 */       return false;
/*      */     } 
/*      */   }
/*      */   public static boolean a(URI paramURI) {
/*  823 */     if (paramURI == null) {
/*  824 */       return false;
/*      */     }
/*  826 */     if (SystemUtils.IS_OS_MAC) {
/*  827 */       Runtime runtime = Runtime.getRuntime();
/*      */       try {
/*  829 */         runtime.exec("open " + paramURI.toURL());
/*  830 */       } catch (Exception exception) {
/*  831 */         exception.printStackTrace();
/*      */       } 
/*      */     } else {
/*  834 */       Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
/*  835 */       if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
/*      */         try {
/*  837 */           desktop.browse(paramURI);
/*  838 */           return true;
/*  839 */         } catch (Exception exception) {
/*  840 */           exception.printStackTrace();
/*      */         } 
/*      */       }
/*      */     } 
/*  844 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(z.a parama) throws Exception {
/*  855 */     if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_LINUX) {
/*  856 */       if (parama == z.a.a) {
/*  857 */         return "/tmp";
/*      */       }
/*  859 */     } else if (SystemUtils.IS_OS_WINDOWS) {
/*  860 */       Map<String, String> map = System.getenv();
/*  861 */       String str = parama.cy();
/*  862 */       if (map.containsKey(str)) {
/*  863 */         return map.get(str);
/*      */       }
/*  865 */       str = str.toUpperCase();
/*  866 */       if (map.containsKey(str)) {
/*  867 */         return map.get(str);
/*      */       }
/*      */     } 
/*  870 */     throw new Exception("Enviroment variable not found");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String a(int paramInt, FontMetrics paramFontMetrics, String paramString) {
/*  882 */     String str1 = "<html><!--ARREMATELINHA-->";
/*  883 */     String[] arrayOfString = paramString.split(" ");
/*  884 */     String str2 = "";
/*      */ 
/*      */     
/*  887 */     for (String str3 : arrayOfString) {
/*      */       
/*  889 */       String str4 = (str2 + str3).replaceAll("\\<[^\\>]*\\>", "");
/*  890 */       int i = paramFontMetrics.stringWidth(str4);
/*  891 */       if (i > paramInt) {
/*      */         
/*  893 */         if (!str2.isEmpty()) {
/*  894 */           str1 = str1 + str2 + "<br>";
/*  895 */           str2 = str3 + " ";
/*      */         } 
/*      */       } else {
/*  898 */         str2 = str2 + str3 + " ";
/*      */       } 
/*      */     } 
/*      */     
/*  902 */     str1 = str1 + str2;
/*  903 */     str1 = str1 + "</html>";
/*  904 */     return str1;
/*      */   }
/*      */   
/*      */   public static DecimalFormat a(String paramString) {
/*  908 */     DecimalFormat decimalFormat = new DecimalFormat(paramString);
/*  909 */     DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
/*  910 */     decimalFormatSymbols.setDecimalSeparator(',');
/*  911 */     decimalFormatSymbols.setGroupingSeparator('.');
/*  912 */     decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
/*  913 */     return decimalFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String ab(String paramString) {
/*      */     try {
/*  924 */       return new String(Files.readAllBytes(Paths.get(ft + FILE_SEPARATOR + "mock-files/" + FILE_SEPARATOR + paramString, new String[0])), "UTF-8");
/*      */     }
/*  926 */     catch (Exception exception) {
/*  927 */       a.warn("Failed to read file", exception);
/*  928 */       return "";
/*      */     } 
/*      */   }
/*      */   
/*      */   public static String ac(String paramString) {
/*  933 */     try (InputStream null = y.class.getResourceAsStream("/files/" + paramString)) {
/*  934 */       byte[] arrayOfByte = IOUtils.toByteArray(inputStream);
/*  935 */       return new String(arrayOfByte, "UTF-8");
/*  936 */     } catch (Exception exception) {
/*  937 */       a.warn("Failed to read file", exception);
/*  938 */       return "";
/*      */     } 
/*      */   }
/*      */   
/*      */   public static ArrayList<i> a(f paramf, String paramString) {
/*  943 */     ArrayList<i> arrayList = new ArrayList();
/*      */     
/*  945 */     for (byte b = 0; b < paramf.length(); b++) {
/*  946 */       arrayList.add(paramf.b(b));
/*      */     }
/*      */     
/*  949 */     Collections.sort(arrayList, (parami1, parami2) -> {
/*      */           int j = 0;
/*      */           
/*      */           try {
/*      */             int k = parami1.getInt(paramString);
/*      */             int m = parami2.getInt(paramString);
/*      */             j = Integer.compare(k, m);
/*  956 */           } catch (g g) {}
/*      */ 
/*      */           
/*      */           return j;
/*      */         });
/*      */     
/*  962 */     return arrayList;
/*      */   }
/*      */   
/*      */   public static int a(int paramInt1, int paramInt2) {
/*  966 */     double d = paramInt1 / paramInt2;
/*  967 */     int i = paramInt1 / paramInt2;
/*  968 */     if (d % 1.0D != 0.0D) {
/*  969 */       i++;
/*      */     }
/*      */     
/*  972 */     return i;
/*      */   }
/*      */   
/*      */   public static boolean m(String paramString) {
/*  976 */     return (o(paramString) && paramString.startsWith("{"));
/*      */   }
/*      */   
/*      */   public static boolean n(String paramString) {
/*  980 */     return (o(paramString) && paramString.startsWith("["));
/*      */   }
/*      */   
/*      */   public static boolean o(String paramString) {
/*  984 */     return (paramString != null && !paramString.isEmpty());
/*      */   }
/*      */   
/*      */   public static long b(String paramString) {
/*  988 */     String[] arrayOfString = paramString.split(":");
/*  989 */     int i = Integer.parseInt(arrayOfString[0]);
/*  990 */     int j = Integer.parseInt(arrayOfString[1]);
/*  991 */     int k = Integer.parseInt(arrayOfString[2]);
/*      */     
/*  993 */     return (i * 60 * 60 * 1000 + j * 60 * 1000 + k * 1000);
/*      */   }
/*      */   
/*      */   public static String ad(String paramString) {
/*  997 */     String str = "";
/*  998 */     for (String str1 : paramString.split(Pattern.quote(FILE_SEPARATOR))) {
/*  999 */       if (str1.contains(" ")) {
/* 1000 */         str = str.concat("\"" + str1 + "\"").concat(FILE_SEPARATOR);
/*      */       } else {
/*      */         
/* 1003 */         str = str.concat(str1).concat(FILE_SEPARATOR);
/*      */       } 
/* 1005 */     }  return str.substring(0, str.length() - 1);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */