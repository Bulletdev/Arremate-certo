/*     */ package org.apache.poi.xssf.usermodel.charts;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.charts.LayoutMode;
/*     */ import org.apache.poi.ss.usermodel.charts.LayoutTarget;
/*     */ import org.apache.poi.ss.usermodel.charts.ManualLayout;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.XSSFChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayout;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutMode;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTLayoutTarget;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTManualLayout;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;
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
/*     */ public final class XSSFManualLayout
/*     */   implements ManualLayout
/*     */ {
/*     */   private CTManualLayout layout;
/*  46 */   private static final LayoutMode defaultLayoutMode = LayoutMode.EDGE;
/*  47 */   private static final LayoutTarget defaultLayoutTarget = LayoutTarget.INNER;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFManualLayout(CTLayout paramCTLayout) {
/*  54 */     initLayout(paramCTLayout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFManualLayout(XSSFChart paramXSSFChart) {
/*  62 */     CTPlotArea cTPlotArea = paramXSSFChart.getCTChart().getPlotArea();
/*  63 */     CTLayout cTLayout = cTPlotArea.isSetLayout() ? cTPlotArea.getLayout() : cTPlotArea.addNewLayout();
/*     */ 
/*     */     
/*  66 */     initLayout(cTLayout);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTManualLayout getCTManualLayout() {
/*  75 */     return this.layout;
/*     */   }
/*     */   
/*     */   public void setWidthRatio(double paramDouble) {
/*  79 */     if (!this.layout.isSetW()) {
/*  80 */       this.layout.addNewW();
/*     */     }
/*  82 */     this.layout.getW().setVal(paramDouble);
/*     */   }
/*     */   
/*     */   public double getWidthRatio() {
/*  86 */     if (!this.layout.isSetW()) {
/*  87 */       return 0.0D;
/*     */     }
/*  89 */     return this.layout.getW().getVal();
/*     */   }
/*     */   
/*     */   public void setHeightRatio(double paramDouble) {
/*  93 */     if (!this.layout.isSetH()) {
/*  94 */       this.layout.addNewH();
/*     */     }
/*  96 */     this.layout.getH().setVal(paramDouble);
/*     */   }
/*     */   
/*     */   public double getHeightRatio() {
/* 100 */     if (!this.layout.isSetH()) {
/* 101 */       return 0.0D;
/*     */     }
/* 103 */     return this.layout.getH().getVal();
/*     */   }
/*     */   
/*     */   public LayoutTarget getTarget() {
/* 107 */     if (!this.layout.isSetLayoutTarget()) {
/* 108 */       return defaultLayoutTarget;
/*     */     }
/* 110 */     return toLayoutTarget(this.layout.getLayoutTarget());
/*     */   }
/*     */   
/*     */   public void setTarget(LayoutTarget paramLayoutTarget) {
/* 114 */     if (!this.layout.isSetLayoutTarget()) {
/* 115 */       this.layout.addNewLayoutTarget();
/*     */     }
/* 117 */     this.layout.getLayoutTarget().setVal(fromLayoutTarget(paramLayoutTarget));
/*     */   }
/*     */   
/*     */   public LayoutMode getXMode() {
/* 121 */     if (!this.layout.isSetXMode()) {
/* 122 */       return defaultLayoutMode;
/*     */     }
/* 124 */     return toLayoutMode(this.layout.getXMode());
/*     */   }
/*     */   
/*     */   public void setXMode(LayoutMode paramLayoutMode) {
/* 128 */     if (!this.layout.isSetXMode()) {
/* 129 */       this.layout.addNewXMode();
/*     */     }
/* 131 */     this.layout.getXMode().setVal(fromLayoutMode(paramLayoutMode));
/*     */   }
/*     */   
/*     */   public LayoutMode getYMode() {
/* 135 */     if (!this.layout.isSetYMode()) {
/* 136 */       return defaultLayoutMode;
/*     */     }
/* 138 */     return toLayoutMode(this.layout.getYMode());
/*     */   }
/*     */   
/*     */   public void setYMode(LayoutMode paramLayoutMode) {
/* 142 */     if (!this.layout.isSetYMode()) {
/* 143 */       this.layout.addNewYMode();
/*     */     }
/* 145 */     this.layout.getYMode().setVal(fromLayoutMode(paramLayoutMode));
/*     */   }
/*     */   
/*     */   public double getX() {
/* 149 */     if (!this.layout.isSetX()) {
/* 150 */       return 0.0D;
/*     */     }
/* 152 */     return this.layout.getX().getVal();
/*     */   }
/*     */   
/*     */   public void setX(double paramDouble) {
/* 156 */     if (!this.layout.isSetX()) {
/* 157 */       this.layout.addNewX();
/*     */     }
/* 159 */     this.layout.getX().setVal(paramDouble);
/*     */   }
/*     */   
/*     */   public double getY() {
/* 163 */     if (!this.layout.isSetY()) {
/* 164 */       return 0.0D;
/*     */     }
/* 166 */     return this.layout.getY().getVal();
/*     */   }
/*     */   
/*     */   public void setY(double paramDouble) {
/* 170 */     if (!this.layout.isSetY()) {
/* 171 */       this.layout.addNewY();
/*     */     }
/* 173 */     this.layout.getY().setVal(paramDouble);
/*     */   }
/*     */   
/*     */   public LayoutMode getWidthMode() {
/* 177 */     if (!this.layout.isSetWMode()) {
/* 178 */       return defaultLayoutMode;
/*     */     }
/* 180 */     return toLayoutMode(this.layout.getWMode());
/*     */   }
/*     */   
/*     */   public void setWidthMode(LayoutMode paramLayoutMode) {
/* 184 */     if (!this.layout.isSetWMode()) {
/* 185 */       this.layout.addNewWMode();
/*     */     }
/* 187 */     this.layout.getWMode().setVal(fromLayoutMode(paramLayoutMode));
/*     */   }
/*     */   
/*     */   public LayoutMode getHeightMode() {
/* 191 */     if (!this.layout.isSetHMode()) {
/* 192 */       return defaultLayoutMode;
/*     */     }
/* 194 */     return toLayoutMode(this.layout.getHMode());
/*     */   }
/*     */   
/*     */   public void setHeightMode(LayoutMode paramLayoutMode) {
/* 198 */     if (!this.layout.isSetHMode()) {
/* 199 */       this.layout.addNewHMode();
/*     */     }
/* 201 */     this.layout.getHMode().setVal(fromLayoutMode(paramLayoutMode));
/*     */   }
/*     */   
/*     */   private void initLayout(CTLayout paramCTLayout) {
/* 205 */     if (paramCTLayout.isSetManualLayout()) {
/* 206 */       this.layout = paramCTLayout.getManualLayout();
/*     */     } else {
/* 208 */       this.layout = paramCTLayout.addNewManualLayout();
/*     */     } 
/*     */   }
/*     */   
/*     */   private STLayoutMode.Enum fromLayoutMode(LayoutMode paramLayoutMode) {
/* 213 */     switch (paramLayoutMode) { case INNER:
/* 214 */         return STLayoutMode.EDGE;
/* 215 */       case OUTER: return STLayoutMode.FACTOR; }
/*     */     
/* 217 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private LayoutMode toLayoutMode(CTLayoutMode paramCTLayoutMode) {
/* 222 */     switch (paramCTLayoutMode.getVal().intValue()) { case 1:
/* 223 */         return LayoutMode.EDGE;
/* 224 */       case 2: return LayoutMode.FACTOR; }
/*     */     
/* 226 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private STLayoutTarget.Enum fromLayoutTarget(LayoutTarget paramLayoutTarget) {
/* 231 */     switch (paramLayoutTarget) { case INNER:
/* 232 */         return STLayoutTarget.INNER;
/* 233 */       case OUTER: return STLayoutTarget.OUTER; }
/*     */     
/* 235 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */   
/*     */   private LayoutTarget toLayoutTarget(CTLayoutTarget paramCTLayoutTarget) {
/* 240 */     switch (paramCTLayoutTarget.getVal().intValue()) { case 1:
/* 241 */         return LayoutTarget.INNER;
/* 242 */       case 2: return LayoutTarget.OUTER; }
/*     */     
/* 244 */     throw new IllegalArgumentException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\charts\XSSFManualLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */