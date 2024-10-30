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
/*    */ @XmlType(name = "CT_OfficeArtExtensionList", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"ext"})
/*    */ public class CTOfficeArtExtensionList
/*    */ {
/*    */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*    */   protected List<CTOfficeArtExtension> ext;
/*    */   
/*    */   public List<CTOfficeArtExtension> getExt() {
/* 79 */     if (this.ext == null) {
/* 80 */       this.ext = new ArrayList<CTOfficeArtExtension>();
/*    */     }
/* 82 */     return this.ext;
/*    */   }
/*    */   
/*    */   public boolean isSetExt() {
/* 86 */     return (this.ext != null && !this.ext.isEmpty());
/*    */   }
/*    */   
/*    */   public void unsetExt() {
/* 90 */     this.ext = null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTOfficeArtExtensionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */