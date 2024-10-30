/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.AxisCrosses;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisOrientation;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisPosition;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisTickMark;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxPos;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTCrosses;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLogBase;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumFmt;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTOrientation;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTTickMark;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STCrosses;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;
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
/*     */ public abstract class XSSFChartAxis
/*     */   implements ChartAxis
/*     */ {
/*     */   protected XSSFChart chart;
/*     */   private static final double MIN_LOG_BASE = 2.0D;
/*     */   private static final double MAX_LOG_BASE = 1000.0D;
/*     */   
/*     */   protected XSSFChartAxis(XSSFChart paramXSSFChart) {
/*  54 */     this.chart = paramXSSFChart;
/*     */   }
/*     */   
/*     */   public AxisPosition getPosition() {
/*  58 */     return toAxisPosition(getCTAxPos());
/*     */   }
/*     */   
/*     */   public void setPosition(AxisPosition paramAxisPosition) {
/*  62 */     getCTAxPos().setVal(fromAxisPosition(paramAxisPosition));
/*     */   }
/*     */   
/*     */   public void setNumberFormat(String paramString) {
/*  66 */     getCTNumFmt().setFormatCode(paramString);
/*  67 */     getCTNumFmt().setSourceLinked(true);
/*     */   }
/*     */   
/*     */   public String getNumberFormat() {
/*  71 */     return getCTNumFmt().getFormatCode();
/*     */   }
/*     */   
/*     */   public boolean isSetLogBase() {
/*  75 */     return getCTScaling().isSetLogBase();
/*     */   }
/*     */   
/*     */   public void setLogBase(double paramDouble) {
/*  79 */     if (paramDouble < 2.0D || 1000.0D < paramDouble)
/*     */     {
/*  81 */       throw new IllegalArgumentException("Axis log base must be between 2 and 1000 (inclusive), got: " + paramDouble);
/*     */     }
/*  83 */     CTScaling cTScaling = getCTScaling();
/*  84 */     if (cTScaling.isSetLogBase()) {
/*  85 */       cTScaling.getLogBase().setVal(paramDouble);
/*     */     } else {
/*  87 */       cTScaling.addNewLogBase().setVal(paramDouble);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double getLogBase() {
/*  92 */     CTLogBase cTLogBase = getCTScaling().getLogBase();
/*  93 */     if (cTLogBase != null) {
/*  94 */       return cTLogBase.getVal();
/*     */     }
/*  96 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public boolean isSetMinimum() {
/* 100 */     return getCTScaling().isSetMin();
/*     */   }
/*     */   
/*     */   public void setMinimum(double paramDouble) {
/* 104 */     CTScaling cTScaling = getCTScaling();
/* 105 */     if (cTScaling.isSetMin()) {
/* 106 */       cTScaling.getMin().setVal(paramDouble);
/*     */     } else {
/* 108 */       cTScaling.addNewMin().setVal(paramDouble);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double getMinimum() {
/* 113 */     CTScaling cTScaling = getCTScaling();
/* 114 */     if (cTScaling.isSetMin()) {
/* 115 */       return cTScaling.getMin().getVal();
/*     */     }
/* 117 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSetMaximum() {
/* 122 */     return getCTScaling().isSetMax();
/*     */   }
/*     */   
/*     */   public void setMaximum(double paramDouble) {
/* 126 */     CTScaling cTScaling = getCTScaling();
/* 127 */     if (cTScaling.isSetMax()) {
/* 128 */       cTScaling.getMax().setVal(paramDouble);
/*     */     } else {
/* 130 */       cTScaling.addNewMax().setVal(paramDouble);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double getMaximum() {
/* 135 */     CTScaling cTScaling = getCTScaling();
/* 136 */     if (cTScaling.isSetMax()) {
/* 137 */       return cTScaling.getMax().getVal();
/*     */     }
/* 139 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisOrientation getOrientation() {
/* 144 */     return toAxisOrientation(getCTScaling().getOrientation());
/*     */   }
/*     */   
/*     */   public void setOrientation(AxisOrientation paramAxisOrientation) {
/* 148 */     CTScaling cTScaling = getCTScaling();
/* 149 */     STOrientation.Enum enum_ = fromAxisOrientation(paramAxisOrientation);
/* 150 */     if (cTScaling.isSetOrientation()) {
/* 151 */       cTScaling.getOrientation().setVal(enum_);
/*     */     } else {
/* 153 */       getCTScaling().addNewOrientation().setVal(enum_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public AxisCrosses getCrosses() {
/* 158 */     return toAxisCrosses(getCTCrosses());
/*     */   }
/*     */   
/*     */   public void setCrosses(AxisCrosses paramAxisCrosses) {
/* 162 */     getCTCrosses().setVal(fromAxisCrosses(paramAxisCrosses));
/*     */   }
/*     */   
/*     */   public boolean isVisible() {
/* 166 */     return !getDelete().getVal();
/*     */   }
/*     */   
/*     */   public void setVisible(boolean paramBoolean) {
/* 170 */     getDelete().setVal(!paramBoolean);
/*     */   }
/*     */   
/*     */   public AxisTickMark getMajorTickMark() {
/* 174 */     return toAxisTickMark(getMajorCTTickMark());
/*     */   }
/*     */   
/*     */   public void setMajorTickMark(AxisTickMark paramAxisTickMark) {
/* 178 */     getMajorCTTickMark().setVal(fromAxisTickMark(paramAxisTickMark));
/*     */   }
/*     */   
/*     */   public AxisTickMark getMinorTickMark() {
/* 182 */     return toAxisTickMark(getMinorCTTickMark());
/*     */   }
/*     */   
/*     */   public void setMinorTickMark(AxisTickMark paramAxisTickMark) {
/* 186 */     getMinorCTTickMark().setVal(fromAxisTickMark(paramAxisTickMark));
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract CTAxPos getCTAxPos();
/*     */ 
/*     */   
/*     */   protected abstract CTNumFmt getCTNumFmt();
/*     */   
/*     */   protected abstract CTScaling getCTScaling();
/*     */   
/*     */   private static STOrientation.Enum fromAxisOrientation(AxisOrientation paramAxisOrientation) {
/* 198 */     switch (paramAxisOrientation) { case NONE:
/* 199 */         return STOrientation.MIN_MAX;
/* 200 */       case IN: return STOrientation.MAX_MIN; }
/*     */     
/* 202 */     throw new IllegalArgumentException();
/*     */   } protected abstract CTCrosses getCTCrosses(); protected abstract CTBoolean getDelete();
/*     */   protected abstract CTTickMark getMajorCTTickMark();
/*     */   protected abstract CTTickMark getMinorCTTickMark();
/*     */   private static AxisOrientation toAxisOrientation(CTOrientation paramCTOrientation) {
/* 207 */     switch (paramCTOrientation.getVal().intValue()) { case 2:
/* 208 */         return AxisOrientation.MIN_MAX;
/* 209 */       case 1: return AxisOrientation.MAX_MIN; }
/*     */     
/* 211 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static STCrosses.Enum fromAxisCrosses(AxisCrosses paramAxisCrosses) {
/* 216 */     switch (paramAxisCrosses) { case NONE:
/* 217 */         return STCrosses.AUTO_ZERO;
/* 218 */       case IN: return STCrosses.MIN;
/* 219 */       case OUT: return STCrosses.MAX; }
/*     */     
/* 221 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static AxisCrosses toAxisCrosses(CTCrosses paramCTCrosses) {
/* 226 */     switch (paramCTCrosses.getVal().intValue()) { case 1:
/* 227 */         return AxisCrosses.AUTO_ZERO;
/* 228 */       case 2: return AxisCrosses.MAX;
/* 229 */       case 3: return AxisCrosses.MIN; }
/*     */     
/* 231 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static STAxPos.Enum fromAxisPosition(AxisPosition paramAxisPosition) {
/* 236 */     switch (paramAxisPosition) { case NONE:
/* 237 */         return STAxPos.B;
/* 238 */       case IN: return STAxPos.L;
/* 239 */       case OUT: return STAxPos.R;
/* 240 */       case CROSS: return STAxPos.T; }
/*     */     
/* 242 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private static AxisPosition toAxisPosition(CTAxPos paramCTAxPos) {
/* 247 */     switch (paramCTAxPos.getVal().intValue()) { case 1:
/* 248 */         return AxisPosition.BOTTOM;
/* 249 */       case 2: return AxisPosition.LEFT;
/* 250 */       case 3: return AxisPosition.RIGHT;
/* 251 */       case 4: return AxisPosition.TOP; }
/* 252 */      return AxisPosition.BOTTOM;
/*     */   }
/*     */ 
/*     */   
/*     */   private static STTickMark.Enum fromAxisTickMark(AxisTickMark paramAxisTickMark) {
/* 257 */     switch (paramAxisTickMark) { case NONE:
/* 258 */         return STTickMark.NONE;
/* 259 */       case IN: return STTickMark.IN;
/* 260 */       case OUT: return STTickMark.OUT;
/* 261 */       case CROSS: return STTickMark.CROSS; }
/*     */     
/* 263 */     throw new IllegalArgumentException("Unknown AxisTickMark: " + paramAxisTickMark);
/*     */   }
/*     */ 
/*     */   
/*     */   private static AxisTickMark toAxisTickMark(CTTickMark paramCTTickMark) {
/* 268 */     switch (paramCTTickMark.getVal().intValue()) { case 3:
/* 269 */         return AxisTickMark.NONE;
/* 270 */       case 2: return AxisTickMark.IN;
/* 271 */       case 4: return AxisTickMark.OUT;
/* 272 */       case 1: return AxisTickMark.CROSS; }
/* 273 */      return AxisTickMark.CROSS;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFChartAxis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */