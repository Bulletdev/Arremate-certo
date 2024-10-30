/*    */ package org.apache.poi.sl.draw.binding;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "CT_ConnectionSiteList", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"cxn"})
/*    */ public class CTConnectionSiteList
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */   protected List<CTConnectionSite> cxn;
/*    */   
/*    */   public List<CTConnectionSite> getCxn() {
/* 79 */     if (this.cxn == null) {
/* 80 */       this.cxn = new ArrayList<CTConnectionSite>();
/*    */     }
/* 82 */     return this.cxn;
/*    */   }
/*    */   
/*    */   public boolean isSetCxn() {
/* 86 */     return (this.cxn != null && !this.cxn.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetCxn() {
/* 90 */     this.cxn = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTConnectionSiteList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */