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
/*    */ @XmlType(name = "CT_GeomGuideList", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"gd"})
/*    */ public class CTGeomGuideList
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */   protected List<CTGeomGuide> gd;
/*    */   
/*    */   public List<CTGeomGuide> getGd() {
/* 79 */     if (this.gd == null) {
/* 80 */       this.gd = new ArrayList<CTGeomGuide>();
/*    */     }
/* 82 */     return this.gd;
/*    */   }
/*    */   
/*    */   public boolean isSetGd() {
/* 86 */     return (this.gd != null && !this.gd.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetGd() {
/* 90 */     this.gd = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTGeomGuideList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */