/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
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
/*     */ 
/*     */ public abstract class XSSFShape
/*     */ {
/*     */   public static final int EMU_PER_PIXEL = 9525;
/*     */   public static final int EMU_PER_POINT = 12700;
/*     */   public static final int POINT_DPI = 72;
/*     */   public static final int PIXEL_DPI = 96;
/*     */   protected XSSFDrawing drawing;
/*     */   protected XSSFShapeGroup parent;
/*     */   protected XSSFAnchor anchor;
/*     */   
/*     */   public XSSFDrawing getDrawing() {
/*  61 */     return this.drawing;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFShapeGroup getParent() {
/*  69 */     return this.parent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFAnchor getAnchor() {
/*  77 */     return this.anchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CTShapeProperties getShapeProperties();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNoFill() {
/*  93 */     return getShapeProperties().isSetNoFill();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoFill(boolean paramBoolean) {
/* 102 */     CTShapeProperties cTShapeProperties = getShapeProperties();
/*     */     
/* 104 */     if (cTShapeProperties.isSetPattFill()) cTShapeProperties.unsetPattFill(); 
/* 105 */     if (cTShapeProperties.isSetSolidFill()) cTShapeProperties.unsetSolidFill();
/*     */     
/* 107 */     cTShapeProperties.setNoFill(CTNoFillProperties.Factory.newInstance());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillColor(int paramInt1, int paramInt2, int paramInt3) {
/* 114 */     CTShapeProperties cTShapeProperties = getShapeProperties();
/* 115 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTShapeProperties.isSetSolidFill() ? cTShapeProperties.getSolidFill() : cTShapeProperties.addNewSolidFill();
/* 116 */     CTSRgbColor cTSRgbColor = CTSRgbColor.Factory.newInstance();
/* 117 */     cTSRgbColor.setVal(new byte[] { (byte)paramInt1, (byte)paramInt2, (byte)paramInt3 });
/* 118 */     cTSolidColorFillProperties.setSrgbClr(cTSRgbColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineStyleColor(int paramInt1, int paramInt2, int paramInt3) {
/* 125 */     CTShapeProperties cTShapeProperties = getShapeProperties();
/* 126 */     CTLineProperties cTLineProperties = cTShapeProperties.isSetLn() ? cTShapeProperties.getLn() : cTShapeProperties.addNewLn();
/* 127 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTLineProperties.isSetSolidFill() ? cTLineProperties.getSolidFill() : cTLineProperties.addNewSolidFill();
/* 128 */     CTSRgbColor cTSRgbColor = CTSRgbColor.Factory.newInstance();
/* 129 */     cTSRgbColor.setVal(new byte[] { (byte)paramInt1, (byte)paramInt2, (byte)paramInt3 });
/* 130 */     cTSolidColorFillProperties.setSrgbClr(cTSRgbColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineWidth(double paramDouble) {
/* 139 */     CTShapeProperties cTShapeProperties = getShapeProperties();
/* 140 */     CTLineProperties cTLineProperties = cTShapeProperties.isSetLn() ? cTShapeProperties.getLn() : cTShapeProperties.addNewLn();
/* 141 */     cTLineProperties.setW((int)(paramDouble * 12700.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineStyle(int paramInt) {
/* 150 */     CTShapeProperties cTShapeProperties = getShapeProperties();
/* 151 */     CTLineProperties cTLineProperties = cTShapeProperties.isSetLn() ? cTShapeProperties.getLn() : cTShapeProperties.addNewLn();
/* 152 */     CTPresetLineDashProperties cTPresetLineDashProperties = CTPresetLineDashProperties.Factory.newInstance();
/* 153 */     cTPresetLineDashProperties.setVal(STPresetLineDashVal.Enum.forInt(paramInt + 1));
/* 154 */     cTLineProperties.setPrstDash(cTPresetLineDashProperties);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */