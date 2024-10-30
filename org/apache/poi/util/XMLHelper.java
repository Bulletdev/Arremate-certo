/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import javax.xml.parsers.DocumentBuilderFactory;
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
/*    */ public final class XMLHelper
/*    */ {
/* 28 */   private static POILogger logger = POILogFactory.getLogger(XMLHelper.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DocumentBuilderFactory getDocumentBuilderFactory() {
/* 34 */     DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/* 35 */     documentBuilderFactory.setExpandEntityReferences(false);
/* 36 */     trySetSAXFeature(documentBuilderFactory, "http://javax.xml.XMLConstants/feature/secure-processing", true);
/* 37 */     trySetSAXFeature(documentBuilderFactory, "http://xml.org/sax/features/external-general-entities", false);
/* 38 */     trySetSAXFeature(documentBuilderFactory, "http://xml.org/sax/features/external-parameter-entities", false);
/* 39 */     trySetSAXFeature(documentBuilderFactory, "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
/* 40 */     trySetSAXFeature(documentBuilderFactory, "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
/* 41 */     return documentBuilderFactory;
/*    */   }
/*    */   
/*    */   private static void trySetSAXFeature(DocumentBuilderFactory paramDocumentBuilderFactory, String paramString, boolean paramBoolean) {
/*    */     try {
/* 46 */       paramDocumentBuilderFactory.setFeature(paramString, paramBoolean);
/* 47 */     } catch (Exception exception) {
/* 48 */       logger.log(5, new Object[] { "SAX Feature unsupported", paramString, exception });
/* 49 */     } catch (AbstractMethodError abstractMethodError) {
/* 50 */       logger.log(5, new Object[] { "Cannot set SAX feature because outdated XML parser in classpath", paramString, abstractMethodError });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\XMLHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */