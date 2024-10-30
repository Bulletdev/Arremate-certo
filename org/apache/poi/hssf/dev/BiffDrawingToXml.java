/*     */ package org.apache.poi.hssf.dev;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ddf.EscherRecord;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.DrawingGroupRecord;
/*     */ import org.apache.poi.hssf.usermodel.HSSFPatriarch;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ 
/*     */ 
/*     */ public class BiffDrawingToXml
/*     */ {
/*     */   private static final String SHEET_NAME_PARAM = "-sheet-name";
/*     */   private static final String SHEET_INDEXES_PARAM = "-sheet-indexes";
/*     */   private static final String EXCLUDE_WORKBOOK_RECORDS = "-exclude-workbook";
/*     */   
/*     */   private static int getAttributeIndex(String paramString, String[] paramArrayOfString) {
/*  46 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  47 */       String str = paramArrayOfString[b];
/*  48 */       if (paramString.equals(str)) {
/*  49 */         return b;
/*     */       }
/*     */     } 
/*  52 */     return -1;
/*     */   }
/*     */   
/*     */   private static boolean isExcludeWorkbookRecords(String[] paramArrayOfString) {
/*  56 */     return (-1 != getAttributeIndex("-exclude-workbook", paramArrayOfString));
/*     */   }
/*     */   
/*     */   private static List<Integer> getIndexesByName(String[] paramArrayOfString, HSSFWorkbook paramHSSFWorkbook) {
/*  60 */     ArrayList<Integer> arrayList = new ArrayList();
/*  61 */     int i = getAttributeIndex("-sheet-name", paramArrayOfString);
/*  62 */     if (-1 != i) {
/*  63 */       if (i >= paramArrayOfString.length) {
/*  64 */         throw new IllegalArgumentException("sheet name param value was not specified");
/*     */       }
/*  66 */       String str = paramArrayOfString[i + 1];
/*  67 */       int j = paramHSSFWorkbook.getSheetIndex(str);
/*  68 */       if (-1 == j) {
/*  69 */         throw new IllegalArgumentException("specified sheet name has not been found in xls file");
/*     */       }
/*  71 */       arrayList.add(Integer.valueOf(j));
/*     */     } 
/*  73 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static List<Integer> getIndexesByIdArray(String[] paramArrayOfString) {
/*  77 */     ArrayList<Integer> arrayList = new ArrayList();
/*  78 */     int i = getAttributeIndex("-sheet-indexes", paramArrayOfString);
/*  79 */     if (-1 != i) {
/*  80 */       if (i >= paramArrayOfString.length) {
/*  81 */         throw new IllegalArgumentException("sheet list value was not specified");
/*     */       }
/*  83 */       String str = paramArrayOfString[i + 1];
/*  84 */       String[] arrayOfString = str.split(",");
/*  85 */       for (String str1 : arrayOfString) {
/*  86 */         arrayList.add(Integer.valueOf(Integer.parseInt(str1)));
/*     */       }
/*     */     } 
/*  89 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static List<Integer> getSheetsIndexes(String[] paramArrayOfString, HSSFWorkbook paramHSSFWorkbook) {
/*  93 */     ArrayList<Integer> arrayList = new ArrayList();
/*  94 */     arrayList.addAll(getIndexesByIdArray(paramArrayOfString));
/*  95 */     arrayList.addAll(getIndexesByName(paramArrayOfString, paramHSSFWorkbook));
/*  96 */     if (0 == arrayList.size()) {
/*  97 */       int i = paramHSSFWorkbook.getNumberOfSheets();
/*  98 */       for (byte b = 0; b < i; b++) {
/*  99 */         arrayList.add(Integer.valueOf(b));
/*     */       }
/*     */     } 
/* 102 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static String getInputFileName(String[] paramArrayOfString) {
/* 106 */     return paramArrayOfString[paramArrayOfString.length - 1];
/*     */   }
/*     */   
/*     */   private static String getOutputFileName(String paramString) {
/* 110 */     if (paramString.contains("xls")) {
/* 111 */       return paramString.replace(".xls", ".xml");
/*     */     }
/* 113 */     return paramString + ".xml";
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 117 */     if (0 == paramArrayOfString.length) {
/* 118 */       System.out.println("Usage: BiffDrawingToXml [options] inputWorkbook");
/* 119 */       System.out.println("Options:");
/* 120 */       System.out.println("  -exclude-workbook            exclude workbook-level records");
/* 121 */       System.out.println("  -sheet-indexes   <indexes>   output sheets with specified indexes");
/* 122 */       System.out.println("  -sheet-namek  <names>        output sheets with specified name");
/*     */       return;
/*     */     } 
/* 125 */     String str1 = getInputFileName(paramArrayOfString);
/* 126 */     FileInputStream fileInputStream = new FileInputStream(str1);
/* 127 */     String str2 = getOutputFileName(str1);
/* 128 */     FileOutputStream fileOutputStream = new FileOutputStream(str2);
/* 129 */     writeToFile(fileOutputStream, fileInputStream, isExcludeWorkbookRecords(paramArrayOfString), paramArrayOfString);
/* 130 */     fileInputStream.close();
/* 131 */     fileOutputStream.close();
/*     */   }
/*     */   
/*     */   public static void writeToFile(OutputStream paramOutputStream, InputStream paramInputStream, boolean paramBoolean, String[] paramArrayOfString) throws IOException {
/* 135 */     HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(paramInputStream);
/* 136 */     InternalWorkbook internalWorkbook = hSSFWorkbook.getInternalWorkbook();
/* 137 */     DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)internalWorkbook.findFirstRecordBySid((short)235);
/*     */     
/* 139 */     StringBuilder stringBuilder = new StringBuilder();
/* 140 */     stringBuilder.append("<workbook>\n");
/* 141 */     String str = "\t";
/* 142 */     if (!paramBoolean && drawingGroupRecord != null) {
/* 143 */       drawingGroupRecord.decode();
/* 144 */       List list1 = drawingGroupRecord.getEscherRecords();
/* 145 */       for (EscherRecord escherRecord : list1) {
/* 146 */         stringBuilder.append(escherRecord.toXml(str));
/*     */       }
/*     */     } 
/* 149 */     List<Integer> list = getSheetsIndexes(paramArrayOfString, hSSFWorkbook);
/* 150 */     for (Integer integer : list) {
/* 151 */       HSSFPatriarch hSSFPatriarch = hSSFWorkbook.getSheetAt(integer.intValue()).getDrawingPatriarch();
/* 152 */       if (hSSFPatriarch != null) {
/* 153 */         stringBuilder.append(str).append("<sheet").append(integer).append(">\n");
/* 154 */         stringBuilder.append(hSSFPatriarch.getBoundAggregate().toXml(str + "\t"));
/* 155 */         stringBuilder.append(str).append("</sheet").append(integer).append(">\n");
/*     */       } 
/*     */     } 
/* 158 */     stringBuilder.append("</workbook>\n");
/* 159 */     paramOutputStream.write(stringBuilder.toString().getBytes(StringUtil.UTF8));
/* 160 */     paramOutputStream.close();
/* 161 */     hSSFWorkbook.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\BiffDrawingToXml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */