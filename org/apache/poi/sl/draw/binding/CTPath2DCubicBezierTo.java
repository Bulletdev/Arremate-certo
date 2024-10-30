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
/*    */ @XmlType(name = "CT_Path2DCubicBezierTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"pt"})
/*    */ public class CTPath2DCubicBezierTo
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*    */   protected List<CTAdjPoint2D> pt;
/*    */   
/*    */   public List<CTAdjPoint2D> getPt() {
/* 79 */     if (this.pt == null) {
/* 80 */       this.pt = new ArrayList<CTAdjPoint2D>();
/*    */     }
/* 82 */     return this.pt;
/*    */   }
/*    */   
/*    */   public boolean isSetPt() {
/* 86 */     return (this.pt != null && !this.pt.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetPt() {
/* 90 */     this.pt = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPath2DCubicBezierTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */