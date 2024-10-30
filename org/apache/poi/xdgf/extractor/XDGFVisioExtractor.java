/*    */ package org.apache.poi.xdgf.extractor;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.POIXMLDocument;
/*    */ import org.apache.poi.POIXMLTextExtractor;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFPage;
/*    */ import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
/*    */ import org.apache.poi.xdgf.usermodel.shape.ShapeTextVisitor;
/*    */ import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
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
/*    */ public class XDGFVisioExtractor
/*    */   extends POIXMLTextExtractor
/*    */ {
/*    */   protected final XmlVisioDocument document;
/*    */   
/*    */   public XDGFVisioExtractor(XmlVisioDocument paramXmlVisioDocument) {
/* 36 */     super((POIXMLDocument)paramXmlVisioDocument);
/* 37 */     this.document = paramXmlVisioDocument;
/*    */   }
/*    */   
/*    */   public XDGFVisioExtractor(OPCPackage paramOPCPackage) throws IOException {
/* 41 */     this(new XmlVisioDocument(paramOPCPackage));
/*    */   }
/*    */   
/*    */   public String getText() {
/* 45 */     ShapeTextVisitor shapeTextVisitor = new ShapeTextVisitor();
/*    */     
/* 47 */     for (XDGFPage xDGFPage : this.document.getPages()) {
/* 48 */       xDGFPage.getContent().visitShapes((ShapeVisitor)shapeTextVisitor);
/*    */     }
/*    */     
/* 51 */     return shapeTextVisitor.getText().toString();
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 55 */     if (paramArrayOfString.length < 1) {
/* 56 */       System.err.println("Use:");
/* 57 */       System.err.println("  XDGFVisioExtractor <filename.vsdx>");
/* 58 */       System.exit(1);
/*    */     } 
/* 60 */     XDGFVisioExtractor xDGFVisioExtractor = new XDGFVisioExtractor(POIXMLDocument.openPackage(paramArrayOfString[0]));
/*    */ 
/*    */ 
/*    */     
/* 64 */     System.out.println(xDGFVisioExtractor.getText());
/* 65 */     xDGFVisioExtractor.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\extractor\XDGFVisioExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */