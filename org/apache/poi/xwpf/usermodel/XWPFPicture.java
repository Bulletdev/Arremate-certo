/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XWPFPicture
/*    */ {
/*    */   private CTPicture ctPic;
/*    */   private String description;
/*    */   private XWPFRun run;
/*    */   
/*    */   public XWPFPicture(CTPicture paramCTPicture, XWPFRun paramXWPFRun) {
/* 35 */     this.run = paramXWPFRun;
/* 36 */     this.ctPic = paramCTPicture;
/* 37 */     this.description = paramCTPicture.getNvPicPr().getCNvPr().getDescr();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPictureReference(PackageRelationship paramPackageRelationship) {
/* 46 */     this.ctPic.getBlipFill().getBlip().setEmbed(paramPackageRelationship.getId());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CTPicture getCTPicture() {
/* 55 */     return this.ctPic;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XWPFPictureData getPictureData() {
/* 63 */     CTBlipFillProperties cTBlipFillProperties = this.ctPic.getBlipFill();
/*    */     
/* 65 */     if (cTBlipFillProperties == null || !cTBlipFillProperties.isSetBlip())
/*    */     {
/* 67 */       return null;
/*    */     }
/*    */     
/* 70 */     String str = cTBlipFillProperties.getBlip().getEmbed();
/* 71 */     POIXMLDocumentPart pOIXMLDocumentPart = this.run.getParent().getPart();
/* 72 */     if (pOIXMLDocumentPart != null) {
/* 73 */       POIXMLDocumentPart pOIXMLDocumentPart1 = pOIXMLDocumentPart.getRelationById(str);
/* 74 */       if (pOIXMLDocumentPart1 instanceof XWPFPictureData) {
/* 75 */         return (XWPFPictureData)pOIXMLDocumentPart1;
/*    */       }
/*    */     } 
/* 78 */     return null;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 82 */     return this.description;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */