/*      */ package org.apache.poi.xssf.streaming;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.zip.ZipEntry;
/*      */ import java.util.zip.ZipFile;
/*      */ import java.util.zip.ZipOutputStream;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CreationHelper;
/*      */ import org.apache.poi.ss.usermodel.DataFormat;
/*      */ import org.apache.poi.ss.usermodel.Font;
/*      */ import org.apache.poi.ss.usermodel.Name;
/*      */ import org.apache.poi.ss.usermodel.PictureData;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.usermodel.Workbook;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.TempFile;
/*      */ import org.apache.poi.xssf.model.SharedStringsTable;
/*      */ import org.apache.poi.xssf.usermodel.XSSFSheet;
/*      */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SXSSFWorkbook
/*      */   implements Workbook
/*      */ {
/*      */   public static final int DEFAULT_WINDOW_SIZE = 100;
/*   92 */   private static final POILogger logger = POILogFactory.getLogger(SXSSFWorkbook.class);
/*      */   
/*      */   private final XSSFWorkbook _wb;
/*      */   
/*   96 */   private final Map<SXSSFSheet, XSSFSheet> _sxFromXHash = new HashMap<SXSSFSheet, XSSFSheet>();
/*   97 */   private final Map<XSSFSheet, SXSSFSheet> _xFromSxHash = new HashMap<XSSFSheet, SXSSFSheet>();
/*      */   
/*   99 */   private int _randomAccessWindowSize = 100;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean _compressTmpFiles = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final SharedStringsTable _sharedStringSource;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SXSSFWorkbook() {
/*  115 */     this((XSSFWorkbook)null);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public SXSSFWorkbook(XSSFWorkbook paramXSSFWorkbook) {
/*  154 */     this(paramXSSFWorkbook, 100);
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
/*      */   public SXSSFWorkbook(XSSFWorkbook paramXSSFWorkbook, int paramInt) {
/*  179 */     this(paramXSSFWorkbook, paramInt, false);
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
/*      */   public SXSSFWorkbook(XSSFWorkbook paramXSSFWorkbook, int paramInt, boolean paramBoolean) {
/*  204 */     this(paramXSSFWorkbook, paramInt, paramBoolean, false);
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
/*      */ 
/*      */   
/*      */   public SXSSFWorkbook(XSSFWorkbook paramXSSFWorkbook, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  231 */     setRandomAccessWindowSize(paramInt);
/*  232 */     setCompressTempFiles(paramBoolean1);
/*  233 */     if (paramXSSFWorkbook == null) {
/*      */       
/*  235 */       this._wb = new XSSFWorkbook();
/*  236 */       this._sharedStringSource = paramBoolean2 ? this._wb.getSharedStringSource() : null;
/*      */     }
/*      */     else {
/*      */       
/*  240 */       this._wb = paramXSSFWorkbook;
/*  241 */       this._sharedStringSource = paramBoolean2 ? this._wb.getSharedStringSource() : null;
/*  242 */       int i = this._wb.getNumberOfSheets();
/*  243 */       for (byte b = 0; b < i; b++) {
/*      */         
/*  245 */         XSSFSheet xSSFSheet = this._wb.getSheetAt(b);
/*  246 */         createAndRegisterSXSSFSheet(xSSFSheet);
/*      */       } 
/*      */     } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SXSSFWorkbook(int paramInt) {
/*  271 */     this(null, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRandomAccessWindowSize() {
/*  280 */     return this._randomAccessWindowSize;
/*      */   }
/*      */   
/*      */   private void setRandomAccessWindowSize(int paramInt) {
/*  284 */     if (paramInt == 0 || paramInt < -1) {
/*  285 */       throw new IllegalArgumentException("rowAccessWindowSize must be greater than 0 or -1");
/*      */     }
/*  287 */     this._randomAccessWindowSize = paramInt;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCompressTempFiles(boolean paramBoolean) {
/*  304 */     this._compressTmpFiles = paramBoolean;
/*      */   }
/*      */   
/*      */   SheetDataWriter createSheetDataWriter() throws IOException {
/*  308 */     if (this._compressTmpFiles) {
/*  309 */       return new GZIPSheetDataWriter(this._sharedStringSource);
/*      */     }
/*      */     
/*  312 */     return new SheetDataWriter(this._sharedStringSource);
/*      */   }
/*      */ 
/*      */   
/*      */   XSSFSheet getXSSFSheet(SXSSFSheet paramSXSSFSheet) {
/*  317 */     return this._sxFromXHash.get(paramSXSSFSheet);
/*      */   }
/*      */ 
/*      */   
/*      */   SXSSFSheet getSXSSFSheet(XSSFSheet paramXSSFSheet) {
/*  322 */     return this._xFromSxHash.get(paramXSSFSheet);
/*      */   }
/*      */ 
/*      */   
/*      */   void registerSheetMapping(SXSSFSheet paramSXSSFSheet, XSSFSheet paramXSSFSheet) {
/*  327 */     this._sxFromXHash.put(paramSXSSFSheet, paramXSSFSheet);
/*  328 */     this._xFromSxHash.put(paramXSSFSheet, paramSXSSFSheet);
/*      */   }
/*      */ 
/*      */   
/*      */   void deregisterSheetMapping(XSSFSheet paramXSSFSheet) {
/*  333 */     SXSSFSheet sXSSFSheet = getSXSSFSheet(paramXSSFSheet);
/*      */ 
/*      */     
/*      */     try {
/*  337 */       sXSSFSheet.getSheetDataWriter().close();
/*  338 */     } catch (IOException iOException) {}
/*      */ 
/*      */ 
/*      */     
/*  342 */     this._sxFromXHash.remove(sXSSFSheet);
/*      */     
/*  344 */     this._xFromSxHash.remove(paramXSSFSheet);
/*      */   }
/*      */ 
/*      */   
/*      */   private XSSFSheet getSheetFromZipEntryName(String paramString) {
/*  349 */     for (XSSFSheet xSSFSheet : this._sxFromXHash.values()) {
/*      */       
/*  351 */       if (paramString.equals(xSSFSheet.getPackagePart().getPartName().getName().substring(1))) return xSSFSheet; 
/*      */     } 
/*  353 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void injectData(File paramFile, OutputStream paramOutputStream) throws IOException {
/*  359 */     ZipFile zipFile = new ZipFile(paramFile);
/*      */     
/*      */     try {
/*  362 */       ZipOutputStream zipOutputStream = new ZipOutputStream(paramOutputStream);
/*      */       
/*      */       try {
/*  365 */         Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
/*  366 */         while (enumeration.hasMoreElements())
/*      */         {
/*  368 */           ZipEntry zipEntry = enumeration.nextElement();
/*  369 */           zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
/*  370 */           InputStream inputStream = zipFile.getInputStream(zipEntry);
/*  371 */           XSSFSheet xSSFSheet = getSheetFromZipEntryName(zipEntry.getName());
/*  372 */           if (xSSFSheet != null) {
/*      */             
/*  374 */             SXSSFSheet sXSSFSheet = getSXSSFSheet(xSSFSheet);
/*  375 */             InputStream inputStream1 = sXSSFSheet.getWorksheetXMLInputStream();
/*      */             
/*      */             try {
/*  378 */               copyStreamAndInjectWorksheet(inputStream, zipOutputStream, inputStream1);
/*      */             }
/*      */             finally {
/*      */               
/*  382 */               inputStream1.close();
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/*  387 */             copyStream(inputStream, zipOutputStream);
/*      */           } 
/*  389 */           inputStream.close();
/*      */         }
/*      */       
/*      */       } finally {
/*      */         
/*  394 */         zipOutputStream.close();
/*      */       }
/*      */     
/*      */     } finally {
/*      */       
/*  399 */       zipFile.close();
/*      */     } 
/*      */   }
/*      */   private static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/*  403 */     byte[] arrayOfByte = new byte[1024];
/*      */     int i;
/*  405 */     while ((i = paramInputStream.read(arrayOfByte)) >= 0)
/*  406 */       paramOutputStream.write(arrayOfByte, 0, i); 
/*      */   }
/*      */   
/*      */   private static void copyStreamAndInjectWorksheet(InputStream paramInputStream1, OutputStream paramOutputStream, InputStream paramInputStream2) throws IOException {
/*  410 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream1, "UTF-8");
/*  411 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(paramOutputStream, "UTF-8");
/*  412 */     boolean bool = true;
/*      */     
/*  414 */     byte b = 0;
/*  415 */     String str = "<sheetData";
/*  416 */     int j = str.length();
/*      */     int i;
/*  418 */     while ((i = inputStreamReader.read()) != -1) {
/*      */       
/*  420 */       if (i == str.charAt(b)) {
/*      */         
/*  422 */         b++;
/*  423 */         if (b == j) {
/*      */           
/*  425 */           if ("<sheetData".equals(str)) {
/*      */             
/*  427 */             i = inputStreamReader.read();
/*  428 */             if (i == -1) {
/*      */               
/*  430 */               outputStreamWriter.write(str);
/*      */               break;
/*      */             } 
/*  433 */             if (i == 62) {
/*      */ 
/*      */               
/*  436 */               outputStreamWriter.write(str);
/*  437 */               outputStreamWriter.write(i);
/*  438 */               str = "</sheetData>";
/*  439 */               j = str.length();
/*  440 */               b = 0;
/*  441 */               bool = false;
/*      */               continue;
/*      */             } 
/*  444 */             if (i == 47) {
/*      */ 
/*      */               
/*  447 */               i = inputStreamReader.read();
/*  448 */               if (i == -1) {
/*      */                 
/*  450 */                 outputStreamWriter.write(str);
/*      */                 break;
/*      */               } 
/*  453 */               if (i == 62) {
/*      */                 break;
/*      */               }
/*      */ 
/*      */ 
/*      */               
/*  459 */               outputStreamWriter.write(str);
/*  460 */               outputStreamWriter.write(47);
/*  461 */               outputStreamWriter.write(i);
/*  462 */               b = 0;
/*      */               
/*      */               continue;
/*      */             } 
/*  466 */             outputStreamWriter.write(str);
/*  467 */             outputStreamWriter.write(47);
/*  468 */             outputStreamWriter.write(i);
/*  469 */             b = 0;
/*      */ 
/*      */             
/*      */             continue;
/*      */           } 
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  481 */       if (b > 0) outputStreamWriter.write(str, 0, b); 
/*  482 */       if (i == str.charAt(0)) {
/*      */         
/*  484 */         b = 1;
/*      */         
/*      */         continue;
/*      */       } 
/*  488 */       outputStreamWriter.write(i);
/*  489 */       b = 0;
/*      */     } 
/*      */ 
/*      */     
/*  493 */     outputStreamWriter.flush();
/*  494 */     if (bool) {
/*      */       
/*  496 */       outputStreamWriter.write("<sheetData>\n");
/*  497 */       outputStreamWriter.flush();
/*      */     } 
/*      */     
/*  500 */     copyStream(paramInputStream2, paramOutputStream);
/*  501 */     outputStreamWriter.write("</sheetData>");
/*  502 */     outputStreamWriter.flush();
/*      */     
/*  504 */     while ((i = inputStreamReader.read()) != -1)
/*  505 */       outputStreamWriter.write(i); 
/*  506 */     outputStreamWriter.flush();
/*      */   }
/*      */ 
/*      */   
/*      */   public XSSFWorkbook getXSSFWorkbook() {
/*  511 */     return this._wb;
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
/*      */   
/*      */   public int getActiveSheetIndex() {
/*  526 */     return this._wb.getActiveSheetIndex();
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
/*      */   public void setActiveSheet(int paramInt) {
/*  539 */     this._wb.setActiveSheet(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstVisibleTab() {
/*  550 */     return this._wb.getFirstVisibleTab();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstVisibleTab(int paramInt) {
/*  561 */     this._wb.setFirstVisibleTab(paramInt);
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
/*      */   public void setSheetOrder(String paramString, int paramInt) {
/*  573 */     this._wb.setSheetOrder(paramString, paramInt);
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
/*      */   
/*      */   public void setSelectedTab(int paramInt) {
/*  588 */     this._wb.setSelectedTab(paramInt);
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
/*      */   public void setSheetName(int paramInt, String paramString) {
/*  600 */     this._wb.setSheetName(paramInt, paramString);
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
/*      */   public String getSheetName(int paramInt) {
/*  612 */     return this._wb.getSheetName(paramInt);
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
/*      */   public int getSheetIndex(String paramString) {
/*  624 */     return this._wb.getSheetIndex(paramString);
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
/*      */   public int getSheetIndex(Sheet paramSheet) {
/*  636 */     return this._wb.getSheetIndex((Sheet)getXSSFSheet((SXSSFSheet)paramSheet));
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
/*      */   public SXSSFSheet createSheet() {
/*  648 */     return createAndRegisterSXSSFSheet(this._wb.createSheet());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet paramXSSFSheet) {
/*      */     SXSSFSheet sXSSFSheet;
/*      */     try {
/*  656 */       sXSSFSheet = new SXSSFSheet(this, paramXSSFSheet);
/*      */     }
/*  658 */     catch (IOException iOException) {
/*      */       
/*  660 */       throw new RuntimeException(iOException);
/*      */     } 
/*  662 */     registerSheetMapping(sXSSFSheet, paramXSSFSheet);
/*  663 */     return sXSSFSheet;
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
/*      */   public SXSSFSheet createSheet(String paramString) {
/*  677 */     return createAndRegisterSXSSFSheet(this._wb.createSheet(paramString));
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
/*      */   @NotImplemented
/*      */   public Sheet cloneSheet(int paramInt) {
/*  691 */     throw new RuntimeException("NotImplemented");
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
/*      */   public int getNumberOfSheets() {
/*  703 */     return this._wb.getNumberOfSheets();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> sheetIterator() {
/*  714 */     return new SheetIterator<Sheet>();
/*      */   }
/*      */ 
/*      */   
/*      */   private final class SheetIterator<T extends Sheet>
/*      */     implements Iterator<T>
/*      */   {
/*  721 */     private final Iterator<XSSFSheet> it = SXSSFWorkbook.this._wb.iterator();
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/*  725 */       return this.it.hasNext();
/*      */     }
/*      */ 
/*      */     
/*      */     public T next() throws NoSuchElementException {
/*  730 */       XSSFSheet xSSFSheet = this.it.next();
/*  731 */       return (T)SXSSFWorkbook.this.getSXSSFSheet(xSSFSheet);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() throws IllegalStateException {
/*  740 */       throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> iterator() {
/*  751 */     return sheetIterator();
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
/*      */   public SXSSFSheet getSheetAt(int paramInt) {
/*  763 */     return getSXSSFSheet(this._wb.getSheetAt(paramInt));
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
/*      */   public SXSSFSheet getSheet(String paramString) {
/*  775 */     return getSXSSFSheet(this._wb.getSheet(paramString));
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
/*      */   public void removeSheetAt(int paramInt) {
/*  787 */     XSSFSheet xSSFSheet = this._wb.getSheetAt(paramInt);
/*  788 */     SXSSFSheet sXSSFSheet = getSXSSFSheet(xSSFSheet);
/*      */ 
/*      */     
/*  791 */     this._wb.removeSheetAt(paramInt);
/*  792 */     deregisterSheetMapping(xSSFSheet);
/*      */ 
/*      */     
/*      */     try {
/*  796 */       sXSSFSheet.dispose();
/*  797 */     } catch (IOException iOException) {
/*  798 */       logger.log(5, new Object[] { iOException });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Font createFont() {
/*  810 */     return (Font)this._wb.createFont();
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
/*      */   public Font findFont(short paramShort1, short paramShort2, short paramShort3, String paramString, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, byte paramByte) {
/*  822 */     return (Font)this._wb.findFont(paramShort1, paramShort2, paramShort3, paramString, paramBoolean1, paramBoolean2, paramShort4, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Font findFont(boolean paramBoolean1, short paramShort1, short paramShort2, String paramString, boolean paramBoolean2, boolean paramBoolean3, short paramShort3, byte paramByte) {
/*  833 */     return (Font)this._wb.findFont(paramBoolean1, paramShort1, paramShort2, paramString, paramBoolean2, paramBoolean3, paramShort3, paramByte);
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
/*      */   public short getNumberOfFonts() {
/*  845 */     return this._wb.getNumberOfFonts();
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
/*      */   public Font getFontAt(short paramShort) {
/*  857 */     return (Font)this._wb.getFontAt(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CellStyle createCellStyle() {
/*  868 */     return (CellStyle)this._wb.createCellStyle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumCellStyles() {
/*  879 */     return this._wb.getNumCellStyles();
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
/*      */   public CellStyle getCellStyleAt(int paramInt) {
/*  891 */     return (CellStyle)this._wb.getCellStyleAt(paramInt);
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
/*      */   public void close() throws IOException {
/*  905 */     for (SXSSFSheet sXSSFSheet : this._xFromSxHash.values()) {
/*      */       
/*      */       try {
/*  908 */         sXSSFSheet.getSheetDataWriter().close();
/*  909 */       } catch (IOException iOException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  917 */     this._wb.close();
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
/*      */   public void write(OutputStream paramOutputStream) throws IOException {
/*  929 */     for (SXSSFSheet sXSSFSheet : this._xFromSxHash.values())
/*      */     {
/*  931 */       sXSSFSheet.flushRows();
/*      */     }
/*      */ 
/*      */     
/*  935 */     File file = TempFile.createTempFile("poi-sxssf-template", ".xlsx");
/*      */     
/*      */     try {
/*  938 */       FileOutputStream fileOutputStream = new FileOutputStream(file);
/*      */       
/*      */       try {
/*  941 */         this._wb.write(fileOutputStream);
/*      */       }
/*      */       finally {
/*      */         
/*  945 */         fileOutputStream.close();
/*      */       } 
/*      */ 
/*      */       
/*  949 */       injectData(file, paramOutputStream);
/*      */     }
/*      */     finally {
/*      */       
/*  953 */       if (!file.delete()) {
/*  954 */         throw new IOException("Could not delete temporary file after processing: " + file);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dispose() {
/*  966 */     boolean bool = true;
/*  967 */     for (SXSSFSheet sXSSFSheet : this._sxFromXHash.keySet()) {
/*      */       
/*      */       try {
/*  970 */         bool = (sXSSFSheet.dispose() && bool) ? true : false;
/*  971 */       } catch (IOException iOException) {
/*  972 */         logger.log(5, new Object[] { iOException });
/*  973 */         bool = false;
/*      */       } 
/*      */     } 
/*  976 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfNames() {
/*  985 */     return this._wb.getNumberOfNames();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Name getName(String paramString) {
/*  995 */     return (Name)this._wb.getName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<? extends Name> getNames(String paramString) {
/* 1006 */     return this._wb.getNames(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<? extends Name> getAllNames() {
/* 1017 */     return this._wb.getAllNames();
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
/*      */   @Deprecated
/*      */   public Name getNameAt(int paramInt) {
/* 1030 */     return (Name)this._wb.getNameAt(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Name createName() {
/* 1041 */     return (Name)this._wb.createName();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int getNameIndex(String paramString) {
/* 1060 */     return this._wb.getNameIndex(paramString);
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
/*      */   @Deprecated
/*      */   public void removeName(int paramInt) {
/* 1074 */     this._wb.removeName(paramInt);
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
/*      */   @Deprecated
/*      */   public void removeName(String paramString) {
/* 1088 */     this._wb.removeName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeName(Name paramName) {
/* 1099 */     this._wb.removeName(paramName);
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
/*      */   public void setPrintArea(int paramInt, String paramString) {
/* 1112 */     this._wb.setPrintArea(paramInt, paramString);
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
/*      */   
/*      */   public void setPrintArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1127 */     this._wb.setPrintArea(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*      */   public String getPrintArea(int paramInt) {
/* 1140 */     return this._wb.getPrintArea(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePrintArea(int paramInt) {
/* 1151 */     this._wb.removePrintArea(paramInt);
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
/*      */   public Row.MissingCellPolicy getMissingCellPolicy() {
/* 1165 */     return this._wb.getMissingCellPolicy();
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
/*      */   public void setMissingCellPolicy(Row.MissingCellPolicy paramMissingCellPolicy) {
/* 1179 */     this._wb.setMissingCellPolicy(paramMissingCellPolicy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataFormat createDataFormat() {
/* 1190 */     return (DataFormat)this._wb.createDataFormat();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int addPicture(byte[] paramArrayOfbyte, int paramInt) {
/* 1210 */     return this._wb.addPicture(paramArrayOfbyte, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<? extends PictureData> getAllPictures() {
/* 1221 */     return this._wb.getAllPictures();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CreationHelper getCreationHelper() {
/* 1231 */     return new SXSSFCreationHelper(this);
/*      */   }
/*      */   
/*      */   protected boolean isDate1904() {
/* 1235 */     return this._wb.isDate1904();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isHidden() {
/* 1244 */     return this._wb.isHidden();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/* 1253 */     this._wb.setHidden(paramBoolean);
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
/*      */   
/*      */   public boolean isSheetHidden(int paramInt) {
/* 1268 */     return this._wb.isSheetHidden(paramInt);
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
/*      */   
/*      */   public boolean isSheetVeryHidden(int paramInt) {
/* 1283 */     return this._wb.isSheetVeryHidden(paramInt);
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
/*      */   
/*      */   public void setSheetHidden(int paramInt, boolean paramBoolean) {
/* 1298 */     this._wb.setSheetHidden(paramInt, paramBoolean);
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
/*      */   public void setSheetHidden(int paramInt1, int paramInt2) {
/* 1323 */     this._wb.setSheetHidden(paramInt1, paramInt2);
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
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public int linkExternalWorkbook(String paramString, Workbook paramWorkbook) {
/* 1340 */     throw new RuntimeException("NotImplemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addToolPack(UDFFinder paramUDFFinder) {
/* 1351 */     this._wb.addToolPack(paramUDFFinder);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceFormulaRecalculation(boolean paramBoolean) {
/* 1368 */     this._wb.setForceFormulaRecalculation(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceFormulaRecalculation() {
/* 1376 */     return this._wb.getForceFormulaRecalculation();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpreadsheetVersion getSpreadsheetVersion() {
/* 1387 */     return SpreadsheetVersion.EXCEL2007;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */