/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Insets;
/*     */ import java.net.URI;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.sl.usermodel.PictureData;
/*     */ import org.apache.poi.sl.usermodel.PictureShape;
/*     */ import org.apache.poi.sl.usermodel.Placeholder;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTPictureNonVisual;
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
/*     */ public class XSLFPictureShape
/*     */   extends XSLFSimpleShape
/*     */   implements PictureShape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   private XSLFPictureData _data;
/*     */   
/*     */   XSLFPictureShape(CTPicture paramCTPicture, XSLFSheet paramXSLFSheet) {
/*  58 */     super((XmlObject)paramCTPicture, paramXSLFSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CTPicture prototype(int paramInt, String paramString) {
/*  67 */     CTPicture cTPicture = CTPicture.Factory.newInstance();
/*  68 */     CTPictureNonVisual cTPictureNonVisual = cTPicture.addNewNvPicPr();
/*  69 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTPictureNonVisual.addNewCNvPr();
/*  70 */     cTNonVisualDrawingProps.setName("Picture " + paramInt);
/*  71 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/*  72 */     cTPictureNonVisual.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
/*  73 */     cTPictureNonVisual.addNewNvPr();
/*     */     
/*  75 */     CTBlipFillProperties cTBlipFillProperties = cTPicture.addNewBlipFill();
/*  76 */     CTBlip cTBlip = cTBlipFillProperties.addNewBlip();
/*  77 */     cTBlip.setEmbed(paramString);
/*  78 */     cTBlipFillProperties.addNewStretch().addNewFillRect();
/*     */     
/*  80 */     CTShapeProperties cTShapeProperties = cTPicture.addNewSpPr();
/*  81 */     CTPresetGeometry2D cTPresetGeometry2D = cTShapeProperties.addNewPrstGeom();
/*  82 */     cTPresetGeometry2D.setPrst(STShapeType.RECT);
/*  83 */     cTPresetGeometry2D.addNewAvLst();
/*  84 */     return cTPicture;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExternalLinkedPicture() {
/*  94 */     if (getBlipId() == null && getBlipLink() != null) {
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSLFPictureData getPictureData() {
/* 105 */     if (this._data == null) {
/* 106 */       String str = getBlipId();
/* 107 */       if (str == null) return null;
/*     */       
/* 109 */       PackagePart packagePart = getSheet().getPackagePart();
/* 110 */       PackageRelationship packageRelationship = packagePart.getRelationship(str);
/* 111 */       if (packageRelationship != null) {
/*     */         try {
/* 113 */           PackagePart packagePart1 = packagePart.getRelatedPart(packageRelationship);
/* 114 */           this._data = new XSLFPictureData(packagePart1);
/*     */         }
/* 116 */         catch (Exception exception) {
/* 117 */           throw new POIXMLException(exception);
/*     */         } 
/*     */       }
/*     */     } 
/* 121 */     return this._data;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPlaceholder(Placeholder paramPlaceholder) {
/* 126 */     super.setPlaceholder(paramPlaceholder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getPictureLink() {
/* 136 */     if (getBlipId() != null)
/*     */     {
/* 138 */       return null;
/*     */     }
/*     */     
/* 141 */     String str = getBlipLink();
/* 142 */     if (str == null)
/*     */     {
/* 144 */       return null;
/*     */     }
/*     */     
/* 147 */     PackagePart packagePart = getSheet().getPackagePart();
/* 148 */     PackageRelationship packageRelationship = packagePart.getRelationship(str);
/* 149 */     if (packageRelationship != null) {
/* 150 */       return packageRelationship.getTargetURI();
/*     */     }
/* 152 */     return null;
/*     */   }
/*     */   
/*     */   protected CTBlipFillProperties getBlipFill() {
/* 156 */     CTPicture cTPicture2, cTPicture1 = (CTPicture)getXmlObject();
/* 157 */     CTBlipFillProperties cTBlipFillProperties = cTPicture1.getBlipFill();
/* 158 */     if (cTBlipFillProperties != null) {
/* 159 */       return cTBlipFillProperties;
/*     */     }
/*     */     
/* 162 */     String str = "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/p:blipFill";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     XmlObject xmlObject = (XmlObject)selectProperty((Class)XmlObject.class, str);
/*     */     try {
/* 169 */       cTPicture2 = CTPicture.Factory.parse(xmlObject.getDomNode());
/* 170 */     } catch (XmlException xmlException) {
/* 171 */       return null;
/*     */     } 
/* 173 */     return cTPicture2.getBlipFill();
/*     */   }
/*     */   
/*     */   protected CTBlip getBlip() {
/* 177 */     return getBlipFill().getBlip();
/*     */   }
/*     */   
/*     */   protected String getBlipLink() {
/* 181 */     String str = getBlip().getLink();
/* 182 */     if (str.isEmpty()) return null; 
/* 183 */     return str;
/*     */   }
/*     */   
/*     */   protected String getBlipId() {
/* 187 */     String str = getBlip().getEmbed();
/* 188 */     if (str.isEmpty()) return null; 
/* 189 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public Insets getClipping() {
/* 194 */     CTRelativeRect cTRelativeRect = getBlipFill().getSrcRect();
/* 195 */     return (cTRelativeRect == null) ? null : new Insets(cTRelativeRect.getT(), cTRelativeRect.getL(), cTRelativeRect.getB(), cTRelativeRect.getR());
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(XSLFShape paramXSLFShape) {
/* 200 */     super.copy(paramXSLFShape);
/*     */     
/* 202 */     XSLFPictureShape xSLFPictureShape = (XSLFPictureShape)paramXSLFShape;
/* 203 */     String str1 = xSLFPictureShape.getBlipId();
/* 204 */     String str2 = getSheet().importBlip(str1, xSLFPictureShape.getSheet().getPackagePart());
/*     */     
/* 206 */     CTPicture cTPicture = (CTPicture)getXmlObject();
/* 207 */     CTBlip cTBlip = getBlipFill().getBlip();
/* 208 */     cTBlip.setEmbed(str2);
/*     */     
/* 210 */     CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = cTPicture.getNvPicPr().getNvPr();
/* 211 */     if (cTApplicationNonVisualDrawingProps.isSetCustDataLst())
/*     */     {
/* 213 */       cTApplicationNonVisualDrawingProps.unsetCustDataLst();
/*     */     }
/* 215 */     if (cTBlip.isSetExtLst()) {
/*     */       
/* 217 */       CTOfficeArtExtensionList cTOfficeArtExtensionList = cTBlip.getExtLst();
/* 218 */       for (CTOfficeArtExtension cTOfficeArtExtension : cTOfficeArtExtensionList.getExtArray()) {
/* 219 */         String str = "declare namespace a14='http://schemas.microsoft.com/office/drawing/2010/main' $this//a14:imgProps/a14:imgLayer";
/* 220 */         XmlObject[] arrayOfXmlObject = cTOfficeArtExtension.selectPath(str);
/* 221 */         if (arrayOfXmlObject != null && arrayOfXmlObject.length == 1) {
/* 222 */           XmlCursor xmlCursor = arrayOfXmlObject[0].newCursor();
/* 223 */           String str3 = xmlCursor.getAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed"));
/* 224 */           String str4 = getSheet().importBlip(str3, xSLFPictureShape.getSheet().getPackagePart());
/* 225 */           xmlCursor.setAttributeText(new b("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "embed"), str4);
/* 226 */           xmlCursor.dispose();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFPictureShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */