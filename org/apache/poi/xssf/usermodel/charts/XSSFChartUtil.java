/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.ChartDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
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
/*     */ class XSSFChartUtil
/*     */ {
/*     */   public static void buildAxDataSource(CTAxDataSource paramCTAxDataSource, ChartDataSource<?> paramChartDataSource) {
/*  40 */     if (paramChartDataSource.isNumeric()) {
/*  41 */       if (paramChartDataSource.isReference()) {
/*  42 */         buildNumRef(paramCTAxDataSource.addNewNumRef(), paramChartDataSource);
/*     */       } else {
/*  44 */         buildNumLit(paramCTAxDataSource.addNewNumLit(), paramChartDataSource);
/*     */       }
/*     */     
/*  47 */     } else if (paramChartDataSource.isReference()) {
/*  48 */       buildStrRef(paramCTAxDataSource.addNewStrRef(), paramChartDataSource);
/*     */     } else {
/*  50 */       buildStrLit(paramCTAxDataSource.addNewStrLit(), paramChartDataSource);
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
/*     */   public static void buildNumDataSource(CTNumDataSource paramCTNumDataSource, ChartDataSource<? extends Number> paramChartDataSource) {
/*  62 */     if (paramChartDataSource.isReference()) {
/*  63 */       buildNumRef(paramCTNumDataSource.addNewNumRef(), paramChartDataSource);
/*     */     } else {
/*  65 */       buildNumLit(paramCTNumDataSource.addNewNumLit(), paramChartDataSource);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void buildNumRef(CTNumRef paramCTNumRef, ChartDataSource<?> paramChartDataSource) {
/*  70 */     paramCTNumRef.setF(paramChartDataSource.getFormulaString());
/*  71 */     CTNumData cTNumData = paramCTNumRef.addNewNumCache();
/*  72 */     fillNumCache(cTNumData, paramChartDataSource);
/*     */   }
/*     */   
/*     */   private static void buildNumLit(CTNumData paramCTNumData, ChartDataSource<?> paramChartDataSource) {
/*  76 */     fillNumCache(paramCTNumData, paramChartDataSource);
/*     */   }
/*     */   
/*     */   private static void buildStrRef(CTStrRef paramCTStrRef, ChartDataSource<?> paramChartDataSource) {
/*  80 */     paramCTStrRef.setF(paramChartDataSource.getFormulaString());
/*  81 */     CTStrData cTStrData = paramCTStrRef.addNewStrCache();
/*  82 */     fillStringCache(cTStrData, paramChartDataSource);
/*     */   }
/*     */   
/*     */   private static void buildStrLit(CTStrData paramCTStrData, ChartDataSource<?> paramChartDataSource) {
/*  86 */     fillStringCache(paramCTStrData, paramChartDataSource);
/*     */   }
/*     */   
/*     */   private static void fillStringCache(CTStrData paramCTStrData, ChartDataSource<?> paramChartDataSource) {
/*  90 */     int i = paramChartDataSource.getPointCount();
/*  91 */     paramCTStrData.addNewPtCount().setVal(i);
/*  92 */     for (byte b = 0; b < i; b++) {
/*  93 */       Object object = paramChartDataSource.getPointAt(b);
/*  94 */       if (object != null) {
/*  95 */         CTStrVal cTStrVal = paramCTStrData.addNewPt();
/*  96 */         cTStrVal.setIdx(b);
/*  97 */         cTStrVal.setV(object.toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void fillNumCache(CTNumData paramCTNumData, ChartDataSource<?> paramChartDataSource) {
/* 104 */     int i = paramChartDataSource.getPointCount();
/* 105 */     paramCTNumData.addNewPtCount().setVal(i);
/* 106 */     for (byte b = 0; b < i; b++) {
/* 107 */       Number number = (Number)paramChartDataSource.getPointAt(b);
/* 108 */       if (number != null) {
/* 109 */         CTNumVal cTNumVal = paramCTNumData.addNewPt();
/* 110 */         cTNumVal.setIdx(b);
/* 111 */         cTNumVal.setV(number.toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFChartUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */