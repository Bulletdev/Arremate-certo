/*     */ package org.apache.xmlbeans.impl.validator;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*     */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
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
/*     */ public class ValidatorUtil
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static class EventImpl
/*     */     implements ValidatorListener.Event
/*     */   {
/*     */     PrefixResolver _prefixResolver;
/*     */     String _text;
/*     */     
/*     */     EventImpl(PrefixResolver param1PrefixResolver, String param1String) {
/*  40 */       this._prefixResolver = param1PrefixResolver;
/*  41 */       this._text = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlCursor getLocationAsCursor() {
/*  47 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Location getLocation() {
/*  52 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiType() {
/*  58 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getXsiNil() {
/*  64 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getXsiLoc() {
/*  69 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getXsiNoLoc() {
/*  74 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public b getName() {
/*  80 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getText() {
/*  86 */       return this._text;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getText(int param1Int) {
/*  91 */       return XmlWhitespace.collapse(this._text, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean textIsWhitespace() {
/*  96 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getNamespaceForPrefix(String param1String) {
/* 101 */       return this._prefixResolver.getNamespaceForPrefix(param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean validateSimpleType(SchemaType paramSchemaType, String paramString, Collection paramCollection, PrefixResolver paramPrefixResolver) {
/* 108 */     if (!paramSchemaType.isSimpleType() && paramSchemaType.getContentType() != 2) {
/*     */       assert false;
/*     */       
/* 111 */       throw new RuntimeException("Not a simple type");
/*     */     } 
/*     */     
/* 114 */     Validator validator = new Validator(paramSchemaType, null, (SchemaTypeLoader)paramSchemaType.getTypeSystem(), null, paramCollection);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     EventImpl eventImpl = new EventImpl(paramPrefixResolver, paramString);
/*     */     
/* 121 */     validator.nextEvent(1, eventImpl);
/*     */     
/* 123 */     validator.nextEvent(3, eventImpl);
/*     */     
/* 125 */     validator.nextEvent(2, eventImpl);
/*     */     
/* 127 */     return validator.isValid();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\validator\ValidatorUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */