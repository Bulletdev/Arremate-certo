/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*    */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*    */ import org.apache.poi.sl.usermodel.Shape;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Internal
/*    */ public class XSLFMetroShape
/*    */ {
/*    */   public static Shape<?, ?> parseShape(byte[] paramArrayOfbyte) throws InvalidFormatException, IOException, XmlException {
/* 48 */     PackagePartName packagePartName = PackagingURIHelper.createPartName("/drs/shapexml.xml");
/* 49 */     OPCPackage oPCPackage = null;
/*    */     try {
/* 51 */       oPCPackage = OPCPackage.open(new ByteArrayInputStream(paramArrayOfbyte));
/* 52 */       PackagePart packagePart = oPCPackage.getPart(packagePartName);
/* 53 */       CTGroupShape cTGroupShape = CTGroupShape.Factory.parse(packagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 54 */       XSLFGroupShape xSLFGroupShape = new XSLFGroupShape(cTGroupShape, null);
/* 55 */       return xSLFGroupShape.getShapes().get(0);
/*    */     } finally {
/* 57 */       if (oPCPackage != null)
/* 58 */         oPCPackage.close(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFMetroShape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */