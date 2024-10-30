/*    */ package org.apache.poi.poifs.crypt.dsig.facets;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.crypto.dsig.Reference;
/*    */ import javax.xml.crypto.dsig.Transform;
/*    */ import javax.xml.crypto.dsig.XMLObject;
/*    */ import javax.xml.crypto.dsig.XMLSignatureException;
/*    */ import org.w3c.dom.Document;
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
/*    */ public class EnvelopedSignatureFacet
/*    */   extends SignatureFacet
/*    */ {
/*    */   public void preSign(Document paramDocument, List<Reference> paramList, List<XMLObject> paramList1) throws XMLSignatureException {
/* 51 */     ArrayList<Transform> arrayList = new ArrayList();
/* 52 */     Transform transform1 = newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
/* 53 */     arrayList.add(transform1);
/* 54 */     Transform transform2 = newTransform("http://www.w3.org/2001/10/xml-exc-c14n#");
/* 55 */     arrayList.add(transform2);
/*    */     
/* 57 */     Reference reference = newReference("", arrayList, null, null, null);
/* 58 */     paramList.add(reference);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\facets\EnvelopedSignatureFacet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */