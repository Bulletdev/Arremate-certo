/*     */ package org.apache.poi.sl.draw.binding;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlAttribute;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_Transform2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"off", "ext"})
/*     */ public class CTTransform2D
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPoint2D off;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPositiveSize2D ext;
/*     */   @XmlAttribute
/*     */   protected Integer rot;
/*     */   @XmlAttribute
/*     */   protected Boolean flipH;
/*     */   @XmlAttribute
/*     */   protected Boolean flipV;
/*     */   
/*     */   public CTPoint2D getOff() {
/*  77 */     return this.off;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOff(CTPoint2D paramCTPoint2D) {
/*  89 */     this.off = paramCTPoint2D;
/*     */   }
/*     */   
/*     */   public boolean isSetOff() {
/*  93 */     return (this.off != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTPositiveSize2D getExt() {
/* 105 */     return this.ext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExt(CTPositiveSize2D paramCTPositiveSize2D) {
/* 117 */     this.ext = paramCTPositiveSize2D;
/*     */   }
/*     */   
/*     */   public boolean isSetExt() {
/* 121 */     return (this.ext != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRot() {
/* 133 */     if (this.rot == null) {
/* 134 */       return 0;
/*     */     }
/* 136 */     return this.rot.intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRot(int paramInt) {
/* 149 */     this.rot = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetRot() {
/* 153 */     return (this.rot != null);
/*     */   }
/*     */   
/*     */   public void unsetRot() {
/* 157 */     this.rot = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFlipH() {
/* 169 */     if (this.flipH == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     return this.flipH.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlipH(boolean paramBoolean) {
/* 185 */     this.flipH = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetFlipH() {
/* 189 */     return (this.flipH != null);
/*     */   }
/*     */   
/*     */   public void unsetFlipH() {
/* 193 */     this.flipH = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFlipV() {
/* 205 */     if (this.flipV == null) {
/* 206 */       return false;
/*     */     }
/* 208 */     return this.flipV.booleanValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlipV(boolean paramBoolean) {
/* 221 */     this.flipV = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetFlipV() {
/* 225 */     return (this.flipV != null);
/*     */   }
/*     */   
/*     */   public void unsetFlipV() {
/* 229 */     this.flipV = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTTransform2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */