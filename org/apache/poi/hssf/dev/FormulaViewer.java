/*     */ package org.apache.poi.hssf.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFactory;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ public class FormulaViewer
/*     */ {
/*     */   private String file;
/*     */   private boolean list = false;
/*     */   
/*     */   public void run() throws IOException {
/*  59 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(this.file), true);
/*     */     try {
/*  61 */       InputStream inputStream = BiffViewer.getPOIFSInputStream(nPOIFSFileSystem);
/*     */       try {
/*  63 */         List list = RecordFactory.createRecords(inputStream);
/*     */         
/*  65 */         for (Record record : list) {
/*  66 */           if (record.getSid() == 6) {
/*  67 */             if (this.list) {
/*  68 */               listFormula((FormulaRecord)record); continue;
/*     */             } 
/*  70 */             parseFormulaRecord((FormulaRecord)record);
/*     */           } 
/*     */         } 
/*     */       } finally {
/*     */         
/*  75 */         inputStream.close();
/*     */       } 
/*     */     } finally {
/*  78 */       nPOIFSFileSystem.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void listFormula(FormulaRecord paramFormulaRecord) {
/*  83 */     String str2, str1 = "~";
/*  84 */     Ptg[] arrayOfPtg = paramFormulaRecord.getParsedExpression();
/*     */     
/*  86 */     int i = arrayOfPtg.length;
/*     */     
/*  88 */     Ptg ptg = arrayOfPtg[i - 1];
/*  89 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.FuncPtg) {
/*  90 */       str2 = String.valueOf(i - 1);
/*     */     } else {
/*  92 */       str2 = String.valueOf(-1);
/*     */     } 
/*     */     
/*  95 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  97 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.ExpPtg)
/*  98 */       return;  stringBuilder.append(ptg.toFormulaString());
/*  99 */     stringBuilder.append(str1);
/* 100 */     switch (ptg.getPtgClass()) {
/*     */       case 0:
/* 102 */         stringBuilder.append("REF");
/*     */         break;
/*     */       case 32:
/* 105 */         stringBuilder.append("VALUE");
/*     */         break;
/*     */       case 64:
/* 108 */         stringBuilder.append("ARRAY");
/*     */         break;
/*     */       default:
/* 111 */         throwInvalidRVAToken(ptg);
/*     */         break;
/*     */     } 
/* 114 */     stringBuilder.append(str1);
/* 115 */     if (i > 1) {
/* 116 */       ptg = arrayOfPtg[i - 2];
/* 117 */       switch (ptg.getPtgClass()) {
/*     */         case 0:
/* 119 */           stringBuilder.append("REF");
/*     */           break;
/*     */         case 32:
/* 122 */           stringBuilder.append("VALUE");
/*     */           break;
/*     */         case 64:
/* 125 */           stringBuilder.append("ARRAY");
/*     */           break;
/*     */         default:
/* 128 */           throwInvalidRVAToken(ptg); break;
/*     */       } 
/*     */     } else {
/* 131 */       stringBuilder.append("VALUE");
/*     */     } 
/* 133 */     stringBuilder.append(str1);
/* 134 */     stringBuilder.append(str2);
/* 135 */     System.out.println(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parseFormulaRecord(FormulaRecord paramFormulaRecord) {
/* 145 */     System.out.println("==============================");
/* 146 */     System.out.print("row = " + paramFormulaRecord.getRow());
/* 147 */     System.out.println(", col = " + paramFormulaRecord.getColumn());
/* 148 */     System.out.println("value = " + paramFormulaRecord.getValue());
/* 149 */     System.out.print("xf = " + paramFormulaRecord.getXFIndex());
/* 150 */     System.out.print(", number of ptgs = " + (paramFormulaRecord.getParsedExpression()).length);
/*     */     
/* 152 */     System.out.println(", options = " + paramFormulaRecord.getOptions());
/* 153 */     System.out.println("RPN List = " + formulaString(paramFormulaRecord));
/* 154 */     System.out.println("Formula text = " + composeFormula(paramFormulaRecord));
/*     */   }
/*     */ 
/*     */   
/*     */   private String formulaString(FormulaRecord paramFormulaRecord) {
/* 159 */     StringBuilder stringBuilder = new StringBuilder();
/* 160 */     Ptg[] arrayOfPtg = paramFormulaRecord.getParsedExpression();
/* 161 */     for (Ptg ptg : arrayOfPtg) {
/* 162 */       stringBuilder.append(ptg.toFormulaString());
/* 163 */       switch (ptg.getPtgClass()) {
/*     */         case 0:
/* 165 */           stringBuilder.append("(R)");
/*     */           break;
/*     */         case 32:
/* 168 */           stringBuilder.append("(V)");
/*     */           break;
/*     */         case 64:
/* 171 */           stringBuilder.append("(A)");
/*     */           break;
/*     */         default:
/* 174 */           throwInvalidRVAToken(ptg); break;
/*     */       } 
/* 176 */       stringBuilder.append(' ');
/*     */     } 
/* 178 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static void throwInvalidRVAToken(Ptg paramPtg) {
/* 182 */     throw new IllegalStateException("Invalid RVA type (" + paramPtg.getPtgClass() + "). This should never happen.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String composeFormula(FormulaRecord paramFormulaRecord) {
/* 188 */     return HSSFFormulaParser.toFormulaString((HSSFWorkbook)null, paramFormulaRecord.getParsedExpression());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFile(String paramString) {
/* 199 */     this.file = paramString;
/*     */   }
/*     */   
/*     */   public void setList(boolean paramBoolean) {
/* 203 */     this.list = paramBoolean;
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
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 216 */     if (paramArrayOfString == null || paramArrayOfString.length > 2 || paramArrayOfString[0].equals("--help")) {
/*     */ 
/*     */       
/* 219 */       System.out.println("FormulaViewer .8 proof that the devil lies in the details (or just in BIFF8 files in general)");
/*     */       
/* 221 */       System.out.println("usage: Give me a big fat file name");
/* 222 */     } else if (paramArrayOfString[0].equals("--listFunctions")) {
/* 223 */       FormulaViewer formulaViewer = new FormulaViewer();
/* 224 */       formulaViewer.setFile(paramArrayOfString[1]);
/* 225 */       formulaViewer.setList(true);
/* 226 */       formulaViewer.run();
/*     */     }
/*     */     else {
/*     */       
/* 230 */       FormulaViewer formulaViewer = new FormulaViewer();
/*     */       
/* 232 */       formulaViewer.setFile(paramArrayOfString[0]);
/* 233 */       formulaViewer.run();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\FormulaViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */