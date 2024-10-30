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
/*    */ @XmlType(name = "CT_Path2DList", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"path"})
/*    */ public class CTPath2DList
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */   protected List<CTPath2D> path;
/*    */   
/*    */   public List<CTPath2D> getPath() {
/* 79 */     if (this.path == null) {
/* 80 */       this.path = new ArrayList<CTPath2D>();
/*    */     }
/* 82 */     return this.path;
/*    */   }
/*    */   
/*    */   public boolean isSetPath() {
/* 86 */     return (this.path != null && !this.path.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetPath() {
/* 90 */     this.path = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTPath2DList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */