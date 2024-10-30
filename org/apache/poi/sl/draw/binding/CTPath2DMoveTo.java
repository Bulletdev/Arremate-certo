/*    */ package org.apache.poi.sl.draw.binding;
/*    */ 
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
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "CT_Path2DMoveTo", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"pt"})
/*    */ public class CTPath2DMoveTo
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", required = true)
/*    */   protected CTAdjPoint2D pt;
/*    */   
/*    */   public CTAdjPoint2D getPt() {
/* 63 */     return this.pt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPt(CTAdjPoint2D paramCTAdjPoint2D) {
/* 75 */     this.pt = paramCTAdjPoint2D;
/*    */   }
/*    */   
/*    */   public boolean isSetPt() {
/* 79 */     return (this.pt != null);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPath2DMoveTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */