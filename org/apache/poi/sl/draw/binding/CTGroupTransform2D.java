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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "CT_GroupTransform2D", namespace = "http://schemas.openxmlformats.org/drawingml/2006/main", propOrder = {"off", "ext", "chOff", "chExt"})
/*     */ public class CTGroupTransform2D
/*     */ {
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPoint2D off;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPositiveSize2D ext;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPoint2D chOff;
/*     */   @XmlElement(namespace = "http://schemas.openxmlformats.org/drawingml/2006/main")
/*     */   protected CTPositiveSize2D chExt;
/*     */   @XmlAttribute
/*     */   protected Integer rot;
/*     */   @XmlAttribute
/*     */   protected Boolean flipH;
/*     */   @XmlAttribute
/*     */   protected Boolean flipV;
/*     */   
/*     */   public CTPoint2D getOff() {
/*  85 */     return this.off;
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
/*  97 */     this.off = paramCTPoint2D;
/*     */   }
/*     */   
/*     */   public boolean isSetOff() {
/* 101 */     return (this.off != null);
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
/* 113 */     return this.ext;
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
/* 125 */     this.ext = paramCTPositiveSize2D;
/*     */   }
/*     */   
/*     */   public boolean isSetExt() {
/* 129 */     return (this.ext != null);
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
/*     */   public CTPoint2D getChOff() {
/* 141 */     return this.chOff;
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
/*     */   public void setChOff(CTPoint2D paramCTPoint2D) {
/* 153 */     this.chOff = paramCTPoint2D;
/*     */   }
/*     */   
/*     */   public boolean isSetChOff() {
/* 157 */     return (this.chOff != null);
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
/*     */   public CTPositiveSize2D getChExt() {
/* 169 */     return this.chExt;
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
/*     */   public void setChExt(CTPositiveSize2D paramCTPositiveSize2D) {
/* 181 */     this.chExt = paramCTPositiveSize2D;
/*     */   }
/*     */   
/*     */   public boolean isSetChExt() {
/* 185 */     return (this.chExt != null);
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
/* 197 */     if (this.rot == null) {
/* 198 */       return 0;
/*     */     }
/* 200 */     return this.rot.intValue();
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
/* 213 */     this.rot = Integer.valueOf(paramInt);
/*     */   }
/*     */   
/*     */   public boolean isSetRot() {
/* 217 */     return (this.rot != null);
/*     */   }
/*     */   
/*     */   public void unsetRot() {
/* 221 */     this.rot = null;
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
/* 233 */     if (this.flipH == null) {
/* 234 */       return false;
/*     */     }
/* 236 */     return this.flipH.booleanValue();
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
/* 249 */     this.flipH = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetFlipH() {
/* 253 */     return (this.flipH != null);
/*     */   }
/*     */   
/*     */   public void unsetFlipH() {
/* 257 */     this.flipH = null;
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
/* 269 */     if (this.flipV == null) {
/* 270 */       return false;
/*     */     }
/* 272 */     return this.flipV.booleanValue();
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
/* 285 */     this.flipV = Boolean.valueOf(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isSetFlipV() {
/* 289 */     return (this.flipV != null);
/*     */   }
/*     */   
/*     */   public void unsetFlipV() {
/* 293 */     this.flipV = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\sl\draw\binding\CTGroupTransform2D.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */