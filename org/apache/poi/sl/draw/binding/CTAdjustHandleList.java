/*    */ package org.apache.poi.sl.draw.binding;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlElements;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name = "CT_AdjustHandleList", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"ahXYOrAhPolar"})
/*    */ public class CTAdjustHandleList
/*    */ {
/*    */   @XmlElements({@XmlElement(name = "ahXY", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTXYAdjustHandle.class), @XmlElement(name = "ahPolar", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", type = CTPolarAdjustHandle.class)})
/*    */   protected List<Object> ahXYOrAhPolar;
/*    */   
/*    */   public List<Object> getAhXYOrAhPolar() {
/* 85 */     if (this.ahXYOrAhPolar == null) {
/* 86 */       this.ahXYOrAhPolar = new ArrayList();
/*    */     }
/* 88 */     return this.ahXYOrAhPolar;
/*    */   }
/*    */   
/*    */   public boolean isSetAhXYOrAhPolar() {
/* 92 */     return (this.ahXYOrAhPolar != null && !this.ahXYOrAhPolar.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetAhXYOrAhPolar() {
/* 96 */     this.ahXYOrAhPolar = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTAdjustHandleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */