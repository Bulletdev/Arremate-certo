/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import org.apache.xmlbeans.xml.stream.XMLEvent;
/*     */ import org.apache.xmlbeans.xml.stream.events.ElementTypeNames;
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
/*     */ public abstract class XmlEventBase
/*     */   implements XMLEvent
/*     */ {
/*     */   private int _type;
/*     */   
/*     */   public XmlEventBase() {}
/*     */   
/*     */   public XmlEventBase(int paramInt) {
/*  33 */     this._type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setType(int paramInt) {
/*  38 */     this._type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  43 */     return this._type;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTypeAsString() {
/*  48 */     return ElementTypeNames.getName(this._type);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStartElement() {
/*  53 */     return (this._type == 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEndElement() {
/*  58 */     return (this._type == 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEntityReference() {
/*  63 */     return (this._type == 8192);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStartPrefixMapping() {
/*  68 */     return (this._type == 1024);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEndPrefixMapping() {
/*  73 */     return (this._type == 2048);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChangePrefixMapping() {
/*  78 */     return (this._type == 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isProcessingInstruction() {
/*  83 */     return (this._type == 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCharacterData() {
/*  88 */     return (this._type == 16);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSpace() {
/*  93 */     return (this._type == 64);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNull() {
/*  98 */     return (this._type == 128);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStartDocument() {
/* 103 */     return (this._type == 256);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEndDocument() {
/* 108 */     return (this._type == 512);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XmlEventBase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */