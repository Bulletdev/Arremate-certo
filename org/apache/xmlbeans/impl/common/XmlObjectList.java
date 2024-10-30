/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
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
/*     */ public class XmlObjectList
/*     */ {
/*     */   private final XmlObject[] _objects;
/*     */   
/*     */   public XmlObjectList(int paramInt) {
/*  33 */     this._objects = new XmlObject[paramInt];
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
/*     */   public boolean set(XmlObject paramXmlObject, int paramInt) {
/*  45 */     if (this._objects[paramInt] != null) {
/*  46 */       return false;
/*     */     }
/*  48 */     this._objects[paramInt] = paramXmlObject;
/*  49 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean filled() {
/*  56 */     for (byte b = 0; b < this._objects.length; b++) {
/*  57 */       if (this._objects[b] == null) return false; 
/*     */     } 
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int unfilled() {
/*  67 */     for (byte b = 0; b < this._objects.length; b++) {
/*  68 */       if (this._objects[b] == null) return b; 
/*     */     } 
/*  70 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  74 */     if (!(paramObject instanceof XmlObjectList)) {
/*  75 */       return false;
/*     */     }
/*  77 */     XmlObjectList xmlObjectList = (XmlObjectList)paramObject;
/*     */     
/*  79 */     if (xmlObjectList._objects.length != this._objects.length) {
/*  80 */       return false;
/*     */     }
/*  82 */     for (byte b = 0; b < this._objects.length; b++) {
/*     */       
/*  84 */       if (this._objects[b] == null || xmlObjectList._objects[b] == null) {
/*  85 */         return false;
/*     */       }
/*  87 */       if (!this._objects[b].valueEquals(xmlObjectList._objects[b])) {
/*  88 */         return false;
/*     */       }
/*     */     } 
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     int i = 0;
/*     */     
/*  98 */     for (byte b = 0; b < this._objects.length; b++) {
/*  99 */       if (this._objects[b] != null)
/* 100 */         i = 31 * i + this._objects[b].valueHashCode(); 
/*     */     } 
/* 102 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String prettytrim(String paramString) {
/*     */     int i;
/* 108 */     for (i = paramString.length(); i > 0; i--) {
/*     */       
/* 110 */       if (!XMLChar.isSpace(paramString.charAt(i - 1)))
/*     */         break; 
/*     */     } 
/*     */     byte b;
/* 114 */     for (b = 0; b < i; b++) {
/*     */       
/* 116 */       if (!XMLChar.isSpace(paramString.charAt(b)))
/*     */         break; 
/*     */     } 
/* 119 */     return paramString.substring(b, i);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 125 */     for (byte b = 0; b < this._objects.length; b++) {
/*     */       
/* 127 */       if (b != 0) stringBuffer.append(" "); 
/* 128 */       stringBuffer.append(prettytrim(((SimpleValue)this._objects[b]).getStringValue()));
/*     */     } 
/*     */     
/* 131 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlObjectList.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */