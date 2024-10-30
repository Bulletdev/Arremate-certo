/*    */ package org.apache.poi.util;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.apache.xmlbeans.XmlCursor;
/*    */ import org.apache.xmlbeans.XmlObject;
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
/*    */ public final class XmlSort
/*    */ {
/*    */   public static void sort(XmlObject paramXmlObject, Comparator<XmlCursor> paramComparator) {
/* 38 */     XmlCursor xmlCursor1 = paramXmlObject.newCursor();
/* 39 */     if (!xmlCursor1.isStart()) {
/* 40 */       throw new IllegalStateException("The element parameter must point to a STARTDOC");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 49 */     boolean bool1 = xmlCursor1.toFirstChild();
/* 50 */     if (!bool1) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 55 */     XmlCursor xmlCursor2 = xmlCursor1.newCursor();
/* 56 */     boolean bool2 = xmlCursor2.toNextSibling();
/* 57 */     while (bool2) {
/* 58 */       bool1 = false;
/*    */ 
/*    */       
/* 61 */       while (xmlCursor1.comparePosition(xmlCursor2) < 0) {
/* 62 */         if (paramComparator.compare(xmlCursor1, xmlCursor2) > 0) {
/*    */ 
/*    */ 
/*    */           
/* 66 */           xmlCursor2.moveXml(xmlCursor1);
/*    */           
/* 68 */           while (!xmlCursor2.isStart() && !xmlCursor2.isEnd())
/* 69 */             xmlCursor2.moveXml(xmlCursor1); 
/* 70 */           bool2 = xmlCursor2.isStart();
/* 71 */           bool1 = true;
/*    */           break;
/*    */         } 
/* 74 */         xmlCursor1.toNextSibling();
/*    */       } 
/* 76 */       if (!bool1)
/*    */       {
/*    */ 
/*    */         
/* 80 */         bool2 = xmlCursor2.toNextSibling();
/*    */       }
/*    */       
/* 83 */       xmlCursor1.toParent();
/* 84 */       xmlCursor1.toFirstChild();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\XmlSort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */