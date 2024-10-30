/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.Picture;
/*     */ import org.apache.poi.ss.usermodel.PictureData;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.ImageUtils;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPictureNonVisual;
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
/*     */ public final class XSSFPicture
/*     */   extends XSSFShape
/*     */   implements Picture
/*     */ {
/*  49 */   private static final POILogger logger = POILogFactory.getLogger(XSSFPicture.class);
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
/*  63 */   private static CTPicture prototype = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTPicture ctPicture;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFPicture(XSSFDrawing paramXSSFDrawing, CTPicture paramCTPicture) {
/*  77 */     this.drawing = paramXSSFDrawing;
/*  78 */     this.ctPicture = paramCTPicture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static CTPicture prototype() {
/*  87 */     if (prototype == null) {
/*  88 */       CTPicture cTPicture = CTPicture.Factory.newInstance();
/*  89 */       CTPictureNonVisual cTPictureNonVisual = cTPicture.addNewNvPicPr();
/*  90 */       CTNonVisualDrawingProps cTNonVisualDrawingProps = cTPictureNonVisual.addNewCNvPr();
/*  91 */       cTNonVisualDrawingProps.setId(1L);
/*  92 */       cTNonVisualDrawingProps.setName("Picture 1");
/*  93 */       cTNonVisualDrawingProps.setDescr("Picture");
/*  94 */       CTNonVisualPictureProperties cTNonVisualPictureProperties = cTPictureNonVisual.addNewCNvPicPr();
/*  95 */       cTNonVisualPictureProperties.addNewPicLocks().setNoChangeAspect(true);
/*     */       
/*  97 */       CTBlipFillProperties cTBlipFillProperties = cTPicture.addNewBlipFill();
/*  98 */       cTBlipFillProperties.addNewBlip().setEmbed("");
/*  99 */       cTBlipFillProperties.addNewStretch().addNewFillRect();
/*     */       
/* 101 */       CTShapeProperties cTShapeProperties = cTPicture.addNewSpPr();
/* 102 */       CTTransform2D cTTransform2D = cTShapeProperties.addNewXfrm();
/* 103 */       CTPositiveSize2D cTPositiveSize2D = cTTransform2D.addNewExt();
/*     */       
/* 105 */       cTPositiveSize2D.setCx(0L);
/* 106 */       cTPositiveSize2D.setCy(0L);
/*     */       
/* 108 */       CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/* 109 */       cTPoint2D.setX(0L);
/* 110 */       cTPoint2D.setY(0L);
/*     */       
/* 112 */       CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/* 113 */       cTPresetGeometry2D.setPrst(STShapeType.RECT);
/* 114 */       cTPresetGeometry2D.addNewAvLst();
/*     */       
/* 116 */       prototype = cTPicture;
/*     */     } 
/* 118 */     return prototype;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setPictureReference(PackageRelationship paramPackageRelationship) {
/* 127 */     this.ctPicture.getBlipFill().getBlip().setEmbed(paramPackageRelationship.getId());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTPicture getCTPicture() {
/* 137 */     return this.ctPicture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize() {
/* 146 */     resize(Double.MAX_VALUE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resize(double paramDouble) {
/* 155 */     resize(paramDouble, paramDouble);
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
/*     */   public void resize(double paramDouble1, double paramDouble2) {
/* 178 */     XSSFClientAnchor xSSFClientAnchor1 = getClientAnchor();
/*     */     
/* 180 */     XSSFClientAnchor xSSFClientAnchor2 = getPreferredSize(paramDouble1, paramDouble2);
/*     */     
/* 182 */     int i = xSSFClientAnchor1.getRow1() + xSSFClientAnchor2.getRow2() - xSSFClientAnchor2.getRow1();
/* 183 */     int j = xSSFClientAnchor1.getCol1() + xSSFClientAnchor2.getCol2() - xSSFClientAnchor2.getCol1();
/*     */     
/* 185 */     xSSFClientAnchor1.setCol2(j);
/*     */     
/* 187 */     xSSFClientAnchor1.setDx2(xSSFClientAnchor2.getDx2());
/*     */     
/* 189 */     xSSFClientAnchor1.setRow2(i);
/*     */     
/* 191 */     xSSFClientAnchor1.setDy2(xSSFClientAnchor2.getDy2());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor getPreferredSize() {
/* 200 */     return getPreferredSize(1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor getPreferredSize(double paramDouble) {
/* 210 */     return getPreferredSize(paramDouble, paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor getPreferredSize(double paramDouble1, double paramDouble2) {
/* 221 */     Dimension dimension = ImageUtils.setPreferredSize(this, paramDouble1, paramDouble2);
/* 222 */     CTPositiveSize2D cTPositiveSize2D = this.ctPicture.getSpPr().getXfrm().getExt();
/* 223 */     cTPositiveSize2D.setCx((int)dimension.getWidth());
/* 224 */     cTPositiveSize2D.setCy((int)dimension.getHeight());
/* 225 */     return getClientAnchor();
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
/*     */   protected static Dimension getImageDimension(PackagePart paramPackagePart, int paramInt) {
/*     */     try {
/* 239 */       return ImageUtils.getImageDimension(paramPackagePart.getInputStream(), paramInt);
/* 240 */     } catch (IOException iOException) {
/*     */       
/* 242 */       logger.log(5, new Object[] { iOException });
/* 243 */       return new Dimension();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Dimension getImageDimension() {
/* 253 */     XSSFPictureData xSSFPictureData = getPictureData();
/* 254 */     return getImageDimension(xSSFPictureData.getPackagePart(), xSSFPictureData.getPictureType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFPictureData getPictureData() {
/* 263 */     String str = this.ctPicture.getBlipFill().getBlip().getEmbed();
/* 264 */     return (XSSFPictureData)getDrawing().getRelationById(str);
/*     */   }
/*     */   
/*     */   protected CTShapeProperties getShapeProperties() {
/* 268 */     return this.ctPicture.getSpPr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFClientAnchor getClientAnchor() {
/* 276 */     XSSFAnchor xSSFAnchor = getAnchor();
/* 277 */     return (xSSFAnchor instanceof XSSFClientAnchor) ? (XSSFClientAnchor)xSSFAnchor : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFSheet getSheet() {
/* 285 */     return (XSSFSheet)getDrawing().getParent();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */