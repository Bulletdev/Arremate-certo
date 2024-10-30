/*    */ package org.apache.poi.poifs.crypt.dsig.facets;
/*    */ 
/*    */ import javax.xml.crypto.MarshalException;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.b.a.a.a.r;
/*    */ import org.b.a.a.a.x;
/*    */ import org.b.a.a.a.y;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Office2010SignatureFacet
/*    */   extends SignatureFacet
/*    */ {
/*    */   public void postSign(Document paramDocument) throws MarshalException {
/*    */     r r;
/* 54 */     NodeList nodeList = paramDocument.getElementsByTagNameNS("http://uri.etsi.org/01903/v1.3.2#", "QualifyingProperties");
/* 55 */     if (nodeList.getLength() != 1) {
/* 56 */       throw new MarshalException("no XAdES-BES extension present");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 61 */       r = r.a.a(nodeList.item(0), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 62 */     } catch (XmlException xmlException) {
/* 63 */       throw new MarshalException(xmlException);
/*    */     } 
/*    */ 
/*    */     
/* 67 */     x x = r.a();
/* 68 */     if (x == null) {
/* 69 */       x = r.b();
/*    */     }
/* 71 */     y y = x.a();
/* 72 */     if (y == null) {
/* 73 */       x.b();
/*    */     }
/*    */     
/* 76 */     Node node = paramDocument.importNode(r.getDomNode().getFirstChild(), true);
/* 77 */     nodeList.item(0).getParentNode().replaceChild(node, nodeList.item(0));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\Office2010SignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */